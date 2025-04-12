

import BUS.ChuongTrinhKhuyenMaiBUS;
import BUS.NhaCungCapBUS;
import BUS.NhaSanXuatBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import BUS.TaiKhoanBUS;
import DTO.ChuongTrinhKhuyenMaiDTO;
import DTO.NhaCungCapDTO;
import DTO.NhaSanXuatDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FormQuanLy extends JFrame {

  private JPanel contentPane;
  private JTable tableSanPham;
  private JTextField tfMaSP;
  private JTextField tfTenSP;
  private JTextField tfDonGia;
  private JTextField tfDonViTinh;
  private JTextField tfSoLuong;
  private JTextField tfMaNhaSanXuat_SP;
  private JTable tableNhanVien;
  private JTextField tfMaNhanVien;
  private JTextField tfHoNhanVien;
  private JTextField tfTenNhanVien;
  private JTextField tfSoDienThoai_NV;
  private JTextField tfLuongNhanVien;
  private JTextField tfEmail_NV;
  private JTable tableTaiKhoan;
  private JTextField tfMaTaiKhoan;
  private JTextField tfTenTaiKhoan;
  private JTextField tfMatKhauTK;
  private JTextField tfMaNV;
  private JTable tableNhaCungCap;
  private JTextField tfMaNhaCungCap;
  private JTextField tfTenNhaCungCap;
  private JTextField tfDiaChiNhaCungCap;
  private JTextField tfSoDienThoai_NCC;
  private JTextField tfEmail_NCC;
  private JTable tableNhaSanXuat;
  private JTextField tfMaNhaSanXuat;
  private JTextField tfTenNhaSanXuat;
  private JTextField tfSoDienThoai_NSX;
  private JTextField tfDiaChi_NSX;
  private JTable tableChuongTrinhKM;
  private JTextField tfMaCT;
  private JTextField tfTenCT;
  private JComboBox cbNgayBD_CTKM = new JComboBox();
  private JComboBox cbThangBD_CTKM = new JComboBox();
  private JComboBox cbNamBD_CTKM = new JComboBox();
  JComboBox cbNgayKT_CTKM = new JComboBox();
  JComboBox cbThangKT_CTKM = new JComboBox();
  JComboBox cbNamKT_CTKM = new JComboBox();
  JComboBox tfNamBD_CTKM = new JComboBox();
  JComboBox cbViTriNhanVien = new JComboBox();
  JComboBox cbNgaySinh_NV = new JComboBox();
  JComboBox cbNamSinh_NV = new JComboBox();
  JComboBox cbThangSinh_NV = new JComboBox();
  JComboBox cbPhanQuyenTK = new JComboBox();
  JComboBox cbMaLoai = new JComboBox();
  private ChuongTrinhKhuyenMaiBUS chuongTrinhKhuyenMaiBUS;
  private SanPhamBUS sanPhamBUS;
  private BUS.TaiKhoanBUS taiKhoanBUS;
  private NhanVienBUS nhanVienBUS;
  private NhaCungCapBUS nhaCungCapBUS;
  private NhaSanXuatBUS nhaSanXuatBUS;
  private DefaultTableModel modelCTKM = new DefaultTableModel();
  private DefaultTableModel modelSP = new DefaultTableModel();
  private DefaultTableModel modelTK = new DefaultTableModel();
  private DefaultTableModel modelNV = new DefaultTableModel();
  private DefaultTableModel modelNCC = new DefaultTableModel();
  private DefaultTableModel modelNSX = new DefaultTableModel();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          FormQuanLy frame = new FormQuanLy();

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public FormQuanLy() {
    chuongTrinhKhuyenMaiBUS = new ChuongTrinhKhuyenMaiBUS();
    sanPhamBUS = new SanPhamBUS();
    sanPhamBUS = new SanPhamBUS();
    taiKhoanBUS = new TaiKhoanBUS();
    nhanVienBUS = new NhanVienBUS();
    nhaCungCapBUS = new NhaCungCapBUS();
    nhaSanXuatBUS = new NhaSanXuatBUS();
    setTitle("Qu\u1EA3n L\u00FD");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 905, 527);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 896, 496);
    contentPane.add(panel);
    panel.setLayout(null);

    JSplitPane splitPane = new JSplitPane();
    splitPane.setOneTouchExpandable(true);
    splitPane.setResizeWeight(0.25);
    splitPane.setBounds(0, 0, 896, 496);
    panel.add(splitPane);

    JPanel pnChon = new JPanel();
    pnChon.setBackground(new Color(102, 205, 170));
    splitPane.setLeftComponent(pnChon);
    pnChon.setLayout(null);

    JButton btnSanPham = new JButton("S\u1EA3n Ph\u1EA9m");

    btnSanPham.setBounds(10, 75, 202, 49);
    pnChon.add(btnSanPham);

    JButton btnNhanVien = new JButton("Nh\u00E2n Vi\u00EAn");
    btnNhanVien.setBounds(10, 135, 202, 49);
    pnChon.add(btnNhanVien);

    JButton btnTaiKhoan = new JButton("T\u00E0i Kho\u1EA3n");
    btnTaiKhoan.setBounds(10, 195, 202, 49);
    pnChon.add(btnTaiKhoan);

    JButton btnThongKe = new JButton("Th\u1ED1ng K\u00EA");
    btnThongKe.setBounds(10, 374, 202, 49);
    pnChon.add(btnThongKe);

    JButton btnDangXuat = new JButton("\u0110\u0103ng Xu\u1EA5t");
    btnDangXuat.setBounds(10, 434, 96, 49);
    pnChon.add(btnDangXuat);

    JButton btnThoat = new JButton("Tho\u00E1t");
    btnThoat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    btnThoat.setBounds(116, 434, 96, 49);
    pnChon.add(btnThoat);

    JButton btnNhaSanXuat = new JButton("Nh\u00E0 S\u1EA3n Xu\u1EA5t");
    btnNhaSanXuat.setBounds(10, 315, 202, 49);
    pnChon.add(btnNhaSanXuat);

    JButton btnNhaCungCap = new JButton("Nh\u00E0 Cung C\u1EA5p");
    btnNhaCungCap.setBounds(10, 255, 202, 49);
    pnChon.add(btnNhaCungCap);

    JButton btnCT_KhuyenMai = new JButton("CT_Khuy\u1EBFn M\u00E3i");
    btnCT_KhuyenMai.setBounds(10, 11, 202, 49);
    pnChon.add(btnCT_KhuyenMai);

    btnDangXuat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int luachon = JOptionPane.showConfirmDialog(null, "BẠN MUỐN ĐĂNG XUẤT KHỎI HỆ THỐNG !!!",
            "ĐĂNG XUẤT", JOptionPane.YES_NO_OPTION);
        System.out.println(luachon);
        if (luachon == 0) {
          FormDangNhap dangNhap = new FormDangNhap();
          dangNhap.setVisible(true);
          dispose();
        }
      }
    });

    JPanel CardThongTin = new JPanel();
    CardThongTin.setBackground(new Color(95, 158, 160));
    splitPane.setRightComponent(CardThongTin);
    CardThongTin.setLayout(new CardLayout(0, 0));

    JPanel pnTT_SanPham = new JPanel();
    pnTT_SanPham.setBackground(new Color(135, 206, 235));
    CardThongTin.add(pnTT_SanPham, "name_830384674955600");
    pnTT_SanPham.setLayout(null);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 244, 647, 239);
    pnTT_SanPham.add(scrollPane);

    tableSanPham = new JTable();
    scrollPane.setViewportView(tableSanPham);
    tableSanPham.setModel(modelSP);

    JScrollPane scrollPaneSP = new JScrollPane();
    scrollPaneSP.setBounds(10, 250, 647, 260);
//    pnTT_SanPham.add(scrollPaneSP);
//    scrollPaneSP.setViewportView(tableSanPham);

    Vector headerSP = new Vector<>();
    headerSP.add("Mã SP");
    headerSP.add("Tên SP");
    headerSP.add("Đơn giá");
    headerSP.add("Đơn vị tính");
    headerSP.add("Số lượng");
    headerSP.add("Mã loại");
    headerSP.add("Mã nhà sản xuất");
    if (modelSP.getRowCount() == 0) {
      modelSP = new DefaultTableModel(headerSP, 0);
      readDataSP();
    }
    tableSanPham.setModel(modelSP);

    JLabel lblMaSP = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m :");
    lblMaSP.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaSP.setBounds(10, 59, 120, 21);
    pnTT_SanPham.add(lblMaSP);

    JLabel lblTenSanPham = new JLabel("T\u00EAn S\u1EA3n Ph\u1EA9m :");
    lblTenSanPham.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTenSanPham.setBounds(10, 91, 123, 21);
    pnTT_SanPham.add(lblTenSanPham);

    JLabel lblDonGia = new JLabel(" \u0110\u01A1n gi\u00E1 :");
    lblDonGia.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblDonGia.setBounds(10, 123, 76, 21);
    pnTT_SanPham.add(lblDonGia);

    JLabel lblSoLuong = new JLabel("S\u1ED1 l\u01B0\u1EE3ng :");
    lblSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblSoLuong.setBounds(329, 61, 80, 21);
    pnTT_SanPham.add(lblSoLuong);

    JLabel lblMaLoai = new JLabel("M\u00E3 lo\u1EA1i :");
    lblMaLoai.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaLoai.setBounds(329, 93, 70, 21);
    pnTT_SanPham.add(lblMaLoai);

    JLabel lblMaNhaSanXuat_SP = new JLabel("M\u00E3 Nh\u00E0 S\u1EA3n Xu\u1EA5t :");
    lblMaNhaSanXuat_SP.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaNhaSanXuat_SP.setBounds(329, 121, 149, 21);
    pnTT_SanPham.add(lblMaNhaSanXuat_SP);

    JLabel lblDonViTinh = new JLabel("\u0110\u01A1n v\u1ECB t\u00EDnh :");
    lblDonViTinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblDonViTinh.setBounds(10, 155, 98, 21);
    pnTT_SanPham.add(lblDonViTinh);

    tfMaSP = new JTextField();
    tfMaSP.setBounds(140, 59, 162, 22);
    pnTT_SanPham.add(tfMaSP);
    tfMaSP.setColumns(10);

    tfTenSP = new JTextField();
    tfTenSP.setColumns(10);
    tfTenSP.setBounds(140, 92, 162, 22);
    pnTT_SanPham.add(tfTenSP);

    tfDonGia = new JTextField();
    tfDonGia.setColumns(10);
    tfDonGia.setBounds(140, 125, 162, 22);
    pnTT_SanPham.add(tfDonGia);

    tfDonViTinh = new JTextField();
    tfDonViTinh.setColumns(10);
    tfDonViTinh.setBounds(140, 158, 162, 22);
    pnTT_SanPham.add(tfDonViTinh);

    tfSoLuong = new JTextField();
    tfSoLuong.setColumns(10);
    tfSoLuong.setBounds(488, 62, 149, 22);
    pnTT_SanPham.add(tfSoLuong);

    tfMaNhaSanXuat_SP = new JTextField();
    tfMaNhaSanXuat_SP.setColumns(10);
    tfMaNhaSanXuat_SP.setBounds(488, 122, 149, 22);
    pnTT_SanPham.add(tfMaNhaSanXuat_SP);

    cbMaLoai.setBounds(488, 94, 149, 22);
    cbMaLoai.setModel(new DefaultComboBoxModel(new String[]{null, "L1", "L2", "L3", "L4", "L5"}));
    pnTT_SanPham.add(cbMaLoai);

    JButton btnThemSP = new JButton("TH\u00CAM");
    btnThemSP.setBounds(10, 189, 107, 44);
    btnThemSP.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        try {
          sanPhamDTO.setMaSanPham(tfMaSP.getText());
          sanPhamDTO.setTenSanPham(tfTenSP.getText());
          sanPhamDTO.setMaNhaSanXuat(tfMaNhaSanXuat_SP.getText());
          sanPhamDTO.setMaLoai(cbMaLoai.getSelectedItem() + "");
          sanPhamDTO.setDonViTinh(tfDonViTinh.getText());
          sanPhamDTO.setDonGia(tfDonGia.getText());
          sanPhamDTO.setSoLuong(tfSoLuong.getText());
        } catch (Exception ex1) {
          if (tfMaSP.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaSP, "Vui lòng nhập Mã Sản Phẩm!!!");
          }
          if (tfTenSP.getText().equals("")) {
            JOptionPane.showMessageDialog(tfTenSP, "Vui lòng nhập Tên Sản Phẩm!!!");
          }
          if (tfMaNhaSanXuat_SP.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhaSanXuat_SP, "Vui lòng nhập Mã Nhà Sản Xuất!!!");
          }
          if (tfDonGia.getText().equals("")) {
            JOptionPane.showMessageDialog(tfDonGia, "Vui lòng nhập đơn giá!!!");
          }
          if (tfSoLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(tfSoLuong, "Vui lòng nhập số lượng!!");
          }

          if (cbMaLoai.getSelectedItem().equals(null)) {
            JOptionPane.showMessageDialog(cbMaLoai, "Vui lòng nhập mã loại!!!");
          }
          if (tfDonViTinh.getText().equals("")) {
            JOptionPane.showMessageDialog(tfDonViTinh, "Vui lòng nhập đơn vị tính!!!");
          }
        }
        sanPhamBUS.them(sanPhamDTO);
        readDataSP();
      }
    });
    pnTT_SanPham.add(btnThemSP);

    JButton btnXoaSP = new JButton("X\u00D3A");
    btnXoaSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (tfMaSP.getText().equals("")) {
          JOptionPane.showMessageDialog(tfMaSP, "Vui lòng nhập mã sản phẩm để xóa!!!");
        }
        sanPhamBUS.xoa(tfMaSP.getText());
        readDataSP();
      }
    });
    btnXoaSP.setBounds(142, 189, 107, 44);
    pnTT_SanPham.add(btnXoaSP);

    JButton btnSuaSP = new JButton("S\u1EECA");
    btnSuaSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String maSanPham = tfMaSP.getText();
        if (tfMaSP.getText().equals("")) {
          JOptionPane.showMessageDialog(tfMaSP, "Vui lòng nhập mã sản phẩm để xóa!!!");
        }
        SanPhamDTO sanPhamDTO = sanPhamBUS.timKiem(maSanPham);
        if (!tfTenSP.getText().equals("")) {
          sanPhamDTO.setTenSanPham(tfTenSP.getText());
        }

        if (!tfDonGia.getText().equals("")) {
          sanPhamDTO.setDonGia((tfDonGia.getText()));
        }

        if (!tfDonViTinh.getText().equals("")) {
          sanPhamDTO.setDonViTinh(tfDonViTinh.getText());
        }

        if (!tfSoLuong.getText().equals("")) {
          sanPhamDTO.setSoLuong((tfSoLuong.getText()));
        }

        if (cbMaLoai.getSelectedItem() != null) {
          sanPhamDTO.setMaLoai(cbMaLoai.getSelectedItem() + "");
        }

        if (!tfMaNhaSanXuat_SP.getText().equals("")) {
          sanPhamDTO.setMaNhaSanXuat(tfMaNhaSanXuat_SP.getText());
        }
        sanPhamBUS.sua(sanPhamDTO);
        readDataSP();
      }
    });
    btnSuaSP.setBounds(279, 191, 107, 42);
    pnTT_SanPham.add(btnSuaSP);

    JButton btnTimKiemSP = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemSP.setBounds(414, 191, 107, 42);
    btnTimKiemSP.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!tfMaSP.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByConditionUseLike("MaSanPham",
              "%" + tfMaSP.getText() + "%")) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (!tfTenSP.getText().equals("")) {
          modelSP.setRowCount(0);
          List<SanPhamDTO> results = sanPhamBUS.findByConditionUseLike("TenSanPham",
              "%" + tfTenSP.getText() + "%");
          for (SanPhamDTO sanPhamDTO : results) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
          ExportToExcel.export("sanpham_theoten", SanPhamDTO.class, results);
          try {
            ReadDataFromExcel.readData("sanpham_theoten");
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
        if (!tfDonGia.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByConditionUseLike("DonGia",
              "%" + tfDonGia.getText() + "%")) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
          ExportToExcel.export("sanpham_theodongia", SanPhamDTO.class,
              sanPhamBUS.findByConditionUseLike("DonGia",
                  "%" + tfDonGia.getText() + "%"));
        }
        if (!tfDonViTinh.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByCondition("DonViTinh",
              tfDonViTinh.getText())) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (!tfSoLuong.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByConditionUseLike("SoLuong",
              "%" + tfSoLuong.getText() + "%")) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (cbMaLoai.getSelectedItem() != null) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByCondition("MaLoai",
              cbMaLoai.getSelectedItem() + "")) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
        if (!tfMaNhaSanXuat_SP.getText().equals("")) {
          modelSP.setRowCount(0);
          for (SanPhamDTO sanPhamDTO : sanPhamBUS.findByCondition("MaNhaSanXuat",
              tfMaNhaSanXuat_SP.getText())) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonViTinh());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getMaLoai());
            row.add(sanPhamDTO.getMaNhaSanXuat());
            modelSP.addRow(row);
          }
          tableSanPham.setModel(modelSP);
        }
