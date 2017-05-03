package com.miguan.yjy.module.template;

import android.net.Uri;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.miguan.yjy.R;
import com.miguan.yjy.model.bean.Product;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Copyright (c) 2017/4/5. LiaoPeiKun Inc. All rights reserved.
 */

public class Template4ViewHolder extends BaseTemplateViewHolder {

//    @BindView(R.id.fl_template_0_image)
//    FrameLayout mFlImage;
//
//    @BindView(R.id.dv_template_0_image)
//    SimpleDraweeView mDvImage;
//
//    @BindView(R.id.tv_template_4_desc)
//    TextView mTvDesc;
//
//    @BindView(R.id.iv_template_0_filter)
//    ImageView mIvFilter;

    private Uri mUri;

    private PipelineDraweeController mController;

    public Template4ViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_list_template_4);
        EventBus.getDefault().register(this);
    }

    @Override
    public void setData(Product data) {
//        mDvImage.setOnClickListener(v -> ImageProvider.getInstance((Activity) getContext()).getImageFromCameraOrAlbum(this));
//        if (mController != null) mDvImage.setController(mController);
    }

    @Override
    public void onImageLoaded(Uri uri) {
//        mIvFilter.setVisibility(View.VISIBLE);
//        mIvFilter.setOnClickListener(v -> FilterActivity.start((AppCompatActivity) getContext(), uri, this));
//        mDvImage.setImageURI(uri);
//        mUri = uri;
    }

    @Override
    public void onFilterSelected(ImageRequest request) {
//        mController = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
//                .setImageRequest(request)
//                .setTapToRetryEnabled(true)
//                .setOldController(mDvImage.getController())
//                .build();
//
//        mDvImage.setController(mController);
    }
//
//    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setFilter(Postprocessor processor) {
//        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(mUri)
//                .setPostprocessor(processor)
//                .build();
//
//        mController = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
//                .setOldController(mDvImage.getController())
//                .setImageRequest(request)
//                .build();
//
//        mDvImage.setController(mController);
    }

}
