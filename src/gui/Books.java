/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javafx.scene.control.TableRow;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import objectplus.ObjectPlus;
import objectplus.ObjectPlusPlus;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Jaroslaw Dawidowicz
 *
 */
public class Books extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Books frame = new Books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Books() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Ksi\u0105\u017Cki");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "flowy,cell 0 0,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Autor", "Ksi\u0105\u017Cka", "Wydawnictwo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for(Object o: ObjectPlus.obiektyEkstensji(biblioteka.Ksiazka.class)){
			model.addRow(new Object[]{((biblioteka.Ksiazka) o).getAutor(), ((biblioteka.Ksiazka) o), (biblioteka.Wydawnictwo)(((biblioteka.Ksiazka) o).dajPowiazanyObiekt("wydawnictwo"))}); 
		}
		ObjectPlusPlus.pokazEkstensje(biblioteka.Ksiazka.class);
		
		JSeparator separator = new JSeparator();
		contentPane.add(separator, "cell 0 1,growx");
		
		JButton btnAdd = new JButton("Dodaj");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook dodajKsiazki = new AddBook();
				dodajKsiazki.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAdd, "flowx,cell 0 2,alignx right,aligny center");
		
		JButton btnZamknij = new JButton("Zamknij");
		btnZamknij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnZamknij, "cell 0 2");
	}

}
