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

/**
 * @author Jaroslaw Dawidowicz
 *
 */
public class main extends JFrame {

	private JPanel contentPane;
	final static String extension = "extension.bin";

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
		setBounds(100, 100, 450, 300);
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
				System.out.println("click klient");
			}
		});
		contentPane.add(btnClient, "cell 1 0,growx,aligny center");
		
		JButton btnBorrows = new JButton("Wypo\u017Cyczenia");
		btnBorrows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("click wypo¿yczenia");
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
