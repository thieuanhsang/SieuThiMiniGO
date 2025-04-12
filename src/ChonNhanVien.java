

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.CTHoaDonBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import DTO.CTHoaDonDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChonNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimChonNV;
	private JTable tableChonNhanVien;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChonNhanVien frame = new ChonNhanVien();
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
	public ChonNhanVien() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Ch\u1ECDn Nh\u00E2n Vi\u00EAn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(198, 10, 175, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		txtTimChonNV = new JTextField();
		txtTimChonNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTimChonNV.setText("");
			}
		});
		txtTimChonNV.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanhNV(txtTimChonNV.getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanhNV(txtTimChonNV.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				showKQTimNhanhNV(txtTimChonNV.getText());
			}
		});
		txtTimChonNV.setBounds(430, 19, 165, 27);
		contentPane.add(txtTimChonNV);
		txtTimChonNV.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 585, 238);
		contentPane.add(scrollPane);
		
		tableChonNhanVien = new JTable();
		scrollPane.setViewportView(tableChonNhanVien);
		
		JButton btnNewButton_1 = new JButton("Ch\u1ECDn");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableChonNhanVien.getSelectedRow();
				if (i>=0) {
					FromChonHang.txtMaNV_inHD.setText((String) model.getValueAt(i, 0));
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Hãy chọn 1 nhân viên");
				}
			}
		});
		btnNewButton_1.setBounds(264, 366, 85, 21);
		contentPane.add(btnNewButton_1);
		docDSNV();
	}
	public void docDSNV() {
		model.setRowCount(0);
		try {
			NhanVienBUS bus = new NhanVienBUS();
			if (NhanVienBUS.dsNhanVien==null) {
				bus.doc_DSNV();
			}
			Vector headerNV = new Vector<>();
		    headerNV.add("Mã NV");
		    headerNV.add("Họ");
		    headerNV.add("Tên");
		    headerNV.add("Số điện thoại");
		    headerNV.add("Email");
			if (model.getRowCount()==0) {
				model = new DefaultTableModel(headerNV,0);
			}
			for (NhanVienDTO nv : NhanVienBUS.dsNhanVien) {
				Vector<Object> row = new Vector<>();
				row.add(nv.getMaNhanVien());
				row.add(nv.getHoNhanVien());
				row.add(nv.getTenNhanVien());
				row.add(nv.getSoDienThoai());
				row.add(nv.getEmail());
				model.addRow(row);
			}
			tableChonNhanVien.setModel(model);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void showKQTimNhanhNV(String input) {
		model.setRowCount(0);
		NhanVienBUS bus = new NhanVienBUS();
		bus.timNhanhNV(input);
		for(NhanVienDTO nv : NhanVienBUS.kqTimNhanhNV) {
			Vector<Object> row = new Vector<>();
			row.add(nv.getMaNhanVien());
			row.add(nv.getHoNhanVien());
			row.add(nv.getTenNhanVien());
			row.add(nv.getSoDienThoai());
			row.add(nv.getEmail());
			model.addRow(row);
		}
		tableChonNhanVien.setModel(model);
	}
}
