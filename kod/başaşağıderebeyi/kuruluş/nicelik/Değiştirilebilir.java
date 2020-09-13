/**
 * başaşağıderebeyi.kuruluş.nicelik.Değiştirilebilir.java
 * 0.6 / 9 Eyl 2020 / 12:09:30
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nicelik;

import başaşağıderebeyi.kuruluş.nesne.*;

import java.util.*;

public class Değiştirilebilir extends Bileşen {
	public final Map<Nitelik, Nicelik> nicelikler;
	public final List<SüreliDeğiştirici> değiştiriciler;
	
	public Değiştirilebilir() {
		nicelikler = new HashMap<>();
		değiştiriciler = new ArrayList<>();
	}
	
	public Değiştirilebilir nicelikEkle(Nicelik nicelik) {
		nicelikler.put(nicelik.nitelik, nicelik);
		return this;
	}
	
	public float değer(Nitelik nitelik) {
		return nicelikler.get(nitelik).değer();
	}
	
	public Değiştirilebilir ekle(SüreliDeğiştirici değiştirici) {
		for (DeğiştiriciParçası değiştiriciParçası : değiştirici.değiştirici.parçalar)
			nicelikler.get(değiştiriciParçası.nitelik).ekle(değiştiriciParçası);
		değiştiriciler.add(değiştirici);
		return this;
	}
	
	public Değiştirilebilir çıkar(SüreliDeğiştirici değiştirici) {
		for (DeğiştiriciParçası değiştiriciParçası : değiştirici.değiştirici.parçalar)
			nicelikler.get(değiştiriciParçası.nitelik).çıkar(değiştiriciParçası);
		değiştiriciler.remove(değiştirici);
		return this;
	}
	
	public Değiştirilebilir temizle() {
		for (Nicelik nicelik : nicelikler.values())
			nicelik.temizle();
		değiştiriciler.clear();
		return this;
	}
	
	public Değiştirilebilir gün() {
		for (int i = 0; i < değiştiriciler.size(); i++) {
			SüreliDeğiştirici değiştirici = değiştiriciler.get(i);
			if (--değiştirici.süre == 0) {
				çıkar(değiştirici);
				i--;
			}
		}
		return this;
	}
}
