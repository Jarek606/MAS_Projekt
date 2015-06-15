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
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Jaroslaw Dawidowicz
 *
 */
public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		setTitle("System biblioteczny");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,center][grow,center][grow,center]", "[]"));
		
		JButton btnBooks = new JButton("Ksi\u0105\u017Cki");
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click ksi¹¿ki");
				
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
	}

}
