package com.huoshan.www.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.huoshan.www.R;
import com.huoshan.www.adapter.RecommendPersonAdapter;
import com.huoshan.www.adapter.VideoAdapter;
import com.huoshan.www.entity.RecommendPersonEntity;
import com.huoshan.www.entity.VideoEntity;
import com.huoshan.www.util.DensityUtil;
import com.huoshan.www.view.SharePopDialog;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView mIVExpandArrow;
    private ImmersionBar mImmersionBar;
    private RecyclerView mRVImageList;
    private VideoAdapter mVideoAdapter;
    private List<VideoEntity> mVideoEntityList;
    private View mHeaderView;

    private ImageView mIVBack;
    private TextView mTVName;
    private ImageView mIVShare;
    private LinearLayout mLLTitle;
    private int mIntTotalScrollY;
    private TextView mTVFollow;
    private RelativeLayout mRLMainWork;
    private RelativeLayout mRLHeaderWork;

    private ImageView mIVHeaderImage;
    private TextView mTVHeaderFollow;
    private LinearLayout mLLMove;
    private RelativeLayout mRLHeaderRecommend;

    private boolean isOpen ;

    private RecyclerView mRVRecommendList;
    private RecommendPersonAdapter mRecommendPersonAdapter;
    private List<RecommendPersonEntity> mRecommendPersonList;
    private int mIntWorkTitleHeight;


    private TextView mTVSendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        clearFullFlag();
        initStatusBar();
        initComponent();
        initHeader();
        initListener();
        initAdapter();
        initRecyclerView();
    }


    private void initRecyclerView() {
        /********************************视频数据******************************************/
        VideoEntity videoEntity1 = new VideoEntity();
        videoEntity1.setImageRes(R.mipmap.cover1);
        videoEntity1.setImagePlayRes(R.mipmap.coverdetail1);
        videoEntity1.setThumbNum(100);
        mVideoEntityList.add(videoEntity1);

        VideoEntity videoEntity2 = new VideoEntity();
        videoEntity2.setImageRes(R.mipmap.cover2);
        videoEntity2.setThumbNum(3000);
        videoEntity2.setImagePlayRes(R.mipmap.coverdetail2);
        mVideoEntityList.add(videoEntity2);

        VideoEntity videoEntity3 = new VideoEntity();
        videoEntity3.setImageRes(R.mipmap.cover3);
        videoEntity3.setThumbNum(186);
        videoEntity3.setImagePlayRes(R.mipmap.coverdetail3);
        mVideoEntityList.add(videoEntity3);

        VideoEntity videoEntity4 = new VideoEntity();
        videoEntity4.setImageRes(R.mipmap.cover4);
        videoEntity4.setThumbNum(194);
        videoEntity4.setImagePlayRes(R.mipmap.coverdetail4);
        mVideoEntityList.add(videoEntity4);

        VideoEntity videoEntity5 = new VideoEntity();
        videoEntity5.setImageRes(R.mipmap.cover5);
        videoEntity5.setThumbNum(188);
        videoEntity5.setImagePlayRes(R.mipmap.coverdetail5);
        mVideoEntityList.add(videoEntity5);

        VideoEntity videoEntity6 = new VideoEntity();
        videoEntity6.setImageRes(R.mipmap.cover6);
        videoEntity6.setThumbNum(666);
        videoEntity6.setImagePlayRes(R.mipmap.coverdetail6);
        mVideoEntityList.add(videoEntity6);

        VideoEntity videoEntity7 = new VideoEntity();
        videoEntity7.setImageRes(R.mipmap.cover7);
        videoEntity7.setThumbNum(908);
        videoEntity7.setImagePlayRes(R.mipmap.coverdetail7);
        mVideoEntityList.add(videoEntity7);

        VideoEntity videoEntity8 = new VideoEntity();
        videoEntity8.setImageRes(R.mipmap.cover8);
        videoEntity8.setThumbNum(678);
        videoEntity8.setImagePlayRes(R.mipmap.coverdetail8);
        mVideoEntityList.add(videoEntity8);

        VideoEntity videoEntity9 = new VideoEntity();
        videoEntity9.setImageRes(R.mipmap.cover9);
        videoEntity9.setThumbNum(123);
        videoEntity9.setImagePlayRes(R.mipmap.coverdetail9);
        mVideoEntityList.add(videoEntity9);

        VideoEntity videoEntity10 = new VideoEntity();
        videoEntity10.setImageRes(R.mipmap.cover10);
        videoEntity10.setThumbNum(368);
        videoEntity10.setImagePlayRes(R.mipmap.coverdetail10);
        mVideoEntityList.add(videoEntity10);

        VideoEntity videoEntity11 = new VideoEntity();
        videoEntity11.setImageRes(R.mipmap.cover11);
        videoEntity11.setThumbNum(177);
        videoEntity11.setImagePlayRes(R.mipmap.coverdetail11);
        mVideoEntityList.add(videoEntity11);

        VideoEntity videoEntity12 = new VideoEntity();
        videoEntity12.setImageRes(R.mipmap.cover12);
        videoEntity12.setThumbNum(711);
        videoEntity12.setImagePlayRes(R.mipmap.coverdetail12);
        mVideoEntityList.add(videoEntity12);

        VideoEntity videoEntity13 = new VideoEntity();
        videoEntity13.setImageRes(R.mipmap.cover13);
        videoEntity13.setThumbNum(1233);
        videoEntity13.setImagePlayRes(R.mipmap.coverdetail13);
        mVideoEntityList.add(videoEntity13);


        VideoEntity videoEntity14 = new VideoEntity();
        videoEntity14.setImageRes(R.mipmap.cover14);
        videoEntity14.setThumbNum(112);
        videoEntity14.setImagePlayRes(R.mipmap.coverdetail14);
        mVideoEntityList.add(videoEntity14);


        VideoEntity videoEntity15 = new VideoEntity();
        videoEntity15.setImageRes(R.mipmap.cover15);
        videoEntity15.setThumbNum(1234);
        videoEntity15.setImagePlayRes(R.mipmap.coverdetail15);
        mVideoEntityList.add(videoEntity15);


        mVideoAdapter.notifyDataSetChanged();


        /********************************推荐人******************************************/
        RecommendPersonEntity recommendPersonEntity6 = new RecommendPersonEntity();
        recommendPersonEntity6.setName("中英混血小姐妹");
        recommendPersonEntity6.setImageRes(R.mipmap.header6);
        mRecommendPersonList.add(recommendPersonEntity6);

        RecommendPersonEntity recommendPersonEntity5 = new RecommendPersonEntity();
        recommendPersonEntity5.setName("户外撒网");
        recommendPersonEntity5.setImageRes(R.mipmap.header5);
        mRecommendPersonList.add(recommendPersonEntity5);

        RecommendPersonEntity recommendPersonEntity4 = new RecommendPersonEntity();
        recommendPersonEntity4.setName("爱所爱的人");
        recommendPersonEntity4.setImageRes(R.mipmap.header4);
        mRecommendPersonList.add(recommendPersonEntity4);

        RecommendPersonEntity recommendPersonEntity3 = new RecommendPersonEntity();
        recommendPersonEntity3.setName("励志金太郎");
        recommendPersonEntity3.setImageRes(R.mipmap.header3);
        mRecommendPersonList.add(recommendPersonEntity3);

        RecommendPersonEntity recommendPersonEntity2 = new RecommendPersonEntity();
        recommendPersonEntity2.setName("爱我所爱");
        recommendPersonEntity2.setImageRes(R.mipmap.header2);
        mRecommendPersonList.add(recommendPersonEntity2);

        RecommendPersonEntity recommendPersonEntity1 = new RecommendPersonEntity();
        recommendPersonEntity1.setName("宇儿");
        recommendPersonEntity1.setImageRes(R.mipmap.header1);
        mRecommendPersonList.add(recommendPersonEntity1);


        mRecommendPersonAdapter.notifyDataSetChanged();
    }


    private void initStatusBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f);
        mImmersionBar.statusBarDarkFont(true);
        mImmersionBar.init();
    }

    private void initComponent() {
        mRVImageList = findViewById(R.id.act_main_rv_list);
        mIVBack = findViewById(R.id.act_main_title_iv_back);
        mTVName = findViewById(R.id.act_main_title_tv_name);
        mIVShare = findViewById(R.id.act_main_title_iv_share);
        mLLTitle = findViewById(R.id.act_main_title);
        mTVFollow = findViewById(R.id.act_main_tv_follow);
        mRLMainWork = findViewById(R.id.act_main_rl_work);
    }

    private void initListener() {
        mIVExpandArrow.setOnClickListener(this);
        mIVShare.setOnClickListener(this);
        mIVHeaderImage.setOnClickListener(this);
        mTVHeaderFollow.setOnClickListener(this);
        mRLHeaderRecommend.setOnClickListener(this);
        mTVSendSms.setOnClickListener(this);
        mRVImageList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mIntTotalScrollY += dy;

                processScroll(mIntTotalScrollY);

                if (mIntTotalScrollY > mLLMove.getBottom() - mRLMainWork.getTop()-mIntWorkTitleHeight) {
                    mRLMainWork.setVisibility(View.VISIBLE);
                    mRLHeaderWork.setVisibility(View.INVISIBLE);
                } else {
                    mRLMainWork.setVisibility(View.INVISIBLE);
                    mRLHeaderWork.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void processScroll(int currentY) {
        //百分比
        float percent = currentY * 1f / 200;
        int alpha = (int) (percent * 255);
        if (alpha >= 250) {
            //y>=320 实心头部
            alpha = 250;
            mTVName.setTextColor(Color.argb(alpha, 0x2a, 0x2a, 0x2a));
            mLLTitle.setBackgroundColor(Color.argb(alpha , 0xff, 0xff, 0xff));
            mIVBack.setColorFilter(Color.parseColor("#484848"));
            mTVFollow.setVisibility(View.VISIBLE);
            mIVShare.setImageDrawable(getResources().getDrawable(R.mipmap.share));
        } else {
            //y<320 渐变头部
            if (alpha < 55) {
                //y<55透明头部
                alpha = 0;
            }
            mTVName.setTextColor(Color.argb(alpha, 0x2a, 0x2a, 0x2a));
            mLLTitle.setBackgroundColor(Color.argb(alpha, 0x99, 0x99, 0x99));
            mIVBack.setColorFilter(Color.parseColor("#ffffff"));
            mTVFollow.setVisibility(View.GONE);
            mIVShare.setImageDrawable(getResources().getDrawable(R.mipmap.share));
        }
    }

    private void initHeader() {
        mHeaderView = LayoutInflater.from(this).inflate(R.layout.header_layout, null);
        mIVExpandArrow = mHeaderView.findViewById(R.id.header_layout_arrow);
        mRLHeaderWork = mHeaderView.findViewById(R.id.header_layout_rl_work);
        mIVHeaderImage = mHeaderView.findViewById(R.id.header_layout_iv_image_view);
        mTVHeaderFollow = mHeaderView.findViewById(R.id.header_layout_tv_follow);
        mLLMove = mHeaderView.findViewById(R.id.header_layout_ll_move);
        mRLHeaderRecommend = mHeaderView.findViewById(R.id.header_layout_rl_recommend);
        mRVRecommendList = mHeaderView.findViewById(R.id.header_layout_rv_recommend_person_list);
        mTVSendSms = mHeaderView.findViewById(R.id.header_layout_tv_send_sms);
   }

    private void initAdapter() {
        mVideoEntityList = new ArrayList<>();

        mVideoAdapter = new VideoAdapter(R.layout.item_video_layout, mVideoEntityList);

        GridLayoutManager videoGridLayoutManager = new GridLayoutManager(this, 3);

        mRVImageList.setLayoutManager(videoGridLayoutManager);

        mVideoAdapter.addHeaderView(mHeaderView);

        mRVImageList.setAdapter(mVideoAdapter);

        //跳转找详情
        mVideoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, VideoDetailActivity.class);
                intent.putExtra("playImage",mVideoEntityList.get(position).getImagePlayRes());
                startActivity(intent);
            }
        });

        mVideoAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                //监听是否滑到了底部
            }
        },mRVImageList);



        mRecommendPersonList = new ArrayList<>();
        mRecommendPersonAdapter = new RecommendPersonAdapter(R.layout.item_recommend_person,mRecommendPersonList);
        LinearLayoutManager recommendLinearLayoutManager = new LinearLayoutManager(this);
        recommendLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRVRecommendList.setLayoutManager(recommendLinearLayoutManager);
        mRVRecommendList.setAdapter(mRecommendPersonAdapter);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_layout_arrow:
                showHideContent();
                break;
            case R.id.act_main_title_iv_share:
                showShare();
                break;
            case R.id.header_layout_iv_image_view:
                jumpToHeaderDetail();
                break;
            case R.id.header_layout_tv_send_sms:
                sendSms();
                break;
        }
    }

    private void showHideContent(){
        if (isOpen){
            close();
        }else {
            open();
        }
    }

    private void jumpToHeaderDetail(){
        Intent intent = new Intent(this, HeaderImageActivity.class);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, mIVHeaderImage, "transition_image");
        ActivityCompat.startActivity(MainActivity.this, intent, compat.toBundle());
    }

    private void sendSms(){
        startActivity(new Intent(MainActivity.this, ChatActivity.class));
    }

    private void open(){
        ValueAnimator animator = ValueAnimator.ofInt(DensityUtil.dp2px(this,170), DensityUtil.dp2px(this,330));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取动画过程中的渐变值
                int animatedValue = (int) animation.getAnimatedValue();
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mLLMove.getLayoutParams();
                lp.setMargins(0, animatedValue, 0, 10);
                mLLMove.setLayoutParams(lp);
                isOpen=true;
            }
        });
        animator.start();
    }


    private void close(){
        ValueAnimator animator = ValueAnimator.ofInt(DensityUtil.dp2px(this,330), DensityUtil.dp2px(this,170));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mLLMove.getLayoutParams();
                lp.setMargins(0, animatedValue, 0, 10);
                mLLMove.setLayoutParams(lp);
                isOpen=false;
            }
        });
        animator.start();
    }


    private void showShare() {
        SharePopDialog SharePopDialog = new SharePopDialog();
        SharePopDialog.setOnSelectedShareTypeListener(new SharePopDialog.OnSelectedShareTypeListener() {
            @Override
            public void onShareTypeInfo(String share_media) {

            }
        });

        SharePopDialog.showDialog(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mIntWorkTitleHeight = mRLHeaderWork.getMeasuredHeight();

    }

    /**
     * 清除全屏标记
     */
    private void clearFullFlag() {
        //清除全屏标记
        getWindow().setBackgroundDrawableResource(R.color.background);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
