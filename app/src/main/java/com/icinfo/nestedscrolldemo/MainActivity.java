package com.icinfo.nestedscrolldemo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.icinfo.nestedscrolldemo.base.AppBaseActivity;
import com.icinfo.nestedscrolldemo.base.BaseActivity;
import com.icinfo.nestedscrolldemo.base.IBasePresenter;
import com.icinfo.nestedscrolldemo.module.ForumDetailListActivity;
import com.icinfo.nestedscrolldemo.ui.discover.DiscoverFragment;
import com.icinfo.nestedscrolldemo.ui.home.HomeFragment;
import com.icinfo.nestedscrolldemo.ui.mine.MineFragment;
import com.icinfo.nestedscrolldemo.ui.nearby.NearbyFragment;
import com.icinfo.nestedscrolldemo.ui.order.OrderFragment;
import com.icinfo.nestedscrolldemo.widget.CustomBottomTabWidget;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private List<Fragment> fragmentList;

    @Override
    public void onClick(View v) {

        startActivity(new Intent(this, ForumDetailListActivity.class));
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        CustomBottomTabWidget viewById = findViewById(R.id.bottom_tab);
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new NearbyFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new OrderFragment());
        fragmentList.add(new MineFragment());

        viewById.init(getSupportFragmentManager(),fragmentList);
    }

    @Nullable
    @Override
    protected IBasePresenter<?> createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}