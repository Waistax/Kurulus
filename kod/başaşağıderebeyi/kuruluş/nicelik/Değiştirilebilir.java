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
	
	private void ekle(DeğiştiriciParçası değiştirici) {
		nicelikler.get(değiştirici.nitelik).ekle(değiştirici);
	}
	
	private void ekle(Değiştirici değiştirici) {
		for (DeğiştiriciParçası değiştiriciParçası : değiştirici.parçalar)
			ekle(değiştiriciParçası);
	}
	
	public void ekle(SüreliDeğiştirici süreliDeğiştirici) {
		ekle(süreliDeğiştirici.değiştirici);
	}
	
	private void çıkar(DeğiştiriciParçası değiştirici) {
		nicelikler.get(değiştirici.nitelik).çıkar(değiştirici);
	}
	
	private void çıkar(Değiştirici değiştirici) {
		for (DeğiştiriciParçası değiştiriciParçası : değiştirici.parçalar)
			çıkar(değiştiriciParçası);
	}
	
	public void çıkar(SüreliDeğiştirici değiştirici) {
		çıkar(değiştirici.değiştirici);
	}
	
	public void temizle(Nitelik nitelik) {
		nicelikler.get(nitelik).temizle();
	}
	
	public void temizle() {
		for (Nicelik nicelik : nicelikler.values())
			nicelik.temizle();
	}
}
