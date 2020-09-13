/**
 * başaşağıderebeyi.kuruluş.yapı.Yapı.java
 * 0.3 / 3 Eyl 2020 / 10:12:49
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.yapı;

import başaşağıderebeyi.kuruluş.*;
import başaşağıderebeyi.kuruluş.dünya.*;
import başaşağıderebeyi.kuruluş.nesne.*;
import başaşağıderebeyi.kuruluş.nicelik.*;

import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class Yapı extends Nesne {
	public Yapı(Ulus ulus, Karo karo, DeğiştiriciParçası... parçalar) {
		Değiştirici değiştirici = new Değiştirici("yapı");
		for (DeğiştiriciParçası parça : parçalar)
			değiştirici.parçalar.add(parça);
		Konum konum = new Konum();
		konum.konum.yaz(karo.konum);
		bileşeniEkle(konum);
		bileşeniEkle(new Değiştirme(ulus.bileşenAl(Değiştirilebilir.class), değiştirici));
		try {
			BufferedImage resim = ImageIO.read(new File("kay/şehir_i.png"));
			Görsel görsel = new Görsel();
			görsel.resim = resim;
			bileşeniEkle(görsel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
