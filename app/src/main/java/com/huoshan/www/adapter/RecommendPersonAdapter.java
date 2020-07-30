package com.huoshan.www.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huoshan.www.R;
import com.huoshan.www.entity.RecommendPersonEntity;

import java.util.List;

public class RecommendPersonAdapter extends BaseQuickAdapter<RecommendPersonEntity, BaseViewHolder> {

    public RecommendPersonAdapter(int layoutResId, @Nullable List<RecommendPersonEntity> data) {
        super(layoutResId, data);
    }

    public RecommendPersonAdapter(@Nullable List<RecommendPersonEntity> data) {
        super(data);
    }

    public RecommendPersonAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendPersonEntity item) {
        ImageView imageView = helper.getView(R.id.item_recommend_person_iv_image);
        imageView.setImageResource(item.getImageRes());
        helper.setText(R.id.item_recommend_person_tv_name,item.getName());
    }
}
