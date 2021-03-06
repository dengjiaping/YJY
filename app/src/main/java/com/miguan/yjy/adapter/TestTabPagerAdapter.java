package com.miguan.yjy.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.miguan.yjy.model.bean.Skin;
import com.miguan.yjy.module.test.TestTabFragment;

import java.util.List;

/**
 * @作者 cjh
 * @日期 2017/4/6 11:50
 * @描述
 */

public class TestTabPagerAdapter extends FragmentStatePagerAdapter{

    Context mContext;
    int type;
    List<Skin> mTests;
    public TestTabPagerAdapter(FragmentManager fm, Context context,int type, List<Skin>list) {
        super(fm);
        mContext = context;
        this.type = type;
        mTests = list;
    }

    @Override
    public Fragment getItem(int position) {
       TestTabFragment testTabFragment= new TestTabFragment();
        testTabFragment.setGetPosition(new TestTabFragment.GetPosition() {
            @Override
            public void getCurPricePostion() {

            }
        });
        return testTabFragment;
    }

    @Override
    public int getCount() {
        return mTests.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTests.get(position).getName();
    }
}
