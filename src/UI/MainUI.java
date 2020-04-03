package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;

import UI.MjestaUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
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
	public MainUI() {
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
		
		JButton btnMjesta = new JButton("Mjesta");
		btnMjesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MjestaUI.main(null);
			}
		});
		btnMjesta.setBounds(63, 53, 132, 23);
		frame.getContentPane().add(btnMjesta);
		
		JButton btnPregledOdlazaka = new JButton("Pregled odlazaka");
		btnPregledOdlazaka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OdlasciUI.main(null);
			}
		});
		btnPregledOdlazaka.setBounds(63, 87, 132, 23);
		frame.getContentPane().add(btnPregledOdlazaka);
		
		JButton bDodajOdlazak = new JButton("Dodaj odlazak");
		bDodajOdlazak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajOdlazakUI.main(null);
			}
		});
		bDodajOdlazak.setBounds(63, 121, 132, 23);
		frame.getContentPane().add(bDodajOdlazak);
		
		JButton btnNewButton = new JButton("Dolasci");
		btnNewButton.setBounds(63, 155, 132, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rezervacije");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RezervacijeUI.main(null);
			}
		});
		btnNewButton_1.setBounds(218, 53, 137, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sve linije kroz stanicu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(218, 87, 137, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnSpisakRezervacija = new JButton("Spisak rezervacija");
		btnSpisakRezervacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpisakRezervacijaUI.main(null);
			}
		});
		btnSpisakRezervacija.setBounds(218, 121, 137, 23);
		frame.getContentPane().add(btnSpisakRezervacija);
	}
}
