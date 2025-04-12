package mapper;

import DTO.NhaSanXuatDTO;
import java.sql.ResultSet;

public class NhaSanXuatMapper implements RowMapper<NhaSanXuatDTO> {

  @Override
  public NhaSanXuatDTO mapRow(ResultSet resultSet) {
    NhaSanXuatDTO nhaSanXuatDTO = new NhaSanXuatDTO();
    try {
      nhaSanXuatDTO.setMaNhaSanXuat(resultSet.getString("MaNhaSanXuat"));
      nhaSanXuatDTO.setTenNhaSanXuat(resultSet.getString("TenNhaSanXuat"));
      nhaSanXuatDTO.setDiaChi(resultSet.getString("DiaChi"));
      nhaSanXuatDTO.setSoDienThoai(resultSet.getString("SoDienThoai"));
      return nhaSanXuatDTO;
    } catch (Exception e) {
      System.out.println("Lỗi ở Nhà sản xuất mapper: " + e.getMessage());
      return null;
    }
  }
}