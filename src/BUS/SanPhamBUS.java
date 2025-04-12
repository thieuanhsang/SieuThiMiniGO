package BUS;

import java.util.ArrayList;
import java.util.List;

//import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
//import javax.swing.JOptionPane;
//import java.util.List;

import DAO.SanPhamDAO;
import DTO.LoaiSanPhamDTO;
import DTO.SanPhamDTO;
import java.util.List;

//import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
//import javax.swing.JOptionPane;

import DAO.SanPhamDAO;
import DTO.LoaiSanPhamDTO;
import DTO.SanPhamDTO;

public class SanPhamBUS implements CRUD<SanPhamDTO> {
	public static ArrayList<SanPhamDTO> ds_SanPhamBUS;
	public static ArrayList<SanPhamDTO> ds_SanPhamTheoLoaiBUS;
	public static ArrayList<SanPhamDTO> ds_SanPhamTheoMaBUS;
	public static ArrayList<SanPhamDTO> kqTimNhanh;
	
	public void doc_ds_SanPhamBUS() {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		if(ds_SanPhamBUS == null) {
			ds_SanPhamBUS = new ArrayList<SanPhamDTO>();
		}
		ds_SanPhamBUS = sanPhamDAO.doc_ds_SanPhamDAO();
	}
	public void timkiemLoaiSP_BUS( String loai_duocchon) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		if(ds_SanPhamTheoLoaiBUS == null) {
			ds_SanPhamTheoLoaiBUS = new ArrayList<SanPhamDTO>();
		}
		ds_SanPhamTheoLoaiBUS = sanPhamDAO.timkiemLoaiSP_DAO(loai_duocchon);
	}
	public void timkiemSanPhamTheoMa_BUS( String MaSP) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		if(ds_SanPhamTheoMaBUS == null) {
			ds_SanPhamTheoMaBUS = new ArrayList<SanPhamDTO>();
		}
		ds_SanPhamTheoMaBUS = sanPhamDAO.timkiemSanPhamTheoMa_DAO(MaSP);
	}
	public void themSoLuongTonSP_BUS(String maSP_duocchon, String SoLuongTon) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		sanPhamDAO.themSoLuongTonSP_DAO(maSP_duocchon, SoLuongTon);
	}
	public void giamSoLuongTonSP_BUS(String maSP_duocchon, String SoLuongTon) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		sanPhamDAO.themSoLuongTonSP_DAO(maSP_duocchon, SoLuongTon);
	}
	public void docDSSP() {
		// TODO Auto-generated method stub
		
	}
	public ArrayList timSPNhanh (String input) {
		kqTimNhanh = new ArrayList<SanPhamDTO>();
		try {
			input = input.toLowerCase();
			for (SanPhamDTO sp : ds_SanPhamTheoLoaiBUS) {
				if(sp.getMaSanPham().toLowerCase().contains(input)||sp.getTenSanPham().toLowerCase().contains(input)||sp.getDonGia().toLowerCase().contains(input)||
						sp.getDonViTinh().toLowerCase().contains(input)||sp.getSoLuong().toLowerCase().contains(input)) {
							kqTimNhanh.add(sp);
						}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kqTimNhanh;
	}
	private SanPhamDAO sanPhamDAO;

    public SanPhamBUS() {
      sanPhamDAO = new SanPhamDAO();
    }

    @Override
    public void them(SanPhamDTO object) {
      sanPhamDAO.save(object);
    }

    @Override
    public void xoa(String ma) {
      sanPhamDAO.delete(ma);
    }

    @Override
    public void sua(SanPhamDTO object) {
      sanPhamDAO.update(object);
    }

    @Override
    public SanPhamDTO timKiem(String ma) {
      return sanPhamDAO.findOne(ma);
    }

    @Override
    public List<SanPhamDTO> findAll() {
      return sanPhamDAO.findAll();
    }

    public List<SanPhamDTO> findByCondition(String column, String data) {
      return sanPhamDAO.findByCondition(column, data);
    }

    public List<SanPhamDTO> findByConditionUseLike(String column, String data) {
      return sanPhamDAO.findWithLike(column, data);
    }
}
