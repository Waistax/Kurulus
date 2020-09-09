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
	public final Değiştirici[] değiştiricler;

	public Yapı(Karo karo, Değiştirici... değiştiriciler) {
		this.karo = karo;
		this.değiştiricler = değiştiriciler;
	}
	
	public void gün() {
	}
	
	public void yapıldığında(Ulus sahip) {
		for (Değiştirici değiştirici : değiştiricler)
			sahip.ekle(değiştirici);
	}
	
	public void yıkıldığında(Ulus sahip) {
		for (Değiştirici değiştirici : değiştiricler)
			sahip.çıkar(değiştirici);
	}
}
