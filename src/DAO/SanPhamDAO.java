package DAO;
import java.util.List;
import mapper.SanPhamMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import DTO.SanPhamDTO;

public class SanPhamDAO extends AbstractDAO<SanPhamDTO>{
	ArrayList ds_SanPhamDAO = new ArrayList<SanPhamDTO>();
	ArrayList ds_SanPhamTheoLoai_DAO = new ArrayList<SanPhamDTO>();
	ArrayList ds_SanPhamTheoMa_DAO = new ArrayList<SanPhamDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	static boolean flagThem;
	public SanPhamDAO () {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public ArrayList<SanPhamDTO> doc_ds_SanPhamDAO() {
		String qry = "Select * from SanPham";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qry);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				SanPhamDTO sp= new SanPhamDTO();
				sp.setMaSanPham(rSet.getString("MaSanPham"));
				sp.setTenSanPham(rSet.getString("TenSanPham"));
				sp.setDonGia(rSet.getString("DonGia"));
				sp.setDonViTinh(rSet.getString("DonViTinh"));
				sp.setSoLuong(rSet.getString("SoLuong"));
				sp.setMaLoai(rSet.getString("MaLoai"));
				sp.setMaNhaSanXuat(rSet.getString("MaNhaSanXuat"));
				ds_SanPhamDAO.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_SanPhamDAO;
	}
	public ArrayList<SanPhamDTO> timkiemLoaiSP_DAO(String loai_duocchon) {
		String qryFindLoai = "Select * from SanPham where MaLoai = '"+loai_duocchon+"'";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryFindLoai);
			ResultSet rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				SanPhamDTO sp= new SanPhamDTO();
				sp.setMaSanPham(rSet.getString("MaSanPham"));
				sp.setTenSanPham(rSet.getString("TenSanPham"));
				sp.setDonGia(rSet.getString("DonGia"));
				sp.setDonViTinh(rSet.getString("DonViTinh"));
				sp.setSoLuong(rSet.getString("SoLuong"));
				sp.setMaLoai(rSet.getString("MaLoai"));
				sp.setMaNhaSanXuat(rSet.getString("MaNhaSanXuat"));
				ds_SanPhamTheoLoai_DAO.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_SanPhamTheoLoai_DAO;
	}
	
	public ArrayList<SanPhamDTO> timkiemSanPhamTheoMa_DAO(String MaSP) {
		String qryFindSanPham = "Select * from SanPham where MaSanPham = '"+MaSP+"'";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryFindSanPham);
			ResultSet rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				SanPhamDTO sp= new SanPhamDTO();
				sp.setMaSanPham(rSet.getString("MaSanPham"));
				sp.setTenSanPham(rSet.getString("TenSanPham"));
				sp.setDonGia(rSet.getString("DonGia"));
				sp.setDonViTinh(rSet.getString("DonViTinh"));
				sp.setSoLuong(rSet.getString("SoLuong"));
				sp.setMaLoai(rSet.getString("MaLoai"));
				sp.setMaNhaSanXuat(rSet.getString("MaNhaSanXuat"));
				ds_SanPhamTheoMa_DAO.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_SanPhamTheoMa_DAO;
	}
	public void themSoLuongTonSP_DAO(String maSP_duocchon, String SoLuongTon) {
		String qryThemSoLuong = "Update  SanPham set `SoLuong` = '"+SoLuongTon+"' where MaSanPham ='"+maSP_duocchon+"'";
		try {
			Statement statement = connection.createStatement();
			statement.execute(qryThemSoLuong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void giamSoLuongTonSP_DAO(String maSP_duocchon, String SoLuongTon) {
		String qrygiamSoLuong = "Update  SanPham set `SoLuong` = '"+SoLuongTon+"' where MaSanPham ='"+maSP_duocchon+"'";
		try {
			Statement statement = connection.createStatement();
			statement.execute(qrygiamSoLuong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//sang tam
	public void save(SanPhamDTO sanpham) {  //check
	    String[] fields = {"MaSanPham", "TenSanPham", "DonGia", "DonViTinh", "SoLuong", "MaLoai",
	        "MaNhaSanXuat"};
	    super.save("sanpham", fields, sanpham.getMaSanPham(), sanpham.getTenSanPham(),
	        sanpham.getDonGia(), sanpham.getDonViTinh(), sanpham.getSoLuong(), sanpham.getMaLoai(),
	        sanpham.getMaNhaSanXuat());
	  }

	  public List<SanPhamDTO> findAll() { //check
	    return super.findAll("sanpham", new SanPhamMapper());
	  }

	  //  public SanPhamDTO findOne(String maSanPham) { //check
//	    StringBuilder sql = new StringBuilder("SELECT * FROM `cuahangtienloi`.`sanpham`");
//	    sql.append(" WHERE MaSanPham = ?");
//	    List<SanPhamDTO> resultList = query(sql.toString(), new SanPhamMapper(), maSanPham);
//	    return resultList.isEmpty() ? null : resultList.get(0);
	//  }
	  public SanPhamDTO findOne(String maSanPham) { //check

	    return super.findOne("sanpham", "MaSanPham", maSanPham, new SanPhamMapper());
	  }

	  public void update(SanPhamDTO sanPham) {
//	    StringBuilder sql = new StringBuilder("UPDATE `cuahangtienloi`.`sanpham`");
//	    sql.append(" SET  TenSanPham = ?, DonGia = ?, DonViTinh = ?, SoLuong = ?,");
//	    sql.append(" MaLoai = ?, MaNhaSanXuat = ? WHERE MaSanPham = ?");
//	    super.update(sql.toString(), sanPham.getTenSanPham(),
//	        sanPham.getDonGia(), sanPham.getDonViTinh(), sanPham.getSoLuong(), sanPham.getMaSanPham());
	    String[] fields = {"TenSanPham", "DonGia", "DonViTinh", "SoLuong", "MaLoai", "MaNhaSanXuat"};
	    String[] condition = {"MaSanPham"};
	    super.update("sanpham", fields, condition, sanPham.getTenSanPham(),
	        sanPham.getDonGia(), sanPham.getDonViTinh(), sanPham.getSoLuong(), sanPham.getMaLoai(),
	        sanPham.getMaNhaSanXuat(),
	        sanPham.getMaSanPham());
	  }

	  public void delete(String maSanPham) {
	    String[] condition = {"MaSanPham"};
	    delete("sanpham", condition, maSanPham);
	  }

	  public int count() {
	    return findAll().size();
	  }

	  public List<SanPhamDTO> findByCondition(String column, String data) {
	    return super.findAllByCondition("sanpham", column, data, new SanPhamMapper());
	  }

	  public List<SanPhamDTO> findWithLike(String column, String data) {
	    return findWithLike("sanpham", column, new SanPhamMapper(), data);
	  }
}
