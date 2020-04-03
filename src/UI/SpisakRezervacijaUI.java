package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import RadSaPodacima.OdlasciPodaci;
import RadSaPodacima.RezervacijaPodaci;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;

public class SpisakRezervacijaUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpisakRezervacijaUI window = new SpisakRezervacijaUI();
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
	public SpisakRezervacijaUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainUI.main(null);
			}
		});
		btnNazad.setBounds(35, 227, 89, 23);
		frame.getContentPane().add(btnNazad);
		
		JComboBox<String> bOdlasci = new JComboBox<String>();
		OdlasciPodaci op = new OdlasciPodaci();
		
		List<String> odlasci = op.ucitajSveOdlaske();
		
		for (String s : odlasci) {
			bOdlasci.addItem(s);
		}
		
		bOdlasci.setBounds(10, 11, 229, 20);
		frame.getContentPane().add(bOdlasci);
		
		JButton btnOdabir = new JButton("Odabir");
		
		btnOdabir.setBounds(274, 10, 89, 23);
		frame.getContentPane().add(btnOdabir);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList<String> list = new JList<String>(dlm);
		list.setBounds(20, 42, 380, 163);
		frame.getContentPane().add(list);
		
		btnOdabir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlm.clear();
				
				RezervacijaPodaci rp = new RezervacijaPodaci();
				List<String> rezervacija = rp.ucitajRezervacijeZaId(bOdlasci.getSelectedItem().toString().split(" ")[0]);
				
				for (String s : rezervacija) {
					dlm.addElement(s);
				}
			}
		});
	}
}
