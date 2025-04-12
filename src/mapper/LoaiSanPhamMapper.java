package mapper;

import DTO.LoaiSanPhamDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaiSanPhamMapper implements RowMapper<LoaiSanPhamDTO> {

  @Override
  public LoaiSanPhamDTO mapRow(ResultSet resultSet) {
    LoaiSanPhamDTO loaiSanPhamDTO = new LoaiSanPhamDTO();
    try {
      loaiSanPhamDTO.setMaLoai(resultSet.getString("MaLoai"));
      loaiSanPhamDTO.setTenLoai(resultSet.getString("TenLoai"));
      return loaiSanPhamDTO;
    } catch (SQLException e) {
      System.out.println("Lỗi ở Loại sản phẩm DTO: " + e.getMessage());
      return null;
    }
  }
}