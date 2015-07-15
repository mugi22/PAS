package co.id.pegadaian.pasg2.pojo;

// Generated Mar 2, 2015 11:08:12 AM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
/**
 * TblSeq generated by hbm2java
 */
@Entity

@Table(name = "TBL_SEQ", schema = "PASG2")
public class TblSeq implements java.io.Serializable {

	private String seqName;
	private long seqNum;
	private String createBy,updateBy;
	private Date createDate,updateDate;
	private BigDecimal versi;
	
	public TblSeq() {
	}

	public TblSeq(String seqName, long seqNum) {
		this.seqName = seqName;
		this.seqNum = seqNum;
	}

	@Id
	@Column(name = "SEQ_NAME", unique = true, nullable = false, length = 100)
	public String getSeqName() {
		return this.seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	@Column(name = "SEQ_NUM", nullable = false, precision = 10, scale = 0)
	public long getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
	}

	@Column(name = "create_by", length = 20)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "update_by", length = 20)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Temporal(TemporalType.TIMESTAMP)//TIMESTAMP DATE
	@Column(name = "create_date", length = 29)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)//TIMESTAMP DATE
	@Column(name = "update_date", length = 29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
	
	@Id
	@Column(name = "versi", length = 19)
	public BigDecimal getVersi() {
		return versi;
	}

	public void setVersi(BigDecimal versi) {
		this.versi = versi;
	}
}
