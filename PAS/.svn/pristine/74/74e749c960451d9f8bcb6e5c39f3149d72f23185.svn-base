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
@Table(name = "PAS_EA_ASPEK_PEMERIKSAAN", schema = "PASG2")
public class PasEaAspekPemeriksaan extends AuditTrail implements java.io.Serializable {
	private String kodeJenisPemeriksaan;
	private String kodeAspekPemeriksaan;
	private String namaAspekPemeriksaan;
	private String keteranganAspekPemeriksaan;
	private String tujuanAspekPemeriksaan;
	private String kdParent;
	private String status;
	private char HavaChild;

	public PasEaAspekPemeriksaan() {
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
	@Column(name = "KODE_ASPEK_PEMERIKSAAN", unique = false, nullable = false, length = 8, scale = 0)
	public String getKodeAspekPemeriksaan() {
		return this.kodeAspekPemeriksaan;
	}

	public void setKodeAspekPemeriksaan(String kodeAspekPemeriksaan) {
		this.kodeAspekPemeriksaan = kodeAspekPemeriksaan;
	}

	@Column(name = "NAMA_ASPEK_PEMERIKSAAN", unique = false, nullable = true, length = 64, scale = 0)
	public String getNamaAspekPemeriksaan() {
		return this.namaAspekPemeriksaan;
	}

	public void setNamaAspekPemeriksaan(String namaAspekPemeriksaan) {
		this.namaAspekPemeriksaan = namaAspekPemeriksaan;
	}

	@Column(name = "KETERANGAN_ASPEK_PEMERIKSAAN", unique = false, nullable = true, length = 256, scale = 0)
	public String getKeteranganAspekPemeriksaan() {
		return this.keteranganAspekPemeriksaan;
	}

	public void setKeteranganAspekPemeriksaan(String keteranganAspekPemeriksaan) {
		this.keteranganAspekPemeriksaan = keteranganAspekPemeriksaan;
	}

	@Column(name = "TUJUAN_ASPEK_PEMERIKSAAN", unique = false, nullable = true, length = 256, scale = 0)
	public String getTujuanAspekPemeriksaan() {
		return this.tujuanAspekPemeriksaan;
	}

	public void setTujuanAspekPemeriksaan(String tujuanAspekPemeriksaan) {
		this.tujuanAspekPemeriksaan = tujuanAspekPemeriksaan;
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

	

	@Column(name = "HAVE_CHILD", unique = false, nullable = true, length = 1)
	public char getHavaChild() {
		return HavaChild;
	}

	public void setHavaChild(char havaChild) {
		HavaChild = havaChild;
	}
	
	
	
	
}