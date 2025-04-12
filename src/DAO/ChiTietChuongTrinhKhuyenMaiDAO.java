package DAO;

import DTO.ChiTietChuongTrinhKhuyenMaiDTO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import mapper.ChiTietChuongTrinhKhuyenMaiMapper;

public class ChiTietChuongTrinhKhuyenMaiDAO extends AbstractDAO<ChiTietChuongTrinhKhuyenMaiDTO> {
  //    public void save(ChiTietChuongTrinhKhuyenMaiDTO chiTietChuongTrinhKhuyenMaiDTO) {  //check
//    StringBuilder stringBuilder = new StringBuilder(
//        "INSERT INTO `cuahangtienloi`.`chitietchuongtrinhkhuyenmai` ");
//    stringBuilder.append(
//        " (MaChuongTrinh, MaSanPham, `%Giam`)");
//    stringBuilder.append(
//        " VALUES (?, ?, ?);");
//    insert(stringBuilder.toString(), chiTietChuongTrinhKhuyenMaiDTO.getMaChuongTrinh(),
//        chiTietChuongTrinhKhuyenMaiDTO.getMaSanPham(),
//        chiTietChuongTrinhKhuyenMaiDTO.getPhanTramGiam());
//  }
  public void save(ChiTietChuongTrinhKhuyenMaiDTO chiTietChuongTrinhKhuyenMaiDTO) {
    String[] fields = {"MaChuongTrinh", "MaSanPham", "`%Giam`"};
    super.save("`chitietchuongtrinhkhuyenmai`", fields,
        chiTietChuongTrinhKhuyenMaiDTO.getMaChuongTrinh(),
        chiTietChuongTrinhKhuyenMaiDTO.getMaKhachHang(),
        chiTietChuongTrinhKhuyenMaiDTO.getPTGiam());
  }

  public List<ChiTietChuongTrinhKhuyenMaiDTO> findAll() { //check
    return super.findAll("chitietchuongtrinhkhuyenmai", new ChiTietChuongTrinhKhuyenMaiMapper());
  }

  public List<ChiTietChuongTrinhKhuyenMaiDTO> findAllByMaChuongTrinh(String maChuongTrinh) { //check
    return super.findAllByCondition("chitietchuongtrinhkhuyenmai", "MaChuongTrinh", maChuongTrinh,
        new ChiTietChuongTrinhKhuyenMaiMapper());
  }

  public ChiTietChuongTrinhKhuyenMaiDTO findOne(String maChuongTrinh) { //check
    return super.findOne("chitietchuongtrinhkhuyenmai", "MaChuongTrinh", maChuongTrinh,
        new ChiTietChuongTrinhKhuyenMaiMapper());
  }

  public ChiTietChuongTrinhKhuyenMaiDTO findOne(String maChuongTrinh, String maSanPham) { //check
    return super.findOne("chitietchuongtrinhkhuyenmai", "MaChuongTrinh", maChuongTrinh,
        new ChiTietChuongTrinhKhuyenMaiMapper(), "MaSanPham", maSanPham);
  }

  public void update(
      ChiTietChuongTrinhKhuyenMaiDTO chiTietChuongTrinhKhuyenMaiDTO) {
    //do table quan hệ OneToMany nên khi sửa phải thêm mã sản phẩm trong where)
    String[] fields = {"`%Giam`"};
    String[] condition = {"MaChuongTrinh", "MaSanPham"};
    super.update("chitietchuongtrinhkhuyenmai", fields, condition,
        chiTietChuongTrinhKhuyenMaiDTO.getPTGiam(),
        chiTietChuongTrinhKhuyenMaiDTO.getMaChuongTrinh(),
        chiTietChuongTrinhKhuyenMaiDTO.getMaKhachHang());
  }

  public void delete(String maChuongTrinh,
      String maSanPham) {  //do table quan hệ OneToMany nên khi xóa dính lỗi Duplicate(trùng)
    String[] condition = {"MaChuongTrinh", "MaSanPham"};
    delete("chitietchuongtrinhkhuyenmai", condition, maChuongTrinh, maSanPham);
  }

  public int count() {
    return findAll().size();
  }

  public int countByMaChuongTrinh(String maChuongTrinh) {
    return findAllByMaChuongTrinh(maChuongTrinh).size();
  }
}