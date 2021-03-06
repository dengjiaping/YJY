package com.miguan.yjy.module.product;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dsk.chain.bijection.RequiresPresenter;
import com.dsk.chain.expansion.data.BaseDataActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.miguan.yjy.R;
import com.miguan.yjy.adapter.BrandPagerAdapter;
import com.miguan.yjy.model.bean.Brand;
import com.miguan.yjy.utils.StringUtils;
import com.miguan.yjy.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.miguan.yjy.R.mipmap.ic_product_detail_record_down;
import static com.miguan.yjy.R.mipmap.ic_product_detail_up;

/**
 * @作者 cjh
 * @日期 2017/5/18 10:44
 * @描述
 */
@RequiresPresenter(BrandMainPresenter.class)
public class BrandMainActivity extends BaseDataActivity<BrandMainPresenter, Brand> {

    @BindView(R.id.sdv_brand_img)
    SimpleDraweeView mSdvBrandImg;
    @BindView(R.id.tv_brand_name)
    TextView mTvBrandName;
    @BindView(R.id.tv_brand_num)
    TextView mTvBrandNum;
    @BindView(R.id.tv_brand_brief)
    TextView mTvBrandBrief;

    @BindView(R.id.id_stickynavlayout_tab)
    TabLayout mTabProductBrand;

    @BindView(R.id.id_stickynavlayout_viewpager)
    NoScrollViewPager mVpBrand;

    BrandPagerAdapter mBrandPagerAdapter;
    @BindView(R.id.iv_brand_show)

    ImageView mIvBrandShow;
    @BindView(R.id.tv_brand_brief_show)

    TextView mTvBrandBriefShow;
    @BindView(R.id.toolbar_title)

    TextView mToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ll_brand_show)
    LinearLayout mLlBrandShow;

    private int tag = 0;
    private int isShowArticle;
    private int isShowStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_brand_main_activity);
        ButterKnife.bind(this);
    }

    @Override
    public void setData(Brand brand) {
        mSdvBrandImg.setImageURI(Uri.parse(StringUtils.getEncodeUrl(brand.getImg())));
        mTvBrandName.setText(brand.getName());
        setToolbarTitle(brand.getName());
        String num = "品牌热度 : <font color=\"#32DAC3\">" + brand.getHot() + "</font>";
        mTvBrandNum.setText(Html.fromHtml(num));
        mTvBrandBrief.setText(brand.getDescription());
        mTvBrandBriefShow.setText(brand.getDescription());
        if (getPresenter().mArticles.size() != 0) {
            isShowArticle = 1;
        } else {
            isShowArticle = 0;
        }
        if (brand.getIs_top() == 0) {
            isShowStart = 0;
        } else {
            isShowStart = 1;
        }

        mVpBrand.setNoScroll(true);
        mBrandPagerAdapter = new BrandPagerAdapter(getSupportFragmentManager(), isShowArticle,isShowStart, brand.getId());
        mVpBrand.setAdapter(mBrandPagerAdapter);
        mTabProductBrand.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabProductBrand.setupWithViewPager(mVpBrand);
        mLlBrandShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag == 0) {
                    tag = 1;
                    mTvBrandBriefShow.setVisibility(View.VISIBLE);
                    mTvBrandBrief.setVisibility(View.GONE);
                    mIvBrandShow.setBackgroundResource(ic_product_detail_up);
                } else {
                    tag = 0;
                    mTvBrandBrief.setVisibility(View.VISIBLE);
                    mTvBrandBriefShow.setVisibility(View.GONE);
                    mIvBrandShow.setBackgroundResource(ic_product_detail_record_down);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    lp.gravity = Gravity.BOTTOM;
                    mIvBrandShow.setLayoutParams(lp);
                }
            }
        });

    }

}

