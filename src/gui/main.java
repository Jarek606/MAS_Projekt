/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.BoxLayout;

import enums.statusEgzemplarza;
import biblioteka.Klient;
import biblioteka.Ksiazka;
import biblioteka.Osoba;
import biblioteka.OsobaPrywatna;
import biblioteka.Wydawnictwo;
import biblioteka.Wypozyczenie;
import objectplus.ObjectPlus;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jaroslaw Dawidowicz
 *
 */
public class main extends JFrame {

	private JPanel contentPane;
	final static String extension = "extension_gui.bin";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Odczytaj ekstensje ze strumienia
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(extension));
					ObjectPlus.odczytajEkstensje(in);
					in.close();	
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				/*Wydawnictwo wyd = new Wydawnictwo("WQR", "ul. Koralowa 10, 25-500 Warszawa");
				Osoba k = new Osoba("Jan", "Kowalski", 580731254, 123);
				Ksiazka ks = new Ksiazka("Smoki w przestworzach", "Jan Nowak", 123);
				biblioteka.Egzemplarz egz = new biblioteka.Egzemplarz();
				Wypozyczenie w = new Wypozyczenie();
				ks.dodajPowiazanie("wydawnictwo", "ksiazka", wyd);
				ks.dodajPowiazanie("egzemplarz", "ksiazka", egz);
				egz.setStatus(statusEgzemplarza.wypozyczony);
				egz.dodajPowiazanie("wypozyczenie", "egzemplarz", w);
				k.dodajPowiazanie("wypozyczenie", "osoba", w);
				
				wyd = new Wydawnictwo("IBN", "Aleje Jerozolimiskie 123, 77-544 Warszawa");
				egz = new biblioteka.Egzemplarz();
				ks = new Ksiazka("Detektyw Y", "Tomasz Kolwaski", 548);
				k = new Osoba("Tadeusz", "Brzeszyk", 12485785, 153);
				w = new Wypozyczenie();
				ks.dodajPowiazanie("wydawnictwo", "ksiazka", wyd);
				ks.dodajPowiazanie("egzemplarz", "ksiazka", egz);
				egz.dodajPowiazanie("wypozyczenie", "egzemplarz", w);
				k.dodajPowiazanie("wypozyczenie", "osoba", w);
				Calendar c = Calendar.getInstance(); 
				Date dataWypozyczenia = new Date();
				c.setTime(dataWypozyczenia); 
				c.add(Calendar.DATE, 14);
				w.setRzeczywistaDataZwrotu(c.getTime());*/
				
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("System biblioteczny");
		setBounds(100, 100, 450, 88);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,center][grow,center][grow,center]", "[]"));
		
		JButton btnBooks = new JButton("Ksi\u0105\u017Cki");
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click ksi¹¿ki");
				 try {
			          Books ksiazki = new Books();
			          ksiazki.setVisible(true);
			        } catch (Exception e1) {
			          // TODO Auto-generated catch block
			          e1.printStackTrace();
			        }
			}
		});
		contentPane.add(btnBooks, "cell 0 0,growx,aligny center");
		
		JButton btnClient = new JButton("Klient");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clients klienci = new Clients();
				klienci.setVisible(true);
				System.out.println("click klient");
				
			}
		});
		contentPane.add(btnClient, "cell 1 0,growx,aligny center");
		
		JButton btnBorrows = new JButton("Wypo\u017Cyczenia");
		btnBorrows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("click wypo¿yczenia");
				AddBorrow ab = new AddBorrow();
				ab.setVisible(true);
			}
		});
		contentPane.add(btnBorrows, "cell 2 0,growx,aligny center");
		
		addWindowListener(new WindowAdapter() {
		     public void windowClosing(WindowEvent ev) {
		      boolean close = true;
		      if (close) {
		    	  	try {
			  			// Zapisz ekstensje do strumienia
			  			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(extension));
			  			ObjectPlus.zapiszEkstensje(out);
			  			out.close();
			  		} catch (FileNotFoundException e) {
			  			e.printStackTrace();
			  		} catch (IOException e) {
			  			e.printStackTrace();
			  		}
		    	  	dispose();
		    	  	System.exit(0);
		         }
		       }
		});
	}
}