//        //readDataSP();
      }
    });
    pnTT_SanPham.add(btnTimKiemSP);

    JButton btnLoaiSP = new JButton("LO\u1EA0I");
    btnLoaiSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnLoaiSP.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LoaiSanPham loaiSanPham = new LoaiSanPham();
        loaiSanPham.setVisible(true);
      }
    });
    btnLoaiSP.setBounds(550, 189, 107, 44);
    pnTT_SanPham.add(btnLoaiSP);

    JLabel lblNewLabel_1 = new JLabel("TH\u00D4NG TIN S\u1EA2N PH\u1EA8M");
    lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblNewLabel_1.setBounds(219, 11, 216, 24);
    pnTT_SanPham.add(lblNewLabel_1);

    JButton btnRS_1 = new JButton("");
    btnRS_1.setIcon(
        new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\imgButton\\refresh.png"));
    btnRS_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readDataSP();
        clearSP();
      }
    });
    btnRS_1.setBounds(593, 8, 51, 43);
    pnTT_SanPham.add(btnRS_1);

    JPanel pnTT_NhanVien = new JPanel();
    pnTT_NhanVien.setBackground(new Color(100, 149, 237));
    CardThongTin.add(pnTT_NhanVien, "name_830757335461200");
    pnTT_NhanVien.setLayout(null);

    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setBounds(10, 280, 647, 203);
    pnTT_NhanVien.add(scrollPane_2);

    tableNhanVien = new JTable();
    scrollPane_2.setViewportView(tableNhanVien);
    tableNhanVien.setModel(modelNV);

    JScrollPane scrollPaneNhanVien = new JScrollPane();
    scrollPaneNhanVien.setBounds(10, 280, 647, 260);
