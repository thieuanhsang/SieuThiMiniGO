package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableStringConverter;

import com.mysql.cj.xdevapi.Statement;

import DTO.KhachHangDTO;

public class KhachHangDAO {
	ArrayList<KhachHangDTO> ds_KhachHangDAO = new ArrayList<KhachHangDTO>();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	static boolean flagThem;
	public KhachHangDAO() {
		super();
		// TODO Auto-generated constructor stub
		if (connection==null) {
			connection=connect.OPconnect();
		}
	}
	public ArrayList<KhachHangDTO> doc_DS_KhachHangDAO(){
		ds_KhachHangDAO = new ArrayList<KhachHangDTO>();
		String qry = "Select * from KhachHang";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qry);
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				KhachHangDTO kh = new KhachHangDTO();
				kh.setMaKH(rSet.getString("MaKhachHang"));
				kh.setHoKH(rSet.getString("HoKhachHang"));
				kh.setTenKH(rSet.getString("TenKhachHang"));
				kh.setCCCD(rSet.getString("CMND/CCCD"));
				kh.setSDT(rSet.getString("SdtKhachHang"));
				ds_KhachHangDAO.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds_KhachHangDAO;
	}
	public void themKhachHang(KhachHangDTO kh) {
	try {
		java.sql.Statement statement = connection.createStatement();
		String qryThemKhachHang = "Insert into KhachHang values ( ";
		qryThemKhachHang = qryThemKhachHang + "'" +kh.getMaKH()+"'"+",";
		qryThemKhachHang = qryThemKhachHang + "'" +kh.getHoKH()+"'"+",";
		qryThemKhachHang = qryThemKhachHang + "'" +kh.getTenKH()+"'"+",";
		qryThemKhachHang = qryThemKhachHang + "'" +kh.getCCCD()+"'"+",";
		qryThemKhachHang = qryThemKhachHang + "'" +kh.getSDT()+"'";
		qryThemKhachHang = qryThemKhachHang + ")";
		statement.executeUpdate(qryThemKhachHang);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	}
	
	public void xoaKhachHang(String makh) {
		try {
			java.sql.Statement statement = connection.createStatement();
			String qryXoa = "Delete from KhachHang where `MaKhachHang` ='"+makh+"'"; // delete from khachhang where makhachhang = 'makh'
			statement.executeUpdate(qryXoa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void suaKhachHang(String makh, String ho, String ten, String cccd, String sdt) {
		try {
			java.sql.Statement statement = connection.createStatement();
			String cccdString = "CMND/CCCD";
			String qrySua = "Update KhachHang set `HoKhachHang` ='"+ho+"', `TenKhachHang` ='"+ten+"', `CMND/CCCD`= '"+cccd+"',`SdtKhachHang` ='"+sdt+"' where MaKhachHang ='"+makh+"'";
			statement.executeUpdate(qrySua);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}			
}

