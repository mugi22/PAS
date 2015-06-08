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

import co.id.pegadaian.pasg2.pojo.TblPasEaAnggotaTimAuditor;

public class TblPasEaAnggotaTimAuditorDAO {
	private Session session;
	
	public TblPasEaAnggotaTimAuditorDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasEaAnggotaTimAuditor tblpaseaanggotatimauditor){
		session.save(tblpaseaanggotatimauditor);
	}
		
	public void delete(TblPasEaAnggotaTimAuditor tblpaseaanggotatimauditor){
		session.delete(tblpaseaanggotatimauditor);
	}
	
	public void update(TblPasEaAnggotaTimAuditor tblpaseaanggotatimauditor){
		session.update(tblpaseaanggotatimauditor);
	}
//====================================================================	
	public TblPasEaAnggotaTimAuditor getById(String  kodeUserAnggotaTimAuditor,String  kodeTkKantorAuditor,String  kodeKantorAuditor,String  kodeUserKetuaTimAuditor){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaAnggotaTimAuditor.class);
                    if (kodeUserAnggotaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserAnggotaTimAuditor", kodeUserAnggotaTimAuditor)); 	}
                    if (kodeTkKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeTkKantorAuditor", kodeTkKantorAuditor)); 	}
                    if (kodeKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditor", kodeKantorAuditor)); 	}
                    if (kodeUserKetuaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserKetuaTimAuditor", kodeUserKetuaTimAuditor)); 	}

		return (TblPasEaAnggotaTimAuditor)  criteria.uniqueResult();//session.get(TblPasEaAnggotaTimAuditor.class, id);
	}
	
	public List<TblPasEaAnggotaTimAuditor> getAll(){
		return (List<TblPasEaAnggotaTimAuditor>) session.createCriteria(TblPasEaAnggotaTimAuditor.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasEaAnggotaTimAuditor.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasEaAnggotaTimAuditor> getAll(int start, int rowcount ){
		return (List<TblPasEaAnggotaTimAuditor>) session.createCriteria(TblPasEaAnggotaTimAuditor.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaAnggotaTimAuditor.class);
                    if (KodeUserAnggotaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserAnggotaTimAuditor", KodeUserAnggotaTimAuditor)); 	}
                    if (KodeTkKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeTkKantorAuditor", KodeTkKantorAuditor)); 	}
                    if (KodeKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditor", KodeKantorAuditor)); 	}
                    if (KodeUserKetuaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserKetuaTimAuditor", KodeUserKetuaTimAuditor)); 	}
		
		return criteria;
	}

	public List<TblPasEaAnggotaTimAuditor> getBy(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (List<TblPasEaAnggotaTimAuditor>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor,  start,rowcount);//total jumlah row
		List<TblPasEaAnggotaTimAuditor> l = getBy(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasEaAnggotaTimAuditor> getBy(String KodeUserAnggotaTimAuditor,String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor  ){
		Criteria criteria =getCriteria(KodeUserAnggotaTimAuditor,KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (List<TblPasEaAnggotaTimAuditor>) criteria.list();
	}


}
