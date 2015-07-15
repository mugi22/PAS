/*
*Create by CodeGenerator
*daoTemplate
*M U G I
*/

package co.id.pegadaian.pasg2.dao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import co.id.pegadaian.pasg2.pojo.PasEaAnggotaTimAuditor;

public class PasEaAnggotaTimAuditorDAO {
	private Session session;
	
	public PasEaAnggotaTimAuditorDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasEaAnggotaTimAuditor tblpaseaanggotatimauditor){
		session.save(tblpaseaanggotatimauditor);
	}
		
	public void delete(PasEaAnggotaTimAuditor tblpaseaanggotatimauditor){
		session.delete(tblpaseaanggotatimauditor);
	}
	
	public void update(PasEaAnggotaTimAuditor tblpaseaanggotatimauditor){
		session.update(tblpaseaanggotatimauditor);
	}
//====================================================================	
	public PasEaAnggotaTimAuditor getById(String  kodeUserAnggotaTimAuditor,String  kodeTkKantorAuditor,String  kodeKantorAuditor,String  kodeUserKetuaTimAuditor){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaAnggotaTimAuditor.class);
                    if (kodeUserAnggotaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserAnggotaTimAuditor", kodeUserAnggotaTimAuditor)); 	}
                    if (kodeTkKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeTkKantorAuditor", kodeTkKantorAuditor)); 	}
                    if (kodeKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditor", kodeKantorAuditor)); 	}
                    if (kodeUserKetuaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserKetuaTimAuditor", kodeUserKetuaTimAuditor)); 	}

		return (PasEaAnggotaTimAuditor)  criteria.uniqueResult();//session.get(TblPasEaAnggotaTimAuditor.class, id);
	}
	
	public List<PasEaAnggotaTimAuditor> getAll(){
		return (List<PasEaAnggotaTimAuditor>) session.createCriteria(PasEaAnggotaTimAuditor.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaAnggotaTimAuditor.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaAnggotaTimAuditor> getAll(int start, int rowcount ){
		return (List<PasEaAnggotaTimAuditor>) session.createCriteria(PasEaAnggotaTimAuditor.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaAnggotaTimAuditor.class);
                    if (KodeUserAnggotaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserAnggotaTimAuditor", KodeUserAnggotaTimAuditor)); 	}
                    if (KodeTkKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeTkKantorAuditor", KodeTkKantorAuditor)); 	}
                    if (KodeKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditor", KodeKantorAuditor)); 	}
                    if (KodeUserKetuaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserKetuaTimAuditor", KodeUserKetuaTimAuditor)); 	}
		
		return criteria;
	}

	public List<PasEaAnggotaTimAuditor> getBy(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (List<PasEaAnggotaTimAuditor>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor,  start,rowcount);//total jumlah row
		List<PasEaAnggotaTimAuditor> l = getBy(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaAnggotaTimAuditor> getBy(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor  ){
		Criteria criteria =getCriteria(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (List<PasEaAnggotaTimAuditor>) criteria.list();
	}


}
