package com.mybakery.mybakery.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mybakery.mybakery.Details;
import com.mybakery.mybakery.R;
import com.mybakery.mybakery.adapters.ProductsAdapter;
import com.mybakery.mybakery.models.Product;

import java.text.DecimalFormat;

public class FragmentOne extends Fragment
{
    //Views and Layout
    ListView mainListview;

    //Adapters
    ProductsAdapter productsAdapter;

    public FragmentOne()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        mainListview = (ListView) view.findViewById(R.id.mainListview);

        productsAdapter = new ProductsAdapter(getActivity(), R.layout.custom_main_listview_item);
        mainListview.setAdapter(productsAdapter);

        fillGenericData();
        addListClickListener();

        return view;
    }

    private void fillGenericData()
    {
        Product p1 = new Product();
        p1.setName("Cheesecake");
        p1.setDescription("Pastel de queso");
        p1.setPrice(12.45);
        p1.setImage(R.drawable.cheesecake);
        productsAdapter.add(p1);

        Product p2 = new Product();
        p2.setName("Chocolate");
        p2.setDescription("Pastel de chocolate");
        p2.setPrice(15.00);
        p2.setImage(R.drawable.chocolate);
        productsAdapter.add(p2);

        Product p3 = new Product();
        p3.setName("Vainilla");
        p3.setDescription("Pastel de vainilla");
        p3.setPrice(12.00);
        p3.setImage(R.drawable.vanilla);
        productsAdapter.add(p3);

        Product p4 = new Product();
        p4.setName("Frambuesas");
        p4.setDescription("Pastel de frambuesas");
        p4.setPrice(17.00);
        p4.setImage(R.drawable.cranberries);
        productsAdapter.add(p4);

        Product p5 = new Product();
        p5.setName("Avellanas");
        p5.setDescription("Pastel de avellanas");
        p5.setPrice(23.00);
        p5.setImage(R.drawable.hazelnut);
        productsAdapter.add(p5);
    }

    private void addListClickListener()
    {
        mainListview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Product product = ((Product) parent.getItemAtPosition(position));

                DecimalFormat formatter = new DecimalFormat("###.##");
                formatter.setDecimalSeparatorAlwaysShown(true);
                formatter.setMinimumFractionDigits(2);

                Intent details = new Intent(getActivity(), Details.class);
                details.putExtra("img_product", product.getImage());
                details.putExtra("price_product", "$ " + formatter.format(product.getPrice()));
                details.putExtra("name_product", product.getName());
                startActivity(details);
            }
        });
    }


}
