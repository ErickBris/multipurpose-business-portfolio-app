package com.csform.businessportfolio.syncdata;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.csform.businessportfolio.BaseActivity;
import com.csform.businessportfolio.FullScreenGalleryActivity;
import com.csform.businessportfolio.R;

public class DialogUtils {

	private FullScreenGalleryActivity mFullScreenGalleryActivity;

	private Dialog mDialog;

	private TextView mDialogTitle;
	private TextView mDialogPositiveButton;
	private TextView mDialogNegativeButton;
	private int wss;

	public DialogUtils(FullScreenGalleryActivity mFullScreenGalleryActivity) {
		this.mFullScreenGalleryActivity = mFullScreenGalleryActivity;
	}

	public void showDialog(String dialogTitleText) {
		if (mDialog == null) {
			mDialog = new Dialog(mFullScreenGalleryActivity,
					R.style.CustomDialogTheme);
		}
		mDialog.setContentView(R.layout.dialog);
		mDialog.show();

		mDialogTitle = (TextView) mDialog.findViewById(R.id.dialog_title);

		mDialogNegativeButton = (TextView) mDialog
				.findViewById(R.id.dialog_negative);
		mDialogPositiveButton = (TextView) mDialog
				.findViewById(R.id.dialog_positive);
		initDialogButtons(dialogTitleText);
	}

	private void initDialogButtons(String dialogTitleText) {
		if (dialogTitleText.equals("wallpaper")) {
			mDialogTitle.setText(mFullScreenGalleryActivity
					.getString(R.string.dialog_wallpaper));
			wss = 0;
		} else if (dialogTitleText.equals("save")) {
			mDialogTitle.setText(mFullScreenGalleryActivity
					.getString(R.string.dialog_save));
			wss = 1;
		} else if (dialogTitleText.equals("share")) {
			mDialogTitle.setText(mFullScreenGalleryActivity
					.getString(R.string.dialog_share));
			wss = 2;
		}

		mDialogNegativeButton.setText(mFullScreenGalleryActivity
				.getString(R.string.no));
		mDialogNegativeButton.setTypeface(BaseActivity.sRobotoLight);
		mDialogNegativeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				mDialog.dismiss();
			}
		});

		mDialogPositiveButton.setText(mFullScreenGalleryActivity
				.getString(R.string.yes));
		mDialogPositiveButton.setTypeface(BaseActivity.sRobotoLight);
		mDialogPositiveButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				mDialog.dismiss();
				mFullScreenGalleryActivity.setGetBit(wss);
			}
		});
	}

	public void dismissDialog() {
		mDialog.dismiss();
	}
}
