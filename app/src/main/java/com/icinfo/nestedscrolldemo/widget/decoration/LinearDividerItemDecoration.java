package com.icinfo.nestedscrolldemo.widget.decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icinfo.nestedscrolldemo.utils.DesityUtils;

/**
 * @time：2020/12/1
 * @author:hugaojian
 **/
public class LinearDividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int DEFAULT_HEIGHT = 1;
    private ColorDrawable mDivider;
    private Builder builder;

    private LinearDividerItemDecoration(Builder builder) {
        mDivider = new ColorDrawable(Color.GRAY);
        mDivider.setColor(builder.dividerColor);

        this.builder = builder;
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        c.save();
        int left, right, top, bottom;
        int leftMargin, rightMargin, topMargin, bottomMargin, height;

        int count = parent.getChildCount();
        if (!builder.isShowLastDivider) {
            count -= 1;
        }

        for (int i = 0; i < count; i++) {
            final View child = parent.getChildAt(i);
            int transitionX = (int) ViewCompat.getTranslationX(child);
            int transitionY = (int) ViewCompat.getTranslationY(child);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            if (i == count - 1 && builder.lastDividerHeight > 0) {
                leftMargin = builder.lastLeftMargin;
                rightMargin = builder.lastRightMargin;
                topMargin = builder.lastTopMargin;
                bottomMargin = builder.lastBottomMargin;
                height = builder.lastDividerHeight;
                if (builder.lastDividerColor != 0) {
                    mDivider.setColor(builder.lastDividerColor);
                }
            } else {
                leftMargin = builder.leftMargin;
                rightMargin = builder.rightMargin;
                topMargin = builder.topMargin;
                bottomMargin = builder.bottomMargin;
                height = builder.dividerHeight;
                mDivider.setColor(builder.dividerColor);
            }

            if (builder.orientation == LinearLayoutManager.VERTICAL) {
                left = child.getLeft() - params.leftMargin + transitionX + DesityUtils.INSTANCE.dip2px(leftMargin);
                top = child.getBottom() + params.bottomMargin;
                right = child.getRight() + params.rightMargin - DesityUtils.INSTANCE.dip2px(rightMargin);
                bottom = top + height + transitionY;
            } else {
                top = child.getTop() - params.topMargin + DesityUtils.INSTANCE.dip2px(topMargin);
                bottom = child.getBottom() + params.bottomMargin + transitionY - DesityUtils.INSTANCE.dip2px(bottomMargin);
                left = child.getRight() + params.rightMargin + transitionX;
                right = left + height;
            }

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
        c.restore();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        int itemCount = parent.getAdapter().getItemCount();
        if (!builder.isShowLastDivider && position == itemCount - 1) {
            return;
        }

        int height;

        if (position == itemCount - 1) {
            height = builder.lastDividerHeight;
        } else {
            height = builder.dividerHeight;
        }

        if (builder.orientation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0, 0, height);
        } else {
            outRect.set(0, 0, height, 0);
        }
    }


    public static class Builder {
        private int dividerHeight = DEFAULT_HEIGHT;
        private int dividerColor = Color.GRAY;
        private int orientation = LinearLayoutManager.VERTICAL;
        private int leftMargin, rightMargin, topMargin, bottomMargin;
        private boolean isShowLastDivider = true;
        private int lastDividerHeight = 0;
        private int lastDividerColor = 0;
        private int lastLeftMargin;
        private int lastRightMargin;
        private int lastTopMargin;
        private int lastBottomMargin;

        public Builder setDividerHeight(int dividerHeight) {
            this.dividerHeight = dividerHeight;
            return this;
        }

        public Builder setDividerColor(@ColorInt int color) {
            this.dividerColor = color;
            return this;
        }

        public Builder setOrientation(@RecyclerView.Orientation int orientation) {
            this.orientation = orientation;
            return this;
        }

        public Builder setLeftMargin(int leftMargin) {
            this.leftMargin = leftMargin;
            return this;
        }

        public Builder setRightMargin(int rightMargin) {
            this.rightMargin = rightMargin;
            return this;
        }

        public Builder setTopMargin(int topMargin) {
            this.topMargin = topMargin;
            return this;
        }

        public Builder setBottomMargin(int bottomMargin) {
            this.bottomMargin = bottomMargin;
            return this;
        }

        public Builder isShowLastDivider(boolean flag) {
            this.isShowLastDivider = flag;
            return this;
        }

        public Builder setLastDividerHeight(int dividerHeight) {
            this.lastDividerHeight = dividerHeight;
            return this;
        }

        public Builder setLastDividerColor(int lastDividerColor) {
            this.lastDividerColor = lastDividerColor;
            return this;
        }

        public Builder setLastLeftMargin(int leftMargin) {
            this.lastLeftMargin = leftMargin;
            return this;
        }

        public Builder setLastRightMargin(int rightMargin) {
            this.lastRightMargin = rightMargin;
            return this;
        }

        public Builder setLastTopMargin(int topMargin) {
            this.lastTopMargin = topMargin;
            return this;
        }

        public Builder setLastBottomMargin(int bottomMargin) {
            this.lastBottomMargin = bottomMargin;
            return this;
        }

        public LinearDividerItemDecoration build() {
            return new LinearDividerItemDecoration(this);
        }
    }

}
