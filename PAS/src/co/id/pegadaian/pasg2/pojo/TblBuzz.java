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
@Table(name = "TBL_BUZZ", schema = "PASG2")
public class TblBuzz extends AuditTrail implements java.io.Serializable {
	private String nik;
	private String nama;
	private Date tgl_Masuk;

	public TblBuzz() {
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
	@Column(name = "TGL_MASUK", unique = false, nullable = true, length = 15)
	public Date getTgl_Masuk() {
		return this.tgl_Masuk;
	}

	public void setTgl_Masuk(Date tgl_Masuk) {
		this.tgl_Masuk = tgl_Masuk;
	}
}