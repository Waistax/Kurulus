/**
 * başaşağıderebeyi.kuruluş.nicelik.Değiştirici.java
 * 0.6 / 9 Eyl 2020 / 11:41:22
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nicelik;

import java.util.*;

public class Değiştirici {
	public final String ad;
	public final List<DeğiştiriciParçası> parçalar;
	
	public Değiştirici(String ad) {
		this.ad = ad;
		parçalar = new ArrayList<>();
	}
	
	public Değiştirici parçaEkle(DeğiştiriciParçası parça) {
		parçalar.add(parça);
		return this;
	}
	
	public Değiştirici parçaEkle(Nitelik nitelik, boolean temel, float değer) {
		return parçaEkle(new DeğiştiriciParçası(nitelik, temel, değer));
	}
}
