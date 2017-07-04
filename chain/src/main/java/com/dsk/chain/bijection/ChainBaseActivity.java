package com.dsk.chain.bijection;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dsk.chain.R;
import com.dsk.chain.expansion.overlay.DefaultViewExpansionDelegate;
import com.dsk.chain.expansion.overlay.ViewExpansionDelegate;

/**
 * Copyright (c) 2015. LiaoPeiKun Inc. All rights reserved.
 */
public class ChainBaseActivity<P extends Presenter> extends ChainAppCompatActivity<P> {

    private FrameLayout mContentParent;

    protected Toolbar mToolbar;

    private ViewExpansionDelegate mDelegate;

    @Override
    public void preCreatePresenter() {
        super.preCreatePresenter();
        mContentParent = (FrameLayout) findViewById(android.R.id.content);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) onSetToolbar(mToolbar);
    }

    public void onSetToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        View viewBack = mToolbar.findViewById(R.id.toolbar_back);
        if (viewBack != null) {
            viewBack.setOnClickListener(onClickListener);
        } else {
            mToolbar.setNavigationOnClickListener(onClickListener);
        }
    }

    public void setToolbarTitle(int title) {
        if (mToolbar == null) {
            return;
        }
        TextView tvTitle = (TextView) findViewById(R.id.toolbar_title);
        if (tvTitle != null) tvTitle.setText(title);
    }

    public void setToolbarTitle(String title) {
        if (mToolbar == null) {
            return;
        }
        TextView tvTitle = (TextView) findViewById(R.id.toolbar_title);
        if (tvTitle != null) tvTitle.setText(title);
    }

    public TextView getTitleView() {
        if (mToolbar == null) return null;

        TextView tvTitle = (TextView) findViewById(R.id.toolbar_title);
        if (tvTitle != null) return tvTitle;
        return null;
    }

    public FrameLayout getContent() {
        return mContentParent;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public ViewExpansionDelegate getExpansionDelegate() {
        if (mDelegate == null) mDelegate = new DefaultViewExpansionDelegate(this);
        return mDelegate;
    }

}
