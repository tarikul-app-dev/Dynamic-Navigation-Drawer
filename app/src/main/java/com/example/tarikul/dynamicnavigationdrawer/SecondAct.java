package com.example.tarikul.dynamicnavigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class SecondAct extends NavigationDrawerAct {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        removeToolbar();
        setupDrawer();
        initViews();
    }

    public void initViews(){
        drawerLayout = (DrawerLayout) findViewById(R.id.app_drawer);
        ImageView menuIcon = (ImageView) findViewById(R.id.drawer_menuIcon);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!drawerLayout.isDrawerOpen(Gravity.LEFT))
                    drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }
}
