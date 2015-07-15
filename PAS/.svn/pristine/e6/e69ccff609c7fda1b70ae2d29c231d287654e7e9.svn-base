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
@Table(name = "TBL_PAS_KS_HARI_LIBUR", schema = "PASG2")
public class TblPasKsHariLibur extends AuditTrail implements java.io.Serializable {
private String kodeHariLibur;
private Date tanggalHariLibur;
private String keteranganHariLibur;
public TblPasKsHariLibur(){
}@Id
@Column(name = "KODEHARILIBUR",unique =true,nullable = false,length =4 , scale = 0)
public String getKodeHariLibur(){
return this.kodeHariLibur;
}public void setKodeHariLibur(String kodeHariLibur){
this.kodeHariLibur=kodeHariLibur;
}
@Temporal(TemporalType.DATE)
@Column(name = "TANGGALHARILIBUR",unique =false,nullable = true,length =13 )
public Date getTanggalHariLibur(){
return this.tanggalHariLibur;
}public void setTanggalHariLibur(Date tanggalHariLibur){
this.tanggalHariLibur=tanggalHariLibur;
}
@Column(name = "KETERANGANHARILIBUR",unique =false,nullable = true,length =64 , scale = 0)
public String getKeteranganHariLibur(){
return this.keteranganHariLibur;
}public void setKeteranganHariLibur(String keteranganHariLibur){
this.keteranganHariLibur=keteranganHariLibur;
}
}