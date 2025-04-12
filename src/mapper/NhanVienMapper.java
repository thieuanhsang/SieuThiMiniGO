package mapper;

import DTO.NhanVienDTO;
import java.sql.ResultSet;

public class NhanVienMapper implements RowMapper<NhanVienDTO> {

  @Override
  public NhanVienDTO mapRow(ResultSet resultSet) {
    NhanVienDTO nhanVienDTO = new NhanVienDTO();
    try {
      nhanVienDTO.setMaNhanVien(resultSet.getString("MaNhanVien"));
      nhanVienDTO.setHoNhanVien(resultSet.getString("HoNhanVien"));
      nhanVienDTO.setTenNhanVien(resultSet.getString("TenNhanVien"));
      nhanVienDTO.setEmail(resultSet.getString("Email"));
      nhanVienDTO.setLuong(resultSet.getInt("Luong"));
      nhanVienDTO.setNgayVaoLam(resultSet.getDate("NgayVaoLam"));
      nhanVienDTO.setViTri(resultSet.getString("ViTri"));
      nhanVienDTO.setSoDienThoai(resultSet.getString("SoDienThoai"));
      return nhanVienDTO;
    } catch (Exception e) {
      System.out.println("Lỗi ở NhanVienMapper : " + e.getMessage());
      return null;
    }
  }
}