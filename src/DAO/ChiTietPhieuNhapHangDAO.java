package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChiTietPhieuNhapHangDTO;


public class ChiTietPhieuNhapHangDAO {
	ArrayList ds_CTPNH_timTheoMa_PNH_DAO = new ArrayList<ChiTietPhieuNhapHangDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	static boolean flagThem;
	public ChiTietPhieuNhapHangDAO () {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public ArrayList<ChiTietPhieuNhapHangDTO> timkiemTheoMA_PNH(String MaPNH) {
		String qryString ="Select * from ChiTietPhieuNhapHang where MaPhieuNhap = '"+MaPNH+"'";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryString);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				ChiTietPhieuNhapHangDTO ctpnh = new ChiTietPhieuNhapHangDTO();
				ctpnh.setMaPhieuNhap(rSet.getString("MaPhieuNhap"));
				ctpnh.setMaSanPham(rSet.getString("MaSanPham"));
				ctpnh.setSoLuong(rSet.getString("SoLuong"));
				ctpnh.setDonGia(rSet.getString("DonGia"));
				ctpnh.setThanhTien(rSet.getString("ThanhTien"));
				ds_CTPNH_timTheoMa_PNH_DAO.add(ctpnh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_CTPNH_timTheoMa_PNH_DAO;
	}
	
	public void them_CTPNH_DAO(ChiTietPhieuNhapHangDTO ctpnh) {
		try {
			Statement statement = connection.createStatement();
			String qryString = "Insert into ChiTietPhieuNhapHang values (";
			String qryString2 = "Update SanPham where MaSanPham = '"+ctpnh.getMaSanPham()+"'";
			qryString = qryString + "'"+ctpnh.getMaPhieuNhap()+"'"+",";
			qryString = qryString + "'"+ctpnh.getMaSanPham()+"'"+",";
			qryString = qryString + "'"+ctpnh.getSoLuong()+"'"+",";
			qryString = qryString + "'"+ctpnh.getDonGia()+"'"+",";
			qryString = qryString + "'"+ctpnh.getThanhTien()+"'"+")";
			statement.execute(qryString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
