/**
 * başaşağıderebeyi.kuruluş.nicelik.SüreliDeğiştirici.java
 * sürüm / 11 Eyl 2020 / 09:01:04
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nicelik;

public class SüreliDeğiştirici {
	public final Değiştirici değiştirici;
	public int süre;
	
	public SüreliDeğiştirici(Değiştirici değiştirici, int süre) {
		this.değiştirici = değiştirici;
		this.süre = süre;
	}
	
	public SüreliDeğiştirici(Değiştirici değiştirici) {
		this(değiştirici, -1);
	}
}
