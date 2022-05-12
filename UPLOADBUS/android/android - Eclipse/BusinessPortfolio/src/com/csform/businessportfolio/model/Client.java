package com.csform.businessportfolio.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Client implements Parcelable {
	
	private String description;
	private String id;
	private String image;
	private String name;
	private String website;

	public Client(String id, String description, String image, String name, String website) {
		this.id = id;
		this.description = description;
		this.image = image;
		this.name = name;
		this.website = website;
	}

	protected Client(Parcel in) {
		description = in.readString();
		id = in.readString();
		image = in.readString();
		name = in.readString();
		website = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(description);
		dest.writeString(id);
		dest.writeString(image);
		dest.writeString(name);
		dest.writeString(website);
	}

	public static final Parcelable.Creator<Client> CREATOR = new Parcelable.Creator<Client>() {
		@Override
		public Client createFromParcel(Parcel in) {
			return new Client(in);
		}

		@Override
		public Client[] newArray(int size) {
			return new Client[size];
		}
	};

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}