//    pnTT_NhanVien.add(scrollPaneNhanVien);
//    scrollPaneNhanVien.setViewportView(tableNhanVien);
    Vector headerNV = new Vector<>();
    headerNV.add("Mã NV");
    headerNV.add("Họ");
    headerNV.add("Tên");
    headerNV.add("Ngày vào làm");
    headerNV.add("Vị trí");
    headerNV.add("Lương");
    headerNV.add("Số điện thoại");
    headerNV.add("Email");
    if (modelNV.getRowCount() == 0) {
      modelNV = new DefaultTableModel(headerNV, 0);
      readDataNV();
    }

    JLabel lblMaNhanVien = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn :");
    lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaNhanVien.setBounds(10, 57, 124, 21);
    pnTT_NhanVien.add(lblMaNhanVien);

    JLabel lblHNhnVin = new JLabel("H\u1ECD Nh\u00E2n Vi\u00EAn :");
    lblHNhnVin.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblHNhnVin.setBounds(10, 102, 122, 21);
    pnTT_NhanVien.add(lblHNhnVin);

    JLabel lblTnNhnVin = new JLabel("T\u00EAn Nh\u00E2n Vi\u00EAn :");
    lblTnNhnVin.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTnNhnVin.setBounds(10, 149, 127, 21);
    pnTT_NhanVien.add(lblTnNhnVin);

    JLabel lblNgyVoLm = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m :");
    lblNgyVoLm.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblNgyVoLm.setBounds(10, 196, 117, 21);
    pnTT_NhanVien.add(lblNgyVoLm);

    JLabel lblVTri = new JLabel("V\u1ECB tr\u00ED :");
    lblVTri.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblVTri.setBounds(370, 56, 51, 21);
    pnTT_NhanVien.add(lblVTri);

    JLabel lblLng = new JLabel("L\u01B0\u01A1ng :");
    lblLng.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblLng.setBounds(370, 101, 62, 21);
    pnTT_NhanVien.add(lblLng);

    JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
    lblSinThoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblSinThoi.setBounds(370, 149, 113, 21);
    pnTT_NhanVien.add(lblSinThoi);

    JLabel lblEmail = new JLabel("Email :");
    lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblEmail.setBounds(370, 196, 55, 21);
    pnTT_NhanVien.add(lblEmail);

    tfMaNhanVien = new JTextField();
    tfMaNhanVien.setBounds(156, 57, 155, 22);
    pnTT_NhanVien.add(tfMaNhanVien);
    tfMaNhanVien.setColumns(10);

    tfHoNhanVien = new JTextField();
    tfHoNhanVien.setColumns(10);
    tfHoNhanVien.setBounds(156, 103, 155, 21);
    pnTT_NhanVien.add(tfHoNhanVien);

    tfTenNhanVien = new JTextField();
    tfTenNhanVien.setColumns(10);
    tfTenNhanVien.setBounds(156, 150, 155, 21);
    pnTT_NhanVien.add(tfTenNhanVien);

    tfSoDienThoai_NV = new JTextField();
    tfSoDienThoai_NV.setColumns(10);
    tfSoDienThoai_NV.setBounds(487, 149, 155, 21);
    pnTT_NhanVien.add(tfSoDienThoai_NV);

    tfLuongNhanVien = new JTextField();
    tfLuongNhanVien.setColumns(10);
    tfLuongNhanVien.setBounds(487, 102, 155, 21);
    pnTT_NhanVien.add(tfLuongNhanVien);

    tfEmail_NV = new JTextField();
    tfEmail_NV.setColumns(10);
    tfEmail_NV.setBounds(487, 196, 155, 21);
    pnTT_NhanVien.add(tfEmail_NV);

    cbViTriNhanVien.setBounds(487, 57, 155, 22);
    cbViTriNhanVien.setModel(new DefaultComboBoxModel(new String[]{null, "Nhân viên", "Quản lý"}));
    pnTT_NhanVien.add(cbViTriNhanVien);

    cbNgaySinh_NV.setBounds(156, 197, 45, 22);
    cbNgaySinh_NV.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
            "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
            "28", "29", "30", "31"}));
    pnTT_NhanVien.add(cbNgaySinh_NV);

    cbNamSinh_NV.setBounds(260, 197, 51, 22);
    cbNamSinh_NV.setModel(new DefaultComboBoxModel(new String[]{null, "2020", "2021", "2022"}));
    pnTT_NhanVien.add(cbNamSinh_NV);

    cbThangSinh_NV.setBounds(205, 197, 45, 22);
    cbThangSinh_NV.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12"}));
    pnTT_NhanVien.add(cbThangSinh_NV);

    JButton btnThemNV = new JButton("TH\u00CAM");
    btnThemNV.setBounds(10, 230, 127, 39);
    btnThemNV.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        try {
          nhanVienDTO.setMaNhanVien(tfMaNhanVien.getText());
          nhanVienDTO.setHoNhanVien(tfHoNhanVien.getText());
          nhanVienDTO.setTenNhanVien(tfTenNhanVien.getText());
          String ngayVaoLam =
              cbNamSinh_NV.getSelectedItem() + "-" + cbThangSinh_NV.getSelectedItem() + "-"
                  + cbNgaySinh_NV.getSelectedItem();
          nhanVienDTO.setNgayVaoLam(java.sql.Date.valueOf(ngayVaoLam));
          nhanVienDTO.setViTri(cbViTriNhanVien.getSelectedItem() + "");
          nhanVienDTO.setLuong(Integer.parseInt(tfLuongNhanVien.getText()));
          nhanVienDTO.setEmail(tfEmail_NV.getText());
          nhanVienDTO.setSoDienThoai(tfSoDienThoai_NV.getText());
          nhanVienBUS.them(nhanVienDTO);
        } catch (Exception ex1) {
          if (tfMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập Mã Nhân Viên!!!");
          }
          if (tfHoNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfHoNhanVien, "Vui lòng nhập Họ nhân viên!!!");
          }
          if (tfTenNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfTenNhanVien, "Vui lòng nhập Tên Nhân viên!!!");
          }
          if (cbNamSinh_NV.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbNamSinh_NV, "Vui lòng nhập Năm vào làm!!!");
          }
          if (cbThangSinh_NV.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbThangSinh_NV, "Vui lòng nhập Tháng vào làm!!!");
          }
          if (cbNgaySinh_NV.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbNgaySinh_NV, "Vui lòng nhập Ngày vào làm!!!");
          }
          if (cbViTriNhanVien.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbViTriNhanVien, "Vui lòng chọn vị trí nhân viên!!");
          }
          if (tfLuongNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfLuongNhanVien, "Vui lòng nhập lương!!!");
          }
          if (tfSoDienThoai_NV.getText().equals("")) {
            JOptionPane.showMessageDialog(tfSoDienThoai_NV, "Vui lòng nhập số điện thoại!!!");
          }
          if (tfEmail_NV.getText().equals("")) {
            JOptionPane.showMessageDialog(tfEmail_NV, "Vui lòng nhập email!!!");
          }
        }
        readDataNV();
      }
    });
    pnTT_NhanVien.add(btnThemNV);

    JButton btnXoaNhanVien = new JButton("X\u00D3A");
    btnXoaNhanVien.setBounds(182, 230, 127, 39);
    btnXoaNhanVien.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (tfMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập mã nhân viên!!!!");
          }
          nhanVienBUS.xoa(tfMaNhanVien.getText());
        } catch (Exception e1) {
          if (tfMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập mã nhân viên!!!!");
          }
        }
        readDataNV();
      }
    });
    pnTT_NhanVien.add(btnXoaNhanVien);

    JButton btnSuaNV = new JButton("S\u1EECA");
    btnSuaNV.setBounds(352, 230, 127, 39);
    btnSuaNV.addActionListener(e -> {
      try {
        if (tfMaNhanVien.getText().equals("")) {
          JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập mã nhân viên!!!!");
        }
        NhanVienDTO nhanVienDTO = nhanVienBUS.timKiem(tfMaNhanVien.getText());
        if (!tfHoNhanVien.getText().equals("")) {
          nhanVienDTO.setHoNhanVien(tfHoNhanVien.getText());
        }
        if (!tfTenNhanVien.getText().equals("")) {
          nhanVienDTO.setTenNhanVien(tfTenNhanVien.getText());
        }
        String[] ngayVaoLam = nhanVienDTO.getNgayVaoLam().toString().split("-");
        if (cbNgaySinh_NV.getSelectedItem() != null && cbThangSinh_NV.getSelectedItem() != null
            && cbNamSinh_NV.getSelectedItem() != null) {
          ngayVaoLam[0] = cbNamSinh_NV.getSelectedItem() + "";
          ngayVaoLam[1] = cbThangSinh_NV.getSelectedItem() + "";
          ngayVaoLam[2] = cbNgaySinh_NV.getSelectedItem() + "";
        }
        if (cbNgaySinh_NV.getSelectedItem() != null) {
          ngayVaoLam[2] = cbNgaySinh_NV.getSelectedItem() + "";
        }
        if (cbThangSinh_NV.getSelectedItem() != null) {
          ngayVaoLam[1] = cbThangSinh_NV.getSelectedItem() + "";
        }
        if (cbNamSinh_NV.getSelectedItem() != null) {
          ngayVaoLam[0] = cbNamSinh_NV.getSelectedItem() + "";
        }
        String newNgayVaoLam = String.join("-", ngayVaoLam);
        nhanVienDTO.setNgayVaoLam(java.sql.Date.valueOf(newNgayVaoLam));
        if (cbViTriNhanVien.getSelectedItem() != null) {
          nhanVienDTO.setViTri(cbViTriNhanVien.getSelectedItem() + "");
        }
        if (!tfLuongNhanVien.getText().equals("")) {
          nhanVienDTO.setLuong(Integer.parseInt(tfLuongNhanVien.getText()));
        }
        if (!tfSoDienThoai_NV.getText().equals("")) {
          nhanVienDTO.setSoDienThoai(tfSoDienThoai_NV.getText());
        }
        if (!tfEmail_NV.getText().equals("")) {
          nhanVienDTO.setEmail(tfEmail_NV.getText());
        }
        nhanVienBUS.sua(nhanVienDTO);
      } catch (Exception e1) {
        JOptionPane.showMessageDialog(tfMaNhanVien, "Mã nhân viên không đúng!!!!");
      }
      readDataNV();
    });
    pnTT_NhanVien.add(btnSuaNV);

    JButton btnTimKiem = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiem.setBounds(516, 230, 127, 39);
    btnTimKiem.addActionListener(e -> {
          try {
            if (!tfMaNhanVien.getText().equals("")) {
              NhanVienDTO nhanVienDTO = nhanVienBUS.timKiem(tfMaNhanVien.getText());
              modelNV.setRowCount(0);
              Vector row = new Vector();
              row.add(nhanVienDTO.getMaNhanVien());
              row.add(nhanVienDTO.getHoNhanVien());
              row.add(nhanVienDTO.getTenNhanVien());
              row.add(nhanVienDTO.getNgayVaoLam());
              row.add(nhanVienDTO.getViTri());
              row.add(nhanVienDTO.getLuong());
              row.add(nhanVienDTO.getSoDienThoai());
              row.add(nhanVienDTO.getEmail());
              modelNV.addRow(row);
              tableNhanVien.setModel(modelNV);
            }
            if (!tfHoNhanVien.getText().equals("")) {
              modelNV.setRowCount(0);
              List<NhanVienDTO> results = nhanVienBUS.findWithLikeCondition("HoNhanVien",
                  "%" + tfHoNhanVien.getText() + "%");
              for (NhanVienDTO nhanVienDTO : results) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
              ExportToExcel.export("nhanvien_theoho", NhanVienDTO.class, results);
              ReadDataFromExcel.readData("nhanvien_theoho");
            }
            if (!tfTenNhanVien.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("TenNhanVien",
                  "%" + tfTenNhanVien.getText() + "%")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbNamSinh_NV.getSelectedItem() != null && cbThangSinh_NV.getSelectedItem() != null
                && cbNgaySinh_NV.getSelectedItem() != null) {
              String ngayVaoLam =
                  cbNamSinh_NV.getSelectedItem() + "-" + cbThangSinh_NV.getSelectedItem() + "-"
                      + cbNgaySinh_NV.getSelectedItem();
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("NgayVaoLam",
                  ngayVaoLam)) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbNamSinh_NV.getSelectedItem() != null) {
              modelNV.setRowCount(0);
              String namVaoLam = cbNamSinh_NV.getSelectedItem() + "%";
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("NgayVaoLam",
                  namVaoLam)) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbThangSinh_NV.getSelectedItem() != null) {
              String thangVaoLam = "%" + cbThangSinh_NV.getSelectedItem() + "%";
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("NgayVaoLam",
                  thangVaoLam)) {
                if (nhanVienDTO.getNgayVaoLam().getMonth() + 1 == Integer.parseInt(
                    cbThangSinh_NV.getSelectedItem() + "")) {
                  Vector row = new Vector();
                  row.add(nhanVienDTO.getMaNhanVien());
                  row.add(nhanVienDTO.getHoNhanVien());
                  row.add(nhanVienDTO.getTenNhanVien());
                  row.add(nhanVienDTO.getNgayVaoLam());
                  row.add(nhanVienDTO.getViTri());
                  row.add(nhanVienDTO.getLuong());
                  row.add(nhanVienDTO.getSoDienThoai());
                  row.add(nhanVienDTO.getEmail());
                  modelNV.addRow(row);
                }
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbNgaySinh_NV.getSelectedItem() != null) {
              String ngayVaoLam = "%" + cbNgaySinh_NV.getSelectedItem();
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("NgayVaoLam",
                  ngayVaoLam)) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (cbViTriNhanVien.getSelectedItem() != null) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("viTri",
                  cbViTriNhanVien.getSelectedItem() + "")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (!tfLuongNhanVien.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("Luong",
                  "%" + tfLuongNhanVien.getText() + "%")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (!tfSoDienThoai_NV.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("SoDienThoai",
                  "%" + tfSoDienThoai_NV.getText() + "%")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
            if (!tfEmail_NV.getText().equals("")) {
              modelNV.setRowCount(0);
              for (NhanVienDTO nhanVienDTO : nhanVienBUS.findWithLikeCondition("Email",
                  "%" + tfEmail_NV.getText() + "%")) {
                Vector row = new Vector();
                row.add(nhanVienDTO.getMaNhanVien());
                row.add(nhanVienDTO.getHoNhanVien());
                row.add(nhanVienDTO.getTenNhanVien());
                row.add(nhanVienDTO.getNgayVaoLam());
                row.add(nhanVienDTO.getViTri());
                row.add(nhanVienDTO.getLuong());
                row.add(nhanVienDTO.getSoDienThoai());
                row.add(nhanVienDTO.getEmail());
                modelNV.addRow(row);
              }
              tableNhanVien.setModel(modelNV);
            }
          } catch (Exception e1) {
            JOptionPane.showMessageDialog(tfHoNhanVien, "Thao tác không thành công");
          }
        }
    );
    pnTT_NhanVien.add(btnTimKiem);

    JLabel lblNewLabel = new JLabel("TH\u00D4NG TIN NH\u00C2N VI\u00CAN");
    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblNewLabel.setBounds(229, 11, 224, 24);
    pnTT_NhanVien.add(lblNewLabel);

    JButton btnRS_NV = new JButton("");
    btnRS_NV.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readDataNV();
        clearNV();
      }
    });
    btnRS_NV.setBounds(592, 3, 51, 43);
    btnRS_NV.setIcon(
        new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\imgButton\\refresh.png"));
    pnTT_NhanVien.add(btnRS_NV);

    JPanel pnTT_TaiKhoan = new JPanel();
    pnTT_TaiKhoan.setBackground(new Color(30, 144, 255));
    CardThongTin.add(pnTT_TaiKhoan, "name_830764199438500");
    pnTT_TaiKhoan.setLayout(null);

    JScrollPane scrollPane_3 = new JScrollPane();
    scrollPane_3.setBounds(10, 252, 647, 231);
    pnTT_TaiKhoan.add(scrollPane_3);

    tableTaiKhoan = new JTable();
    scrollPane_3.setViewportView(tableTaiKhoan);

    JLabel lblMaTaiKhoan = new JLabel("M\u00E3 T\u00E0i Kho\u1EA3n :");
    lblMaTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblMaTaiKhoan.setBounds(10, 70, 130, 22);
    pnTT_TaiKhoan.add(lblMaTaiKhoan);

    JLabel lblTnTiKhon = new JLabel("T\u00EAn T\u00E0i Kho\u1EA3n :");
    lblTnTiKhon.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblTnTiKhon.setBounds(10, 116, 134, 22);
    pnTT_TaiKhoan.add(lblTnTiKhon);

    JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u :");
    lblMtKhu.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblMtKhu.setBounds(10, 163, 130, 22);
    pnTT_TaiKhoan.add(lblMtKhu);

    JLabel lblPhnQuyn = new JLabel("Ph\u00E2n quy\u1EC1n :");
    lblPhnQuyn.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblPhnQuyn.setBounds(338, 70, 130, 22);
    pnTT_TaiKhoan.add(lblPhnQuyn);

    JLabel lblMNhnVin = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn :");
    lblMNhnVin.setFont(new Font("Times New Roman", Font.BOLD, 19));
    lblMNhnVin.setBounds(338, 121, 130, 22);
    pnTT_TaiKhoan.add(lblMNhnVin);

    JLabel lblThngTinTi = new JLabel("TH\u00D4NG TIN T\u00C0I KHO\u1EA2N");
    lblThngTinTi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblThngTinTi.setBounds(226, 11, 222, 24);
    pnTT_TaiKhoan.add(lblThngTinTi);

    tfMaTaiKhoan = new JTextField();
    tfMaTaiKhoan.setBounds(150, 70, 166, 23);
    pnTT_TaiKhoan.add(tfMaTaiKhoan);
    tfMaTaiKhoan.setColumns(10);

    tfTenTaiKhoan = new JTextField();
    tfTenTaiKhoan.setColumns(10);
    tfTenTaiKhoan.setBounds(150, 119, 166, 23);
    pnTT_TaiKhoan.add(tfTenTaiKhoan);

    tfMatKhauTK = new JTextField();
    tfMatKhauTK.setColumns(10);
    tfMatKhauTK.setBounds(150, 166, 166, 23);
    pnTT_TaiKhoan.add(tfMatKhauTK);

    tfMaNV = new JTextField();
    tfMaNV.setColumns(10);
    tfMaNV.setBounds(478, 119, 166, 23);
    pnTT_TaiKhoan.add(tfMaNV);

    cbPhanQuyenTK.setBounds(478, 72, 166, 22);
    cbPhanQuyenTK.setModel(new DefaultComboBoxModel(
        new String[]{null, "user", "admin"}));
    pnTT_TaiKhoan.add(cbPhanQuyenTK);

    JButton btnThemTK = new JButton("TH\u00CAM");
    btnThemTK.setBounds(76, 206, 89, 35);
    btnThemTK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
        try {
          if (tfMaTaiKhoan.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhanVien, "Vui lòng nhập Mã Tài Khoản!!!");
          }
          if (tfTenTaiKhoan.getText().equals("")) {
            JOptionPane.showMessageDialog(tfTenTaiKhoan, "Vui lòng nhập Tên tài khoản!!!");
          }
          if (tfMatKhauTK.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMatKhauTK, "Vui lòng nhập Mật khẩu!!!");
          }
          if (cbPhanQuyenTK.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(cbPhanQuyenTK, "Vui lòng nhập phân quyền!!!");
          }
          if (tfMatKhauTK.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMatKhauTK, "Vui lòng nhập Mã nhân viên!!!");
          }
          taiKhoanDTO.setMaTaiKhoan(tfMaTaiKhoan.getText());
          taiKhoanDTO.setTenTaiKhoan(tfTenTaiKhoan.getText());
          taiKhoanDTO.setMatKhau(tfMatKhauTK.getText());
          taiKhoanDTO.setPhanQuyen(cbPhanQuyenTK.getSelectedItem() + "");
          taiKhoanDTO.setMaNV(tfMaNV.getText());
          taiKhoanBUS.them(taiKhoanDTO);
        } catch (Exception ex1) {
          JOptionPane.showMessageDialog(tfTenTaiKhoan, "Thêm không thành công!!!!");
        }
        readDataTK();
      }
    });
    pnTT_TaiKhoan.add(btnThemTK);

    JButton btnXoaTK = new JButton("X\u00D3A");
    btnXoaTK.setBounds(216, 206, 89, 35);
    btnXoaTK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (tfMaTaiKhoan.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaTaiKhoan, "Nhập mã tài khoản để xóa!!!!");
          } else {
            taiKhoanBUS.xoa(tfMaTaiKhoan.getText());
          }
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(tfMaTaiKhoan, "Xóa không thành công!!!!");
        }
        readDataTK();
      }
    });
    pnTT_TaiKhoan.add(btnXoaTK);

    JButton btnSuaTK = new JButton("S\u1EECA");
    btnSuaTK.setBounds(359, 206, 89, 35);
    btnSuaTK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (tfMaTaiKhoan.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaTaiKhoan, "Nhập mã tài khoản để xóa!!!!");
          } else {
            TaiKhoanDTO taiKhoanDTO = taiKhoanBUS.timKiem(tfMaTaiKhoan.getText());
            if (!tfTenTaiKhoan.getText().equals("")) {
              taiKhoanDTO.setTenTaiKhoan(tfTenTaiKhoan.getText());
            }
            if (!tfMatKhauTK.getText().equals("")) {
              taiKhoanDTO.setMatKhau(tfMatKhauTK.getText());
            }
            if (cbPhanQuyenTK.getSelectedItem() != null) {
              taiKhoanDTO.setPhanQuyen(cbPhanQuyenTK.getSelectedItem() + "");
            }
            if (!tfMaNV.getText().equals("")) {
              taiKhoanDTO.setMaNV(tfMaNV.getText());
            }
            taiKhoanBUS.sua(taiKhoanDTO);
          }
          readDataTK();
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(tfTenTaiKhoan, "Sửa không thành công!!!!");
        }
      }
    });
    pnTT_TaiKhoan.add(btnSuaTK);

    JButton btnTimKiemTK = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemTK.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!tfMaTaiKhoan.getText().equals("")) {
          TaiKhoanDTO taiKhoanDTO = taiKhoanBUS.timKiem(tfMaTaiKhoan.getText());
          modelTK.setRowCount(0);
          Vector row = new Vector();
          row.add(taiKhoanDTO.getMaTaiKhoan());
          row.add(taiKhoanDTO.getTenTaiKhoan());
          row.add(taiKhoanDTO.getMatKhau());
          row.add(taiKhoanDTO.getPhanQuyen());
          row.add(taiKhoanDTO.getMaNV());
          modelTK.addRow(row);
        }
        if (!tfTenTaiKhoan.getText().equals("")) {
          modelTK.setRowCount(0);
          List<TaiKhoanDTO> taiKhoanResults = taiKhoanBUS.findWithLikeCondition("TenTaiKhoan",
              "%" + tfTenTaiKhoan.getText() + "%");
          for (TaiKhoanDTO taiKhoanDTO : taiKhoanResults) {
            Vector row = new Vector();
            row.add(taiKhoanDTO.getMaTaiKhoan());
            row.add(taiKhoanDTO.getTenTaiKhoan());
            row.add(taiKhoanDTO.getMatKhau());
            row.add(taiKhoanDTO.getPhanQuyen());
            row.add(taiKhoanDTO.getMaNV());
            modelTK.addRow(row);
          }
          ExportToExcel.export("taikhoan_theoten", TaiKhoanDTO.class, taiKhoanResults);
          try {
            ReadDataFromExcel.readData("taikhoan_theoten");
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
        if (!tfMatKhauTK.getText().equals("")) {
          modelTK.setRowCount(0);
          for (TaiKhoanDTO taiKhoanDTO : taiKhoanBUS.findWithLikeCondition("MatKhau",
              "%" + tfMatKhauTK.getText() + "%")) {
            Vector row = new Vector();
            row.add(taiKhoanDTO.getMaTaiKhoan());
            row.add(taiKhoanDTO.getTenTaiKhoan());
            row.add(taiKhoanDTO.getMatKhau());
            row.add(taiKhoanDTO.getPhanQuyen());
            row.add(taiKhoanDTO.getMaNV());
            modelTK.addRow(row);
          }
        }
        if (cbPhanQuyenTK.getSelectedItem() != null) {
          modelTK.setRowCount(0);
          for (TaiKhoanDTO taiKhoanDTO : taiKhoanBUS.findByCondition("PhanQuyen",
              cbPhanQuyenTK.getSelectedItem() + "")) {
            Vector row = new Vector();
            row.add(taiKhoanDTO.getMaTaiKhoan());
            row.add(taiKhoanDTO.getTenTaiKhoan());
            row.add(taiKhoanDTO.getMatKhau());
            row.add(taiKhoanDTO.getPhanQuyen());
            row.add(taiKhoanDTO.getMaNV());
            modelTK.addRow(row);
          }
        }
        if (!tfMaNV.getText().equals("")) {
          modelTK.setRowCount(0);
          for (TaiKhoanDTO taiKhoanDTO : taiKhoanBUS.findWithLikeCondition("MaNhanVien",
              tfMaNV.getText())) {
            Vector row = new Vector();
            row.add(taiKhoanDTO.getMaTaiKhoan());
            row.add(taiKhoanDTO.getTenTaiKhoan());
            row.add(taiKhoanDTO.getMatKhau());
            row.add(taiKhoanDTO.getPhanQuyen());
            row.add(taiKhoanDTO.getMaNV());
            modelTK.addRow(row);
          }
        }
        tableTaiKhoan.setModel(modelTK);
      }
    });
    btnTimKiemTK.setBounds(497, 206, 89, 35);
    pnTT_TaiKhoan.add(btnTimKiemTK);

    JPanel pnTT_NhaCungCap = new JPanel();
    pnTT_NhaCungCap.setBackground(new Color(0, 191, 255));
    CardThongTin.add(pnTT_NhaCungCap, "name_830765793286600");
    pnTT_NhaCungCap.setLayout(null);

    JScrollPane scrollPane_4 = new JScrollPane();
    scrollPane_4.setBounds(10, 258, 647, 225);
    pnTT_NhaCungCap.add(scrollPane_4);

    tableNhaCungCap = new JTable();
    scrollPane_4.setViewportView(tableNhaCungCap);
    tableNhaCungCap.setModel(modelNCC);

    tableNhaCungCap.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = tableNhaCungCap.getSelectedRow();
        NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
        nhaCungCapDTO.setMaNhaCungCap(modelNCC.getValueAt(i, 0).toString());
        tfMaNhaCungCap.setText(nhaCungCapDTO.getMaNhaCungCap());
        nhaCungCapDTO.setTenNhaCungCap(modelNCC.getValueAt(i, 1).toString());
        tfTenNhaCungCap.setText(nhaCungCapDTO.getTenNhaCungCap());
        nhaCungCapDTO.setSdt(modelNCC.getValueAt(i, 2).toString());
        tfSoDienThoai_NCC.setText(nhaCungCapDTO.getSdt());
        nhaCungCapDTO.setDiaChi(modelNCC.getValueAt(i, 3).toString());
        tfDiaChiNhaCungCap.setText(nhaCungCapDTO.getDiaChi());
        nhaCungCapDTO.setEmail(modelNCC.getValueAt(i, 4).toString());
        tfEmail_NCC.setText(nhaCungCapDTO.getEmail());
      }
    });

    JScrollPane scrollPaneTK = new JScrollPane();
    scrollPaneTK.setBounds(5, 260, 647, 260);
