package mapper;

import DTO.TaiKhoanDTO;
import java.sql.ResultSet;

public class TaiKhoanMapper implements RowMapper<TaiKhoanDTO> {

  @Override
  public TaiKhoanDTO mapRow(ResultSet resultSet) {
    TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
    try {
      taiKhoanDTO.setMaTaiKhoan(resultSet.getString("MaTaiKhoan"));
      taiKhoanDTO.setTenTaiKhoan(resultSet.getString("TenTaiKhoan"));
      taiKhoanDTO.setMaNV(resultSet.getString("MaNhanVien"));
      taiKhoanDTO.setMatKhau(resultSet.getString("MatKhau"));
      taiKhoanDTO.setPhanQuyen(resultSet.getString("PhanQuyen"));
      return taiKhoanDTO;
    } catch (Exception e) {
      System.out.println("Lỗi ở TaiKhoanmapper: " + e.getMessage());
      return null;
    }
  }
}