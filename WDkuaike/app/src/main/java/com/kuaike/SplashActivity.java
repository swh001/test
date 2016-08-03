package com.kuaike;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.kuaike.activity.ActivityHomePage;
import com.kuaike.base.BaseActivity;
import com.kuaike.wdkuaike.R;


/**
 * Created by Administrator on 2016/7/28.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new myThread(), 1000);
    }

    public class myThread implements Runnable {
        @Override
        public void run() {
            {
                Intent intent = new Intent(SplashActivity.this, ActivityHomePage.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }
    }
}
