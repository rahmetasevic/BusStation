package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import RadSaPodacima.OdlasciPodaci;
import RadSaPodacima.RezervacijaPodaci;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RezervacijeUI {

	private JFrame frame;
	private JTextField tfIme;
	private JTextField tfPrezime;
	private JTextField tfBrojKarata;
	private JTextField tfDatum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervacijeUI window = new RezervacijeUI();
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
	public RezervacijeUI() {
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
		btnNazad.setBounds(60, 227, 89, 23);
		frame.getContentPane().add(btnNazad);
		
		JComboBox<String> cbOdlasci = new JComboBox<String>();
		
		OdlasciPodaci op = new OdlasciPodaci();
		List<String> odlasci = op.ucitajSveOdlaske();
		
		for (String s : odlasci) {
			cbOdlasci.addItem(s);
		}
		
		cbOdlasci.setBounds(10, 22, 223, 20);
		frame.getContentPane().add(cbOdlasci);
		
		JLabel lblOdlazak = new JLabel("Odlazak");
		lblOdlazak.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblOdlazak);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(10, 53, 46, 14);
		frame.getContentPane().add(lblIme);
		
		tfIme = new JTextField();
		tfIme.setBounds(10, 78, 139, 20);
		frame.getContentPane().add(tfIme);
		tfIme.setColumns(10);
		
		tfPrezime = new JTextField();
		tfPrezime.setBounds(159, 78, 145, 20);
		frame.getContentPane().add(tfPrezime);
		tfPrezime.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(159, 53, 46, 14);
		frame.getContentPane().add(lblPrezime);
		
		JLabel lblBrojKarata = new JLabel("Broj karata");
		lblBrojKarata.setBounds(10, 119, 103, 14);
		frame.getContentPane().add(lblBrojKarata);
		
		tfBrojKarata = new JTextField();
		tfBrojKarata.setBounds(10, 140, 46, 20);
		frame.getContentPane().add(tfBrojKarata);
		tfBrojKarata.setColumns(10);
		
		JLabel lblDatumRezervacije = new JLabel("Datum rezervacije");
		lblDatumRezervacije.setBounds(103, 119, 102, 14);
		frame.getContentPane().add(lblDatumRezervacije);
		
		tfDatum = new JTextField();
		tfDatum.setBounds(101, 140, 86, 20);
		frame.getContentPane().add(tfDatum);
		tfDatum.setColumns(10);
		
		JButton btnSpremi = new JButton("Spremi");
		btnSpremi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tfIme.getText().isEmpty() && !tfPrezime.getText().isEmpty() && !tfBrojKarata.getText().isEmpty() && !tfDatum.getText().isEmpty()) {
					RezervacijaPodaci rp = new RezervacijaPodaci();
					rp.spremiRezervaciju(cbOdlasci.getSelectedItem().toString().split(" ")[0], tfIme.getText(), tfPrezime.getText(), tfBrojKarata.getText(), tfDatum.getText());
					tfIme.setText("");
					tfPrezime.setText("");
					tfBrojKarata.setText("");
					tfDatum.setText("");
					
					JOptionPane.showMessageDialog(null, "Uspješno spremljena rezervacija!");
				}
				else JOptionPane.showMessageDialog(null, "Morate popuniti sva polja prije spremanja!");
			}
		});
		btnSpremi.setBounds(60, 181, 89, 23);
		frame.getContentPane().add(btnSpremi);
	}
}
