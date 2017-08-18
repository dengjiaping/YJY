package com.miguan.yjy.module.main;

import com.dsk.chain.expansion.data.BaseDataFragmentPresenter;
import com.miguan.yjy.model.bean.Test;
import com.miguan.yjy.model.local.UserPreferences;
import com.miguan.yjy.utils.LUtils;
import com.miguan.yjy.widget.ShareBottomDialog;

/**
 * @作者 cjh
 * @日期 2017/6/5 17:30
 * @描述
 */

public class SkinTestFragmentPresenter extends BaseDataFragmentPresenter<SkinTestFragment1, Test> {

    /**
     * 肤质测试分享
     */
    public void share() {
        String url = "http://m." + (LUtils.isDebug ? "beta." : "") + "yjyapp.com/site/skin-share?user_id=";
        new ShareBottomDialog.Builder(getView().getActivity())
                .setTitle("护肤界的16种肤质，你知道你是哪种吗?")
                .setUrl(url + UserPreferences.getUserID())//等待地址替换
                .setContent("搞不清楚肤质就护肤？测清楚总不会错！")
                .setWxCircleTitle("What？！活了20+年才搞清楚自己，原来是这种肤质！")
                .setWbContent("护肤界的16种肤质，你知道你是哪种吗？#颜究院APP#" + url + UserPreferences.getUserID())//等待地址替换
                .setType(3)
                .show();
    }

}
