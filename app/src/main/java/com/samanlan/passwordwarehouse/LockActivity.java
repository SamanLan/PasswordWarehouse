package com.samanlan.passwordwarehouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.gcssloop.encrypt.oneway.MD5Util;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.samanlan.passwordwarehouse.Config.SALT;
import static com.samanlan.passwordwarehouse.Config.SP_NAME;

public class LockActivity extends AppCompatActivity {

    @BindView(R.id.pattern_lock_view)
    PatternLockView patternLockView;
    /**
     * 图形密码
     */
    String pwdImg;
    /**
     * 数字密码
     */
    String pwdNum;

    int errorTimes;
    /**
     * 错误上限值
     */
    final int ERROR_CEILING = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        ButterKnife.bind(this);
        patternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {

            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                if (MD5Util.md5(PatternLockUtils.patternToString(patternLockView, pattern), SALT).equals(pwdImg)) {
                    startActivity(new Intent(LockActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LockActivity.this, "错啦错啦", Toast.LENGTH_SHORT).show();
                    errorTimes++;
                    if (errorTimes >= ERROR_CEILING) {

                    }
                }
            }

            @Override
            public void onCleared() {

            }
        });
        SharedPreferences sp = getSharedPreferences(SP_NAME, MODE_PRIVATE);
        pwdImg = sp.getString("pwdImg", MD5Util.md5("0125", SALT));
        pwdNum = sp.getString("pwdNum", "");
        if (TextUtils.isEmpty(pwdImg)) {
            setUserPwd(sp);
        }
    }

    /**
     * 用户初始化密码
     * @param sp sp
     */
    private void setUserPwd(SharedPreferences sp) {

    }
}
