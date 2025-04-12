package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.List;

public class NhaCungCapBUS implements CRUD<NhaCungCapDTO> {

  private NhaCungCapDAO nhaCungCapDAO;

  public NhaCungCapBUS() {
    nhaCungCapDAO = new NhaCungCapDAO();
  }

  @Override
  public void them(NhaCungCapDTO object) {
    nhaCungCapDAO.save(object);
  }

  @Override
  public void xoa(String ma) {
    nhaCungCapDAO.delete(ma);
  }

  @Override
  public void sua(NhaCungCapDTO object) {
    nhaCungCapDAO.update(object);
  }

  @Override
  public NhaCungCapDTO timKiem(String ma) {
    return nhaCungCapDAO.findOne(ma);
  }

  @Override
  public List<NhaCungCapDTO> findAll() {
    return nhaCungCapDAO.findAll();
  }

  public List<NhaCungCapDTO> findWithLikeCondition(String column, String data) {
    return nhaCungCapDAO.findWithLike(column, data);
  }

  public List<NhaCungCapDTO> findByCondition(String column, String data) {
    return nhaCungCapDAO.findByCondition(column, data);
  }
}