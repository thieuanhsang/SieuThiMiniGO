package DTO;

public class PhieuNhapHangDTO {
	public String MaPhieuNhapHang, MaNhaCungCap, MaNhanVien, NgayLap, TongTien;
	public PhieuNhapHangDTO(String MaPhieuNhap, String MaNhaCungCap, String MaNhanVien, String NgayLap, String TongTien) {
		this.MaPhieuNhapHang = MaPhieuNhapHang;
		this.MaNhaCungCap = MaNhaCungCap;
		this.MaNhanVien = MaNhanVien;
		this.NgayLap = NgayLap;
		this.TongTien = TongTien;	
	}
	public String getMaPhieuNhapHang() {
		return MaPhieuNhapHang;
	}
	public void setMaPhieuNhapHang(String maPhieuNhapHang) {
		MaPhieuNhapHang = maPhieuNhapHang;
	}
	public String getMaNhaCungCap() {
		return MaNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(String ngayLap) {
		NgayLap = ngayLap;
	}
	public String getTongTien() {
		return TongTien;
	}
	public void setTongTien(String tongTien) {
		TongTien = tongTien;
	}
	public PhieuNhapHangDTO() {
	}
}
