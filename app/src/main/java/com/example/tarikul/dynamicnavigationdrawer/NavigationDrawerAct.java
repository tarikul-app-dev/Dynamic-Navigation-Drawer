package com.example.tarikul.dynamicnavigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class NavigationDrawerAct extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.drawer_default);
        drawerLayout = (DrawerLayout) findViewById(R.id.app_drawer);

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // We inflate the sent layout
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.app_container);
        frameLayout.addView(inflater.inflate(R.layout.layout_container, null, false));

        FrameLayout appFrame = (FrameLayout) findViewById(R.id.app_content);
        appFrame.addView(inflater.inflate(layoutResID, null, false));

    }

    public void setupDrawer() {

//        if(userName!=null && userName.length()>0){
//            txvUserName.setText(userName);
//        }
        LinearLayout allInputData = (LinearLayout) findViewById(R.id.drawer_all_input_data);
        allInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), NavigationDrawerAct.class);
                startActivity(i);
            }
        });
        LinearLayout offlineData = (LinearLayout) findViewById(R.id.drawer_offline_data);
        offlineData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), NavigationDrawerAct.class);
                startActivity(i);
            }
        });

        LinearLayout allExistData = (LinearLayout) findViewById(R.id.drawer_exist_data);
        allExistData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), NavigationDrawerAct.class);
                startActivity(i);
            }
        });




    }


    @Override
    protected void onResume() {
        // Close drawer on activity result
        if (drawerLayout.isDrawerOpen(Gravity.LEFT))
            drawerLayout.closeDrawer(Gravity.LEFT, false);

        super.onResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { // We close the drawer if the user press back
            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    public void removeToolbar() {
        RelativeLayout bar = (RelativeLayout) findViewById(R.id.toolbar_container);
        bar.setVisibility(View.GONE);
    }

    /**
     * Change the toolbar title
     * @param title
     */
    public void setToolbarTitle(String title) {
//        TextView barTitle = (TextView) findViewById(R.id.toolbar_title);
//        barTitle.setText(title);
    }
    /**
     * Change the toolbar title
     * @param title
     */
    public void setToolbarTitle(@StringRes int title) {
//        TextView barTitle = (TextView) findViewById(R.id.toolbar_title);
//        barTitle.setText(title);
    }

    /**
     * Give you the possibility to disable the shadow under the toolbar
     * @param state
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setToolbarShadowVisibility(boolean state) {
        RelativeLayout bar = (RelativeLayout) findViewById(R.id.toolbar_container);
        if (state)
            bar.setElevation(4);
        else
            bar.setElevation(0);
    }
}
