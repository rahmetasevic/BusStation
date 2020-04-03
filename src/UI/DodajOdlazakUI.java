package UI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import RadSaPodacima.MjestaPodaci;
import RadSaPodacima.OdlasciPodaci;
import RadSaPodacima.UsputnePodaci;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajOdlazakUI {

	private JFrame frame;
	private JTextField tfVrijemePolaska;
	private JTextField tfVrijemeDolaska;
	private JTextField tfVrijemeDolaskaKrajnja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajOdlazakUI window = new DodajOdlazakUI();
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
	public DodajOdlazakUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox<String> cbPolazna = new JComboBox<String>();
		cbPolazna.setBounds(10, 25, 163, 20);
		frame.getContentPane().add(cbPolazna);
		
		MjestaPodaci mp = new MjestaPodaci();
		List<String> mjesta = mp.ucitajSvaMjestaZaIspis();
		
		for (String s : mjesta) {
			cbPolazna.addItem(s);
		}
		
		JLabel lblNewLabel = new JLabel("Odabir polazne stanice");
		lblNewLabel.setBounds(10, 11, 117, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tfVrijemePolaska = new JTextField();
		tfVrijemePolaska.setBounds(10, 72, 86, 20);
		frame.getContentPane().add(tfVrijemePolaska);
		tfVrijemePolaska.setColumns(10);
		
		JLabel lblVrijemePolaska = new JLabel("Vrijeme polaska");
		lblVrijemePolaska.setBounds(10, 47, 101, 14);
		frame.getContentPane().add(lblVrijemePolaska);
		
		JComboBox<String> cbKrajnjaStanica = new JComboBox<String>();
		cbKrajnjaStanica.setBounds(10, 103, 163, 20);
		frame.getContentPane().add(cbKrajnjaStanica);
		
		
		for (String s : mjesta) {
			cbKrajnjaStanica.addItem(s);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Krajnja stanica");
		lblNewLabel_1.setBounds(10, 91, 130, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox<String> cbUcestalost = new JComboBox<String>();
		cbUcestalost.setBounds(10, 189, 163, 20);
		frame.getContentPane().add(cbUcestalost);
		
		cbUcestalost.addItem("");
		cbUcestalost.addItem("Svaki dan");
		cbUcestalost.addItem("Radnim danom");
		cbUcestalost.addItem("Samo vikendom");
		
		JLabel lblUestalost = new JLabel("U\u010Destalost");
		lblUestalost.setBounds(10, 164, 117, 14);
		frame.getContentPane().add(lblUestalost);
		
		JLabel lblUsputnaStanica = new JLabel("Usputna stanica");
		lblUsputnaStanica.setBounds(235, 0, 117, 14);
		frame.getContentPane().add(lblUsputnaStanica);
		
		JComboBox<String> cbUsputnaStanica = new JComboBox<String>();
		
		for (String s : mjesta) {
			cbUsputnaStanica.addItem(s);
		}
		
		cbUsputnaStanica.setBounds(235, 25, 130, 20);
		frame.getContentPane().add(cbUsputnaStanica);
		
		JList<String> usputnaLista = new JList<String>();
		DefaultListModel<String> usputnaModel = new DefaultListModel<String>();
		usputnaLista.setModel(usputnaModel);
		usputnaLista.setBounds(235, 101, 189, 190);
		frame.getContentPane().add(usputnaLista);
		
		JLabel lblVrijemeDolaska = new JLabel("Vrijeme dolaska");
		lblVrijemeDolaska.setBounds(234, 56, 101, 14);
		frame.getContentPane().add(lblVrijemeDolaska);
		
		tfVrijemeDolaska = new JTextField();
		tfVrijemeDolaska.setBounds(235, 72, 86, 20);
		frame.getContentPane().add(tfVrijemeDolaska);
		tfVrijemeDolaska.setColumns(10);
		
		JButton bDodajUsputnu = new JButton("Dodaj");
		bDodajUsputnu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tfVrijemeDolaska.getText().isEmpty()) {
					usputnaModel.addElement(cbUsputnaStanica.getSelectedItem().toString() + " " + tfVrijemeDolaska.getText());
				}
				else JOptionPane.showMessageDialog(null, "Za dodavanje usputne stanice potrebno je dodati vrijeme dolaska");
			}
		});
		bDodajUsputnu.setBounds(331, 52, 89, 23);
		frame.getContentPane().add(bDodajUsputnu);
		
		JButton bIzbrisiUsputnu = new JButton("Izbrisi");
		bIzbrisiUsputnu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!usputnaLista.isSelectionEmpty()) {
					usputnaModel.remove(usputnaLista.getSelectedIndex());
				}
				else JOptionPane.showMessageDialog(null, "Morate napraviti selekciju na listi prije uklanjanja sa liste!");
			}
		});
		bIzbrisiUsputnu.setBounds(331, 71, 89, 23);
		frame.getContentPane().add(bIzbrisiUsputnu);
		
		JButton bSpremi = new JButton("Spremi");
		bSpremi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!tfVrijemePolaska.getText().isEmpty() && !tfVrijemeDolaskaKrajnja.getText().isEmpty() && !cbUcestalost.getSelectedItem().toString().equals("")) {
					OdlasciPodaci mp = new OdlasciPodaci();
					
					mp.spremiOdlazak(cbPolazna.getSelectedItem().toString(), tfVrijemePolaska.getText(), cbKrajnjaStanica.getSelectedItem().toString(),
							tfVrijemeDolaskaKrajnja.getText(), cbUcestalost.getSelectedItem().toString());
					
					List<String> usputne = new ArrayList<String>();
					String zadnjiId = mp.ucitajZadnjiId();
					
					for (int i = 0; i < usputnaModel.getSize(); i++) {
						usputne.add(zadnjiId + " " + usputnaModel.get(i));
					}
					
					
					
					UsputnePodaci up = new UsputnePodaci();
					up.spremiUsputne(usputne);
					
					JOptionPane.showMessageDialog(null, "Uspješno spremljeno!");
					
					tfVrijemeDolaska.setText("");
					tfVrijemeDolaskaKrajnja.setText("");
					tfVrijemePolaska.setText("");
					usputnaModel.clear();
				}
			}
		});
		bSpremi.setBounds(10, 241, 89, 23);
		frame.getContentPane().add(bSpremi);
		
		JButton bOtkazi = new JButton("Otkazi");
		bOtkazi.setBounds(10, 275, 89, 23);
		frame.getContentPane().add(bOtkazi);
		
		JButton bNazad = new JButton("Nazad");
		bNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainUI.main(null);
				frame.dispose();
			}
		});
		bNazad.setBounds(115, 241, 89, 50);
		frame.getContentPane().add(bNazad);
		
		JLabel lblVrijemeDolaska_1 = new JLabel("Vrijeme dolaska");
		lblVrijemeDolaska_1.setBounds(10, 124, 117, 14);
		frame.getContentPane().add(lblVrijemeDolaska_1);
		
		tfVrijemeDolaskaKrajnja = new JTextField();
		tfVrijemeDolaskaKrajnja.setBounds(10, 143, 86, 20);
		frame.getContentPane().add(tfVrijemeDolaskaKrajnja);
		tfVrijemeDolaskaKrajnja.setColumns(10);
	}
}
