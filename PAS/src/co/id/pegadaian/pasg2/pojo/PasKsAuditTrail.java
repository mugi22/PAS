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
@Table(name = "PAS_KS_AUDIT_TRAIL", schema = "PASG2")
public class PasKsAuditTrail extends AuditTrail implements java.io.Serializable {
	private long kodeAuditTrail;
	private String namaTable;
	private long kodeRecord;
	private String aksi;
	private String alamatIP;
	private String namaKomputer;
	
	private String kodeUserPelaku;

	@Column(name = "KODE_USER_PELAKU", unique = false, nullable = false, length = 15, scale = 0)
	public String getKodeUserPelaku() {
		return kodeUserPelaku;
	}

	public void setKodeUserPelaku(String kodeUserPelaku) {
		this.kodeUserPelaku = kodeUserPelaku;
	}

	public PasKsAuditTrail() {
	}

	@Id
	@Column(name = "KODE_AUDIT_TRAIL", unique = false, nullable = false, length = 15, scale = 0)
	public long getKodeAuditTrail() {
		return this.kodeAuditTrail;
	}

	public void setKodeAuditTrail(long kodeAuditTrail) {
		this.kodeAuditTrail = kodeAuditTrail;
	}

	@Column(name = "NAMA_TABLE", unique = false, nullable = true, length = 256, scale = 0)
	public String getNamaTable() {
		return this.namaTable;
	}

	public void setNamaTable(String namaTable) {
		this.namaTable = namaTable;
	}

	@Column(name = "KODE_RECORD", unique = false, nullable = true, length = 15, scale = 0)
	public long getKodeRecord() {
		return this.kodeRecord;
	}

	public void setKodeRecord(long kodeRecord) {
		this.kodeRecord = kodeRecord;
	}

	@Column(name = "AKSI", unique = false, nullable = true, length = 1024, scale = 0)
	public String getAksi() {
		return this.aksi;
	}

	public void setAksi(String aksi) {
		this.aksi = aksi;
	}

	@Column(name = "ALAMAT_IP", unique = false, nullable = true, length = 16, scale = 0)
	public String getAlamatIP() {
		return this.alamatIP;
	}

	public void setAlamatIP(String alamatIP) {
		this.alamatIP = alamatIP;
	}

	@Column(name = "NAMA_KOMPUTER", unique = false, nullable = true, length = 64, scale = 0)
	public String getNamaKomputer() {
		return this.namaKomputer;
	}

	public void setNamaKomputer(String namaKomputer) {
		this.namaKomputer = namaKomputer;
	}

}