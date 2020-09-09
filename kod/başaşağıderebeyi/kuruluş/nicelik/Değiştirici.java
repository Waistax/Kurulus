/**
 * başaşağıderebeyi.kuruluş.nicelik.Değiştirici.java
 * 0.6 / 9 Eyl 2020 / 11:41:22
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nicelik;

public class Değiştirici {
	public final String ad;
	public final Nitelik nitelik;
	public final boolean temel;
	public float değer;
	public int süre;

	public Değiştirici(String ad, Nitelik nitelik, boolean temel, float değer, int süre) {
		this.ad = ad;
		this.nitelik = nitelik;
		this.temel = temel;
		this.değer = değer;
		this.süre = süre;
	}
}
