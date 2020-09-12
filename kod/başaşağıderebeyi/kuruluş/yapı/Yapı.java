/**
 * başaşağıderebeyi.kuruluş.yapı.Yapı.java
 * 0.3 / 3 Eyl 2020 / 10:12:49
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.yapı;

import başaşağıderebeyi.kuruluş.*;
import başaşağıderebeyi.kuruluş.dünya.*;
import başaşağıderebeyi.kuruluş.nicelik.*;

public class Yapı {
	public final Karo karo;
	public final SüreliDeğiştirici değiştirici;

	public Yapı(Karo karo, DeğiştiriciParçası... parçalar) {
		this.karo = karo;
		Değiştirici değiştirici = new Değiştirici("yapı");
		for (DeğiştiriciParçası parça : parçalar)
			değiştirici.parçalar.add(parça);
		this.değiştirici = new SüreliDeğiştirici(değiştirici);
	}
	
	public void gün() {
	}
	
	public void yapıldığında(Ulus sahip) {
		sahip.ekle(değiştirici);
	}
	
	public void yıkıldığında(Ulus sahip) {
		sahip.çıkar(değiştirici);
	}
}
