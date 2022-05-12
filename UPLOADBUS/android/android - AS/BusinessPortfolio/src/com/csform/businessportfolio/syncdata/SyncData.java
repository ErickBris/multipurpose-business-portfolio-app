package com.csform.businessportfolio.syncdata;

import java.io.IOException;

import android.os.AsyncTask;

import com.csform.businessportfolio.MainActivity;
import com.csform.businessportfolio.R;
import com.csform.businessportfolio.model.Categories;
import com.csform.businessportfolio.model.Clients;
import com.csform.businessportfolio.model.OurTeams;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class SyncData extends AsyncTask<Void, Void, Integer> {
	private MainActivity mMainActivity;

	public SyncData(MainActivity mainActivity) {
		this.mMainActivity = mainActivity;
	}

	@Override
	protected void onPreExecute() {
		mMainActivity.showSplashScreen();
	}

	@Override
	protected Integer doInBackground(Void... params) {
		try {
			Clients clients = SyncDataHelper.fetchClients();
			mMainActivity.setClients(clients.getClients());
			if (isCancelled()) {
				return -10;
			}

			OurTeams ourTeams = SyncDataHelper.fetchOurTeams();
			mMainActivity.setOurTeams(ourTeams.getOurTeamList());
			if (isCancelled()) {
				return -10;
			}

			Categories categories = SyncDataHelper.fetchImageCategories();
			mMainActivity.setCategories(categories.getCategory());
			if (isCancelled()) {
				return -10;
			}
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return -2;
		} catch (JsonIOException e) {
			e.printStackTrace();
			return -3;
		} catch (IOException e) {
			e.printStackTrace();
			return -4;
		} catch (Exception e) {
			e.printStackTrace();
			return -5;
		}
		return 1;
	}

	@Override
	protected void onPostExecute(Integer result) {
		if (result == 1) {
			mMainActivity.hideSplashScreen();
		} else {
			mMainActivity.makeToast(R.string.error_occured);
		}
	}
}
