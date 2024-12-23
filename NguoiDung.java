/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThuVien;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NguoiDung implements INguoiDung {
 private String id, name, gioiTinh, ngaySinh, lop, maSV;
 private ArrayList<Sach> dsSach;
    public NguoiDung(String id, String name, String gioiTinh, String ngaySinh, String lop, String maSV) {
        this.id = id;
        this.name = name;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.maSV = maSV;
        dsSach=new ArrayList<>();
        //tu dong xoa sach
        LocalDate currentDate = LocalDate.now(); 
        for(int i=0;i<dsSach.size();i++){
            if(dsSach.get(i).getNgayMuon().plusDays(dsSach.get(i).getSoNgayMuon())==currentDate){
                dsSach.remove(i);
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public ArrayList<Sach> getDsSach() {
        return dsSach;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setDsSach(ArrayList<Sach> dsSach) {
        this.dsSach = dsSach;
    }
    @Override
    public boolean muonSach(Sach sach, int soNgayMuon) {
        if(dsSach.size()>5) return false;
        if(sach.getSoLuongSach()-sach.getSoLuongMuon()<=0) return false;
        System.out.println("muon sach "+sach.getTenSach()+" thanh cong");
        dsSach.add(sach);
        sach.capNhatSachDaMuon();
        sach.setNgayMuon(LocalDate.now());
        sach.setSoNgayMuon(soNgayMuon);
        return true;
    }
   
    @Override
    public boolean traSach(String idSach) {
       for(int i=0;i<dsSach.size();i++){
           if(dsSach.get(i).getId().equals(idSach)){
               dsSach.remove(i);
               return true;
           }
       }
        System.out.println("khong tim thay sach");
        return false;
    }

    @Override
    public Sach timKiem(String id) {
        for(int i=0;i<dsSach.size();i++){
            if(dsSach.get(i).getId().equals(id)){
                return dsSach.get(i);
            }
        }
        System.out.println("khong tim thay sach");
        return null;
    }

    @Override
    public String toString() {
        return "NguoiDung{" + "id=" + id + ", name=" + name + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", lop=" + lop + ", maSV=" + maSV + '}';
    }
    public void danhSachSach(){
        for(Sach x: dsSach){
            System.out.println("Ngay muon: "+ x.getNgayMuon()+", ngay tra : " + x.getNgayMuon().plusDays(x.getSoNgayMuon())+", Ten Sach: "+x.getTenSach()+", Ten nguoi muon: "+ this.name);
        }
    }
}
