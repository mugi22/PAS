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

import co.id.pegadaian.pasg2.pojo.PasEaTkKantorAuditor;

public class PasEaTkKantorAuditorDAO {
	private Session session;
	
	public PasEaTkKantorAuditorDAO(Session session){
		this.session = session;
	}
	 
	
	public void insert(PasEaTkKantorAuditor tblpaseatkkantorauditor){
		session.save(tblpaseatkkantorauditor);
	}
		
	public void delete(PasEaTkKantorAuditor tblpaseatkkantorauditor){
		session.delete(tblpaseatkkantorauditor);
	}
	
	public void update(PasEaTkKantorAuditor tblpaseatkkantorauditor){
		session.update(tblpaseatkkantorauditor);
	}
//====================================================================	
	public PasEaTkKantorAuditor getById(String  kodeTk){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaTkKantorAuditor.class);
                    if (kodeTk.length()>0){criteria.add(Restrictions.eq("kodeTk", kodeTk)); 	}

		return (PasEaTkKantorAuditor)  criteria.uniqueResult();//session.get(TblPasEaTkKantorAuditor.class, id);
	}
	
	public List<PasEaTkKantorAuditor> getAll(){
		return (List<PasEaTkKantorAuditor>) session.createCriteria(PasEaTkKantorAuditor.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaTkKantorAuditor.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaTkKantorAuditor> getAll(int start, int rowcount ){
		return (List<PasEaTkKantorAuditor>) session.createCriteria(PasEaTkKantorAuditor.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeTk,String NamaTk,String StatusTk){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaTkKantorAuditor.class);
                    if (KodeTk.length()>0){criteria.add(Restrictions.eq("kodeTk", KodeTk)); 	}
                    if (NamaTk.length()>0){criteria.add(Restrictions.eq("namaTk", NamaTk)); 	}
                    if (StatusTk.length()>0){criteria.add(Restrictions.eq("statusTk", StatusTk)); 	}
		
		return criteria;
	}

	public List<PasEaTkKantorAuditor> getBy(String KodeTk,String NamaTk,String StatusTk ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeTk,NamaTk,StatusTk);
		return (List<PasEaTkKantorAuditor>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeTk,String NamaTk,String StatusTk, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeTk,NamaTk,StatusTk);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeTk,String NamaTk,String StatusTk ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeTk,NamaTk,StatusTk,  start,rowcount);//total jumlah row
		List<PasEaTkKantorAuditor> l = getBy(KodeTk,NamaTk,StatusTk, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaTkKantorAuditor> getBy(String KodeTk,String NamaTk,String StatusTk  ){
		Criteria criteria =getCriteria(KodeTk,NamaTk,StatusTk);
		return (List<PasEaTkKantorAuditor>) criteria.list();
	}


}
