package DAO;

import DTO.NhaSanXuatDTO;
import DTO.TaiKhoanDTO;
import java.util.List;
import mapper.NhaSanXuatMapper;
import mapper.TaiKhoanMapper;

public class NhaSanXuatDAO extends AbstractDAO<NhaSanXuatDTO> {

  public void save(NhaSanXuatDTO nhaSanXuatDTO) {  //check
    String[] fields = {"MaNhaSanXuat", "TenNhaSanXuat", "DiaChi", "SoDienThoai"};
    super.save("nhasanxuat", fields, nhaSanXuatDTO.getMaNhaSanXuat(),
        nhaSanXuatDTO.getTenNhaSanXuat(), nhaSanXuatDTO.getDiaChi(),
        nhaSanXuatDTO.getSoDienThoai());
  }

  public List<NhaSanXuatDTO> findAll() { //check
    return super.findAll("nhasanxuat", new NhaSanXuatMapper());
  }

  public NhaSanXuatDTO findOne(String maNhaSanXuat) { //check
    return super.findOne("nhasanxuat", "manhasanxuat", maNhaSanXuat, new NhaSanXuatMapper());
  }

  public void update(NhaSanXuatDTO nhaSanXuatDTO) {
    String[] fields = {"TenNhaSanXuat", "DiaChi", "SoDienThoai"};
    String[] condition = {"MaNhaSanXuat"};
    super.update("nhasanxuat", fields, condition, nhaSanXuatDTO.getTenNhaSanXuat(),
        nhaSanXuatDTO.getDiaChi(), nhaSanXuatDTO.getSoDienThoai(),
        nhaSanXuatDTO.getMaNhaSanXuat());
  }

  public void delete(String maNhaSanXuat) {
    String[] condition = {"MaNhaSanXuat"};
    delete("nhasanxuat", condition, maNhaSanXuat);
  }

  public List<NhaSanXuatDTO> findByCondition(String column, String data) {
    return super.findAllByCondition("nhasanxuat", column, data, new NhaSanXuatMapper());
  }

  public List<NhaSanXuatDTO> findWithLike(String column, String data) {
    return findWithLike("nhasanxuat", column, new NhaSanXuatMapper(), data);
  }

  public int count() {
    return findAll().size();
  }



}

