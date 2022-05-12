package com.csform.businessportfolio.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csform.businessportfolio.BaseActivity;
import com.csform.businessportfolio.MapActivity;
import com.csform.businessportfolio.R;

public class ContactFragment extends Fragment implements OnClickListener {
	
	//TODO Change here your contact information
	private String address = "I. F. Jukića 11, Banja Luka, Bosnia and Herzegovina";
	private String officePhone = "+387 65 172 455";
	private String mobilePhone = "+387 65 864 314";
	private String faxPhone = null;
	private String email = "dev@csform.com";
	private String web = "www.csform.com";
	private String facebook = "csform";
	private String twitter = "CSForm";
	
	public static ContactFragment newInstance() {
		ContactFragment contactFragment = new ContactFragment();
		return contactFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.contact, container, false);
		
		//Find every TextView so you can change fonts and data
		TextView companyName = (TextView) root.findViewById(R.id.contact_company_name);
		TextView companyMoto = (TextView) root.findViewById(R.id.contact_company_moto);
		TextView addressTitleView = (TextView) root.findViewById(R.id.contact_template_address_title);
		TextView addressView = (TextView) root.findViewById(R.id.contact_template_address);
		TextView phoneNumbersTitleView = (TextView) root.findViewById(R.id.contact_template_phone_numbers_title);
		TextView telView = (TextView) root.findViewById(R.id.contact_template_tel);
		TextView telCallView = (TextView) root.findViewById(R.id.contact_template_tel_call);
		TextView mobView = (TextView) root.findViewById(R.id.contact_template_mob);
		TextView mobCallView = (TextView) root.findViewById(R.id.contact_template_mob_call);
		TextView faxTitleView = (TextView) root.findViewById(R.id.contact_template_fax_title);
		TextView faxView = (TextView) root.findViewById(R.id.contact_template_fax);
		TextView faxCallView = (TextView) root.findViewById(R.id.contact_template_fax_call);
		TextView emailTitleView = (TextView) root.findViewById(R.id.contact_template_email_title);
		TextView emailView = (TextView) root.findViewById(R.id.contact_template_email);
		TextView emailSendView = (TextView) root.findViewById(R.id.contact_template_email_send);
		TextView webTitleView = (TextView) root.findViewById(R.id.contact_template_web_title);
		TextView websiteView = (TextView) root.findViewById(R.id.contact_template_web);
		TextView websiteVisitView = (TextView) root.findViewById(R.id.contact_template_web_visit);
		TextView facebookView = (TextView) root.findViewById(R.id.contact_template_facebook);
		TextView facebookVisitView = (TextView) root.findViewById(R.id.contact_template_facebook_visit);
		TextView twitterView = (TextView) root.findViewById(R.id.contact_template_twiter);
		TextView twitterVisitView = (TextView) root.findViewById(R.id.contact_template_twiter_visit);
		TextView openMapView = (TextView) root.findViewById(R.id.contact_open_map);
		
		if (!TextUtils.isEmpty(address)) {
			addressView.setText(address);
		} else {
			addressView.setText(R.string.no_data_available);
		}
		if (!TextUtils.isEmpty(officePhone)) {
			telView.setText(officePhone);
		} else {
			telView.setText(R.string.no_data_available);
		}
		if (!TextUtils.isEmpty(mobilePhone)) {
			mobView.setText(mobilePhone);
		} else {
			mobView.setText(R.string.no_data_available);
		}
		if (!TextUtils.isEmpty(faxPhone)) {
			faxView.setText(faxPhone);
		} else {
			faxView.setText(R.string.no_data_available);
		}
		if (!TextUtils.isEmpty(email)) {
			emailView.setText(email);
		} else {
			emailView.setText(R.string.no_data_available);
		}
		if (!TextUtils.isEmpty(web)) {
			websiteView.setText(web);
		} else {
			websiteView.setText(R.string.no_data_available);
		}
		if (!TextUtils.isEmpty(facebook)) {
			facebookView.setText("facebook.com/" + facebook);
		} else {
			facebookView.setText(R.string.no_data_available);
		}
		if (!TextUtils.isEmpty(twitter)) {
			twitterView.setText("twitter.com/" + twitter);
		} else {
			twitterView.setText(R.string.no_data_available);
		}

