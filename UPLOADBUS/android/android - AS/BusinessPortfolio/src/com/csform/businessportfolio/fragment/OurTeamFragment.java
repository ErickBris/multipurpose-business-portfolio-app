package com.csform.businessportfolio.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.csform.businessportfolio.OurTeamActivity;
import com.csform.businessportfolio.R;
import com.csform.businessportfolio.adapter.OurTeamAdapter;
import com.csform.businessportfolio.model.OurTeam;

public class OurTeamFragment extends Fragment implements OnItemClickListener {

	public static final String PARCELABLE_OUR_TEAM_LIST = "our_team_list";
	public static final String PARCELABLE_OUR_TEAM = "our_team";
	private ArrayList<OurTeam> ourTeam;

	public static OurTeamFragment newInstance(ArrayList<OurTeam> ourTeam) {
		OurTeamFragment ourTeamFragment = new OurTeamFragment();
		Bundle args = new Bundle(1);
		args.putParcelableArrayList(PARCELABLE_OUR_TEAM_LIST, ourTeam);
		ourTeamFragment.setArguments(args);
		return ourTeamFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.grid, container, false);
		ourTeam = getArguments().getParcelableArrayList(
				PARCELABLE_OUR_TEAM_LIST);
		GridView ourTeamListView = (GridView) rootView
				.findViewById(R.id.grid_view);
		ourTeamListView.setNumColumns(1);//make it list view
		ourTeamListView.setAdapter(new OurTeamAdapter(getActivity(), ourTeam));
		ourTeamListView.setOnItemClickListener(this);
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent(getActivity(), OurTeamActivity.class);
		intent.putExtra(PARCELABLE_OUR_TEAM, ourTeam.get(position));
		startActivity(intent);
	}
}
