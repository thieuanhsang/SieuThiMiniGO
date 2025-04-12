import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.LoaiSanPhamBUS;
import BUS.SanPhamBUS;
import DTO.LoaiSanPhamDTO;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoaiSanPham extends JFrame {

	private JPanel contentPane;
	private JTable tableLoaiSanPham;
	private JTextField tfMaLoai;
	private JTextField tfTenLoai;
	DefaultTableModel modelLoaiSP = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoaiSanPham frame = new LoaiSanPham();
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
	public LoaiSanPham() {
		setTitle("Lo\u1EA1i");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 324, 134);
		contentPane.add(scrollPane);
		
		
		
		tableLoaiSanPham = new JTable();
		tableLoaiSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableLoaiSanPham.getSelectedRow();
				if(i>=0 ) {
					tfMaLoai.setText(modelLoaiSP.getValueAt(i, 0).toString());
					tfTenLoai.setText(modelLoaiSP.getValueAt(i, 1).toString());
				}
			}
		});

		scrollPane.setViewportView(tableLoaiSanPham);
	
		JLabel lblMaLoaiSP = new JLabel("M\u00E3 Lo\u1EA1i :");
		lblMaLoaiSP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaLoaiSP.setBounds(10, 60, 82, 25);
		contentPane.add(lblMaLoaiSP);
		
		JLabel lblTnLoi = new JLabel("T\u00EAn Lo\u1EA1i :");
		lblTnLoi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTnLoi.setBounds(10, 95, 82, 25);
		contentPane.add(lblTnLoi);
		
		tfMaLoai = new JTextField();
		tfMaLoai.setBounds(102, 62, 232, 25);
		contentPane.add(tfMaLoai);
		tfMaLoai.setColumns(10);
		
		tfTenLoai = new JTextField();
		tfTenLoai.setColumns(10);
		tfTenLoai.setBounds(102, 97, 232, 25);
		contentPane.add(tfTenLoai);
		
		JLabel lblThngTinLoi = new JLabel("TH\u00D4NG TIN LO\u1EA0I S\u1EA2N PH\u1EA8M");
		lblThngTinLoi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblThngTinLoi.setBounds(33, 10, 279, 24);
		contentPane.add(lblThngTinLoi);
		//header
		Vector<String> header = new Vector<>();
			header.add("Mã Loại");
			header.add("Tên Loại");
			if(modelLoaiSP.getRowCount() == 0) {
				modelLoaiSP = new DefaultTableModel(header,0);
			}
			tableLoaiSanPham.setModel(modelLoaiSP);
			doc_ds_LoaiSP();
			tableLoaiSanPham.getColumnModel().getColumn(0).setPreferredWidth(-1);
	}

	public void doc_ds_LoaiSP() {
		LoaiSanPhamBUS bus = new LoaiSanPhamBUS();
		bus.doc_DS_LoaiBUS();
		for(LoaiSanPhamDTO loai : LoaiSanPhamBUS.ds_LoaiBUS) {
			Vector rowVector = new Vector();
			rowVector.add(loai.getMaLoai());
			rowVector.add(loai.getTenLoai());
			modelLoaiSP.addRow(rowVector);
		}
		tableLoaiSanPham.setModel(modelLoaiSP);
	}
}
