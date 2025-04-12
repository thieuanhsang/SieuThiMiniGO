package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.CTCTKhuyenMaiDTO;
import DTO.HoaDonDTO;

public class HoaDonDAO {
	public static boolean flag;
	public static boolean flagSua;
	public static boolean flagXoa;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	MySQLConnect connect = new MySQLConnect();
	public HoaDonDAO() {
		if (connection==null) {
			try {
				connection=connect.OPconnect();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public ArrayList docDSHD() {
		ArrayList dshd = new ArrayList<HoaDonDTO>();
		try {
			String qry = "select * from hoadon";
			preparedStatement = connection.prepareStatement(qry);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HoaDonDTO hd = new HoaDonDTO();
				hd.setMaHD(resultSet.getString(1));
				hd.setMaNV(resultSet.getString(2));
				hd.setMaKH(resultSet.getString(3));
				hd.setNgayLap(resultSet.getString(4));
				hd.setTongTien(resultSet.getString(5));
				dshd.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu!");
		}
		return dshd;
	}
	
	public void them(HoaDonDTO hd) {
		try {
			String qry = "Insert into hoadon Values ('"+hd.getMaHD()+"','"+hd.getMaNV()+"','"+
		hd.getMaKH()+"','"+hd.getNgayLap()+"','"+hd.getTongTien()+"')";
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.executeUpdate(qry);
			flag= true;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!");
			flag= false;
		}
	}
	public void sua(HoaDonDTO hd) {
		try {
			String qry = "Update hoadon set MaNhanVien='"+hd.getMaNV()+"',MaKhachHang='"+hd.getMaKH()+
					"',NgayLap='"+hd.getNgayLap()+"',TongTien='"+hd.getTongTien()+"' where MaHoaDon='"+hd.getMaHD()+"'";
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.executeUpdate(qry);
			flagSua= true;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi sửa hóa đơn");
			flagSua=false;
		}
	}
	public void xoa(String ma) {
		try {
			String qry = "Delete from hoadon where MaHoaDon='"+ma+"'";
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.executeUpdate(qry);
			flagXoa= true;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi xóa hóa đơn!");
		}
	}
	public ArrayList timHDTheoMa(String ma) {
		ArrayList kq = new ArrayList<HoaDonDTO>();
		try {
			String qry = "select * from hoadon where MaHoaDon In ('"+ma+"')";
			preparedStatement = connection.prepareStatement(qry);
			resultSet = preparedStatement.executeQuery();
		    while(resultSet.next()) {
		    	HoaDonDTO hd = new HoaDonDTO();
				hd.setMaHD(resultSet.getString(1));
				hd.setMaNV(resultSet.getString(2));
				hd.setMaKH(resultSet.getString(3));
				hd.setNgayLap(resultSet.getString(4));
				hd.setTongTien(resultSet.getString(5));
				kq.add(hd);
		    }
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Tìm không thành công!");
		}
		return kq;
	}
	public ArrayList timTheoKhoangTien (String input1, String input2) {
		ArrayList kq = new ArrayList<HoaDonDTO>();
		try {
			String qry = "select * from hoadon where TongTien BETWEEN "+input1 + " AND " + input2;
			preparedStatement = connection.prepareStatement(qry);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				HoaDonDTO hd = new HoaDonDTO();
				hd.setMaHD(resultSet.getString(1));
				hd.setMaNV(resultSet.getString(2));
				hd.setMaKH(resultSet.getString(3));
				hd.setNgayLap(resultSet.getString(4));
				hd.setTongTien(resultSet.getString(5));
				kq.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Tìm không thành công!");
		}
		return kq;
	}
	public ArrayList timMaNVorMaKH (String input1, String input2) {
		ArrayList kq = new ArrayList<HoaDonDTO>();
		try {
			String qry = "select * from hoadon where MaNhanVien= '"+input1+"' OR MaKhachHang='"+input2+"'";
			preparedStatement = connection.prepareStatement(qry);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				HoaDonDTO hd = new HoaDonDTO();
				hd.setMaHD(resultSet.getString(1));
				hd.setMaNV(resultSet.getString(2));
				hd.setMaKH(resultSet.getString(3));
				hd.setNgayLap(resultSet.getString(4));
				hd.setTongTien(resultSet.getString(5));
				kq.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Lỗi tìm");
		}
		return kq;
	}
	public ArrayList checkKhuyenMai(String maKH) {
		ArrayList kqCheck= new ArrayList<CTCTKhuyenMaiDTO>();
		try {
			String qry = "select * from chitietchuongtrinhkhuyenmai where MaKhachHang='"+maKH+"'";
			preparedStatement = connection.prepareStatement(qry);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CTCTKhuyenMaiDTO ctctkm = new CTCTKhuyenMaiDTO();
				ctctkm.setMaChuongTrinh(resultSet.getString(1));
				ctctkm.setMaKhachHang(resultSet.getString(2));
				ctctkm.setPTGiam(resultSet.getString(3));
				kqCheck.add(ctctkm);
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return kqCheck;
	}
}
