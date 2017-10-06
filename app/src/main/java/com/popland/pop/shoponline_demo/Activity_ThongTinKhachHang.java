package com.popland.pop.shoponline_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class Activity_ThongTinKhachHang extends AppCompatActivity {
EditText edtTen, edtEmail, edtSdt, edtDiachi;
    Button btnXacthuc;
String ten,email, sdt, diachi;
    String[] customer = {ten,email,sdt,diachi};
boolean empty = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__thong_tin_khach_hang);
        edtTen = (EditText)findViewById(R.id.EDTten);
        edtEmail = (EditText)findViewById(R.id.EDTemail);
        edtSdt = (EditText)findViewById(R.id.EDTsdt);
        edtDiachi = (EditText)findViewById(R.id.EDTdiachi);
        btnXacthuc = (Button)findViewById(R.id.BTNxacthuc);

        btnXacthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ten = edtTen.getText().toString();
                email = edtEmail.getText().toString();
                sdt = edtSdt.getText().toString();
                diachi = edtDiachi.getText().toString();
                for (int i = 0; i < customer.length; i++) {
                    if (TextUtils.isEmpty(customer[i])) {
                        empty = true;
                        break;
                    }
                }
                if (empty == true) {
                    Toast.makeText(Activity_ThongTinKhachHang.this, "Please fill up all fields", Toast.LENGTH_LONG).show();
                } else {
                    KhachHang khachHang = new KhachHang(ten,email,sdt,diachi, Activity_ChiTietSanPham.idSP);
                    Activity_HangDienThoai.mData.child("ThongTinKhachHang").push().setValue(khachHang, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError == null) {
                                Toast.makeText(Activity_ThongTinKhachHang.this, "don dat hang da chuyen", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(Activity_ThongTinKhachHang.this, "xin thu lai", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

    }
}
