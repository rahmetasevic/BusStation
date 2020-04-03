package RadSaPodacima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RezervacijaPodaci {

	public void spremiRezervaciju(String idLinije, String ime, String prezime, String brojKarata, String datum) {
		BufferedWriter bw = null;
		List<String> sveRezervacije = ucitajSveRezervacije();
		sveRezervacije.add(idLinije + " " + ime + " " + prezime + " " + brojKarata + " " + datum);
		
		try {
			bw = new BufferedWriter(new FileWriter("rezervacije.txt", false));
			
			for (String s : sveRezervacije) {
				bw.write(s);
				bw.newLine();
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
		finally {
			try {
				bw.flush();
				bw.close();
			}
			catch (IOException e) {
				System.out.println(e);
			}
		}
	}
	
	public List<String> ucitajSveRezervacije() {
		List<String> rezervacije = new ArrayList<String>();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("rezervacije.txt"));
			
			String linija;
			
			while ((linija = br.readLine()) != null) {
				rezervacije.add(linija);
			}
			
			br.close();
			
			return rezervacije;
		}
		catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<String> ucitajRezervacijeZaId(String id) {
		List<String> rezervacije = ucitajSveRezervacije();
		List<String> filtriraneRezervacije = new ArrayList<String>();
		
		for (String s : rezervacije) {
			if (s.split(" ")[0].equals(id)) {
				filtriraneRezervacije.add(s);
			}
		}
		
		return filtriraneRezervacije;
	}
}
