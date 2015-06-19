package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JSeparator;

import java.awt.FlowLayout;

import javax.swing.JButton;

import biblioteka.Egzemplarz;
import biblioteka.Ksiazka;
import biblioteka.Osoba;
import biblioteka.Wydawnictwo;
import biblioteka.Wypozyczenie;
import enums.statusEgzemplarza;
import objectplus.ObjectPlus;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBorrow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBorrow frame = new AddBorrow();
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
	public AddBorrow() {
		setTitle("Dodaj wypo\u017Cyczenie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][grow]"));
		
		JLabel lblDodajWypoyczenie = new JLabel("Dodaj Wypo\u017Cyczenie");
		lblDodajWypoyczenie.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblDodajWypoyczenie, "cell 0 0 2 1,alignx center,growy");
		
		JLabel lblKlient = new JLabel("Klient");
		contentPane.add(lblKlient, "cell 0 1,alignx left");
		
		JComboBox cbClient = new JComboBox();
		contentPane.add(cbClient, "cell 1 1,growx");
		try {
			for(Object o: ObjectPlus.obiektyEkstensji(biblioteka.Osoba.class)){
				cbClient.addItem(o);; 
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblKsika = new JLabel("Ksi\u0105\u017Cka");
		contentPane.add(lblKsika, "cell 0 2,alignx left");
		
		
		JComboBox cbBook = new JComboBox();
		contentPane.add(cbBook, "cell 1 2,growx");
		try {
			for(Object o: ObjectPlus.obiektyEkstensji(biblioteka.Egzemplarz.class)){
				if (((biblioteka.Egzemplarz) o).getStatus() == statusEgzemplarza.dostepny){
					cbBook.addItem(((biblioteka.Egzemplarz) o).dajPowiazanyObiekt("ksiazka"));
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JSeparator separator = new JSeparator();
		contentPane.add(separator, "cell 1 3,growx");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 4,alignx right,aligny top");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnDodaj = new JButton("Dodaj");
		panel.add(btnDodaj);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnAnuluj);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Click dodaj wypo¿yczenie");
				Osoba o = (Osoba)cbClient.getSelectedItem();
				Ksiazka k = (Ksiazka)cbBook.getSelectedItem();
				Egzemplarz e = (Egzemplarz)k.dajDostepnyEgzemplarz();
				Wypozyczenie w = new Wypozyczenie();
				e.setStatus(statusEgzemplarza.wypozyczony);
				e.dodajPowiazanie("wypozyczenie", "egzemplarz", w);
				o.dodajPowiazanie("osoba", "wypozyczenie", w);
				
			}
		});
	}

}
