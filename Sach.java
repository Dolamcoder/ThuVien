/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThuVien;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class Sach {
    private String id, tenSach, tacGia;
    private int soLuongMuon=0, soLuongSach;
    private LocalDate ngayMuon;
    private int soNgayMuon;
    public Sach(String id, String tenSach, String tacGia, int soLuongSach) {
        this.id = id;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.soLuongSach = soLuongSach;
    }

    public void setNgayMuon(LocalDate ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setSoNgayMuon(int soNgayMuon) {
        this.soNgayMuon = soNgayMuon;
    }

    public int getSoNgayMuon() {
        return soNgayMuon;
    }

    public LocalDate getNgayMuon() {
        return ngayMuon;
    }

    public String getId() {
        return id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public int getSoLuongSach() {
        return soLuongSach;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public void setSoLuongSach(int soLuongSach) {
        this.soLuongSach = soLuongSach;
    }
    public String  toString(){
        return "Sach dang co: "+ this.soLuongSach+ ", So luong con lai: " + (this.soLuongSach-this.soLuongMuon)+", So luong muon: "+ this.soLuongMuon;
    }
    public void capNhatSachDaMuon(){
        this.soLuongMuon++;
    }
    public void capNhatSachTra(){
        this.soLuongMuon--;
    }
}