//    pnTT_TaiKhoan.add(scrollPaneTK);
//    scrollPaneTK.setViewportView(tableTaiKhoan);
    Vector headerTK = new Vector<>();
    headerTK.add("Mã TK");
    headerTK.add("Tên TK");
    headerTK.add("Mật khẩu");
    headerTK.add("Phân quyền");
    headerTK.add("Mã nhân viên");
    if (modelTK.getRowCount() == 0) {
      modelTK = new DefaultTableModel(headerTK, 0);
      readDataTK();
    }

    JLabel lblMaNCC = new JLabel("M\u00E3 Nh\u00E0 Cung C\u1EA5p :");
    lblMaNCC.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaNCC.setBounds(10, 57, 157, 21);
    pnTT_NhaCungCap.add(lblMaNCC);

    JLabel lblTnNhCung = new JLabel("T\u00EAn Nh\u00E0 Cung C\u1EA5p :");
    lblTnNhCung.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTnNhCung.setBounds(10, 104, 160, 21);
    pnTT_NhaCungCap.add(lblTnNhCung);

    JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9 :");
    lblaCh.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblaCh.setBounds(379, 57, 65, 21);
    pnTT_NhaCungCap.add(lblaCh);

    JLabel lblSinThoi_1 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
    lblSinThoi_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblSinThoi_1.setBounds(10, 149, 113, 21);
    pnTT_NhaCungCap.add(lblSinThoi_1);

    JLabel lblEmail_1 = new JLabel("Email :");
    lblEmail_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblEmail_1.setBounds(379, 107, 55, 21);
    pnTT_NhaCungCap.add(lblEmail_1);

    JScrollPane scrollPaneNCC = new JScrollPane();
    scrollPaneNCC.setBounds(10, 260, 647, 260);
