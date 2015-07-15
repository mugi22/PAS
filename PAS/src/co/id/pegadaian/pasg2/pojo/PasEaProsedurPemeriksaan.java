package co.id.pegadaian.pasg2.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PAS_EA_PROSEDUR_PEMERIKSAAN", schema = "PASG2")
public class PasEaProsedurPemeriksaan extends AuditTrail implements	java.io.Serializable {
	private String kodeJenisPemeriksaan;
	private String kodeAspekPemeriksaan;
	private String kodePemeriksaan;
	private String caraPemeriksaan;
	private String kriteria;
	private String petunjukPemeriksaan;
	private String namaFileTemplateKKP;
	private String fileTemplateKKP;
	private String tkResikoAsptekTerperiksa;

	public PasEaProsedurPemeriksaan() {
	}

	@Id
	@Column(name = "KODE_JENIS_PEMERIKSAAN", unique = false, nullable = false, length = 4, scale = 0)
	public String getKodeJenisPemeriksaan() {
		return this.kodeJenisPemeriksaan;
	}

	public void setKodeJenisPemeriksaan(String kodeJenisPemeriksaan) {
		this.kodeJenisPemeriksaan = kodeJenisPemeriksaan;
	}

	@Id
	@Column(name = "KODE_ASPEK_PEMERIKSAAN", unique = false, nullable = true, length = 8, scale = 0)
	public String getKodeAspekPemeriksaan() {
		return this.kodeAspekPemeriksaan;
	}

	public void setKodeAspekPemeriksaan(String kodeAspekPemeriksaan) {
		this.kodeAspekPemeriksaan = kodeAspekPemeriksaan;
	}

	@Id
	@Column(name = "KODE_PEMERIKSAAN", unique = false, nullable = true, length = 8, scale = 0)
	public String getKodePemeriksaan() {
		return this.kodePemeriksaan;
	}

	public void setKodePemeriksaan(String kodePemeriksaan) {
		this.kodePemeriksaan = kodePemeriksaan;
	}

	@Column(name = "CARA_PEMERIKSAAN", unique = false, nullable = true, length = 256, scale = 0)
	public String getCaraPemeriksaan() {
		return this.caraPemeriksaan;
	}

	public void setCaraPemeriksaan(String caraPemeriksaan) {
		this.caraPemeriksaan = caraPemeriksaan;
	}

	@Column(name = "KRITERIA", unique = false, nullable = true, length = 256, scale = 0)
	public String getKriteria() {
		return this.kriteria;
	}

	public void setKriteria(String kriteria) {
		this.kriteria = kriteria;
	}

	@Column(name = "PETUNJUK_PEMERIKSAAN", unique = false, nullable = true, length = 256, scale = 0)
	public String getPetunjukPemeriksaan() {
		return this.petunjukPemeriksaan;
	}

	public void setPetunjukPemeriksaan(String petunjukPemeriksaan) {
		this.petunjukPemeriksaan = petunjukPemeriksaan;
	}

	@Column(name = "NAMA_FILE_TEMPLATE_KKP", unique = false, nullable = true, length = 64, scale = 0)
	public String getNamaFileTemplateKKP() {
		return this.namaFileTemplateKKP;
	}

	public void setNamaFileTemplateKKP(String namaFileTemplateKKP) {
		this.namaFileTemplateKKP = namaFileTemplateKKP;
	}

	@Column(name = "FILE_TEMPLATE_KKP", unique = false, nullable = true, length = 256, scale = 0)
	public String getFileTemplateKKP() {
		return this.fileTemplateKKP;
	}

	public void setFileTemplateKKP(String fileTemplateKKP) {
		this.fileTemplateKKP = fileTemplateKKP;
	}

	@Column(name = "TK_RESIKO_ASPTEK_TERPERIKSA", unique = false, nullable = true, length = 8, scale = 0)
	public String getTkResikoAsptekTerperiksa() {
		return this.tkResikoAsptekTerperiksa;
	}

	public void setTkResikoAsptekTerperiksa(String tkResikoAsptekTerperiksa) {
		this.tkResikoAsptekTerperiksa = tkResikoAsptekTerperiksa;
	}

}