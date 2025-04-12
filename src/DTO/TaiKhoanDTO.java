package DTO;

public class TaiKhoanDTO {

  String maTaiKhoan;
  String tenTaiKhoan;
  String matkhau;
  String phanQuyen;
  String maNhanVien;

  public String getMaTaiKhoan() {
    return maTaiKhoan;
  }

  public void setMaTaiKhoan(String maTaiKhoan) {
    this.maTaiKhoan = maTaiKhoan;
  }

  public String getTenTaiKhoan() {
    return tenTaiKhoan;
  }

  public void setTenTaiKhoan(String tenTaiKhoan) {
    this.tenTaiKhoan = tenTaiKhoan;
  }

  public String getMatKhau() {
    return matkhau;
  }

  public void setMatKhau(String matKhau) {
    this.matkhau = matKhau;
  }

  public String getPhanQuyen() {
    return phanQuyen;
  }

  public void setPhanQuyen(String phanQuyen) {
    this.phanQuyen = phanQuyen;
  }

  public String getMaNV() {
    return maNhanVien;
  }

  public void setMaNV(String maNV) {
    maNhanVien = maNV;
  }

  public TaiKhoanDTO(String MaTaiKhoan, String TenTaiKhoan, String MatKhau, String phanQuyen,
      String MaNV) {
    this.maTaiKhoan = MaTaiKhoan;
    this.tenTaiKhoan = TenTaiKhoan;
    this.matkhau = MatKhau;
    this.maNhanVien = MaNV;
  }

  public TaiKhoanDTO() {
  }
}
