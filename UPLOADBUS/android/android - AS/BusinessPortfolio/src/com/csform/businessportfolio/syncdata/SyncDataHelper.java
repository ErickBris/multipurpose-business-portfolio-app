package com.csform.businessportfolio.syncdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.csform.businessportfolio.model.Categories;
import com.csform.businessportfolio.model.Clients;
import com.csform.businessportfolio.model.OurTeams;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class SyncDataHelper {

	private static final int CONNECTION_TIMEOUT = 45 * 1000; // 45 seconds
	public static final String URL_ROOT = "http://www.pengaja.com/business/admin/index.php/";
	public static final String URL_UPLOADS = "http://pengaja.com/business/admin/uploads/";

	private static BufferedReader getInputStream(String urlString)
			throws IOException {
		urlString = urlString.replaceAll(" ", "%20");
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(CONNECTION_TIMEOUT);
		return new BufferedReader(new InputStreamReader(conn.getInputStream()));
	}

	public static Clients fetchClients() throws JsonSyntaxException,
			JsonIOException, IOException {
		String urlString = URL_ROOT + "clients/api";
		BufferedReader in = getInputStream(urlString);
		try {
			return new Gson().fromJson(in, Clients.class);
		} finally {
			closeReader(in);
		}
	}

	public static OurTeams fetchOurTeams() throws JsonSyntaxException,
			JsonIOException, IOException {
		String urlString = URL_ROOT + "ourTeam/api";
		BufferedReader in = getInputStream(urlString);
		try {
			return new Gson().fromJson(in, OurTeams.class);
		} finally {
			closeReader(in);
		}
	}

	public static Categories fetchImageCategories() throws JsonSyntaxException,
			JsonIOException, IOException {
		String urlString = URL_ROOT + "galleryCategory/api";
		BufferedReader in = getInputStream(urlString);
		try {
			return new Gson().fromJson(in, Categories.class);
		} finally {
			closeReader(in);
		}
	}

	private static void closeReader(BufferedReader in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				// ignore
			}
		}
	}
}
