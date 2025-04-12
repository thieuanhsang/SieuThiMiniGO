package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PhieuNhapHangDTO;

public class PhieuNhapHangDAO {
	ArrayList ds_PNH_DAO = new ArrayList<PhieuNhapHangDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	static boolean flagThem;
	public PhieuNhapHangDAO () {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public ArrayList<PhieuNhapHangDTO> doc_ds_PNH_DAO() {
		String qryString = "Select * from PhieuNhapHang";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryString);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				PhieuNhapHangDTO pnh = new PhieuNhapHangDTO();
				pnh.setMaPhieuNhapHang(rSet.getString("MaPhieuNhapHang"));
				pnh.setMaNhaCungCap(rSet.getString("MaNhaCungCap"));
				pnh.setMaNhanVien(rSet.getString("MaNhanVien"));
				pnh.setNgayLap(rSet.getString("NgayLap"));
				pnh.setTongTien(rSet.getString("TongTien"));
				ds_PNH_DAO.add(pnh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_PNH_DAO;	
	}
		public void them_PNH_DAO(PhieuNhapHangDTO pnh) {
			try {
				Statement statement = connection.createStatement();
				String qryString = "Insert into PhieuNhapHang values (";
				qryString = qryString + "'"+pnh.getMaPhieuNhapHang()+"'"+",";
				qryString = qryString + "'"+pnh.getMaNhaCungCap()+"'"+",";
				qryString = qryString + "'"+pnh.getMaNhanVien()+"'"+",";
				qryString = qryString + "'"+pnh.getNgayLap()+"'"+",";
				qryString = qryString + "'"+pnh.getTongTien()+"'"+")";
				statement.execute(qryString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
