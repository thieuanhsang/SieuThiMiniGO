package BUS;

import java.util.ArrayList;

import DAO.HoaDonDAO;
import DTO.CTCTKhuyenMaiDTO;
import DTO.HoaDonDTO;

public class HoaDonBUS {
	public static ArrayList<HoaDonDTO> dshd;
	public static ArrayList<HoaDonDTO> kq;
	public static ArrayList<CTCTKhuyenMaiDTO> kqCheck;

	public HoaDonBUS() {
		// TODO Auto-generated constructor stub
	}
	public void docDSHD() {
		HoaDonDAO data = new HoaDonDAO();
		if (dshd==null) {
			dshd = new ArrayList<HoaDonDTO>();
		}
		dshd = data.docDSHD();
	}
	public void themHD (HoaDonDTO hd) {
		HoaDonDAO data = new HoaDonDAO();
		data.them(hd);
		if (HoaDonDAO.flag==true) {
			dshd.add(hd);
		}
	}
	public void sua (HoaDonDTO hd, int i) {
		HoaDonDAO data = new HoaDonDAO();
		data.sua(hd);
		if (HoaDonDAO.flagSua==true) {
			dshd.set(i, hd);
		}
	}
	public void xoa (String ma, int i) {
		HoaDonDAO data = new HoaDonDAO();
		data.xoa(ma);
		if (HoaDonDAO.flagXoa==true) {
			dshd.remove(i);
		}
	}
	public void timTheoMaHD (String ma) {
		HoaDonDAO data = new HoaDonDAO();
        kq = new ArrayList<HoaDonDTO>();
		kq = data.timHDTheoMa(ma);
	}
	public void timTheoKhoangTien(String input1, String input2) {
		HoaDonDAO data = new HoaDonDAO();
		kq = new ArrayList<HoaDonDTO>();
		kq = data.timTheoKhoangTien(input1, input2);
	}
	public void timTheoMaNVorMaKH (String input1, String input2) {
		HoaDonDAO dataDao = new HoaDonDAO();
		kq = new ArrayList<HoaDonDTO>();
		kq = dataDao.timMaNVorMaKH(input1, input2);
	}
	public void checkKhachHang (String maKH) {
		HoaDonDAO data = new HoaDonDAO();
		kqCheck = new ArrayList<CTCTKhuyenMaiDTO>();
		kqCheck = data.checkKhuyenMai(maKH);
	}
}
