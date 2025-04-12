package DTO;

public class KhachHangDTO {
	public String MaKH;
	public String HoKH;
	public String TenKH;
	public String CCCD;
	public String SDT;
	public KhachHangDTO (String MaKH, String HoKH, String TenKH, String CCCD, String SDT) {
		this.MaKH = MaKH;
		this.HoKH =HoKH;
		this.TenKH = TenKH;
		this.CCCD = CCCD;
		this.SDT = SDT;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getHoKH() {
		return HoKH;
	}
	public void setHoKH(String hoKH) {
		HoKH = hoKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public KhachHangDTO() {
	}
}
