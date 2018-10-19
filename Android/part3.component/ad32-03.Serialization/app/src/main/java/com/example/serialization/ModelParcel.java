package com.example.serialization;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelParcel implements Parcelable {

    private int    idata = 0;
    private String sdata = "";

    public int getIdata() {
        return idata;
    }

    public void setIdata(int idata) {
        this.idata = idata;
    }

    public String getSdata() {
        return sdata;
    }

    public void setSdata(String sdata) {
        this.sdata = sdata;
    }

    @Override
    public String toString() {
        return "ModelParcel{" +
                "idata=" + idata +
                ", sdata='" + sdata + '\'' +
                '}';
    }

    public ModelParcel() {
    }

    protected ModelParcel(Parcel in) {
        idata = in.readInt();
        sdata = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idata);
        dest.writeString(sdata);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelParcel> CREATOR = new Creator<ModelParcel>() {
        @Override
        public ModelParcel createFromParcel(Parcel in) {
            return new ModelParcel(in);
        }

        @Override
        public ModelParcel[] newArray(int size) {
            return new ModelParcel[size];
        }
    };
}
