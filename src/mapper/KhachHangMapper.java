package mapper;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHangMapper implements RowMapper<KhachHangDTO> {

  @Override
  public KhachHangDTO mapRow(ResultSet resultSet) {
    KhachHangDTO khachHangDTO = new KhachHangDTO();
    try {
      khachHangDTO.setMaKH(resultSet.getString("MaKhachHang"));
      khachHangDTO.setHoKH(resultSet.getString("HoKhachHang"));
      khachHangDTO.setTenKH(resultSet.getString("TenKhachHang"));
      khachHangDTO.setCCCD(resultSet.getString("CMND/CCCD"));
      khachHangDTO.setSDT(resultSet.getString("SdtKhachHang"));
      return khachHangDTO;
    } catch (SQLException e) {
      System.out.println("Lỗi ở khách hàng mapper: " + e.getMessage());
      return null;
    }
  }
}