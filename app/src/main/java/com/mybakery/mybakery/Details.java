package com.mybakery.mybakery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity
{
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        toolbar = (Toolbar) findViewById(R.id.detailsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.product_details));

        ImageView ivProduct = (ImageView) findViewById(R.id.ivImage_producto);
        TextView tvPrice = (TextView) findViewById(R.id.tvPrice);
        TextView tvName = (TextView) findViewById(R.id.tvNameProduct);

        Intent intent = getIntent();
        int image = intent.getIntExtra("img_product", 0);
        String price = intent.getStringExtra("price_product");
        String name = intent.getStringExtra("name_product");

        ivProduct.setImageResource(image);
        tvPrice.setText(price);
        tvName.setText(name);


    }
}
