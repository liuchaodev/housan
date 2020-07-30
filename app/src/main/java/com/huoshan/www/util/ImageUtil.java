package com.huoshan.www.util;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;


/**
 * Created by dell on 2016/1/30.
 */
public class ImageUtil {


    /**
     * 通过glide加载网络图片
     *
     * @param url
     * @param view
     */
    public static void loadImageUrl(String url, ImageView view, int placeholder, int error) {
        try {
            if (url != null && (url.contains("http") || url.contains("https"))) {
                Picasso.get().load(url).
                        placeholder(placeholder).
                        config(Bitmap.Config.RGB_565).
                        error(error).
                        fit().
                        centerCrop().
                        into(view);
            }else{
                Picasso.get().load(placeholder).
                        placeholder(placeholder).
                        config(Bitmap.Config.RGB_565).
                        error(error).
                        fit().
                        centerCrop().
                        into(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过glide加载网络图片
     *
     * @param url
     * @param view
     */
    public static void loadImageUrlWithTag(String url, ImageView view, int placeholder, int error, String tag) {
        try {
             if (url != null && (url.contains("http") || url.contains("https"))) {
            Picasso.get().load(url).tag(tag).
                    placeholder(placeholder).
                    config(Bitmap.Config.RGB_565).
                    error(error).
                    fit().
                    centerCrop().
                    into(view);
              }else{
                 Picasso.get().load(placeholder).
                         placeholder(placeholder).
                         config(Bitmap.Config.RGB_565).
                         error(error).
                         fit().
                         centerCrop().
                         into(view);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过glide加载网络图片
     *
     * @param url
     * @param view
     */
    public static void loadImageUrl(int width, int height, String url, ImageView view, int placeholder, int error) {
        try {
            if (url != null && (url.contains("http") || url.contains("https"))) {

                Picasso.get()
                        .load(url)
                        .config(Bitmap.Config.RGB_565)
                        .resize(width, height)//节约内存
                        .centerCrop()
                        .into(view);
            }else{
                Picasso.get().load(placeholder).
                        placeholder(placeholder).
                        config(Bitmap.Config.RGB_565).
                        error(error).
                        fit().
                        centerCrop().
                        into(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回收ImageView占用的图像内存;
     * 使用了本方法之后,记得用一下
     * System.gc(); 提醒系统及时回收
     *
     * @param view 在setImageResource()方法前面还没有bitmap,图片可以出来。
     *             在其后面执行本方法的话,图片就不会显示出来。
     *             在setImageBitmap()方法的前面还没有bitmap,图片可以出来。
     *             在其后面执行本方法的话,图片就不会显示出来。
     *             最好在onDestroy方法中执行本方法
     */

    public static void recycleImageView(View view) {
        try {
            if (view == null) return;
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bmp = ((BitmapDrawable) drawable).getBitmap();
                    if (bmp != null && !bmp.isRecycled()) {
                        ((ImageView) view).setImageBitmap(null);
                        bmp.recycle();
                        bmp = null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


