package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import RadSaPodacima.DolasciPodaci;
import RadSaPodacima.MjestaPodaci;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DolasciUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DolasciUI window = new DolasciUI();
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
	public DolasciUI() {
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
		cbMjesta.setBounds(10, 11, 162, 20);
		
		MjestaPodaci mp = new MjestaPodaci();
		List<String> mjesta = mp.ucitajSvaMjestaZaIspis();
		
		for (String s : mjesta) {
			cbMjesta.addItem(s);
		}
		
		frame.getContentPane().add(cbMjesta);
		
		JButton bOdabir = new JButton("Odabir");

		bOdabir.setBounds(204, 10, 89, 23);
		frame.getContentPane().add(bOdabir);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList<String> list = new JList<String>(dlm);
		list.setBounds(10, 44, 414, 179);
		frame.getContentPane().add(list);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainUI.main(null);
			}
		});
		btnNazad.setBounds(48, 234, 89, 23);
		frame.getContentPane().add(btnNazad);
		
		
		bOdabir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DolasciPodaci dp = new DolasciPodaci();
				List<String> dolasci = dp.ucitajOdlaskeIzStanice(cbMjesta.getSelectedItem().toString());
				
				for (String s : dolasci) {
					dlm.addElement(s);
				}
			}
		});
	}
}
