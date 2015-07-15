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
@Table(name = "TBL_COBA", schema = "PASG2")
public class TblCoba extends AuditTrail implements java.io.Serializable {
	private String nik;
	private String nama;
	private Date tglLhahir;

	public TblCoba() {
	}

	@Id
	@Column(name = "NIK", unique = true, nullable = false, length = 10, scale = 0)
	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	@Column(name = "NAMA", unique = false, nullable = false, length = 50, scale = 0)
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TGL_LHAHIR", unique = false, nullable = true, length = 13)
	public Date getTglLhahir() {
		return this.tglLhahir;
	}

	public void setTglLhahir(Date tglLhahir) {
		this.tglLhahir = tglLhahir;
	}
}