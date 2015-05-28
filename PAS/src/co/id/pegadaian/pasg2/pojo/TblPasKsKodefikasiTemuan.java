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
@Table(name = "TBL_PAS_KS_KODIFIKASI_TEMUAN", schema = "PASG2")
public class TblPasKsKodefikasiTemuan extends AuditTrail implements
		java.io.Serializable {
	private String kodeJenisPemeriksaan;
	private String kodeAspekPemeriksaan;
	private String kodeTemuan;
	private String namaTemuan;
	private String kdParent;
	private String status;

	public TblPasKsKodefikasiTemuan() {
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
	@Column(name = "KODE_ASPEK_PEMERIKSAAN", unique = false, nullable = false, length = 4, scale = 0)
	public String getKodeAspekPemeriksaan() {
		return this.kodeAspekPemeriksaan;
	}

	public void setKodeAspekPemeriksaan(String kodeAspekPemeriksaan) {
		this.kodeAspekPemeriksaan = kodeAspekPemeriksaan;
	}

	@Id
	@Column(name = "KODE_TEMUAN", unique = false, nullable = false, length = 4, scale = 0)
	public String getKodeTemuan() {
		return this.kodeTemuan;
	}

	public void setKodeTemuan(String kodeTemuan) {
		this.kodeTemuan = kodeTemuan;
	}

	@Column(name = "NAMA_TEMUAN", unique = false, nullable = true, length = 128, scale = 0)
	public String getNamaTemuan() {
		return this.namaTemuan;
	}

	public void setNamaTemuan(String namaTemuan) {
		this.namaTemuan = namaTemuan;
	}

	@Column(name = "KD_PARENT", unique = false, nullable = true, length = 8, scale = 0)
	public String getKdParent() {
		return this.kdParent;
	}

	public void setKdParent(String kdParent) {
		this.kdParent = kdParent;
	}

	@Column(name = "STATUS", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}