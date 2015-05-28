package co.id.pegadaian.pasg2.pojo;

// Generated Mar 2, 2015 11:08:12 AM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TblKabupaten generated by hbm2java
 */
@Entity
@Table(name = "TBL_KABUPATEN", schema = "PASG2")
public class TblKabupaten extends AuditTrail implements java.io.Serializable {
	private String kodeProvinsi;
	private String kodeKabupaten;
	private String namaKabupaten;
	
	@Id
	@Column(name = "KODE_PROVINSI", nullable = false, length = 2)
	public String getKodeProvinsi() {
		return this.kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
	@Id
	@Column(name = "KODE_KABUPATEN", nullable = false, length = 4)
	public String getKodeKabupaten() {
		return this.kodeKabupaten;
	}

	public void setKodeKabupaten(String kodeKabupaten) {
		this.kodeKabupaten = kodeKabupaten;
	}

	@Column(name = "NAMA_KABUPATEN", nullable = false, length = 200)
	public String getNamaKabupaten() {
		return this.namaKabupaten;
	}

	public void setNamaKabupaten(String namaKabupaten) {
		this.namaKabupaten = namaKabupaten;
	}

}
