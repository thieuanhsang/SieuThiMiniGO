package BUS;

import java.util.ArrayList;

import DAO.ChiTietPhieuNhapHangDAO;
import DAO.PhieuNhapHangDAO;
import DTO.PhieuNhapHangDTO;

public class PhieuNhapHangBUS {
	public static ArrayList<PhieuNhapHangDTO> ds_PNH_BUS;
	public static ArrayList<PhieuNhapHangDTO> kqTimKiemNhanh_PNH;
	public PhieuNhapHangBUS() {}
	public void doc_DS_PNH_BUS() {
		PhieuNhapHangDAO dataDao =  new PhieuNhapHangDAO();
		if(ds_PNH_BUS == null) {
			ds_PNH_BUS = new ArrayList<PhieuNhapHangDTO>();
			ds_PNH_BUS = dataDao.doc_ds_PNH_DAO();
		}
	}
	public void them_PNH_BUS(PhieuNhapHangDTO pnh) {
		PhieuNhapHangDAO dataDao = new PhieuNhapHangDAO();
		dataDao.them_PNH_DAO(pnh);
	}
	public ArrayList timNhanh_PNH(String input) {
		kqTimKiemNhanh_PNH = new ArrayList<>();
		try {
			input = input.toLowerCase();
			for(PhieuNhapHangDTO pnh : PhieuNhapHangBUS.ds_PNH_BUS) {
				if (pnh.getMaPhieuNhapHang().toLowerCase().contains(input)||pnh.getMaNhaCungCap().toLowerCase().contains(input)||pnh.getMaNhanVien().toLowerCase().contains(input)||
						pnh.getNgayLap().toLowerCase().contains(input)||pnh.getTongTien().toLowerCase().contains(input)) {
					kqTimKiemNhanh_PNH.add(pnh);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kqTimKiemNhanh_PNH;
	}
}
