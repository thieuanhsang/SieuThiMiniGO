package DTO;

public class LoaiDTO {
	public String MaLoai, TenLoai;
	public LoaiDTO(String MaLoai, String TenLoai) {
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
	public LoaiDTO() {
	}
}
