package DTO;

public class HoaDonDTO {
	String MaHD;
	String MaNV;
	String MaKH;
	String NgayLap;
	String TongTien;
	public HoaDonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonDTO(String maHD, String maNV, String maKH, String ngayLap, String tongTien) {
		super();
		MaHD = maHD;
		MaNV = maNV;
		MaKH = maKH;
		NgayLap = ngayLap;
		TongTien = tongTien;
	}
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
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
	
}
