/**
 * başaşağıderebeyi.kuruluş.Kuruluş.java
 * 0.1 / 3 Eyl 2020 / 09:24:26
 * Cem GEÇGEL (BaşAşağıDerebeyi)
 */
package başaşağıderebeyi.kuruluş;

import başaşağıderebeyi.awtkütüphanesi.*;
import başaşağıderebeyi.kuruluş.dünya.*;
import başaşağıderebeyi.kuruluş.nesne.*;
import başaşağıderebeyi.kuruluş.nicelik.*;
import başaşağıderebeyi.kuruluş.yapı.*;
import başaşağıderebeyi.kütük.*;
import başaşağıderebeyi.matematik.*;
import başaşağıderebeyi.motor.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

public class Kuruluş implements Uygulama {
	public static final String SÜRÜM = "0.8";
	public static final Kütük KÜTÜK = new Kütük();
	public static final Kuruluş KURULUŞ = new Kuruluş();
	public static final AWTGörselleştirici GÖRSELLEŞTİRİCİ = new AWTGörselleştirici();
	public static final AWTGirdi GİRDİ = new AWTGirdi();
	
	public static final float YAKINLAŞTIRMA_TABANI = 1.2F;
	public static final int YAKINLAŞTIRMA_BAŞLANGIÇ_DEĞERİ = 16;
	public static final int YAKINLAŞTIRMA_EN_YÜKSEK_DEĞERİ = 28;
	public static final int YAKINLAŞTIRMA_EN_DÜŞÜK_DEĞERİ = 8;
	public static final float WASD_HIZI = 1000.0F;
	public static final Color SINIR_RENGİ = new Color(0.0F, 0.0F, 0.0F, 0.8F);
	public static final Stroke SINIR_ÇİZGİSİ = new BasicStroke(0.5F);
	public static final Color ÜSTÜNDE_DURMA_RENGİ = new Color(1.0F, 1.0F, 0.0F, 1.0F);
	public static final Stroke ÜSTÜNDE_DURMA_ÇİZGİSİ = new BasicStroke(1.5F);
	
	public static final Color KARE_ORANI_SAYAÇ_RENGİ = new Color(1.0F, 1.0F, 1.0F, 1.0F);
	public static final Color KARE_ORANI_ARKAPLAN_RENGİ = new Color(0.0F, 0.0F, 0.0F, 0.5F);
	public static final Font KARE_ORANI_SAYAÇ_YAZI_TİPİ = new Font("Consolas", Font.PLAIN, 12);
	public static final Font OLUŞTURUCU_YÜZDESİ_YAZI_TİPİ = new Font("Consolas", Font.PLAIN, 20);
	public static final DecimalFormat OLUŞTURUCU_KİMLİĞİ_ŞEKLİ = new DecimalFormat("00");
	public static final DecimalFormat OLUŞTURUCU_YÜZDESİ_ŞEKLİ = new DecimalFormat(": %000.000");
	
	public static final Color OYUN_İÇİ_YAZI_RENGİ = new Color(1.0F, 1.0F, 0.6F, 1.0F);
	public static final Color OYUN_İÇİ_ARKAPLAN_RENGİ = new Color(0.0F, 0.0F, 0.0F, 0.7F);
	public static final Font OYUN_İÇİ_YAZI_TİPİ = new Font("Consolas", Font.PLAIN, 20);
	
	public static final Vektör2 SIFIR_VEKTÖR = new Vektör2();
	
	public static void main(String[] args) {
		GÖRSELLEŞTİRİCİ.başlık = "Kuruluş srm. " + SÜRÜM;
		GÖRSELLEŞTİRİCİ.kenarYumuşatma = true;
		GÖRSELLEŞTİRİCİ.boyut = new Vektör2(16.0F * 80.0F, 9.0F * 80.0F);
		GÖRSELLEŞTİRİCİ.girdi = GİRDİ;
		Motor.uygulama = KURULUŞ;
		Motor.görselleştirici = GÖRSELLEŞTİRİCİ;
		Motor.hedefKareOranı = 120.0F;
		Motor.başla();
	}
	
	public static int sıkıştır(int t, int alt, int üst) {
		return t < alt ? alt : t > üst ? üst : t;
	}
	
