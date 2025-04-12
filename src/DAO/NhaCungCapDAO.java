package DAO;

import DTO.NhaCungCapDTO;
import java.util.List;
import mapper.NhaCungCapMapper;

public class NhaCungCapDAO extends AbstractDAO<NhaCungCapDTO> {

  public void save(NhaCungCapDTO nhaCungCapDTO) {  //check
    String[] fields = {"MaNhaCungCap", "TenNhaCungCap", "DiaChi", "Sdt", "Email"};
    super.save("nhacungcap", fields, nhaCungCapDTO.getMaNhaCungCap(),
        nhaCungCapDTO.getTenNhaCungCap(), nhaCungCapDTO.getDiaChi(), nhaCungCapDTO.getSdt(),
        nhaCungCapDTO.getEmail());
  }

  public List<NhaCungCapDTO> findAll() { //check
    return super.findAll("nhacungcap", new NhaCungCapMapper());
  }

  public NhaCungCapDTO findOne(String maNhaCungCap) { //check
    return super.findOne("nhacungcap", "MaNhaCungCap", maNhaCungCap, new NhaCungCapMapper());
  }

  public void update(NhaCungCapDTO nhaCungCapDTO) {
    String[] fields = {"TenNhaCungCap", "DiaChi", "Sdt", "Email"};
    String[] condition = {"MaNhaCungCap"};
    super.update("nhacungcap", fields, condition, nhaCungCapDTO.getTenNhaCungCap(),
        nhaCungCapDTO.getDiaChi(),
        nhaCungCapDTO.getSdt(), nhaCungCapDTO.getEmail(), nhaCungCapDTO.getMaNhaCungCap());
  }




  public void abc (NhaCungCapDTO object){
    if (!object.equals(null)){
      try {
        String[] fields = {"ten", "diachi", "sdt", "mail"};
        String[] condition = {"ma"};
        super.update("nhacungcap", fields, condition, object.getTenNhaCungCap(),
                object.getDiaChi(),
                object.getSdt(), object.getEmail(), object.getMaNhaCungCap());
      } catch (Exception e){
        e.printStackTrace();
      }
    }
  }




  public void delete(String maNhaCungCap) {
    String[] condition = {"MaNhaCungCap"};
    delete("nhacungcap", condition, maNhaCungCap);
  }

  public List<NhaCungCapDTO> findByCondition(String column, String data) {
    return super.findAllByCondition("nhacungcap", column, data, new NhaCungCapMapper());
  }

  public List<NhaCungCapDTO> findWithLike(String column, String data) {
    return findWithLike("nhacungcap", column, new NhaCungCapMapper(), data);
  }

  public int count() {
    return findAll().size();
  }
}