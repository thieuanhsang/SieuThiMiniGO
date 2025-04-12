package DTO;

public class ChiTietPhieuNhapHangDTO {
	public String MaPhieuNhap, MaSanPham, SoLuong, DonGia, ThanhTien;
	public ChiTietPhieuNhapHangDTO(String MaPhieuNhap,String MaSanPham,String SoLuong,String DonGia,String ThanhTien) {	
		this.MaPhieuNhap = MaPhieuNhap;
		this.MaSanPham = MaSanPham;
		this.SoLuong = SoLuong;
		this.ThanhTien = ThanhTien;
		
	}
	public String getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(String soLuong) {
		SoLuong = soLuong;
	}
	public String getDonGia() {
		return DonGia;
	}
	public void setDonGia(String donGia) {
		DonGia = donGia;
	}
	public String getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(String thanhTien) {
		ThanhTien = thanhTien;
	}
	public ChiTietPhieuNhapHangDTO() {
	}
}
