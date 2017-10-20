package com.samanlan.passwordwarehouse.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;

import com.andrognito.patternlockview.PatternLockView;
import com.samanlan.passwordwarehouse.AddActivity;
import com.samanlan.passwordwarehouse.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;
import static com.samanlan.passwordwarehouse.Config.SP_NAME;

/**
 * Author：zixin on 2017/10/20 16:39
 * E-mail：lanshenming@linghit.com
 * Desc：
 */

public class PwdDialog extends Dialog {

    @BindView(R.id.pattern_lock_view)
    PatternLockView patternLockView;
    @BindView(R.id.cancel_action)
    PatternLockView btnCancel;
    @BindView(R.id.ok_action)
    PatternLockView btnOk;
    private int type = 0;

    public PwdDialog(@NonNull Context context) {
        super(context);
    }

    public PwdDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pwd);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.cancel_action, R.id.ok_action})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel_action:
                if (type == 0) {
                    dismiss();
                    ((Activity) view.getContext()).finish();
                } else {
                    dismiss();
                }
                break;
            case R.id.ok_action:
                SharedPreferences sp = view.getContext().getSharedPreferences(SP_NAME, MODE_PRIVATE);
                break;
            default:
        }
    }
}
