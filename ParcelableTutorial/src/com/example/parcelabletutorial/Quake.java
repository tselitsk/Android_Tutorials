package com.example.parcelabletutorial;

import android.os.Parcel;
import android.os.Parcelable;

public class Quake implements Parcelable{
	String title;
	String updated;
	
	public Quake()
	{
		
	}
	
	public Quake(Parcel source)
	{
		this.title=source.readString();
		this.updated=source.readString();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return this.title;
	}
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int arg1) {
		dest.writeString(this.title);
		dest.writeString(this.updated);
	}
	
	public static final Parcelable.Creator<Quake> CREATOR =
			new Parcelable.Creator<Quake>() {

				@Override
				public Quake createFromParcel(Parcel source) {
					return new Quake(source);
				}

				@Override
				public Quake[] newArray(int size) {
					return new Quake[size];
				}
		
	};
	 

}
