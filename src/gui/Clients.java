/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import biblioteka.Osoba;
import biblioteka.Wypozyczenie;
import objectplus.ObjectPlus;
import objectplus.ObjectPlusPlus;

import java.awt.Font;

/**
 * @author Jaroslaw Dawidowicz
 *
 */
public class Clients extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clients frame = new Clients();
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
	public Clients() {
		setTitle("Klienci");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][][grow]"));
		
		JLabel lblKlienci = new JLabel("Klienci:");
		lblKlienci.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblKlienci, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Imi\u0119 i nazwisko", "PESEL"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		try {
			for(Object o: ObjectPlus.obiektyEkstensji(biblioteka.Osoba.class)){
				model.addRow(new Object[]{((biblioteka.Osoba) o), ((biblioteka.Osoba) o).getPesel()}); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		JLabel lblWypoyczoneKsiki = new JLabel("Wypo\u017Cyczone ksi\u0105\u017Cki:");
		lblWypoyczoneKsiki.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblWypoyczoneKsiki, "cell 0 2");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 0 3,grow");
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ksi\u0105\u017Cka", "Data wypo\u017Cyczenia", "Data zwrotu"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		DefaultTableModel model2 = (DefaultTableModel) table_1.getModel();
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				for (int i = model2.getRowCount() - 1; i >= 0; i--) {
				    model2.removeRow(i);
				}
				Osoba os = (Osoba) model.getValueAt(table.getSelectedRow() ,0);
				ObjectPlusPlus[] wypozyczenia = null;
				try {
					wypozyczenia = os.dajPowiazania("wypozyczenie");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				for(Object o : wypozyczenia){
					try {
						model2.addRow(new Object[]{((Wypozyczenie) o).dajPowiazanyObiekt("egzemplarz").dajPowiazanyObiekt("ksiazka"), ((Wypozyczenie) o).getDataWypozyczenia(), ((Wypozyczenie) o).getRzeczywistaDataZwrotu()});
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			
			}
		});
	}

}