//    pnTT_NhaCungCap.add(scrollPaneNCC);
//    scrollPaneNCC.setViewportView(tableNhaCungCap);
    Vector headerNCC = new Vector<>();
    headerNCC.add("Mã NCC");
    headerNCC.add("Tên NCC");
    headerNCC.add("Số điện thoại");
    headerNCC.add("Địa chỉ");
    headerNCC.add("Email");
    if (modelNCC.getRowCount() == 0) {
      modelNCC = new DefaultTableModel(headerNCC, 0);
      readDataNCC();
    }

    tfMaNhaCungCap = new JTextField();
    tfMaNhaCungCap.setBounds(177, 57, 166, 22);
    pnTT_NhaCungCap.add(tfMaNhaCungCap);
    tfMaNhaCungCap.setColumns(10);

    tfTenNhaCungCap = new JTextField();
    tfTenNhaCungCap.setColumns(10);
    tfTenNhaCungCap.setBounds(177, 106, 166, 22);
    pnTT_NhaCungCap.add(tfTenNhaCungCap);

    tfDiaChiNhaCungCap = new JTextField();
    tfDiaChiNhaCungCap.setColumns(10);
    tfDiaChiNhaCungCap.setBounds(454, 58, 187, 22);
    pnTT_NhaCungCap.add(tfDiaChiNhaCungCap);

    tfSoDienThoai_NCC = new JTextField();
    tfSoDienThoai_NCC.setColumns(10);
    tfSoDienThoai_NCC.setBounds(177, 150, 166, 22);
    pnTT_NhaCungCap.add(tfSoDienThoai_NCC);

    tfEmail_NCC = new JTextField();
    tfEmail_NCC.setColumns(10);
    tfEmail_NCC.setBounds(454, 108, 187, 22);
    pnTT_NhaCungCap.add(tfEmail_NCC);

    JLabel lblThngTinNh = new JLabel("TH\u00D4NG TIN NH\u00C0 CUNG C\u1EA4P");
    lblThngTinNh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblThngTinNh.setBounds(213, 11, 260, 24);
    pnTT_NhaCungCap.add(lblThngTinNh);

    JButton btnThemNCC = new JButton("TH\u00CAM ");
    btnThemNCC.setBounds(20, 200, 113, 49);
    btnThemNCC.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
        try {
          if (tfMaNhaCungCap.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhaCungCap, "Vui lòng nhập Mã Nhà cung cấp!!!");
          }
          if (tfTenNhaCungCap.getText().equals("")) {
            JOptionPane.showMessageDialog(tfTenNhaCungCap, "Vui lòng nhập Tên nhà cung cấp!!!");
          }
          if (tfSoDienThoai_NCC.getText().equals("")) {
            JOptionPane.showMessageDialog(tfSoDienThoai_NCC, "Vui lòng nhập Số điện thoại!!!");
          }
          if (tfDiaChiNhaCungCap.getText().equals("")) {
            JOptionPane.showMessageDialog(tfDiaChiNhaCungCap, "Vui lòng địa chỉ!!!");
          }
          if (tfEmail_NCC.getText().equals("")) {
            JOptionPane.showMessageDialog(tfEmail_NCC, "Vui lòng nhập Email!!!");
          }
          nhaCungCapDTO.setMaNhaCungCap(tfMaNhaCungCap.getText());
          nhaCungCapDTO.setTenNhaCungCap(tfTenNhaCungCap.getText());
          nhaCungCapDTO.setSdt(tfSoDienThoai_NCC.getText());
          nhaCungCapDTO.setDiaChi(tfEmail_NCC.getText());
          nhaCungCapDTO.setEmail(tfDiaChiNhaCungCap.getText());
          nhaCungCapBUS.them(nhaCungCapDTO);
        } catch (Exception ex1) {
          JOptionPane.showMessageDialog(tfTenTaiKhoan, "Thêm không thành công!!!!");
        }
        readDataNCC();
      }
    });
    pnTT_NhaCungCap.add(btnThemNCC);

    JButton btnXoaNCC = new JButton("X\u00D3A");
    btnXoaNCC.setBounds(181, 200, 113, 47);
    btnXoaNCC.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (tfMaNhaCungCap.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhaCungCap, "Nhập mã để xóa!!!!");
          }
          nhaCungCapBUS.xoa(tfMaNhaCungCap.getText());
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(tfTenNhaCungCap, "Xóa không thành công!!!!");
        }
        readDataNCC();
      }
    });
    pnTT_NhaCungCap.add(btnXoaNCC);

    JButton btnSuaNCC = new JButton("S\u1EECA");
    btnSuaNCC.setBounds(350, 202, 113, 47);
    btnSuaNCC.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (tfMaNhaCungCap.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhaCungCap, "Nhập mã để sửa!!!!");
          } else {
            NhaCungCapDTO nhaCungCapDTO = nhaCungCapBUS.timKiem(tfMaNhaCungCap.getText());
            if (!tfTenNhaCungCap.getText().equals("")) {
              nhaCungCapDTO.setTenNhaCungCap(tfTenNhaCungCap.getText());
            }
            if (!tfSoDienThoai_NCC.getText().equals("")) {
              nhaCungCapDTO.setSdt(tfSoDienThoai_NCC.getText());
            }
            if (!tfDiaChiNhaCungCap.getText().equals("")) {
              nhaCungCapDTO.setDiaChi(tfDiaChiNhaCungCap.getText());
            }
            if (!tfEmail_NCC.getText().equals("")) {
              nhaCungCapDTO.setEmail(tfEmail_NCC.getText());
            }
            nhaCungCapBUS.sua(nhaCungCapDTO);
          }
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(tfTenNhaCungCap, "Sửa không thành công!!!!");
        }
        readDataNCC();
      }
    });
    pnTT_NhaCungCap.add(btnSuaNCC);

    JButton btnTimKiemNCC = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemNCC.setBounds(520, 200, 113, 49);
    btnTimKiemNCC.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!tfMaNhaCungCap.getText().equals("")) {
          NhaCungCapDTO nhaCungCapDTO = nhaCungCapBUS.timKiem(tfMaNhaCungCap.getText());
          modelNCC.setRowCount(0);
          Vector row = new Vector();
          row.add(nhaCungCapDTO.getMaNhaCungCap());
          row.add(nhaCungCapDTO.getTenNhaCungCap());
          row.add(nhaCungCapDTO.getSdt());
          row.add(nhaCungCapDTO.getDiaChi());
          row.add(nhaCungCapDTO.getEmail());
          modelNCC.addRow(row);
        }
        if (!tfTenNhaCungCap.getText().equals("")) {
          modelNCC.setRowCount(0);
          List<NhaCungCapDTO> nhaCungCapDTOList = nhaCungCapBUS.findWithLikeCondition(
              "TenNhaCungCap",
              "%" + tfTenNhaCungCap.getText() + "%");
          for (NhaCungCapDTO nhaCungCapDTO : nhaCungCapDTOList) {
            Vector row = new Vector();
            row.add(nhaCungCapDTO.getMaNhaCungCap());
            row.add(nhaCungCapDTO.getTenNhaCungCap());
            row.add(nhaCungCapDTO.getSdt());
            row.add(nhaCungCapDTO.getDiaChi());
            row.add(nhaCungCapDTO.getEmail());
            modelNCC.addRow(row);
          }
          ExportToExcel.export("nhacungcap_theoten", NhaCungCapDTO.class, nhaCungCapDTOList);
          try {
            ReadDataFromExcel.readData("nhacungcap_theoten");
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
        if (!tfDiaChiNhaCungCap.getText().equals("")) {
          modelNCC.setRowCount(0);
          for (NhaCungCapDTO nhaCungCapDTO : nhaCungCapBUS.findWithLikeCondition("DiaChi",
              "%" + tfDiaChiNhaCungCap.getText() + "%")) {
            Vector row = new Vector();
            row.add(nhaCungCapDTO.getMaNhaCungCap());
            row.add(nhaCungCapDTO.getTenNhaCungCap());
            row.add(nhaCungCapDTO.getSdt());
            row.add(nhaCungCapDTO.getDiaChi());
            row.add(nhaCungCapDTO.getEmail());
            modelNCC.addRow(row);
          }
        }
        if (!tfSoDienThoai_NCC.getText().equals("")) {
          modelNCC.setRowCount(0);
          for (NhaCungCapDTO nhaCungCapDTO : nhaCungCapBUS.findWithLikeCondition("Sdt",
              "%" + tfSoDienThoai_NCC.getText() + "%")) {
            Vector row = new Vector();
            row.add(nhaCungCapDTO.getMaNhaCungCap());
            row.add(nhaCungCapDTO.getTenNhaCungCap());
            row.add(nhaCungCapDTO.getSdt());
            row.add(nhaCungCapDTO.getDiaChi());
            row.add(nhaCungCapDTO.getEmail());
            modelNCC.addRow(row);
          }
        }
        if (!tfEmail_NCC.getText().equals("")) {
          modelNCC.setRowCount(0);
          for (NhaCungCapDTO nhaCungCapDTO : nhaCungCapBUS.findWithLikeCondition("Email",
              "%" + tfEmail_NCC.getText() + "%")) {
            Vector row = new Vector();
            row.add(nhaCungCapDTO.getMaNhaCungCap());
            row.add(nhaCungCapDTO.getTenNhaCungCap());
            row.add(nhaCungCapDTO.getSdt());
            row.add(nhaCungCapDTO.getDiaChi());
            row.add(nhaCungCapDTO.getEmail());
            modelNCC.addRow(row);
          }
        }
        tableNhaCungCap.setModel(modelNCC);
      }
    });
    pnTT_NhaCungCap.add(btnTimKiemNCC);

    JButton btnRS_4 = new JButton("");
    btnRS_4.setIcon(
        new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\imgButton\\refresh.png"));
    btnRS_4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readDataNCC();
        clearNCC();
      }
    });
    btnRS_4.setBounds(593, 11, 51, 43);
    pnTT_NhaCungCap.add(btnRS_4);

    JPanel pnTT_NhaSanXuat = new JPanel();
    pnTT_NhaSanXuat.setBackground(new Color(224, 255, 255));
    CardThongTin.add(pnTT_NhaSanXuat, "name_830767186557700");
    pnTT_NhaSanXuat.setLayout(null);

    JScrollPane scrollPane_5 = new JScrollPane();
    scrollPane_5.setBounds(10, 218, 647, 265);
    pnTT_NhaSanXuat.add(scrollPane_5);

    tableNhaSanXuat = new JTable();
    scrollPane_5.setViewportView(tableNhaSanXuat);
    tableNhaSanXuat.setModel(modelNSX);

    tableNhaSanXuat.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = tableNhaSanXuat.getSelectedRow();
        NhaSanXuatDTO nhaSanXuatDTO = new NhaSanXuatDTO();
        nhaSanXuatDTO.setMaNhaSanXuat(modelNSX.getValueAt(i, 0).toString());
        tfMaNhaSanXuat.setText(nhaSanXuatDTO.getMaNhaSanXuat());
        nhaSanXuatDTO.setTenNhaSanXuat(modelNSX.getValueAt(i, 1).toString());
        tfTenNhaSanXuat.setText(nhaSanXuatDTO.getTenNhaSanXuat());
        nhaSanXuatDTO.setDiaChi(modelNSX.getValueAt(i, 2).toString());
        tfDiaChi_NSX.setText(nhaSanXuatDTO.getDiaChi());
        nhaSanXuatDTO.setSoDienThoai(modelNSX.getValueAt(i, 3).toString());
        tfSoDienThoai_NSX.setText(nhaSanXuatDTO.getSoDienThoai());
      }
    });

    JLabel lblMaNhaSanXuat = new JLabel("M\u00E3 Nh\u00E0 S\u1EA3n Xu\u1EA5t :");
    lblMaNhaSanXuat.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaNhaSanXuat.setBounds(10, 65, 149, 21);
    pnTT_NhaSanXuat.add(lblMaNhaSanXuat);

    JLabel lblTnNhSn = new JLabel("T\u00EAn Nh\u00E0 S\u1EA3n Xu\u1EA5t :");
    lblTnNhSn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTnNhSn.setBounds(10, 111, 152, 21);
    pnTT_NhaSanXuat.add(lblTnNhSn);

    JLabel lblaCh_1 = new JLabel("\u0110\u1ECBa ch\u1EC9 :");
    lblaCh_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblaCh_1.setBounds(354, 63, 65, 21);
    pnTT_NhaSanXuat.add(lblaCh_1);

    JLabel lblSinThoi_2 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
    lblSinThoi_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblSinThoi_2.setBounds(354, 114, 113, 21);
    pnTT_NhaSanXuat.add(lblSinThoi_2);

    JScrollPane scrollPaneNSX = new JScrollPane();
    scrollPaneNSX.setBounds(10, 260, 647, 260);
