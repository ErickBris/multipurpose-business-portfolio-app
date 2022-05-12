package com.csform.businessportfolio;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.csform.businessportfolio.adapter.GalleryImagesGridAdapter;
import com.csform.businessportfolio.fragment.PortfolioFragment;
import com.csform.businessportfolio.model.GalleryImages;

public class ImagesActivity extends BaseActivity implements OnItemClickListener {
	private GridView mGrid;
	private ArrayList<GalleryImages> galleryImages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);

		galleryImages = getIntent().getParcelableArrayListExtra(PortfolioFragment.PARCELABLE_GALLERY_IMAGES);
		mGrid = (GridView) findViewById(R.id.grid_view);
		mGrid.setOnItemClickListener(this);
		mGrid.setAdapter(new GalleryImagesGridAdapter(ImagesActivity.this, galleryImages));
		
		setTitle(getIntent().getExtras().getString(PortfolioFragment.PARCELABLE_CATEGORY_NAME));
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent(this, FullScreenGalleryActivity.class);
		intent.putParcelableArrayListExtra("images", galleryImages);
		intent.putExtra("position", position);
		startActivity(intent);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mGrid.setNumColumns(getResources().getInteger(R.integer.grid_view_number_of_columns));
	}
}
