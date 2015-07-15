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
@Table(name = "PAS_RA_PKPT", schema = "PASG2")
public class PasRaPKPT extends AuditTrail implements java.io.Serializable {
	private String kodePKPT;
	private String kodePKPTYangDiRevisi;
	private String tahunPKPT;
	private String kodeKantorAuditorPemilik;
	private String kodeUserPembuat;
	private String statusPembuatan;
	private String nomorSuratPengajuan;
	private Date tanggalSuratPengajuan;
	private String kodeUserPeReviu;
	private String statusReviu;
	private String kodeUserPenyetuju;
	private String statusPerstujuan;
	private String nomorSuratPersetujuan;
	private Date tanggalSuratPersetujuan;
	private String statusPKPT;

	public PasRaPKPT() {
	}

	@Id
	@Column(name = "KODE_PKPT", unique = true, nullable = false, length = 10, scale = 0)
	public String getKodePKPT() {
		return this.kodePKPT;
	}

	public void setKodePKPT(String kodePKPT) {
		this.kodePKPT = kodePKPT;
	}

	@Column(name = "KODE_PKPT_YANG_DIREVISI", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodePKPTYangDiRevisi() {
		return this.kodePKPTYangDiRevisi;
	}

	public void setKodePKPTYangDiRevisi(String kodePKPTYangDiRevisi) {
		this.kodePKPTYangDiRevisi = kodePKPTYangDiRevisi;
	}

	@Column(name = "TAHUN_PKPT", unique = false, nullable = true, length = 4, scale = 0)
	public String getTahunPKPT() {
		return this.tahunPKPT;
	}

	public void setTahunPKPT(String tahunPKPT) {
		this.tahunPKPT = tahunPKPT;
	}

	@Column(name = "KODE_KANTOR_AUDITOR_PEMILIK", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodeKantorAuditorPemilik() {
		return this.kodeKantorAuditorPemilik;
	}

	public void setKodeKantorAuditorPemilik(String kodeKantorAuditorPemilik) {
		this.kodeKantorAuditorPemilik = kodeKantorAuditorPemilik;
	}

	@Column(name = "KODE_USER_PEMBUAT", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodeUserPembuat() {
		return this.kodeUserPembuat;
	}

	public void setKodeUserPembuat(String kodeUserPembuat) {
		this.kodeUserPembuat = kodeUserPembuat;
	}

	@Column(name = "STATUS_PEMBUATAN", unique = false, nullable = true, length = 2, scale = 0)
	public String getStatusPembuatan() {
		return this.statusPembuatan;
	}

	public void setStatusPembuatan(String statusPembuatan) {
		this.statusPembuatan = statusPembuatan;
	}

	@Column(name = "NOMOR_SURAT_PENGAJUAN", unique = false, nullable = true, length = 50, scale = 0)
	public String getNomorSuratPengajuan() {
		return this.nomorSuratPengajuan;
	}

	public void setNomorSuratPengajuan(String nomorSuratPengajuan) {
		this.nomorSuratPengajuan = nomorSuratPengajuan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL_SURAT_PENGAJUAN", unique = false, nullable = true, length = 14)
	public Date getTanggalSuratPengajuan() {
		return this.tanggalSuratPengajuan;
	}

	public void setTanggalSuratPengajuan(Date tanggalSuratPengajuan) {
		this.tanggalSuratPengajuan = tanggalSuratPengajuan;
	}

	@Column(name = "KODE_USER_PEREVIU", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodeUserPeReviu() {
		return kodeUserPeReviu;
	}

	public void setKodeUserPeReviu(String kodeUserPeReviu) {
		this.kodeUserPeReviu = kodeUserPeReviu;
	}

	@Column(name = "KODE_USER_PENYETUJU", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodeUserPenyetuju() {
		return this.kodeUserPenyetuju;
	}

	public void setKodeUserPenyetuju(String kodeUserPenyetuju) {
		this.kodeUserPenyetuju = kodeUserPenyetuju;
	}

	@Column(name = "STATUS_PERSTUJUAN", unique = false, nullable = true, length = 2, scale = 0)
	public String getStatusPerstujuan() {
		return this.statusPerstujuan;
	}

	public void setStatusPerstujuan(String statusPerstujuan) {
		this.statusPerstujuan = statusPerstujuan;
	}

	@Column(name = "NOMOR_SURAT_PERSETUJUAN", unique = false, nullable = true, length = 50, scale = 0)
	public String getNomorSuratPersetujuan() {
		return this.nomorSuratPersetujuan;
	}

	public void setNomorSuratPersetujuan(String nomorSuratPersetujuan) {
		this.nomorSuratPersetujuan = nomorSuratPersetujuan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL_SURAT_PERSETUJUAN", unique = false, nullable = true, length = 14)
	public Date getTanggalSuratPersetujuan() {
		return this.tanggalSuratPersetujuan;
	}

	public void setTanggalSuratPersetujuan(Date tanggalSuratPersetujuan) {
		this.tanggalSuratPersetujuan = tanggalSuratPersetujuan;
	}

	@Column(name = "STATUS_PKPT", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatusPKPT() {
		return this.statusPKPT;
	}

	public void setStatusPKPT(String statusPKPT) {
		this.statusPKPT = statusPKPT;
	}

	@Column(name = "STATUS_REVIU", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatusReviu() {
		return statusReviu;
	}

	public void setStatusReviu(String statusReviu) {
		this.statusReviu = statusReviu;
	}
	
//	=========================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}