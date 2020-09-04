/**
 * başaşağıderebeyi.kuruluş.yapı.Yapı.java
 * 0.3 / 3 Eyl 2020 / 10:12:49
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.yapı;

import başaşağıderebeyi.kuruluş.dünya.*;

public class Yapı {
	public final Karo karo;
	public YapıTürü tür;
	
	public Yapı(Karo karo, YapıTürü tür) {
		this.karo = karo;
		this.tür = tür;
	}
	
	public Yapı(Karo karo) {
		this(karo, null);
	}
	
	public void kare() {
		tür.kare(this);
	}
	
	public void yapıldığında() {
		tür.yapıldığında(this);
	}
	
	public void yıkıldığında() {
		tür.yıkıldığında(this);
	}
}
