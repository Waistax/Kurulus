/**
 * başaşağıderebeyi.kuruluş.Ulus.java
 * 0.4 / 4 Eyl 2020 / 08:02:01
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import başaşağıderebeyi.kuruluş.dünya.*;
import başaşağıderebeyi.kuruluş.halk.*;
import başaşağıderebeyi.kuruluş.nesne.*;
import başaşağıderebeyi.kuruluş.nicelik.*;
import başaşağıderebeyi.kuruluş.yapı.*;
import başaşağıderebeyi.kütük.*;

import java.util.*;

public class Ulus extends Nesne {
	public final List<Kimlik> birincilKimlikler;
	public final List<Yapı> yapılar;
	public final List<Karo> toprak;
	public String ad;
	public Halk halk;
	public Yapı başkent;
	
	public Ulus(String ad) {
		birincilKimlikler = new ArrayList<>();
		yapılar = new ArrayList<>();
		toprak = new ArrayList<>();
		this.ad = ad;
		halk = new Halk();
		Değiştirilebilir değiştirilebilir = new Değiştirilebilir();
		bileşeniEkle(değiştirilebilir);
		Map<Tanımlayıcı, Nitelik> nitelikler = Kuruluş.KÜTÜK.haritaAl(Nitelik.class);
		for (Tanımlayıcı tanımlayıcı : nitelikler.keySet())
			if (tanımlayıcı.ad.startsWith("ulus_nitelik_"))
				değiştirilebilir.nicelikEkle(new Nicelik(nitelikler.get(tanımlayıcı)));
	}
	
	public void başkentiDeğiştir(Yapı başkent) {
		this.başkent = başkent;
	}
	
	public void gün() {
		bileşenAl(Değiştirilebilir.class).gün();
	}
}
