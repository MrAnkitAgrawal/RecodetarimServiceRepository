package com.techie.recodetarim.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cari")
public class Cari implements Serializable {
	private static final long serialVersionUID = 435499386071061769L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "carikod")
	private String carikod;

	@Column(name = "cariaciklama")
	private String cariaciklama;

	@Column(name = "adres1")
	private String adres1;

	@Column(name = "adres2")
	private String adres2;

	@Column(name = "il")
	private String il;

	@Column(name = "ilce")
	private String ilce;

	@Column(name = "vergiDairesi")
	private String vergiDairesi;

	@Column(name = "vergiNo")
	private String vergiNo;

	@Column(name = "anaGrup")
	private String anaGrup;

	@Column(name = "altGrup")
	private String altGrup;

	@Column(name = "telefon1")
	private String telefon1;

	@Column(name = "telefon2")
	private String telefon2;

	@Column(name = "faks")
	private String faks;

	@Column(name = "mail")
	private String mail;

	@Column(name = "web")
	private String web;

	@Column(name = "aktifPasifDurum")
	private int aktifPasifDurum;

	@Column(name = "hazirlayan")
	private String hazirlayan;

	@Column(name = "iskonto")
	private double iskonto;

	@Column(name = "telefon3")
	private String telefon3;

	@Column(name = "sirket")
	private String sirket;

	@Column(name = "adres3")
	private String adres3;

	@Column(name = "musteriTemsilcisi")
	private String musteriTemsilcisi;

	@Column(name = "terminGunSayi")
	private int terminGunSayi;

	@Column(name = "cariDoviz")
	private String cariDoviz;

	@Column(name = "muhasebeKod")
	private String muhasebeKod;

	@Column(name = "vergiDairesiKod")
	private String vergiDairesiKod;

	@Column(name = "muhasebeCariKod")
	private String muhasebeCariKod;

	@Column(name = "mail1")
	private String mail1;

	@Column(name = "logoDurum")
	private String logoDurum;

	@Column(name = "uretimFazlaDurum")
	private String uretimFazlaDurum;

	@Column(name = "efaturaDurum")
	private int efaturaDurum;

	@Column(name = "musteriNo")
	private int musteriNo;

	@Column(name = "musteriTip")
	private int musteriTip;

	@Column(name = "fire_oran")
	private double fireOran;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarikod() {
		return carikod;
	}

	public void setCarikod(String carikod) {
		this.carikod = carikod;
	}

	public String getCariaciklama() {
		return cariaciklama;
	}

	public void setCariaciklama(String cariaciklama) {
		this.cariaciklama = cariaciklama;
	}

	public String getAdres1() {
		return adres1;
	}

	public void setAdres1(String adres1) {
		this.adres1 = adres1;
	}

	public String getAdres2() {
		return adres2;
	}

	public void setAdres2(String adres2) {
		this.adres2 = adres2;
	}

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public String getIlce() {
		return ilce;
	}

	public void setIlce(String ilce) {
		this.ilce = ilce;
	}

	public String getVergiDairesi() {
		return vergiDairesi;
	}

	public void setVergiDairesi(String vergiDairesi) {
		this.vergiDairesi = vergiDairesi;
	}

	public String getVergiNo() {
		return vergiNo;
	}

	public void setVergiNo(String vergiNo) {
		this.vergiNo = vergiNo;
	}

	public String getAnaGrup() {
		return anaGrup;
	}

	public void setAnaGrup(String anaGrup) {
		this.anaGrup = anaGrup;
	}

	public String getAltGrup() {
		return altGrup;
	}

	public void setAltGrup(String altGrup) {
		this.altGrup = altGrup;
	}

	public String getTelefon1() {
		return telefon1;
	}

	public void setTelefon1(String telefon1) {
		this.telefon1 = telefon1;
	}

	public String getTelefon2() {
		return telefon2;
	}

	public void setTelefon2(String telefon2) {
		this.telefon2 = telefon2;
	}

	public String getFaks() {
		return faks;
	}

	public void setFaks(String faks) {
		this.faks = faks;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public int getAktifPasifDurum() {
		return aktifPasifDurum;
	}

	public void setAktifPasifDurum(int aktifPasifDurum) {
		this.aktifPasifDurum = aktifPasifDurum;
	}

	public String getHazirlayan() {
		return hazirlayan;
	}

	public void setHazirlayan(String hazirlayan) {
		this.hazirlayan = hazirlayan;
	}

	public double getIskonto() {
		return iskonto;
	}

	public void setIskonto(double iskonto) {
		this.iskonto = iskonto;
	}

	public String getTelefon3() {
		return telefon3;
	}

	public void setTelefon3(String telefon3) {
		this.telefon3 = telefon3;
	}

	public String getSirket() {
		return sirket;
	}

	public void setSirket(String sirket) {
		this.sirket = sirket;
	}

	public String getAdres3() {
		return adres3;
	}

	public void setAdres3(String adres3) {
		this.adres3 = adres3;
	}

	public String getMusteriTemsilcisi() {
		return musteriTemsilcisi;
	}

	public void setMusteriTemsilcisi(String musteriTemsilcisi) {
		this.musteriTemsilcisi = musteriTemsilcisi;
	}

	public int getTerminGunSayi() {
		return terminGunSayi;
	}

	public void setTerminGunSayi(int terminGunSayi) {
		this.terminGunSayi = terminGunSayi;
	}

	public String getCariDoviz() {
		return cariDoviz;
	}

	public void setCariDoviz(String cariDoviz) {
		this.cariDoviz = cariDoviz;
	}

	public String getMuhasebeKod() {
		return muhasebeKod;
	}

	public void setMuhasebeKod(String muhasebeKod) {
		this.muhasebeKod = muhasebeKod;
	}

	public String getVergiDairesiKod() {
		return vergiDairesiKod;
	}

	public void setVergiDairesiKod(String vergiDairesiKod) {
		this.vergiDairesiKod = vergiDairesiKod;
	}

	public String getMuhasebeCariKod() {
		return muhasebeCariKod;
	}

	public void setMuhasebeCariKod(String muhasebeCariKod) {
		this.muhasebeCariKod = muhasebeCariKod;
	}

	public String getMail1() {
		return mail1;
	}

	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}

	public String getLogoDurum() {
		return logoDurum;
	}

	public void setLogoDurum(String logoDurum) {
		this.logoDurum = logoDurum;
	}

	public String getUretimFazlaDurum() {
		return uretimFazlaDurum;
	}

	public void setUretimFazlaDurum(String uretimFazlaDurum) {
		this.uretimFazlaDurum = uretimFazlaDurum;
	}

	public int getEfaturaDurum() {
		return efaturaDurum;
	}

	public void setEfaturaDurum(int efaturaDurum) {
		this.efaturaDurum = efaturaDurum;
	}

	public int getMusteriNo() {
		return musteriNo;
	}

	public void setMusteriNo(int musteriNo) {
		this.musteriNo = musteriNo;
	}

	public int getMusteriTip() {
		return musteriTip;
	}

	public void setMusteriTip(int musteriTip) {
		this.musteriTip = musteriTip;
	}

	public double getFireOran() {
		return fireOran;
	}

	public void setFireOran(double fireOran) {
		this.fireOran = fireOran;
	}

	@Override
	public String toString() {
		return "Cari [id=" + id + ", carikod=" + carikod + ", cariaciklama=" + cariaciklama + ", adres1=" + adres1
				+ ", adres2=" + adres2 + ", il=" + il + ", ilce=" + ilce + ", vergiDairesi=" + vergiDairesi
				+ ", vergiNo=" + vergiNo + ", anaGrup=" + anaGrup + ", altGrup=" + altGrup + ", telefon1=" + telefon1
				+ ", telefon2=" + telefon2 + ", faks=" + faks + ", mail=" + mail + ", web=" + web + ", aktifPasifDurum="
				+ aktifPasifDurum + ", hazirlayan=" + hazirlayan + ", iskonto=" + iskonto + ", telefon3=" + telefon3
				+ ", sirket=" + sirket + ", adres3=" + adres3 + ", musteriTemsilcisi=" + musteriTemsilcisi
				+ ", terminGunSayi=" + terminGunSayi + ", cariDoviz=" + cariDoviz + ", muhasebeKod=" + muhasebeKod
				+ ", vergiDairesiKod=" + vergiDairesiKod + ", muhasebeCariKod=" + muhasebeCariKod + ", mail1=" + mail1
				+ ", logoDurum=" + logoDurum + ", uretimFazlaDurum=" + uretimFazlaDurum + ", efaturaDurum="
				+ efaturaDurum + ", musteriNo=" + musteriNo + ", musteriTip=" + musteriTip + ", fireOran=" + fireOran
				+ "]";
	}
}
