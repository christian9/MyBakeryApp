package com.mybakery.mybakery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setBackgroundDrawableResource(R.drawable.bg_cakes) ;
    }

    public void navigateHome(View view)
    {
        Intent home = new Intent(Login.this, Main.class);
        startActivity(home);
    }
}
