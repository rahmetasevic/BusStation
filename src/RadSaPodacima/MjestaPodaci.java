package RadSaPodacima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MjestaPodaci {
	
	@SuppressWarnings("resource")
	public List<String> ucitajSvaMjestaZaIspis() {
		BufferedReader br = null;
		
		try {
			File file = new File("mjesta.txt");
			br = new BufferedReader(new FileReader(file));
			
			String linija;
			List<String> neFiltriranaLista = new ArrayList<String>();
			List<String> filtriranaLista = new ArrayList<String>();
			
			while ((linija = br.readLine()) != null) {
				neFiltriranaLista.add(linija);
			}
			
			for (String s : neFiltriranaLista) {
				filtriranaLista.add(s.split(" ")[1]);
			}
			
			return filtriranaLista;
		}
		catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
	@SuppressWarnings("resource")
	public List<String> ucitajSvaMjesta() {
		BufferedReader br = null;
		
		try {
			File file = new File("mjesta.txt");
			br = new BufferedReader(new FileReader(file));
			
			String linija;
			List<String> neFiltriranaLista = new ArrayList<String>();
			
			while ((linija = br.readLine()) != null) {
				neFiltriranaLista.add(linija);
			}
			
			
			return neFiltriranaLista;
		}
		catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void izbrisiMjesto(String mjesto) {

		List<String> mjesta = ucitajSvaMjesta();
			
		int zaBrisanje = -1;
		for (int i = 0; i < mjesta.size(); i++) {
			if (mjesta.get(i).contains(mjesto)) {
				zaBrisanje = i;
				break;
			}
		}
		
		if (zaBrisanje != -1) {
			mjesta.remove(zaBrisanje);
		}
		
		zapisiSvaMjesta(mjesta, false);
		
	}
	
	public void zapisiSvaMjesta(List<String> mjesta, boolean append) {
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("mjesta.txt", append));
			
			for (String s : mjesta) {
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
		finally {
			if (bw != null) {
				try {
					bw.close();
				}
				catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	public boolean provjeriPostojanjeMjesta(String mjesto) {
		
		List<String> mjesta = ucitajSvaMjesta();
		
		boolean postoji = false;
		for (String s : mjesta) {
			if (s.contains(mjesto)) postoji = true;
		}
		
		return postoji;
	}
	
	public void dodajMjesto(String mjesto) {
		
		List<String> mjesta = ucitajSvaMjesta();
		
		String id = mjesta.get(mjesta.size() - 1).split(" ")[0];
		
		mjesta.add((Integer.valueOf(id) + 1) + " " + mjesto);
		
		zapisiSvaMjesta(mjesta, false);
	}
}
