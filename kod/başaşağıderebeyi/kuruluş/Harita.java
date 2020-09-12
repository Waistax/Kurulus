/**
 * başaşağıderebeyi.kuruluş.Harita.java
 * 0.4 / 4 Eyl 2020 / 08:08:39
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import başaşağıderebeyi.kuruluş.dünya.*;
import başaşağıderebeyi.kuruluş.nicelik.*;
import başaşağıderebeyi.kütük.*;

import java.util.*;

public class Harita {
	public final Dünya dünya;
	public final List<Ulus> uluslar;
	
	public Harita(Dünya dünya) {
		this.dünya = dünya;
		this.uluslar = new ArrayList<>();
	}
	
	public Ulus ulusEkle(String ad) {
		Ulus ulus = new Ulus(ad);
		Map<Tanımlayıcı, Nitelik> nitelikler = Kuruluş.KÜTÜK.haritaAl(Nitelik.class);
		for (Tanımlayıcı tanımlayıcı : nitelikler.keySet())
			if (tanımlayıcı.ad.startsWith("ulus_nitelik_"))
				ulus.oluştur(nitelikler.get(tanımlayıcı));
		uluslar.add(ulus);
		return ulus;
	}
}
