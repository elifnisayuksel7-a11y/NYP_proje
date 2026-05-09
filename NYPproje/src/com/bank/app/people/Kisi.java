package com.bank.app.people;


public class Kisi {
	private String ad;
	private String soyad;
	private String email;
	// int veri tipinde hata aldığım için long kullandım
	private long telefonNumarasi;

	public Kisi(String ad , String soyad , String email , long telefonNumarasi ) {
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
		this.telefonNumarasi = telefonNumarasi;
	}

	// Getter ve Setter metotları
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefonNumarasi() {
		return telefonNumarasi;
	}

	public void setTelefonNumarasi(long telefonNumarasi) {
		this.telefonNumarasi = telefonNumarasi;
	}
	
	// Kişi bilgilerini formatlı bir şekilde çıktı vermek için kullanılır.
	@Override
	public String toString() {
        return "Ad: " + ad +  ", Soyad: " + soyad +  ", Email: " + email +  ", Telefon: " + telefonNumarasi;
    }
}