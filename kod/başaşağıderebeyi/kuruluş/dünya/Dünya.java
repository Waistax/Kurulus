/**
 * başaşağıderebeyi.kuruluş.dünya.Dünya.java
 * 0.1 / 3 Eyl 2020 / 09:29:52
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.dünya;

import başaşağıderebeyi.matematik.*;

public class Dünya {
	public final Vektör2t boyut;
	public final Karo[] karolar;
	
	public Dünya(Vektör2t boyut) {
		this.boyut = boyut;
		this.karolar = new Karo[boyut.x * boyut.y];
		int endeks = 0;
		for (int y = 0; y < boyut.y; y++)
			for (int x = 0; x < boyut.x; x++)
				karolar[endeks] = new Karo(new Vektör2t(x, y), endeks++);
	}
	
	public int endeks(int x, int y) {
		return x + y * boyut.x;
	}
	
	public int endeks(Vektör2t konum) {
		return endeks(konum.x, konum.y);
	}
	
	public Vektör2t konum(int endeks) {
		return karolar[endeks].konum;
	}
}
