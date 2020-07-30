package com.huoshan.www.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huoshan.www.R;



public class SharePopDialog implements View.OnClickListener {

    private OnSelectedShareTypeListener mOnSelectedShareTypeListener;

    private Dialog dialog;// 利用android自带的dialog类
    private View dialogView;// 弹窗的内容view
    private RelativeLayout mRLUp;// 弹窗内容的某部分
    private LinearLayout mLLPopList;// 弹窗内容的某部分
    private TextView mTVCancel;
    private LinearLayout mLLWx;
    private LinearLayout mLLWXCircle;
    private LinearLayout mLLQq;
    private LinearLayout mLLQZone;

    public void showDialog(Activity activity) {
        initComponent(activity);
        initAnimLayout();//上部分外层动画
        initAnim();// 上部分内层动画，每一个元素分开做动画
        initListener();
    }

    private void initComponent(Activity activity){
        dialog = new Dialog(activity, R.style.dialog_share_fullscreen);//创建一个dialog实例，
        dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_share, null);//实例化一个view作为弹窗的内容view
        mLLPopList = dialogView.findViewById(R.id.popListView);
        mRLUp = dialogView.findViewById(R.id.ll_up);
        mLLWx = dialogView.findViewById(R.id.dialog_share_wx);
        mLLWXCircle = dialogView.findViewById(R.id.dialog_share_wx_circle);
        mLLQq = dialogView.findViewById(R.id.dialog_share_qq);
        mLLQZone = dialogView.findViewById(R.id.dialog_share_q_zone);

        mTVCancel = dialogView.findViewById(R.id.btn_cancel);


        dialog.setContentView(dialogView);//设置弹窗的内容view
        dialog.setCanceledOnTouchOutside(true);//设置是否可以在窗口之外点击屏幕让弹窗消失
        dialog.setCancelable(true);//是否可以被按下back而让弹窗消失
        Window window = dialog.getWindow();//获得弹窗的 window对象
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.BOTTOM;//初始化弹窗的位置，在底部
            params.width = getScreenPixelsWidth(activity);//弹窗的宽度是整个屏幕的宽度
            window.setWindowAnimations(R.style.popwindow_anim_style);// 弹窗的显示和消失，加入动画
        }

        dialog.show();//显示弹窗
    }


    private void initListener() {
        mLLQZone.setOnClickListener(this);
        mLLWx.setOnClickListener(this);
        mLLWXCircle.setOnClickListener(this);
        mLLQq.setOnClickListener(this);
        mTVCancel.setOnClickListener(this);
    }

    /**
     * 获取屏幕的宽度，单位是像素px
     *
     * @param activity
     * @return
     */
    private int getScreenPixelsWidth(Context activity) {
        return activity.getResources().getDisplayMetrics().widthPixels;
    }

    private int animDuration = 500;// 动画执行的时长

    /**
     * 动画效果1
     */
    private void initAnimLayout() {
        //整体layout的动画，Y轴移动
        final int height = 20;
        final ValueAnimator anim = ValueAnimator.ofFloat(1, 0, 1);
        anim.setDuration(animDuration);
        anim.setInterpolator(new OvershootInterpolator());//先快后慢的插值器
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mRLUp.setTranslationY((1 - value) * height);
            }
        });
        anim.start();
    }

    /**
     * 动画效果2
     */
    private void initAnim() {
        int count = mLLPopList.getChildCount();
        long delay = 0;

        for (int i = 0; i < count; i++) {
            final View child = mLLPopList.getChildAt(i);
            child.setTranslationY(1 * 600);
            child.setAlpha(1 - 1);
        }

        for (int i = 0; i < count; i++) {
            final View child = mLLPopList.getChildAt(i);

            ValueAnimator anim = ValueAnimator.ofFloat(1, 0);
            anim.setDuration(animDuration);
            anim.setInterpolator(new OvershootInterpolator());
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = (float) animation.getAnimatedValue();
                    child.setTranslationY(value * 600);
                    child.setAlpha(1 - value);
                }
            });
            anim.setStartDelay(delay);
            anim.start();
            delay += 100;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_share_wx:
                if (this.mOnSelectedShareTypeListener != null) {
                    mOnSelectedShareTypeListener.onShareTypeInfo("微信");
                }
                dialog.dismiss();
                break;
            case R.id.dialog_share_wx_circle:
                if (this.mOnSelectedShareTypeListener != null) {
                    mOnSelectedShareTypeListener.onShareTypeInfo("朋友圈");
                }
                dialog.dismiss();
                break;
            case R.id.dialog_share_qq:
                if (this.mOnSelectedShareTypeListener != null) {
                    mOnSelectedShareTypeListener.onShareTypeInfo("QQ");
                }
                dialog.dismiss();
                break;
            case R.id.dialog_share_q_zone:
                if (this.mOnSelectedShareTypeListener != null) {
                    mOnSelectedShareTypeListener.onShareTypeInfo("QQ空间");
                }
                dialog.dismiss();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
        }
    }


    public interface OnSelectedShareTypeListener {
        void onShareTypeInfo(String share_media);
    }


    public void setOnSelectedShareTypeListener(OnSelectedShareTypeListener onSelectedShareTypeListener) {
        this.mOnSelectedShareTypeListener = onSelectedShareTypeListener;
    }


}