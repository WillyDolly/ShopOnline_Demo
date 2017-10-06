package com.popland.pop.shoponline_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class Activity_ChiTietSanPham extends AppCompatActivity {
ImageView ivAnhsp;
    TextView tvTensp, tvGiasp, tvSpecs;
    Button btnMua;
    public static String idSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        ivAnhsp =(ImageView)findViewById(R.id.IVanhsp);
        tvTensp =(TextView)findViewById(R.id.TVtensp);
        tvGiasp =(TextView)findViewById(R.id.TVgiasp);
        tvSpecs =(TextView)findViewById(R.id.TVspecs);
        btnMua =(Button)findViewById(R.id.BTNmua);

        Intent i = getIntent();
        Bundle bd = i.getBundleExtra("bundle");

        String anhSP = bd.getString("anhsp");
        Picasso.with(Activity_ChiTietSanPham.this).load(anhSP).into(ivAnhsp);

        String tenSP = bd.getString("tensp");
        tvTensp.setText(tenSP);

        int giaSP = bd.getInt("giasp");
        DecimalFormat df = new DecimalFormat("#,###,###,###");
        tvGiasp.setText(df.format(giaSP));

        String specs = bd.getString("specs");
        tvSpecs.setText(specs);

        idSP = bd.getString("idSanpham");
        //solve 2:
//        String idSp = i.getStringExtra("idSanpham");
//        Activity_HangDienThoai.mData.child("DanhSachSanPham").child(idSp).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                DanhSachSanPham ds = dataSnapshot.getValue(DanhSachSanPham.class);
//                //get ds. ...
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_ChiTietSanPham.this,Activity_ThongTinKhachHang.class);
                startActivity(i);
            }
        });
    }
}
