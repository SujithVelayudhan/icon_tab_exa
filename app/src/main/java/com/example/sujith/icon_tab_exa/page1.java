package com.example.sujith.icon_tab_exa;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class page1 extends AppCompatActivity {

    Toolbar tools;
    TabLayout tab_lay;
    ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });

        tools=findViewById(R.id.tool_bar);
        tools.setTitle("Whatsss uppp");
        setSupportActionBar(tools);

        view_pager=findViewById(R.id.view_pager);
        setup_view(view_pager);

        tab_lay=findViewById(R.id.tab_layout);
        tab_lay.setupWithViewPager(view_pager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.opt,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setup_view(ViewPager view_pager)
    {
        ViewPagerAdapter adapt=new ViewPagerAdapter(getSupportFragmentManager());
        adapt.addFragment(new chats(),"CHATS");
        adapt.addFragment(new status(),"STATUS");
        adapt.addFragment(new calls(),"CALLS");

        view_pager.setAdapter(adapt);


    }

    private class ViewPagerAdapter extends FragmentPagerAdapter
    {
        List<Fragment> mfraglist=new ArrayList<>();
        List<String> mfragtitle=new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mfraglist.get(i);
        }

        @Override
        public int getCount() {
            return mfraglist.size();
        }

        public void addFragment(Fragment f,String title)
        {
            mfraglist.add(f);
            mfragtitle.add(title);

        }

        public CharSequence getPageTitle(int position)
        {
            return mfragtitle.get(position);
        }
    }
}
