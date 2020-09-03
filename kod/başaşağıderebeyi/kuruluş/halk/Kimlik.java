/**
 * başaşağıderebeyi.kuruluş.halk.Kimlik.java
 * 0.2 / 3 Eyl 2020 / 09:55:02
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.halk;

public class Kimlik {
	public final Kültür kültür;
	public final İnanç inanç;
	public final String ad;
	
	public Kimlik(Kültür kültür, İnanç inanç) {
		this.kültür = kültür;
		this.inanç = inanç;
		ad = kültür.ad + " " + inanç.ad;
	}
	
	@Override
	public String toString() {
		return ad;
	}
}
