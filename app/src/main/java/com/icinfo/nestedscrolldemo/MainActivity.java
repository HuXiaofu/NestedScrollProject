package com.icinfo.nestedscrolldemo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.icinfo.nestedscrolldemo.base.BaseActivity;
import com.icinfo.nestedscrolldemo.base.BaseFragment;
import com.icinfo.nestedscrolldemo.module.ForumDetailListActivity;
import com.icinfo.nestedscrolldemo.ui.discover.DiscoverFragment;
import com.icinfo.nestedscrolldemo.ui.home.HomeFragment;
import com.icinfo.nestedscrolldemo.ui.mine.MineFragment;
import com.icinfo.nestedscrolldemo.ui.nearby.NearbyFragment;
import com.icinfo.nestedscrolldemo.ui.order.OrderFragment;
import com.icinfo.nestedscrolldemo.widget.CustomBottomTabWidget;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private List<BaseFragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomBottomTabWidget viewById = findViewById(R.id.bottom_tab);
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new NearbyFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new OrderFragment());
        fragmentList.add(new MineFragment());

        viewById.init(getSupportFragmentManager(),fragmentList);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        findViewById(R.id.my_title).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(this, ForumDetailListActivity.class));
    }
}