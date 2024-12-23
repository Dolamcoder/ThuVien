/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThuVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ThuVien {
    Scanner sc=new Scanner(System.in);
    private String id;
    private String nameThuVien;
   List<Sach> danhSachSach;
   List<NguoiDung> danhSachNguoiDung;
    public ThuVien(String id, String nameThuVien) {
        this.id = id;
        this.nameThuVien = nameThuVien;
        danhSachSach=new ArrayList<>();
        danhSachNguoiDung=new ArrayList<>();
    }
    public String getId() {
        return id;
    }

    public String getNameThuVien() {
        return nameThuVien;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Sach> getDanhSachSach() {
        return danhSachSach;
    }

    public void setDanhSachSach(List<Sach> danhSachSach) {
        this.danhSachSach = danhSachSach;
    }

    public void setDanhSachNguoiDung(List<NguoiDung> danhSachNguoiDung) {
        this.danhSachNguoiDung = danhSachNguoiDung;
    }

    public List<NguoiDung> getDanhSachNguoiDung() {
        return danhSachNguoiDung;
    }

    public void setNameThuVien(String nameThuVien) {
        this.nameThuVien = nameThuVien;
    }
    public boolean checkSach(String id){
        for(Sach x: danhSachSach){
            if(x.getId().equals(id)) return false;
        }
        return true;
    }
    public boolean checkNguoiDung(String id){
        for(NguoiDung x: danhSachNguoiDung){
            if(x.getId().equals(id)){
                return false;
            }
        }
        return true;
        }
    public void addSach() {
    System.out.println("Nhap ma Sach: ");
    String id = sc.nextLine();
    
    // Kiểm tra nếu mã sách đã tồn tại
    if (!checkSach(id)) {
        System.out.println("Ma sach da ton tai, vui long nhap lai.");
        return;
    }

    System.out.println("Nhap ten sach: ");
    String nameSach = sc.nextLine();
    if (nameSach.trim().isEmpty()) {
        System.out.println("Ten sach khong duoc de trong.");
        return;
    }

    System.out.println("Nhap ten tac gia: ");
    String tacGia = sc.nextLine();
    if (tacGia.trim().isEmpty()) {
        System.out.println("Ten tac gia khong duoc de trong.");
        return;
    }

    System.out.println("Nhap so luong sach: ");
    int n = 0;
    try {
        n = sc.nextInt();
        sc.nextLine();  
        if (n <= 0) {
            System.out.println("So luong sach phai lon hon 0.");
            return;
        }
    } catch (Exception e) {
        System.out.println("Vui long nhap so luong sach dung dinh dang.");
        sc.nextLine();  
        return;
    }

   
    Sach sach = new Sach(id, nameSach, tacGia, n);
    danhSachSach.add(sach);
    System.out.println("Them thanh cong sach: " + nameSach);
}

    public void xoaSach(){
        boolean check=true;
        while(check){
        System.out.println("nhap ma sach can xoa: ");
        String ma=sc.nextLine();
        for(int i=0;i<danhSachSach.size();i++){
            if(danhSachSach.get(i).getId().equals(ma)){
                danhSachSach.remove(i);
                System.out.println("xoa Sach thanh cong");
                check=false;
            }
        }
        System.out.println("khong tim thay sach");
        }
    }
   public void addNguoiDung() {
    System.out.println("Nhap ma khach hang: ");
    String id = sc.nextLine();
    if (!checkNguoiDung(id)) {
    System.out.println("Ma da ton tai, vui long nhap lai.");
        return;
    }
    System.out.println("Ten nguoi dung: ");
    String name = sc.nextLine();
    System.out.println("Gioi tinh: ");
    String gt = sc.nextLine();
    System.out.println("Ngay sinh: ");
    String ns = sc.nextLine();
    System.out.println("Lop: ");
    String lop = sc.nextLine();
    System.out.println("Ma SV: ");
    String maSV = sc.nextLine();

    NguoiDung nd = new NguoiDung(id, name, gt, ns, lop, maSV);
    danhSachNguoiDung.add(nd); // Đảm bảo thêm đúng vào danh sách
    System.out.println("Them thanh cong: " + name);
}

    public void xoaNguoiDung(){
        System.out.println("nhap ma nguoi dung");
        String id=sc.nextLine();
        for(int i=0;i<danhSachNguoiDung.size();i++){
            if(danhSachNguoiDung.get(i).getId().equals(id)){
                danhSachNguoiDung.remove(i);
                System.out.println("Xoa thanh cong nguoi dung "+ danhSachNguoiDung.get(i).getName());
            }
        }
        System.out.println("khong tim thay nguoi dung");
    }
    public void danhSachND(){
        for(NguoiDung x: danhSachNguoiDung){
            System.out.println(x);
        }
    }
    public void danhSachS(){
        for(Sach x: danhSachSach){
            System.out.println("Ten sach: "+ x.getTenSach()+ ","+ x);
        }
    }
    public Sach timKiemSach(String id){
        
        for(Sach x:danhSachSach){
            if(x.getId().equals(id) && x!=null) return x;
        }
        return null;
    }
    public NguoiDung timKiemNguoiDung(String id) {
    for (NguoiDung x : danhSachNguoiDung) {
        if (x.getId().equals(id)) { 
            return x; 
        }
    }
    return null; 
}

    public void suaSach(){
         System.out.println("nhap vao ma Sach can sua");
        String id=sc.nextLine();
        Sach sach=timKiemSach(id);
        System.out.println("nhap ten sach moi: ");
        String name=sc.nextLine();
        System.out.println("nhap ten tac gia moi: ");
        String tacGia=sc.nextLine();
        int sl=sc.nextInt();
        sach.setTenSach(name);
        sach.setTacGia(tacGia);
        sach.setSoLuongSach(sl);
        System.out.println("thong tin cap nhat thanh cong");
        System.out.println(sach);
    }
    public void suaNguoiDung(){
        System.out.println("nhap vao ma nguoi dung: ");
        String id=sc.nextLine();
        NguoiDung nd=timKiemNguoiDung(id);
       System.out.println("nhap ten nguoi dung: ");
        String name=sc.nextLine();
        sc.nextLine();
        System.out.println("Gioi tinh: ");
        String gt=sc.nextLine();
        sc.nextLine();
        System.out.println("Ngay Sinh: ");
        String ns=sc.nextLine();
        sc.nextLine();
        System.out.println("Lop: ");
        String lop=sc.nextLine();
        sc.nextLine();
        System.out.println("Ma sv: ");
        String maSV=sc.nextLine();
        sc.nextLine();
        nd.setName(name);
        nd.setGioiTinh(gt);
        nd.setNgaySinh(ns);
        nd.setLop(lop);
        nd.setMaSV(maSV);
        System.out.println("Da cap nhat thanh cong");
        System.out.println(nd);
    }
    public int soLuongSach(){
        int sum=0;
        for(Sach x: danhSachSach){
            sum+=x.getSoLuongSach();
        }
        return sum;
    }
    public void danhSachNguoiDung(){
        for(NguoiDung x: danhSachNguoiDung){
            System.out.println(x);
        }
    }
    public void danhSachSach(){
        for(Sach x : danhSachSach){
            System.out.println(x);
        }
    }
    
    @Override
    public String toString() {
        return "ThuVien{" + "id=" + id + ", nameThuVien=" + nameThuVien + ", So nguoi dung = "+ danhSachNguoiDung.size()+" So Luong sach = "+ soLuongSach() +"}";
    }
    
}
