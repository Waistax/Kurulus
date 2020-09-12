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
}
