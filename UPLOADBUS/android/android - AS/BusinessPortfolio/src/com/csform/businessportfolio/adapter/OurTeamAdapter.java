package com.csform.businessportfolio.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.csform.businessportfolio.BaseActivity;
import com.csform.businessportfolio.R;
import com.csform.businessportfolio.Utils;
import com.csform.businessportfolio.model.OurTeam;

public class OurTeamAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private ArrayList<OurTeam> ourTeamList;

	public OurTeamAdapter(Context context, ArrayList<OurTeam> ourTeamList) {
		this.context = context;
		this.ourTeamList = ourTeamList;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	private class ViewHolder {
		public TextView firstName;
		public TextView lastName;
		public TextView position;
		public ImageView image;
	}

	@Override
	public int getCount() {
		return ourTeamList.size();
	}

	@Override
	public Object getItem(int position) {
		return ourTeamList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.our_team_single_item,
					parent, false);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.our_team_single_item_image);
			holder.firstName = (TextView) convertView
					.findViewById(R.id.our_team_single_item_first_name);
			holder.lastName = (TextView) convertView
					.findViewById(R.id.our_team_single_item_last_name);
			holder.position = (TextView) convertView
					.findViewById(R.id.our_team_single_item_position);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		OurTeam ot = ourTeamList.get(position);

		Utils.setImageWithImageLoader(holder.image, context, ot.getId(), ot.getImage(), null);
		holder.firstName.setTypeface(BaseActivity.sRobotoThin);
		holder.lastName.setTypeface(BaseActivity.sRobotoThin);
		holder.position.setTypeface(BaseActivity.sRobotoBlack);

		holder.firstName.setText(ot.getFirst_name());
		holder.lastName.setText(ot.getLast_name());
		if (ot.getPosition() == null) {
			holder.position.setVisibility(View.GONE);
		} else {
			holder.position.setVisibility(View.VISIBLE);
			holder.position.setText(ot.getPosition().toUpperCase());
		}

		return convertView;
	}

}
