package com.miguan.yjy.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.miguan.yjy.model.bean.Test;
import com.miguan.yjy.module.test.SkinGuideFragment;
import com.miguan.yjy.module.test.SkinReadFragment;
import com.miguan.yjy.module.test.SkinRecomFragment;

/**
 * @作者 cjh
 * @日期 2017/6/16 15:35
 * @描述
 */

public class SkinTestViewPager extends FragmentPagerAdapter {

    Test mTest;
    public static final String BUNDLE_TEST = "test";

    public SkinTestViewPager(FragmentManager fm, Test mTest) {
        super(fm);
        this.mTest = mTest;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Bundle bundle = new Bundle();
                SkinReadFragment skinReadFragment = new SkinReadFragment();
                bundle.putParcelable(BUNDLE_TEST, mTest);
                skinReadFragment.setArguments(bundle);
                return skinReadFragment;
            case 1:
                Bundle bundle1 = new Bundle();
                SkinRecomFragment skinRecomFragment = new SkinRecomFragment();
                bundle1.putParcelable(BUNDLE_TEST, mTest);
                skinRecomFragment.setArguments(bundle1);
                return skinRecomFragment;
            case 2:
                Bundle bundle2 = new Bundle();
                SkinGuideFragment skinGuideFragment = new SkinGuideFragment();
                bundle2.putParcelable(BUNDLE_TEST, mTest);
                skinGuideFragment.setArguments(bundle2);
                return skinGuideFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "肤质解读";
            case 1:
                return "推荐产品";
            case 2:
                return "护肤指南";

        }
        return super.getPageTitle(position);
    }
}