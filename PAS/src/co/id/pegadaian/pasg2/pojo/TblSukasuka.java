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
@Table(name = "TBL_SUKASUKA", schema = "PASG2")
public class TblSukasuka extends AuditTrail implements java.io.Serializable {
	private String sukaSukaID;
	private String sukaName;
	private Date sukaTgl;
	private BigDecimal sukaGaji;
	private long sukaJmlx;

	public TblSukasuka() {
	}

	@Id
	@Column(name = "SUKASUKA_ID", unique = true, nullable = false, length = 10, scale = 0)
	public String getSukaSukaID() {
		return this.sukaSukaID;
	}

	public void setSukaSukaID(String sukaSukaID) {
		this.sukaSukaID = sukaSukaID;
	}

	@Column(name = "SUKA_NAME", unique = false, nullable = false, length = 30, scale = 0)
	public String getSukaName() {
		return this.sukaName;
	}

	public void setSukaName(String sukaName) {
		this.sukaName = sukaName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SUKATGL", unique = false, nullable = true, length = 14)
	public Date getSukaTgl() {
		return this.sukaTgl;
	}

	public void setSukaTgl(Date sukaTgl) {
		this.sukaTgl = sukaTgl;
	}

	@Column(name = "SUKA_GAJI", unique = false, nullable = true, length = 10, scale = 0)
	public BigDecimal getSukaGaji() {
		return this.sukaGaji;
	}

	public void setSukaGaji(BigDecimal sukaGaji) {
		this.sukaGaji = sukaGaji;
	}

	@Column(name = "SUKA_JMLX", unique = false, nullable = true, length = 2, scale = 0)
	public long getSukaJmlx() {
		return this.sukaJmlx;
	}

	public void setSukaJmlx(long sukaJmlx) {
		this.sukaJmlx = sukaJmlx;
	}
}