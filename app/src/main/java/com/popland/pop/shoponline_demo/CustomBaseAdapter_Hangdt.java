package com.popland.pop.shoponline_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hai on 08/07/2016.
 */
public class CustomBaseAdapter_Hangdt extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<HangDienThoai> myItems;
    public CustomBaseAdapter_Hangdt(Context context,int layout, List<HangDienThoai> items){
        myContext = context;
        myLayout = layout;
        myItems = items;
    }
    @Override
    public int getCount() {
        return myItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout,null);

        ImageView ivLogoHang =(ImageView)convertView.findViewById(R.id.IVlogoHang);
        Picasso.with(myContext).load(myItems.get(position).logoHang).into(ivLogoHang);
        TextView tvTenhang =(TextView)convertView.findViewById(R.id.TVtenHang);
        tvTenhang.setText(myItems.get(position).tenHang);
        return convertView;
    }
}
