package com.icinfo.nestedscrolldemo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.icinfo.nestedscrolldemo.base.BaseActivity;
import com.icinfo.nestedscrolldemo.module.ForumDetailListActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        findViewById(R.id.my_title).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ForumDetailListActivity.class));
    }
}