package BUS;

import java.util.ArrayList;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDonDTO;

public class CTHoaDonBUS {
	public static ArrayList<CTHoaDonDTO> dscthd;
	public static ArrayList<CTHoaDonDTO> kqLoc;
	public static ArrayList<CTHoaDonDTO> kqTimNhanhCTHD;

	public CTHoaDonBUS() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void docDSCTHD() {
		CTHoaDonDAO data = new CTHoaDonDAO();
		if (dscthd==null) {
			dscthd=new ArrayList<CTHoaDonDTO>();
		}
		dscthd=data.docDSCTHD();
	}
	
	public void themCTHD(CTHoaDonDTO cthd) {
		dscthd = new ArrayList<CTHoaDonDTO>();
		CTHoaDonDAO data = new CTHoaDonDAO();
		data.themCTHD(cthd);
		if (CTHoaDonDAO.flagThem==true) {
			dscthd.add(cthd);
		}
	}
//	ArrayList LocHD (String ma) {
//		kqLoc = new ArrayList<CTHoaDonDTO>();
//		for (CTHoaDonDTO cthd : dscthd) {
//			if (cthd.getMaHoaDon().equals(ma)) {
//				kqLoc.add(cthd);
//			}
//		}
//		return kqLoc;
//	}
	public void locHD(String ma) {
		CTHoaDonDAO data = new CTHoaDonDAO();
		data.LocHD(ma);
		if (kqLoc== null) {
			kqLoc = new ArrayList<CTHoaDonDTO>();
		}
		kqLoc = data.LocHD(ma);
	}
	
	public void suaSoLuong(String ma, int soLuongCon) {
		CTHoaDonDAO data = new CTHoaDonDAO();
		data.suaSoLuong(ma, soLuongCon);
	}
	public ArrayList timNhanhCTHD (String input) {
		kqTimNhanhCTHD = new ArrayList<CTHoaDonDTO>();
		try {
			input = input.toLowerCase();
			for (CTHoaDonDTO cthd : dscthd) {
				if (cthd.getMaHoaDon().toLowerCase().contains(input)||cthd.getMaSanPham().toLowerCase().contains(input)||cthd.getTenSanPham().toLowerCase().contains(input)||
						cthd.getDonGia().toLowerCase().contains(input)||cthd.getSoLuong().toLowerCase().contains(input)||cthd.getThanhTien().toLowerCase().contains(input)) {
					kqTimNhanhCTHD.add(cthd);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kqTimNhanhCTHD;
	}
}
