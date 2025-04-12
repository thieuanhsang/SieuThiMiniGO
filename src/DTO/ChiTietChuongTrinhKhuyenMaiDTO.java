package DTO;

public class ChiTietChuongTrinhKhuyenMaiDTO {
	String maKhachHang;
	String maChuongTrinh;
	String PTGiam;
	public ChiTietChuongTrinhKhuyenMaiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietChuongTrinhKhuyenMaiDTO(String maKhachHang, String maChuongTrinh, String pTGiam) {
		super();
		this.maKhachHang = maKhachHang;
		this.maChuongTrinh = maChuongTrinh;
		PTGiam = pTGiam;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public String getMaChuongTrinh() {
		return maChuongTrinh;
	}
	public void setMaChuongTrinh(String maChuongTrinh) {
		this.maChuongTrinh = maChuongTrinh;
	}
	public String getPTGiam() {
		return PTGiam;
	}
	public void setPTGiam(String d) {
		PTGiam = d;
	}
	public void setMaKhachHang(String maKhachHang) {
		// TODO Auto-generated method stub
		this.maKhachHang = maKhachHang;
	}
	
	
}
