package com.csform.businessportfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csform.businessportfolio.fragment.ClientsFragment;
import com.csform.businessportfolio.model.Client;

public class ClientsActivity extends BaseActivity implements OnClickListener {

	private Client mClient;

	private ImageView mImage;
	private TextView mName;
	private TextView mDescription;
	private TextView mWebLabel;
	private TextView mWeb;
	private LinearLayout mWebLayout;
	private TextView mWebButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clients_activity);
		mClient = getIntent().getParcelableExtra(ClientsFragment.PARCELABLE_CLIENTS);

		mImage = (ImageView) findViewById(R.id.clients_activity_image);
		mName = (TextView) findViewById(R.id.clients_activity_name);
		mDescription = (TextView) findViewById(R.id.clients_activity_description);
		mWebLabel = (TextView) findViewById(R.id.clients_activity_web_site_label);
		mWeb = (TextView) findViewById(R.id.clients_activity_web_site);
		mWebLayout = (LinearLayout) findViewById(R.id.clients_activity_web_layout);
		mWebButton = (TextView) findViewById(R.id.clients_activity_web_button);

		Utils.setImageWithImageLoader(mImage, this, mClient.getId(), mClient.getImage(), null);

		mName.setText(mClient.getName());
		if (mClient.getDescription() == null || mClient.getDescription().equals("")) {
			mDescription.setText(mClient.getDescription());
			mDescription.setVisibility(View.GONE);
		} else {
			mDescription.setText(mClient.getDescription());
		}
		if (mClient.getWebsite() == null || mClient.getWebsite().equals("")) {
			mWeb.setText(mClient.getWebsite());
			mWeb.setVisibility(View.GONE);
			mWebLabel.setVisibility(View.GONE);
			mWebLayout.setVisibility(View.GONE);
			mWebButton.setVisibility(View.GONE);
		} else {
			mWeb.setText(mClient.getWebsite());
		}

		mName.setTypeface(sRobotoThin);
		mDescription.setTypeface(sRobotoThin);
		mWebLabel.setTypeface(sRobotoBlack);
		mWeb.setTypeface(sRobotoThin);
		mWeb.setOnClickListener(this);
		mWebButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (mClient.getWebsite() != null) {
			visitWebsite(mClient.getWebsite());
		} else {
			makeToast(R.string.website_not_available);
		}
	}

	private void visitWebsite(String website) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://" + website));
		startActivity(intent);
	}
}
