package BUS;

import DAO.ChuongTrinhKhuyenMaiDAO;
import DTO.ChuongTrinhKhuyenMaiDTO;
import java.util.List;

public class ChuongTrinhKhuyenMaiBUS implements CRUD<ChuongTrinhKhuyenMaiDTO> {

  private ChuongTrinhKhuyenMaiDAO chuongTrinhKhuyenMaiDAO;

  public ChuongTrinhKhuyenMaiBUS() {
    chuongTrinhKhuyenMaiDAO = new ChuongTrinhKhuyenMaiDAO();
  }

  public void them(ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO) {
    chuongTrinhKhuyenMaiDAO.save(chuongTrinhKhuyenMaiDTO);
  }

  //Không xài Object để tránh lãng phí vùng nhớ
  public void xoa(String maChuongTrinh) {
    chuongTrinhKhuyenMaiDAO.delete(maChuongTrinh);
  }

  public void sua(ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO) {
    chuongTrinhKhuyenMaiDAO.update(chuongTrinhKhuyenMaiDTO);
  }

  public ChuongTrinhKhuyenMaiDTO timKiem(String maChuongTrinh) {
    return chuongTrinhKhuyenMaiDAO.findOne(maChuongTrinh);
  }

  public List<ChuongTrinhKhuyenMaiDTO> findAll() {
    return chuongTrinhKhuyenMaiDAO.findAll();
  }

  public List<ChuongTrinhKhuyenMaiDTO> findAllByCondition(String condition, String data) {
    return chuongTrinhKhuyenMaiDAO.findAllByCondition(condition, data
    );
  }

  public List<ChuongTrinhKhuyenMaiDTO> findByUseLike(String field, String data) {
    return chuongTrinhKhuyenMaiDAO.findByUseLike(field, data);
  }





}