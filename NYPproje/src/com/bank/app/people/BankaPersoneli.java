package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;


public class BankaPersoneli extends Kisi {
    private String personelID;
    private ArrayList<Musteri> musteriler;
    
    public BankaPersoneli(String ad, String soyad, String email, long telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        
        //  istenen otomatik personel ID üretimi burada yapılır
        Random id = new Random();
        int Randomid = id.nextInt(900000) + 100000; // 6 haneli rastgele sayı üretir
        this.personelID = String.valueOf(Randomid);
        
        // Müşterileri ekleyebilmek için ArrayList nesnesi bellekte oluşturulur
        this.musteriler = new ArrayList<>();
    }

    // private değişken olan personelID değerini döndürür
    public String getPersonelID() {
        return personelID;
    }

    public void setPersonelID(String personelID) {
        this.personelID = personelID;
    }

    // Personelin sorumlu olduğu müşteri listesine erişim sağlar
    public ArrayList<Musteri> getMusteriler() {
        return musteriler;
    }

    // Müşteri listesini toplu olarak güncellemek için kullanılır
    public void setMusteriler(ArrayList<Musteri> musteriler) {
        this.musteriler = musteriler;
    }
    
    // Kisi sınıfındaki toString metodunun üzerine personel ID bilgisini de ekleyerek yazdırır
    @Override
    public String toString() {
        return super.toString() + ", Personel ID: " + personelID;
    }
}
