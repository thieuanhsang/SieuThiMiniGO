package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.AsyncBoxView.ChildLocator;

import DTO.CTHoaDonDTO;


public class ChiTietHoaDonDAO {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	public static boolean flagThem;
	public ChiTietHoaDonDAO() {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public ArrayList docDSCTHD() {
		ArrayList<CTHoaDonDTO> dscthd = new ArrayList<CTHoaDonDTO>();
		try {
			String qry = "select * from chitiethoadon";
			preparedStatement = connection.prepareStatement(qry);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CTHoaDonDTO cthd = new CTHoaDonDTO();
				cthd.setMaHoaDon(resultSet.getString(1));
				cthd.setMaSanPham(resultSet.getString(2));
				cthd.setTenSanPham(resultSet.getString(3));
				cthd.setDonGia(resultSet.getString(4));
				cthd.setSoLuong(resultSet.getString(5));
				cthd.setThanhTien(resultSet.getString(6));
				dscthd.add(cthd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lá»—i Ä‘á»�c chi tiáº¿t hÃ³a Ä‘Æ¡n");
		}
		return dscthd;
	}
	public void themCTHD(CTHoaDonDTO cthd) {
		try {
			String qry = "Insert into chitiethoadon Values ('"+ cthd.getMaHoaDon()+"','"+cthd.getMaSanPham()+"','"+cthd.getTenSanPham()+"','"+
		cthd.getDonGia()+"','"+cthd.getSoLuong()+"','"+cthd.getThanhTien()+"')";
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.executeUpdate(qry);
			flagThem = true;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lá»—i thÃªm vÃ o chi tiáº¿t hÃ³a Ä‘Æ¡n");
		}
	}
	public ArrayList LocHD(String ma) {
		ArrayList kqLoc = new ArrayList<>();
		try {
			String qry = "select * from chitiethoadon where MaHoaDon In ('"+ma+"')";
			preparedStatement = connection.prepareStatement(qry);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CTHoaDonDTO cthd = new CTHoaDonDTO();
				cthd.setMaHoaDon(resultSet.getString(1));
				cthd.setMaSanPham(resultSet.getString(2));
				cthd.setTenSanPham(resultSet.getString(3));
				cthd.setDonGia(resultSet.getString(4));
				cthd.setSoLuong(resultSet.getString(5));
				cthd.setThanhTien(resultSet.getString(6));
				kqLoc.add(cthd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lá»—i lá»�c theo mÃ£");
		}
		return kqLoc;
	}
	public void suaSoLuong (String ma, int soLuongCon) {
		try {
			String qry = "Update sanpham Set SoLuong='"+soLuongCon+"' where MaSanPham='"+ma+"'";
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lá»—i sá»­a sá»‘ lÆ°á»£ng");
		}
	}
	void xoaCTHD (String ma) {
		try {
			String qry = "Delete from chitiethoadon where MaSanPham='"+ma+"'";
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.executeUpdate();
			flagThem=true;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lá»—i xÃ³a chi tiáº¿t hÃ³a Ä‘Æ¡n");
		}
	}
}
