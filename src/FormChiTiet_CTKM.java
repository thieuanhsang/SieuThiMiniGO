import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableStringConverter;

import BUS.ChiTietCTKM_BUS;
import DTO.ChiTietChuongTrinhKhuyenMaiDTO;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.util.Iterator;
import java.util.Vector;

import javax.lang.model.element.NestingKind;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormChiTiet_CTKM extends JFrame {

	private JPanel contentPane;
	private JTextField tfMaKH;
	private JTextField tfMaCT;
	private JTextField tfPtGiam;
	private JTable tableChiTiet_CTKM;
	DefaultTableModel modelChiTiet_CTKM = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormChiTiet_CTKM frame = new FormChiTiet_CTKM();
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
	public FormChiTiet_CTKM() {
		setTitle("CHI TI\u1EBET CTKM");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 625, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblThngTinChi = new JLabel("TH\u00D4NG TIN CHI TI\u1EBET CTKM");
		lblThngTinChi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblThngTinChi.setBounds(172, 11, 262, 24);
		contentPane.add(lblThngTinChi);
		
		JButton btnThemChiTietKM = new JButton("TH\u00CAM");
		btnThemChiTietKM.setBounds(444, 46, 106, 31);
		contentPane.add(btnThemChiTietKM);
		
		JButton btnXoaChiTietKM = new JButton("X\u00D3A");
		
		btnXoaChiTietKM.setBounds(444, 88, 106, 31);
		contentPane.add(btnXoaChiTietKM);
		
		JButton btnSuaChiTietKM = new JButton("S\u1EECA");
		btnSuaChiTietKM.setBounds(444, 130, 106, 31);
		contentPane.add(btnSuaChiTietKM);
		
		tfMaKH = new JTextField();
		tfMaKH.setBounds(172, 106, 222, 31);
		contentPane.add(tfMaKH);
		tfMaKH.setColumns(10);
		
		tfMaCT = new JTextField();
		tfMaCT.setColumns(10);
		tfMaCT.setBounds(172, 46, 222, 31);
		contentPane.add(tfMaCT);
		
		tfPtGiam = new JTextField();
		tfPtGiam.setColumns(10);
		tfPtGiam.setBounds(172, 171, 222, 31);
		contentPane.add(tfPtGiam);
		
		JButton btnSuaChiTietKM_1 = new JButton("THOÁT");
		btnSuaChiTietKM_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSuaChiTietKM_1.setBounds(444, 172, 106, 31);
		contentPane.add(btnSuaChiTietKM_1);
		
		JLabel lblMChngTrnh = new JLabel("M\u00E3 Ch\u01B0\u01A1ng tr\u00ECnh :");
		lblMChngTrnh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblMChngTrnh.setBounds(10, 47, 160, 24);
		contentPane.add(lblMChngTrnh);
		
		JLabel lblMKhchHng = new JLabel("M\u00E3 Kh\u00E1ch H\u00E0ng :");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblMKhchHng.setBounds(10, 114, 160, 24);
		contentPane.add(lblMKhchHng);
		
		JLabel lblGim = new JLabel("Gi\u1EA3m (%) :");
		lblGim.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblGim.setBounds(10, 179, 160, 24);
		contentPane.add(lblGim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 214, 589, 193);
		contentPane.add(scrollPane);
		
		tableChiTiet_CTKM = new JTable();
		tableChiTiet_CTKM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableChiTiet_CTKM.getSelectedRow();
				if(i>=0) {
					tfMaCT.setText(modelChiTiet_CTKM.getValueAt(i, 0).toString());
					tfMaKH.setText(modelChiTiet_CTKM.getValueAt(i, 1).toString());
					Double pTGiamDouble = Double.parseDouble(modelChiTiet_CTKM.getValueAt(i, 2).toString());
					String ptString = pTGiamDouble.toString();
					tfPtGiam.setText(ptString);
				}
			}
		});
		scrollPane.setViewportView(tableChiTiet_CTKM);
		//header
		Vector rowVector = new Vector<>();
		rowVector.add("Mã Chương trình");
		rowVector.add("Mã Khách Hàng");
		rowVector.add("Giảm (%)");
		if(modelChiTiet_CTKM.getRowCount() == 0) {
			modelChiTiet_CTKM = new DefaultTableModel(rowVector,0);
		}
		tableChiTiet_CTKM.setModel(modelChiTiet_CTKM);
		doc_DS_ChiTiet_CTKM();
		btnThemChiTietKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChiTietChuongTrinhKhuyenMaiDTO ctctkm = new ChiTietChuongTrinhKhuyenMaiDTO();
				ctctkm.setMaChuongTrinh(tfMaCT.getText());
				ctctkm.setMaKhachHang(tfMaKH.getText());
				Double pTGiamDouble = Double.parseDouble(tfPtGiam.getText());
				String pTGiamDouble_String = pTGiamDouble.toString();
				ctctkm.setPTGiam(pTGiamDouble_String);
				//them Database
				ChiTietCTKM_BUS bus = new ChiTietCTKM_BUS();
				bus.themChiTiet_CTKM_BUS(ctctkm);
				//them table
				Vector rowVector1 = new Vector<>();
				rowVector1.add(tfMaCT.getText());
				rowVector1.add(tfMaKH.getText());
				rowVector1.add(pTGiamDouble_String);
				modelChiTiet_CTKM.addRow(rowVector1);
				tableChiTiet_CTKM.setModel(modelChiTiet_CTKM);
			}
		});
		btnXoaChiTietKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableChiTiet_CTKM.getSelectedRow();
				if(i>= 0) {
					String MaCT = modelChiTiet_CTKM.getValueAt(i, 0).toString();
					String MaKH = modelChiTiet_CTKM.getValueAt(i, 1).toString();
					ChiTietCTKM_BUS bus = new ChiTietCTKM_BUS();
					bus.xoaChiTiet_CTKM_BUS(MaCT, MaKH);
					modelChiTiet_CTKM.removeRow(i);
				}
			}
		});
		btnSuaChiTietKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Integer i = tableChiTiet_CTKM.getSelectedRow();
			if(i >= 0) {
				String MaCT = tfMaCT.getText();
				String MaKH = tfMaKH.getText();
				Double ptDouble = Double.parseDouble(tfPtGiam.getText());
				String PTGiam = ptDouble.toString();
				ChiTietCTKM_BUS bus = new ChiTietCTKM_BUS();
				bus.suaChiTiet_CTKM_BUS(PTGiam, MaKH, MaCT);
				modelChiTiet_CTKM.setValueAt(PTGiam, i, 2);
				}
			}
		});
	}
	//doc ds ChiTiet_CTKM
	private void doc_DS_ChiTiet_CTKM() {
		// TODO Auto-generated method stub
		ChiTietCTKM_BUS bus = new ChiTietCTKM_BUS();
		bus.doc_ds_ChiTiet_CTKM_BUS();
		for(ChiTietChuongTrinhKhuyenMaiDTO ctctkm : ChiTietCTKM_BUS.ds_ChiTiet_CTKM) {
			Vector rowVector = new Vector<>();
			rowVector.add(ctctkm.getMaChuongTrinh());
			rowVector.add(ctctkm.getMaKhachHang());
			rowVector.add(ctctkm.getPTGiam());
			modelChiTiet_CTKM.addRow(rowVector);
		}
		tableChiTiet_CTKM.setModel(modelChiTiet_CTKM);
	}
}
