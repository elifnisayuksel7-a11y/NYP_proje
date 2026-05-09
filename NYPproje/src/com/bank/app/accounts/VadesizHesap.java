package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;

public class VadesizHesap extends BankaHesabi {

    public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) {
        // Negatif miktar kontrolü
        if (miktar <= 0) {
            System.out.println("Hata: Transfer edilecek tutar negatif veya sıfır olamaz!");
            return; // Metodu burada sonlandırır, işleme devam etmez
        }

        if (gonderenHesap.getBakiye() >= miktar) {
            gonderenHesap.setBakiye(gonderenHesap.getBakiye() - miktar);
            aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
            System.out.println("[Vadesiz Hesap] Transfer başarılı. Alıcı IBAN: " + aliciHesap.getIban());
        } else {
            System.out.println("[Vadesiz Hesap] Hata: Gönderen hesabın bakiyesi yetersiz!");
        }
    }

    public void krediKartiBorcOde(KrediKarti kart, double miktar) {
        // Negatif miktar kontrolü
        if (miktar <= 0) {
            System.out.println("Hata: Ödenecek borç tutarı negatif veya sıfır olamaz!");
            return; 
        }

        if (this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar);
            kart.borcOde(miktar);
            System.out.println("[Vadesiz Hesap] Kart borcunuz başarıyla ödendi.");
        } else {
            System.out.println("[Vadesiz Hesap] Hata: Hesabınızda borç ödemesi için yeterli bakiye bulunmamaktadır.");
        }
    }
}