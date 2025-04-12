package BUS;

import java.util.ArrayList;

import DAO.LoaiSanPhamDAO;
import DTO.LoaiSanPhamDTO;

public class LoaiSanPhamBUS {
	public static ArrayList<LoaiSanPhamDTO> ds_LoaiBUS;
	public LoaiSanPhamBUS() {
	}
	public void doc_DS_LoaiBUS() {
		LoaiSanPhamDAO loaiDAO = new LoaiSanPhamDAO();
		if(ds_LoaiBUS == null) {
			ds_LoaiBUS = new ArrayList<LoaiSanPhamDTO>();
		}
		ds_LoaiBUS = loaiDAO.doc_dsLoaiDAO();
	}
}
