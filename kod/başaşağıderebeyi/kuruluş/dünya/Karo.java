/**
 * başaşağıderebeyi.kuruluş.dünya.Karo.java
 * 0.1 / 3 Eyl 2020 / 09:30:27
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.dünya;

import başaşağıderebeyi.matematik.*;

public class Karo {
	public final Vektör2 konum;
	public final int endeks;
	public Arazi arazi;
	
	public Karo(Vektör2 konum, int endeks, Arazi arazi) {
		this.konum = konum;
		this.endeks = endeks;
		this.arazi = arazi;
	}
	
	public Karo(Vektör2 konum, int endeks) {
		this(konum, endeks, null);
	}
}
