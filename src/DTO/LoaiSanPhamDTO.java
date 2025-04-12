package DTO;

public class LoaiSanPhamDTO {
	public String MaLoai, TenLoai;
	public LoaiSanPhamDTO(String MaLoai, String TenLoai) {
		this.MaLoai = MaLoai;
		this.TenLoai = TenLoai;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	public LoaiSanPhamDTO() {
	}
}
