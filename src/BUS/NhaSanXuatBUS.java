package BUS;

import DAO.NhaSanXuatDAO;
import DTO.NhaSanXuatDTO;
import java.util.List;

public class NhaSanXuatBUS implements CRUD<NhaSanXuatDTO> {

  private NhaSanXuatDAO nhaSanXuatDAO;

  public NhaSanXuatBUS() {
    nhaSanXuatDAO = new NhaSanXuatDAO();
  }

  @Override
  public void them(NhaSanXuatDTO object) {
    nhaSanXuatDAO.save(object);
  }

  @Override
  public void xoa(String ma) {
    nhaSanXuatDAO.delete(ma);
  }

  @Override
  public void sua(NhaSanXuatDTO object) {
    nhaSanXuatDAO.update(object);
  }

  @Override
  public NhaSanXuatDTO timKiem(String ma) {
    return nhaSanXuatDAO.findOne(ma);
  }

  @Override
  public List<NhaSanXuatDTO> findAll() {
    return nhaSanXuatDAO.findAll();
  }

  public List<NhaSanXuatDTO> findWithLikeCondition(String column, String data) {
    return nhaSanXuatDAO.findWithLike(column, data);
  }

  public List<NhaSanXuatDTO> findByCondition(String column, String data) {
    return nhaSanXuatDAO.findByCondition(column, data);
  }
}