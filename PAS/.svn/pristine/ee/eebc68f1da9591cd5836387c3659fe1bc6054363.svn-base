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
@Table(name = "TBL_PAS_KS_KODIFIKASI_KASUS", schema = "PASG2")
public class TblPasKsKodefikasiKasus extends AuditTrail implements
		java.io.Serializable {
	private String kodeKasus;
	private String namaKasus;
	private String status;

	public TblPasKsKodefikasiKasus() {
	}

	@Id
	@Column(name = "KODE_KASUS", unique = true, nullable = false, length = 4, scale = 0)
	public String getKodeKasus() {
		return this.kodeKasus;
	}

	public void setKodeKasus(String kodeKasus) {
		this.kodeKasus = kodeKasus;
	}

	@Column(name = "NAMA_KASUS", unique = false, nullable = false, length = 128, scale = 0)
	public String getNamaKasus() {
		return this.namaKasus;
	}

	public void setNamaKasus(String namaKasus) {
		this.namaKasus = namaKasus;
	}

	@Column(name = "STATUS", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}