package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import RadSaPodacima.MjestaPodaci;
import RadSaPodacima.OdlasciPodaci;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;

public class OdlasciUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdlasciUI window = new OdlasciUI();
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
	public OdlasciUI() {
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
		
		JButton bNazad = new JButton("Nazad");
		bNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainUI.main(null);
			}
		});
		bNazad.setBounds(20, 213, 89, 23);
		frame.getContentPane().add(bNazad);
		
		JComboBox<String> cbMjesta = new JComboBox<String>();
		MjestaPodaci mp = new MjestaPodaci();
		List<String> mjesta = mp.ucitajSvaMjestaZaIspis();
		
		for (String s : mjesta) {
			cbMjesta.addItem(s);
		}
		
		cbMjesta.setBounds(20, 23, 145, 20);
		frame.getContentPane().add(cbMjesta);
		
		JButton bOdabirStanice = new JButton("Odabir stanice");

		bOdabirStanice.setBounds(193, 22, 145, 23);
		frame.getContentPane().add(bOdabirStanice);
		
		JList<String> listOdlasci = new JList<String>();
		DefaultListModel<String> modelList = new DefaultListModel<String>();
		listOdlasci.setModel(modelList);
		
		listOdlasci.setBounds(20, 54, 392, 152);
		frame.getContentPane().add(listOdlasci);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		bOdabirStanice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelList.clear();
				
				OdlasciPodaci op = new OdlasciPodaci();
				
				List<String> odlasci = op.ucitajOdlaskeIzStanice(cbMjesta.getSelectedItem().toString());
				
				
				for (String s : odlasci) {
					modelList.addElement(s);
				}
			}
		});
	}
}
