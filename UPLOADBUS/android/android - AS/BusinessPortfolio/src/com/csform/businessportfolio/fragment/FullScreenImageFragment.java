package com.csform.businessportfolio.fragment;

import uk.co.senab.photoview.PhotoViewAttacher;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.csform.businessportfolio.R;
import com.csform.businessportfolio.Utils;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class FullScreenImageFragment extends Fragment {

	private static final String PARCELABLE_ID = "id";
	private static final String PARCELABLE_IMAGE = "image";
	
	private String id;
	private String image;
	
	private ImageView imageView;
	private PhotoViewAttacher attacher;
	
	public static FullScreenImageFragment newInstance(String id, String image) {
		FullScreenImageFragment fullScreenImageFragment = new FullScreenImageFragment();
		Bundle args = new Bundle(2);
		args.putString(PARCELABLE_ID, id);
		args.putString(PARCELABLE_IMAGE, image);
		fullScreenImageFragment.setArguments(args);
		return fullScreenImageFragment;
	}
	
	private SimpleImageLoadingListener imageLoadingListener = new SimpleImageLoadingListener() {

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			attacher.update();
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		id = getArguments().getString(PARCELABLE_ID);
		image = getArguments().getString(PARCELABLE_IMAGE);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.image_view, null);
		imageView = (ImageView) root.findViewById(R.id.image);
		attacher = new PhotoViewAttacher(imageView);
		//Log.v("id: " + id, "image: " + image);
		Utils.setImageWithImageLoader(imageView, getActivity(), id, image, imageLoadingListener);
		return root;
	}
}
