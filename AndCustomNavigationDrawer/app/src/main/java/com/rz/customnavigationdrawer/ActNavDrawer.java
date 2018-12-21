package com.rz.customnavigationdrawer;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActNavDrawer extends AppCompatActivity {
    //ActNavigationDrawerList
    //ModelNavDrawerData
    //AdapterNavDrawer
    //FragDashboard
    //FragTutorial
    //FragRzRasel
    //FragBadgeMate
    //FragSubscribe
    //FragLike
    //FragAbout
    //FragContact
    /*
    {DELAY=200}pri{ENTER}Act{ENTER} act{ENTER};{ENTER}
    pri{ENTER}Con{ENTER} con{ENTER};{ENTER}
    pri{ENTER}ActionBar{ENTER} act{ENTER};{ENTER}
    pri{ENTER}Dra{ENTER} sysDrawerLayout;{ENTER}
    pri{ENTER}AdapterNav{ENTER} ada{ENTER};{ENTER}
     */
    //|------------------------------------------------------------|
    private Activity activity;
    private Context context;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout sysDrawerLayout;
    private AdapterNavigationDrawer adapterNavigationDrawer;
    private ArrayList<ModelNavDrawerData> modelNavDrawerListItems = new ArrayList<ModelNavDrawerData>();
    private ListView sysDrawerList;
    //|------------------------------------------------------------|

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_nav_drawer);
        activity = this;
        context = this;
        //|------------------------------------------------------------|
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //|------------------------------------------------------------|
        sysDrawerLayout = (DrawerLayout) findViewById(R.id.sysDrawerLayout);
        sysDrawerList = (ListView) findViewById(R.id.sysDrawerList);
        //|------------------------------------------------------------|
        modelNavDrawerListItems.add(new ModelNavDrawerData("Home"));
        modelNavDrawerListItems.add(new ModelNavDrawerData("Tutorial"));
        adapterNavigationDrawer = new AdapterNavigationDrawer(context, R.layout.lay_row_nav_drawer, modelNavDrawerListItems);
        sysDrawerList.setAdapter(adapterNavigationDrawer);
        sysDrawerList.setOnItemClickListener(new OnDrawerItemClickListener());
        //|------------------------------------------------------------|
        //actionBarDrawerToggle = new ActionBarDrawerToggle(activity, sysDrawerLayout,R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle = new ActionBarDrawerToggle(activity, sysDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            /* Called when drawer is closed */
            public void onDrawerClosed(View argDrawerView) {
                //Put your code here
                //invalidateOptionsMenu();
                super.onDrawerClosed(argDrawerView);
            }

            /* Called when a drawer is opened */
            public void onDrawerOpened(View argDrawerView) {
                //Put your code here
                //invalidateOptionsMenu();
                super.onDrawerOpened(argDrawerView);
            }
        };
        actionBarDrawerToggle.syncState();
        sysDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        //|------------------------------------------------------------|
        if (savedInstanceState == null) {
            onDisplayDrawerItem(0);
        }
        //|------------------------------------------------------------|
    }

    //|------------------------------------------------------------|
    public boolean onOptionsItemSelected(MenuItem argItem) {
        if (actionBarDrawerToggle.onOptionsItemSelected(argItem)) {
            return true;
        }
        return false;
    }

    //|------------------------------------------------------------|
    private class OnDrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> argParent, View view, int argPosition, long argId) {
            onDisplayDrawerItem(argPosition);
        }
    }

    @Override
    public void onBackPressed() {
        if (sysDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            sysDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

    //|------------------------------------------------------------|
    private void onDisplayDrawerItem(int argPosition) {
        Fragment fragment = null;
        Bundle bundle = null;
        bundle = new Bundle();
        String toolbarTitle = modelNavDrawerListItems.get(argPosition).getNavTitle();
        if (argPosition == 0) {
            fragment = new FragHome();
        } else if (argPosition == 1) {
            fragment = new FragTutorial();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (bundle == null) {
                bundle = new Bundle();
            }
            fragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.sysFrameContainer, fragment);
            fragmentTransaction.commit();

            // update selected item and title, then close the drawer
            sysDrawerList.setItemChecked(argPosition, true);
            sysDrawerList.setSelection(argPosition);
            getSupportActionBar().setTitle(toolbarTitle);
        } else {
            // error in creating fragment
            Log.e("Dashboard", "Error in creating fragment");
        }
        sysDrawerList.setItemChecked(argPosition, true);
        sysDrawerLayout.closeDrawer(sysDrawerList);
    }
    //|------------------------------------------------------------|
}
