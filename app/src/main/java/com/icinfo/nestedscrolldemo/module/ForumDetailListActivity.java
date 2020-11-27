package com.icinfo.nestedscrolldemo.module;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.icinfo.nestedscrolldemo.R;
import com.icinfo.nestedscrolldemo.base.BaseActivity;

/**
 * @time：2020/11/25
 * @author:hugaojian
 **/
public class ForumDetailListActivity extends BaseActivity {

    private AppBarLayout appBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        setHideStatusBar(false);
        initTop();
    }

    private void initTop() {
        appBar = findViewById(R.id.app_bar);
        final View toolbarOpen = findViewById(R.id.toolbar_open);
        final View toolbarClose = findViewById(R.id.toolbar_close);
        final View bgClose = findViewById(R.id.bg_toolbar_close);
        final View bgOpen = findViewById(R.id.bg_toolbar_open);
        final View bgContent = findViewById(R.id.bg_content);
        appBar.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int offset = Math.abs(verticalOffset);//垂直方向偏移
                int scrollRange = appBarLayout.getTotalScrollRange();//最大偏移
                //滑动没超过一半
                if (offset <= scrollRange / 2) {
                    toolbarOpen.setVisibility(View.VISIBLE);
                    toolbarClose.setVisibility(View.GONE);

                    float scale = (float) offset / (scrollRange / 2);
                    int alpha = (int) (255 * scale);
                    bgOpen.setBackgroundColor(Color.argb(alpha, 25, 131, 209));
                } else {
                    toolbarOpen.setVisibility(View.GONE);
                    toolbarClose.setVisibility(View.VISIBLE);

                    float scale = (float) (scrollRange - offset) / (scrollRange / 2);
                    int alpha = (int) (255 * scale);
                    bgClose.setBackgroundColor(Color.argb(alpha, 25, 131, 209));
                }
                float scale = offset / scrollRange;
                int alpha = (int) (255 * scale);
                bgContent.setBackgroundColor(Color.argb(alpha, 25, 131, 209));

            }
        });
    }
}
