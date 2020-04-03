package RadSaPodacima;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PolasciPodaci {
	
	public List<String> ucitajPolakseZaMjesto(String mjesto) {
		List<String> polasci = new ArrayList<String>();
		BufferedReader br = null;
		mjesto = mjesto.toLowerCase();
		
		try {
			br = new BufferedReader(new FileReader("odlasci.txt"));
			String linija;
			
			while ((linija = br.readLine()) != null) {
				if (linija.split(" ")[1].toLowerCase().contains(mjesto)) {
					polasci.add(linija.split(" ")[1] + " " + linija.split(" ")[2]);
				}
			}
			
			br.close();
			
			br = new BufferedReader(new FileReader("usputne.txt"));
			
			while ((linija = br.readLine()) != null) {
				if (linija.toLowerCase().contains(mjesto)) {
					polasci.add(linija.split(" ")[1] + " " + linija.split(" ")[2]);
				}
			}
			
			return polasci;
		}
		catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
}
