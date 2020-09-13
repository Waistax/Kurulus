/**
 * başaşağıderebeyi.kuruluş.nesne.Nesne.java
 * 0.8 / 12 Eyl 2020 / 12:57:48
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nesne;

import java.util.*;

public class Nesne {
	public final Map<Class<? extends Bileşen>, Bileşen> bileşenler;

	public Nesne() {
		this.bileşenler = new HashMap<>();
	}
	
	public <B extends Bileşen> void bileşeniEkle(B b) {
		bileşenler.put(b.getClass(), b);
		b.eklendiğinde(this);
	}
	
	public <B extends Bileşen> void bileşeniÇıkar(B b) {
		bileşenler.remove(b.getClass());
		b.çıkartıldığında(this);
	}
	
	public <B extends Bileşen> void bileşenÇıkar(Class<B> sınıf) {
		Bileşen b = bileşenler.remove(sınıf);
		if (b != null)
			b.çıkartıldığında(this);
	}
	
	@SuppressWarnings("unchecked")
	public <B extends Bileşen> B bileşenAl(Class<B> sınıf) {
		Bileşen b = bileşenler.get(sınıf);
		if (b == null)
			return null;
		return (B)b;
	}
	
	public <B extends Bileşen> boolean bileşenVarMı(Class<B> sınıf) {
		return bileşenler.containsKey(sınıf);
	}
	
	public <B extends Bileşen> boolean bileşeninSahibiMi(B b) {
		return bileşenler.containsValue(b);
	}
	
	public void yokEdildiğinde() {
		for (Bileşen b : bileşenler.values())
			b.çıkartıldığında(this);
	}
}
