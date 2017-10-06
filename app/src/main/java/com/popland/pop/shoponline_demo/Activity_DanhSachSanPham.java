package com.popland.pop.shoponline_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class Activity_DanhSachSanPham extends AppCompatActivity {
ListView lvDanhSachsp;
    ArrayList<DanhSachSanPham> arrlDSsp;
    CustomListView_DanhSachsp adapter;
    String idHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__danh_sach_san_pham);
        lvDanhSachsp = (ListView)findViewById(R.id.LVdanhsachsp);
        arrlDSsp = new ArrayList<DanhSachSanPham>();
        adapter = new CustomListView_DanhSachsp(Activity_DanhSachSanPham.this,R.layout.customlayout_danhsachsp,arrlDSsp);
        lvDanhSachsp.setAdapter(adapter);

        Intent i  = getIntent();
        idHang = i.getStringExtra("idHang");
        Activity_HangDienThoai.mData.child("DanhSachSanPham").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DanhSachSanPham danhsachsp  = dataSnapshot.getValue(DanhSachSanPham.class);
                if(idHang.equals(danhsachsp.idHang)){
                    arrlDSsp.add(new DanhSachSanPham(danhsachsp.idHang,dataSnapshot.getKey()
                            ,danhsachsp.tensp,danhsachsp.giasp,danhsachsp.anhsp,danhsachsp.specs));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        lvDanhSachsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Activity_DanhSachSanPham.this,Activity_ChiTietSanPham.class);
                Bundle bd = new Bundle();
                bd.putString("anhsp",arrlDSsp.get(position).anhsp);
                bd.putString("tensp",arrlDSsp.get(position).tensp);
                bd.putInt("giasp", arrlDSsp.get(position).giasp);
                bd.putString("specs", arrlDSsp.get(position).specs);
                bd.putString("idSanpham",arrlDSsp.get(position).idSanpham);
                i.putExtra("bundle", bd);
                startActivity(i);

                //solve 2:
               // i.putExtra("idSanpham",arrlDSsp.get(position).idSanpham);// idSanphaam = dataSnapshot.getKey()
            }
        });
//        btnThem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                danhSachsp = new DanhSachSanPham(
//                        edtIdhang.getText().toString(),edtIdsp.getText().toString(),edtTensp.getText().toString(),
//                        Integer.parseInt(edtGiasp.getText().toString()),edtAnhsp.getText().toString(),edtInfo.getText().toString()
//                );
//
//                Activity_HangDienThoai.mData.child("DanhSachSanPham").push().setValue(danhSachsp, new DatabaseReference.CompletionListener() {
//                    @Override
//                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//                        if(databaseError==null){
//                            Toast.makeText(Activity_DanhSachSanPham.this,"thanh cong",Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(Activity_DanhSachSanPham.this,"that bai",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });
    }
}
