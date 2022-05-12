package com.csform.businessportfolio.syncdata;

import java.util.ArrayList;

import android.os.AsyncTask;

import com.csform.businessportfolio.MainActivity;
import com.csform.businessportfolio.model.Category;
import com.csform.businessportfolio.model.Client;
import com.csform.businessportfolio.model.GalleryImages;
import com.csform.businessportfolio.model.OurTeam;

public class SyncOfflineData extends AsyncTask<Void, Void, Void> {
	
	private static final int SPLASH_SCREEN_TIMEOUT = 1625;
	
	private MainActivity mMainActivity;

	public SyncOfflineData(MainActivity mainActivity) {
		this.mMainActivity = mainActivity;
	}

	@Override
	protected void onPreExecute() {
		mMainActivity.showSplashScreen();
	}

	@Override
	protected Void doInBackground(Void... params) {
		
		addClients();
		
		addOurTeam();
		
		addPortfolioCategory();

		try {
			Thread.sleep(SPLASH_SCREEN_TIMEOUT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		mMainActivity.hideSplashScreen();
	}
	
	/*
	 * Important note!
	 * Please make sure that every ID parameter is null. This will tell the
	 * ImageLoader that it should not search for your uploads folder, but for
	 * a URL provided for image parameter.
	 */
	private void addPortfolioCategory() {
		//Create list of categories
		ArrayList<Category> categories = new ArrayList<Category>();
		//Create one category
		Category cat = new Category();
		cat.setName("Category1");
		cat.setImage("http://pengaja.com/business/admin/uploads/11.jpg");
		ArrayList<GalleryImages> galleryImages = new  ArrayList<GalleryImages>();
		//Create three images
		GalleryImages gi1 = new GalleryImages();
		gi1.setImage("http://pengaja.com/business/admin/uploads/44.jpg");
		galleryImages.add(gi1);
		GalleryImages gi2 = new GalleryImages();
		gi2.setImage("http://pengaja.com/business/admin/uploads/55.jpg");
		galleryImages.add(gi2);
		GalleryImages gi3 = new GalleryImages();
		gi3.setImage("http://pengaja.com/business/admin/uploads/61.jpg");
		galleryImages.add(gi3);
		//Add three images in category
		cat.setGalleryImages(galleryImages);
		//Add created category in rest categories
		categories.add(cat);
		//Set list of categories
		mMainActivity.setCategories(categories);
	}

	/*
	 * Important note!
	 * Please make sure that every ID parameter is null. This will tell the
	 * ImageLoader that it should not search for your uploads folder, but for
	 * a URL provided for image parameter.
	 */
	//TODO Add Clients
	private void addClients() {
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(new Client(null, null, "http://pengaja.com/business/admin/uploads/11.jpg", "Delhaize Europe", "www.delhaizegroup.com"));
		clients.add(new Client(null, null, "http://pengaja.com/business/admin/uploads/22.jpg", "Bristol Group", "www.bristolgroup.cz"));
		clients.add(new Client(null, null, "http://pengaja.com/business/admin/uploads/33.jpg", "Meggle", "www.meggle.com"));
		mMainActivity.setClients(clients);
	}

	/*
	 * Important note!
	 * Please make sure that every ID parameter is null. This will tell the
	 * ImageLoader that it should not search for your uploads folder, but for
	 * a URL provided for image parameter.
	 */
	//TODO Add Our Team members
	private void addOurTeam() {
		ArrayList<OurTeam> ourTeam = new ArrayList<OurTeam>();
		ourTeam.add(new OurTeam(null, null, "jakovljevic.mladen@gmail.com", "jakovljevic.mladen", null,
				"Mladen", "http://pengaja.com/business/admin/uploads/110396367_595971813835086_1627121891_n.jpg", "Jakovljević", "+38765573996", null, "Senior developer",
				"m_jakovljevic", "www.lagoman.com"));
		ourTeam.add(new OurTeam(null, null, null, null, null,
				"Davor", "http://pengaja.com/business/admin/uploads/210409912_595971803835087_983543480_n.jpg", "Jovanović", "+38766115771", null, "Junior developer",
				null, "www.csform.com"));
		mMainActivity.setOurTeams(ourTeam);
	}
}
