/**
 * başaşağıderebeyi.kuruluş.nesne.Görsel.java
 * 0.8 / 13 Eyl 2020 / 13:28:31
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nesne;

import başaşağıderebeyi.kuruluş.*;
import başaşağıderebeyi.matematik.*;

import java.awt.image.*;

public class Görsel extends Bileşen {
	private final Vektör2 pikselKonumuTamponu;

	public BufferedImage resim;
	public Vektör2 konum;
	
	public Görsel() {
		this.pikselKonumuTamponu = new Vektör2();
	}
	
	@Override
	public void eklendiğinde(Nesne nesne) {
		Konum konum = nesne.bileşenAl(Konum.class);
		if (konum != null)
			this.konum = konum.konum;
		else
			this.konum = null;
	}
	
	public void çiz() {
		if (resim != null && konum != null && Kuruluş.KURULUŞ.ekranDörtgeni.içinde(konum)) {
			Kuruluş.KURULUŞ.piksel(konum, pikselKonumuTamponu);
			Kuruluş.KURULUŞ.çizer.drawImage(resim,
					(int)pikselKonumuTamponu.x, (int)pikselKonumuTamponu.y,
					Kuruluş.KURULUŞ.karoBoyutu, Kuruluş.KURULUŞ.karoBoyutu, null);
		}
	}
}
