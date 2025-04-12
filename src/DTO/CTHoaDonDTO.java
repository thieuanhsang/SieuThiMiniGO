package DTO;

public class CTHoaDonDTO {
	String MaHoaDon;
	String MaSanPham;
	String TenSanPham;
	String DonGia;
	String SoLuong;
	String ThanhTien;
	public CTHoaDonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CTHoaDonDTO(String maHoaDon, String maSanPham, String tenSanPham, String donGia, String soLuong,
			String thanhTien) {
		super();
		MaHoaDon = maHoaDon;
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		DonGia = donGia;
		SoLuong = soLuong;
		ThanhTien = thanhTien;
	}
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public String getDonGia() {
		return DonGia;
	}
	public void setDonGia(String donGia) {
		DonGia = donGia;
	}
	public String getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(String soLuong) {
		SoLuong = soLuong;
	}
	public String getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(String thanhTien) {
		ThanhTien = thanhTien;
	}
	
}
