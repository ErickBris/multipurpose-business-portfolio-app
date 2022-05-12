package com.csform.businessportfolio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.csform.businessportfolio.adapter.FullScreenGalleryAdapter;
import com.csform.businessportfolio.fragment.FullScreenImageFragment;
import com.csform.businessportfolio.model.GalleryImages;
import com.csform.businessportfolio.syncdata.DialogUtils;
import com.csform.businessportfolio.syncdata.SyncDataHelper;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * FullScreen gallery Swipe images
 * 
 * @author itcsform
 * 
 */
public class FullScreenGalleryActivity extends BaseActivity {

	private ArrayList<GalleryImages> images;
	private ViewPager mPhotoPager;
	private TextView imageText;
	private ImageView setWallPaper;
	private ImageView downloadImage;
	private ImageView shareImage;
	private int currentImageIndex;
	private DialogUtils dialog;

	private OnClickListener imageClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			int id = arg0.getId();
			if (id == R.id.wallpaper) {
				dialog.showDialog("wallpaper");
			} else if (id == R.id.save) {
				dialog.showDialog("save");
			} else if (id == R.id.share) {
				dialog.showDialog("share");
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.full_screen_gallery);
		images = getIntent().getParcelableArrayListExtra("images");
		mPhotoPager = (ViewPager) findViewById(R.id.photo_pager);
		imageText = (TextView) findViewById(R.id.image_text);
		setWallPaper = (ImageView) findViewById(R.id.wallpaper);
		downloadImage = (ImageView) findViewById(R.id.save);
		shareImage = (ImageView) findViewById(R.id.share);

		int index = getIntent().getExtras().getInt("position");
		currentImageIndex = index;
		
		mPhotoPager.setAdapter(new FullScreenGalleryAdapter(getSupportFragmentManager(), getImageFragments()));
		mPhotoPager.setCurrentItem(index);

		mPhotoPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				currentImageIndex = position;
				if(images.get(currentImageIndex).getDescription() == null || images.get(currentImageIndex).getDescription().equals("")) {
					imageText.setVisibility(View.GONE);
				}else {
					imageText.setText(images.get(currentImageIndex).getDescription());
					imageText.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			mPhotoPager.setPageTransformer(true, new DepthPageTransformer());
		}

		setWallPaper.setOnClickListener(imageClick);
		downloadImage.setOnClickListener(imageClick);
		shareImage.setOnClickListener(imageClick);
		if(images.get(currentImageIndex).getDescription() == null || images.get(currentImageIndex).getDescription().equals("")) {
			imageText.setVisibility(View.GONE);
		} else {
			imageText.setText(images.get(currentImageIndex).getDescription());
			imageText.setVisibility(View.VISIBLE);
		}

