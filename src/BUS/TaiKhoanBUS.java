package BUS;
import java.util.ArrayList;
import java.util.List;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;

public class TaiKhoanBUS implements CRUD<TaiKhoanDTO> {
	public static ArrayList<TaiKhoanDTO> ds_TaiKhoan;
	private TaiKhoanDAO taiKhoanDAO;
	public TaiKhoanBUS() {
		taiKhoanDAO = new TaiKhoanDAO();
	}
	public void doc_DS_TaiKhoan() {
		TaiKhoanDAO dataTaiKhoanDAO = new TaiKhoanDAO();
		if(ds_TaiKhoan == null) {
			ds_TaiKhoan = new ArrayList<TaiKhoanDTO>();
		}
		ds_TaiKhoan = dataTaiKhoanDAO.docDSTK_DAO();
	}
	  @Override
	  public void them(TaiKhoanDTO object) {
	    taiKhoanDAO.save(object);
	  }

	  @Override
	  public void xoa(String ma) {
	    taiKhoanDAO.delete(ma);
	  }

	  @Override
	  public void sua(TaiKhoanDTO object) {
	    taiKhoanDAO.update(object);
	  }

	  @Override
	  public TaiKhoanDTO timKiem(String ma) {
	    return taiKhoanDAO.findOne(ma);
	  }

	  @Override
	  public List<TaiKhoanDTO> findAll() {
	    return taiKhoanDAO.findAll();
	  }

	  public List<TaiKhoanDTO> findWithLikeCondition(String column, String data) {
	    return taiKhoanDAO.findWithLike(column, data);
	  }

	  public List<TaiKhoanDTO> findByCondition(String column, String data) {
	    return taiKhoanDAO.findByCondition(column, data);
	  }
}
