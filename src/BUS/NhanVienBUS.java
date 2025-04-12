package BUS;

import DAO.NhanVienDAO;
import DTO.CTHoaDonDTO;
import DTO.NhanVienDTO;

import java.util.ArrayList;
import java.util.List;

public class NhanVienBUS implements CRUD<NhanVienDTO> {
	
public static ArrayList<NhanVienDTO> dsNhanVien, kqTimNhanhNV;
  private NhanVienDAO nhanVienDAO;

  public NhanVienBUS() {
    nhanVienDAO = new NhanVienDAO();
  }

  @Override
  public void them(NhanVienDTO object) {
    nhanVienDAO.save(object);
  }

  @Override
  public void xoa(String ma) {
    nhanVienDAO.delete(ma);
  }

  @Override
  public void sua(NhanVienDTO object) {
    nhanVienDAO.update(object);
  }

  @Override
  public NhanVienDTO timKiem(String ma) {
    return nhanVienDAO.findOne(ma);
  }

  @Override
  public List<NhanVienDTO> findAll() {
    return nhanVienDAO.findAll();
  }

  public List<NhanVienDTO> findWithLikeCondition(String column, String data) {
    return nhanVienDAO.findWithLike(column, data);
  }
  public void doc_DSNV () {
	  NhanVienDAO dataDao = new NhanVienDAO();
	  if (dsNhanVien == null) {
		  dsNhanVien = new ArrayList<NhanVienDTO>();
	  }
	  dsNhanVien = dataDao.doc_ds_NhanVienDAO();
  }
  
  public ArrayList timNhanhNV (String input) {
		kqTimNhanhNV = new ArrayList<NhanVienDTO>();
		try {
			input = input.toLowerCase();
			for (NhanVienDTO nv : dsNhanVien) {
				if (nv.getMaNhanVien().toLowerCase().contains(input)||nv.getHoNhanVien().toLowerCase().contains(input)||nv.getTenNhanVien().toLowerCase().contains(input)||nv.getSoDienThoai().toLowerCase().contains(input)||nv.getEmail().toLowerCase().contains(input)) {
					kqTimNhanhNV.add(nv);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kqTimNhanhNV;
	}
}