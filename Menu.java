package QuanLyThuVien;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ThuVien thuVien = null;
        boolean ok = true;
        Scanner sc = new Scanner(System.in);

        while (ok) {
            System.out.println("1: Tao thu vien");
            System.out.println("2: Xem thong tin thu vien");
            System.out.println("3: Them nguoi dung");
            System.out.println("4: Xoa nguoi dung");
            System.out.println("5: Sua nguoi dung");
            System.out.println("6: Them sach");
            System.out.println("7: Xoa sach");
            System.out.println("8: Sua sach");
            System.out.println("9: Tim kiem sach");
            System.out.println("10: Tim kiem nguoi dung");
            System.out.println("11: Muon sach");
            System.out.println("12: Tra sach");
            System.out.println("13: Xem danh sach sach");
            System.out.println("14: Xem danh sach nguoi dung");
            System.out.println("15: ket thuc chuong trinh");
            int n = sc.nextInt();
            sc.nextLine(); // Đọc dấu xuống dòng sau khi nhập số

            switch (n) {
                case 1:
                    System.out.println("Nhap ma thu vien: ");
                    String idThuVien = sc.nextLine();
                    System.out.println("Nhap ten thu vien: ");
                    String name = sc.nextLine();
                    thuVien = new ThuVien(idThuVien, name);
                    System.out.println("Thu vien da duoc tao thanh cong.");
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 2:
                    if (thuVien != null) {
                        System.out.println(thuVien);
                    } else {
                        System.out.println("Chua co thu vien nao.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 3:
                    if (thuVien != null) {
                        thuVien.addNguoiDung();
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 4:
                    if (thuVien != null) {
                        thuVien.xoaNguoiDung();
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 5:
                    if (thuVien != null) {
                        thuVien.suaNguoiDung();
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 6:
                    if (thuVien != null) {
                        thuVien.addSach();
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 7:
                    if (thuVien != null) {
                        thuVien.xoaSach();
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 8:
                    if (thuVien != null) {
                        thuVien.suaSach();
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 9:
                    if (thuVien != null) {
                        System.out.println("Nhap ma sach: ");
                        String idSach = sc.nextLine();
                        System.out.println(thuVien.timKiemSach(idSach));
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 10:
                    if (thuVien != null) {
                        System.out.println("Nhap ma nguoi dung: ");
                        String idKH = sc.nextLine();
                        NguoiDung nguoiDung = thuVien.timKiemNguoiDung(idKH);
                        if (nguoiDung != null) {
                            System.out.println(nguoiDung);
                        } else {
                            System.out.println("Khong tim thay nguoi dung voi ma: " + idKH);
                        }
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 11:
                    if (thuVien == null) {
                        System.out.println("Vui long tao thu vien truoc!");
                        break;
                    }

                    // Nhap ma nguoi dung
                    System.out.println("Nhap ma nguoi dung muon muon sach: ");
                    String idND = sc.nextLine();

                    // Tim nguoi dung
                    NguoiDung nguoiDung = thuVien.timKiemNguoiDung(idND);
                    if (nguoiDung == null) {
                        System.out.println("Khong tim thay nguoi dung voi ma: " + idND);
                        break;
                    }

                    // Nhap ma sach muon muon va so ngay muon
                    System.out.println("Nhap ma sach muon muon: ");
                    String idSachMuon = sc.nextLine();
                    System.out.println("Nhap so ngay muon: ");
                    int soNgayMuon = sc.nextInt();
                    sc.nextLine();  // De clear newline sau khi nhap so

                    // Tim sach
                    Sach sachMuon = thuVien.timKiemSach(idSachMuon);
                    if (sachMuon == null) {
                        System.out.println("Khong tim thay sach voi ma: " + idSachMuon);
                        break;
                    }

                    // Kiem tra neu sach co san de muon
                   
                        nguoiDung.muonSach(sachMuon, soNgayMuon);
                      
                        System.out.println("Da muon sach thanh cong: " + sachMuon.getTenSach() + " cho " + soNgayMuon + " ngay.");
                        System.out.println("Enter de tiep tuc");
                        sc.nextLine();
                    break;

                case 12:
                    if (thuVien != null) {
                        System.out.println("Nhap ma sach can tra: ");
                        String idSachTra = sc.nextLine();
                        System.out.println("Nhap ma nguoi dung: ");
                        String idNguoiDungTra = sc.nextLine();

                        NguoiDung nguoiDungTra = thuVien.timKiemNguoiDung(idNguoiDungTra);
                        if (nguoiDungTra != null) {
                            if (nguoiDungTra.traSach(idSachTra)) {
                                System.out.println("Tra sach thanh cong.");
                            } else {
                                System.out.println("Khong tim thay sach de tra.");
                            }
                        } else {
                            System.out.println("Khong tim thay nguoi dung.");
                        }
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 13:
                    if (thuVien != null) {
                        thuVien.danhSachSach();
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;

                case 14:
                    if (thuVien != null) {
                        thuVien.danhSachNguoiDung();
                    } else {
                        System.out.println("Chua co thu vien nao. Vui long tao thu vien truoc.");
                    }
                    System.out.println("Enter de tiep tuc");
                    sc.nextLine();
                    break;
                case 15:
                    ok=false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }
    }
}
