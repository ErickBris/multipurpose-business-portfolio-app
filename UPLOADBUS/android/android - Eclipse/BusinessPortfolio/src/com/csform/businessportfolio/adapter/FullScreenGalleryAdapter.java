package com.csform.businessportfolio.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Used for PhotoPager
 * 
 * @author itcsform
 * 
 */
public class FullScreenGalleryAdapter extends FragmentPagerAdapter {
	
	private List<Fragment> mFragments;

	public FullScreenGalleryAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.mFragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	/*private Context context;
	private LayoutInflater inflater;
	private ArrayList<GalleryImages> images;
	DisplayImageOptions options;
	ImageLoader imageLoader;
	String category_path;

	public FullScreenGalleryAdapter(Context context,
			ArrayList<GalleryImages> images) {
		this.context = context;
		this.images = images;
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).memoryCacheExtraOptions(480, 800)
				// default = device screen dimensions
				.threadPoolSize(5)
				// default
				.threadPriority(Thread.NORM_PRIORITY - 1)
				// default
				.denyCacheImageMultipleSizesInMemory()
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
				.build();
		imageLoader = ImageLoader.getInstance();
		imageLoader.init(config);

		inflater = (LayoutInflater) this.context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader.resume();

	}

	@Override
	public int getCount() {
		if (images != null)
			return images.size();
		return 0;
	}

	*//**
	 * Shows image in pager item
	 *//*
	@Override
	public View instantiateItem(View view, int position) {
		final View imageLayout = inflater.inflate(R.layout.full_screen_gallery_single_item, null);
		final ImageView imageView = (ImageView) imageLayout
				.findViewById(R.id.image);
		final ProgressBar bar = (ProgressBar) imageLayout
				.findViewById(R.id.imageProgressBar);
		final PhotoViewAttacher attacher = new PhotoViewAttacher(imageView);

		imageLoader.displayImage(
				SyncDataHelper.URL_UPLOADS + images.get(position).getId() + images.get(position).getImage(),
				imageView, options, new SimpleImageLoadingListener() {

					@Override
					public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
						bar.setVisibility(View.GONE);

						attacher.update();
					}
				});

		((ViewPager) view).addView(imageLayout, 0);

		return imageLayout;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}
*/
}