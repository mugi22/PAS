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
@Table(name = "Tbl_Test", schema = "PASG2")
public class TblTest extends AuditTrail implements java.io.Serializable {
	private String nik;
	private String nama;
	private Date tglLahir;
	private long nilai;

	public TblTest() {
	}

	@Id
	@Column(name = "NIK", unique = true, nullable = false, length = 7, scale = 0)
	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	@Column(name = "NAMA", unique = false, nullable = false, length = 30, scale = 0)
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TGLLAHIR", unique = false, nullable = true, length = 13)
	public Date getTglLahir() {
		return this.tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

	@Column(name = "NILAI", unique = false, nullable = true, length = 2, scale = 0)
	public long getNilai() {
		return this.nilai;
	}

	public void setNilai(long nilai) {
		this.nilai = nilai;
	}
}