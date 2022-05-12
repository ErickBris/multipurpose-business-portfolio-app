package com.csform.businessportfolio.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.csform.businessportfolio.ImagesActivity;
import com.csform.businessportfolio.R;
import com.csform.businessportfolio.adapter.CategoriesGridAdapter;
import com.csform.businessportfolio.model.Category;

public class PortfolioFragment extends Fragment implements OnItemClickListener {

	public static final String PARCELABLE_CATEGORY_NAME = "category_name";
	public static final String PARCELABLE_CATEGORIES = "categories";
	public static final String PARCELABLE_GALLERY_IMAGES = "gallery_images";

	private ArrayList<Category> categories;
	private GridView mGrid;

	public static PortfolioFragment newInstance(ArrayList<Category> categories) {
		PortfolioFragment portfolioFragment = new PortfolioFragment();
		Bundle args = new Bundle(1);
		args.putParcelableArrayList(PARCELABLE_CATEGORIES, categories);
		portfolioFragment.setArguments(args);
		return portfolioFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.grid, container, false);
		categories = getArguments().getParcelableArrayList(
				PARCELABLE_CATEGORIES);

		mGrid = (GridView) rootView.findViewById(R.id.grid_view);
		mGrid.setNumColumns(1);
		mGrid.setOnItemClickListener(this);
		mGrid.setAdapter(new CategoriesGridAdapter(getActivity(), categories));

		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		Intent intent = new Intent(getActivity(), ImagesActivity.class);
		intent.putParcelableArrayListExtra(PARCELABLE_GALLERY_IMAGES,
				categories.get(position).getGalleryImages());
		intent.putExtra(PARCELABLE_CATEGORY_NAME, categories.get(position).getName());
		startActivity(intent);
	}
}
