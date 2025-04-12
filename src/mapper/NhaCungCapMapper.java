package mapper;

import DTO.NhaCungCapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhaCungCapMapper implements RowMapper<NhaCungCapDTO> {

  @Override
  public NhaCungCapDTO mapRow(ResultSet resultSet) {
    NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
    try {
      nhaCungCapDTO.setMaNhaCungCap(resultSet.getString("MaNhaCungCap"));
      nhaCungCapDTO.setTenNhaCungCap(resultSet.getString("TenNhaCungCap"));
      nhaCungCapDTO.setEmail(resultSet.getString("Email"));
      nhaCungCapDTO.setDiaChi(resultSet.getString("DiaChi"));
      nhaCungCapDTO.setSdt(resultSet.getString("Sdt"));
      return nhaCungCapDTO;
    } catch (SQLException e) {
      System.out.println("Lỗi ở nhà cung cấp mapper: " + e.getMessage());
      return null;
    }
  }
}