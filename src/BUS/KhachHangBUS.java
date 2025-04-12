package BUS;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;

public class KhachHangBUS {
	public static ArrayList<KhachHangDTO> ds_KhachHang;
	public KhachHangBUS() {
	}
	
	public void doc_DS_KhachHangBUS() {
		KhachHangDAO dataKhachHangDAO = new KhachHangDAO();
		if(ds_KhachHang == null) {
			ds_KhachHang = new ArrayList<KhachHangDTO>();
		}
		ds_KhachHang = dataKhachHangDAO.doc_DS_KhachHangDAO();
	}
	
	
	public void themKhachHang(KhachHangDTO kh) {
		KhachHangDAO dataKhachHangDAO = new KhachHangDAO();
		dataKhachHangDAO.themKhachHang(kh);
		ds_KhachHang.add(kh);
	}
	
	public void xoaKhachHang(String makh, KhachHangDTO kh) {
		KhachHangDAO dataKhachHangDAO = new KhachHangDAO();
		dataKhachHangDAO.xoaKhachHang(makh);
		ds_KhachHang.remove(kh);
	}
	
	public void suaKhachHang(String makh, String ho, String ten, String cccd ,String sdt ) {
		KhachHangDAO dataKhachHangDAO = new KhachHangDAO();
		dataKhachHangDAO.suaKhachHang(makh, ho, ten, cccd, sdt);
	}
}
