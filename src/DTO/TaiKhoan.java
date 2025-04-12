package DTO;

public class TaiKhoan {
	String MaTaiKhoan, TenTaiKhoan, MatKhau, PhanQuyen,MaNV;
	public TaiKhoan(String MaTaiKhoan, String TenTaiKhoan,String MatKhau,String phanQuyen,String Ma) {
		this.MaTaiKhoan = MaTaiKhoan;
		this.TenTaiKhoan = TenTaiKhoan;
		this.MatKhau = MatKhau;
		this.MaNV = MaNV;
	}
	public String getPhanQuyen() {
		return PhanQuyen;
	}
	public void setPhanQuyen(String phanQuyen) {
		PhanQuyen = phanQuyen;
	}
	public String getMaTaiKhoan() {
		return MaTaiKhoan;
	}
	public void setMaTaiKhoan(String maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}
	public String getTenTaiKhoan() {
		return TenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		TenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public TaiKhoan() {
	}
}
