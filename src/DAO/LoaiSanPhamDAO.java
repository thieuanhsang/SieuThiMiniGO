package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import DTO.LoaiSanPhamDTO;

public class LoaiSanPhamDAO {
	ArrayList ds_LoaiDAO = new ArrayList<LoaiSanPhamDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	static boolean flagThem;
	public LoaiSanPhamDAO () {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public ArrayList<LoaiSanPhamDTO> doc_dsLoaiDAO() {
		String qry = "Select * from LoaiSanPham";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qry);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				LoaiSanPhamDTO loai = new LoaiSanPhamDTO();
				loai.setMaLoai(rSet.getString("MaLoai"));
				loai.setTenLoai(rSet.getString("TenLoai"));
				ds_LoaiDAO.add(loai);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_LoaiDAO;
	}
}
