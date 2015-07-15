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
@Table(name = "TBL_PAS_KS_KODIFIKASI_SEBAB", schema = "PASG2")
public class TblPasKsKodefikasiSebab extends AuditTrail implements
		java.io.Serializable {
	private String kodeSebab;
	private String namaSebab;
	private String status;

	public TblPasKsKodefikasiSebab() {
	}

	@Id
	@Column(name = "KODE_SEBAB", unique = true, nullable = false, length = 4, scale = 0)
	public String getKodeSebab() {
		return this.kodeSebab;
	}

	public void setKodeSebab(String kodeSebab) {
		this.kodeSebab = kodeSebab;
	}

	@Column(name = "NAMA_SEBAB", unique = false, nullable = true, length = 128, scale = 0)
	public String getNamaSebab() {
		return this.namaSebab;
	}

	public void setNamaSebab(String namaSebab) {
		this.namaSebab = namaSebab;
	}

	@Column(name = "STATUS", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}