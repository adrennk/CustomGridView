/*
 * Copyright (c) 2013. CMG Ltd All rights reserved.
 *
 * This software is the confidential and proprietary information of CMG
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with CMG.
 */
package com.customview.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by longnguyen on 6/7/14.
 */
public class ImageLoaderHelper {
    private static String TAG = "ImageLoaderHelper.class";

    private ImageLoaderHelper(){

    }

    public static ImageLoader getImageLoader(Context context){
        try {
            if (ImageLoader.getInstance().isInited()) {
                return ImageLoader.getInstance();
            }
            DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                    .showStubImage(R.drawable.loading)
                    .showImageForEmptyUri(R.drawable.loading)
                    .showImageOnFail(R.drawable.loading).cacheInMemory()
                    .cacheOnDisc().bitmapConfig(Bitmap.Config.RGB_565)
                    .build();
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                    context)
                    .defaultDisplayImageOptions(defaultOptions).build();
            ImageLoader.getInstance().init(config);
            return ImageLoader.getInstance();
        } catch (Exception ex) {
            Log.e(TAG, "Error when get image loader instance: " + ex);
            return null;
        }
    }
}
