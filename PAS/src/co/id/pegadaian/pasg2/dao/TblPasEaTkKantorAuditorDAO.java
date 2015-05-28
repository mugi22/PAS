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

import co.id.pegadaian.pasg2.pojo.TblPasEaTkKantorAuditor;

public class TblPasEaTkKantorAuditorDAO {
	private Session session;
	
	public TblPasEaTkKantorAuditorDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasEaTkKantorAuditor tblpaseatkkantorauditor){
		session.save(tblpaseatkkantorauditor);
	}
		
	public void delete(TblPasEaTkKantorAuditor tblpaseatkkantorauditor){
		session.delete(tblpaseatkkantorauditor);
	}
	
	public void update(TblPasEaTkKantorAuditor tblpaseatkkantorauditor){
		session.update(tblpaseatkkantorauditor);
	}
//====================================================================	
	public TblPasEaTkKantorAuditor getById(String  kodeTk){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaTkKantorAuditor.class);
                    if (kodeTk.length()>0){criteria.add(Restrictions.eq("kodeTk", kodeTk)); 	}

		return (TblPasEaTkKantorAuditor)  criteria.uniqueResult();//session.get(TblPasEaTkKantorAuditor.class, id);
	}
	
	public List<TblPasEaTkKantorAuditor> getAll(){
		return (List<TblPasEaTkKantorAuditor>) session.createCriteria(TblPasEaTkKantorAuditor.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasEaTkKantorAuditor.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasEaTkKantorAuditor> getAll(int start, int rowcount ){
		return (List<TblPasEaTkKantorAuditor>) session.createCriteria(TblPasEaTkKantorAuditor.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeTk,String NamaTk,String StatusTk){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaTkKantorAuditor.class);
                    if (KodeTk.length()>0){criteria.add(Restrictions.eq("kodeTk", KodeTk)); 	}
                    if (NamaTk.length()>0){criteria.add(Restrictions.eq("namaTk", NamaTk)); 	}
                    if (StatusTk.length()>0){criteria.add(Restrictions.eq("statusTk", StatusTk)); 	}
		
		return criteria;
	}

	public List<TblPasEaTkKantorAuditor> getBy(String KodeTk,String NamaTk,String StatusTk ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeTk,NamaTk,StatusTk);
		return (List<TblPasEaTkKantorAuditor>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeTk,String NamaTk,String StatusTk, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeTk,NamaTk,StatusTk);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeTk,String NamaTk,String StatusTk ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeTk,NamaTk,StatusTk,  start,rowcount);//total jumlah row
		List<TblPasEaTkKantorAuditor> l = getBy(KodeTk,NamaTk,StatusTk, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasEaTkKantorAuditor> getBy(String KodeTk,String NamaTk,String StatusTk  ){
		Criteria criteria =getCriteria(KodeTk,NamaTk,StatusTk);
		return (List<TblPasEaTkKantorAuditor>) criteria.list();
	}


}
