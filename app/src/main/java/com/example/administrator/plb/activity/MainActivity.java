package com.example.administrator.plb.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.example.administrator.plb.R;
import com.example.administrator.plb.adapter.FragmentAdapter;
import com.example.administrator.plb.fragment.ActionFragment;
import com.example.administrator.plb.fragment.ContactsFragment;
import com.example.administrator.plb.fragment.EyeFragment;
import com.example.administrator.plb.fragment.InformFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageView tour;
    private ViewPager viewPager;
    private BottomNavigationView bottomView;
    private FragmentAdapter adapter;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private RelativeLayout right;
    private NavigationView left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(menuItemClickListener);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        toggle.syncState();
    }

    private void initView() {
//        tour = (ImageView) findViewById(R.id.tour);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        bottomView = (BottomNavigationView) findViewById(R.id.bottomView);
        drawer = findViewById(R.id.drawer);
        right = findViewById(R.id.right);
        toolbar = findViewById(R.id.toolbar);
        left=findViewById(R.id.navigation);
    }

    private void initData() {
        List<Fragment>list=new ArrayList<>();
        list.add(new InformFragment());
        list.add(new ContactsFragment());
        list.add(new EyeFragment());
        list.add(new ActionFragment());
        adapter=new FragmentAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(listener);
        bottomView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        drawer.addDrawerListener(drawerListener);
    }
    private DrawerLayout.DrawerListener drawerListener=new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View view, float v) {
            right.layout(left.getRight(),0,left.getRight()+right.getWidth(),right.getHeight());
        }

        @Override
        public void onDrawerOpened(@NonNull View view) {

        }

        @Override
        public void onDrawerClosed(@NonNull View view) {

        }

        @Override
        public void onDrawerStateChanged(int i) {

        }
    };
    private Toolbar.OnMenuItemClickListener menuItemClickListener=new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            return true;
        }
    };
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.inform:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.contacts:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.video:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.action:
                    viewPager.setCurrentItem(3);
                    break;
            }
            return true;
        }
    };


    private ViewPager.OnPageChangeListener listener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }
        @Override
        public void onPageSelected(int i) {
            switch (i){
                case 0:
                    bottomView.setSelectedItemId(R.id.inform);
                    break;
                case 1:
                    bottomView.setSelectedItemId(R.id.contacts);
                    break;
                case 2:
                    bottomView.setSelectedItemId(R.id.video);
                    break;
                case 3:
                    bottomView.setSelectedItemId(R.id.action);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

}
