package com.prospect.rallyshop.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.prospect.rallyshop.Login;
import com.prospect.rallyshop.R;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Stock extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        // Setup toggle to display hamburger icon with nice animation
        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.syncState();
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.openDrawer(GravityCompat.START);
            }
        });
        drawerToggle.setHomeAsUpIndicator(R.drawable.xboxmenu);
        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
        // Lookup navigation view
        NavigationView navigationView = (NavigationView) findViewById(R.id.nvView);
// Inflate the header view at runtime
        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header);

    }

    private ActionBarDrawerToggle setupDrawerToggle() {

        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it

        // and will not render the hamburger icon without it.

        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);

    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override

                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {

        switch(menuItem.getItemId()) {
            case R.id.viewcategory:

                Intent intent = new Intent(getApplicationContext(), Category.class);
                startActivity(intent);
                finish();
                break;
            case R.id.viewsubcategory:

                Intent intent112 = new Intent(getApplicationContext(), SimpleProduct.class);
                startActivity(intent112);
                finish();
                break;

            case R.id.viewsell:

                Intent intent111 = new Intent(getApplicationContext(), SoldProduct.class);
                startActivity(intent111);
                finish();
                break;
            case R.id.viewAlart:

                Intent intent2 = new Intent(getApplicationContext(), AlartProduct.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.viewUS:

                Intent intent2viewUS = new Intent(getApplicationContext(), AoutUS.class);
                startActivity(intent2viewUS);
                finish();
                break;
            case R.id.Quit:

                Intent intent2Quit = new Intent(getApplicationContext(), Login.class);
                startActivity(intent2Quit);
                finish();
                break;

            default:

                Toast.makeText(Stock.this,"No Activity selected",Toast.LENGTH_LONG).show();

        }
        // Highlight the selected item has been done by NavigationView

        menuItem.setChecked(true);

        // Set action bar title

        setTitle(menuItem.getTitle());

        // Close the navigation drawer

        mDrawer.closeDrawers();

    }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    // `onPostCreate` called when activity start-up is complete after `onStart()`

    // NOTE 1: Make sure to override the method with only a single `Bundle` argument

    // Note 2: Make sure you implement the correct `onPostCreate(Bundle savedInstanceState)` method.

    // There are 2 signatures and only `onPostCreate(Bundle state)` shows the hamburger icon.

    @Override

    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred.

        drawerToggle.syncState();

    }

    @Override

    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        // Pass any configuration change to the drawer toggles

        drawerToggle.onConfigurationChanged(newConfig);

    }

}