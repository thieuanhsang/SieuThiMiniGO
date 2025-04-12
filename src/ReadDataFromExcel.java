import DTO.ChuongTrinhKhuyenMaiDTO;
import DTO.NhaCungCapDTO;
import DTO.NhaSanXuatDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadDataFromExcel {


  public static List<?> readData(String sheetName) throws IOException {
    List results = null;
    String workingDir = System.getProperty("user.dir");
    final File excelPath = new File(workingDir + "/" + sheetName + ".xlsx");
    // final String excelPath = workingDir + "/data.xlsx";
    InputStream inputStream = new FileInputStream(excelPath);
    Workbook workbook = new HSSFWorkbook(inputStream);
    Sheet sheet = workbook.getSheetAt(0);

    Iterator<Row> iterator = sheet.iterator();
    Object data;
    if (sheetName.startsWith("chuongtrinhkhuyenmai")) {
      results = new ArrayList<SanPhamDTO>();
      //dòng
      while (iterator.hasNext()) {
        Row row = iterator.next();
        if (row.getRowNum() == 0) {
          continue; //header
        }
        //cột
        Iterator<Cell> cellIterator = row.cellIterator();
        data = new ChuongTrinhKhuyenMaiDTO();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (cell.getColumnIndex() == 0) {
            ((ChuongTrinhKhuyenMaiDTO) data).setMaChuongTrinh(cell.getStringCellValue());
            System.out.println(
                "Mã chương trình: " + ((ChuongTrinhKhuyenMaiDTO) data).getMaChuongTrinh());
          } else if (cell.getColumnIndex() == 1) {
            ((ChuongTrinhKhuyenMaiDTO) data).setTenKhuyenMai(cell.getStringCellValue());
            System.out.println(
                "Tên khuyến mãi: " + ((ChuongTrinhKhuyenMaiDTO) data).getTenKhuyenMai());
          } else if (cell.getColumnIndex() == 2) {
            ((ChuongTrinhKhuyenMaiDTO) data).setNgayBatDau(
                Date.valueOf(cell.getStringCellValue()));
            System.out.println(
                "Ngày bắt đầu: " + ((ChuongTrinhKhuyenMaiDTO) data).getNgayBatDau().toString());
          } else if (cell.getColumnIndex() == 3) {
            ((ChuongTrinhKhuyenMaiDTO) data).setNgayKetThuc(
                Date.valueOf(cell.getStringCellValue()));
            System.out.println(
                "Ngày kết thúc: " + ((ChuongTrinhKhuyenMaiDTO) data).getNgayKetThuc().toString());
          }
        }
        results.add(data);
        System.out.println("================================");
      }
    } else if (sheetName.startsWith("sanpham")) {
      results = new ArrayList<SanPhamDTO>();
      //dòng
      while (iterator.hasNext()) {
        Row row = iterator.next();
        if (row.getRowNum() == 0) {
          continue; //header
        }
        //cột
        Iterator<Cell> cellIterator = row.cellIterator();
        data = new SanPhamDTO();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (cell.getColumnIndex() == 0) {
            ((SanPhamDTO) data).setMaSanPham(cell.getStringCellValue());
            System.out.println(
                "Mã sản phẩm: " + ((SanPhamDTO) data).getMaSanPham());
          } else if (cell.getColumnIndex() == 1) {
            ((SanPhamDTO) data).setTenSanPham(cell.getStringCellValue());
            System.out.println(
                "Tên sản phẩm: " + ((SanPhamDTO) data).getTenSanPham());
          } else if (cell.getColumnIndex() == 2) {
            ((SanPhamDTO) data).setDonGia(cell.getStringCellValue());
            System.out.println(
                "Đơn giá: " + ((SanPhamDTO) data).getDonGia());
          } else if (cell.getColumnIndex() == 3) {
            ((SanPhamDTO) data).setDonViTinh(cell.getStringCellValue());
            System.out.println(
                "Đơn vị tính: " + ((SanPhamDTO) data).getDonViTinh());
          } else if (cell.getColumnIndex() == 4) {
            ((SanPhamDTO) data).setSoLuong(cell.getStringCellValue());
            System.out.println(
                "Số lượng: " + ((SanPhamDTO) data).getSoLuong());
          } else if (cell.getColumnIndex() == 5) {
            ((SanPhamDTO) data).setMaLoai(cell.getStringCellValue());
            System.out.println(
                "Mã loại: " + ((SanPhamDTO) data).getMaLoai());
          } else if (cell.getColumnIndex() == 6) {
            ((SanPhamDTO) data).setMaNhaSanXuat(cell.getStringCellValue());
            System.out.println(
                "Mã nhà sản xuất: " + ((SanPhamDTO) data).getMaNhaSanXuat());
          }
        }
        results.add(data);
        System.out.println("================================");
      }
    } else if (sheetName.startsWith("nhanvien")) {
      results = new ArrayList<NhanVienDTO>();
      //dòng
      while (iterator.hasNext()) {
        Row row = iterator.next();
        if (row.getRowNum() == 0) {
          continue; //header
        }
        //cột
        Iterator<Cell> cellIterator = row.cellIterator();
        data = new NhanVienDTO();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (cell.getColumnIndex() == 0) {
            ((NhanVienDTO) data).setMaNhanVien(cell.getStringCellValue());
            System.out.println(
                "Mã nhân viên: " + ((NhanVienDTO) data).getMaNhanVien());
          } else if (cell.getColumnIndex() == 1) {
            ((NhanVienDTO) data).setHoNhanVien(cell.getStringCellValue());
            System.out.println(
                "Họ nhân viên: " + ((NhanVienDTO) data).getHoNhanVien());
          } else if (cell.getColumnIndex() == 2) {
            ((NhanVienDTO) data).setTenNhanVien(cell.getStringCellValue());
            System.out.println(
                "Tên nhân viên: " + ((NhanVienDTO) data).getTenNhanVien());
          } else if (cell.getColumnIndex() == 3) {
            ((NhanVienDTO) data).setNgayVaoLam(Date.valueOf(cell.getStringCellValue()));
            System.out.println(
                "Ngày vào làm: " + ((NhanVienDTO) data).getNgayVaoLam());
          } else if (cell.getColumnIndex() == 4) {
            ((NhanVienDTO) data).setViTri(cell.getStringCellValue());
            System.out.println(
                "Vị trí: " + ((NhanVienDTO) data).getViTri());
          } else if (cell.getColumnIndex() == 5) {
            ((NhanVienDTO) data).setLuong(Integer.parseInt(cell.getStringCellValue()));
            System.out.println(
                "Lương: " + ((NhanVienDTO) data).getLuong());
          } else if (cell.getColumnIndex() == 6) {
            ((NhanVienDTO) data).setSoDienThoai(cell.getStringCellValue());
            System.out.println(
                "Số điện thoại: " + ((NhanVienDTO) data).getSoDienThoai());
          } else if (cell.getColumnIndex() == 6) {
            ((NhanVienDTO) data).setEmail(cell.getStringCellValue());
            System.out.println(
                "Email: " + ((NhanVienDTO) data).getEmail());
          }
        }
        results.add(data);
        System.out.println("================================");
      }
    } else if (sheetName.startsWith("taikhoan")) {
      results = new ArrayList<TaiKhoanDTO>();
      //dòng
      while (iterator.hasNext()) {
        Row row = iterator.next();
        if (row.getRowNum() == 0) {
          continue; //header
        }
        //cột
        Iterator<Cell> cellIterator = row.cellIterator();
        data = new TaiKhoanDTO();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (cell.getColumnIndex() == 0) {
            ((TaiKhoanDTO) data).setMaTaiKhoan(cell.getStringCellValue());
            System.out.println(
                "Mã tài khoản: " + ((TaiKhoanDTO) data).getMaTaiKhoan());
          } else if (cell.getColumnIndex() == 1) {
            ((TaiKhoanDTO) data).setTenTaiKhoan(cell.getStringCellValue());
            System.out.println(
                "Tên tài khoản: " + ((TaiKhoanDTO) data).getTenTaiKhoan());
          } else if (cell.getColumnIndex() == 2) {
            ((TaiKhoanDTO) data).setMatKhau(cell.getStringCellValue());
            System.out.println(
                "Mật khẩu: " + ((TaiKhoanDTO) data).getMatKhau());
          } else if (cell.getColumnIndex() == 3) {
            ((TaiKhoanDTO) data).setPhanQuyen(cell.getStringCellValue());
            System.out.println(
                "Phân quyền: " + ((TaiKhoanDTO) data).getPhanQuyen());
          } else if (cell.getColumnIndex() == 4) {
            ((TaiKhoanDTO) data).setMaNV(cell.getStringCellValue());
            System.out.println(
                "Mã nhân viên: " + ((TaiKhoanDTO) data).getMaNV());
          }
        }
        results.add(data);
        System.out.println("================================");
      }
    } else if (sheetName.startsWith("nhacungcap")) {
      results = new ArrayList<NhaCungCapDTO>();

      //dòng
      while (iterator.hasNext()) {
        Row row = iterator.next();
        if (row.getRowNum() == 0) {
          continue; //header
        }
        //cột
        Iterator<Cell> cellIterator = row.cellIterator();
        data = new NhaCungCapDTO();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (cell.getColumnIndex() == 0) {
            ((NhaCungCapDTO) data).setMaNhaCungCap(cell.getStringCellValue());
            System.out.println(
                "Mã nhà cung cấp: " + ((NhaCungCapDTO) data).getMaNhaCungCap());
          } else if (cell.getColumnIndex() == 1) {
            ((NhaCungCapDTO) data).setTenNhaCungCap(cell.getStringCellValue());
            System.out.println(
                "Tên nhà cung cấp: " + ((NhaCungCapDTO) data).getTenNhaCungCap());
          } else if (cell.getColumnIndex() == 2) {
            ((NhaCungCapDTO) data).setSdt(cell.getStringCellValue());
            System.out.println(
                "Số điện thoại: " + ((NhaCungCapDTO) data).getSdt());
          } else if (cell.getColumnIndex() == 3) {
            ((NhaCungCapDTO) data).setDiaChi(cell.getStringCellValue());
            System.out.println(
                "Địa chỉ: " + ((NhaCungCapDTO) data).getDiaChi());
          } else if (cell.getColumnIndex() == 4) {
            ((NhaCungCapDTO) data).setEmail(cell.getStringCellValue());
            System.out.println(
                "Email: " + ((NhaCungCapDTO) data).getEmail());
          }
        }
        results.add(data);
        System.out.println("================================");
      }
    } else if (sheetName.startsWith("nhasanxuat")) {
      results = new ArrayList<NhaSanXuatDTO>();
      //dòng
      while (iterator.hasNext()) {
        Row row = iterator.next();
        if (row.getRowNum() == 0) {
          continue; //header
        }
        //cột
        Iterator<Cell> cellIterator = row.cellIterator();
        data = new NhaSanXuatDTO();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (cell.getColumnIndex() == 0) {
            ((NhaSanXuatDTO) data).setMaNhaSanXuat(cell.getStringCellValue());
            System.out.println(
                "Mã nhà sản xuất: " + ((NhaSanXuatDTO) data).getMaNhaSanXuat());
          } else if (cell.getColumnIndex() == 1) {
            ((NhaSanXuatDTO) data).setTenNhaSanXuat(cell.getStringCellValue());
            System.out.println(
                "Tên nhà sản xuất: " + ((NhaSanXuatDTO) data).getTenNhaSanXuat());
          } else if (cell.getColumnIndex() == 2) {
            ((NhaSanXuatDTO) data).setDiaChi(cell.getStringCellValue());
            System.out.println(
                "Địa chỉ: " + ((NhaSanXuatDTO) data).getDiaChi());
          } else if (cell.getColumnIndex() == 3) {
            ((NhaSanXuatDTO) data).setSoDienThoai(cell.getStringCellValue());
            System.out.println(
                "Số điện thọaỉ: " + ((NhaSanXuatDTO) data).getSoDienThoai());
          }
        }
        results.add(data);
        System.out.println("================================");
      }

    }

