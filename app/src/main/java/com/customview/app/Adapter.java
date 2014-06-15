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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by longnguyen on 6/7/14.
 */
public class Adapter extends BaseAdapter {
    private List<Model> list;
    private Context context;

    public Adapter(Context context, List<Model> newList){
        this.context = context;
        this.list = newList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Model getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridCell;

        //if (convertView == null) {
            gridCell = new View(context);
            gridCell = inflater.inflate(R.layout.custom_cell, null);

            TextView txtName = (TextView) gridCell.findViewById(R.id.friend_name);
            txtName.setText(getItem(position).getName());

            ImageView profileImgView = (ImageView) gridCell.findViewById(R.id.profileImg);
            ImageLoaderHelper.getImageLoader(context).displayImage(getItem(position).getImageUrl(), profileImgView);
        //Log.i(TAG, getItem(position).getImageURL());
        //} else {
        //    gridCell = (View) convertView;
        //}

        return gridCell;
    }
}
