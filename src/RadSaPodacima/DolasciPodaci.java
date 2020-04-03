package RadSaPodacima;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DolasciPodaci {

	public List<String> ucitajOdlaskeIzStanice(String mjesto) {
		List<String> odlasci = new ArrayList<String>();
		List<String> zaBrisanje = new ArrayList<String>();
		
		odlasci = ucitajSveDolaske();
		mjesto = mjesto.toLowerCase();
		
		for (String s : odlasci) {
			if (!s.split(" ")[3].toLowerCase().contains(mjesto)) {
				zaBrisanje.add(s);
			}
		}
		
		odlasci.removeAll(zaBrisanje);
		
		UsputnePodaci up = new UsputnePodaci();
		
		String[][] zaDodat = new String[999][999];
		for (int i = 0; i < 999; i++) {
			for (int j = 0; j < 999; j++) {
				zaDodat[i][j] = null;
			}
		}
		
		int j = 0;
		for (int i = 0; i < odlasci.size(); i++) {
			List<String> usputne = up.ucitajUsputneSaId(odlasci.get(i).split(" ")[0]);
			
			if (usputne != null && usputne.size() > 0) {
				for (int k = 0; k < usputne.size(); k++) {
					zaDodat[j][k] = String.valueOf(i);
					zaDodat[j+1][k] = usputne.get(k);
					j = j + 2;
				}
			}	
		}
		
		for(int i = 0; i < j; i = i + 2) {
			for (int k = 0; zaDodat[i][k] != null; k++) {
				odlasci.add(Integer.valueOf(zaDodat[i][k]) + 1, zaDodat[i+1][k]);
			}
		}
		
		return odlasci;
	}
	
	public List<String> ucitajSveDolaske() {
		BufferedReader br = null;
		List<String> odlasci = new ArrayList<String>();
		
		try {
			File file = new File("odlasci.txt");
			br = new BufferedReader(new FileReader(file));
			
			String linija;
			
			while ((linija = br.readLine()) != null) {
				odlasci.add(linija);
			}
			
			br.close();
			
			return odlasci;
		}
		catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
}
