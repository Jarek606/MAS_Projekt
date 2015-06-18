package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import objectplus.ObjectPlus;
import biblioteka.Wydawnictwo;
import java.awt.Color;

public class AddBook extends JFrame {

	private static final Class Ksiazka = null;
	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JLabel lblIsbn;
	private JTextField txtIsbn;
	private JLabel lblWydawnictwo;
	private JComboBox cbPublisher;
	private JSeparator separator;
	private JButton btnDodaj;
	private JButton btnAnuluj;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setTitle("Dodaj ksi\u0105\u017Ck\u0119");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[90.00][grow]", "[grow][][][][][][grow]"));
		
		JLabel lblDodajKsik = new JLabel("Dodaj Ksi\u0105\u017Ck\u0119");
		lblDodajKsik.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblDodajKsik, "cell 0 0 2 1,alignx center,aligny center");
		
		JLabel lblTytu = new JLabel("Tytu\u0142");
		contentPane.add(lblTytu, "cell 0 1,alignx left");
		
		txtTitle = new JTextField();
		contentPane.add(txtTitle, "cell 1 1,growx");
		txtTitle.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		contentPane.add(lblAutor, "cell 0 2,alignx left");
		
		txtAuthor = new JTextField();
		contentPane.add(txtAuthor, "cell 1 2,growx");
		txtAuthor.setColumns(10);
		
		lblIsbn = new JLabel("ISBN");
		contentPane.add(lblIsbn, "cell 0 3,alignx left");
		
		txtIsbn = new JTextField();
		contentPane.add(txtIsbn, "cell 1 3,growx");
		txtIsbn.setColumns(10);
		
		lblWydawnictwo = new JLabel("Wydawnictwo");
		contentPane.add(lblWydawnictwo, "cell 0 4,alignx left");
		
		cbPublisher = new JComboBox();
		try {
			for(Object o: ObjectPlus.obiektyEkstensji(biblioteka.Wydawnictwo.class)){
				cbPublisher.addItem(o);; 
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(cbPublisher, "cell 1 4,growx");
		
		separator = new JSeparator();
		contentPane.add(separator, "cell 0 5 2 1,growx");
		
		panel = new JPanel();
		contentPane.add(panel, "cell 1 6,alignx right,growy");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean error = false;
				if (txtTitle.getText().isEmpty()){
					txtTitle.setBackground(Color.RED);
					error = true;
				}
				if (txtAuthor.getText().isEmpty()){
					txtTitle.setBackground(Color.RED);
					error = true;
				}
				if (txtIsbn.getText().isEmpty()){
					txtTitle.setBackground(Color.RED);
					error = true;
				}
				if (!error){
					biblioteka.Ksiazka k = new biblioteka.Ksiazka(txtTitle.getText(), txtAuthor.getText(), Integer.parseInt(txtIsbn.getText()));
					k.dodajPowiazanie("ksiazka", "wydawnictwo", (Wydawnictwo)cbPublisher.getSelectedItem());
					System.out.println("Dodano:" + k);
					dispose();
				}
			}
		});
		panel.add(btnDodaj);
		
		btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("AddBook anuluj");
				dispose();
			}
		});
		panel.add(btnAnuluj);
	}

}
