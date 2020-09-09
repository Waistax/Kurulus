/**
 * başaşağıderebeyi.kuruluş.DünyaOluşturucu.java
 * 0.5 / 8 Eyl 2020 / 11:54:05
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import başaşağıderebeyi.kuruluş.dünya.*;
import başaşağıderebeyi.matematik.*;

public class DünyaOluşturucu implements Runnable {
	public final Dünya dünya;
	public final Arazi[] araziler;
	public final int kimlik;
	public final int başlangıç;
	public final int bitiş;
	
	public float yüzde;
	public boolean bitti;
	
	public DünyaOluşturucu(Dünya dünya, Arazi[] araziler, int kimlik, int başlangıç, int bitiş) {
		this.dünya = dünya;
		this.araziler = araziler;
		this.kimlik = kimlik;
		this.başlangıç = başlangıç;
		this.bitiş = bitiş;
	}
	
	@Override
	public void run() {
		System.out.println("Oluşturucu " + kimlik + " başlıyor...");
		final float yatayYükseklik = bitiş - başlangıç;
		int endeks = başlangıç * (int)dünya.boyut.x;
		for (int y = başlangıç; y < bitiş; y++) {
			for (int x = 0; x < dünya.boyut.x; x++)
				dünya.karolar[endeks] = new Karo(new Vektör2(x, y), endeks++, araziler[(int)(Math.random() * 100.0F) % araziler.length]);
			yüzde = (y + 1 - başlangıç) / yatayYükseklik;
		}
		bitti = true;
		System.out.println("Oluşturucu " + kimlik + " bitti!");
	}
}
