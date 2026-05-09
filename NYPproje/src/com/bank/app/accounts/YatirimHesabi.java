package com.bank.app.accounts;


public class YatirimHesabi extends BankaHesabi {

    // Yatırım hesabına para girişi sağlayan metot
    public void paraEkle(double miktar) {
        // Miktarın pozitif olup olmadığı kontrol ediliyor
        if (miktar > 0) {
            setBakiye(getBakiye() + miktar);
            
            System.out.println("[Yatırım Hesabı] " + miktar + " TL para yatırma işlemi başarılı. Güncel bakiye: " + getBakiye());
        }
        else {
            System.out.println("Hata: Yatırılacak tutar negatif veya sıfır olamaz!");
        }
    }

    // Yatırım hesabından para çekilmesini sağlayan metot
    public void paraCek(double miktar) {
        // Bakiyenin çekilmek istenen tutara yetip yetmediği kontrol edilir
        if (getBakiye() >= miktar) {
            setBakiye(getBakiye() - miktar);
            
            System.out.println("[Yatırım Hesabı] " + miktar + " TL çekim yapıldı. Kalan bakiyeniz: " + getBakiye());
        } else {
            // Yetersiz bakiye durumunda kullanıcıya hata mesajı basılır
            System.out.println("[Yatırım Hesabı] Hata: Bakiyeniz yetersiz. İşlem gerçekleştirilemedi.");
        }
    }
}