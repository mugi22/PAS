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
@Table(name = "PAS_RA_KEGIATAN_PKPT", schema = "PASG2")
public class PasRaKegiatanPKPT extends AuditTrail implements java.io.Serializable {
	private String kodePKPT;
	private String kodeKegiatanPKPT;
	private Date tanggalAwal;
	private Date tanggalAkhir;
	private String namaKegiatan;
	private String keteranganKegiatan;
	private String statusInap;
	private String jenisTransportasi;
	private BigDecimal biayaTransportasi;
	private BigDecimal biayaMobilDinas;
	private BigDecimal biayaLumpsum;
	private String kodeUserPembuat;
	private String kodeJenisPemeriksaan;
	private String kodeAuditan;

	public PasRaKegiatanPKPT() {
	}

	@Id
	@Column(name = "KODE_PKPT", unique = false, nullable = false, length = 30, scale = 0)
	public String getKodePKPT() {
		return this.kodePKPT;
	}

	public void setKodePKPT(String kodePKPT) {
		this.kodePKPT = kodePKPT;
	}

	@Id
	@Column(name = "KODE_KEGIATAN_PKPT", unique = false, nullable = false, length = 30, scale = 0)
	public String getKodeKegiatanPKPT() {
		return this.kodeKegiatanPKPT;
	}

	public void setKodeKegiatanPKPT(String kodeKegiatanPKPT) {
		this.kodeKegiatanPKPT = kodeKegiatanPKPT;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL_AWAL", unique = false, nullable = true, length = 14)
	public Date getTanggalAwal() {
		return this.tanggalAwal;
	}

	public void setTanggalAwal(Date tanggalAwal) {
		this.tanggalAwal = tanggalAwal;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TANGGAL_AKHIR", unique = false, nullable = true, length = 14)
	public Date getTanggalAkhir() {
		return this.tanggalAkhir;
	}

	public void setTanggalAkhir(Date tanggalAkhir) {
		this.tanggalAkhir = tanggalAkhir;
	}

	@Column(name = "NAMA_KEGIATAN", unique = false, nullable = true, length = 256, scale = 0)
	public String getNamaKegiatan() {
		return this.namaKegiatan;
	}

	public void setNamaKegiatan(String namaKegiatan) {
		this.namaKegiatan = namaKegiatan;
	}

	@Column(name = "KETERANGAN_KEGIATAN", unique = false, nullable = true, length = 256, scale = 0)
	public String getKeteranganKegiatan() {
		return this.keteranganKegiatan;
	}

	public void setKeteranganKegiatan(String keteranganKegiatan) {
		this.keteranganKegiatan = keteranganKegiatan;
	}

	@Column(name = "STATUS_INAP", unique = false, nullable = true, length = 2, scale = 0)
	public String getStatusInap() {
		return this.statusInap;
	}

	public void setStatusInap(String statusInap) {
		this.statusInap = statusInap;
	}

	@Column(name = "JENIS_TRANSPORTASI", unique = false, nullable = true, length = 2, scale = 0)
	public String getJenisTransportasi() {
		return this.jenisTransportasi;
	}

	public void setJenisTransportasi(String jenisTransportasi) {
		this.jenisTransportasi = jenisTransportasi;
	}

	@Column(name = "BIAYA_TRANSPORTASI", unique = false, nullable = true, length = 12, scale = 0)
	public BigDecimal getBiayaTransportasi() {
		return this.biayaTransportasi;
	}

	public void setBiayaTransportasi(BigDecimal biayaTransportasi) {
		this.biayaTransportasi = biayaTransportasi;
	}

	@Column(name = "KODE_USER_PEMBUAT", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodeUserPembuat() {
		return this.kodeUserPembuat;
	}

	public void setKodeUserPembuat(String kodeUserPembuat) {
		this.kodeUserPembuat = kodeUserPembuat;
	}

	@Column(name = "BIAYA_MOBILDINAS", unique = false, nullable = true, length = 12, scale = 0)
	public BigDecimal getBiayaMobilDinas() {
		return biayaMobilDinas;
	}

	public void setBiayaMobilDinas(BigDecimal biayaMobilDinas) {
		this.biayaMobilDinas = biayaMobilDinas;
	}

	@Column(name = "BIAYA_LUMPSUM", unique = false, nullable = true, length = 12, scale = 0)
	public BigDecimal getBiayaLumpsum() {
		return biayaLumpsum;
	}

	public void setBiayaLumpsum(BigDecimal biayaLumpsum) {
		this.biayaLumpsum = biayaLumpsum;
	}
//Tambahan
	
	@Column(name = "KODE_JENIS_PEMERIKSAAN", unique = false, nullable = true, length = 4, scale = 0)
	public String getKodeJenisPemeriksaan() {
		return this.kodeJenisPemeriksaan;
	}

	public void setKodeJenisPemeriksaan(String kodeJenisPemeriksaan) {
		this.kodeJenisPemeriksaan = kodeJenisPemeriksaan;
	}
	


	@Column(name = "KODE_AUDITAN", unique = false, nullable = true, length = 10, scale = 0)
	public String getKodeAuditan() {
		return this.kodeAuditan;
	}

	public void setKodeAuditan(String kodeAuditan) {
		this.kodeAuditan = kodeAuditan;
	}

	
}