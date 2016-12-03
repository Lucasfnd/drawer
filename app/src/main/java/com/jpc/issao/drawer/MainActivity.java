package com.jpc.issao.drawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter <String> listAdapter;
    String fragmentArray [] = {"LAYOUT_1", "LAYOUT_2"};
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, fragmentArray);
        listView.setAdapter(listAdapter);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                switch (position){
                    case 0:
                        fragment = new FragmentOne();
                                break;
                    case 1:
                        fragment = new FragmentTwo();
                                break;
                    default:
                        fragment = new FragmentOne();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit();
                drawerLayout.closeDrawers();
            }
        });
    }
}