	public static float sıkıştır(float o, float alt, float üst) {
		return o < alt ? alt : o > üst ? üst : o;
	}
	
	public static Color tersRengi(Color renk) {
		return new Color(255 - renk.getRed(), 255 - renk.getGreen(), 255 - renk.getBlue());
	}
	
	public Dünya dünya;
	public Harita harita;
	public int mod;
	public Vektör2 kamera;
	public int yakınlaştırma;
	public int karoBoyutu;
	public Vektör2 üzerindeDurulanYer;
	public boolean üzerindeDurulanYerSınırlarınİçerisinde;
	public Vektör2 ekran;
	public Dikdörtgen2 ekranDörtgeni;
	public Dikdörtgen2 pikselDörtgeni;
	public Graphics2D çizer;
	public int işlemSayısı;
	public ExecutorService işlemler;
	public UlusGüncelleyici[] güncelleyiciler;
	public DünyaOluşturucu[] oluşturucular;
	public boolean haritaOluşturuldu;
	public float oluşturmaBaşlangıcı;
	
	@Override
	public void yükle() {
		final Arazi[] araziler = new Arazi[] {
			new Arazi(new Color(0.2F, 0.2F, 0.4F), 0.0F, 10.0F, 0.0F),
			new Arazi(new Color(0.4F, 0.4F, 0.7F), 0.0F, 10.0F, 0.0F),
			new Arazi(new Color(0.6F, 0.6F, 1.0F), 0.0F, 8.0F, 0.0F),
			new Arazi(new Color(0.6F, 1.0F, 0.6F), 10.0F, 1.0F, 1.0F),
			new Arazi(new Color(0.4F, 0.7F, 0.4F), 8.0F, 1.0F, 1.0F),
			new Arazi(new Color(0.2F, 0.4F, 0.2F), 5.0F, 1.0F, 1.0F),
			new Arazi(new Color(1.0F, 1.0F, 0.6F), 4.0F, 1.0F, 1.0F),
			new Arazi(new Color(0.7F, 0.7F, 0.4F), 3.0F, 1.0F, 1.0F),
			new Arazi(new Color(0.4F, 0.4F, 0.2F), 2.0F, 1.0F, 1.0F),
			new Arazi(new Color(1.0F, 0.6F, 0.6F), 1.0F, 0.5F, 5.0F),
			new Arazi(new Color(0.7F, 0.4F, 0.4F), 0.5F, 0.5F, 8.0F),
			new Arazi(new Color(0.4F, 0.2F, 0.2F), 0.1F, 0.1F, 10.0F)
		};
		for (int i = 0; i < araziler.length; i++)
			KÜTÜK.bağla("kuruluş:arazi_" + i, araziler[i]);
		oluşturmaBaşlangıcı = Motor.zaman();
		dünya = new Dünya(new Vektör2(1000.0F, 1000.0F));
		harita = new Harita(dünya);
		final Nitelik[] nitelikler = new Nitelik[] {
			new Nitelik("moral"),
			new Nitelik("vergi_geliri"),
			new Nitelik("yemek_üretimi")
		};
		for (Nitelik nitelik : nitelikler)
			KÜTÜK.bağla("kuruluş:ulus_nitelik_" + nitelik.ad, nitelik);
		final Ulus TC = new Ulus("Türkiye Cumhuriyeti");
		harita.nesneEkle(TC);
		final Değiştirici milliMücadele = new Değiştirici("Milli Mücadele");
		milliMücadele.parçalar.add(new DeğiştiriciParçası(nitelikler[0], true, 1.0F));
		milliMücadele.parçalar.add(new DeğiştiriciParçası(nitelikler[0], false, 0.2F));
		TC.bileşenAl(Değiştirilebilir.class).ekle(new SüreliDeğiştirici(milliMücadele, 900));
		işlemSayısı = 12;
		işlemler = Executors.newFixedThreadPool(işlemSayısı);
		güncelleyiciler = new UlusGüncelleyici[işlemSayısı];
		for (int i = 0; i < güncelleyiciler.length; i++)
			güncelleyiciler[i] = new UlusGüncelleyici(harita.nesneler, i, güncelleyiciler.length);
		oluşturucular = new DünyaOluşturucu[işlemSayısı];
		for (int i = 0; i < oluşturucular.length; i++) {
			oluşturucular[i] = new DünyaOluşturucu(dünya, araziler, i, (int)dünya.boyut.y * i / oluşturucular.length, (int)dünya.boyut.y * (i + 1) / oluşturucular.length);
			işlemler.execute(oluşturucular[i]);
		}
		kamera = new Vektör2();
		yakınlaştırma = YAKINLAŞTIRMA_BAŞLANGIÇ_DEĞERİ;
		boyutuHesapla();
		üzerindeDurulanYer = new Vektör2();
		ekran = new Vektör2(GÖRSELLEŞTİRİCİ.boyut);
		ekranDörtgeni = new Dikdörtgen2();
		pikselDörtgeni = new Dikdörtgen2();
		çizer = GÖRSELLEŞTİRİCİ.çizer;
	}
	
