package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import java.util.ArrayList;
import java.util.Random;


public class Musteri extends Kisi {
    private String musteriNumarasi;
    // Müşterinin birden fazla hesabı ve kartı olabileceği için ArrayList kullanıldı.
    private ArrayList<BankaHesabi> hesaplar;
    private ArrayList<KrediKarti> krediKartlari;

    public Musteri(String ad, String soyad, String email, long telefonNumarasi) {
        // Üst sınıf olan Kisi'nin constructor'ını çağırarak temel bilgileri atar.
        super(ad, soyad, email, telefonNumarasi);
        
        //  istenen otomatik müşteri numarası üretimi (6 haneli).
        Random rmusteri = new Random();
        this.musteriNumarasi = String.valueOf(rmusteri.nextInt(900000) + 100000);
        
        // Listeler constructor içinde başlatılarak NullPointerException hatası engellenir.
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    // Girilen tür bilgisine göre ilgili hesap nesnesini oluşturup listeye ekler.
    public void hesapEkle(String hesapTuru) {
        if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
            hesaplar.add(new VadesizHesap());
        } else if (hesapTuru.equalsIgnoreCase("Yatirim")) {
            hesaplar.add(new YatirimHesabi());
        }
    }

    // Müşteriye yeni bir kredi kartı tanımlar.
    public void krediKartiEkle(double limit) {
        krediKartlari.add(new KrediKarti(limit));
    }

    /**
     * Dökümandaki "Bakiyesi olan hesap silinemez" kuralını kontrol eden metot.
     */
    public void hesapSil(BankaHesabi hesap) {
        if (hesap.getBakiye() > 0) {
            // Eğer hesapta para varsa silme işlemini reddeder.
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
        } else {
            hesaplar.remove(hesap);
            System.out.println("Hesap başarıyla silindi.");
        }
    }

    /**
     * Dökümandaki "Borcu olan kart silinemez" kuralını kontrol eden metot.
     */
    public void krediKartiSil(KrediKarti kredi) {
        if (kredi.getGuncelBorc() == 0) {
            // Borç tamamen kapandıysa kartı listeden çıkarır.
            krediKartlari.remove(kredi);
            System.out.println("Kredi kartı başarıyla silindi.");
        } else {
            System.out.println("lütfen öncelikle borç ödemesi yapınız");
        }
    }

    // Getter ve Setter metotları
    public String getMusteriNumarasi() {
        return musteriNumarasi;
    }

    public void setMusteriNumarasi(String musteriNumarasi) {
        this.musteriNumarasi = musteriNumarasi;
    }

    public ArrayList<BankaHesabi> getHesaplar() {
        return hesaplar;
    }

    public void setHesaplar(ArrayList<BankaHesabi> hesaplar) {
        this.hesaplar = hesaplar;
    }

    public ArrayList<KrediKarti> getKrediKartlari() {
        return krediKartlari;
    }

    public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) {
        this.krediKartlari = krediKartlari;
    }

    // Üst sınıftan gelen bilgilerin yanına müşteri numarasını ekleyerek yazdırır.
    @Override
    public String toString() {
        return super.toString() + ", Müşteri No: " + musteriNumarasi;
    }
}