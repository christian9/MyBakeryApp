package com.mybakery.mybakery.models;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by Geovanni on 06/05/2017.
 */

public class Product
{
    private int mID;
    private String mName;
    private String mDescription;
    private int mImage;
    private double mPrice;

    public int getID()
    {
        return mID;
    }

    public String getName()
    {
        return mName;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public double getPrice()
    {
        return mPrice;
    }

    public int getImage()
    {
        return mImage;
    }

    public void setID(int mID)
    {
        this.mID = mID;
    }

    public void setName(String mName)
    {
        this.mName = mName;
    }

    public void setDescription(String mDescription)
    {
        this.mDescription = mDescription;
    }

    public void setPrice(double mPrice)
    {
        this.mPrice = mPrice;
    }

    public void setImage(int mImage)
    {
        this.mImage = mImage;
    }

    public Product()
    {

    }

    public Product(int pID, String pName, String pDescription, int pImage, double pPrice)
    {
        this.mID = pID;
        this.mName = pName;
        this.mDescription = pDescription;
        this.mImage = pImage;
        this.mPrice = pPrice;
    }
}