		//Adjust fonts:
		companyName.setTypeface(BaseActivity.sRobotoThin);
		companyMoto.setTypeface(BaseActivity.sRobotoThin);
		addressView.setTypeface(BaseActivity.sRobotoThin);
		phoneNumbersTitleView.setTypeface(BaseActivity.sRobotoBlack);
		addressTitleView.setTypeface(BaseActivity.sRobotoBlack);
		addressView.setTypeface(BaseActivity.sRobotoLight);
		telView.setTypeface(BaseActivity.sRobotoLight);
		telCallView.setTypeface(BaseActivity.sRobotoLight);
		mobView.setTypeface(BaseActivity.sRobotoLight);
		mobCallView.setTypeface(BaseActivity.sRobotoLight);
		faxTitleView.setTypeface(BaseActivity.sRobotoBlack);
		faxView.setTypeface(BaseActivity.sRobotoLight);
		faxCallView.setTypeface(BaseActivity.sRobotoLight);
		emailTitleView.setTypeface(BaseActivity.sRobotoBlack);
		emailView.setTypeface(BaseActivity.sRobotoLight);
		emailSendView.setTypeface(BaseActivity.sRobotoLight);
		webTitleView.setTypeface(BaseActivity.sRobotoBlack);
		websiteView.setTypeface(BaseActivity.sRobotoLight);
		websiteVisitView.setTypeface(BaseActivity.sRobotoLight);
		facebookView.setTypeface(BaseActivity.sRobotoLight);
		facebookVisitView.setTypeface(BaseActivity.sRobotoLight);
		twitterView.setTypeface(BaseActivity.sRobotoLight);
		twitterVisitView.setTypeface(BaseActivity.sRobotoLight);
		openMapView.setTypeface(BaseActivity.sRobotoLight);
		
		openMapView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(), MapActivity.class));
			}
		});
		
		//Set listeners:
		telCallView.setOnClickListener(this);
		mobCallView.setOnClickListener(this);
		faxCallView.setOnClickListener(this);
		emailSendView.setOnClickListener(this);
		websiteVisitView.setOnClickListener(this);
		facebookVisitView.setOnClickListener(this);
		twitterVisitView.setOnClickListener(this);
		
		return root;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.contact_template_tel_call:
			if (officePhone != null) {
				startCall(officePhone);
			} else {
				makeToast(R.string.number_not_available);
			}
			break;
		case R.id.contact_template_mob_call:
			if (mobilePhone != null) {
				startCall(mobilePhone);
			} else {
				makeToast(R.string.number_not_available);
			}
			break;
		case R.id.contact_template_fax_call:
			if (faxPhone != null) {
				startCall(faxPhone);
			} else {
				makeToast(R.string.number_not_available);
			}
			break;
		case R.id.contact_template_email_send:
			if (email != null) {
				sendMail(email);
			} else {
				makeToast(R.string.email_not_available);
			}
			break;
		case R.id.contact_template_web_visit:
			if (web != null) {
				visitWebsite(web);
			} else {
				makeToast(R.string.website_not_available);
			}
			break;
		case R.id.contact_template_facebook_visit:
			if (facebook != null) {
				visitWebsite(facebook.contains("facebook.com") ? facebook : "www.facebook.com/" + facebook);
			} else {
				makeToast(R.string.website_not_available);
			}
			break;
		case R.id.contact_template_twiter_visit:
			if (twitter != null) {
				visitWebsite(twitter.contains("twitter.com") ? twitter : "www.twitter.com/" + twitter);
			} else {
				makeToast(R.string.website_not_available);
			}
			break;
		}
	}
	
	private void makeToast(int res) {
		((BaseActivity) getActivity()).makeToast(res);
	}
	
	private void startCall(String number) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("tel:" + number));
		startActivity(intent);
	}
	
	private void sendMail(String email) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("mailto:" + email));
		startActivity(intent);
	}
	
	private void visitWebsite(String website) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://" + website));
		startActivity(intent);
	}
}
