package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import DTO.LoaiDTO;

public class LoaiDAO {
	ArrayList ds_LoaiDAO = new ArrayList<LoaiDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	static boolean flagThem;
	public LoaiDAO () {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public ArrayList<LoaiDTO> doc_dsLoaiDAO() {
		String qry = "Select * from LoaiSanPham";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qry);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				LoaiDTO loai = new LoaiDTO();
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
