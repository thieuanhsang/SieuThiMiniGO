package BUS;

import java.util.ArrayList;

import DAO.LoaiDAO;
import DTO.LoaiDTO;

public class LoaiBUS {
	public static ArrayList<LoaiDTO> ds_LoaiBUS;
	public LoaiBUS() {
	}
	public void doc_DS_LoaiBUS() {
		LoaiDAO loaiDAO = new LoaiDAO();
		if(ds_LoaiBUS == null) {
			ds_LoaiBUS = new ArrayList<LoaiDTO>();
		}
		ds_LoaiBUS = loaiDAO.doc_dsLoaiDAO();
	}
}