//    pnTT_NhaSanXuat.add(scrollPaneNSX);
//    scrollPaneNSX.setViewportView(tableNhaSanXuat);
    Vector headerNSX = new Vector<>();
    headerNSX.add("Mã NSX");
    headerNSX.add("Tên NSX");
    headerNSX.add("Địa chỉ");
    headerNSX.add("Số điện thoại");

    if (modelNSX.getRowCount() == 0) {
      modelNSX = new DefaultTableModel(headerNSX, 0);
      readDataNSX();
    }

    tfMaNhaSanXuat = new JTextField();
    tfMaNhaSanXuat.setBounds(169, 65, 164, 22);
    pnTT_NhaSanXuat.add(tfMaNhaSanXuat);
    tfMaNhaSanXuat.setColumns(10);

    tfTenNhaSanXuat = new JTextField();
    tfTenNhaSanXuat.setColumns(10);
    tfTenNhaSanXuat.setBounds(169, 113, 164, 22);
    pnTT_NhaSanXuat.add(tfTenNhaSanXuat);

    tfSoDienThoai_NSX = new JTextField();
    tfSoDienThoai_NSX.setColumns(10);
    tfSoDienThoai_NSX.setBounds(478, 110, 164, 22);
    pnTT_NhaSanXuat.add(tfSoDienThoai_NSX);

    tfDiaChi_NSX = new JTextField();
    tfDiaChi_NSX.setColumns(10);
    tfDiaChi_NSX.setBounds(478, 65, 164, 22);
    pnTT_NhaSanXuat.add(tfDiaChi_NSX);

    JButton btnThemNSX = new JButton("TH\u00CAM");
    btnThemNSX.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        NhaSanXuatDTO nhaSanXuatDTO = new NhaSanXuatDTO();
        try {
          if (tfMaNhaSanXuat.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhaSanXuat, "Vui lòng nhập Mã Nhà sản xuất!!!");
          }
          if (tfTenNhaSanXuat.getText().equals("")) {
            JOptionPane.showMessageDialog(tfTenNhaSanXuat, "Vui lòng nhập Tên nhà sản xuất!!!");
          }
          if (tfDiaChi_NSX.getText().equals("")) {
            JOptionPane.showMessageDialog(tfDiaChi_NSX, "Vui lòng nhập địa chỉ!!!");
          }

          if (tfSoDienThoai_NCC.getText().equals("")) {
            JOptionPane.showMessageDialog(tfSoDienThoai_NSX, "Vui lòng nhập Số điện thoại!!!");
          }
          nhaSanXuatDTO.setMaNhaSanXuat(tfMaNhaSanXuat.getText());
          nhaSanXuatDTO.setTenNhaSanXuat(tfTenNhaSanXuat.getText());
          nhaSanXuatDTO.setSoDienThoai(tfSoDienThoai_NSX.getText());
          nhaSanXuatDTO.setDiaChi(tfDiaChi_NSX.getText());
          nhaSanXuatBUS.them(nhaSanXuatDTO);
        } catch (Exception ex1) {
          JOptionPane.showMessageDialog(tfTenTaiKhoan, "Thêm không thành công!!!!");
        }
        readDataNSX();
      }
    });
    btnThemNSX.setBounds(31, 166, 101, 41);
    pnTT_NhaSanXuat.add(btnThemNSX);

    JButton btnXoaNSX = new JButton("X\u00D3A");
    btnXoaNSX.setBounds(193, 166, 101, 41);
    btnXoaNSX.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (tfMaNhaSanXuat.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhaSanXuat, "Vui lòng nhập mã để xóa!!!!");
          } else {
            nhaSanXuatBUS.xoa(tfMaNhaSanXuat.getText());
          }
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(tfMaNhaSanXuat, "Xóa không thành công!!!!");
        }
        readDataNSX();
      }
    });
    pnTT_NhaSanXuat.add(btnXoaNSX);

    JButton btnSuaNSX = new JButton("S\u1EECA");
    btnSuaNSX.setBounds(364, 166, 101, 41);
    btnSuaNSX.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (tfMaNhaSanXuat.getText().equals("")) {
            JOptionPane.showMessageDialog(tfMaNhaSanXuat, "Vui lòng nhập mã để sửa!!!!");
          } else {
            NhaSanXuatDTO nhaSanXuatDTO = nhaSanXuatBUS.timKiem(tfMaNhaSanXuat.getText());
            if (!tfTenNhaSanXuat.getText().equals("")) {
              nhaSanXuatDTO.setTenNhaSanXuat(tfTenNhaSanXuat.getText());
            }
            if (!tfDiaChi_NSX.getText().equals("")) {
              nhaSanXuatDTO.setDiaChi(tfDiaChi_NSX.getText());
            }
            if (!tfSoDienThoai_NSX.getText().equals("")) {
              nhaSanXuatDTO.setSoDienThoai(tfSoDienThoai_NSX.getText());
            }
            nhaSanXuatBUS.sua(nhaSanXuatDTO);
          }
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(tfMaNhaSanXuat, "Sửa không thành công!!!!");
        }
        readDataNSX();
      }
    });
    pnTT_NhaSanXuat.add(btnSuaNSX);

    JButton btnTimKiemNSX = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemNSX.setBounds(527, 166, 101, 41);
    btnTimKiemNSX.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (!tfMaNhaSanXuat.getText().equals("")) {
            NhaSanXuatDTO nhaSanXuatDTO = nhaSanXuatBUS.timKiem(tfMaNhaSanXuat.getText());
            modelNSX.setRowCount(0);
            Vector row = new Vector();
            row.add(nhaSanXuatDTO.getMaNhaSanXuat());
            row.add(nhaSanXuatDTO.getTenNhaSanXuat());
            row.add(nhaSanXuatDTO.getDiaChi());
            row.add(nhaSanXuatDTO.getSoDienThoai());
            modelNSX.addRow(row);
          }
          if (!tfTenNhaSanXuat.getText().equals("")) {
            modelNSX.setRowCount(0);
            List<NhaSanXuatDTO> results = nhaSanXuatBUS.findWithLikeCondition("TenNhaSanXuat",
                "%" + tfTenNhaSanXuat.getText() + "%");
            for (NhaSanXuatDTO nhaSanXuatDTO : results) {
              Vector row = new Vector();
              row.add(nhaSanXuatDTO.getMaNhaSanXuat());
              row.add(nhaSanXuatDTO.getTenNhaSanXuat());
              row.add(nhaSanXuatDTO.getDiaChi());
              row.add(nhaSanXuatDTO.getSoDienThoai());
              modelNSX.addRow(row);
            }
            ExportToExcel.export("nhasanxuat_theoten", NhaSanXuatDTO.class, results);
            ReadDataFromExcel.readData("nhasanxuat_theoten");
          }
          if (!tfDiaChi_NSX.getText().equals("")) {
            modelNSX.setRowCount(0);
            for (NhaSanXuatDTO nhaSanXuatDTO : nhaSanXuatBUS.findWithLikeCondition("DiaChi",
                "%" + tfDiaChi_NSX.getText() + "%")) {
              Vector row = new Vector();
              row.add(nhaSanXuatDTO.getMaNhaSanXuat());
              row.add(nhaSanXuatDTO.getTenNhaSanXuat());
              row.add(nhaSanXuatDTO.getDiaChi());
              row.add(nhaSanXuatDTO.getSoDienThoai());
              modelNSX.addRow(row);
            }
          }
          if (!tfSoDienThoai_NSX.getText().equals("")) {
            modelNSX.setRowCount(0);
            for (NhaSanXuatDTO nhaSanXuatDTO : nhaSanXuatBUS.findWithLikeCondition("SoDienThoai",
                "%" + tfSoDienThoai_NSX.getText() + "%")) {
              Vector row = new Vector();
              row.add(nhaSanXuatDTO.getMaNhaSanXuat());
              row.add(nhaSanXuatDTO.getTenNhaSanXuat());
              row.add(nhaSanXuatDTO.getDiaChi());
              row.add(nhaSanXuatDTO.getSoDienThoai());
              modelNSX.addRow(row);
            }
          }
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(tfMaNhaSanXuat, "Tìm kiếm không thành công!!!!");
        }
        tableNhaSanXuat.setModel(modelNSX);
      }
    });
    pnTT_NhaSanXuat.add(btnTimKiemNSX);

    JLabel lblThngTinNh_1 = new JLabel("TH\u00D4NG TIN NH\u00C0 S\u1EA2N XU\u1EA4T");
    lblThngTinNh_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
    lblThngTinNh_1.setBounds(187, 15, 263, 24);
    pnTT_NhaSanXuat.add(lblThngTinNh_1);

    JButton btnRS_5 = new JButton("");
    btnRS_5.setIcon(
        new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\imgButton\\refresh.png"));
    btnRS_5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readDataNSX();
        clearNSX();
      }
    });
    btnRS_5.setBounds(592, 11, 51, 43);
    pnTT_NhaSanXuat.add(btnRS_5);

    JPanel pnTT_ThongKe = new JPanel();
    pnTT_ThongKe.setBackground(new Color(0, 255, 255));
    CardThongTin.add(pnTT_ThongKe, "name_830768477387000");
    pnTT_ThongKe.setLayout(null);

    JPanel pnMoDau = new JPanel();
    pnMoDau.setBackground(new Color(255, 105, 180));
    CardThongTin.add(pnMoDau, "name_11636176876500");
    pnMoDau.setLayout(null);

    JLabel lblLogo = new JLabel("");
    lblLogo.setBounds(194, 120, 271, 198);
    lblLogo.setIcon(new ImageIcon("imgButton/logo.png"));
    pnMoDau.add(lblLogo);

    JLabel lblHinhNen = new JLabel("");
    lblHinhNen.setIcon(new ImageIcon("imgButton/hinhnen.png"));
    lblHinhNen.setBounds(-229, 0, 896, 494);
    pnMoDau.add(lblHinhNen);

    JPanel pnTTCT_KhuyenMai = new JPanel();
    pnTTCT_KhuyenMai.setBackground(new Color(255, 160, 122));
    CardThongTin.add(pnTTCT_KhuyenMai, "name_15312920090800");
    pnTTCT_KhuyenMai.setLayout(null);

    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(10, 223, 647, 260);
    pnTTCT_KhuyenMai.add(scrollPane_1);

    tableChuongTrinhKM = new JTable();
    scrollPane_1.setViewportView(tableChuongTrinhKM);

    JLabel lblMaChuongTrinh = new JLabel("M\u00E3 Ch\u01B0\u01A1ng tr\u00ECnh :");
    lblMaChuongTrinh.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblMaChuongTrinh.setBounds(10, 69, 152, 21);
    pnTTCT_KhuyenMai.add(lblMaChuongTrinh);

    JLabel lblTnChngTrnh = new JLabel("T\u00EAn Ch\u01B0\u01A1ng tr\u00ECnh :");
    lblTnChngTrnh.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblTnChngTrnh.setBounds(10, 122, 152, 21);
    pnTTCT_KhuyenMai.add(lblTnChngTrnh);

    JLabel lblNgyB = new JLabel("Ng\u00E0y B\u0110 :");
    lblNgyB.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblNgyB.setBounds(348, 69, 80, 21);
    pnTTCT_KhuyenMai.add(lblNgyB);

    JLabel lblNgyKt = new JLabel("Ng\u00E0y KT :");
    lblNgyKt.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblNgyKt.setBounds(348, 122, 80, 21);
    pnTTCT_KhuyenMai.add(lblNgyKt);

    tfMaCT = new JTextField();
    tfMaCT.setBounds(174, 71, 164, 20);
    pnTTCT_KhuyenMai.add(tfMaCT);
    tfMaCT.setColumns(10);

    tfTenCT = new JTextField();
    tfTenCT.setColumns(10);
    tfTenCT.setBounds(174, 124, 164, 20);
    pnTTCT_KhuyenMai.add(tfTenCT);

    cbNgayBD_CTKM.setBounds(449, 70, 39, 22);
    cbNgayBD_CTKM.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
            "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
            "28", "29", "30", "31"}));

    pnTTCT_KhuyenMai.add(cbNgayBD_CTKM);

    cbThangBD_CTKM.setBounds(508, 70, 39, 22);
    cbThangBD_CTKM.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12"}));
    pnTTCT_KhuyenMai.add(cbThangBD_CTKM);

    tfNamBD_CTKM.setBounds(557, 70, 63, 22);
    tfNamBD_CTKM.setModel(new DefaultComboBoxModel(new String[]{null, "2020", "2021", "2022"}));
    pnTTCT_KhuyenMai.add(tfNamBD_CTKM);

    cbNgayKT_CTKM.setBounds(449, 122, 39, 22);
    cbNgayKT_CTKM.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
            "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
            "28", "29", "30", "31"}));
    pnTTCT_KhuyenMai.add(cbNgayKT_CTKM);

    cbThangKT_CTKM.setBounds(508, 122, 39, 22);
    cbThangKT_CTKM.setModel(new DefaultComboBoxModel(
        new String[]{null, "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12"}));
    pnTTCT_KhuyenMai.add(cbThangKT_CTKM);

    cbNamKT_CTKM.setBounds(557, 122, 63, 22);
    cbNamKT_CTKM.setModel(new DefaultComboBoxModel(new String[]{null, "2020", "2021", "2022"}));
    pnTTCT_KhuyenMai.add(cbNamKT_CTKM);

    JLabel lblThngTinChng = new JLabel(
        "TH\u00D4NG TIN CH\u01AF\u01A0NG TR\u00CCNH KHUY\u1EBEN M\u00C3I");
    lblThngTinChng.setFont(new Font("Times New Roman", Font.BOLD, 18));
    lblThngTinChng.setBounds(145, 11, 376, 21);
    pnTTCT_KhuyenMai.add(lblThngTinChng);

    JButton btnThemCTKM = new JButton("TH\u00CAM");
    btnThemCTKM.setBounds(10, 180, 109, 32);
    btnThemCTKM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = new ChuongTrinhKhuyenMaiDTO();
        chuongTrinhKhuyenMaiDTO.setMaChuongTrinh(tfMaCT.getText());
        chuongTrinhKhuyenMaiDTO.setTenKhuyenMai(tfTenCT.getText());
        String ngayBatDau =
            tfNamBD_CTKM.getSelectedObjects()[0] + "-" + cbThangBD_CTKM.getSelectedObjects()[0]
                + "-"
                + cbNgayBD_CTKM.getSelectedObjects()[0];
        chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(ngayBatDau));

        String ngayKetThuc =
            cbNamKT_CTKM.getSelectedObjects()[0] + "-" + cbThangKT_CTKM.getSelectedObjects()[0]
                + "-"
                + cbNgayKT_CTKM.getSelectedObjects()[0];
        chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(ngayKetThuc));
        chuongTrinhKhuyenMaiBUS.them(chuongTrinhKhuyenMaiDTO);
        modelCTKM.setRowCount(0);
        tableChuongTrinhKM.setModel(modelCTKM);
      }
    });
    pnTTCT_KhuyenMai.add(btnThemCTKM);

    JButton btnXoaCTKM = new JButton("X\u00D3A");
    btnXoaCTKM.setBounds(145, 180, 109, 32);
    btnXoaCTKM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String ma = tfMaCT.getText();
        chuongTrinhKhuyenMaiBUS.xoa(ma);
        modelCTKM.setRowCount(0);
        readDataCTKM();
        tableChuongTrinhKM.setModel(modelCTKM);
      }
    });
    pnTTCT_KhuyenMai.add(btnXoaCTKM);

    JButton btnSuaCTKM = new JButton("S\u1EECA");
    btnSuaCTKM.setBounds(280, 180, 109, 32);
    btnSuaCTKM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tfMaCT.getText().equals("")) {
          JOptionPane.showMessageDialog(tfTenCT, "Vui long nhap ma chuong trinh can sua!!!!");
        }
        ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = chuongTrinhKhuyenMaiBUS.timKiem(
            tfMaCT.getText().toUpperCase()); // tránh lỗi quên bật CapsLock

        try {
          if (!tfTenCT.getText().equals("") || tfTenCT.getText() != null) {
            chuongTrinhKhuyenMaiDTO.setTenKhuyenMai(tfTenCT.getText());
          }
        } catch (Exception e1) {
          System.out.println("Lỗi ở btnSuaCTKM: " + e1.getMessage());
        }

        try {
          if (tfNamBD_CTKM.getSelectedItem() != null
              && cbThangBD_CTKM.getSelectedItem() != null
              && cbNgayBD_CTKM.getSelectedItem() != null) {
            String ngayBatDau =
                tfNamBD_CTKM.getSelectedObjects()[0] + "-" + cbThangBD_CTKM.getSelectedObjects()[0]
                    + "-"
                    + cbNgayBD_CTKM.getSelectedObjects()[0];
            chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(ngayBatDau));
          }
          if (!tfTenCT.getText().equals("")) {
            chuongTrinhKhuyenMaiDTO.setTenKhuyenMai(tfTenCT.getText());
          }

          if (tfNamBD_CTKM.getSelectedItem() != null) {
            String namBatDau = tfNamBD_CTKM.getSelectedObjects()[0] + "";
            String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
            ngayBatDau[0] = namBatDau;
            String newNgayBatDau = String.join("-", ngayBatDau);
            chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(newNgayBatDau));
          }
          if (cbThangBD_CTKM.getSelectedItem() != null) {
            String thangBatDau = cbThangBD_CTKM.getSelectedItem() + "";
            String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
            ngayBatDau[1] = thangBatDau;
            String newNgayBatDau = String.join("-", ngayBatDau);
            chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(newNgayBatDau));
          }
          if (cbNgayBD_CTKM.getSelectedItem() != null) {
            String ngayBD = cbNgayBD_CTKM.getSelectedItem() + "";
            String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
            ngayBatDau[2] = ngayBD;
            String newNgayBatDau = String.join("-", ngayBatDau);
            chuongTrinhKhuyenMaiDTO.setNgayBatDau(java.sql.Date.valueOf(newNgayBatDau));
          }
          if (cbNamKT_CTKM.getSelectedItem() != null
              && cbThangKT_CTKM.getSelectedItem() != null
              && cbNgayKT_CTKM.getSelectedItem() != null) {
            String ngayKetThuc =
                cbNamKT_CTKM.getSelectedItem() + "-" + cbThangKT_CTKM.getSelectedItem()
                    + "-"
                    + cbNgayKT_CTKM.getSelectedItem();
            chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(ngayKetThuc));
          }
          if (cbNamKT_CTKM.getSelectedItem() != null) {
            String namKetThuc = cbNamKT_CTKM.getSelectedItem() + "";
            String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
            ngayKetThuc[0] = namKetThuc;
            String newNgayKetThuc = String.join("-", ngayKetThuc);
            chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(newNgayKetThuc));
          }
          if (cbThangKT_CTKM.getSelectedItem() != null) {
            String thangKetThuc = cbThangKT_CTKM.getSelectedItem() + "";
            String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
            ngayKetThuc[1] = thangKetThuc;
            String newNgayKetThuc = String.join("-", ngayKetThuc);
            chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(newNgayKetThuc));
          }
          if (cbNgayKT_CTKM.getSelectedItem() != null) {
            String ngayKT = cbNgayKT_CTKM.getSelectedItem() + "";
            String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
            ngayKetThuc[2] = ngayKT;
            String newNgayKetThuc = String.join("-", ngayKetThuc);
            chuongTrinhKhuyenMaiDTO.setNgayKetThuc(java.sql.Date.valueOf(newNgayKetThuc));
          }
        } catch (Exception e1) {
          System.out.println("Lỗi ở sửa NGÀY THÁNG NĂM KẾT THÚC btnTimKiem: " + e1.getMessage());
        }
        chuongTrinhKhuyenMaiBUS.sua(chuongTrinhKhuyenMaiDTO);
        modelCTKM.setRowCount(0);
        readDataCTKM();
        tableChuongTrinhKM.setModel(modelCTKM);
      }
    });
    pnTTCT_KhuyenMai.add(btnSuaCTKM);

    JButton btnTimKiemCTKM = new JButton("T\u00CCM KI\u1EBEM");
    btnTimKiemCTKM.setBounds(420, 180, 109, 32);
    btnTimKiemCTKM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String ma = tfMaCT.getText();
        try {
          //if (tfMaCT.getText().equals("") || tfMaCT.getText() != null || tfMaCT.getText().length() == 0) {
          if (!ma.equals("")) {
            ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = chuongTrinhKhuyenMaiBUS.timKiem(ma);
            tfTenCT.setText(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
            String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
            cbNgayBD_CTKM.setSelectedItem(ngayBatDau[2]);
            cbThangBD_CTKM.setSelectedItem(ngayBatDau[1]);
            tfNamBD_CTKM.setSelectedItem(
                ngayBatDau[0]);  //do  lưu  theo dạng  YYYY/mm/DD nên query ngược lại
            String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
            cbNgayKT_CTKM.setSelectedItem(ngayKetThuc[2]);
            cbThangKT_CTKM.setSelectedItem(ngayKetThuc[1]);
            cbNamKT_CTKM.setSelectedItem(ngayKetThuc[0]);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiBUS.findByUseLike(
                "MaChuongTrinh", "%" + tfMaCT.getText() + "%")) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
            tableChuongTrinhKM.setModel(modelCTKM);

          }
        } catch (Exception ex) {
          System.out.println("Loi tim theo ma: " + ex.getMessage());
        }

        try {
          if (!tfTenCT.getText().equals("")) {
            modelCTKM.setRowCount(0);
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByUseLike(
                "TenKhuyenMai", "%" + tfTenCT.getText() + "%");
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
            ExportToExcel.export("chuongtrinhkhuyenmai_theoten", ChuongTrinhKhuyenMaiDTO.class,
                results);
            ReadDataFromExcel.readData("chuongtrinhkhuyenmai_theoten");
          }

          String[] fields = {"NgayBatDau", "NgayKetThuc"};
          String ngayBatDau =
              tfNamBD_CTKM.getSelectedItem() + "-" + cbThangBD_CTKM.getSelectedItem()
                  + "-"
                  + cbNgayBD_CTKM.getSelectedItem();
          String ngayKetThuc =
              cbNamKT_CTKM.getSelectedItem() + "-" + cbThangKT_CTKM.getSelectedItem()
                  + "-"
                  + cbNgayKT_CTKM.getSelectedItem();

          if (tfNamBD_CTKM.getSelectedItem() != null
              && cbThangBD_CTKM.getSelectedItem() != null
              && cbNgayBD_CTKM.getSelectedItem() != null) {
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiBUS.findAllByCondition(
                fields[0], ngayBatDau)) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }
          if (tfNamBD_CTKM.getSelectedItem() != null) {
            String namBatDau = tfNamBD_CTKM.getSelectedItem() + "%";
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByUseLike(
                fields[0], namBatDau);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
            ExportToExcel.export("chuongtrinhkhuyenmai_theonam", ChuongTrinhKhuyenMaiDTO.class,
                results);
            ReadDataFromExcel.readData("chuongtrinhkhuyenmai_theonam");
          }
          if (cbThangBD_CTKM.getSelectedItem() != null) {
            String thangBatDau = "%" + cbThangBD_CTKM.getSelectedItem() + "%";
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByUseLike(
                fields[0], thangBatDau);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              if (chuongTrinhKhuyenMaiDTO.getNgayBatDau().getMonth() + 1 == Integer.parseInt(
                  cbThangBD_CTKM.getSelectedItem() + "")) {
                Vector row = new Vector();
                row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
                row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
                row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
                row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
                modelCTKM.addRow(row);
              }
            }
          }
          if (cbNgayBD_CTKM.getSelectedItem() != null) {
            String ngayBD = "%" + cbNgayBD_CTKM.getSelectedItem();
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByUseLike(
                fields[0], ngayBD);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }

          //NgayKetThuc
          if (cbNamKT_CTKM.getSelectedItem() != null
              && cbThangKT_CTKM.getSelectedItem() != null
              && cbNgayKT_CTKM.getSelectedItem() != null) {
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiBUS.findAllByCondition(
                fields[1], ngayKetThuc)) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }
          if (cbNamKT_CTKM.getSelectedItem() != null) {
            String namKetThuc = cbNamKT_CTKM.getSelectedItem() + "%";
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByUseLike(
                fields[1], namKetThuc);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }
          if (cbThangKT_CTKM.getSelectedItem() != null) {
            String thangKetThuc = "%" + cbThangKT_CTKM.getSelectedItem() + "%";
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByUseLike(
                fields[1], thangKetThuc);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              if (chuongTrinhKhuyenMaiDTO.getNgayKetThuc().getMonth() + 1 == Integer.parseInt(
                  cbThangKT_CTKM.getSelectedItem()
                      + "")) { //do dùng theo kiểu %data% nên phải lọc thêm để trả ra đúng data
                Vector row = new Vector();
                row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
                row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
                row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
                row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
                modelCTKM.addRow(row);
              }
            }
          }
          if (cbNgayKT_CTKM.getSelectedItem() != null) {
            String ngayKT = "%" + cbNgayKT_CTKM.getSelectedItem();
            List<ChuongTrinhKhuyenMaiDTO> results = chuongTrinhKhuyenMaiBUS.findByUseLike(
                fields[1], ngayKT);
            modelCTKM.setRowCount(0);
            for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO : results) {
              Vector row = new Vector();
              row.add(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
              row.add(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayBatDau());
              row.add(chuongTrinhKhuyenMaiDTO.getNgayKetThuc());
              modelCTKM.addRow(row);
            }
          }

        } catch (Exception ex1) {
          System.out.println("Lỗi ở tìm theo năm: " + ex1.getMessage());
        }

        tableChuongTrinhKM.setModel(modelCTKM);
      }

    });
    pnTTCT_KhuyenMai.add(btnTimKiemCTKM);

    JButton btnCT_CTKM = new JButton("CHI TI\u1EBET");
    btnCT_CTKM.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        FormChiTiet_CTKM chieTiet_CTKM = new FormChiTiet_CTKM();
        chieTiet_CTKM.setVisible(true);
      }
    });

    JScrollPane scrollPaneCTKM = new JScrollPane();
    scrollPaneCTKM.setBounds(10, 223, 647, 260);
