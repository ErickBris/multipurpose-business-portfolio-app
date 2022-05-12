package com.csform.businessportfolio.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csform.businessportfolio.BaseActivity;
import com.csform.businessportfolio.R;

public class AboutUsFragment extends Fragment {
	
	public static AboutUsFragment newInstance() {
		AboutUsFragment aboutUsFragment = new AboutUsFragment();
		return aboutUsFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View aboutUsView = inflater.inflate(R.layout.about_us, container, false);

		TextView companyName = (TextView) aboutUsView.findViewById(R.id.about_us_company_name);
		TextView subtitle = (TextView) aboutUsView.findViewById(R.id.about_us_subtitle);
		TextView moto = (TextView) aboutUsView.findViewById(R.id.about_us_moto);
		TextView description = (TextView) aboutUsView.findViewById(R.id.about_us_description);
		
		companyName.setTypeface(BaseActivity.sRobotoThin);
		subtitle.setTypeface(BaseActivity.sRobotoBlack);
		moto.setTypeface(BaseActivity.sRobotoThin);
		description.setTypeface(BaseActivity.sRobotoThin);
		
		return aboutUsView;
	}
}
