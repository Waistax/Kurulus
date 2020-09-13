/**
 * başaşağıderebeyi.kuruluş.nesne.Değiştirme.java
 * 0.8 / 13 Eyl 2020 / 11:42:48
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.nesne;

import başaşağıderebeyi.kuruluş.nicelik.*;

public class Değiştirme extends Bileşen {
	public final Değiştirilebilir hedef;
	public final SüreliDeğiştirici değiştirici;
	
	public Değiştirme(Değiştirilebilir hedef, Değiştirici değiştirici) {
		this.hedef = hedef;
		this.değiştirici = new SüreliDeğiştirici(değiştirici);
	}
	
	@Override
	public void eklendiğinde(Nesne nesne) {
		hedef.ekle(değiştirici);
	}
	
	@Override
	public void çıkartıldığında(Nesne nesne) {
		hedef.çıkar(değiştirici);
	}
}
