package com.bank.app.cards;

import java.util.Random;


public class KrediKarti {
    private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    public KrediKarti(double limit) {
        this.limit = limit;
        this.guncelBorc = 0.0; // Kart ilk alındığında borç sıfırdır.
        this.kullanilabilirLimit = limit; // Başlangıçta kullanılabilir limit, kartın limitine eşittir.
        
        //  istenen 16 haneli rastgele kart numarası üretimi.
        Random randomno = new Random();
        this.kartNumarasi = ""; 
        for (int i = 0; i < 16; i++) {
            // Döngü her döndüğünde 0-9 arası bir rakam ekleyerek numarayı tamamlar.
            this.kartNumarasi += randomno.nextInt(10);
        }
    }

    // Karttan harcama yapıldığında limit ve borç durumunu güncelleyen metot.
    public void alisverisYap(double miktar) {
        // Harcama yapmadan önce limit kontrolü yapılır.
        if (this.kullanilabilirLimit >= miktar) {
            this.kullanilabilirLimit -= miktar; // Kullanılabilir limit azalır.
            this.guncelBorc += miktar;         // Borç miktarı artar.
            System.out.println(miktar + " TL tutarında alışveriş yapıldı");
        } 
        else {
            System.out.println("Yetersiz limit! " + " Alışveriş yapılamadı");
        }
    }

    // Kart borcu ödendiğinde limitleri tekrar açan metot.
    public void borcOde(double miktar) {
        if (miktar > 0) {
            this.guncelBorc -= miktar;         // Borç azalır.
            this.kullanilabilirLimit += miktar; // Kullanılabilir limit tekrar artar.
            System.out.println(miktar + " TL borç ödemesi yapıldı");
        }
    }

    // Getter ve Setter metotları.
    public String getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(String kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
        // Limit değiştiğinde kullanılabilir limit de güncel borca göre yeniden hesaplanır.
        this.kullanilabilirLimit = limit - guncelBorc;
    }

    public double getGuncelBorc() {
        return guncelBorc;
    }

    public void setGuncelBorc(double guncelBorc) {
        this.guncelBorc = guncelBorc;
    }

    public double getKullanilabilirLimit() {
        return kullanilabilirLimit;
    }

    public void setKullanilabilirLimit(double kullanilabilirLimit) {
        this.kullanilabilirLimit = kullanilabilirLimit;
    }

    // Kart bilgilerini ve son durumu özetleyen metot.
    @Override
    public String toString() {
        return "Kart No: " + kartNumarasi + " | Borç: " + guncelBorc + " TL | Kullanılabilir Limit: " + kullanilabilirLimit + " TL";
    }
}