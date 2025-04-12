package BUS;

import java.util.ArrayList;

import DAO.ChiTietPhieuNhapHangDAO;
import DAO.PhieuNhapHangDAO;
import DTO.ChiTietPhieuNhapHangDTO;
import DTO.PhieuNhapHangDTO;

public class ChiTietPhieuNhapHangBUS {
	public static ArrayList<ChiTietPhieuNhapHangDTO> ds_CTPNH_timtheoMa_PNH_BUS;
	public ChiTietPhieuNhapHangBUS() {}
	
	public void timtheoMa_CTPNH_BUS(String MaPNH) {
		ChiTietPhieuNhapHangDAO dataDao = new ChiTietPhieuNhapHangDAO();
		if(ds_CTPNH_timtheoMa_PNH_BUS == null) {
			ds_CTPNH_timtheoMa_PNH_BUS = new ArrayList<ChiTietPhieuNhapHangDTO>();
		}
		ds_CTPNH_timtheoMa_PNH_BUS = dataDao.timkiemTheoMA_PNH(MaPNH);
	}
	public void them_CTPNH_BUS(ChiTietPhieuNhapHangDTO ctpnh) {
		ChiTietPhieuNhapHangDAO dataDao = new ChiTietPhieuNhapHangDAO();
		dataDao.them_CTPNH_DAO(ctpnh);
	}
}
