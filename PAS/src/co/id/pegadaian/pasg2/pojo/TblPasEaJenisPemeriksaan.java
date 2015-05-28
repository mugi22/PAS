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
@Table(name = "TBL_PAS_EA_JENIS_PEMERIKSAAN", schema = "PASG2")
public class TblPasEaJenisPemeriksaan extends AuditTrail implements
		java.io.Serializable {
	private String kodeJenisPemeriksaan;
	private String namaJenisPemeriksaan;
	private String keteranganJenisPemeriksaan;
	private String status;

	public TblPasEaJenisPemeriksaan() {
	}

	@Id
	@Column(name = "KODE_JENIS_PEMERIKSAAN", unique = true, nullable = false, length = 4, scale = 0)
	public String getKodeJenisPemeriksaan() {
		return this.kodeJenisPemeriksaan;
	}

	public void setKodeJenisPemeriksaan(String kodeJenisPemeriksaan) {
		this.kodeJenisPemeriksaan = kodeJenisPemeriksaan;
	}

	@Column(name = "NAMA_JENIS_PEMERIKSAAN", unique = false, nullable = true, length = 64, scale = 0)
	public String getNamaJenisPemeriksaan() {
		return this.namaJenisPemeriksaan;
	}

	public void setNamaJenisPemeriksaan(String namaJenisPemeriksaan) {
		this.namaJenisPemeriksaan = namaJenisPemeriksaan;
	}

	@Column(name = "KETERANGAN_JENIS_PEMERIKSAAN", unique = false, nullable = true, length = 256, scale = 0)
	public String getKeteranganJenisPemeriksaan() {
		return this.keteranganJenisPemeriksaan;
	}

	public void setKeteranganJenisPemeriksaan(String keteranganJenisPemeriksaan) {
		this.keteranganJenisPemeriksaan = keteranganJenisPemeriksaan;
	}

	@Column(name = "STATUS", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}