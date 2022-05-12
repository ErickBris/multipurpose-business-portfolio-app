package com.csform.businessportfolio.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.csform.businessportfolio.R;
import com.csform.businessportfolio.Utils;
import com.csform.businessportfolio.model.GalleryImages;

public class GalleryImagesGridAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<GalleryImages> mGalleryImages;

	public GalleryImagesGridAdapter(Context context,
			ArrayList<GalleryImages> galleryImages) {
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
		mGalleryImages = galleryImages;
	}

	@Override
	public int getCount() {
		return mGalleryImages.size();
	}

	@Override
	public Object getItem(int position) {
		return mGalleryImages.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.gallery_images_grid_item,
					parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		GalleryImages galleryImages = mGalleryImages.get(position);

		Utils.setImageWithImageLoader(holder.image, mContext, galleryImages.getId(), galleryImages.getImage(), null);

		return convertView;
	}

	public static class ViewHolder {
		private ImageView image;
	}
}
