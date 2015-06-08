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
@Table(name = "PAS_EA_TK_AUDITAN", schema = "PASG2")
public class PasEaTkAuditan extends AuditTrail implements java.io.Serializable {
private String kodeTkAuditan;
private String namaTkAuditan;
private String keteranganTkAuditan;
private String statusTkAuditan;
public PasEaTkAuditan(){
}@Id
@Column(name = "KODE_TK_AUDITAN",unique =true,nullable = false,length =2 , scale = 0)
public String getKodeTkAuditan(){
return this.kodeTkAuditan;
}public void setKodeTkAuditan(String kodeTkAuditan){
this.kodeTkAuditan=kodeTkAuditan;
}
@Column(name = "NAMA_TK_AUDITAN",unique =false,nullable = true,length =64 , scale = 0)
public String getNamaTkAuditan(){
return this.namaTkAuditan;
}public void setNamaTkAuditan(String namaTkAuditan){
this.namaTkAuditan=namaTkAuditan;
}
@Column(name = "KETERANGAN_TK_AUDITAN",unique =false,nullable = true,length =256 , scale = 0)
public String getKeteranganTkAuditan(){
return this.keteranganTkAuditan;
}public void setKeteranganTkAuditan(String keteranganTkAuditan){
this.keteranganTkAuditan=keteranganTkAuditan;
}
@Column(name = "STATUS_TK_AUDITAN",unique =false,nullable = true,length =1 , scale = 0)
public String getStatusTkAuditan(){
return this.statusTkAuditan;
}public void setStatusTkAuditan(String statusTkAuditan){
this.statusTkAuditan=statusTkAuditan;
}
}