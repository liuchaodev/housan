package com.huoshan.www.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.huoshan.www.R;
import com.huoshan.www.util.ImageUtil;

public class HeaderImageActivity extends Activity implements View.OnClickListener {



    private ImmersionBar mImmersionBar;
    private RelativeLayout mRLRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_image);
        init();
    }


    private void init(){
        initStatusBar();
        initComponent();
        initListener();
    }

    private void initListener() {
        mRLRoot.setOnClickListener(this);
    }

    private void initComponent(){
        mRLRoot = findViewById(R.id.act_header_rl_root);
    }


    private void initStatusBar(){
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f);
        mImmersionBar.statusBarDarkFont(true);
        mImmersionBar.init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.act_header_rl_root:
                finishAfterTransition();
                break;
        }
    }
}
