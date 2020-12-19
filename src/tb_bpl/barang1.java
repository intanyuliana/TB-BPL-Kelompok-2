package tb_bpl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class barang1 {
       
	private JFrame frame; 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					barang1 window = new barang1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public barang1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 240, 245));
		frame.setBounds(0, 0, 1250, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 105, 355, 308);
		panel.setBackground(new Color(255, 240, 245));
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tambah Barang");
		lblNewLabel_1.setBounds(101, 11, 159, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kode Barang");
		lblNewLabel_2.setBounds(10, 44, 91, 31);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nama Barang");
		lblNewLabel_2_1.setBounds(10, 86, 104, 31);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Jumlah");
		lblNewLabel_2_1_1.setBounds(10, 128, 104, 31);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Harga Beli (Rp)");
		lblNewLabel_2_1_2.setBounds(10, 168, 115, 31);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Harga Jual (Rp)");
		lblNewLabel_2_1_3.setBounds(10, 210, 115, 31);
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_2_1_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(153, 51, 174, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(153, 93, 174, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(153, 135, 174, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(153, 175, 174, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(153, 217, 174, 20);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("Tambah");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(113, 262, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(385, 105, 832, 510);
		panel_1.setBackground(new Color(255, 240, 245));
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Detail Barang");
		lblNewLabel_1_1.setBounds(346, 8, 123, 22);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1_3_2_1 = new JLabel("Total Barang");
		lblNewLabel_2_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_3_2_1.setBounds(142, 451, 115, 31);
		panel_1.add(lblNewLabel_2_1_3_2_1);
		
		JLabel lblNewLabel_2_1_3_2_2 = new JLabel("Total Stok");
		lblNewLabel_2_1_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_3_2_2.setBounds(500, 451, 115, 31);
		panel_1.add(lblNewLabel_2_1_3_2_2);
		
		JLabel lblNewLabel_2_1_3_2_3 = new JLabel("");
		lblNewLabel_2_1_3_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_3_2_3.setBounds(244, 451, 79, 31);
		lblNewLabel_2_1_3_2_3.setBorder(new LineBorder(Color.BLACK, 2));
		panel_1.add(lblNewLabel_2_1_3_2_3);
		
		JLabel lblNewLabel_2_1_3_2_3_1 = new JLabel("");
		lblNewLabel_2_1_3_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_3_2_3_1.setBorder(new LineBorder(Color.BLACK, 2));
		lblNewLabel_2_1_3_2_3_1.setBounds(580, 451, 79, 31);
		panel_1.add(lblNewLabel_2_1_3_2_3_1);
		
		JLabel lblNewLabel = new JLabel("Master Barang");
		lblNewLabel.setBounds(435, 0, 329, 85);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 44));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setBounds(20, 432, 355, 183);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Restok Barang");
		lblNewLabel_1_2.setBounds(108, 20, 133, 22);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("Nama Barang");
		lblNewLabel_2_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_3_1.setBounds(10, 53, 115, 31);
		panel_2.add(lblNewLabel_2_1_3_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(153, 58, 174, 20);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_2_1_3_2 = new JLabel("Jumlah Stok");
		lblNewLabel_2_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_3_2.setBounds(10, 95, 115, 31);
		panel_2.add(lblNewLabel_2_1_3_2);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(153, 100, 174, 20);
		panel_2.add(textField_6);
		
		JButton btnRestok = new JButton("Restok");
		btnRestok.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRestok.setBounds(108, 137, 89, 23);
		panel_2.add(btnRestok);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(20, 645, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(127, 645, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Hapus");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(236, 645, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Pencarian");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(343, 645, 116, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}
