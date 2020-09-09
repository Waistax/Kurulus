/**
 * başaşağıderebeyi.kuruluş.nicelik.Değiştirilebilir.java
 * 0.6 / 9 Eyl 2020 / 12:09:30
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nicelik;

import java.util.*;

public class Değiştirilebilir {
	public final Map<Nitelik, Nicelik> nicelikler;
	
	public Değiştirilebilir() {
		nicelikler = new HashMap<>();
	}
	
	public void oluştur(Nitelik nitelik) {
		nicelikler.put(nitelik, new Nicelik(nitelik));
	}
	
	public void yokEt(Nitelik nitelik) {
		nicelikler.remove(nitelik);
	}
	
	public float değer(Nitelik nitelik) {
		return nicelikler.get(nitelik).değer();
	}
	
	public void ekle(Değiştirici değiştirici) {
		nicelikler.get(değiştirici.nitelik).ekle(değiştirici);
	}
	
	public void çıkar(Değiştirici değiştirici) {
		nicelikler.get(değiştirici.nitelik).çıkar(değiştirici);
	}
	
	public void temizle(Nitelik nitelik) {
		nicelikler.get(nitelik).temizle();
	}
	
	public void temizle() {
		for (Nicelik nicelik : nicelikler.values())
			nicelik.temizle();
	}
	
	public void gün() {
		for (Nicelik nicelik : nicelikler.values())
			nicelik.gün();
	}
}
