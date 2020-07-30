package com.huoshan.www.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huoshan.www.R;
import com.huoshan.www.entity.VideoEntity;
import com.huoshan.www.util.ImageUtil;

import java.util.List;

public class VideoAdapter extends BaseQuickAdapter<VideoEntity, BaseViewHolder> {

    public VideoAdapter(int layoutResId, @Nullable List<VideoEntity> data) {
        super(layoutResId, data);
    }

    public VideoAdapter(@Nullable List<VideoEntity> data) {
        super(data);
    }

    public VideoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoEntity item) {
        ImageView coverImage=helper.getView(R.id.item_video_layout_image);
        coverImage.setImageResource(item.getImageRes());
        helper.setText(R.id.item_video_layout_num,item.getThumbNum()+"");
       // ImageUtil.loadImageUrl(item.getImageUrl(), (ImageView) helper.getView(R.id.item_video_layout_image),R.mipmap.loading,R.mipmap.loading);
    }
}
