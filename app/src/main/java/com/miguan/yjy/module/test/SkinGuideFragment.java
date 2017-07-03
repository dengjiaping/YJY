package com.miguan.yjy.module.test;

import android.view.ViewGroup;

import com.dsk.chain.bijection.RequiresPresenter;
import com.dsk.chain.expansion.list.BaseListFragment;
import com.dsk.chain.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.miguan.yjy.adapter.viewholder.ArticleViewHolder;
import com.miguan.yjy.model.bean.Article;

/**
 * @作者 cjh
 * @日期 2017/6/21 14:33
 * @描述
 */
@RequiresPresenter(SkinGuideFragmentPresenter.class)
public class SkinGuideFragment extends BaseListFragment<SkinGuideFragmentPresenter,Article> {
    @Override
    public BaseViewHolder<Article> createViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(parent);
    }

    @Override
    public ListConfig getListConfig() {
        return super.getListConfig().setRefreshAble(false);
    }
}