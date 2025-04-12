package DTO;

public class SanPhamDTO {
	public String MaSanPham, TenSanPham, DonGia, DonViTinh;
	public String SoLuong;
	public String MaLoai;
	public String MaNhaSanXuat;
	public  SanPhamDTO(String MaSanPham,String TenSanPham, String DonGia,String DonViTinh,String SoLuong, String MaLoai, String MaSanXuat) {
		this.MaSanPham = MaSanPham;
		this.TenSanPham = TenSanPham;
		this.DonGia = DonGia;
		this.DonViTinh = DonViTinh;
		this.SoLuong = SoLuong;
		this.MaLoai = MaLoai;
		this.MaNhaSanXuat = MaSanXuat;
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
	public void setDonGia(String string) {
		DonGia = string;
	}
	public String getDonViTinh() {
		return DonViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}
	public String getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(String string) {
		SoLuong = string;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getMaNhaSanXuat() {
		return MaNhaSanXuat;
	}
	public void setMaNhaSanXuat(String maNhaSanXuat) {
		MaNhaSanXuat = maNhaSanXuat;
	}
	public SanPhamDTO() {
	}
}
