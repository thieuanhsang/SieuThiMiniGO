package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import mapper.TaiKhoanMapper;

import DTO.TaiKhoanDTO;

public class TaiKhoanDAO extends AbstractDAO<TaiKhoanDTO>{
	ArrayList ds_TaiKhoanDAO;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	static boolean flagThem;
	public TaiKhoanDAO () {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public ArrayList<TaiKhoanDTO> docDSTK_DAO(){
		ds_TaiKhoanDAO = new ArrayList<TaiKhoanDTO>();
		String qryString = "Select * from TaiKhoan";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryString);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				TaiKhoanDTO tk = new TaiKhoanDTO();
				tk.setMaTaiKhoan(rSet.getString("MaTaiKhoan"));
				tk.setTenTaiKhoan(rSet.getString("TenTaiKhoan"));
				tk.setMatKhau(rSet.getString("MatKhau"));
				tk.setPhanQuyen(rSet.getString("PhanQuyen"));
				tk.setMaNV(rSet.getString("MaNhanVien"));
				ds_TaiKhoanDAO.add(tk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_TaiKhoanDAO;
	}
	public void save(TaiKhoanDTO taiKhoanDTO) {  //check
	    String[] fields = {"MaTaiKhoan", "TenTaiKhoan", "MatKhau", "PhanQuyen", "MaNhanVien"};
	    super.save("taikhoan", fields, taiKhoanDTO.getMaTaiKhoan(), taiKhoanDTO.getTenTaiKhoan(),
	        taiKhoanDTO.getMatKhau(), taiKhoanDTO.getPhanQuyen(), taiKhoanDTO.getMaNV());
	  }

	  public List<TaiKhoanDTO> findAll() { //check
	    return super.findAll("taikhoan", new TaiKhoanMapper());
	  }

	  public TaiKhoanDTO findOne(String maTaiKhoan) { //check
	    return super.findOne("taikhoan", "MaTaiKhoan", maTaiKhoan,
	        new TaiKhoanMapper());
	  }

	  public void update(TaiKhoanDTO taiKhoanDTO) {
	    String[] fields = {"TenTaiKhoan", "MatKhau", "PhanQuyen"};
	    String[] condition = {"MaTaiKhoan", "MaNhanVien"};
	    super.update("taikhoan", fields, condition, taiKhoanDTO.getTenTaiKhoan(),
	        taiKhoanDTO.getMatKhau(), taiKhoanDTO.getPhanQuyen(),
	        taiKhoanDTO.getMaTaiKhoan(), taiKhoanDTO.getMaNV());
	  }

	  public void delete(String maTaiKhoan) {
	    String[] condition = {"MaTaiKhoan"};
	    delete("taikhoan", condition, maTaiKhoan);
	  }

	  public List<TaiKhoanDTO> findByCondition(String column, String data) {
	    return super.findAllByCondition("taikhoan", column, data, new TaiKhoanMapper());
	  }

	  public List<TaiKhoanDTO> findWithLike(String column, String data) {
	    return findWithLike("taikhoan", column, new TaiKhoanMapper(), data);
	  }

	  public int count() {
	    return findAll().size();
	  }
}
