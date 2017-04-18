package com.miguan.yjy.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.miguan.yjy.R;
import com.miguan.yjy.model.bean.Test;
import com.miguan.yjy.module.test.TestRecomendPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @作者 cjh
 * @日期 2017/4/5 16:51
 * @描述
 */

public class TestListAdapter extends RecyclerArrayAdapter<Test> {


    public TestListAdapter(Context context, List<Test> objects) {
        super(context, objects);
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(mObjects.get(position));
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(parent);
    }


    class MyViewHolder extends BaseViewHolder<Test> {

        @BindView(R.id.iv_test_list)
        ImageView mIvTestList;
        @BindView(R.id.tv_test_list_name)
        TextView mTvTestListName;

        public MyViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_test_list);
            ButterKnife.bind(this, itemView);
        }


        @Override
        public void setData(Test data) {
            Glide.with(getContext()).load(data.getImg()).into(mIvTestList);
//            mIvTestList.setBackgroundResource(data.getImg());
            mTvTestListName.setText(data.getTitle());
            itemView.setOnClickListener(v -> TestRecomendPresenter.star(getContext()));
        }
    }

}