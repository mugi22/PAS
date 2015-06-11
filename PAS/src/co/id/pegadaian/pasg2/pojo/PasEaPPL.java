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
@Table(name = "PAS_EA_PPL", schema = "PASG2")
public class PasEaPPL extends AuditTrail implements java.io.Serializable {
	private String kodePPL;
	private String namaPPL;

	public PasEaPPL() {
	}

	@Id
	@Column(name = "KODE_PPL", unique = true, nullable = false, length = 4, scale = 0)
	public String getKodePPL() {
		return this.kodePPL;
	}

	public void setKodePPL(String kodePPL) {
		this.kodePPL = kodePPL;
	}

	@Column(name = "NAMA_PPL", unique = false, nullable = true, length = 64, scale = 0)
	public String getNamaPPL() {
		return this.namaPPL;
	}

	public void setNamaPPL(String namaPPL) {
		this.namaPPL = namaPPL;
	}
}