	@Override
	public void kaydet() {
	}
	
	@Override
	public void kare() {
		if (!haritaOluşturuldu) {
			boolean bitmemişOluşturucuVar = false;
			for (DünyaOluşturucu oluşturucu : oluşturucular)
				if (!oluşturucu.bitti)
					bitmemişOluşturucuVar = true;
			haritaOluşturuldu = !bitmemişOluşturucuVar;
			çizer.setFont(OLUŞTURUCU_YÜZDESİ_YAZI_TİPİ);
			final FontMetrics ölçü = çizer.getFontMetrics();
			final int yükseklik = ölçü.getHeight();
			int y = 70;
			çizer.drawString("(" + (int)dünya.boyut.x + "x" + (int)dünya.boyut.y + ") " + (dünya.karolar.length / 1000000.0F) + "m karo oluşturuluyor...", 10, y);
			çizer.drawString("Geçen süre " + (Motor.zaman() - oluşturmaBaşlangıcı) / 1000000000.0F + "s.", 10, y += yükseklik);
			float toplamYüzde = 0.0F;
			for (DünyaOluşturucu oluşturucu : oluşturucular) {
				final float p = oluşturucu.yüzde;
				final float q = 1.0F - p;
				toplamYüzde += p;
				çizer.setColor(new Color(0.4F * p + 1.0F * q, 1.0F * p + 0.4F * q, 0.4F));
				çizer.drawString("Oluşturucu " + OLUŞTURUCU_KİMLİĞİ_ŞEKLİ.format(oluşturucu.kimlik) + OLUŞTURUCU_YÜZDESİ_ŞEKLİ.format(p), 10, y += yükseklik);
			}
			final float p = toplamYüzde / oluşturucular.length;
			final float q = 1.0F - p;
			final int yatayAlan = (int)ekran.x - 20;
			çizer.setColor(new Color(0.4F * p + 1.0F * q, 1.0F * p + 0.4F * q, 0.4F));
			String toplamYüzdeYazısı = "Toplam " + OLUŞTURUCU_YÜZDESİ_ŞEKLİ.format(p);
			çizer.fillRect(10, y += yükseklik, Math.round(yatayAlan * p), yükseklik);
			çizer.setColor(tersRengi(çizer.getColor()));
			çizer.drawRect(10, y, yatayAlan, yükseklik);
			y += yükseklik - ölçü.getDescent();
			çizer.drawString(toplamYüzdeYazısı, (yatayAlan - ölçü.stringWidth(toplamYüzdeYazısı)) / 2, y);
		} else {
			boolean güncelliyor = false;
			for (UlusGüncelleyici güncelleyici : güncelleyiciler)
				if (güncelleyici.çalışıyor)
					güncelliyor = true;
			if (!güncelliyor)
				for (UlusGüncelleyici güncelleyici : güncelleyiciler)
					işlemler.execute(güncelleyici);
			if (GİRDİ.kaydırma != 0) {
				yakınlaştırma = sıkıştır(yakınlaştırma + GİRDİ.kaydırma, YAKINLAŞTIRMA_EN_DÜŞÜK_DEĞERİ, YAKINLAŞTIRMA_EN_YÜKSEK_DEĞERİ);
				final Vektör2 imleçHaritaEski = harita(GİRDİ.imleç, new Vektör2());
				boyutuHesapla();
				final Vektör2 imleçHaritaYeni = harita(GİRDİ.imleç, new Vektör2());
				kamera.çıkar(imleçHaritaYeni.çıkar(imleçHaritaEski).çarp(karoBoyutu));
			}
			if (GİRDİ.düğmeAşağı[MouseEvent.BUTTON2] || GİRDİ.tuşAşağı[KeyEvent.VK_M])
				kamera.çıkar(GİRDİ.imleçDeğişimi);
			final Vektör2 yerDeğiştirme = new Vektör2(
					GİRDİ.tuşAşağı[KeyEvent.VK_D] ? 1 : 0 - (GİRDİ.tuşAşağı[KeyEvent.VK_A] ? 1 : 0),
					GİRDİ.tuşAşağı[KeyEvent.VK_S] ? 1 : 0 - (GİRDİ.tuşAşağı[KeyEvent.VK_W] ? 1 : 0));
			final float yerDeğiştirmeUzunluğu = yerDeğiştirme.uzunluk();
			if (yerDeğiştirmeUzunluğu > 0.0F)
				kamera.topla(yerDeğiştirme.çarp(WASD_HIZI / Motor.kareOranı / yerDeğiştirmeUzunluğu));
			final Vektör2 kameraSınırı = new Vektör2();
			kameraSınırı.çarp(dünya.boyut, karoBoyutu).çıkar(ekran);
			kamera.sıkıştır(SIFIR_VEKTÖR, kameraSınırı);
			if (kameraSınırı.x < 0.0F) kamera.yazX(kameraSınırı.x / 2.0F);
			if (kameraSınırı.y < 0.0F) kamera.yazY(kameraSınırı.y / 2.0F);
			harita(GİRDİ.imleç, üzerindeDurulanYer).taban();
			üzerindeDurulanYerSınırlarınİçerisinde = içerdeMi(üzerindeDurulanYer);
			ekranDörtgeniniHesapla();
			final Vektör2 pikselKonumuTamponu = new Vektör2();
			for (int y = (int)ekranDörtgeni.k.y; y < ekranDörtgeni.b.y; y++)
				for (int x = (int)ekranDörtgeni.k.x; x < ekranDörtgeni.b.x; x++) {
					final Karo karo = dünya.karolar[dünya.endeks(x, y)];
					piksel(karo.konum, pikselKonumuTamponu);
					çizer.setColor(karo.arazi.renk);
					çizer.fillRect((int)pikselKonumuTamponu.x, (int)pikselKonumuTamponu.y, karoBoyutu, karoBoyutu);
				}
			for (Nesne nesne : harita.nesneler) {
				Görsel görsel = nesne.bileşenAl(Görsel.class);
				if (görsel != null) {
					görsel.çiz();
				}
			}
			final Stroke çizgi = çizer.getStroke();
			çizer.setColor(SINIR_RENGİ);
			çizer.setStroke(SINIR_ÇİZGİSİ);
			pikselDörtgeniniHesapla();
			pikselKonumuTamponu.yazY(0.0F);
			for (int x = (int)ekranDörtgeni.k.x; x <= ekranDörtgeni.b.x; x++) {
				piksel(pikselKonumuTamponu.yazX(x));
				çizer.drawLine((int)pikselKonumuTamponu.x, (int)pikselDörtgeni.k.y, (int)pikselKonumuTamponu.x, (int)pikselDörtgeni.b.y);
			}
			pikselKonumuTamponu.yazX(0.0F);
			for (int y = (int)ekranDörtgeni.k.y; y <= ekranDörtgeni.b.y; y++) {
				piksel(pikselKonumuTamponu.yazY(y));
				çizer.drawLine((int)pikselDörtgeni.k.x, (int)pikselKonumuTamponu.y, (int)pikselDörtgeni.b.x, (int)pikselKonumuTamponu.y);
			}
			if (üzerindeDurulanYerSınırlarınİçerisinde) {
				if (GİRDİ.düğmeBasıldı[MouseEvent.BUTTON1]) {
					Ulus TC = (Ulus)harita.nesneler.get(0);
					Karo karo = dünya.karolar[dünya.endeks(üzerindeDurulanYer)];
					Yapı şehir = new Yapı(TC, karo, new DeğiştiriciParçası(KÜTÜK.ara("kuruluş:ulus_nitelik_vergi_geliri", Nitelik.class), true, 1.0F));
					TC.yapılar.add(şehir);
					harita.nesneEkle(şehir);
				}
				piksel(üzerindeDurulanYer, pikselKonumuTamponu);
				çizer.setColor(ÜSTÜNDE_DURMA_RENGİ);
				çizer.setStroke(ÜSTÜNDE_DURMA_ÇİZGİSİ);
				çizer.drawRect((int)pikselKonumuTamponu.x, (int)pikselKonumuTamponu.y, karoBoyutu, karoBoyutu);
			}
			çizer.setStroke(çizgi);
			çizer.setFont(OYUN_İÇİ_YAZI_TİPİ);
			çizer.setColor(OYUN_İÇİ_YAZI_RENGİ);
			final Değiştirilebilir TCdeğiştirilebilir = harita.nesneler.get(0).bileşenAl(Değiştirilebilir.class);
			final List<String> yazılar = new ArrayList<>(TCdeğiştirilebilir.nicelikler.size() + 1);
			yazılar.add("Türkiye Cumhuriyeti");
			for (final Nicelik nicelik : TCdeğiştirilebilir.nicelikler.values()) {
				yazılar.add(nicelik.nitelik.ad + ": " + nicelik.değer());
			}
			final String[] yazıDizisi = new String[yazılar.size()];
			for (int i = 0; i < yazıDizisi.length; i++)
				yazıDizisi[i] = yazılar.get(i);
			yazıYaz(10, 50, OYUN_İÇİ_ARKAPLAN_RENGİ, yazıDizisi);
		}
		çizer.setFont(KARE_ORANI_SAYAÇ_YAZI_TİPİ);
		çizer.setColor(KARE_ORANI_SAYAÇ_RENGİ);
		yazıYaz(10, 10, KARE_ORANI_ARKAPLAN_RENGİ,
				"Kare Oranı: " + Motor.kareOranı,
				"Bellek: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024.0F / 1024.0F + "/" + Runtime.getRuntime().totalMemory() / 1024.0F / 1024.0F + " MB");
	}
	
	@Override
	public void saniye() {
	}
	
	public void yazıYaz(final int x, int y, final Color arkaplan, final String... yazılar) {
		final FontMetrics ölçü = çizer.getFontMetrics();
		final int yükseklik = ölçü.getHeight();
		final int arkaplanFazlası = Math.round(yükseklik * 0.1F);
		final Color renk = çizer.getColor();
		for (final String yazı : yazılar) {
			if (arkaplan != null) {
				final int yazıGenişliği = ölçü.stringWidth(yazı);
				çizer.setColor(arkaplan);
				çizer.fillRect(x - arkaplanFazlası, y, yazıGenişliği + arkaplanFazlası * 2, yükseklik);
				çizer.setColor(renk);
			}
			y += yükseklik;
			çizer.drawString(yazı, x, y - ölçü.getDescent());
		}
	}
	
	public void boyutuHesapla() {
		karoBoyutu = (int)Math.round(Math.pow(YAKINLAŞTIRMA_TABANI, yakınlaştırma));
	}
	
	public void ekranDörtgeniniHesapla() {
		harita(SIFIR_VEKTÖR, ekranDörtgeni.k).taban().büyüktür(SIFIR_VEKTÖR);
		harita(ekran, ekranDörtgeni.b).tavan().küçüktür(dünya.boyut);
	}
	
	public void pikselDörtgeniniHesapla() {
		piksel(ekranDörtgeni.k, pikselDörtgeni.k);
		piksel(ekranDörtgeni.b, pikselDörtgeni.b);
	}
	
	public Vektör2 harita(Vektör2 piksel, Vektör2 harita) {
		return harita.topla(piksel, kamera).böl(karoBoyutu);
	}
	
	public Vektör2 harita(Vektör2 v) {
		return harita(v, v);
	}
	
	public Vektör2 piksel(Vektör2 harita, Vektör2 piksel) {
		return piksel.çarp(harita, karoBoyutu).çıkar(kamera);
	}
	
	public Vektör2 piksel(Vektör2 v) {
		return piksel(v, v);
	}
	
	public boolean içerdeMi(Vektör2 konum) {
		return konum.x >= 0.0F && konum.y >= 0.0F && konum.x < dünya.boyut.x && konum.y < dünya.boyut.y;
	}
}
