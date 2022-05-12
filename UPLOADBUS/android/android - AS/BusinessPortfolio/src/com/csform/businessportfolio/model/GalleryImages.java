package com.csform.businessportfolio.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GalleryImages implements Parcelable {
	
	private String description;
	private String id;
	private String id_category;
	private String image;
	
	public GalleryImages() { }

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

	public String getId_category() {
		return this.id_category;
	}

	public void setId_category(String id_category) {
		this.id_category = id_category;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	protected GalleryImages(Parcel in) {
		description = in.readString();
		id = in.readString();
		id_category = in.readString();
		image = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(description);
		dest.writeString(id);
		dest.writeString(id_category);
		dest.writeString(image);
	}

	public static final Parcelable.Creator<GalleryImages> CREATOR = new Parcelable.Creator<GalleryImages>() {
		@Override
		public GalleryImages createFromParcel(Parcel in) {
			return new GalleryImages(in);
		}

		@Override
		public GalleryImages[] newArray(int size) {
			return new GalleryImages[size];
		}
	};
}