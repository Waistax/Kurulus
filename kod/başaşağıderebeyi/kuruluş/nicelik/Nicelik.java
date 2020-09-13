/**
 * başaşağıderebeyi.kuruluş.nicelik.Nicelik.java
 * 0.6 / 9 Eyl 2020 / 11:41:13
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nicelik;

import java.util.*;

public class Nicelik {
	public final Nitelik nitelik;
	public final Nicelik üstü;
	public final List<DeğiştiriciParçası> değiştiriciler;
	
	public float temel;
	public float kat;
	public float değer;
	public boolean kirli;
	
	public Nicelik(Nitelik nitelik, Nicelik üstü) {
		this.nitelik = nitelik;
		this.üstü = üstü;
		değiştiriciler = new ArrayList<>();
		kat = 1.0F;
	}
	
	public Nicelik(Nitelik nitelik) {
		this(nitelik, null);
	}
	
	private Nicelik hesapla(DeğiştiriciParçası değiştirici) {
		if (değiştirici.temel)
			temel += değiştirici.değer;
		else
			kat += değiştirici.değer;
		return this;
	}
	
	public float değer() {
		if (kirli) {
			temel = 0.0F;
			kat = 1.0F;
			if (üstü != null)
				for (DeğiştiriciParçası değiştirici : üstü.değiştiriciler)
					hesapla(değiştirici);
			for (DeğiştiriciParçası değiştirici : değiştiriciler)
				hesapla(değiştirici);
			değer = temel * kat;
			kirli = false;
		}
		return değer;
	}
	
	public Nicelik ekle(DeğiştiriciParçası değiştirici) {
		değiştiriciler.add(değiştirici);
		kirli = true;
		return this;
	}
	
	public Nicelik çıkar(DeğiştiriciParçası değiştirici) {
		değiştiriciler.remove(değiştirici);
		kirli = true;
		return this;
	}
	
	public Nicelik temizle() {
		değiştiriciler.clear();
		temel = 0.0F;
		kat = 1.0F;
		kirli = false;
		return this;
	}
}
