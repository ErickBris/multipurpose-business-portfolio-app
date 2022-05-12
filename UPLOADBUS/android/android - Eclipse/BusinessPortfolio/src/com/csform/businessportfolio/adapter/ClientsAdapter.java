package com.csform.businessportfolio.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.csform.businessportfolio.R;
import com.csform.businessportfolio.Utils;
import com.csform.businessportfolio.model.Client;

public class ClientsAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private ArrayList<Client> clients;

	public ClientsAdapter(Context context, ArrayList<Client> clients) {
		this.context = context;
		this.clients = clients;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	private class ViewHolder {
		public ImageView image;
	}

	@Override
	public int getCount() {
		return clients.size();
	}

	@Override
	public Object getItem(int position) {
		return clients.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.image_view,
					parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Client client = clients.get(position);
		Utils.setImageWithImageLoader(holder.image, context, client.getId(), client.getImage(), null);

		return convertView;
	}
}
