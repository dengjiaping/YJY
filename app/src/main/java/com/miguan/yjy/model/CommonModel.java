package com.miguan.yjy.model;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.format.DateUtils;

import com.dsk.chain.bijection.ChainBaseActivity;
import com.dsk.chain.model.AbsModel;
import com.miguan.yjy.R;
import com.miguan.yjy.dialogs.BaseAlertDialog;
import com.miguan.yjy.model.bean.Discover;
import com.miguan.yjy.model.bean.Home;
import com.miguan.yjy.model.bean.Result;
import com.miguan.yjy.model.bean.User;
import com.miguan.yjy.model.bean.Version;
import com.miguan.yjy.model.constant.Constants;
import com.miguan.yjy.model.local.UserPreferences;
import com.miguan.yjy.model.services.DefaultTransform;
import com.miguan.yjy.model.services.ServicesClient;
import com.miguan.yjy.module.common.DownloadService;
import com.miguan.yjy.utils.LUtils;

import rx.Observable;
import rx.Subscriber;

/**
 * Copyright (c) 2017/1/13. LiaoPeiKun Inc. All rights reserved.
 */

public class CommonModel extends AbsModel {

    public static CommonModel getInstance() {
        return getInstance(CommonModel.class);
    }

    /**
     * 首页
     */
    public Observable<Home> getHomeList() {
        return ServicesClient.getServices().home(UserPreferences.getToken()).compose(new DefaultTransform<>());
    }

    /**
     * 发现
     */
    public Observable<Discover> getDiscover() {
        return ServicesClient.getServices().discover(UserPreferences.getToken()).compose(new DefaultTransform<>());
    }

    /**
     * 提示更新
     * @param context
     */
    public void update(Context context) {
        ServicesClient.getServices().checkUpdate()
                .compose(new DefaultTransform<>())
                .subscribe(new Subscriber<Version>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Version version) {
                        if (version.getIsMust() == 1 &&
                                !version.getNumber().equals(LUtils.getAppVersionName())) {
                            showUpdateDialog(context, version);
                        } else {
                            checkBindMobile(context);
                        }
                    }
                });
    }

    public Observable<Version> checkCurVersion(Context context) {
        return ServicesClient.getServices().checkUpdate().compose(new DefaultTransform<>());
    }

    public void checkUpdate(Context context) {
        ServicesClient.getServices().checkUpdate()
                .compose(new DefaultTransform<>())
                .subscribe(new Subscriber<Version>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Version version) {
                        if (version.getType() == 0) {
                            LUtils.toast("已经是最新版本了");
                        } else if (version.getIsMust() == 1 &&
                                !version.getNumber().equals(LUtils.getAppVersionName())) {
                            showUpdateDialog(context, version);
                        }
                    }
                });
    }

    private void showUpdateDialog(Context context, Version version) {
        if (version.getContent().length != 0) {
            new AlertDialog.Builder(context)
                    .setTitle("新版本发布啦~" + version.getNumber())
                    .setMessage(Html.fromHtml(getContent(version.getContent())))
                    .setNegativeButton("取消", null)
                    .setPositiveButton("立即更新", (dialog, which) -> {
                        LUtils.log("开始下载");
                        Intent intent = new Intent(context, DownloadService.class);
                        intent.putExtra("title", "正在下载" + context.getString(R.string.app_name));
                        intent.putExtra("url", version.getDownloadUrl());
                        intent.putExtra("path", findDownLoadDirectory());
                        intent.putExtra("name", "YJY" + System.currentTimeMillis() + ".apk");
                        context.startService(intent);
                    })
                    .show();
        }
    }

    private void checkBindMobile(Context context) {
        if (AccountModel.getInstance().isLogin()
                && !DateUtils.isToday(LUtils.getPreferences().getLong(Constants.KEY_CHECK_IS_BIND_TIME, 0))) {
            ServicesClient.getServices().isBind(UserPreferences.getToken())
                    .compose(new DefaultTransform<>())
                    .subscribe(new Subscriber<Integer>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                        }

                        @Override
                        public void onNext(Integer result) {
                            if (result == 2) {
                                BaseAlertDialog dialog = BaseAlertDialog.newInstance(R.layout.dialog_not_bind_mobile, context);
                                dialog.setCancelable(false);
                                dialog.show(((ChainBaseActivity) context).getSupportFragmentManager(), "bindDialog");
                            }
                        }
                    });
        }
    }

    public Observable<User> getUnreadMsg() {
        return ServicesClient.getServices().unreadMsg(UserPreferences.getToken())
                .doOnNext(this::saveMsg)
                .compose(new DefaultTransform<>());
    }

    public Observable<String> setMsgRead(int msgId, String type) {
        return ServicesClient.getServices().setMsgRead(UserPreferences.getToken(), msgId, type).compose(new DefaultTransform<>());
    }

    /**
     * 统计BANNER点击数
     *
     * @return
     */
    public Observable<String> analyticsBanner(int bannerId) {
        return ServicesClient.getServices().analyticsBanner(UserPreferences.getToken(), bannerId).compose(new DefaultTransform<>());
    }

    /**
     * 统计分享数
     *
     * @return
     */
    public Observable<String> analyticsShare(int id, int type) {
        return ServicesClient.getServices().analyticsShare(UserPreferences.getToken(), id, type).compose(new DefaultTransform<>());
    }

    /**
     * 统计模板生成
     *
     * @return
     */
    public Observable<String> analyticsTemplate() {
        return ServicesClient.getServices().analyticsTemplate(UserPreferences.getToken()).compose(new DefaultTransform<>());
    }

    /**
     * 分享加颜值
     *
     * @return
     */
    public Observable<Result> addScoreForShare() {
        return ServicesClient.getServices().addScoreForShare(UserPreferences.getToken()).compose(new DefaultTransform<>());
    }

    private String findDownLoadDirectory() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        } else {
            return Environment.getRootDirectory() + "/" + "download/";
        }
    }

    private String getContent(String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            builder.append(i == strings.length - 1 ? strings[i] : strings[i] + "<br>");
        }
        return builder.toString();
    }

    private void saveMsg(User user) {
        UserPreferences.setUnreadMsg(user.getUnReadNUM());
        UserPreferences.setOverdueNum(user.getOverdueNum());
    }

}
