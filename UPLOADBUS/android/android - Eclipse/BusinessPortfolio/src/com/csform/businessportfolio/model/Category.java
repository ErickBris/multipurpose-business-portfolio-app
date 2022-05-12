package com.csform.businessportfolio.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
	
	private ArrayList<GalleryImages> galleryImages;
	private String id;
	private String image;
	private String name;
	
	public Category() {
		
	}

	public ArrayList<GalleryImages> getGalleryImages() {
		return this.galleryImages;
	}

	public void setGalleryImages(ArrayList<GalleryImages> galleryImages) {
		this.galleryImages = galleryImages;
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

	protected Category(Parcel in) {
		if (in.readByte() == 0x01) {
			galleryImages = new ArrayList<GalleryImages>();
			in.readList(galleryImages, GalleryImages.class.getClassLoader());
		} else {
			galleryImages = null;
		}
		id = in.readString();
		image = in.readString();
		name = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (galleryImages == null) {
			dest.writeByte((byte) (0x00));
		} else {
			dest.writeByte((byte) (0x01));
			dest.writeList(galleryImages);
		}
		dest.writeString(id);
		dest.writeString(image);
		dest.writeString(name);
	}

	public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
		@Override
		public Category createFromParcel(Parcel in) {
			return new Category(in);
		}

		@Override
		public Category[] newArray(int size) {
			return new Category[size];
		}
	};
}