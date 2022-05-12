package com.csform.businessportfolio;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity {

	private static final LatLng TutorialsPoint = new LatLng(44.770057, 17.191455);
	private GoogleMap googleMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity);
		try {
			if (googleMap == null) {
				googleMap = ((MapFragment) getFragmentManager()
						.findFragmentById(R.id.map)).getMap();
			}
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(TutorialsPoint, 15.0f));
			googleMap.addMarker(new MarkerOptions().position(TutorialsPoint)
					.title(getString(R.string.company_name)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
