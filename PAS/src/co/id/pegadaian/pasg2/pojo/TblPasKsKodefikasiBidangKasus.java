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
@Table(name = "TBL_PAS_KS_KODIFIKASI_BIDANG_KASUS", schema = "PASG2")
public class TblPasKsKodefikasiBidangKasus extends AuditTrail implements
		java.io.Serializable {
	private String kodeBidangKasus;
	private String namaBidangKasus;
	private String status;

	public TblPasKsKodefikasiBidangKasus() {
	}

	@Id
	@Column(name = "KODE_BIDANG_KASUS", unique = true, nullable = false, length = 4, scale = 0)
	public String getKodeBidangKasus() {
		return this.kodeBidangKasus;
	}

	public void setKodeBidangKasus(String kodeBidangKasus) {
		this.kodeBidangKasus = kodeBidangKasus;
	}

	@Column(name = "NAMA_BIDANG_KASUS", unique = false, nullable = false, length = 128, scale = 0)
	public String getNamaBidangKasus() {
		return this.namaBidangKasus;
	}

	public void setNamaBidangKasus(String namaBidangKasus) {
		this.namaBidangKasus = namaBidangKasus;
	}

	@Column(name = "STATUS", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}