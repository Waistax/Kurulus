/**
 * başaşağıderebeyi.kuruluş.UlusGüncelleyici.java
 * 0.7 / 10 Eyl 2020 / 11:02:44
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import başaşağıderebeyi.kuruluş.nesne.*;

import java.util.*;

public class UlusGüncelleyici implements Runnable {
	public final List<Nesne> nesneler;
	public final int kimlik;
	public final int sayı;
	
	public boolean çalışıyor;
	
	public UlusGüncelleyici(List<Nesne> nesneler, int kimlik, int sayı) {
		this.nesneler = nesneler;
		this.kimlik = kimlik;
		this.sayı = sayı;
	}
	
	@Override
	public void run() {
		çalışıyor = true;
		final int bitiş = nesneler.size() * (kimlik + 1) / sayı;
		for (int i = nesneler.size() * kimlik / sayı; i < bitiş; i++) {
			Nesne nesne = nesneler.get(i);
			if (nesne instanceof Ulus)
				((Ulus)nesne).gün();
		}
		çalışıyor = false;
	}
}
