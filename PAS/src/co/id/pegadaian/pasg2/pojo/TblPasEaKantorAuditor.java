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
@Table(name = "TBL_PAS_EA_KANTOR_AUDITOR", schema = "PASG2")
public class TblPasEaKantorAuditor extends AuditTrail implements
		java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kodeTk;
	private String kodeKantor;
	private String nama;
	private String alamat;
	private String kota;
	private String provinsi;
	private String koordinat;
	private String telp;
	private String fax;
	private String kodeParent;
	private String status;

	public TblPasEaKantorAuditor() {
	}

	@Column(name = "KODE_TK_KANTOR_AUDITOR", unique = false, nullable = true, length = 2, scale = 0)
	public String getKodeTk() {
		return this.kodeTk;
	}

	public void setKodeTk(String kodeTk) {
		this.kodeTk = kodeTk;
	}

	@Id
	@Column(name = "KODE_KANTOR_AUDITOR", unique = true, nullable = false, length = 5)
	public String getKodeKantor() {
		return this.kodeKantor;
	}

	public void setKodeKantor(String kodeKantor) {
		this.kodeKantor = kodeKantor;
	}

	@Column(name = "NAMA_KANTOR_AUDITOR", unique = false, nullable = true, length = 64, scale = 0)
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Column(name = "ALAMAT_KANTOR_AUDITOR", unique = false, nullable = true, length = 128, scale = 0)
	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	@Column(name = "KOTA_KANTOR_AUDITOR", unique = false, nullable = true, length = 4, scale = 0)
	public String getKota() {
		return this.kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	@Column(name = "PROVINSI_KANTOR_AUDITOR", unique = false, nullable = true, length = 2, scale = 0)
	public String getProvinsi() {
		return this.provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	@Column(name = "KOORDINAT_KANTOR_AUDITOR", unique = false, nullable = true, length = 64, scale = 0)
	public String getKoordinat() {
		return this.koordinat;
	}

	public void setKoordinat(String koordinat) {
		this.koordinat = koordinat;
	}

	@Column(name = "TELEPHONE_KANTOR_AUDITOR", unique = false, nullable = true, length = 16, scale = 0)
	public String getTelp() {
		return this.telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}

	@Column(name = "FAXIMILE_KANTOR_AUDITOR", unique = false, nullable = true, length = 16, scale = 0)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "KD_PARENT", unique = false, nullable = true, length = 5, scale = 0)
	public String getKodeParent() {
		return this.kodeParent;
	}

	public void setKodeParent(String kodeParent) {
		this.kodeParent = kodeParent;
	}

	@Column(name = "STATUS_KANTOR_AUDITOR", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}