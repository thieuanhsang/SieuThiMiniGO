package DAO;

import DTO.NhanVienDTO;
import DTO.SanPhamDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mapper.NhanVienMapper;

public class NhanVienDAO extends AbstractDAO<NhanVienDTO> {

	ArrayList ds_NhanVienDAO = new ArrayList<NhanVienDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	static boolean flagThem;
	public NhanVienDAO () {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public void save(NhanVienDTO nhanVienDTO) {  //check
    String[] fields = {"MaNhanVien", "HoNhanVien", "TenNhanVien", "NgayVaoLam", "ViTri", "Luong",
        "SoDienThoai",
        "Email"};
    super.save("nhanvien", fields, nhanVienDTO.getMaNhanVien(), nhanVienDTO.getHoNhanVien(),
        nhanVienDTO.getTenNhanVien(),
        nhanVienDTO.getNgayVaoLam(), nhanVienDTO.getViTri(), nhanVienDTO.getLuong(),
        nhanVienDTO.getSoDienThoai(), nhanVienDTO.getEmail());
  }

  public List<NhanVienDTO> findAll() { //check
    return super.findAll("nhanvien", new NhanVienMapper());
  }

  public NhanVienDTO findOne(String maNhanVien) { //check
    return super.findOne("nhanvien", "MaNhanVien", maNhanVien, new NhanVienMapper());
  }

  public void update(NhanVienDTO nhanVienDTO) {
//    StringBuilder sql = new StringBuilder("UPDATE `cuahangtienloi`.`nhanvien`");
//    sql.append(" SET  TenNhanVien = ?, NgayVaoLam = ?, ViTri = ?, Luong = ?,");
//    sql.append(" SoDienThoai = ?, Email = ? WHERE MaNhanVien = ?");
//    super.update(sql.toString(), nhanVienDTO.getTenNhanVien(), nhanVienDTO.getNgayVaoLam(),
//        nhanVienDTO.getViTri(), nhanVienDTO.getLuong(), nhanVienDTO.getSoDienThoai(),
//        nhanVienDTO.getEmail(), nhanVienDTO.getMaNhanVien());
    String[] fields = {"HoNhanVien", "TenNhanVien", "NgayVaoLam", "ViTri", "Luong", "SoDienThoai",
        "Email"};
    String[] condition = {"MaNhanVien"};
    super.update("nhanvien", fields, condition, nhanVienDTO.getHoNhanVien(),
        nhanVienDTO.getTenNhanVien(),
        nhanVienDTO.getNgayVaoLam(),
        nhanVienDTO.getViTri(), nhanVienDTO.getLuong(), nhanVienDTO.getSoDienThoai(),
        nhanVienDTO.getEmail(), nhanVienDTO.getMaNhanVien());
  }

  public void delete(String maNhanVien) {
    String[] condition = {"MaNhanVien"};
    delete("nhanvien", condition, maNhanVien);
  }

  public List<NhanVienDTO> findWithLike(String column, String data) {
    return findWithLike("nhanvien", column, new NhanVienMapper(), data);
  }


  public int count() {
    return findAll().size();
  }
  public ArrayList<NhanVienDTO> doc_ds_NhanVienDAO() {
		String qry = "Select * from NhanVien";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qry);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				NhanVienDTO nv = new NhanVienDTO();
				nv.setMaNhanVien(rSet.getString(1));
				nv.setHoNhanVien(rSet.getString(2));
				nv.setTenNhanVien(rSet.getString(3));
				nv.setSoDienThoai(rSet.getString(7));
				nv.setEmail(rSet.getString(8));
				ds_NhanVienDAO.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_NhanVienDAO;
	}
}