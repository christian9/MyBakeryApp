package com.mybakery.mybakery;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mybakery.mybakery.fragments.Products;
import com.mybakery.mybakery.fragments.TabContainer;

public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setInitialFragment();
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
            TabContainer fragmentInicio = new TabContainer();
            android.support.v4.app.FragmentTransaction fragmentTransactionInicio = getSupportFragmentManager()
                    .beginTransaction();
            toolbar.setTitle("Inicio");
            fragmentTransactionInicio.replace(R.id.mainFragment, fragmentInicio);
            fragmentTransactionInicio.commit();
        }
        else if (id == R.id.nav_products)
        {
            Products fragmentProducts = new Products();
            android.support.v4.app.FragmentTransaction fragmentTransactionProducts = getSupportFragmentManager()
                    .beginTransaction();
            toolbar.setTitle("Productos");
            fragmentTransactionProducts.replace(R.id.mainFragment, fragmentProducts);
            fragmentTransactionProducts.commit();
        }
        else if (id == R.id.nav_stores)
        {
            Toast.makeText(this, "Menu sucursales", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_favorites)
        {
            Toast.makeText(this, "Menu favoritos", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_settings)
        {
            Toast.makeText(this, "Menu configuracion", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setInitialFragment()
    {
        navigationView.setCheckedItem(R.id.nav_home);

        TabContainer fragmentInicio = new TabContainer();
        android.support.v4.app.FragmentTransaction fragmentTransactionInicio = getSupportFragmentManager().beginTransaction();
        toolbar.setTitle("Inicio");
        fragmentTransactionInicio.replace(R.id.mainFragment, fragmentInicio);
        fragmentTransactionInicio.commit();
    }
}
