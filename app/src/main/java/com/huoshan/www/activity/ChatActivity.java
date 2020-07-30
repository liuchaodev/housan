package com.huoshan.www.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.huoshan.www.R;

public class ChatActivity extends Activity implements View.OnClickListener {

    private ImmersionBar mImmersionBar;
    private ImageView mIVBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
    }

    private void init(){
        initStatusBar();
        initComponent();
        initListener();
    }

    private void initListener() {
        mIVBack.setOnClickListener(this);
    }

    private void initStatusBar(){
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f);
        mImmersionBar.statusBarDarkFont(true);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }

    private void initComponent(){
        mIVBack = findViewById(R.id.act_chat_iv_back);
    }

    @Override
    protected void onDestroy() {
        mImmersionBar.destroy();
        super.onDestroy();

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
