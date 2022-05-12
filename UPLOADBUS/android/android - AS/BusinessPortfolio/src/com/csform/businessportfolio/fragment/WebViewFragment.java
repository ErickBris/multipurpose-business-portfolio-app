package com.csform.businessportfolio.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.csform.businessportfolio.R;

public class WebViewFragment extends Fragment {

	public static final int OBTAIN_PROGRESS_EVERY = 100;
	public static final String ARG_URL = "url";
	
	private ProgressBar mProgressBar;
	private WebView mWebView;
	private Handler mHandler = new Handler();
	private Runnable mRunnable = new Runnable() {
		
		@Override
		public void run() {
			int progress = mWebView.getProgress();
			mProgressBar.setProgress(progress);
			if (progress != 100) {
				mHandler.postDelayed(this, OBTAIN_PROGRESS_EVERY);
			}
		}
	};
	
	public static WebViewFragment newInstance(String URL) {
		WebViewFragment webViewFragment = new WebViewFragment();
		Bundle args = new Bundle(1);
		args.putString(ARG_URL, URL);
		webViewFragment.setArguments(args);
		return webViewFragment;
	}

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.web_view, container, false);
		
		mWebView = (WebView) root.findViewById(R.id.web_view);
		mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
		
		mWebView.loadUrl(getArguments().getString(ARG_URL));
		
		mHandler.postDelayed(mRunnable, OBTAIN_PROGRESS_EVERY);
		
		// to open links in this webview, use this line of code:
		mWebView.setWebViewClient(new WebViewClient());
		// to enable JavaScript, use this line of code:
		mWebView.getSettings().setJavaScriptEnabled(true);
		// to load pages faster, use this line of code:
		mWebView.getSettings().setAppCacheEnabled(true);
		// to enable pinch to zoom, use this line of code:
		mWebView.getSettings().setBuiltInZoomControls(true);
		
		return root;
	}
}
