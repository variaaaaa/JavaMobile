package com.example.lab4_6;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    int id;
    String name;
    int price;
    int imageResource;
    boolean isChecked;


    public Product(int id, String name, int price, int imageResource, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
        this.isChecked = isChecked;
    }

    Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readInt();
        imageResource = in.readInt();
        isChecked = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeInt(imageResource);
        dest.writeByte((byte) (isChecked ? 1 : 0));
    }


    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}