package com.csform.businessportfolio.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OurTeam implements Parcelable {
	
	private String address;
	private String email;
	private String facebook;
	private String fax_number;
	private String first_name;
	private String id;
	private String image;
	private String last_name;
	private String mobile_number;
	private String phone_number;
	private String position;
	private String twitter;
	private String website;

	public OurTeam(String id, String address, String email, String facebook,
			String fax_number, String first_name, String image,
			String last_name, String mobile_number, String phone_number,
			String position, String twitter, String website) {
		this.id = id;
		this.address = address;
		this.email = email;
		this.facebook = facebook;
		this.fax_number = fax_number;
		this.first_name = first_name;
		this.image = image;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		this.phone_number = phone_number;
		this.position = position;
		this.twitter = twitter;
		this.website = website;
	}

	protected OurTeam(Parcel in) {
		address = in.readString();
		email = in.readString();
		facebook = in.readString();
		fax_number = in.readString();
		first_name = in.readString();
		id = in.readString();
		image = in.readString();
		last_name = in.readString();
		mobile_number = in.readString();
		phone_number = in.readString();
		position = in.readString();
		twitter = in.readString();
		website = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(address);
		dest.writeString(email);
		dest.writeString(facebook);
		dest.writeString(fax_number);
		dest.writeString(first_name);
		dest.writeString(id);
		dest.writeString(image);
		dest.writeString(last_name);
		dest.writeString(mobile_number);
		dest.writeString(phone_number);
		dest.writeString(position);
		dest.writeString(twitter);
		dest.writeString(website);
	}

	public static final Parcelable.Creator<OurTeam> CREATOR = new Parcelable.Creator<OurTeam>() {
		@Override
		public OurTeam createFromParcel(Parcel in) {
			return new OurTeam(in);
		}

		@Override
		public OurTeam[] newArray(int size) {
			return new OurTeam[size];
		}
	};

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getFax_number() {
		return this.fax_number;
	}

	public void setFax_number(String fax_number) {
		this.fax_number = fax_number;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getId() {
		return id;
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

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile_number() {
		return this.mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getPhone_number() {
		return this.phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}
