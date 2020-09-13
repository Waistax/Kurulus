/**
 * başaşağıderebeyi.kuruluş.Harita.java
 * 0.4 / 4 Eyl 2020 / 08:08:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import başaşağıderebeyi.kuruluş.dünya.*;
import başaşağıderebeyi.kuruluş.nesne.*;

import java.util.*;

public class Harita {
	public final Dünya dünya;
	public final List<Nesne> nesneler;
	
	public Harita(Dünya dünya) {
		this.dünya = dünya;
		this.nesneler = new ArrayList<>();
	}
	
	public void nesneEkle(Nesne nesne) {
		nesneler.add(nesne);
	}
	
	public void nesneÇıkar(Nesne nesne) {
		nesneler.remove(nesne);
		nesne.yokEdildiğinde();
	}
}
