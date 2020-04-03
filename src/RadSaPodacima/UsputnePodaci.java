package RadSaPodacima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsputnePodaci {

	public void spremiUsputne(List<String> usputne) {
		BufferedWriter bw = null;
		List<String> sveUsputne = ucitajSveUsputne();
		
		
		for (String s : usputne) {
			sveUsputne.add(s);
		}
		
		try {
			bw = new BufferedWriter(new FileWriter("usputne.txt", false));
			
			for (String s : sveUsputne) {
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
	
	public List<String> ucitajSveUsputne() {
		BufferedReader br = null;
		List<String> sveUsputne = new ArrayList<String>();
		
		try {
			br = new BufferedReader(new FileReader("usputne.txt"));
			
			String linija;
			
			while((linija = br.readLine()) != null) {
				sveUsputne.add(linija);
			}
			
			br.close();
			
			return sveUsputne;
		}
		catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<String> ucitajUsputneSaId(String id) {
		List<String> sveUsputne = ucitajSveUsputne();
		List<String> usputneSaId = new ArrayList<String>();
		
		for (String s : sveUsputne) {
			if (s.split(" ")[0].contains(id)) {
				usputneSaId.add(s);
			}
		}
		
		return usputneSaId;
	}
}
