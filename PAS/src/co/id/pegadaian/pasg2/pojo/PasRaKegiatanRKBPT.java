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
@Table(name = "PAS_RA_KEGIATAN_RKBPT", schema = "PASG2")
public class PasRaKegiatanRKBPT extends AuditTrail implements
		java.io.Serializable {
	private String kodeRKBPT;
	private String kodeKegiatanRKBPT;
	private Date tanggalAwal;
	private Date tanggalAkhir;
	private String namaKegiatan;
	private String keteranganKegiatan;
	private String tempatKegiatan;
	private long jumlahPersonil;
	private String statusInap;
	private BigDecimal jarak;
	private String jenisTransportasi;
	private BigDecimal biayaTransportasi;
	private BigDecimal biayaLumpsum;

	public PasRaKegiatanRKBPT() {
	}

	@Id
	@Column(name = "KODE_RKBPT", unique = false, nullable = false, length = 10, scale = 0)
	public String getKodeRKBPT() {
		return this.kodeRKBPT;
	}

	public void setKodeRKBPT(String kodeRKBPT) {
		this.kodeRKBPT = kodeRKBPT;
	}

	@Id
	@Column(name = "KODE_KEGIATAN_RKBPT", unique = false, nullable = false, length = 30, scale = 0)
	public String getKodeKegiatanRKBPT() {
		return this.kodeKegiatanRKBPT;
	}

	public void setKodeKegiatanRKBPT(String kodeKegiatanRKBPT) {
		this.kodeKegiatanRKBPT = kodeKegiatanRKBPT;
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

	@Column(name = "TEMPAT_KEGIATAN", unique = false, nullable = true, length = 256, scale = 0)
	public String getTempatKegiatan() {
		return this.tempatKegiatan;
	}

	public void setTempatKegiatan(String tempatKegiatan) {
		this.tempatKegiatan = tempatKegiatan;
	}

	@Column(name = "JUMLAH_PERSONIL", unique = false, nullable = true, length = 3, scale = 0)
	public long getJumlahPersonil() {
		return this.jumlahPersonil;
	}

	public void setJumlahPersonil(long jumlahPersonil) {
		this.jumlahPersonil = jumlahPersonil;
	}

	@Column(name = "STATUS_INAP", unique = false, nullable = true, length = 2, scale = 0)
	public String getStatusInap() {
		return this.statusInap;
	}

	public void setStatusInap(String statusInap) {
		this.statusInap = statusInap;
	}

	@Column(name = "JARAK", unique = false, nullable = true, length = 5, scale = 0)
	public BigDecimal getJarak() {
		return this.jarak;
	}

	public void setJarak(BigDecimal jarak) {
		this.jarak = jarak;
	}

	@Column(name = "JENIS_TRANSPORTASI", unique = false, nullable = true, length = 2, scale = 0)
	public String getJenisTransportasi() {
		return this.jenisTransportasi;
	}

	public void setJenisTransportasi(String jenisTransportasi) {
		this.jenisTransportasi = jenisTransportasi;
	}

	@Column(name = "BIAYA_TRANSPORTASI", unique = false, nullable = true, length = 14, scale = 0)
	public BigDecimal getBiayaTransportasi() {
		return this.biayaTransportasi;
	}

	public void setBiayaTransportasi(BigDecimal biayaTransportasi) {
		this.biayaTransportasi = biayaTransportasi;
	}

	@Column(name = "BIAYA_LUMSUM", unique = false, nullable = true, length = 14, scale = 0)
	public BigDecimal getBiayaLumpsum() {
		return this.biayaLumpsum;
	}

	public void setBiayaLumpsum(BigDecimal biayaLumpsum) {
		this.biayaLumpsum = biayaLumpsum;
	}
}