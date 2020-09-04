/**
 * başaşağıderebeyi.kuruluş.Ulus.java
 * 0.4 / 4 Eyl 2020 / 08:02:01
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import başaşağıderebeyi.kuruluş.halk.*;
import başaşağıderebeyi.kuruluş.yapı.*;

import java.util.*;

public class Ulus {
	public final List<Kimlik> birincilKimlikler;
	public final List<Yapı> yapılar;
	public String ad;
	public Halk halk;
	public Yapı başkent;
	
	public Ulus(String ad) {
		birincilKimlikler = new ArrayList<>();
		yapılar = new ArrayList<>();
		this.ad = ad;
	}
	
	public void başkentiDeğiştir(Yapı başkent) {
		this.başkent = başkent;
	}
}
