package com.huoshan.www.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.huoshan.www.R;
import com.huoshan.www.util.ImageUtil;

public class VideoDetailActivity extends Activity {

    private ImmersionBar mImmersionBar;
    private ImageView mIVVideoImage;
    private int mPlayImageRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        init();
    }


    private void init(){
        initStatusBar();
        initComponent();

    }

    private void initComponent() {
        mPlayImageRes = getIntent().getIntExtra("playImage",0);
        mIVVideoImage = findViewById(R.id.act_video_detail_image);
        mIVVideoImage.setImageResource(mPlayImageRes);
       // ImageUtil.loadImageUrl("http://www.4zlink.com/sdk/1.jpeg",mIVVideoImage,R.mipmap.loading,R.mipmap.loading);
    }

    private void initStatusBar(){
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f);
        mImmersionBar.statusBarDarkFont(true);
        mImmersionBar.init();
    }
}
