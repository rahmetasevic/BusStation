package UI;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import RadSaPodacima.MjestaPodaci;
import RadSaPodacima.PolasciPodaci;

import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class SveLinijeKrozStanicuUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SveLinijeKrozStanicuUI window = new SveLinijeKrozStanicuUI();
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
	public SveLinijeKrozStanicuUI() {
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
		
		JLabel lblOdabirMjesta = new JLabel("Odabir mjesta");
		lblOdabirMjesta.setBounds(28, 11, 105, 14);
		frame.getContentPane().add(lblOdabirMjesta);
		
		JComboBox<String> cbMjesto = new JComboBox<String>();
		
		MjestaPodaci mp = new MjestaPodaci();
		List<String> mjesta = mp.ucitajSvaMjestaZaIspis();
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		for (String s : mjesta) {
			cbMjesto.addItem(s);
		}
		
		cbMjesto.setBounds(28, 32, 165, 20);
		frame.getContentPane().add(cbMjesto);
		
		JButton btnOdabir = new JButton("Odabir");
		btnOdabir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.clear();
				PolasciPodaci pp = new PolasciPodaci();
				List<String> polasci = pp.ucitajPolakseZaMjesto(cbMjesto.getSelectedItem().toString());
				
				for (String s : polasci) {
					dlm.addElement(s);
				}
			}
		});
		btnOdabir.setBounds(237, 31, 89, 23);
		frame.getContentPane().add(btnOdabir);
		
		
		
		JList<String> list = new JList<String>(dlm);
		
		
		
		list.setBounds(28, 63, 375, 165);
		frame.getContentPane().add(list);
	}

}
