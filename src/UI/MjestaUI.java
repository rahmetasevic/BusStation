package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import RadSaPodacima.MjestaPodaci;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MjestaUI {

	private JFrame frame;
	private JTextField tfDodajMjesto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MjestaUI window = new MjestaUI();
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
	public MjestaUI() {
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
		
		JComboBox<String> cbMjesta = new JComboBox<String>();
		MjestaPodaci mp = new MjestaPodaci();
		List<String> lista = mp.ucitajSvaMjestaZaIspis();

		for (String s : lista) {
			cbMjesta.addItem(s);
		}
		
		cbMjesta.setBounds(10, 23, 159, 20);
		frame.getContentPane().add(cbMjesta);
		
		JButton bIzbrisi = new JButton("Izbrisi");
		bIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mp.izbrisiMjesto(cbMjesta.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Mjesto uspjesno izbrisano!");
				frame.dispose();
				MjestaUI.main(null);
			}
		});
		bIzbrisi.setBounds(192, 22, 89, 23);
		frame.getContentPane().add(bIzbrisi);
		
		tfDodajMjesto = new JTextField();
		tfDodajMjesto.setBounds(10, 102, 159, 20);
		frame.getContentPane().add(tfDodajMjesto);
		tfDodajMjesto.setColumns(10);
		
		JButton bDodaj = new JButton("Dodaj");
		bDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!mp.provjeriPostojanjeMjesta(tfDodajMjesto.getText())) {
					mp.dodajMjesto(tfDodajMjesto.getText());
					tfDodajMjesto.setText("");
					JOptionPane.showMessageDialog(null, "Mjesto uspjesno dodano!");
					frame.dispose();
					MjestaUI.main(null);
				}
				else JOptionPane.showMessageDialog(null, "Mjesto vec postoji!");
			}
		});
		bDodaj.setBounds(192, 101, 89, 23);
		frame.getContentPane().add(bDodaj);
		
		JButton bNazad = new JButton("Nazad");
		bNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainUI.main(null);
			}
		});
		bNazad.setBounds(145, 212, 89, 23);
		frame.getContentPane().add(bNazad);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
