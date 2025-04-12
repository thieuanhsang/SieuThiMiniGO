package BUS;

import java.util.List;

public interface CRUD<T> {
  void them(T object);
  void xoa(String ma);
  void sua(T object);
  T timKiem(String ma);
  List<T> findAll();
}
