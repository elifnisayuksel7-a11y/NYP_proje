package com.bank.app.main;

import com.bank.app.people.*;
import com.bank.app.accounts.*;
import com.bank.app.cards.*;
import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. PERSONEL KAYDI
        System.out.println("********** BANKA YÖNETİM SİSTEMİ **********");
        System.out.println("--- Personel Giriş Paneli ---");
        System.out.print("Personel Adı: ");
        String pAd = scanner.nextLine();
        System.out.print("Personel Soyadı: ");
        String pSoyad = scanner.nextLine();
        System.out.print("Email: ");
        String pEmail = scanner.nextLine();
        System.out.print("Telefon: ");
        long pTel = scanner.nextLong();
        scanner.nextLine(); 

        BankaPersoneli personel = new BankaPersoneli(pAd, pSoyad, pEmail, pTel);
        System.out.println("\n Personel Girişi Başarılı.");
        System.out.println(personel.toString());

        // 2. MÜŞTERİ KAYDI
        System.out.println("\n--- Yeni Müşteri Kayıt Paneli ---");
        System.out.print("Müşteri Adı: ");
        String mAd = scanner.nextLine();
        System.out.print("Müşteri Soyadı: ");
        String mSoyad = scanner.nextLine();
        System.out.print("Email: ");
        String mEmail = scanner.nextLine();
        System.out.print("Telefon: ");
        long mTel = scanner.nextLong();
        scanner.nextLine(); 

        Musteri yeniMusteri = new Musteri(mAd, mSoyad, mEmail, mTel);
        personel.getMusteriler().add(yeniMusteri);
        System.out.println("\n Müşteri Başarıyla Kaydedildi.");
        System.out.println(yeniMusteri.toString());

        // 3. HESAP İŞLEMLERİ VE PARA YATIRMA
        yeniMusteri.hesapEkle("Vadesiz");
        yeniMusteri.hesapEkle("Yatirim");
        VadesizHesap vadesiz = (VadesizHesap) yeniMusteri.getHesaplar().get(0);
        YatirimHesabi yatirim = (YatirimHesabi) yeniMusteri.getHesaplar().get(1);

        System.out.println("\n--- Bakiye İşlemleri ---");
        System.out.print("Yatırım hesabına yatırılacak tutar: ");
        double yatirimMiktar = scanner.nextDouble();
        yatirim.paraEkle(yatirimMiktar);

        System.out.print("Vadesiz hesaba yatırılacak tutar: ");
        double vadesizMiktar = scanner.nextDouble();
        vadesiz.setBakiye(vadesizMiktar);

        // 4. PARA TRANSFERİ (Dinamik Miktar)
        System.out.println("\n--- Transfer İşlemi ---");
        System.out.print("Vadesizden Yatırıma aktarılacak miktar: ");
        double transferMiktar = scanner.nextDouble();
        vadesiz.paraTransferi(yatirim, vadesiz, transferMiktar); 

        // 5. KREDİ KARTI VE HARCAMA
        System.out.println("\n--- Kredi Kartı İşlemleri ---");
        System.out.print("Kredi kartı limiti ne kadar olsun?: ");
        double kartLimit = scanner.nextDouble();
        yeniMusteri.krediKartiEkle(kartLimit);
        KrediKarti kart = yeniMusteri.getKrediKartlari().get(0);

        System.out.print("Yapılacak alışveriş tutarı: ");
        double harcama = scanner.nextDouble();
        kart.alisverisYap(harcama);
        
        System.out.println("\n Borç Ödeme Deneniyor...");
        vadesiz.krediKartiBorcOde(kart, harcama);

        // 6. HESAP SİLME
        System.out.println("\n--- Hesap Silme İşlemi ---");
        System.out.println("Bakiyesi olan " + yatirim.getIban() + " siliniyor...");
        yeniMusteri.hesapSil(yatirim); 
        
        System.out.println("Bakiyesi 0 olan yeni bir hesap açılıp siliniyor...");
        yeniMusteri.hesapEkle("Vadesiz");
        VadesizHesap silinecek = (VadesizHesap) yeniMusteri.getHesaplar().get(2);
        yeniMusteri.hesapSil(silinecek);

        // 7. GÜNCEL DURUM ÖZETİ
        System.out.println("\n--- Güncel Durum Özeti ---");
        System.out.println(vadesiz.toString());
        System.out.println(yatirim.toString());
        System.out.println(kart.toString());

        System.out.println("\n********** İŞLEMLER TAMAMLANDI **********");
        scanner.close();
    }
}