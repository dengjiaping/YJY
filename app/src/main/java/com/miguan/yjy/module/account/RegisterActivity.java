package com.miguan.yjy.module.account;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.dsk.chain.bijection.ChainBaseActivity;
import com.dsk.chain.bijection.RequiresPresenter;
import com.miguan.yjy.R;
import com.miguan.yjy.utils.LUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (c) 2017/3/30. LiaoPeiKun Inc. All rights reserved.
 */
@RequiresPresenter(RegisterPresenter.class)
public class RegisterActivity extends ChainBaseActivity<RegisterPresenter> implements TextWatcher {

    @BindView(R.id.et_account_username)
    EditText mEtUsername;

    @BindView(R.id.et_account_password)
    EditText mEtPassword;

    @BindView(R.id.et_account_captcha)
    EditText mEtCaptcha;

    @BindView(R.id.btn_account_captcha)
    Button mBtnCaptcha;

    @BindView(R.id.btn_register_submit)
    Button mBtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_activity_register);
        setToolbarTitle(R.string.btn_register);
        ButterKnife.bind(this);

        UserTextWatcher watcher = new UserTextWatcher(mBtnSubmit, mEtCaptcha, mEtPassword, mEtUsername);
        mEtUsername.addTextChangedListener(watcher);
        mEtPassword.addTextChangedListener(watcher);
        mEtCaptcha.addTextChangedListener(watcher);

        mBtnCaptcha.setOnClickListener(v -> checkCaptcha());
        mBtnSubmit.setOnClickListener(v -> checkInput());
    }

    private void checkCaptcha() {
        if (TextUtils.isEmpty(mEtUsername.getText())) {
            LUtils.toast("用户名/手机不能为空");
            return;
        }
        getPresenter().sendCaptcha(mEtUsername.getText().toString().trim());
    }

    private void checkInput() {
        if (TextUtils.isEmpty(mEtCaptcha.getText())) {
            LUtils.toast("验证码不能为空");
            return;
        }
        if (TextUtils.isEmpty(mEtPassword.getText())) {
            LUtils.toast("密码不能为空");
            return;
        }

        getPresenter().register(
                mEtUsername.getText().toString().trim(),
                mEtCaptcha.getText().toString().trim(),
                mEtPassword.getText().toString().trim()
        );
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        boolean enabled = !TextUtils.isEmpty(mEtUsername.getText()) && TextUtils.isEmpty(mEtCaptcha.getText())
                && TextUtils.isEmpty(mEtPassword.getText());
        mBtnSubmit.setEnabled(enabled);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
