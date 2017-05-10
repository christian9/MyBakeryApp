package com.mybakery.mybakery.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mybakery.mybakery.R;
import com.mybakery.mybakery.models.Product;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * Created by Geovanni on 06/05/2017.
 */

public class ProductsAdapter extends ArrayAdapter<Product>
{
    Context mContext;
    int AdapterResource;

    public ProductsAdapter(Context pContext, int pResource)
    {
        super(pContext, pResource);

        this.mContext = pContext;
        this.AdapterResource = pResource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        final Product currentItem = getItem(position);

        if (row == null)
        {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(AdapterResource, parent, false);
        }

        row.setTag(currentItem);
        final TextView tvName = (TextView) row.findViewById(R.id.tvProductName);
        final TextView tvDescription = (TextView) row.findViewById(R.id.tvProductDescription);
        final TextView tvPrice = (TextView) row.findViewById(R.id.tvPrice);
        final ImageView ivImage = (ImageView) row.findViewById(R.id.productImage);


        tvName.setText(currentItem.getName());
        tvDescription.setText(currentItem.getDescription());

        ivImage.setImageResource(currentItem.getImage());


        DecimalFormat formatter = new DecimalFormat("###.##");
        formatter.setDecimalSeparatorAlwaysShown(true);
        formatter.setMinimumFractionDigits(2);

        tvPrice.setText("$" + formatter.format(currentItem.getPrice()));

        return row;
    }
}