package DTO;

import java.sql.Date;

public class NhanVienDTO {

  private String maNhanVien;
  private String hoNhanVien;
  private String tenNhanVien;
  private Date ngayVaoLam;
  private String viTri;
  private Integer luong;
  private String soDienThoai;
  private String email;

  public String getMaNhanVien() {
    return maNhanVien;
  }

  public void setMaNhanVien(String maNhanVien) {
    this.maNhanVien = maNhanVien;
  }

  public String getHoNhanVien() {
    return hoNhanVien;
  }

  public void setHoNhanVien(String hoNhanVien) {
    this.hoNhanVien = hoNhanVien;
  }

  public String getTenNhanVien() {
    return tenNhanVien;
  }

  public void setTenNhanVien(String tenNhanVien) {
    this.tenNhanVien = tenNhanVien;
  }

  public Date getNgayVaoLam() {
    return ngayVaoLam;
  }

  public void setNgayVaoLam(Date ngayVaoLam) {
    this.ngayVaoLam = ngayVaoLam;
  }

  public String getViTri() {
    return viTri;
  }

  public void setViTri(String viTri) {
    this.viTri = viTri;
  }

  public Integer getLuong() {
    return luong;
  }

  public void setLuong(Integer luong) {
    this.luong = luong;
  }

  public String getSoDienThoai() {
    return soDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    this.soDienThoai = soDienThoai;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}