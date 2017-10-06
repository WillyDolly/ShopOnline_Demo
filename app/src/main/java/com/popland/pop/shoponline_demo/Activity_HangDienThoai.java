package com.popland.pop.shoponline_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Activity_HangDienThoai extends AppCompatActivity {
    ListView lvHangdt;
    ArrayList<HangDienThoai> arrlHangdt;
    CustomBaseAdapter_Hangdt adapter;
    public static DatabaseReference mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__hang_dien_thoai);
        lvHangdt =(ListView)findViewById(R.id.LVHangdt);
        arrlHangdt = new ArrayList<HangDienThoai>();
        adapter = new CustomBaseAdapter_Hangdt(Activity_HangDienThoai.this,R.layout.customlayout_hangdt,arrlHangdt);
        lvHangdt.setAdapter(adapter);

        mData = FirebaseDatabase.getInstance().getReference();

//       String logoHangDT = "https://firebasestorage.googleapis.com/v0/b/myphoneshop-ac920.appspot.com/o/logoHangDT%2FAndroidIcon.png?alt=media&token=0e6315d3-fb6d-40d5-9572-0de2fb0fcef3";
//      HangDienThoai hangDienThoai = new HangDienThoai("Android", "An", logoHangDT);
//        mData.child("HangDienThoai").push().setValue(hangDienThoai);
        mData.child("HangDienThoai").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                HangDienThoai hangDienThoai = dataSnapshot.getValue(HangDienThoai.class);
                arrlHangdt.add(new HangDienThoai(hangDienThoai.tenHang, hangDienThoai.idHang, hangDienThoai.logoHang));
                adapter.notifyDataSetChanged();
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

        lvHangdt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Activity_HangDienThoai.this,Activity_DanhSachSanPham.class);
                i.putExtra("idHang",arrlHangdt.get(position).idHang);
                startActivity(i);
            }
        });

    }
}
