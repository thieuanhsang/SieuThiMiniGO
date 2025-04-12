import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.sasl.ScramSha1SaslClient;
import com.mysql.cj.xdevapi.Statement;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoan;
import DTO.TaiKhoanDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.SplashScreen;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tfTaiKhoan,tfMatKhau;
	private JLabel lblTaiKhoan, lblMatKhau,lblNhanVien,lblQuanLy;
	private JButton btnDangNhap, btnQuayLai;
	static ArrayList<TaiKhoan> taikhoan = new ArrayList<TaiKhoan>();
	static ArrayList<String> maNV_dangdung = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDangNhap frame = new FormDangNhap();
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
	public void Visible() {
		lblNhanVien.setVisible(false);
		lblQuanLy.setVisible(false);
		lblTaiKhoan.setVisible(true);
		lblMatKhau.setVisible(true);
		tfTaiKhoan.setVisible(true);
		tfMatKhau.setVisible(true);
		btnDangNhap.setVisible(true);
		btnQuayLai.setVisible(true);
	}
	public FormDangNhap() {
		setTitle("\u0110\u0102NG NH\u1EACP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnChon = new JPanel();
		pnChon.setBackground(new Color(135, 206, 250));
		pnChon.setBounds(0, 0, 434, 473);
		contentPane.add(pnChon);
		pnChon.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(120, 21, 233, 201);
		lblLogo.setIcon(new ImageIcon("imgButton/logo.png"));
		pnChon.add(lblLogo);
		
		tfTaiKhoan = new JTextField();
		tfTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfTaiKhoan.setBounds(43, 272, 332, 40);
		pnChon.add(tfTaiKhoan);
		tfTaiKhoan.setColumns(10);
		tfTaiKhoan.setVisible(false);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfMatKhau.setColumns(10);
		tfMatKhau.setBounds(43, 354, 332, 40);
		pnChon.add(tfMatKhau);
		tfMatKhau.setVisible(false);
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangNhap.setBounds(138, 405, 138, 47);
		pnChon.add(btnDangNhap);
		btnDangNhap.setVisible(false);
		
		JLabel lblTaiKhoan = new JLabel("T\u00E0i kho\u1EA3n :");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTaiKhoan.setBounds(43, 243, 126, 30);
		pnChon.add(lblTaiKhoan);
		lblTaiKhoan.setVisible(false);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt kh\u1EA9u :");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMatKhau.setBounds(43, 323, 126, 30);
		pnChon.add(lblMatKhau);
		lblMatKhau.setVisible(false);
		
		JButton btnQuayLai = new JButton("<-");
		btnQuayLai.setBounds(10, 11, 45, 23);
		btnQuayLai.setVisible(false);
		pnChon.add(btnQuayLai);
		
		JLabel lblDangNhap = new JLabel("");
		lblDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDangNhap.setIcon(new ImageIcon("imgButton/dangnhap1.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDangNhap.setIcon(new ImageIcon("imgButton/dangnhap.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTaiKhoan.setVisible(true);
				lblMatKhau.setVisible(true);
				tfTaiKhoan.setVisible(true);
				tfMatKhau.setVisible(true);
				btnDangNhap.setVisible(true);
				btnQuayLai.setVisible(true);
				lblDangNhap.setVisible(false);
			}
		});
		lblDangNhap.setBounds(102, 295, 307, 86);
		lblDangNhap.setIcon(new ImageIcon("imgButton/dangnhap.png"));
		pnChon.add(lblDangNhap);
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTaiKhoan.setVisible(false);
				lblMatKhau.setVisible(false);
				tfTaiKhoan.setVisible(false);
				tfMatKhau.setVisible(false);
				btnDangNhap.setVisible(false);
				btnQuayLai.setVisible(false);
				lblDangNhap.setVisible(true);
			}
		});
		TaiKhoanBUS bus = new TaiKhoanBUS();
		TaiKhoan tk = new TaiKhoan();
		bus.doc_DS_TaiKhoan();
		ArrayList doc_DS_TaiKhoan = TaiKhoanBUS.ds_TaiKhoan;
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfTaiKhoan.getText().equals("")||tfMatKhau.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP TÀI KHOẢN/MẬT KHẨU");
				}else {
					String tentaikhoan = tfTaiKhoan.getText();
					String matkhau = tfMatKhau.getText();
					for(TaiKhoanDTO tk: TaiKhoanBUS.ds_TaiKhoan) {
						if((tk.getTenTaiKhoan().equals(tentaikhoan))&&(tk.getMatKhau().equals(matkhau))&&tk.getPhanQuyen().equals("user")) {
							JOptionPane.showMessageDialog(null, "Bạn đang đăng nhập với quyền Nhân Viên !!!");
							FromChonHang chonHang = new FromChonHang();
							chonHang.setVisible(true);
							maNV_dangdung.add(tk.getMaNV());
							String [] str = new String[maNV_dangdung.size()];
							for(int i =0; i<maNV_dangdung.size(); i++) {
								str[i] = maNV_dangdung.get(i);
							}
							for(String k: str) {
								System.out.print(k);
							}
						}else if(tk.getTenTaiKhoan().equals(tentaikhoan)&&(tk.getMatKhau().equals(matkhau))&&tk.getPhanQuyen().equals("admin")) {
							JOptionPane.showMessageDialog(null, "Bạn đang đăng nhập với quyền Quản Lý !!!");
							String[] luachondangnhapStrings = {"Chọn","Bán Hàng", "Quản Lý"};
							JComboBox cbLuaChonBox = new JComboBox<>(luachondangnhapStrings);
							JOptionPane.showMessageDialog(null, cbLuaChonBox,"Lựa chọn chức năng", JOptionPane.QUESTION_MESSAGE);
							if(cbLuaChonBox.getSelectedItem().equals("Bán Hàng")) {
								FromChonHang chonHang = new FromChonHang();
								chonHang.setVisible(true);
								dispose();
								maNV_dangdung.add(tk.getMaNV());
								String [] str = new String[maNV_dangdung.size()];
								for(int i =0; i<maNV_dangdung.size(); i++) {
									str[i] = maNV_dangdung.get(i);
								}
								for(String k: str) {
									System.out.print(k);
								}
								dispose();
							}else if(cbLuaChonBox.getSelectedItem().equals("Quản Lý")) {
								FormQuanLy formQuanLy = new FormQuanLy();
								formQuanLy.setVisible(true);
								
								maNV_dangdung.add(tk.getMaNV());
								String [] str = new String[maNV_dangdung.size()];
								for(int i =0; i<maNV_dangdung.size(); i++) {
									str[i] = maNV_dangdung.get(i);
								}
								for(String k: str) {
									System.out.print(k);
								}
								dispose();
							}
						}else if (!tk.getTenTaiKhoan().equals(tentaikhoan)  && !tk.getMatKhau().equals(matkhau)) {
							JOptionPane.showMessageDialog(null, "Tài khoản hoặc Mật khẩu không đúng/không tồn tại !!!");
							FormDangNhap dangNhap = new FormDangNhap();
							dangNhap.setVisible(true);
							JOptionPane.showMessageDialog(null, "Vui lòng thao tác lại !!!");
							break;
						}
					}
					dispose();	
				}
			}
		});
		tfMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnDangNhap.doClick();
				}
			}
		});
		tfTaiKhoan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfMatKhau.requestFocus();
				}
			}
		});
	}
}
