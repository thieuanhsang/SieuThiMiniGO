package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChiTietChuongTrinhKhuyenMaiDTO;
import DTO.ChiTietPhieuNhapHangDTO;

public class ChiTietCTKM_DAO {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	public ChiTietCTKM_DAO() {
		// TODO Auto-generated constructor stub
		try {
			if(connection == null) {
				connection = connect.OPconnect();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ArrayList doc_DS_ChiTietCTKM() {
		ArrayList dsCTCTKM = new ArrayList<>();
		try {
			String qryString = "Select * from chitietchuongtrinhkhuyenmai";
			preparedStatement = connection.prepareStatement(qryString);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ChiTietChuongTrinhKhuyenMaiDTO ctctkm = new ChiTietChuongTrinhKhuyenMaiDTO();
				ctctkm.setMaChuongTrinh(resultSet.getString("MaChuongTrinh"));
				ctctkm.setMaKhachHang(resultSet.getString("MaKhachHang"));
				ctctkm.setPTGiam(resultSet.getString("%Giam"));
				dsCTCTKM.add(ctctkm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsCTCTKM;
	}
	public void themChiTietCTKM_DAO(ChiTietChuongTrinhKhuyenMaiDTO ctctkm) {
		
		try {
			String qryString = "Insert into chitietchuongtrinhkhuyenmai values (";
			qryString = qryString + "'"+ctctkm.getMaChuongTrinh()+"'"+",";
			qryString = qryString + "'"+ctctkm.getMaKhachHang()+"'"+",";
			qryString = qryString + "'"+ctctkm.getPTGiam()+"'"+")";
			preparedStatement = connection.prepareStatement(qryString);
			preparedStatement.executeUpdate();
			System.out.println("Success_CTCTKM");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void xoaChiTietCTKM_DAO(String MaCT,String MaKH) {
		try {
			String qryString = "Delete from chitietchuongtrinhkhuyenmai where `MaChuongTrinh` = '"+MaCT+"' AND `MaKhachHang` = '"+MaKH+"'";
			preparedStatement = connection.prepareStatement(qryString);
			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void suaChietCTKM_DAO(String PTGiam, String MaKH, String MaCT) {
		try {
			String qryString = "Update chitietchuongtrinhkhuyenmai set  `%Giam` = '"+PTGiam+"' where `MaKhachHang` = '"+MaKH+"' and `MaChuongTrinh` = '"+MaCT+"'";
			preparedStatement = connection.prepareStatement(qryString);
			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
