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

import co.id.pegadaian.pasg2.pojo.TblPasEaKetuaTimAuditor;

public class TblPasEaKetuaTimAuditorDAO {
	private Session session;
	
	public TblPasEaKetuaTimAuditorDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasEaKetuaTimAuditor tblpaseaketuatimauditor){
		session.save(tblpaseaketuatimauditor);
	}
		
	public void delete(TblPasEaKetuaTimAuditor tblpaseaketuatimauditor){
		session.delete(tblpaseaketuatimauditor);
	}
	
	public void update(TblPasEaKetuaTimAuditor tblpaseaketuatimauditor){
		session.update(tblpaseaketuatimauditor);
	}
//====================================================================	
	public TblPasEaKetuaTimAuditor getById(String  kodeTkKantorAuditor,String  kodeKantorAuditor,String  kodeUserKetuaTimAuditor){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaKetuaTimAuditor.class);
                    if (kodeTkKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeTkKantorAuditor", kodeTkKantorAuditor)); 	}
                    if (kodeKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditor", kodeKantorAuditor)); 	}
                    if (kodeUserKetuaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserKetuaTimAuditor", kodeUserKetuaTimAuditor)); 	}

		return (TblPasEaKetuaTimAuditor)  criteria.uniqueResult();//session.get(TblPasEaKetuaTimAuditor.class, id);
	}

	public TblPasEaKetuaTimAuditor getByBranch(String  kodeKantorAuditor){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaKetuaTimAuditor.class);
                    criteria.add(Restrictions.eq("kodeKantorAuditor", kodeKantorAuditor)); 	

		return (TblPasEaKetuaTimAuditor)  criteria.uniqueResult();//session.get(TblPasEaKetuaTimAuditor.class, id);
	}
	
	
	public List<TblPasEaKetuaTimAuditor> getAll(){
		return (List<TblPasEaKetuaTimAuditor>) session.createCriteria(TblPasEaKetuaTimAuditor.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasEaKetuaTimAuditor.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasEaKetuaTimAuditor> getAll(int start, int rowcount ){
		return (List<TblPasEaKetuaTimAuditor>) session.createCriteria(TblPasEaKetuaTimAuditor.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaKetuaTimAuditor.class);
                    if (KodeTkKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeTkKantorAuditor", KodeTkKantorAuditor)); 	}
                    if (KodeKantorAuditor.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditor", KodeKantorAuditor)); 	}
                    if (KodeUserKetuaTimAuditor.length()>0){criteria.add(Restrictions.eq("kodeUserKetuaTimAuditor", KodeUserKetuaTimAuditor)); 	}
		
		return criteria;
	}

	public List<TblPasEaKetuaTimAuditor> getBy(String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (List<TblPasEaKetuaTimAuditor>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor,  start,rowcount);//total jumlah row
		List<TblPasEaKetuaTimAuditor> l = getBy(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasEaKetuaTimAuditor> getBy(String KodeTkKantorAuditor,String KodeKantorAuditor,String KodeUserKetuaTimAuditor  ){
		Criteria criteria =getCriteria(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
		return (List<TblPasEaKetuaTimAuditor>) criteria.list();
	}


}