//    while (iterator.hasNext()) {
//      Row row = iterator.next();
//      if (row.getRowNum() == 0) {
//        continue; //header
//      }
//      Iterator<Cell> cellIterator = row.cellIterator();
//      if (isChuongTrinhKhuyenMai == true) {
//        data = new ChuongTrinhKhuyenMaiDTO();
//        while (cellIterator.hasNext()) {
//          Cell cell = cellIterator.next();
//          if (cell.getColumnIndex() == 0) {
//            ((ChuongTrinhKhuyenMaiDTO) data).setMaChuongTrinh(cell.getStringCellValue());
//          } else if (cell.getColumnIndex() == 1) {
//            ((ChuongTrinhKhuyenMaiDTO) data).setTenKhuyenMai(cell.getStringCellValue());
//          } else if (cell.getColumnIndex() == 2) {
//            ((ChuongTrinhKhuyenMaiDTO) data).setNgayBatDau(Date.valueOf(cell.getStringCellValue()));
//          } else if (cell.getColumnIndex() == 3) {
//            ((ChuongTrinhKhuyenMaiDTO) data).setNgayKetThuc(
//                Date.valueOf(cell.getStringCellValue()));
//          }
//          results.add(data);
//        }
//
//      } else if (isSanPham == true) {
//        data = new SanPhamDTO();
//      } else if (isNhanVien == true) {
//        data = new NhanVienDTO();
//      } else if (isTaiKhoan == true) {
//        data = new TaiKhoanDTO();
//      } else if (isNhaCungCap == true) {
//        data = new NhaCungCapDTO();
//      } else if (isNhaSanXuat == true) {
//        data = new NhaSanXuatDTO();
//      }
//    }

    return results;
  }

}
