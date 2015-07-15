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
@Table(name = "TBL_PAS_KS_KODEFIKASI_TK_TEMUAN", schema = "PASG2")
public class TblPasKsKodefikasiTkTemuan extends AuditTrail implements java.io.Serializable {
private String kodeTkTemuan;
private String namaTkTemuan;
private String status;
public TblPasKsKodefikasiTkTemuan(){
}@Id
@Column(name = "KODETKTEMUAN",unique =true,nullable = false,length =4 , scale = 0)
public String getKodeTkTemuan(){
return this.kodeTkTemuan;
}public void setKodeTkTemuan(String kodeTkTemuan){
this.kodeTkTemuan=kodeTkTemuan;
}
@Column(name = "NAMATKTEMUAN",unique =false,nullable = false,length =128 , scale = 0)
public String getNamaTkTemuan(){
return this.namaTkTemuan;
}public void setNamaTkTemuan(String namaTkTemuan){
this.namaTkTemuan=namaTkTemuan;
}
@Column(name = "STATUS",unique =false,nullable = true,length =1 , scale = 0)
public String getStatus(){
return this.status;
}public void setStatus(String status){
this.status=status;
}
}