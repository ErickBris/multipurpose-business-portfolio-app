package com.csform.businessportfolio;

import java.util.Locale;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.businessportfolio.fragment.OurTeamFragment;
import com.csform.businessportfolio.model.OurTeam;

public class OurTeamActivity extends BaseActivity implements OnClickListener {
	
	private OurTeam employer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.our_team_activity);

		employer = getIntent().getExtras().getParcelable(OurTeamFragment.PARCELABLE_OUR_TEAM);

		ImageView image = (ImageView) findViewById(R.id.our_team_activity_image);
		TextView firstName = (TextView) findViewById(R.id.our_team_activity_first_name);
		TextView lastName = (TextView) findViewById(R.id.our_team_activity_last_name);
		TextView position = (TextView) findViewById(R.id.our_team_activity_position);
		TextView addressTitle = (TextView) findViewById(R.id.contact_template_address_title);
		TextView address = (TextView) findViewById(R.id.contact_template_address);
		TextView phoneNumbersTitle = (TextView) findViewById(R.id.contact_template_phone_numbers_title);
		TextView tel = (TextView) findViewById(R.id.contact_template_tel);
		TextView telCall = (TextView) findViewById(R.id.contact_template_tel_call);
		TextView mob = (TextView) findViewById(R.id.contact_template_mob);
		TextView mobCall = (TextView) findViewById(R.id.contact_template_mob_call);
		TextView faxTitle = (TextView) findViewById(R.id.contact_template_fax_title);
		TextView fax = (TextView) findViewById(R.id.contact_template_fax);
		TextView faxCall = (TextView) findViewById(R.id.contact_template_fax_call);
		TextView emailTitle = (TextView) findViewById(R.id.contact_template_email_title);
		TextView email = (TextView) findViewById(R.id.contact_template_email);
		TextView emailSend = (TextView) findViewById(R.id.contact_template_email_send);
		TextView webTitle = (TextView) findViewById(R.id.contact_template_web_title);
		TextView website = (TextView) findViewById(R.id.contact_template_web);
		TextView websiteVisit = (TextView) findViewById(R.id.contact_template_web_visit);
		TextView facebook = (TextView) findViewById(R.id.contact_template_facebook);
		TextView facebookVisit = (TextView) findViewById(R.id.contact_template_facebook_visit);
		TextView twitter = (TextView) findViewById(R.id.contact_template_twiter);
		TextView twitterVisit = (TextView) findViewById(R.id.contact_template_twiter_visit);
		
		Utils.setImageWithImageLoader(image, this, employer.getId(), employer.getImage(), null);
		
		firstName.setText(employer.getFirst_name());
		lastName.setText(employer.getLast_name());
		position.setText(employer.getPosition().toUpperCase(Locale.getDefault()));
		if (employer.getAddress() != null) {
			address.setText(employer.getAddress());
		} else {
			address.setText(R.string.no_data_available);
		}
		if (employer.getPhone_number() != null) {
			tel.setText(employer.getPhone_number());
		} else {
			tel.setText(R.string.no_data_available);
		}
		if (employer.getMobile_number() != null) {
			mob.setText(employer.getMobile_number());
		} else {
			mob.setText(R.string.no_data_available);
		}
		if (employer.getFax_number() != null) {
			fax.setText(employer.getFax_number());
		} else {
			fax.setText(R.string.no_data_available);
		}
		if (employer.getEmail() != null) {
			email.setText(employer.getEmail());
		} else {
			email.setText(R.string.no_data_available);
		}
		if (employer.getWebsite() != null) {
			website.setText(employer.getWebsite());
		} else {
			website.setText(R.string.no_data_available);
		}
		if (employer.getFacebook() != null) {
			facebook.setText("facebook.com/" + employer.getFacebook());
		} else {
			facebook.setText(R.string.no_data_available);
		}
		if (employer.getTwitter() != null) {
			twitter.setText("twitter.com/" + employer.getTwitter());
		} else {
			twitter.setText(R.string.no_data_available);
		}
		
		//Adjust fonts:
		firstName.setTypeface(sRobotoThin);
		lastName.setTypeface(sRobotoThin);
		position.setTypeface(sRobotoBlack);
		phoneNumbersTitle.setTypeface(sRobotoBlack);
		addressTitle.setTypeface(sRobotoBlack);
		address.setTypeface(sRobotoLight);
		tel.setTypeface(sRobotoLight);
		telCall.setTypeface(sRobotoLight);
		mob.setTypeface(sRobotoLight);
		mobCall.setTypeface(sRobotoLight);
		faxTitle.setTypeface(sRobotoBlack);
		fax.setTypeface(sRobotoLight);
		faxCall.setTypeface(sRobotoLight);
		emailTitle.setTypeface(sRobotoBlack);
		email.setTypeface(sRobotoLight);
		emailSend.setTypeface(sRobotoLight);
		webTitle.setTypeface(sRobotoBlack);
		website.setTypeface(sRobotoLight);
		websiteVisit.setTypeface(sRobotoLight);
		facebook.setTypeface(sRobotoLight);
		facebookVisit.setTypeface(sRobotoLight);
		twitter.setTypeface(sRobotoLight);
		twitterVisit.setTypeface(sRobotoLight);
		
		//Set listeners:
		telCall.setOnClickListener(this);
		mobCall.setOnClickListener(this);
		faxCall.setOnClickListener(this);
		emailSend.setOnClickListener(this);
		websiteVisit.setOnClickListener(this);
		facebookVisit.setOnClickListener(this);
		twitterVisit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.contact_template_tel_call:
			if (employer.getPhone_number() != null) {
				startCall(employer.getPhone_number());
			} else {
				makeToast(R.string.number_not_available);
			}
			break;
		case R.id.contact_template_mob_call:
			if (employer.getMobile_number() != null) {
				startCall(employer.getMobile_number());
			} else {
				makeToast(R.string.number_not_available);
			}
			break;
		case R.id.contact_template_fax_call:
			if (employer.getFax_number() != null) {
				startCall(employer.getFax_number());
			} else {
				makeToast(R.string.number_not_available);
			}
			break;
		case R.id.contact_template_email_send:
			if (employer.getEmail() != null) {
				sendMail(employer.getEmail());
			} else {
				makeToast(R.string.email_not_available);
			}
			break;
		case R.id.contact_template_web_visit:
			if (employer.getWebsite() != null) {
				visitWebsite(employer.getWebsite());
			} else {
				makeToast(R.string.website_not_available);
			}
			break;
		case R.id.contact_template_facebook_visit:
			if (employer.getFacebook() != null) {
				visitWebsite(employer.getFacebook().contains("facebook.com") ? employer.getFacebook() : "www.facebook.com/" + employer.getFacebook());
			} else {
				makeToast(R.string.website_not_available);
			}
			break;
		case R.id.contact_template_twiter_visit:
			if (employer.getTwitter() != null) {
				visitWebsite(employer.getTwitter().contains("twitter.com") ? employer.getTwitter() : "www.twitter.com/" + employer.getTwitter());
			} else {
				makeToast(R.string.website_not_available);
			}
			break;
		}
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
