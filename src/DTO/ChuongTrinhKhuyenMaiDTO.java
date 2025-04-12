package DTO;

import java.sql.Date;

public class ChuongTrinhKhuyenMaiDTO {
  private String maChuongTrinh;
  private String tenKhuyenMai;
  private Date ngayBatDau;
  private Date ngayKetThuc;

  public String getMaChuongTrinh() {
    return maChuongTrinh;
  }

  public void setMaChuongTrinh(String maChuongTrinh) {
    this.maChuongTrinh = maChuongTrinh;
  }

  public String getTenKhuyenMai() {
    return tenKhuyenMai;
  }

  public void setTenKhuyenMai(String tenKhuyenMai) {
    this.tenKhuyenMai = tenKhuyenMai;
  }

  public Date getNgayBatDau() {
    return ngayBatDau;
  }

  public void setNgayBatDau(Date ngayBatDau) {
    this.ngayBatDau = ngayBatDau;
  }

  public Date getNgayKetThuc() {
    return ngayKetThuc;
  }

  public void setNgayKetThuc(Date ngayKetThuc) {
    this.ngayKetThuc = ngayKetThuc;
  }
}
