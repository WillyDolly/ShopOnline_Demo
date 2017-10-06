package com.popland.pop.shoponline_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by hai on 08/07/2016.
 */
public class CustomListView_DanhSachsp extends ArrayAdapter<DanhSachSanPham> {
    public CustomListView_DanhSachsp(Context context, int resource, List<DanhSachSanPham> objects) {
        super(context, resource, objects);
    }
    public View getView(int position,View convertView,ViewGroup parent){
        View v = convertView;
        if(v==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.customlayout_danhsachsp,null);
        }
        DanhSachSanPham p = getItem(position);
        if(p!=null){
            ImageView ivAnhsp =(ImageView)v.findViewById(R.id.IVanhsp);
            Picasso.with(getContext()).load(p.anhsp).into(ivAnhsp);
            TextView tvTensp =(TextView)v.findViewById(R.id.TVtensp);
            tvTensp.setText(p.tensp);
            TextView tvGiasp =(TextView)v.findViewById(R.id.TVgiasp);
            DecimalFormat df = new DecimalFormat("#,###,###,###");
            tvGiasp.setText(df.format(p.giasp));
        }
        return v;
    }
}
