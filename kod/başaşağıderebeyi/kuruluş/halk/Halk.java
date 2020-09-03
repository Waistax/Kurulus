/**
 * başaşağıderebeyi.kuruluş.halk.Halk.java
 * 0.2 / 3 Eyl 2020 / 09:54:24
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş.halk;

import java.util.*;

public class Halk {
	public final Map<Kimlik, Integer> nitelik;
	public int nicelik;
	
	public Halk(Halk... halklar) {
		if (halklar.length == 0)
			nitelik = new HashMap<>();
		else {
			nitelik = new HashMap<>(halklar[0].nitelik);
			nicelik = halklar[0].nicelik;
			for (int i = 1; i < halklar.length; i++)
				ekle(halklar[i]);
		}
	}
	
	public void ekle(Halk halk) {
		for (Kimlik kimlik : halk.nitelik.keySet()) {
			Integer kimlikNiceliği = nitelik.get(kimlik);
			if (kimlikNiceliği == null)
				nitelik.put(kimlik, halk.nitelik.get(kimlik));
			else
				nitelik.put(kimlik, kimlikNiceliği + halk.nitelik.get(kimlik));
		}
		nicelik += halk.nicelik;
	}
	
	public void ekle(Kimlik kimlik, int kimlikNiceliği) {
		Integer eskiNicelik = nitelik.get(kimlik);
		if (eskiNicelik == null)
			nitelik.put(kimlik, kimlikNiceliği);
		else
			nitelik.put(kimlik, eskiNicelik + kimlikNiceliği);
	}
	
	@Override
	public String toString() {
		StringBuilder sonuç = new StringBuilder();
		for (Kimlik kimlik : nitelik.keySet())
			sonuç.append(kimlik).append(" = ").append(nitelik.get(kimlik)).append(System.lineSeparator());
		return sonuç.delete(sonuç.length() - System.lineSeparator().length(), sonuç.length()).toString();
	}
}
