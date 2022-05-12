package com.csform.businessportfolio;

import com.google.analytics.tracking.android.EasyTracker;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class BaseActivity extends FragmentActivity {

	public static Typeface sRobotoBlack;
	public static Typeface sRobotoBlackItalic;
	public static Typeface sRobotoLight;
	public static Typeface sRobotoLightItalic;
	public static Typeface sRobotoThin;
	
	private Toast mToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initTypefaces();
	}

	@Override
	public void onStart() {
		super.onStart();
		EasyTracker.getInstance(this).activityStart(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		EasyTracker.getInstance(this).activityStop(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mToast != null) {
			mToast.cancel();
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	
	public void makeToast(int resId) {
		makeToast(getString(resId));
	}
	
	public void makeToast(String text) {
		if (mToast == null) {
			mToast = Toast.makeText(this, text, Toast.LENGTH_LONG);
		} else {
			mToast.setText(text);
		}
		mToast.show();
	}

	private void initTypefaces() {
		if (sRobotoBlack == null) {
			sRobotoBlack = Typeface.createFromAsset(getAssets(),
					"fonts/Roboto-Black.ttf");
		}
		if (sRobotoBlackItalic == null) {
			sRobotoBlackItalic = Typeface.createFromAsset(getAssets(),
					"fonts/Roboto-BlackItalic.ttf");
		}
		if (sRobotoLight == null) {
			sRobotoLight = Typeface.createFromAsset(getAssets(),
					"fonts/Roboto-Light.ttf");
		}
		if (sRobotoLightItalic == null) {
			sRobotoLightItalic = Typeface.createFromAsset(getAssets(),
					"fonts/Roboto-LightItalic.ttf");
		}
		if (sRobotoThin == null) {
			sRobotoThin = Typeface.createFromAsset(getAssets(),
					"fonts/Roboto-Thin.ttf");
		}
	}
}
