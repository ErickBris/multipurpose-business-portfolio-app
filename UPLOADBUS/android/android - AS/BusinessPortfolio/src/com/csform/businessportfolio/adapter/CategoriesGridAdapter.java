package com.csform.businessportfolio.adapter;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.businessportfolio.BaseActivity;
import com.csform.businessportfolio.R;
import com.csform.businessportfolio.Utils;
import com.csform.businessportfolio.model.Category;

public class CategoriesGridAdapter extends BaseAdapter {
	
	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<Category> mCategories;

	public CategoriesGridAdapter(Context context, ArrayList<Category> categories) {
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
		mCategories = categories;
	}

	@Override
	public int getCount() {
		return mCategories.size();
	}

	@Override
	public Object getItem(int position) {
		return mCategories.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.category_grid_item, parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			holder.text = (TextView) convertView.findViewById(R.id.text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		Category category = mCategories.get(position);
		
		Utils.setImageWithImageLoader(holder.image, mContext, category.getId(), category.getImage(), null);
		
		holder.text.setText(category.getName().toUpperCase(Locale.getDefault()));
		holder.text.setTypeface(BaseActivity.sRobotoBlack);
		
		return convertView;
	}

	public static class ViewHolder {
		private ImageView image;
		private TextView text;
	}
}
