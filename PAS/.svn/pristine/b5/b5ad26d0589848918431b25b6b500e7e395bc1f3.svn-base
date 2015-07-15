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
@Table(name = "PAS_EA_PPL_USER", schema = "PASG2")
public class PasEaPPLUser extends AuditTrail implements java.io.Serializable {
	private String kodeUser;
	private String kodePPLUSer;
	private String penyelenggaraPPL;
	private Date tglAwalPPL;
	private Date tglAkhirPPL;
	private long lamaPPL;
	private String namaFileBuktiPPL;
	private String fileBuktiPPL;
	private BigDecimal nilai;

	public PasEaPPLUser() {
	}

	@Id
	@Column(name = "KODE_USER", unique = false, nullable = false, length = 10, scale = 0)
	public String getKodeUser() {
		return this.kodeUser;
	}

	public void setKodeUser(String kodeUser) {
		this.kodeUser = kodeUser;
	}

	@Id
	@Column(name = "KODE_PPL_USER", unique = false, nullable = false, length = 4, scale = 0)
	public String getKodePPLUSer() {
		return this.kodePPLUSer;
	}

	public void setKodePPLUSer(String kodePPLUSer) {
		this.kodePPLUSer = kodePPLUSer;
	}

	@Column(name = "PENYELENGGARA_PPL", unique = false, nullable = true, length = 64, scale = 0)
	public String getPenyelenggaraPPL() {
		return this.penyelenggaraPPL;
	}

	public void setPenyelenggaraPPL(String penyelenggaraPPL) {
		this.penyelenggaraPPL = penyelenggaraPPL;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TGLAWAL_PPL", unique = false, nullable = true, length = 13)
	public Date getTglAwalPPL() {
		return this.tglAwalPPL;
	}

	public void setTglAwalPPL(Date tglAwalPPL) {
		this.tglAwalPPL = tglAwalPPL;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TGLAKHIR_PPL", unique = false, nullable = true, length = 13)
	public Date getTglAkhirPPL() {
		return this.tglAkhirPPL;
	}

	public void setTglAkhirPPL(Date tglAkhirPPL) {
		this.tglAkhirPPL = tglAkhirPPL;
	}

	@Column(name = "LAMA_PPL", unique = false, nullable = true, length = 7, scale = 0)
	public long getLamaPPL() {
		return this.lamaPPL;
	}

	public void setLamaPPL(long lamaPPL) {
		this.lamaPPL = lamaPPL;
	}

	@Column(name = "NAMA_FILE_BUKTI_PPL", unique = false, nullable = true, length = 64, scale = 0)
	public String getNamaFileBuktiPPL() {
		return this.namaFileBuktiPPL;
	}

	public void setNamaFileBuktiPPL(String namaFileBuktiPPL) {
		this.namaFileBuktiPPL = namaFileBuktiPPL;
	}

	@Column(name = "FILE_BUKTI_PPL", unique = false, nullable = true, length = 2000, scale = 0)
	public String getFileBuktiPPL() {
		return this.fileBuktiPPL;
	}

	public void setFileBuktiPPL(String fileBuktiPPL) {
		this.fileBuktiPPL = fileBuktiPPL;
	}

	@Column(name = "NILAI", unique = false, nullable = true, length = 6, scale = 0)
	public BigDecimal getNilai() {
		return this.nilai;
	}

	public void setNilai(BigDecimal nilai) {
		this.nilai = nilai;
	}
}