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
@Table(name = "Tbl_Pas_Ea_Tk_Kantor_Auditor", schema = "PASG2")
public class TblPasEaTkKantorAuditor extends AuditTrail implements
		java.io.Serializable {
	private String kodeTk;
	private String namaTk;
	private String keteranganTk;
	private String statusTk;

	public TblPasEaTkKantorAuditor() {
	}

	@Id
	@Column(name = "KODE_TK_KANTOR_AUDITOR", unique = true, nullable = false, length = 2, scale = 0)
	public String getKodeTk() {
		return this.kodeTk;
	}

	public void setKodeTk(String kodeTk) {
		this.kodeTk = kodeTk;
	}

	@Column(name = "NAMA_TK_KANTOR_AUDITOR", unique = false, nullable = false, length = 64, scale = 0)
	public String getNamaTk() {
		return this.namaTk;
	}

	public void setNamaTk(String namaTk) {
		this.namaTk = namaTk;
	}

	@Column(name = "KETERANGAN_TK_KANTOR_AUDITOR", unique = false, nullable = true, length = 256, scale = 0)
	public String getKeteranganTk() {
		return this.keteranganTk;
	}

	public void setKeteranganTk(String keteranganTk) {
		this.keteranganTk = keteranganTk;
	}

	@Column(name = "STATUS_TK_KANTOR_AUDITOR", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatusTk() {
		return this.statusTk;
	}

	public void setStatusTk(String statusTk) {
		this.statusTk = statusTk;
	}
}