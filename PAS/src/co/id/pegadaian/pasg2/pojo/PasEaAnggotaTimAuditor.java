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
@Table(name = "PAS_EA_ANGGOTA_TIM_AUDITOR", schema = "PASG2")
public class PasEaAnggotaTimAuditor extends AuditTrail implements
		java.io.Serializable {
	private String kodeTkKantorAuditor;
	private String kodeKantorAuditor;
	private String kodeUserKetuaTimAuditor;

	private String kodeUserAnggotaTimAuditor;
	
	public PasEaAnggotaTimAuditor() {
	}

	@Id
	@Column(name = "KODE_TK_KANTOR_AUDITOR", unique = false, nullable = false, length = 2, scale = 0)
	public String getKodeTkKantorAuditor() {
		return this.kodeTkKantorAuditor;
	}

	public void setKodeTkKantorAuditor(String kodeTkKantorAuditor) {
		this.kodeTkKantorAuditor = kodeTkKantorAuditor;
	}

	@Id
	@Column(name = "KODE_KANTOR_AUDITOR", unique = false, nullable = false, length = 5, scale = 0)
	public String getKodeKantorAuditor() {
		return this.kodeKantorAuditor;
	}

	public void setKodeKantorAuditor(String kodeKantorAuditor) {
		this.kodeKantorAuditor = kodeKantorAuditor;
	}

	@Id
	@Column(name = "KODE_USER_KETUA_TIM_AUDITOR", unique = false, nullable = false, length = 10, scale = 0)
	public String getKodeUserKetuaTimAuditor() {
		return this.kodeUserKetuaTimAuditor;
	}

	public void setKodeUserKetuaTimAuditor(String kodeUserKetuaTimAuditor) {
		this.kodeUserKetuaTimAuditor = kodeUserKetuaTimAuditor;
	}
	
	
	@Id
	@Column(name = "KODE_USER_ANGGOTA_TIM_AUDITOR", unique = false, nullable = false, length = 10, scale = 0)
	public String getKodeUserAnggotaTimAuditor() {
		return this.kodeUserAnggotaTimAuditor;
	}

	public void setKodeUserAnggotaTimAuditor(String kodeUserKetuaTimAuditor) {
		this.kodeUserAnggotaTimAuditor = kodeUserKetuaTimAuditor;
	}
	
	
}