/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public ArrayList<SanPham> getTop6() {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select top 6 * from SanPham order by gia desc";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }
    //Phương thức đọc giày theo thể loại
    public ArrayList<SanPham> getByCategoryId(int maloai) {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select * from TheLoai where maloai=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maloai);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }
    //phuong thuc doc tat ca san pham (Giày) từ CSDL
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select * from SanPham";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }
    //phuong thuc doc tat ca san pham (Giày) từ CSDL theo pageIndex,pageSiza
    public ArrayList<SanPham> getByPage(int pageIndex, int pageSize) {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select * from SanPham order by maloai OFFSET ?  Row Fetch Next ? Row Only";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(pageIndex-1)*pageSize);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }
    
    //Phương thức lấy thông tin sản phẩm (Giày) theo mã hoa 
    public SanPham getById(int masp) {
        SanPham kq = null;
        String sql = "select * from SanPham where masp=?";
        conn = DbContext.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, masp);
            rs = ps.executeQuery();
            if (rs.next()) {
                kq = new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getDate(6));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return kq;
    }

}
