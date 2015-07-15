package co.id.pegadaian.pasg2.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="TBL_PARAM"   ,schema="PASG2")
public class TblParam extends AuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8139569582865717033L;
	private String key,value,description;
	
	@Id 
	@Column(name="KEY_", nullable=false, length=100)
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	@Column(name="VALUE_", nullable=false, length=100)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	@Column(name="description_", nullable=false, length=200)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
