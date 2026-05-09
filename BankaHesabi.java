package com.bank.app.accounts;

import java.util.Random;


public class BankaHesabi {
    private String iban;
    
    private double bakiye;

    public BankaHesabi() {
        // Rastgele numara üretimi için Random sınıfından nesne üretir
        Random randomiban = new Random();
        
        //  istenen "otomatik türetme" kuralına uygun olarak rastgele IBAN oluşturur
        this.iban = "TR" + (10000000 + (long)(randomiban.nextDouble() * 90000000));
        
        // Yeni açılan hesabın başlangıç bakiyesi 0 olarak atanır
        this.bakiye = 0.0;
    }

    // getter ve setter metotları
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    // Hesap bilgilerini düzenli bir metin olarak döndürmek için toString metodu override edildi
    @Override
    public String toString() {
        return "IBAN: " + iban + " | Bakiye: " + bakiye + " TL";
    }
}