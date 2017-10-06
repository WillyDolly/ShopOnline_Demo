package com.popland.pop.shoponline_demo;

/**
 * Created by hai on 08/07/2016.
 */
public class DanhSachSanPham {
    public String idHang;
    public String idSanpham;
    public String tensp;
    public Integer giasp;
    public String anhsp;
    public String specs;

    public DanhSachSanPham(){

    }

    public DanhSachSanPham(String idHang, String idSanpham, String tensp, Integer giasp, String anhsp, String specs) {
        this.idHang = idHang;
        this.idSanpham = idSanpham;
        this.tensp = tensp;
        this.giasp = giasp;
        this.anhsp = anhsp;
        this.specs = specs;
    }
}
