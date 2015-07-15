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
@Table(name = "PAS_RA_RKBPT", schema = "PASG2")
public class PasRaRKBPT extends AuditTrail implements java.io.Serializable {
	private String kodeRKBPT;
	private String kodeRKBPTYangDiRevisi;
	private String tahunRKBPT;
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
	private String statusRKBPT;

	public PasRaRKBPT() {
	}

	@Id
	@Column(name = "KODE_RKBPT", unique = true, nullable = false, length = 10, scale = 0)
	public String getKodeRKBPT() {
		return this.kodeRKBPT;
	}

	public void setKodeRKBPT(String kodeRKBPT) {
		this.kodeRKBPT = kodeRKBPT;
	}

	@Column(name = "KODE_RKBPT_YANG_DIREVISI", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodeRKBPTYangDiRevisi() {
		return this.kodeRKBPTYangDiRevisi;
	}

	public void setKodeRKBPTYangDiRevisi(String kodeRKBPTYangDiRevisi) {
		this.kodeRKBPTYangDiRevisi = kodeRKBPTYangDiRevisi;
	}

	@Column(name = "TAHUN_RKBPT", unique = false, nullable = true, length = 4, scale = 0)
	public String getTahunRKBPT() {
		return this.tahunRKBPT;
	}

	public void setTahunRKBPT(String tahunRKBPT) {
		this.tahunRKBPT = tahunRKBPT;
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

	@Column(name = "STATUS_RKBPT", unique = false, nullable = true, length = 1, scale = 0)
	public String getStatusRKBPT() {
		return this.statusRKBPT;
	}

	public void setStatusRKBPT(String statusRKBPT) {
		this.statusRKBPT = statusRKBPT;
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