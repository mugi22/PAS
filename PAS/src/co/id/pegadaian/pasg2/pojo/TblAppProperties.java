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
@Table(name = "TBL_APP_PROPERTIES", schema = "PASG2")
public class TblAppProperties extends AuditTrail implements java.io.Serializable {
private String propertiesNama;
private String propertiesValue;
public TblAppProperties(){
}@Id
@Column(name = "PROPERTIES_NAMA",unique =true,nullable = false,length =200 , scale = 0)
public String getPropertiesNama(){
return this.propertiesNama;
}public void setPropertiesNama(String propertiesNama){
this.propertiesNama=propertiesNama;
}
@Column(name = "PROPERTIES_VALUE",unique =false,nullable = true,length =400 , scale = 0)
public String getPropertiesValue(){
return this.propertiesValue;
}public void setPropertiesValue(String propertiesValue){
this.propertiesValue=propertiesValue;
}
}