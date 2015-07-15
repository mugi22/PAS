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
@Table(name = "PAS_EA_FORMASI_AUDITAN", schema = "PASG2")
public class PasEaFormasiAuditan extends AuditTrail implements
		java.io.Serializable {
	private String kodeTkAuditan;
	private String kodeAuditan;
	private String kodeFormasiAuditan;
	private String jabatan;
	private String grade;
	private String nik;
	private String nama;

	public PasEaFormasiAuditan() {
	}

	@Id
	@Column(name = "KODE_TK_AUDITAN", unique = false, nullable = false, length = 2, scale = 0)
	public String getKodeTkAuditan() {
		return this.kodeTkAuditan;
	}

	public void setKodeTkAuditan(String kodeTkAuditan) {
		this.kodeTkAuditan = kodeTkAuditan;
	}

	@Id
	@Column(name = "KODE_AUDITAN", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodeAuditan() {
		return this.kodeAuditan;
	}

	public void setKodeAuditan(String kodeAuditan) {
		this.kodeAuditan = kodeAuditan;
	}

	@Id
	@Column(name = "KODE_FORMASI_AUDITAN", unique = false, nullable = true, length = 4, scale = 0)
	public String getKodeFormasiAuditan() {
		return this.kodeFormasiAuditan;
	}

	public void setKodeFormasiAuditan(String kodeFormasiAuditan) {
		this.kodeFormasiAuditan = kodeFormasiAuditan;
	}

	@Column(name = "JABATAN", unique = false, nullable = true, length = 4, scale = 0)
	public String getJabatan() {
		return this.jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	@Column(name = "GRADE", unique = false, nullable = true, length = 2, scale = 0)
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name = "NIK", unique = false, nullable = true, length = 10, scale = 0)
	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	@Column(name = "NAMA", unique = false, nullable = true, length = 64, scale = 0)
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
}