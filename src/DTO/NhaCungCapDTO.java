package DTO;

public class NhaCungCapDTO {

  private String maNhaCungCap;
  private String tenNhaCungCap;
  private String diaChi;
  private String Sdt;
  private String email;

  public String getMaNhaCungCap() {
    return maNhaCungCap;
  }

  public void setMaNhaCungCap(String maNhaCungCap) {
    this.maNhaCungCap = maNhaCungCap;
  }

  public String getTenNhaCungCap() {
    return tenNhaCungCap;
  }

  public void setTenNhaCungCap(String tenNhaCungCap) {
    this.tenNhaCungCap = tenNhaCungCap;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public String getSdt() {
    return Sdt;
  }

  public void setSdt(String sdt) {
    Sdt = sdt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}