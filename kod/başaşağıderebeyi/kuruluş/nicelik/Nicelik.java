/**
 * başaşağıderebeyi.kuruluş.nicelik.Nicelik.java
 * 0.6 / 9 Eyl 2020 / 11:41:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nicelik;

import java.util.*;

public class Nicelik {
	public final Nitelik nitelik;
	public final List<Değiştirici> değiştiriciler;
	
	public float temel;
	public float kat;
	public float değer;
	public boolean kirli;
	
	public Nicelik(Nitelik nitelik) {
		this.nitelik = nitelik;
		değiştiriciler = new ArrayList<>();
		kat = 1.0F;
	}
	
	public float değer() {
		if (kirli) {
			temel = 0.0F;
			kat = 1.0F;
			for (Değiştirici değiştirici : değiştiriciler)
				if (değiştirici.temel)
					temel += değiştirici.değer;
				else
					kat += değiştirici.değer;
			değer = temel * kat;
			kirli = false;
		}
		return değer;
	}
	
	public void ekle(Değiştirici değiştirici) {
		değiştiriciler.add(değiştirici);
		kirli = true;
	}
	
	public void çıkar(int endeks) {
		değiştiriciler.remove(endeks);
		kirli = true;
	}
	
	public void çıkar(Değiştirici değiştirici) {
		çıkar(değiştiriciler.indexOf(değiştirici));
	}
	
	public void temizle() {
		değiştiriciler.clear();
		temel = 0.0F;
		kat = 1.0F;
		kirli = false;
	}
	
	public void gün() {
		for (int i = 0; i < değiştiriciler.size(); i++)
			if (değiştiriciler.get(i).süre-- == 0)
				çıkar(i--);
	}
}
