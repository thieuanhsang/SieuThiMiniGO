import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import BUS.CTHoaDonBUS;
import BUS.ChiTietPhieuNhapHangBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.LoaiBUS;
import BUS.PhieuNhapHangBUS;
import BUS.SanPhamBUS;
import DTO.CTHoaDonDTO;
import DTO.ChiTietPhieuNhapHangDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.LoaiDTO;
import DTO.PhieuNhapHangDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoan;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.security.auth.login.FailedLoginException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.border.CompoundBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class FromChonHang extends JFrame {

	private JPanel contentPane;
	private JPanel pnHoaMyPham,pnBanhKeo,pnDoAnNhanh,pnKem_NGK,pnThucPhamKho;
	private JTable tableThucPhamKho;
	private JTextField txtTimNhanhSP;
	private JTextField txtTongTien;
	private JTable tableHoaDon;
	private JTextField txtMaKH_inHD;
	public static JTextField txtMaNV_inHD;
	private JTextField txtMaHD;
	private JTextField txtTongTien_inHD;
	private final JLabel lblMaKH = new JLabel("Mã Khách Hàng :");
	private JTextField tfTenKH;
	private JTextField tfHoKH;
	private JTextField tfMaKH;
	private JTextField tfSoDienThoaiKH;
	private JTable table_KhachHang;
	static ArrayList<String> maNV_hienhanh = FormDangNhap.maNV_dangdung;
	DefaultTableModel modelKhachHang = new DefaultTableModel();	
	DefaultTableModel modelLoai = new DefaultTableModel();
	DefaultTableModel modelSanPham = new DefaultTableModel();
	DefaultTableModel modelLoaiSP = new DefaultTableModel();
	DefaultTableModel modelSanPhamDaChon = new DefaultTableModel();
	DefaultTableModel modelPNH = new DefaultTableModel();
	DefaultTableModel modelChiTietPNH = new DefaultTableModel();
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel modelGio = new DefaultTableModel();
	DefaultTableModel modelCTHD = new DefaultTableModel();
	DefaultTableModel modelHoaDon = new DefaultTableModel();
	private JTextField tfCMND;
	private JTable table_DS_PNH;
	private JTable table_ChiTietPNH;
	private JTable table_DS_LoaiSP;
	private JTable table_DS_SanPham;
	private JTable table_DS_SanPhamDaChon;
	private JTextField tfMaPNH_moi;
	private JTextField tfMaNV_LapPhieu;
	private JTextField tfNgayLapPhieuMoi;
	private JTextField tfTongTien_SP_DaChon;
	private JTextField tfMaNCC_PNH;
	private JTextField tfMaPhieuNhap_PNH;
	private JTextField tfMaNV_DaTaoPNH;
	private JTextField tfNgayLap_PNH;
	private JTextField tfTongTien_PNH;
	public ArrayList<String> taiKhoans = FormDangNhap.maNV_dangdung;
	private JTextField txtSoLuong;
	private JTextField txtSuaSL;
	private JTextField txtNgayLapHD;
	private JTextField txtMaHD_inCTHD;
	private JTextField txtMaSP_inCTHD;
	private JTextField txtDonGia_inCTHD;
	private JTextField txtSoLuong_inCTHD;
	private JTextField txtThanhTien_inCTHD;
	private JTable tableCTHD;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromChonHang frame = new FromChonHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	double sum = 0;
	Double dongia, soluong, thanhtien, tongtien=0.0;
	private String daKhuyenMai = ".";
	private JTable tableGioHang;
	private JTextField txtTenSP_inCTHD;
	private JTextField txtTimNhanhCTHD;
	private JTextField tfTimKiemNhanh_PNH;
	
	public void clear() {
		tfMaKH.setText("");
		tfHoKH.setText("");
		tfTenKH.setText("");
		tfCMND.setText("");
		tfSoDienThoaiKH.setText("");
	}
	public FromChonHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1080, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Chọn hàng");
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setName("b\u00E0n h\u00E0ng\r\n");
		tabbedPane.setBounds(0, 0, 1064, 599);
		contentPane.add(tabbedPane);
		
		JPanel pnBanHang = new JPanel();
		pnBanHang.setName("B\u00E1n h\u00E0ng");
		tabbedPane.addTab("Bán hàng", null, pnBanHang, null);
		pnBanHang.setLayout(null);
		
		JPanel pnLoaiSP = new JPanel();
		pnLoaiSP.setBackground(new Color(0, 191, 255));
		pnLoaiSP.setBounds(0, 0, 288, 571);
		pnBanHang.add(pnLoaiSP);
		pnLoaiSP.setLayout(null);
		
		JPanel pnChonMon = new JPanel();
		pnChonMon.setVisible(false);
		pnChonMon.setBackground(new Color(255, 105, 180));
		pnChonMon.setBounds(287, 0, 479, 571);
		pnBanHang.add(pnChonMon, "name_126056180043200");
		pnChonMon.setLayout(null);
		
		JLabel lblLoai = new JLabel("THỰC PHẨM KHÔ");
		lblLoai.setForeground(new Color(0, 0, 0));
		lblLoai.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblLoai.setBounds(10, 5, 252, 45);
		pnChonMon.add(lblLoai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 459, 349);
		pnChonMon.add(scrollPane);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(250, 421, 208, 139);
		pnChonMon.add(scrollPane_5);
		
		JTextArea txtArea_ThongTin = new JTextArea();
		txtArea_ThongTin.setEditable(false);
		txtArea_ThongTin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane_5.setViewportView(txtArea_ThongTin);
		
		tableThucPhamKho = new JTable();
		tableThucPhamKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableThucPhamKho.getSelectedRow();
				if (i>=0) {
					txtArea_ThongTin.setText("Mã: "+model.getValueAt(i, 0)+"\nTên: "+model.getValueAt(i, 1)+"\nGiá: "+
				model.getValueAt(i, 2)+"\nĐơn vị tính: "+model.getValueAt(i, 3)+"\nSố lượng còn: "+model.getValueAt(i, 4));
				}
			}
		});
		scrollPane.setViewportView(tableThucPhamKho);
		
		txtTimNhanhSP = new JTextField();
		txtTimNhanhSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTimNhanhSP.setText("");
			}
		});
		txtTimNhanhSP.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanh(txtTimNhanhSP.getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanh(txtTimNhanhSP.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanh(txtTimNhanhSP.getText());
			}
		});
		txtTimNhanhSP.setText("Tìm kiếm sản phẩm ...");
		txtTimNhanhSP.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		txtTimNhanhSP.setBounds(283, 12, 186, 38);
		pnChonMon.add(txtTimNhanhSP);
		txtTimNhanhSP.setColumns(10);
		
		JPanel pnGioHang = new JPanel();
		pnGioHang.setBackground(new Color(30, 144, 255));
		pnGioHang.setBounds(764, 0, 295, 571);
		pnBanHang.add(pnGioHang);
		pnGioHang.setLayout(null);
		
		JButton btnThemGioHang = new JButton("THÊM VÀO GIỎ");
		btnThemGioHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableThucPhamKho.getSelectedRow();
				if(i>=0) {
					if ( Integer.parseInt(txtSoLuong.getText()) <=0 || Integer.parseInt(txtSoLuong.getText()) > Integer.parseInt((String) model.getValueAt(i, 4))) {
						JOptionPane.showMessageDialog(null, "Số lượng không phù hợp!");
					}
					else {
						Vector<Object> rowGio = new Vector<>();
						rowGio.add(model.getValueAt(i, 0));
						rowGio.add(model.getValueAt(i, 1));
						rowGio.add(model.getValueAt(i, 2));
						rowGio.add(txtSoLuong.getText());
						sum = sum + Double.parseDouble( (String) model.getValueAt(i, 2)) * Double.parseDouble(txtSoLuong.getText());
						modelGio.addRow(rowGio);
						tableGioHang.setModel(modelGio);
						txtTongTien.setText(sum+"");
						txtSuaSL.setEditable(true);
						txtSoLuong.setText("");
					}
			}
			}
		});
		btnThemGioHang.setBounds(24, 507, 203, 53);
		btnThemGioHang.setIcon(new ImageIcon("imgButton/thanhtoan.png"));
		pnChonMon.add(btnThemGioHang);
		
		JLabel lblNewLabel_1 = new JLabel("Số lượng :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(24, 441, 88, 24);
		pnChonMon.add(lblNewLabel_1);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 17));
		txtSoLuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSoLuong.setText("");
			}
		});
		txtSoLuong.setBounds(131, 431, 96, 45);
		pnChonMon.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		
		JLabel lblLogoBanHang = new JLabel();
		lblLogoBanHang.setBounds(440, 165, 271, 253);
		pnBanHang.add(lblLogoBanHang);
		lblLogoBanHang.setIcon(new ImageIcon("imgButton/logo.png"));
		
		JLabel lblHinhNen = new JLabel("");
		lblHinhNen.setBounds(0, 0, 1059, 571);
		lblHinhNen.setIcon(new ImageIcon("imgButton/hinhnen.png"));
		pnBanHang.add(lblHinhNen);
		
		JLabel lblGiHng = new JLabel("GIỎ HÀNG");
		lblGiHng.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblGiHng.setBounds(95, 21, 98, 24);
		pnGioHang.add(lblGiHng);
		
		JLabel lblNewLabel = new JLabel("TỔNG TIỀN :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(20, 393, 114, 24);
		pnGioHang.add(lblNewLabel);
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtTongTien.setBounds(144, 393, 141, 25);
		pnGioHang.add(txtTongTien);
		txtTongTien.setColumns(10);
		
		JPanel pnHoaDon = new JPanel();
		tabbedPane.addTab("Hóa đơn", null, pnHoaDon, null);
		pnHoaDon.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 105, 180));
		panel.setBounds(0, 0, 1059, 571);
		pnHoaDon.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 304, 549, 256);
		panel.add(scrollPane_1);
		
		tableHoaDon = new JTable();
		tableHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableHoaDon.getSelectedRow();
				if (i>=0) {
					txtMaHD.setText(modelHoaDon.getValueAt(i, 0)+"");
					txtMaNV_inHD.setText(modelHoaDon.getValueAt(i, 1)+"");
					txtMaKH_inHD.setText(modelHoaDon.getValueAt(i, 2)+"");
					txtNgayLapHD.setText(modelHoaDon.getValueAt(i, 3)+"");
					txtTongTien_inHD.setText(modelHoaDon.getValueAt(i, 4)+"");
					
					BUS.CTHoaDonBUS bus = new BUS.CTHoaDonBUS();
					bus.locHD(txtMaHD.getText());
					
					showKQLoc();
				}
			}
		});
		scrollPane_1.setViewportView(tableHoaDon);
		
		JPanel pnDienThongTin = new JPanel();
		pnDienThongTin.setBackground(new Color(175, 238, 238));
		pnDienThongTin.setBounds(10, 11, 392, 288);
		panel.add(pnDienThongTin);
		pnDienThongTin.setLayout(null);
		
		JLabel lblTongTien = new JLabel("Tổng tiền :");
		lblTongTien.setBounds(10, 242, 93, 24);
		pnDienThongTin.add(lblTongTien);
		lblTongTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNgayLap = new JLabel("Ngày lập :");
		lblNgayLap.setBounds(10, 193, 87, 24);
		pnDienThongTin.add(lblNgayLap);
		lblNgayLap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblMaKhachHang = new JLabel("Mã khách hàng :");
		lblMaKhachHang.setBounds(10, 148, 141, 24);
		pnDienThongTin.add(lblMaKhachHang);
		lblMaKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên :");
		lblMaNhanVien.setBounds(10, 101, 126, 24);
		pnDienThongTin.add(lblMaNhanVien);
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn :");
		lblMaHoaDon.setBounds(10, 54, 114, 24);
		pnDienThongTin.add(lblMaHoaDon);
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(152, 46, 230, 40);
		pnDienThongTin.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		txtMaNV_inHD = new JTextField();
		txtMaNV_inHD.setBounds(152, 97, 133, 34);
		pnDienThongTin.add(txtMaNV_inHD);
		txtMaNV_inHD.setColumns(10);
		
		txtMaKH_inHD = new JTextField();
		txtMaKH_inHD.setText("KH0");
		txtMaKH_inHD.setBounds(152, 142, 133, 36);
		pnDienThongTin.add(txtMaKH_inHD);
		txtMaKH_inHD.setColumns(10);
		
		txtTongTien_inHD = new JTextField();
		txtTongTien_inHD.setEditable(false);
		txtTongTien_inHD.setBounds(152, 236, 230, 41);
		pnDienThongTin.add(txtTongTien_inHD);
		txtTongTien_inHD.setColumns(10);
		
		JLabel lblDienThongTin = new JLabel("ĐIỀN THÔNG TIN HÓA ĐƠN");
		lblDienThongTin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblDienThongTin.setBounds(84, 11, 265, 24);
		pnDienThongTin.add(lblDienThongTin);
		
		JButton btnCheck_KH = new JButton("CHECK");
		btnCheck_KH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HoaDonBUS bus = new HoaDonBUS();
				bus.checkKhachHang(txtMaKH_inHD.getText());
				tongtien = Double.parseDouble(txtTongTien_inHD.getText());
				
				if (daKhuyenMai.equals(txtMaKH_inHD.getText())) {
					JOptionPane.showMessageDialog(null, "Không thể áp dụng khuyễn mãi!");
				}
				else {
					for (DTO.CTCTKhuyenMaiDTO ctctkm : HoaDonBUS.kqCheck) {
						tongtien = tongtien - ((Double.parseDouble(ctctkm.getPTGiam())/100)*tongtien);
					}
					txtTongTien_inHD.setText(tongtien+"");
					JOptionPane.showMessageDialog(null, "Đã áp dụng khuyến mãi");
					daKhuyenMai = txtMaKH_inHD.getText();
				}
			}
		});
		btnCheck_KH.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnCheck_KH.setBounds(295, 142, 87, 36);
		pnDienThongTin.add(btnCheck_KH);
		
		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setEditable(false);
		txtNgayLapHD.setBounds(152, 189, 133, 36);
		pnDienThongTin.add(txtNgayLapHD);
		txtNgayLapHD.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("...");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    java.util.Date date = new java.util.Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = dateFormat.format(date);
				txtNgayLapHD.setText(time);
			}
		});
		btnNewButton_3.setBounds(295, 189, 87, 36);
		pnDienThongTin.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Chọn");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChonNhanVien chonNhanVien = new ChonNhanVien();
				chonNhanVien.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(295, 97, 87, 34);
		pnDienThongTin.add(btnNewButton_5);
		
		JPanel pnButton_ChucNang = new JPanel();
		pnButton_ChucNang.setBackground(new Color(175, 238, 238));
		pnButton_ChucNang.setBounds(401, 11, 158, 288);
		panel.add(pnButton_ChucNang);
		pnButton_ChucNang.setLayout(null);
		
		JButton btnThemHD = new JButton("THÊM");
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HoaDonDTO hd = new HoaDonDTO();
				hd.setMaHD(txtMaHD.getText());
				hd.setMaNV(txtMaNV_inHD.getText());
				hd.setMaKH(txtMaKH_inHD.getText());
				hd.setNgayLap(txtNgayLapHD.getText());
				hd.setTongTien(txtTongTien_inHD.getText());
				
				HoaDonBUS bus = new HoaDonBUS();
				bus.themHD(hd);
				showDSHD();
				
				
				txtMaHD.setText("");
