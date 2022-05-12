package com.csform.businessportfolio.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.csform.businessportfolio.ClientsActivity;
import com.csform.businessportfolio.R;
import com.csform.businessportfolio.adapter.ClientsAdapter;
import com.csform.businessportfolio.model.Client;

public class ClientsFragment extends Fragment implements OnItemClickListener {
	
	public static final String PARCELABLE_CLIENTS = "clients";
	
	private ArrayList<Client> mClients;
	private GridView mClientsGridView;
	
	public static ClientsFragment newInstance(ArrayList<Client> clients) {
		ClientsFragment clientsFragment = new ClientsFragment();
		Bundle args = new Bundle(1);
		args.putParcelableArrayList(PARCELABLE_CLIENTS, clients);
		clientsFragment.setArguments(args);
		return clientsFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.grid, container, false);
		mClients = getArguments().getParcelableArrayList(PARCELABLE_CLIENTS);
		mClientsGridView = (GridView) rootView
				.findViewById(R.id.grid_view);
		ListAdapter clientsAdapter = new ClientsAdapter(getActivity(), mClients);
		mClientsGridView.setAdapter(clientsAdapter);
		mClientsGridView.setOnItemClickListener(this);
		return rootView;
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mClientsGridView.setNumColumns(getResources().getInteger(R.integer.grid_view_number_of_columns));
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		/*ListAdapter clientsAdapter = (ListAdapter) ((GridView) parent)
				.getAdapter();
		Client client = (Client) clientsAdapter.getItem(position);
		Intent intent = new Intent(Intent.ACTION_VIEW);
		if (!client.getWebsite().startsWith("https://")
				&& !client.getWebsite().startsWith("http://")) {
			intent.setData(Uri.parse("http://" + client.getWebsite()));
		} else {
			intent.setData(Uri.parse(client.getWebsite()));
		}
		startActivity(intent);*/
		Intent intent = new Intent(getActivity(), ClientsActivity.class);
		intent.putExtra(PARCELABLE_CLIENTS, mClients.get(position));
		startActivity(intent);
	}
}
