package com.huoshan.www.entity;

public class VideoEntity {
    public String getPlayImageUrl() {
        return playImageUrl;
    }

    public void setPlayImageUrl(String playImageUrl) {
        this.playImageUrl = playImageUrl;
    }

    private String imageUrl;
    private int imageRes;
    private int imagePlayRes;
    private int thumbNum;
    private String playImageUrl;

    public int getImagePlayRes() {
        return imagePlayRes;
    }

    public void setImagePlayRes(int imagePlayRes) {
        this.imagePlayRes = imagePlayRes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public int getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(int thumbNum) {
        this.thumbNum = thumbNum;
    }
}
