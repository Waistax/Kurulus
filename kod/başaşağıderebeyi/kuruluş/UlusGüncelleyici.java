/**
 * başaşağıderebeyi.kuruluş.UlusGüncelleyici.java
 * 0.7 / 10 Eyl 2020 / 11:02:44
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import java.util.*;

public class UlusGüncelleyici implements Runnable {
	public final List<Ulus> uluslar;
	public final int kimlik;
	public final int sayı;
	
	public boolean çalışıyor;
	
	public UlusGüncelleyici(List<Ulus> uluslar, int kimlik, int sayı) {
		this.uluslar = uluslar;
		this.kimlik = kimlik;
		this.sayı = sayı;
	}
	
	@Override
	public void run() {
		çalışıyor = true;
		final int bitiş = uluslar.size() * (kimlik + 1) / sayı;
		for (int i = uluslar.size() * kimlik / sayı; i < bitiş; i++)
			uluslar.get(i).gün();
		çalışıyor = false;
	}
}
