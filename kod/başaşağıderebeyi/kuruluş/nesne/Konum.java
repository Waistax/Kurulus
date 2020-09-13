/**
 * başaşağıderebeyi.kuruluş.nesne.Konum.java
 * 0.8 / 13 Eyl 2020 / 11:40:35
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nesne;

import başaşağıderebeyi.matematik.*;

public class Konum extends Bileşen {
	public final Vektör2 konum;
	
	public Konum() {
		konum = new Vektör2();
	}
	
	@Override
	public String toString() {
		return konum.toString();
	}
}
