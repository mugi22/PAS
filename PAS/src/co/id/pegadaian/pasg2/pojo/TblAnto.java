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
@Table(name = "Tbl_Anto", schema = "PASG2")
public class TblAnto extends AuditTrail implements java.io.Serializable {
	private String nik;
	private String alamat;
	private Date tglx;

	public TblAnto() {
	}

	@Id
	@Column(name = "NIK", unique = true, nullable = false, length = 2, scale = 0)
	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	@Column(name = "ALAMAT", unique = false, nullable = true, length = 50, scale = 0)
	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TGLX", unique = false, nullable = true, length = 14)
	public Date getTglx() {
		return this.tglx;
	}

	public void setTglx(Date tglx) {
		this.tglx = tglx;
	}
}