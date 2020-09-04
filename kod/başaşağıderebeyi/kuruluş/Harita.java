/**
 * başaşağıderebeyi.kuruluş.Harita.java
 * 0.4 / 4 Eyl 2020 / 08:08:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import başaşağıderebeyi.kuruluş.dünya.*;

import java.util.*;

public class Harita {
	public final Dünya dünya;
	public final List<Ulus> uluslar;
	
	public Harita(Dünya dünya) {
		this.dünya = dünya;
		this.uluslar = new ArrayList<>();
	}
}
