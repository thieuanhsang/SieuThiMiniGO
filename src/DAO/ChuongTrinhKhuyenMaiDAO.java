package DAO;

import DTO.ChuongTrinhKhuyenMaiDTO;
import java.util.List;
import mapper.ChuongTrinhKhuyenMaiMapper;

public class ChuongTrinhKhuyenMaiDAO extends AbstractDAO<ChuongTrinhKhuyenMaiDTO> {

  public void save(ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO) {  //check
    String[] fields = {"MaChuongTrinh", "TenKhuyenMai", "NgayBatDau", "NgayKetThuc"};
    super.save("chuongtrinhkhuyenmai", fields, chuongTrinhKhuyenMaiDTO.getMaChuongTrinh(),
        chuongTrinhKhuyenMaiDTO.getTenKhuyenMai(), chuongTrinhKhuyenMaiDTO.getNgayBatDau(),
        chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
  }

  public List<ChuongTrinhKhuyenMaiDTO> findAll() { //check

    return super.findAll("chuongtrinhkhuyenmai", new ChuongTrinhKhuyenMaiMapper());
  }

  public ChuongTrinhKhuyenMaiDTO findOne(String maChuongTrinh) { //check
    return super.findOne("chuongtrinhkhuyenmai", "MaChuongTrinh", maChuongTrinh,
        new ChuongTrinhKhuyenMaiMapper());
  }

  public void update(ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO) {
//    StringBuilder sql = new StringBuilder("UPDATE `cuahangtienloi`.`chuongtrinhkhuyenmai`");
//    sql.append(
//        " SET TenKhuyenMai = ?, NgayBatDau = ?, NgayKetThuc = ? WHERE MaChuongTrinh = ?");
//    super.update(sql.toString(),
//        chuongTrinhKhuyenMaiDTO.getTenKhuyenMai(), chuongTrinhKhuyenMaiDTO.getNgayBatDau(),
//        chuongTrinhKhuyenMaiDTO.getNgayKetThuc(), chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
    String[] fields = {"TenKhuyenMai", "NgayBatDau", "NgayKetThuc"};
    String[] condition = {"MaChuongTrinh"};
    super.update("chuongtrinhkhuyenmai", fields, condition,
        chuongTrinhKhuyenMaiDTO.getTenKhuyenMai(), chuongTrinhKhuyenMaiDTO.getNgayBatDau(),
        chuongTrinhKhuyenMaiDTO.getNgayKetThuc(), chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
  }

  public void delete(String maChuongTrinh) {
    String[] condition = {"MaChuongTrinh"};
    delete("chuongtrinhkhuyenmai", condition, maChuongTrinh);
  }

  public int count() {
    return findAll().size();
  }

  public List<ChuongTrinhKhuyenMaiDTO> findAllByCondition(String condition, String data) {
    return findAllByCondition("chuongtrinhkhuyenmai", condition, data,
        new ChuongTrinhKhuyenMaiMapper());
  }

  public List<ChuongTrinhKhuyenMaiDTO> findAllByConditions(String[] fields, Object... parameters) {
    return findAllByConditions("chuongtrinhkhuyenmai", fields, new ChuongTrinhKhuyenMaiMapper(),
        parameters);
  }

  public List<ChuongTrinhKhuyenMaiDTO> findByUseLike(String field, String data) {
    return findWithLike("chuongtrinhkhuyenmai", field, new ChuongTrinhKhuyenMaiMapper(), data);
  }




}