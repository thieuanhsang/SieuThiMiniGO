package BUS;

import java.util.ArrayList;

import DAO.ChiTietCTKM_DAO;
import DTO.ChiTietChuongTrinhKhuyenMaiDTO;

public class ChiTietCTKM_BUS {
	public static ArrayList<ChiTietChuongTrinhKhuyenMaiDTO> ds_ChiTiet_CTKM;
	public ChiTietCTKM_BUS() {
	}
	public void doc_ds_ChiTiet_CTKM_BUS() {
		ChiTietCTKM_DAO dataDao = new ChiTietCTKM_DAO();
		if(ds_ChiTiet_CTKM == null) {
			ds_ChiTiet_CTKM = new ArrayList<ChiTietChuongTrinhKhuyenMaiDTO>();
		}
		ds_ChiTiet_CTKM = dataDao.doc_DS_ChiTietCTKM();
	}
	public void themChiTiet_CTKM_BUS(ChiTietChuongTrinhKhuyenMaiDTO ctctkm) {
		ChiTietCTKM_DAO dataDao = new ChiTietCTKM_DAO();
		dataDao.themChiTietCTKM_DAO(ctctkm);
	}
	public void xoaChiTiet_CTKM_BUS(String MaCT, String MaKH) {
		ChiTietCTKM_DAO dataDao = new ChiTietCTKM_DAO();
		dataDao.xoaChiTietCTKM_DAO(MaCT, MaKH);
	}
	public void suaChiTiet_CTKM_BUS(String PTGiam, String MaKH, String MaCT) {
		ChiTietCTKM_DAO dataDao = new ChiTietCTKM_DAO();
		dataDao.suaChietCTKM_DAO(PTGiam, MaKH, MaCT);
	}
}