		dialog = new DialogUtils(this);
	}
	
	private List<Fragment> getImageFragments() {
		List<Fragment> fragments = new ArrayList<Fragment>();
		for (GalleryImages gi : images) {
			fragments.add(FullScreenImageFragment.newInstance(gi.getId(), gi.getImage()));
		}
		return fragments;
	}

	@Override
	public void onStart() {
		super.onStart();
		EasyTracker.getInstance(this).activityStart(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		EasyTracker.getInstance(this).activityStop(this);
	}

	/**
	 * Set wallpaper on device
	 * 
	 * @param bitmap
	 */
	private void setPhoneWallpaper(Bitmap bitmap) {
		WallpaperManager myWallpaperManager = WallpaperManager
				.getInstance(getApplicationContext());

		try {
			myWallpaperManager.setBitmap(bitmap);

			Toast.makeText(this, getString(R.string.wallpaper_set),
					Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(this, getString(R.string.wallpaper_error),
					Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * Save image on SDcard
	 * 
	 * @param bitmap
	 */
	private Uri saveSDCard(Bitmap bitmap) {
		File folder = new File(Environment.getExternalStorageDirectory()
				+ "/com.csform.businessportfolio");
		try {
			if (!folder.exists()) {
				folder.mkdir();
			}

			OutputStream fOut = null;
			File file = new File(folder, "image_"
					+ String.valueOf(mPhotoPager.getCurrentItem()) + ".jpg");
			fOut = new FileOutputStream(file);
			bitmap.compress(CompressFormat.JPEG, 100, fOut);

			fOut.flush();
			fOut.close();

			if (Build.VERSION.SDK_INT == 7) {
				this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri
						.parse("file://"
								+ Environment.getExternalStorageDirectory())));
			} else {
				MediaScannerConnection.scanFile(getApplicationContext(),
						new String[] { file.toString() }, null,
						new MediaScannerConnection.OnScanCompletedListener() {
							public void onScanCompleted(String path, Uri uri) {
							}
						});
			}
			Toast.makeText(FullScreenGalleryActivity.this,
					getString(R.string.image_saved), Toast.LENGTH_SHORT).show();

		} catch (Exception ex) {
			ex.printStackTrace();
			Toast.makeText(FullScreenGalleryActivity.this,
					getString(R.string.error_occured), Toast.LENGTH_SHORT)
					.show();
			return null;
		}
		return Uri.fromFile(new File(folder, "image_"
				+ String.valueOf(mPhotoPager.getCurrentItem()) + ".jpg"));
	}

	/**
	 * Share image over intet
	 * 
	 */
	private void share(Uri uriToShare) {
		if (images.get(currentImageIndex) != null) {
			Intent share = new Intent(Intent.ACTION_SEND);
			share.setType("text/plain");
			share.putExtra(Intent.EXTRA_SUBJECT, images.get(currentImageIndex)
					.getDescription());
			share.putExtra(Intent.EXTRA_STREAM, uriToShare);
			startActivity(Intent
					.createChooser(share, getString(R.string.share)));
		}
	}

	/**
	 * Get bitmap from url
	 * 
	 * @author itcsform
	 * 
	 */
	private class GetBitmap extends AsyncTask<Void, Void, Bitmap> {
		Dialog progressDialog;

		private int type;
		private String path;

		public GetBitmap(int type) {

			this.type = type;
			if (images.get(currentImageIndex) != null) {
				if(images.get(currentImageIndex).getId() != null) {
					this.path = SyncDataHelper.URL_UPLOADS
							+ images.get(currentImageIndex).getId()
							+ images.get(currentImageIndex).getImage();
				} else {
					this.path = images.get(currentImageIndex).getImage();
				}
			}
			progressDialog = ProgressDialog.show(
					FullScreenGalleryActivity.this, "",
					getString(R.string.please_wait));

			progressDialog.show();

		}

		@Override
		protected Bitmap doInBackground(Void... arg0) {
			try {
				if (path != null) {
					if (path.startsWith("http://")) {
						URL url = new URL(path);
						HttpURLConnection connection = (HttpURLConnection) url
								.openConnection();
						connection.setDoInput(true);
						connection.connect();

						InputStream input = connection.getInputStream();

						Bitmap tmp = BitmapFactory.decodeStream(input);
						connection.disconnect();
						input.close();
						return tmp;
					} else if (path.startsWith("assets://")) {
						InputStream input = new BufferedInputStream(getAssets()
								.open(path.replace("assets://", "")));

						Bitmap tmp = BitmapFactory.decodeStream(input);
						input.close();
						return tmp;
					}
				}
			} catch (Exception e) {

				e.printStackTrace();
			} catch (OutOfMemoryError er) {
				er.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Bitmap bitmap) {

			if (bitmap != null) {
				if (type == 0)
					setPhoneWallpaper(bitmap);
				else {
					Uri uriToShare = saveSDCard(bitmap);
					if (type == 2) {
						share(uriToShare);
					}
				}
			} else
				Toast.makeText(FullScreenGalleryActivity.this,
						getString(R.string.error_occured), Toast.LENGTH_SHORT)
						.show();
			progressDialog.dismiss();
		}
	}

	public void setGetBit(int i) {
		new GetBitmap(i).execute();
	}
	
	
	@SuppressLint("NewApi")
	public class DepthPageTransformer implements ViewPager.PageTransformer {
		private static final float MIN_SCALE = 0.25f;

		public void transformPage(View view, float position) {
			int pageWidth = view.getWidth();

			if (position < -1) { // [-Infinity,-1)
				// This page is way off-screen to the left.
				view.setAlpha(0);

			} else if (position <= 0) { // [-1,0]
				// Use the default slide transition when moving to the left page
				view.setAlpha(1);
				view.setTranslationX(0);
				view.setScaleX(1);
				view.setScaleY(1);

			} else if (position <= 1) { // (0,1]
				// Fade the page out.
				view.setAlpha(1 - position);

				// Counteract the default slide transition
				view.setTranslationX(pageWidth * -position);

				// Scale the page down (between MIN_SCALE and 1)
				float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
						* (1 - Math.abs(position));
				view.setScaleX(scaleFactor);
				view.setScaleY(scaleFactor);

			} else { // (1,+Infinity]
				// This page is way off-screen to the right.
				view.setAlpha(0);
			}
		}
	}
}
