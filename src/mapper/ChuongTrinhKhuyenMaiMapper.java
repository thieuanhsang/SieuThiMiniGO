package mapper;

import DTO.ChuongTrinhKhuyenMaiDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuongTrinhKhuyenMaiMapper implements RowMapper<ChuongTrinhKhuyenMaiDTO> {

  @Override
  public ChuongTrinhKhuyenMaiDTO mapRow(ResultSet resultSet) {
    ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = new ChuongTrinhKhuyenMaiDTO();
    try {
      chuongTrinhKhuyenMaiDTO.setMaChuongTrinh(resultSet.getString("MaChuongTrinh"));
      chuongTrinhKhuyenMaiDTO.setTenKhuyenMai(resultSet.getString("TenKhuyenMai"));
      chuongTrinhKhuyenMaiDTO.setNgayBatDau(resultSet.getDate("NgayBatDau"));
      chuongTrinhKhuyenMaiDTO.setNgayKetThuc(resultSet.getDate("NgayKetThuc"));
      return chuongTrinhKhuyenMaiDTO;
    } catch (SQLException e) {
      System.out.println("Lỗi ở chương trình khuyến mãi mapper: " + e.getMessage());
      return null;
    }
  }
}