//    pnTTCT_KhuyenMai.add(scrollPaneCTKM);
//    scrollPaneCTKM.setViewportView(tableChuongTrinhKM);
    Vector headerCTKM = new Vector<>();
    headerCTKM.add("Mã CT");
    headerCTKM.add("Tên CT");
    headerCTKM.add("Ngày BD");
    headerCTKM.add("Ngày KT");
    if (modelCTKM.getRowCount() == 0) {
      modelCTKM = new DefaultTableModel(headerCTKM, 0);
      readDataCTKM();
    }
    btnCT_CTKM.setBounds(548, 180, 109, 32);
    pnTTCT_KhuyenMai.add(btnCT_CTKM);

    //code logic
    //invisible all panel ThongTin
    pnTT_SanPham.setVisible(false);
    pnTT_NhanVien.setVisible(false);
    pnTT_TaiKhoan.setVisible(false);
    pnTT_NhaCungCap.setVisible(false);
    pnTT_NhaSanXuat.setVisible(false);
    pnTT_ThongKe.setVisible(false);
    pnMoDau.setVisible(true);

    btnSanPham.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(true);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnNhanVien.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(true);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnTaiKhoan.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(true);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnNhaCungCap.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(true);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnNhaSanXuat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(true);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnThongKe.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(true);
        pnTTCT_KhuyenMai.setVisible(false);
      }
    });
    btnCT_KhuyenMai.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        pnTT_SanPham.setVisible(false);
        pnTT_NhanVien.setVisible(false);
        pnTT_TaiKhoan.setVisible(false);
        pnTT_NhaCungCap.setVisible(false);
        pnTT_NhaSanXuat.setVisible(false);
        pnTT_ThongKe.setVisible(false);
        pnTTCT_KhuyenMai.setVisible(true);
        pnMoDau.setVisible(false);
      }
    });
    tableChuongTrinhKM.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = tableChuongTrinhKM.getSelectedRow();
        ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO = new ChuongTrinhKhuyenMaiDTO();
        chuongTrinhKhuyenMaiDTO.setMaChuongTrinh(modelCTKM.getValueAt(i, 0).toString());
        tfMaCT.setText(chuongTrinhKhuyenMaiDTO.getMaChuongTrinh());
        chuongTrinhKhuyenMaiDTO.setTenKhuyenMai(modelCTKM.getValueAt(i, 1).toString());
        tfTenCT.setText(chuongTrinhKhuyenMaiDTO.getTenKhuyenMai());
        chuongTrinhKhuyenMaiDTO.setNgayBatDau(
            java.sql.Date.valueOf(modelCTKM.getValueAt(i, 2).toString()));
        String[] ngayBatDau = chuongTrinhKhuyenMaiDTO.getNgayBatDau().toString().split("-");
        tfNamBD_CTKM.setSelectedItem(ngayBatDau[0]);
        cbThangBD_CTKM.setSelectedItem(ngayBatDau[1]);
        cbNgayBD_CTKM.setSelectedItem(ngayBatDau[2]);
        chuongTrinhKhuyenMaiDTO.setNgayKetThuc(
            java.sql.Date.valueOf(modelCTKM.getValueAt(i, 3).toString()));
        String[] ngayKetThuc = chuongTrinhKhuyenMaiDTO.getNgayKetThuc().toString().split("-");
        cbNamKT_CTKM.setSelectedItem(ngayKetThuc[0]);
        cbThangKT_CTKM.setSelectedItem(ngayKetThuc[1]);
        cbNgayKT_CTKM.setSelectedItem(ngayKetThuc[2]);
      }
    });
    tableChuongTrinhKM.setModel(modelCTKM);

    JButton btnRS = new JButton("");
    btnRS.setIcon(
        new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\imgButton\\refresh.png"));
    btnRS.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readDataCTKM();
        clearCTKM();
      }
    });
    btnRS.setBounds(595, 11, 51, 43);
    pnTTCT_KhuyenMai.add(btnRS);

    tableNhanVien.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = tableNhanVien.getSelectedRow();
        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        nhanVienDTO.setMaNhanVien(modelNV.getValueAt(i, 0).toString());
        tfMaNhanVien.setText(nhanVienDTO.getMaNhanVien());
        nhanVienDTO.setHoNhanVien(modelNV.getValueAt(i, 1).toString());
        tfHoNhanVien.setText(nhanVienDTO.getHoNhanVien());
        nhanVienDTO.setTenNhanVien(modelNV.getValueAt(i, 2).toString());
        tfTenNhanVien.setText(nhanVienDTO.getTenNhanVien());
        nhanVienDTO.setNgayVaoLam(
            java.sql.Date.valueOf(modelNV.getValueAt(i, 3).toString()));
        String[] ngayVaoLam = nhanVienDTO.getNgayVaoLam().toString().split("-");
        cbNamSinh_NV.setSelectedItem(ngayVaoLam[0]);
        cbThangSinh_NV.setSelectedItem(ngayVaoLam[1]);
        cbNgaySinh_NV.setSelectedItem(ngayVaoLam[2]);
        nhanVienDTO.setViTri(modelNV.getValueAt(i, 4).toString());
        cbViTriNhanVien.setSelectedItem(nhanVienDTO.getViTri());
        nhanVienDTO.setLuong(Integer.parseInt(modelNV.getValueAt(i, 5).toString()));
        tfLuongNhanVien.setText(nhanVienDTO.getLuong().toString());
        nhanVienDTO.setSoDienThoai(modelNV.getValueAt(i, 6).toString());
        tfSoDienThoai_NV.setText(nhanVienDTO.getSoDienThoai());
        nhanVienDTO.setEmail(modelNV.getValueAt(i, 7).toString());
        tfEmail_NV.setText(nhanVienDTO.getEmail());
      }
    });

    tableTaiKhoan.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = tableTaiKhoan.getSelectedRow();
        TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
        taiKhoanDTO.setMaTaiKhoan(modelTK.getValueAt(i, 0).toString());
        tfMaTaiKhoan.setText(taiKhoanDTO.getMaTaiKhoan());
        taiKhoanDTO.setTenTaiKhoan(modelTK.getValueAt(i, 1).toString());
        tfTenTaiKhoan.setText(taiKhoanDTO.getTenTaiKhoan());
        taiKhoanDTO.setMatKhau(modelTK.getValueAt(i, 2).toString());
        tfMatKhauTK.setText(taiKhoanDTO.getMatKhau());
        taiKhoanDTO.setPhanQuyen(modelTK.getValueAt(i, 3).toString());
        cbPhanQuyenTK.setSelectedItem(taiKhoanDTO.getPhanQuyen());
        taiKhoanDTO.setMaNV(modelTK.getValueAt(i, 4).toString());
        tfMaNV.setText(taiKhoanDTO.getMaNV());
      }
    });
    tableTaiKhoan.setModel(modelTK);

    JButton btnRS_3 = new JButton("");
    btnRS_3.setIcon(
        new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\DoAn\\imgButton\\refresh.png"));
    btnRS_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        readDataTK();
        clearTk();
      }
    });
    btnRS_3.setBounds(593, 11, 51, 43);
    pnTT_TaiKhoan.add(btnRS_3);
    // click -> thong tin
    tableSanPham.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = tableSanPham.getSelectedRow();
        SanPhamDTO sanPhamDTO = new SanPhamDTO();
        sanPhamDTO.setMaSanPham(modelSP.getValueAt(i, 0).toString());
        tfMaSP.setText(sanPhamDTO.getMaSanPham());
        sanPhamDTO.setTenSanPham(modelSP.getValueAt(i, 1).toString());
        tfTenSP.setText(sanPhamDTO.getTenSanPham());
        sanPhamDTO.setDonGia((modelSP.getValueAt(i, 2).toString()));
        tfDonGia.setText(sanPhamDTO.getDonGia().toString());
        sanPhamDTO.setDonViTinh(modelSP.getValueAt(i, 3).toString());
        tfDonViTinh.setText(sanPhamDTO.getDonViTinh());
        sanPhamDTO.setSoLuong((modelSP.getValueAt(i, 4).toString()));
        tfSoLuong.setText(sanPhamDTO.getSoLuong().toString());
        sanPhamDTO.setMaLoai(modelSP.getValueAt(i, 5).toString());
        cbMaLoai.setSelectedItem(sanPhamDTO.getMaLoai());
        sanPhamDTO.setMaNhaSanXuat(modelSP.getValueAt(i, 6).toString());
        tfMaNhaSanXuat_SP.setText(sanPhamDTO.getMaNhaSanXuat());
      }
    });
    this.setVisible(true);
  }

  public void readDataCTKM() {
    modelCTKM.setRowCount(0);
    for (ChuongTrinhKhuyenMaiDTO chuongTrinhKhuyenMaiDTO1 : chuongTrinhKhuyenMaiBUS.findAll()) {
      Vector row = new Vector();
      row.add(chuongTrinhKhuyenMaiDTO1.getMaChuongTrinh());
      row.add(chuongTrinhKhuyenMaiDTO1.getTenKhuyenMai());
      row.add(chuongTrinhKhuyenMaiDTO1.getNgayBatDau());
      row.add(chuongTrinhKhuyenMaiDTO1.getNgayKetThuc());
      modelCTKM.addRow(row);
    }
    tableChuongTrinhKM.setModel(modelCTKM);
  }

  public void readDataSP() {
    modelSP.setRowCount(0);
    for (SanPhamDTO sanPhamDTO : sanPhamBUS.findAll()) {
      Vector row = new Vector();
      row.add(sanPhamDTO.getMaSanPham());
      row.add(sanPhamDTO.getTenSanPham());
      row.add(sanPhamDTO.getDonGia());
      row.add(sanPhamDTO.getDonViTinh());
      row.add(sanPhamDTO.getSoLuong());
      row.add(sanPhamDTO.getMaLoai());
      row.add(sanPhamDTO.getMaNhaSanXuat());
      modelSP.addRow(row);
    }
    tableSanPham.setModel(modelSP);
  }

  public void readDataTK() {
    modelTK.setRowCount(0);
    for (TaiKhoanDTO taiKhoanDTO : taiKhoanBUS.findAll()) {
      Vector row = new Vector();
      row.add(taiKhoanDTO.getMaTaiKhoan());
      row.add(taiKhoanDTO.getTenTaiKhoan());
      row.add(taiKhoanDTO.getMatKhau());
      row.add(taiKhoanDTO.getPhanQuyen());
      row.add(taiKhoanDTO.getMaNV());
      modelTK.addRow(row);
    }
    tableTaiKhoan.setModel(modelTK);
  }

  public void readDataNV() {
    modelNV.setRowCount(0);
    for (NhanVienDTO nhanVienDTO : nhanVienBUS.findAll()) {
      Vector row = new Vector();
      row.add(nhanVienDTO.getMaNhanVien());
      row.add(nhanVienDTO.getHoNhanVien());
      row.add(nhanVienDTO.getTenNhanVien());
      row.add(nhanVienDTO.getNgayVaoLam());
      row.add(nhanVienDTO.getViTri());
      row.add(nhanVienDTO.getLuong());
      row.add(nhanVienDTO.getSoDienThoai());
      row.add(nhanVienDTO.getEmail());
      modelNV.addRow(row);
    }
    tableNhanVien.setModel(modelNV);
  }

  public void readDataNCC() {
    modelNCC.setRowCount(0);
    for (NhaCungCapDTO nhaCungCapDTO : nhaCungCapBUS.findAll()) {
      Vector row = new Vector();
      row.add(nhaCungCapDTO.getMaNhaCungCap());
      row.add(nhaCungCapDTO.getTenNhaCungCap());
      row.add(nhaCungCapDTO.getSdt());
      row.add(nhaCungCapDTO.getDiaChi());
      row.add(nhaCungCapDTO.getEmail());
      modelNCC.addRow(row);
    }
    tableNhaCungCap.setModel(modelNCC);
  }

  public void readDataNSX() {
    modelNSX.setRowCount(0);
    for (NhaSanXuatDTO nhaSanXuatDTO : nhaSanXuatBUS.findAll()) {
      Vector row = new Vector();
      row.add(nhaSanXuatDTO.getMaNhaSanXuat());
      row.add(nhaSanXuatDTO.getTenNhaSanXuat());
      row.add(nhaSanXuatDTO.getDiaChi());
      row.add(nhaSanXuatDTO.getSoDienThoai());
      modelNSX.addRow(row);
    }
    tableNhaSanXuat.setModel(modelNSX);
  }

  public void clearCTKM() {
    tfMaCT.setText("");
    tfTenCT.setText("");
    cbNgayBD_CTKM.setSelectedIndex(-1);
    cbThangBD_CTKM.setSelectedIndex(-1);
    tfNamBD_CTKM.setSelectedIndex(-1);
    cbNgayKT_CTKM.setSelectedIndex(-1);
    cbThangKT_CTKM.setSelectedIndex(-1);
    cbNamKT_CTKM.setSelectedIndex(-1);
  }

  public void clearNV() {
    tfMaNhanVien.setText("");
    tfHoNhanVien.setText("");
    tfTenNhanVien.setText("");
    cbNgaySinh_NV.setSelectedIndex(0);
    cbThangSinh_NV.setSelectedIndex(0);
    cbNamSinh_NV.setSelectedIndex(0);
    cbViTriNhanVien.setSelectedIndex(0);
    tfLuongNhanVien.setText("");
    tfSoDienThoai_NV.setText("");
    tfEmail_NV.setText("");
  }

  public void clearTk() {
    tfMaTaiKhoan.setText("");
    tfTenTaiKhoan.setText("");
    tfMatKhauTK.setText("");
    cbPhanQuyenTK.setSelectedIndex(-1);
    tfMaNV.setText("");
  }

  public void clearNCC() {
    tfMaNhaCungCap.setText("");
    tfTenNhaCungCap.setText("");
    tfSoDienThoai_NCC.setText("");
    tfDiaChiNhaCungCap.setText("");
    tfEmail_NCC.setText("");

  }

  public void clearNSX() {
    tfMaNhaSanXuat.setText("");
    tfTenNhaSanXuat.setText("");
    tfSoDienThoai_NCC.setText("");
    tfDiaChi_NSX.setText("");
    tfSoDienThoai_NSX.setText("");
  }

  public void clearSP() {
    tfMaSP.setText("");
    tfTenSP.setText("");
    tfDonViTinh.setText("");
    tfDonGia.setText("");
    tfSoLuong.setText("");
    cbMaLoai.setSelectedIndex(-1);
    tfMaNhaSanXuat_SP.setText("");
  }
}