/**
 * başaşağıderebeyi.kuruluş.dünya.Dünya.java
 * 0.1 / 3 Eyl 2020 / 09:29:52
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.dünya;

import başaşağıderebeyi.matematik.*;

public class Dünya {
	public final Vektör2 boyut;
	public final Karo[] karolar;
	
	public Dünya(Vektör2 boyut) {
		this.boyut = boyut;
		this.karolar = new Karo[(int)(boyut.x * boyut.y)];
	}
	
	public int endeks(int x, int y) {
		return x + y * (int)boyut.x;
	}
	
	public int endeks(Vektör2 konum) {
		return endeks((int)konum.x, (int)konum.x);
	}
	
	public Vektör2 konum(int endeks) {
		return karolar[endeks].konum;
	}
}
