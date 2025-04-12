package mapper;

import DTO.ChiTietChuongTrinhKhuyenMaiDTO;
import java.sql.ResultSet;

public class ChiTietChuongTrinhKhuyenMaiMapper implements
    RowMapper<ChiTietChuongTrinhKhuyenMaiDTO> {

  @Override
  public ChiTietChuongTrinhKhuyenMaiDTO mapRow(ResultSet resultSet) {
    try {
      ChiTietChuongTrinhKhuyenMaiDTO chiTietChuongTrinhKhuyenMaiDTO = new ChiTietChuongTrinhKhuyenMaiDTO();
      chiTietChuongTrinhKhuyenMaiDTO.setMaChuongTrinh(resultSet.getString("MaChuongTrinh"));
      chiTietChuongTrinhKhuyenMaiDTO.setMaKhachHang(resultSet.getString("MaKhachHang"));
      chiTietChuongTrinhKhuyenMaiDTO.setPTGiam(resultSet.getString("%Giam"));
      return chiTietChuongTrinhKhuyenMaiDTO;
    } catch (Exception e) {
      System.out.println("Lỗi ở chi tiết chương trình khuyến mãi mapper: " + e.getMessage());
      return null;
    }
  }
}