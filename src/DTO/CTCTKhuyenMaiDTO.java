package DTO;

public class CTCTKhuyenMaiDTO {
	String maKhachHang;
	String maChuongTrinh;
	String PTGiam;
	public CTCTKhuyenMaiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CTCTKhuyenMaiDTO(String maKhachHang, String maChuongTrinh, String pTGiam) {
		super();
		this.maKhachHang = maKhachHang;
		this.maChuongTrinh = maChuongTrinh;
		PTGiam = pTGiam;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
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
	public void setPTGiam(String pTGiam) {
		PTGiam = pTGiam;
	}
	
}