//				txtMaKH_inHD.setText("");
				txtMaNV_inHD.setText("");
				txtNgayLapHD.setText("");
//				txtTongTien_inHD.setText("");
				if (DAO.HoaDonDAO.flag==true) {
					modelCTHD.setRowCount(0);
					for (int i=0; i<modelGio.getRowCount();i++) {
						dongia = Double.parseDouble((String) modelGio.getValueAt(i, 2));
						soluong = Double.parseDouble((String) modelGio.getValueAt(i, 3));
						thanhtien = soluong*dongia;

						Vector<Object> rowCT = new Vector<>();
						rowCT.add(hd.getMaHD());
						rowCT.add(modelGio.getValueAt(i, 0));
						rowCT.add(modelGio.getValueAt(i, 1));
						rowCT.add(modelGio.getValueAt(i, 2));
						rowCT.add(modelGio.getValueAt(i, 3));
						rowCT.add(thanhtien);
						modelCTHD.addRow(rowCT);
					}
					tableCTHD.setModel(modelCTHD);
				}
			}
		});
		btnThemHD.setBounds(21, 11, 127, 39);
		btnThemHD.setIcon(new ImageIcon("imgButton/+.png"));
		pnButton_ChucNang.add(btnThemHD);
		
		JButton btnSuaHD = new JButton("SỬA");
		btnSuaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableHoaDon.getSelectedRow();
				if (i>=0) {
					HoaDonDTO hd = new HoaDonDTO();
					hd.setMaHD(txtMaHD.getText());
					hd.setMaKH(txtMaKH_inHD.getText());
					hd.setMaNV(txtMaNV_inHD.getText());
					hd.setNgayLap(txtNgayLapHD.getText());
					hd.setTongTien(txtTongTien_inHD.getText());
					
					HoaDonBUS bus = new HoaDonBUS();
					bus.sua(hd, i);
					
					showDSHD();
				}
			}
		});
		btnSuaHD.setBounds(21, 99, 127, 39);
		btnSuaHD.setIcon(new ImageIcon("imgButton/sua.png"));
		pnButton_ChucNang.add(btnSuaHD);
		
		JButton btnTimKiemHD = new JButton("TÌM");
		btnTimKiemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cbTimHD = new JComboBox();
				cbTimHD.setModel(new DefaultComboBoxModel<>(new String[] {"Tìm theo mã hóa đơn", "Tìm theo khoảng tiền", "Tìm theo nhân viên hoặc khách hàng"}));
				JOptionPane.showConfirmDialog(null, cbTimHD, "Chọn phương thức cần tìm", JOptionPane.DEFAULT_OPTION);
				
				if (cbTimHD.getSelectedIndex()==0) {
					String ma = (JOptionPane.showInputDialog("Nhập mã hóa đơn cần tìm"));
					HoaDonBUS bus = new HoaDonBUS();
					bus.timTheoMaHD(ma);
					
					modelHoaDon.setRowCount(0);
					for (HoaDonDTO hd : HoaDonBUS.kq) {
						Vector row = new Vector<>();
						row.add(hd.getMaHD());
						row.add(hd.getMaNV());
						row.add(hd.getMaKH());
						row.add(hd.getNgayLap());
						row.add(hd.getTongTien());
						modelHoaDon.addRow(row);
					}
					tableHoaDon.setModel(modelHoaDon);
					
					if (modelHoaDon.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy mã hóa đơn phù hợp!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Tìm thấy "+modelHoaDon.getRowCount()+" mã hóa đơn phù hợp!");
					}
				}
				else if (cbTimHD.getSelectedIndex()==1) {
					String input1 = (JOptionPane.showInputDialog("Nhập khoảng tiền bắt đầu!"));
					String input2 = (JOptionPane.showInputDialog("Nhập khoảng tiền kết thúc"));
					
					HoaDonBUS bus = new HoaDonBUS();
					bus.timTheoKhoangTien(input1, input2);
					
					modelHoaDon.setRowCount(0);
					for (HoaDonDTO hd : HoaDonBUS.kq) {
						Vector row = new Vector<>();
						row.add(hd.getMaHD());
						row.add(hd.getMaNV());
						row.add(hd.getMaKH());
						row.add(hd.getNgayLap());
						row.add(hd.getTongTien());
						modelHoaDon.addRow(row);
					}
					tableHoaDon.setModel(modelHoaDon);
					
					if (modelHoaDon.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy tổng tiền hóa đơn phù hợp!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Tìm thấy "+modelHoaDon.getRowCount()+" tổng tiền hóa đơn phù hợp!");
					}
				}
				else {
					String input1 = (JOptionPane.showInputDialog("Nhập mã nhân viên"));
					String input2 = JOptionPane.showInputDialog("Nhập mã khách hàng");
					
					HoaDonBUS bus = new HoaDonBUS();
					bus.timTheoMaNVorMaKH(input1, input2);
					
					modelHoaDon.setRowCount(0);
					for (HoaDonDTO hd : HoaDonBUS.kq) {
						Vector row = new Vector<>();
						row.add(hd.getMaHD());
						row.add(hd.getMaNV());
						row.add(hd.getMaKH());
						row.add(hd.getNgayLap());
						row.add(hd.getTongTien());
						modelHoaDon.addRow(row);
					}
					tableHoaDon.setModel(modelHoaDon);
					
					if (modelHoaDon.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy tổng tiền hóa đơn phù hợp!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Tìm thấy "+modelHoaDon.getRowCount()+" tổng tiền hóa đơn phù hợp!");
					}
				}
			}
		});
		btnTimKiemHD.setBounds(21, 150, 127, 39);
		btnTimKiemHD.setIcon(new ImageIcon("imgButton/timkiem.png"));
		pnButton_ChucNang.add(btnTimKiemHD);
		
		JButton btnXoaHD = new JButton("XÓA");
		btnXoaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableHoaDon.getSelectedRow();
				if (i>=0) {
					HoaDonBUS bus = new HoaDonBUS();
					bus.xoa(txtMaHD.getText(), i);
					
					showDSHD();
				}
			}
		});
		btnXoaHD.setBounds(21, 55, 127, 39);
		btnXoaHD.setIcon(new ImageIcon("imgButton/-.png"));
		pnButton_ChucNang.add(btnXoaHD);
		
		JButton btnThoatHD = new JButton("THOÁT");
		btnThoatHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnThoatHD.setBounds(21, 238, 127, 39);
		btnThoatHD.setIcon(new ImageIcon("imgButton/thoat.png"));
		pnButton_ChucNang.add(btnThoatHD);
		
		JButton btnNewButton_9 = new JButton("ĐỌC");
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDSHD();
			}
		});
		btnNewButton_9.setBounds(21, 194, 127, 39);
		btnNewButton_9.setIcon(new ImageIcon("imgButton/refresh.png"));
		pnButton_ChucNang.add(btnNewButton_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(569, 11, 480, 293);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hóa đơn :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 79, 91, 18);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mã sản phẩm :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 138, 101, 18);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tên sản phẩm :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 196, 104, 18);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Đơn giá :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(265, 79, 61, 18);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Số Lượng :");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(265, 139, 75, 18);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Thành tiền :");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(265, 196, 82, 18);
		panel_1.add(lblNewLabel_9);
		
		txtMaHD_inCTHD = new JTextField();
		txtMaHD_inCTHD.setEditable(false);
		txtMaHD_inCTHD.setBounds(115, 74, 133, 30);
		panel_1.add(txtMaHD_inCTHD);
		txtMaHD_inCTHD.setColumns(10);
		
		txtMaSP_inCTHD = new JTextField();
		txtMaSP_inCTHD.setEditable(false);
		txtMaSP_inCTHD.setBounds(115, 133, 133, 30);
		panel_1.add(txtMaSP_inCTHD);
		txtMaSP_inCTHD.setColumns(10);
		
		txtDonGia_inCTHD = new JTextField();
		txtDonGia_inCTHD.setEditable(false);
		txtDonGia_inCTHD.setBounds(345, 74, 125, 30);
		panel_1.add(txtDonGia_inCTHD);
		txtDonGia_inCTHD.setColumns(10);
		
		txtSoLuong_inCTHD = new JTextField();
		txtSoLuong_inCTHD.setEditable(false);
		txtSoLuong_inCTHD.setBounds(345, 130, 125, 30);
		panel_1.add(txtSoLuong_inCTHD);
		txtSoLuong_inCTHD.setColumns(10);
		
		txtThanhTien_inCTHD = new JTextField();
		txtThanhTien_inCTHD.setEditable(false);
		txtThanhTien_inCTHD.setBounds(345, 187, 125, 30);
		panel_1.add(txtThanhTien_inCTHD);
		txtThanhTien_inCTHD.setColumns(10);
		
		txtTenSP_inCTHD = new JTextField();
		txtTenSP_inCTHD.setBounds(115, 190, 133, 30);
		panel_1.add(txtTenSP_inCTHD);
		txtTenSP_inCTHD.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_10.setBounds(146, 11, 191, 42);
		panel_1.add(lblNewLabel_10);
		
		JButton btnDocDS_CTHD = new JButton("Đọc DS ");
		btnDocDS_CTHD.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDocDS_CTHD.setBounds(10, 7, 100, 46);
		panel_1.add(btnDocDS_CTHD);
		
		JButton btnXacNhan = new JButton("XÁC NHẬN");
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnXacNhan.setBounds(364, 7, 106, 46);
		panel_1.add(btnXacNhan);
		
		txtTimNhanhCTHD = new JTextField();
		txtTimNhanhCTHD.setBounds(265, 245, 205, 35);
		panel_1.add(txtTimNhanhCTHD);
		txtTimNhanhCTHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTimNhanhCTHD.setText("");
			}
		});
		txtTimNhanhCTHD.setColumns(10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Tìm kiếm chi tiết hóa đơn :");
		lblNewLabel_10_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_10_1.setBounds(12, 250, 241, 24);
		panel_1.add(lblNewLabel_10_1);
		txtTimNhanhCTHD.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanhCTHD(txtTimNhanhCTHD.getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanhCTHD(txtTimNhanhCTHD.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanhCTHD(txtTimNhanhCTHD.getText());
			}
		});
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<modelCTHD.getRowCount();i++) {
					DTO.CTHoaDonDTO cthd = new DTO.CTHoaDonDTO();
					cthd.setMaHoaDon(modelCTHD.getValueAt(i, 0)+"");
					cthd.setMaSanPham(modelCTHD.getValueAt(i, 1)+"");
					cthd.setTenSanPham(modelCTHD.getValueAt(i, 2)+"");
					cthd.setDonGia(modelCTHD.getValueAt(i, 3)+"");
					cthd.setSoLuong(modelCTHD.getValueAt(i, 4)+"");
					cthd.setThanhTien(modelCTHD.getValueAt(i, 5)+"");
					BUS.CTHoaDonBUS bus = new BUS.CTHoaDonBUS();
					bus.themCTHD(cthd);
				}
				JOptionPane.showMessageDialog(null, "Hoàn tất thao tác !!!");
				txtMaHD_inCTHD.setText("");
				txtMaSP_inCTHD.setText("");
				txtTenSP_inCTHD.setText("");
				txtDonGia_inCTHD.setText("");
				txtSoLuong_inCTHD.setText("");
				txtThanhTien_inCTHD.setText("");
			
				String masp;
				Integer soLuongCon;
				SanPhamBUS bussp = new SanPhamBUS();
				bussp.doc_ds_SanPhamBUS();
				for (int i =0; i<modelCTHD.getRowCount();i++) {
					masp = (String) modelCTHD.getValueAt(i, 1);
					for (SanPhamDTO sp : SanPhamBUS.ds_SanPhamBUS) {
						if (sp.getMaSanPham().equals(masp)) {
							soLuongCon = Integer.parseInt(sp.getSoLuong()) - Integer.parseInt((String) modelCTHD.getValueAt(i, 4));
							BUS.CTHoaDonBUS bus = new BUS.CTHoaDonBUS();
							bus.suaSoLuong(masp, soLuongCon);
						}
					}
				}
				modelGio.setRowCount(0);
				tableGioHang.setModel(modelGio);
				txtTongTien.setText("");
				modelCTHD.setRowCount(0);
				
				pnChonMon.setVisible(false);
			}
		});
		btnDocDS_CTHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDSCTHD();
			}
		});
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(569, 304, 480, 256);
		panel.add(scrollPane_3);
		
		tableCTHD = new JTable();
		tableCTHD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableCTHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableCTHD.getSelectedRow();
				if (i>=0) {
					txtMaHD_inCTHD.setText(modelCTHD.getValueAt(i, 0)+"");
					txtMaSP_inCTHD.setText(modelCTHD.getValueAt(i, 1)+"");
					txtTenSP_inCTHD.setText(modelCTHD.getValueAt(i, 2)+"");
					txtDonGia_inCTHD.setText(modelCTHD.getValueAt(i, 3)+"");
					txtSoLuong_inCTHD.setText(modelCTHD.getValueAt(i, 4)+"");
					txtThanhTien_inCTHD.setText(modelCTHD.getValueAt(i, 5)+"");
				}
			}
		});
		scrollPane_3.setViewportView(tableCTHD);
		
		JPanel pnQuanLyKhachHang = new JPanel();
		tabbedPane.addTab("Khách hàng", null, pnQuanLyKhachHang, null);
		pnQuanLyKhachHang.setLayout(null);
		
		JPanel pnDienThongTinKH = new JPanel();
		pnDienThongTinKH.setBackground(new Color(255, 105, 180));
		pnDienThongTinKH.setBounds(0, 0, 534, 571);
		pnQuanLyKhachHang.add(pnDienThongTinKH);
		pnDienThongTinKH.setLayout(null);
		lblMaKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblMaKH.setBounds(26, 88, 192, 30);
		pnDienThongTinKH.add(lblMaKH);
		
		JLabel lblTn = new JLabel("Họ Khách Hàng :");
		lblTn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblTn.setBounds(24, 157, 189, 30);
		pnDienThongTinKH.add(lblTn);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng :");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblTnKhchHng.setBounds(25, 228, 197, 30);
		pnDienThongTinKH.add(lblTnKhchHng);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại :");
		lblSinThoi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblSinThoi.setBounds(25, 364, 155, 30);
		pnDienThongTinKH.add(lblSinThoi);
		
		tfTenKH = new JTextField();
		tfTenKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfTenKH.setBounds(238, 226, 257, 38);
		pnDienThongTinKH.add(tfTenKH);
		tfTenKH.setColumns(10);
		
		tfHoKH = new JTextField();
		tfHoKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfHoKH.setColumns(10);
		tfHoKH.setBounds(237, 157, 257, 38);
		pnDienThongTinKH.add(tfHoKH);
		
		tfMaKH = new JTextField();
		tfMaKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfMaKH.setColumns(10);
		tfMaKH.setBounds(239, 88, 257, 38);
		pnDienThongTinKH.add(tfMaKH);
		
		tfSoDienThoaiKH = new JTextField();
		tfSoDienThoaiKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfSoDienThoaiKH.setColumns(10);
		tfSoDienThoaiKH.setBounds(238, 362, 257, 38);
		pnDienThongTinKH.add(tfSoDienThoaiKH);
		
		JButton btnSuaKH = new JButton("SỬA");
		btnSuaKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSuaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_KhachHang.getSelectedRow();
				if(i>=0) {
					//database
					KhachHangBUS bus = new KhachHangBUS();
					String makh = tfMaKH.getText();
					String ho = tfHoKH.getText();
					String ten = tfTenKH.getText();
					String cccd = tfCMND.getText();
					String sdt = tfSoDienThoaiKH.getText();
					bus.suaKhachHang(makh, ho, ten, cccd,sdt);
					//table
					KhachHangDTO kh = new KhachHangDTO();
					kh.setMaKH(makh);
					kh.setHoKH(ho);
					kh.setTenKH(ten);
					kh.setCCCD(cccd);
					kh.setSDT(sdt);
					modelKhachHang.setValueAt(kh.MaKH, i, 0);
					modelKhachHang.setValueAt(kh.HoKH, i, 1);
					modelKhachHang.setValueAt(kh.TenKH, i, 2);
					modelKhachHang.setValueAt(kh.CCCD, i, 3);
					modelKhachHang.setValueAt(kh.SDT, i, 4);
					clear();
					JOptionPane.showMessageDialog(null, "Sửa thông tin thành công !!!");
				}
			}
		});
		btnSuaKH.setBounds(28, 503, 208, 58);
		btnSuaKH.setIcon(new ImageIcon("imgButton/sua.png"));
		pnDienThongTinKH.add(btnSuaKH);
		
		JButton btnTimKiemKH = new JButton("TÌM KIẾM");
		btnTimKiemKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTimKiemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] luachon = {"Mã","Họ","Tên","SĐT"};
				JComboBox cbLuaChon = new JComboBox<>(luachon);
				JOptionPane.showMessageDialog(null, cbLuaChon,"Lựa chọn phương thức !!!",JOptionPane.QUESTION_MESSAGE);
				if(cbLuaChon.getSelectedItem().equals("Mã")) {
					for(int i=modelKhachHang.getRowCount()-1; i>=0; i--) {
						modelKhachHang.removeRow(i);
					}
					String inputMaString = JOptionPane.showInputDialog(null,"Nhập Mã cần tìm !!!");
					for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
						if(kh.getMaKH().equals(inputMaString)) {
							Vector rowTimkiem = new Vector<>();
							rowTimkiem.add(kh.getMaKH());
							rowTimkiem.add(kh.getHoKH());
							rowTimkiem.add(kh.getTenKH());
							rowTimkiem.add(kh.getCCCD());
							rowTimkiem.add(kh.getSDT());
							modelKhachHang.addRow(rowTimkiem);
							table_KhachHang.setModel(modelKhachHang);
							break;
						}
					}
				}
				if(cbLuaChon.getSelectedItem().equals("Họ")) {
					for(int i=modelKhachHang.getRowCount()-1; i>=0; i--) {
						modelKhachHang.removeRow(i);
					}
					String inputHoString = JOptionPane.showInputDialog(null,"Nhập Họ cần tìm !!!");
					for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
						if(kh.getHoKH().equals(inputHoString)) {
							Vector rowTimkiem = new Vector<>();
							rowTimkiem.add(kh.getMaKH());
							rowTimkiem.add(kh.getHoKH());
							rowTimkiem.add(kh.getTenKH());
							rowTimkiem.add(kh.getCCCD());
							rowTimkiem.add(kh.getSDT());
							modelKhachHang.addRow(rowTimkiem);
							table_KhachHang.setModel(modelKhachHang);
							break;
						}
					}
				}
				if(cbLuaChon.getSelectedItem().equals("Tên")) {
					for(int i=modelKhachHang.getRowCount()-1; i>=0; i--) {
						modelKhachHang.removeRow(i);
					}
					String inputTenString = JOptionPane.showInputDialog(null,"Nhập Tên cần tìm !!!");
					for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
						if(kh.getTenKH().equals(inputTenString)) {
							Vector rowTimkiem = new Vector<>();
							rowTimkiem.add(kh.getMaKH());
							rowTimkiem.add(kh.getHoKH());
							rowTimkiem.add(kh.getTenKH());
							rowTimkiem.add(kh.getCCCD());
							rowTimkiem.add(kh.getSDT());
							modelKhachHang.addRow(rowTimkiem);
							table_KhachHang.setModel(modelKhachHang);
							break;
						}
					}
				}
				if(cbLuaChon.getSelectedItem().equals("SĐT")) {
					for(int i=modelKhachHang.getRowCount()-1; i>=0; i--) {
						modelKhachHang.removeRow(i);
					}
					
					 String inputSDT = JOptionPane.showInputDialog(null,"Nhập SĐT cần tìm !!!");
					 for(KhachHangDTO kh : KhachHangBUS.ds_KhachHang) {
						if(kh.getSDT().equals(inputSDT)) {
							Vector rowTimkiem = new Vector<>();
							rowTimkiem.add(kh.getMaKH());
							rowTimkiem.add(kh.getHoKH());
							rowTimkiem.add(kh.getTenKH());
							rowTimkiem.add(kh.getCCCD());
							rowTimkiem.add(kh.getSDT());
							modelKhachHang.addRow(rowTimkiem);
							table_KhachHang.setModel(modelKhachHang);
							break;
						}
					}
				}
			}
		});
		
		btnTimKiemKH.setBounds(294, 502, 201, 58);
		btnTimKiemKH.setIcon(new ImageIcon("imgButton/timkiem.png"));
		pnDienThongTinKH.add(btnTimKiemKH);
		
		JButton btnThemKH = new JButton("THÊM");
		btnThemKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lay du lieu
				KhachHangDTO kh = new KhachHangDTO();
					kh.setMaKH(tfMaKH.getText());
					kh.setHoKH(tfHoKH.getText());
					kh.setTenKH(tfTenKH.getText());
					kh.setCCCD(tfCMND.getText());
					kh.setSDT(tfSoDienThoaiKH.getText());

				KhachHangBUS bus = new KhachHangBUS();
					bus.themKhachHang(kh);
					
					Vector rowKhachHang = new Vector<>();
					rowKhachHang.add(kh.getMaKH());
					rowKhachHang.add(kh.getHoKH());
					rowKhachHang.add(kh.getTenKH());
					rowKhachHang.add(kh.getCCCD());
					rowKhachHang.add(kh.getSDT());
					modelKhachHang.addRow(rowKhachHang);
					table_KhachHang.setModel(modelKhachHang);
					clear();
					JOptionPane.showMessageDialog(null, "Khách Hàng đã được thêm vào DS !!!");
			}
		});
		btnThemKH.setBounds(28, 423, 208, 58);
		btnThemKH.setIcon(new ImageIcon("imgButton/+.png"));
		pnDienThongTinKH.add(btnThemKH);
		
		JButton btnXoaKH = new JButton("XÓA");
		btnXoaKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHangDTO kh = new KhachHangDTO(); 
				int i = table_KhachHang.getSelectedRow();
				if(i>=0){
					int luachon = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa !!!", "Xóa",JOptionPane.YES_NO_OPTION);
					if(luachon == 0) {
						modelKhachHang.removeRow(i);
						table_KhachHang.setModel(modelKhachHang);
						String makh = tfMaKH.getText();
						KhachHangBUS bus = new KhachHangBUS();
						bus.xoaKhachHang(makh, kh);
						clear();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Khách Hàng cần xóa !!!");
				}
			}
		});
		btnXoaKH.setBounds(294, 422, 201, 58);
		btnXoaKH.setIcon(new ImageIcon("imgButton/-.png"));
		pnDienThongTinKH.add(btnXoaKH);
		
		JLabel lblDienThongTinKhangHang = new JLabel("ĐIỀN THÔNG TIN KHÁCH HÀNG");
		lblDienThongTinKhangHang.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblDienThongTinKhangHang.setBounds(28, 29, 423, 33);
		pnDienThongTinKH.add(lblDienThongTinKhangHang);
		
		tfCMND = new JTextField();
		tfCMND.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		tfCMND.setColumns(10);
		tfCMND.setBounds(238, 295, 257, 38);
		pnDienThongTinKH.add(tfCMND);
		
		JLabel lblCmndcccd = new JLabel("CMND/CCCD :");
		lblCmndcccd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblCmndcccd.setBounds(25, 297, 166, 30);
		pnDienThongTinKH.add(lblCmndcccd);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelKhachHang.setRowCount(0);
				tfMaKH.setText("");
				tfHoKH.setText("");
				tfTenKH.setText("");
				tfCMND.setText("");
				tfCMND.setText("");
				tfSoDienThoaiKH.setText("");
				// do lai du lieu cho table_KhachHang
				ArrayList ds_KhachHangGUI = KhachHangBUS.ds_KhachHang;
				for(KhachHangDTO kh: KhachHangBUS.ds_KhachHang) {
					Vector rowKhachHang = new Vector<>();
					rowKhachHang.add(kh.getMaKH()+"");
					rowKhachHang.add(kh.getHoKH()+"");
					rowKhachHang.add(kh.getTenKH()+"");
					rowKhachHang.add(kh.getCCCD()+"");
					rowKhachHang.add(kh.getSDT()+"");
					modelKhachHang.addRow(rowKhachHang);
				}
				table_KhachHang.setModel(modelKhachHang);
			}
		});
		btnNewButton_4.setBounds(461, 11, 58, 51);
		btnNewButton_4.setIcon(new ImageIcon("imgButton/refresh.png"));
		pnDienThongTinKH.add(btnNewButton_4);
		
		JPanel pnDS_KhachHang = new JPanel();
		pnDS_KhachHang.setBackground(new Color(51, 0, 51));
		pnDS_KhachHang.setBounds(532, 0, 527, 571);
		pnQuanLyKhachHang.add(pnDS_KhachHang);
		pnDS_KhachHang.setLayout(null);
		
		JLabel lblDanhSchKhch = new JLabel("DANH SÁCH KHÁCH HÀNG THÂN THIẾT");
		lblDanhSchKhch.setForeground(new Color(240, 255, 255));
		lblDanhSchKhch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblDanhSchKhch.setBounds(17, 22, 502, 31);
		pnDS_KhachHang.add(lblDanhSchKhch);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 72, 507, 488);
		pnDS_KhachHang.add(scrollPane_2);
		
		//Do du lieu khach hang vao table_KhachHang
		table_KhachHang = new JTable();
		table_KhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table_KhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int i = table_KhachHang.getSelectedRow();
				 KhachHangDTO kh = new KhachHangDTO();
				 kh.setMaKH(modelKhachHang.getValueAt(i, 0).toString());
				 tfMaKH.setText(kh.getMaKH());
				 kh.setHoKH(modelKhachHang.getValueAt(i, 1).toString());
				 tfHoKH.setText(kh.getHoKH());
				 kh.setTenKH(modelKhachHang.getValueAt(i, 2).toString());
				 tfTenKH.setText(kh.getTenKH());
				 kh.setCCCD(modelKhachHang.getValueAt(i, 3).toString());
				 tfCMND.setText(kh.getCCCD());
				 kh.setSDT(modelKhachHang.getValueAt(i, 4).toString());
				 tfSoDienThoaiKH.setText(kh.getSDT()); 
			}
		});
		KhachHangBUS bus = new KhachHangBUS();
		bus.doc_DS_KhachHangBUS();
		Vector headerKhachHang = new Vector<>();
		headerKhachHang.add("Mã KH");
		headerKhachHang.add("Họ KH");
		headerKhachHang.add("Tên KH");
		headerKhachHang.add("CMND/CCCD");
		headerKhachHang.add("SĐT");
		if(modelKhachHang.getRowCount() == 0) {
			modelKhachHang = new DefaultTableModel(headerKhachHang, 0);
		}
		ArrayList ds_KhachHangGUI = KhachHangBUS.ds_KhachHang;
		for(KhachHangDTO kh: KhachHangBUS.ds_KhachHang) {
			Vector rowKhachHang = new Vector<>();
			rowKhachHang.add(kh.getMaKH()+"");
			rowKhachHang.add(kh.getHoKH()+"");
			rowKhachHang.add(kh.getTenKH()+"");
			rowKhachHang.add(kh.getCCCD()+"");
			rowKhachHang.add(kh.getSDT()+"");
			modelKhachHang.addRow(rowKhachHang);
		}
		table_KhachHang.setModel(modelKhachHang);
		scrollPane_2.setViewportView(table_KhachHang);
		
		//Button
		JButton btnHoaMyPham = new JButton("MyPham");
		btnHoaMyPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        lblLoai.setText("HÓA MỸ PHẨM");
		        pnChonMon.setVisible(true);
		        SanPhamBUS bus = new SanPhamBUS();
				bus.timkiemLoaiSP_BUS("L5");
				showSPTheoLoai();
			}
		});
		btnHoaMyPham.setIcon(new ImageIcon("imgButton/hoamypham.png"));
		btnHoaMyPham.setBounds(7, 382, 274, 55);
		pnLoaiSP.add(btnHoaMyPham);
		
		JButton btnDoAnNhanh = new JButton("DoAnNhanh");
		btnDoAnNhanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        lblLoai.setText("ĐỒ ĂN NHANH");
		        pnChonMon.setVisible(true);
		        SanPhamBUS bus = new SanPhamBUS();
				bus.timkiemLoaiSP_BUS("L3");
				showSPTheoLoai();
			}
		});
		btnDoAnNhanh.setBounds(7, 325, 274, 55);
		btnDoAnNhanh.setIcon(new ImageIcon("imgButton/doannhanh.png"));
		pnLoaiSP.add(btnDoAnNhanh);
		
		JButton btnBanhKeo = new JButton("BanhKeo");
		btnBanhKeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLoai.setText("BÁNH KẸO");
				pnChonMon.setVisible(true);
				SanPhamBUS bus = new SanPhamBUS();
				bus.timkiemLoaiSP_BUS("L2");
				showSPTheoLoai();
			}
		});
		btnBanhKeo.setBounds(7, 269, 274, 55);
		btnBanhKeo.setIcon(new ImageIcon("imgButton/banhkeo.png"));
		pnLoaiSP.add(btnBanhKeo);
		
		JButton btnKem_NGK = new JButton("Kem");
		btnKem_NGK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLoai.setText("KEM VÀ NƯỚC GIẢI KHÁT");
				pnChonMon.setVisible(true);
				
				SanPhamBUS bus = new SanPhamBUS();
				bus.timkiemLoaiSP_BUS("L1");
				showSPTheoLoai();
			}
		});
		btnKem_NGK.setBounds(7, 212, 274, 55);
		btnKem_NGK.setIcon(new ImageIcon("imgButton/kem_ngk.png"));
		pnLoaiSP.add(btnKem_NGK);
		
		JButton btnThucPhamKho = new JButton("ThucPham");
		btnThucPhamKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblLoai.setText("THỰC PHẨM KHÔ");
				pnChonMon.setVisible(true);
				
				SanPhamBUS bus = new SanPhamBUS();
				bus.timkiemLoaiSP_BUS("L4");
				showSPTheoLoai();
			}
		});
		btnThucPhamKho.setBounds(7, 155, 274, 55);
		btnThucPhamKho.setIcon(new ImageIcon("imgButton/thucphamkho.png"));
		pnLoaiSP.add(btnThucPhamKho);
		
		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				String [] str = new String[maNV_hienhanh.size()];
				for(int i =0; i<maNV_hienhanh.size(); i++) {
					str[i] = maNV_hienhanh.get(i);
				}
				for(String k: str) {
					txtMaNV_inHD.setText(k+"");
				}
				showDSHD();
				tabbedPane.setSelectedIndex(1);
				Vector<Object> header = new Vector<>();
				header.add("Mã hóa đơn");
				header.add("Mã sản phẩm");
				header.add("Tên SP");
				header.add("Đơn giá");
				header.add("Số lượng");
				header.add("Thành tiền");
				if (modelCTHD.getRowCount()==0) {
					modelCTHD = new DefaultTableModel(header,0);
				}
				modelCTHD.setRowCount(0);
				for (int i=0; i<modelGio.getRowCount();i++) {
					dongia = Double.parseDouble((String) modelGio.getValueAt(i, 2));
					soluong = Double.parseDouble((String) modelGio.getValueAt(i, 3));
					thanhtien = soluong*dongia;
					tongtien+=thanhtien;

					Vector<Object> rowCT = new Vector<>();
					rowCT.add("");
					rowCT.add(modelGio.getValueAt(i, 0));
					rowCT.add(modelGio.getValueAt(i, 1));
					rowCT.add(modelGio.getValueAt(i, 2));
					rowCT.add(modelGio.getValueAt(i, 3));
					rowCT.add(thanhtien);
					modelCTHD.addRow(rowCT);
					
				}
				txtTongTien_inHD.setText(tongtien+"");
				tableCTHD.setModel(modelCTHD);
			}
		});
		btnThanhToan.setBounds(10, 505, 275, 55);
		btnThanhToan.setIcon(new ImageIcon("imgButton/thanhtoan1.png"));
		pnGioHang.add(btnThanhToan);
		
		
		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int luachon = JOptionPane.showConfirmDialog(null, "BẠN MUỐN ĐĂNG XUẤT KHỎI HỆ THỐNG !!!", "ĐĂNG XUẤT", JOptionPane.YES_NO_OPTION);
				System.out.println(luachon);
				if(luachon == 0 ) {
					FormDangNhap dangNhap = new FormDangNhap();
					dangNhap.setVisible(true);
					dispose();
				}
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDangXuat.setIcon(new ImageIcon("imgButton/dangxuat.png"));
		btnDangXuat.setBounds(60, 453, 166, 51);
		pnLoaiSP.add(btnDangXuat);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoat.setIcon(new ImageIcon("imgButton/thoat.png"));
		btnThoat.setBounds(60, 509, 166, 51);
		pnLoaiSP.add(btnThoat);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(135, 206, 250));
		lblLogo.setBounds(60, 0, 198, 154);
		lblLogo.setIcon(new ImageIcon("imgButton/logo1.jpg"));
		pnLoaiSP.add(lblLogo);
	
		JPanel pnPhieuNhapHang = new JPanel();
		tabbedPane.addTab("Phiếu nhập hàng", null, pnPhieuNhapHang, null);
		pnPhieuNhapHang.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.3);
		splitPane.setBounds(0, 0, 1059, 571);
		pnPhieuNhapHang.add(splitPane);
		
		JPanel pnDS_PNH = new JPanel();
		pnDS_PNH.setBackground(new Color(70, 130, 180));
		splitPane.setLeftComponent(pnDS_PNH);
		pnDS_PNH.setLayout(null);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(10, 80, 296, 416);
		pnDS_PNH.add(scrollPane_10);
		
		table_DS_PNH = new JTable();
		table_DS_PNH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane_10.setViewportView(table_DS_PNH);
		
		
		JButton btnTaoPNH = new JButton("Tạo phiếu mới");
		btnTaoPNH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTaoPNH.setBounds(91, 515, 137, 43);
		pnDS_PNH.add(btnTaoPNH);
		
		JLabel lblDS_PNH = new JLabel("DANH SÁCH PHIẾU NHẬP");
		lblDS_PNH.setForeground(SystemColor.desktop);
		lblDS_PNH.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblDS_PNH.setBounds(31, 11, 275, 26);
		pnDS_PNH.add(lblDS_PNH);
		
		JPanel Card_PNH = new JPanel();
		splitPane.setRightComponent(Card_PNH);
		Card_PNH.setLayout(new CardLayout(0, 0));
		
		JPanel pnChiTietPhieu = new JPanel();
		pnChiTietPhieu.setBackground(new Color(135, 206, 250));
		Card_PNH.add(pnChiTietPhieu, "name_166609918518000");
		pnChiTietPhieu.setLayout(null);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(20, 220, 706, 273);
		pnChiTietPhieu.add(scrollPane_11);
		
		table_ChiTietPNH = new JTable();
		table_ChiTietPNH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane_11.setViewportView(table_ChiTietPNH);
		
		JLabel lblMaNV_PNH = new JLabel("Mã Phiếu nhập hàng :");
		lblMaNV_PNH.setForeground(SystemColor.desktop);
		lblMaNV_PNH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblMaNV_PNH.setBounds(10, 59, 236, 30);
		pnChiTietPhieu.add(lblMaNV_PNH);
		
		JLabel lblMaNV_PNH_1 = new JLabel("Mã Nhân viên :");
		lblMaNV_PNH_1.setForeground(SystemColor.desktop);
		lblMaNV_PNH_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblMaNV_PNH_1.setBounds(10, 101, 163, 30);
		pnChiTietPhieu.add(lblMaNV_PNH_1);
		
		JLabel lblMaNV_PNH_1_1 = new JLabel("Ngày lập : ");
		lblMaNV_PNH_1_1.setForeground(SystemColor.desktop);
		lblMaNV_PNH_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblMaNV_PNH_1_1.setBounds(10, 144, 114, 30);
		pnChiTietPhieu.add(lblMaNV_PNH_1_1);
		
		JLabel lblMaNV_PNH_1_2 = new JLabel("Tổng tiền :");
		lblMaNV_PNH_1_2.setForeground(SystemColor.desktop);
		lblMaNV_PNH_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblMaNV_PNH_1_2.setBounds(457, 507, 117, 30);
		pnChiTietPhieu.add(lblMaNV_PNH_1_2);
		
		JLabel lblMaNV_PNH_1_2_1 = new JLabel("Danh sách sản phẩm :");
		lblMaNV_PNH_1_2_1.setForeground(SystemColor.desktop);
		lblMaNV_PNH_1_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblMaNV_PNH_1_2_1.setBounds(10, 179, 236, 30);
		pnChiTietPhieu.add(lblMaNV_PNH_1_2_1);
		
		tfMaPhieuNhap_PNH = new JTextField();
		tfMaPhieuNhap_PNH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		tfMaPhieuNhap_PNH.setEditable(false);
		tfMaPhieuNhap_PNH.setBounds(234, 59, 240, 28);
		pnChiTietPhieu.add(tfMaPhieuNhap_PNH);
		tfMaPhieuNhap_PNH.setColumns(10);
		
		tfMaNV_DaTaoPNH = new JTextField();
		tfMaNV_DaTaoPNH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		tfMaNV_DaTaoPNH.setEditable(false);
		tfMaNV_DaTaoPNH.setColumns(10);
		tfMaNV_DaTaoPNH.setBounds(234, 102, 240, 28);
		pnChiTietPhieu.add(tfMaNV_DaTaoPNH);
		
		tfNgayLap_PNH = new JTextField();
		tfNgayLap_PNH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		tfNgayLap_PNH.setEditable(false);
		tfNgayLap_PNH.setColumns(10);
		tfNgayLap_PNH.setBounds(234, 145, 240, 28);
		pnChiTietPhieu.add(tfNgayLap_PNH);
		
		tfTongTien_PNH = new JTextField();
		tfTongTien_PNH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		tfTongTien_PNH.setEditable(false);
		tfTongTien_PNH.setColumns(10);
		tfTongTien_PNH.setBounds(581, 504, 145, 41);
		pnChiTietPhieu.add(tfTongTien_PNH);
		
		JPanel pnTaoPhieu = new JPanel();
		pnTaoPhieu.setBackground(new Color(70, 130, 180));
		Card_PNH.add(pnTaoPhieu, "name_168885859763500");
		pnTaoPhieu.setLayout(null);
		
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 49, 283, 166);
		pnTaoPhieu.add(scrollPane_7);
		
		table_DS_LoaiSP = new JTable();
		scrollPane_7.setViewportView(table_DS_LoaiSP);
		table_DS_LoaiSP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table_DS_LoaiSP.setModel(modelLoaiSP);
		table_DS_LoaiSP.setModel(modelLoaiSP);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(303, 49, 422, 166);
		pnTaoPhieu.add(scrollPane_8);
		
		table_DS_SanPham = new JTable();
		scrollPane_8.setViewportView(table_DS_SanPham);
		table_DS_SanPham.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(304, 254, 422, 249);
		pnTaoPhieu.add(scrollPane_9);
		
		table_DS_SanPhamDaChon = new JTable();
		scrollPane_9.setViewportView(table_DS_SanPhamDaChon);
		table_DS_SanPhamDaChon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblMPhiuMi_1 = new JLabel("Mã Phiếu mới :");
		lblMPhiuMi_1.setForeground(SystemColor.desktop);
		lblMPhiuMi_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblMPhiuMi_1.setBounds(10, 257, 128, 22);
		pnTaoPhieu.add(lblMPhiuMi_1);
		
		JLabel lblMNv = new JLabel("Mã NV:");
		lblMNv.setForeground(SystemColor.desktop);
		lblMNv.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMNv.setBounds(10, 360, 69, 24);
		pnTaoPhieu.add(lblMNv);
		
		JLabel lblNgy_1 = new JLabel("Ngày lập :");
		lblNgy_1.setForeground(SystemColor.desktop);
		lblNgy_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNgy_1.setBounds(10, 419, 87, 24);
		pnTaoPhieu.add(lblNgy_1);
		
		JButton btnTaoPhieu = new JButton("Tạo phiếu");
		btnTaoPhieu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTaoPhieu.setBounds(133, 515, 126, 44);
		pnTaoPhieu.add(btnTaoPhieu);
		
		tfMaPNH_moi = new JTextField();
		tfMaPNH_moi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tfMaPNH_moi.setBounds(137, 256, 157, 33);
		pnTaoPhieu.add(tfMaPNH_moi);
		tfMaPNH_moi.setColumns(10);
		
		tfMaNV_LapPhieu = new JTextField();
		tfMaNV_LapPhieu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tfMaNV_LapPhieu.setColumns(10);
		tfMaNV_LapPhieu.setBounds(138, 359, 156, 33);
		pnTaoPhieu.add(tfMaNV_LapPhieu);
		
		tfNgayLapPhieuMoi = new JTextField();
		tfNgayLapPhieuMoi.setEditable(false);
		tfNgayLapPhieuMoi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tfNgayLapPhieuMoi.setColumns(10);
		tfNgayLapPhieuMoi.setBounds(137, 417, 157, 33);
		pnTaoPhieu.add(tfNgayLapPhieuMoi);
		
		JLabel lblNgy_1_1 = new JLabel("Tổng tiền :");
		lblNgy_1_1.setForeground(SystemColor.desktop);
		lblNgy_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNgy_1_1.setBounds(10, 472, 93, 24);
		pnTaoPhieu.add(lblNgy_1_1);
		
		tfTongTien_SP_DaChon = new JTextField();
		tfTongTien_SP_DaChon.setEditable(false);
		tfTongTien_SP_DaChon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tfTongTien_SP_DaChon.setText("0.0");
		tfTongTien_SP_DaChon.setColumns(10);
		tfTongTien_SP_DaChon.setBounds(137, 470, 157, 33);
		pnTaoPhieu.add(tfTongTien_SP_DaChon);
		
		JLabel lblMPhiuMi_1_1 = new JLabel("Danh sách Loại");
		lblMPhiuMi_1_1.setForeground(SystemColor.desktop);
		lblMPhiuMi_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMPhiuMi_1_1.setBounds(92, 17, 131, 24);
		pnTaoPhieu.add(lblMPhiuMi_1_1);
		
		JLabel lblMPhiuMi_1_1_1 = new JLabel("Danh sách Sản phẩm");
		lblMPhiuMi_1_1_1.setForeground(SystemColor.desktop);
		lblMPhiuMi_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMPhiuMi_1_1_1.setBounds(435, 17, 177, 24);
		pnTaoPhieu.add(lblMPhiuMi_1_1_1);
		
		JLabel lblMPhiuMi_1_1_1_1 = new JLabel("Danh sách Sản phẩm đã chọn");
		lblMPhiuMi_1_1_1_1.setForeground(SystemColor.desktop);
		lblMPhiuMi_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMPhiuMi_1_1_1_1.setBounds(405, 226, 248, 24);
		pnTaoPhieu.add(lblMPhiuMi_1_1_1_1);
		
		JButton btnXoaSP_DaChon = new JButton("Xóa");
		btnXoaSP_DaChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_DS_SanPhamDaChon.getSelectedRow();
				if(i>=0) {
					Double tongtien = Double.parseDouble(tfTongTien_SP_DaChon.getText());
					Double  thanhtienXoa = Double.parseDouble(modelSanPhamDaChon.getValueAt(i, 6).toString());
					Double tongtienMoi = tongtien - thanhtienXoa;
					tfTongTien_SP_DaChon.setText(tongtienMoi.toString());
					table_DS_SanPhamDaChon.setModel(modelSanPhamDaChon);
					modelSanPhamDaChon.removeRow(i);
				}
			}
		});
		btnXoaSP_DaChon.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoaSP_DaChon.setBounds(336, 516, 126, 43);
		pnTaoPhieu.add(btnXoaSP_DaChon);
		
		JButton btnSuaSLSP_DaChon = new JButton("Sửa");
		btnSuaSLSP_DaChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_DS_SanPhamDaChon.getSelectedRow();
				Double input = Double.parseDouble(JOptionPane.showInputDialog(null,"Nhập số lượng: "));
				Double tongtienCu = Double.parseDouble(tfTongTien_SP_DaChon.getText());
				Double thanhtienCu =  Double.parseDouble(modelSanPhamDaChon.getValueAt(i, 6).toString());
				Double DonGia = Double.parseDouble(modelSanPhamDaChon.getValueAt(i, 2).toString());
				Double thanhtienMoi = input * DonGia;
				Double tongtienMoi = tongtienCu - thanhtienCu + thanhtienMoi;
				
				modelSanPhamDaChon.setValueAt(input.toString(), i, 5);
				modelSanPhamDaChon.setValueAt(thanhtienMoi, i, 6);
				tfTongTien_SP_DaChon.setText(tongtienMoi.toString());
			}
		});
		btnSuaSLSP_DaChon.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSuaSLSP_DaChon.setBounds(549, 516, 126, 43);
		pnTaoPhieu.add(btnSuaSLSP_DaChon);
		
		
		
		btnTaoPNH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnTaoPhieu.setVisible(true);
				pnChiTietPhieu.setVisible(false);
				String [] str = new String[maNV_hienhanh.size()];
				for(int i =0; i<maNV_hienhanh.size(); i++) {
					str[i] = maNV_hienhanh.get(i);
				}
				for(String k: str) {
					tfMaNV_LapPhieu.setText(k+"");
				}
				java.util.Date date = new java.util.Date();
				DateFormat timeDateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String time = timeDateFormat.format(date);
				tfNgayLapPhieuMoi.setText(time);
				int countPNH = 0;
				for(int i = 0; i< table_DS_PNH.getRowCount();i++) {
					countPNH = countPNH + 1;
				}
				countPNH = countPNH + 1;
				tfMaPNH_moi.setText("PNH"+countPNH);
			}
		});
		//set header cho table_DS_PNH
		Vector<String> headerDS_PNH = new Vector<>();
		headerDS_PNH.add("Mã Phiếu nhập");
		headerDS_PNH.add("Mã NCC");
		headerDS_PNH.add("Mã NV");
		headerDS_PNH.add("Ngày lập");
		headerDS_PNH.add("Tổng tiền");
		if(table_DS_PNH.getRowCount() == 0) {
			modelPNH = new DefaultTableModel(headerDS_PNH,0);
		}
		table_DS_PNH.setModel(modelPNH);
		
		tfTimKiemNhanh_PNH = new JTextField();
		tfTimKiemNhanh_PNH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTimKiemNhanh_PNH.setText("");
			}
		});
		tfTimKiemNhanh_PNH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tfTimKiemNhanh_PNH.setBounds(184, 43, 122, 26);
		pnDS_PNH.add(tfTimKiemNhanh_PNH);
		tfTimKiemNhanh_PNH.setColumns(10);
		//tìm kiếm nhanh PNH
		tfTimKiemNhanh_PNH.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimKiemNhanh_PNH(tfTimKiemNhanh_PNH.getText());
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub	
				showKQTimKiemNhanh_PNH(tfTimKiemNhanh_PNH.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub	
				showKQTimKiemNhanh_PNH(tfTimKiemNhanh_PNH.getText());
			}
		});
		
		JLabel lblMPhiuMi_1_2 = new JLabel("Tìm kiếm Phiếu nhập :");
		lblMPhiuMi_1_2.setForeground(Color.BLACK);
		lblMPhiuMi_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblMPhiuMi_1_2.setBounds(10, 43, 175, 21);
		pnDS_PNH.add(lblMPhiuMi_1_2);
		//set header cho table_ChiTietPNH
		Vector<String> headerChiTiet_PNH = new Vector<>();
		headerChiTiet_PNH.add("Mã SP");
		headerChiTiet_PNH.add("Số lượng");
		headerChiTiet_PNH.add("Thành tiền");
		headerChiTiet_PNH.add("ĐVT");
		headerChiTiet_PNH.add("Tên SP");
		if(table_ChiTietPNH.getRowCount() == 0) {
			modelChiTietPNH = new DefaultTableModel(headerChiTiet_PNH,0);
		}
		table_ChiTietPNH.setModel(modelChiTietPNH);
		
		JLabel lblMaNV_PNH_2 = new JLabel("CHI TIẾT PHIẾU NHẬP HÀNG");
		lblMaNV_PNH_2.setForeground(SystemColor.desktop);
		lblMaNV_PNH_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblMaNV_PNH_2.setBounds(134, 11, 310, 26);
		pnChiTietPhieu.add(lblMaNV_PNH_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(517, 11, 219, 198);
		lblNewLabel_2.setIcon(new ImageIcon("imgButton/logo.png"));
		pnChiTietPhieu.add(lblNewLabel_2);
		table_ChiTietPNH.moveColumn(2, 4);
		table_ChiTietPNH.moveColumn(1, 3);
		//set header cho table_DS_LoaiSP
		Vector<String> headerLoaiSP = new Vector<>();
		headerLoaiSP.add("Mã Loại");
		headerLoaiSP.add("Tên Loại");
		if(table_DS_LoaiSP.getRowCount() == 0) {
			modelLoaiSP = new DefaultTableModel(headerLoaiSP,0);
		}
		table_DS_LoaiSP.setModel(modelLoaiSP);
		table_DS_LoaiSP.getColumnModel().getColumn(0).setPreferredWidth(-1);
		// set header cho table_DS_SanPham
		Vector<String> headerSanPham_PNH = new Vector<>();
		headerSanPham_PNH.add("Mã SP");
		headerSanPham_PNH.add("Tên SP");
		headerSanPham_PNH.add("Đơn giá");
		headerSanPham_PNH.add("ĐVT");
		headerSanPham_PNH.add("Mã NSX");
		if(table_DS_SanPham.getRowCount() == 0) {
			modelSanPham= new DefaultTableModel(headerSanPham_PNH,0);
		}
		table_DS_SanPham.setModel(modelSanPham);
		
		//set header cho table_DS_SanPhamDaChon
		Vector<String> headerSanPham_DaChon = new Vector<>();
		headerSanPham_DaChon.add("Mã SP");
		headerSanPham_DaChon.add("Tên SP");
		headerSanPham_DaChon.add("Đơn giá");
		headerSanPham_DaChon.add("ĐVT");
		headerSanPham_DaChon.add("Mã NSX");
		headerSanPham_DaChon.add("Số Lượng");
		headerSanPham_DaChon.add("Thành tiền");
		if(table_DS_SanPham.getRowCount() == 0) {
			modelSanPhamDaChon= new DefaultTableModel(headerSanPham_DaChon,0);
		}
		table_DS_SanPhamDaChon.setModel(modelSanPhamDaChon);
		
		//đổ dữ liệu vào table_DS_PNH
		PhieuNhapHangBUS  pnh_bus = new PhieuNhapHangBUS();
		pnh_bus.doc_DS_PNH_BUS();
		for(PhieuNhapHangDTO pnh : PhieuNhapHangBUS.ds_PNH_BUS) {
			Vector<String> rowPNH = new Vector<>();
			rowPNH.add(pnh.getMaPhieuNhapHang());
			rowPNH.add(pnh.getMaNhaCungCap());
			rowPNH.add(pnh.getMaNhanVien());
			rowPNH.add(pnh.getNgayLap());
			rowPNH.add(pnh.getTongTien());
			modelPNH.addRow(rowPNH);
		}
		
		JLabel lblSuaSL = new JLabel("Số lượng :");
		lblSuaSL.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSuaSL.setBounds(10, 450, 69, 20);
		pnGioHang.add(lblSuaSL);
		
		txtSuaSL = new JTextField();
		txtSuaSL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSuaSL.setText("");
			}
		});
		txtSuaSL.setEditable(false);
		txtSuaSL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSuaSL.setBounds(89, 437, 96, 51);
		pnGioHang.add(txtSuaSL);
		txtSuaSL.setColumns(10);
		
		JButton btnSuaSL = new JButton("sửa");
		btnSuaSL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableGioHang.getSelectedRow();
				sum=0.0;
				if (i>=0) {
					modelGio.setValueAt(txtSuaSL.getText(), i, 3);
					for (int j=0;j<modelGio.getRowCount();j++) {
						sum = sum + Double.parseDouble( (String) modelGio.getValueAt(j, 2)) * Double.parseDouble((String) modelGio.getValueAt(j, 3));
					}
					txtTongTien.setText(sum+"");
				}
				txtSuaSL.setText("");
			}
		});
		btnSuaSL.setBounds(200, 429, 85, 35);
		pnGioHang.add(btnSuaSL);
		
		JButton btnXoaGio = new JButton("xóa");
		btnXoaGio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableGioHang.getSelectedRow();
				sum = 0.0;
				if (i>=0) {
					modelGio.removeRow(i);
					for (int j=0;j<modelGio.getRowCount();j++) {
						sum = sum + Double.parseDouble( (String) modelGio.getValueAt(j, 2)) * Double.parseDouble((String) modelGio.getValueAt(j, 3));
					}
					txtTongTien.setText(sum+"");
					txtSuaSL.setText("");
				}
			}
		});
		btnXoaGio.setBounds(200, 466, 85, 33);
		pnGioHang.add(btnXoaGio);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 62, 275, 320);
		pnGioHang.add(scrollPane_4);
		
		tableGioHang = new JTable();
		tableGioHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableGioHang.getSelectedRow();
				if (i>=0) {
					txtSuaSL.setText(modelGio.getValueAt(i, 3)+"");
				}
			}
		});
		scrollPane_4.setViewportView(tableGioHang);
		Vector<Object> headerGio = new Vector<>();
		headerGio.add("Mã");
		headerGio.add("Tên SP");
		headerGio.add("Đơn giá");
		headerGio.add("Số lượng");
		if (modelGio.getRowCount()==0) {
			modelGio = new DefaultTableModel(headerGio,0);
		}
		tableGioHang.setModel(modelGio);
		// đổ dữ liệu vào table table_DS_LoaiSP GUI
		LoaiBUS loaiBUS = new LoaiBUS();
		loaiBUS.doc_DS_LoaiBUS();
		for(LoaiDTO loai : LoaiBUS.ds_LoaiBUS) {
			Vector<String> rowLoaiSP = new Vector<>();
			rowLoaiSP.add(loai.getMaLoai());
			rowLoaiSP.add(loai.getTenLoai());
			modelLoaiSP.addRow(rowLoaiSP);
		}
		table_DS_LoaiSP.setModel(modelLoaiSP);
		// đổ dữ liệu vào table table_DS_SanPham 
		SanPhamBUS sanPhamBUS = new SanPhamBUS();
		sanPhamBUS.doc_ds_SanPhamBUS();
		ArrayList ds_SanPhamGUI = SanPhamBUS.ds_SanPhamBUS;
		for(SanPhamDTO sp: SanPhamBUS.ds_SanPhamBUS) {
			Vector<String> rowSanPham = new Vector<>();
			rowSanPham.add(sp.getMaSanPham());
			rowSanPham.add(sp.getTenSanPham());
			rowSanPham.add(sp.getDonGia());
			rowSanPham.add(sp.getDonViTinh());
			rowSanPham.add(sp.getMaNhaSanXuat());
			modelSanPham.addRow(rowSanPham);
		}
		table_DS_SanPham.setModel(modelSanPham);
		
		JLabel lblMNcc = new JLabel("Mã NCC :");
		lblMNcc.setForeground(SystemColor.desktop);
		lblMNcc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMNcc.setBounds(10, 307, 89, 24);
		pnTaoPhieu.add(lblMNcc);
		
		tfMaNCC_PNH = new JTextField();
		tfMaNCC_PNH.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tfMaNCC_PNH.setColumns(10);
		tfMaNCC_PNH.setBounds(137, 305, 157, 33);
		pnTaoPhieu.add(tfMaNCC_PNH);
		
		JButton btnQuayLaiCTPNH = new JButton("<=");
		btnQuayLaiCTPNH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnChiTietPhieu.setVisible(true);
				pnTaoPhieu.setVisible(false);
			}
		});
		btnQuayLaiCTPNH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnQuayLaiCTPNH.setBounds(10, 12, 61, 27);
		pnTaoPhieu.add(btnQuayLaiCTPNH);
		table_DS_SanPham.getColumnModel().getColumn(1).setPreferredWidth(400);
		
		//click chọn sản phẩm thuộc loại ?
		table_DS_LoaiSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modelSanPham.setRowCount(0);
				String loai_duocchon = "";
				int i = table_DS_LoaiSP.getSelectedRow();
				if(i >= 0) {
					loai_duocchon = modelLoaiSP.getValueAt(i, 0).toString();
					SanPhamBUS bus = new SanPhamBUS();
					bus.timkiemLoaiSP_BUS(loai_duocchon);
					for(SanPhamDTO sp : SanPhamBUS.ds_SanPhamTheoLoaiBUS) {
						Vector<String> rowSanPhamTheoLoai = new Vector<>();
						rowSanPhamTheoLoai.add(sp.getMaSanPham());
						rowSanPhamTheoLoai.add(sp.getTenSanPham());
						rowSanPhamTheoLoai.add(sp.getDonGia());
						rowSanPhamTheoLoai.add(sp.getDonViTinh());
//						rowSanPhamTheoLoai.add(sp.getSoLuong());
//						rowSanPhamTheoLoai.add(sp.getMaLoai());
						rowSanPhamTheoLoai.add(sp.getMaNhaSanXuat());
						modelSanPham.addRow(rowSanPhamTheoLoai);
					}
				}
				table_DS_SanPham.setModel(modelSanPham);
			}
		});
		//click chọn sản phẩm vào thêm vào danh sách
		table_DS_SanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_DS_SanPham.getSelectedRow();
				String MaSP = modelSanPham.getValueAt(i, 0).toString();
				SanPhamBUS bus = new SanPhamBUS();
				bus.timkiemSanPhamTheoMa_BUS(MaSP);
				for(SanPhamDTO sp : SanPhamBUS.ds_SanPhamTheoMaBUS) {
					Double tongtienDouble = Double.parseDouble(tfTongTien_SP_DaChon.getText());
					Vector<String> rowChon = new Vector<>();
					rowChon.add(sp.getMaSanPham());
					rowChon.add(sp.getTenSanPham());
					rowChon.add(sp.getDonGia());
					rowChon.add(sp.getDonViTinh());
					rowChon.add(sp.getMaNhaSanXuat());
					Double input = Double.parseDouble(JOptionPane.showInputDialog(null,"Nhập số lượng: "));
					sp.setSoLuong(input.toString());
					rowChon.add(sp.getSoLuong());
					Double DonGia = Double.parseDouble(modelSanPham.getValueAt(i, 2).toString());
					Double thanhtien = DonGia * input;
					rowChon.add(thanhtien.toString());
					tongtienDouble = tongtienDouble + thanhtien;
					tfTongTien_SP_DaChon.setText(tongtienDouble.toString());
					modelSanPhamDaChon.addRow(rowChon);
					table_DS_SanPhamDaChon.setModel(modelSanPhamDaChon);
				}
			}
		});
		//click danh sách phiếu nhập hàng đổ dữ liệu ra table_ChiTietPNH
		table_DS_PNH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modelChiTietPNH.setRowCount(0);
				pnTaoPhieu.setVisible(false);
				pnChiTietPhieu.setVisible(true);
				int i = table_DS_PNH.getSelectedRow();
				String MaPNH = "";
				String MaSP = "";
				String MaNV = "";
				String NgayLapPhieu = "";
				String TongTien =""; 
				if(i >=0) {
					MaPNH = modelPNH.getValueAt(i, 0).toString();
					MaNV = modelPNH.getValueAt(i, 2).toString();
					NgayLapPhieu = modelPNH.getValueAt(i, 3).toString();
					TongTien = modelPNH.getValueAt(i, 4).toString();
					tfMaPhieuNhap_PNH.setText(MaPNH);
					tfMaNV_DaTaoPNH.setText(MaNV);
					tfNgayLap_PNH.setText(NgayLapPhieu);
					tfTongTien_PNH.setText(TongTien);
					ChiTietPhieuNhapHangBUS bus_ct = new ChiTietPhieuNhapHangBUS(); 
					bus_ct.timtheoMa_CTPNH_BUS(MaPNH);
				for(ChiTietPhieuNhapHangDTO ct_pnh : ChiTietPhieuNhapHangBUS.ds_CTPNH_timtheoMa_PNH_BUS) {
					Vector<String> rowctpnh_TimKiem = new Vector<>();
						rowctpnh_TimKiem.add(ct_pnh.getMaSanPham());
						rowctpnh_TimKiem.add(ct_pnh.getSoLuong());
						rowctpnh_TimKiem.add(ct_pnh.getThanhTien());
					modelChiTietPNH.addRow(rowctpnh_TimKiem);
				table_ChiTietPNH.setModel(modelChiTietPNH);
					for(int x=0; x <= table_ChiTietPNH.getRowCount()-1;x++) {
						MaSP = modelChiTietPNH.getValueAt(x, 0).toString();
						SanPhamBUS bus = new SanPhamBUS();
						bus.timkiemSanPhamTheoMa_BUS(MaSP);
						for(SanPhamDTO sp : SanPhamBUS.ds_SanPhamTheoMaBUS) {
							modelChiTietPNH.setValueAt(sp.TenSanPham, x, 4);
							modelChiTietPNH.setValueAt(sp.DonViTinh, x, 3);
						}
					}
				}
				table_ChiTietPNH.setModel(modelChiTietPNH);
			}
		}
		});
		btnTaoPhieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhieuNhapHangDTO pnh = new PhieuNhapHangDTO();
				pnh.setMaPhieuNhapHang(tfMaPNH_moi.getText());
				pnh.setMaNhaCungCap(tfMaNCC_PNH.getText());
				pnh.setMaNhanVien(tfMaNV_LapPhieu.getText());
				pnh.setNgayLap(tfNgayLapPhieuMoi.getText());
				pnh.setTongTien(tfTongTien_SP_DaChon.getText());
				//thêm phiếu mới vào table
				Vector<String> rowPNH = new Vector<>();
				rowPNH.add(tfMaPNH_moi.getText());
				rowPNH.add(tfMaNCC_PNH.getText());
				rowPNH.add(tfMaNV_LapPhieu.getText());
				rowPNH.add(tfNgayLapPhieuMoi.getText());
				rowPNH.add(tfTongTien_SP_DaChon.getText());
				modelPNH.addRow(rowPNH);
				table_DS_PNH.setModel(modelPNH);
				//thêm phiếu mới vào csdl
				PhieuNhapHangBUS bus = new PhieuNhapHangBUS();
				bus.them_PNH_BUS(pnh);
				JOptionPane.showMessageDialog(null, "Phiếu "+tfMaPNH_moi.getText()+" đã được tạo bởi nhân viên "+tfMaNV_LapPhieu.getText()+" !!!");
				
				//lưu chi tiết vào csdl
				for(int i = 0 ;i<modelSanPhamDaChon.getRowCount(); i++) {
					ChiTietPhieuNhapHangDTO ctpnh = new ChiTietPhieuNhapHangDTO();
					ctpnh.setMaPhieuNhap(tfMaPNH_moi.getText());
					ctpnh.setMaSanPham(modelSanPhamDaChon.getValueAt(i, 0).toString());
					ctpnh.setSoLuong(modelSanPhamDaChon.getValueAt(i, 5).toString());
					ctpnh.setDonGia(modelSanPhamDaChon.getValueAt(i, 2).toString());
					ctpnh.setThanhTien(modelSanPhamDaChon.getValueAt(i, 6).toString());
					ChiTietPhieuNhapHangBUS bus_ctpnh = new ChiTietPhieuNhapHangBUS();
					bus_ctpnh.them_CTPNH_BUS(ctpnh);
				}
				JOptionPane.showMessageDialog(null, "Đã lưu vào CSDL");
				
				//thay đổi số lượng csdl
				for(int i = 0 ;i<modelSanPhamDaChon.getRowCount(); i++) {
				SanPhamBUS bus_SP = new SanPhamBUS();
				bus_SP.doc_ds_SanPhamBUS();
				for(SanPhamDTO sp : SanPhamBUS.ds_SanPhamBUS) {
					String MaSP_CTPNH = modelSanPhamDaChon.getValueAt(i, 0).toString();
					System.out.println(MaSP_CTPNH);
					if(sp.getMaSanPham().equals(MaSP_CTPNH)) {
						Integer SoLuongTon = Integer.parseInt(sp.getSoLuong());
						Double SoLuongThem_Double = Double.parseDouble(modelSanPhamDaChon.getValueAt(i, 5).toString());
						Integer SoLuongThem = SoLuongThem_Double.intValue();
						Integer SoLuongTong = SoLuongTon + SoLuongThem;
						String SoLuongTong_String = String.valueOf(SoLuongTong);
						SanPhamBUS bus_themSoLuongTon =  new SanPhamBUS();
						bus_themSoLuongTon.themSoLuongTonSP_BUS(MaSP_CTPNH, SoLuongTong_String);
						}
					}
				}
				modelSanPhamDaChon.setRowCount(0);
				
				//tạo mã PNH mới
				int countPNH = 0;
				for(int j = 0; j< table_DS_PNH.getRowCount();j++) {
					countPNH = countPNH + 1;
				}
				countPNH = countPNH + 1;
				tfMaPNH_moi.setText("PNH"+countPNH);
				pnChonMon.setVisible(false);
			}
		});
		showDSHD();
		showDSCTHD();
	}
	private void showSPTheoLoai() {
		model.setRowCount(0);
		tableThucPhamKho.setModel(model);
		try {
			SanPhamBUS bus = new SanPhamBUS();
			if (SanPhamBUS.ds_SanPhamBUS==null) {
				bus.doc_ds_SanPhamBUS();;
			}
			Vector<Object> header = new Vector<>();
			header.add("Mã sản phẩm");
			header.add("Tên sản phẩm");
			header.add("Đơn giá");
			header.add("Đơn vị tính");
			header.add("Số lượng");
			if (model.getRowCount()==0) {
				model = new DefaultTableModel(header,0);
			}
			for (SanPhamDTO sp : SanPhamBUS.ds_SanPhamTheoLoaiBUS) {
				Vector row = new Vector<>();
				row.add(sp.getMaSanPham());
				row.add(sp.getTenSanPham());
				row.add(sp.getDonGia());
				row.add(sp.getDonViTinh());
				row.add(sp.getSoLuong());
				model.addRow(row);
			}
			tableThucPhamKho.setModel(model);
			TableColumnModel setColumnModel = tableThucPhamKho.getColumnModel(); // set width column
			setColumnModel.getColumn(0).setPreferredWidth(8);
			setColumnModel.getColumn(2).setPreferredWidth(1);
			setColumnModel.getColumn(3).setPreferredWidth(1);
			setColumnModel.getColumn(4).setPreferredWidth(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void showDSHD() {
		modelHoaDon.setRowCount(0);
		try {
			HoaDonBUS bus = new HoaDonBUS();
			if (HoaDonBUS.dshd==null) {
				bus.docDSHD();
			}
			Vector header = new Vector<>();
			header.add("Mã hóa đơn");
			header.add("Mã nhân viên");
			header.add("Mã khách hàng");
			header.add("Ngày lập");
			header.add("Tổng tiền");
			if (modelHoaDon.getRowCount()==0) {
				modelHoaDon = new DefaultTableModel(header,0);
			}
			for (HoaDonDTO hd : HoaDonBUS.dshd) {
				Vector rowHD = new Vector<>();
				rowHD.add(hd.getMaHD());
				rowHD.add(hd.getMaNV());
				rowHD.add(hd.getMaKH());
				rowHD.add(hd.getNgayLap());
				rowHD.add(hd.getTongTien());
				modelHoaDon.addRow(rowHD);
			}
			tableHoaDon.setModel(modelHoaDon);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void showDSCTHD() {
		modelCTHD.setRowCount(0);
		try {
			BUS.CTHoaDonBUS bus = new BUS.CTHoaDonBUS();
			bus.docDSCTHD();
			Vector<Object> header = new Vector<>();
			header.add("Mã hóa đơn");
			header.add("Mã sản phẩm");
			header.add("Tên san phẩm");
			header.add("Đơn giá");
			header.add("Số lượng");
			header.add("Thành tiền");
			if (modelCTHD.getRowCount()==0) {
				modelCTHD = new DefaultTableModel(header,0);
			}
			for (DTO.CTHoaDonDTO cthd : BUS.CTHoaDonBUS.dscthd) {
				Vector rowCTHD = new Vector<>();
				rowCTHD.add(cthd.getMaHoaDon());
				rowCTHD.add(cthd.getMaSanPham());
				rowCTHD.add(cthd.getTenSanPham());
				rowCTHD.add(cthd.getDonGia());
				rowCTHD.add(cthd.getSoLuong());
				rowCTHD.add(cthd.getThanhTien());
				modelCTHD.addRow(rowCTHD);
			}
			tableCTHD.setModel(modelCTHD);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void showKQLoc() {
		modelCTHD.setRowCount(0);
		Vector<Object> header = new Vector<>();
		header.add("Mã hóa đơn");
		header.add("Mã sản phẩm");
		header.add("Tên san phẩm");
		header.add("Đơn giá");
		header.add("Số lượng");
		header.add("Thành tiền");
		if (modelCTHD.getRowCount()==0) {
			modelCTHD = new DefaultTableModel(header,0);
		}
		for (DTO.CTHoaDonDTO cthd : BUS.CTHoaDonBUS.kqLoc) {
			Vector rowCTHD = new Vector<>();
			rowCTHD.add(cthd.getMaHoaDon());
			rowCTHD.add(cthd.getMaSanPham());
			rowCTHD.add(cthd.getTenSanPham());
			rowCTHD.add(cthd.getDonGia());
			rowCTHD.add(cthd.getSoLuong());
			rowCTHD.add(cthd.getThanhTien());
			modelCTHD.addRow(rowCTHD);
		}
		tableCTHD.setModel(modelCTHD);
	}
	private void showKQTimNhanh(String input) {
		model.setRowCount(0);
		SanPhamBUS bus = new SanPhamBUS();
		bus.timSPNhanh(input);
		for(SanPhamDTO sp : SanPhamBUS.kqTimNhanh) {
			Vector rowVector = new Vector<>();
			rowVector.add(sp.getMaSanPham());
			rowVector.add(sp.getTenSanPham());
			rowVector.add(sp.getDonGia());
			rowVector.add(sp.getDonViTinh());
			rowVector.add(sp.getSoLuong());
			model.addRow(rowVector);
		}
		tableThucPhamKho.setModel(model);
	}
	private void showKQTimNhanhCTHD(String input) {
		modelCTHD.setRowCount(0);
		CTHoaDonBUS bus = new CTHoaDonBUS();
		bus.timNhanhCTHD(input);
		for(CTHoaDonDTO cthd : CTHoaDonBUS.kqTimNhanhCTHD) {
			Vector rowVector = new Vector<>();
			rowVector.add(cthd.getMaHoaDon());
			rowVector.add(cthd.getMaSanPham());
			rowVector.add(cthd.getTenSanPham());
			rowVector.add(cthd.getDonGia());
			rowVector.add(cthd.getSoLuong());
			rowVector.add(cthd.getThanhTien());
			modelCTHD.addRow(rowVector);
		}
		tableCTHD.setModel(modelCTHD);
	}
	private void showKQTimKiemNhanh_PNH(String input) {
		modelPNH.setRowCount(0);
		PhieuNhapHangBUS bus = new PhieuNhapHangBUS();
		bus.timNhanh_PNH(input);
		for(PhieuNhapHangDTO pnh : PhieuNhapHangBUS.kqTimKiemNhanh_PNH) {
			Vector rowVector = new Vector<>();
			rowVector.add(pnh.getMaPhieuNhapHang());
			rowVector.add(pnh.getMaNhaCungCap());
			rowVector.add(pnh.getMaNhanVien());
			rowVector.add(pnh.getNgayLap());
			rowVector.add(pnh.getTongTien());
			modelPNH.addRow(rowVector);
		}
		table_DS_PNH.setModel(modelPNH);
	}
}
