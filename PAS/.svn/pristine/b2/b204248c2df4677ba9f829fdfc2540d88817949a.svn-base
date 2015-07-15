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

import co.id.pegadaian.pasg2.pojo.PasEaTkAuditan;

public class PasEaTkAuditanDAO {
	private Session session;
	
	public PasEaTkAuditanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasEaTkAuditan tblpaseatkauditan){
		session.save(tblpaseatkauditan);
	}
		
	public void delete(PasEaTkAuditan tblpaseatkauditan){
		session.delete(tblpaseatkauditan);
	}
	
	public void update(PasEaTkAuditan tblpaseatkauditan){
		session.update(tblpaseatkauditan);
	}
//====================================================================	
	public PasEaTkAuditan getById(String  kodeTkAuditan){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaTkAuditan.class);
                    if (kodeTkAuditan.length()>0){criteria.add(Restrictions.eq("kodeTkAuditan", kodeTkAuditan)); 	}

		return (PasEaTkAuditan)  criteria.uniqueResult();//session.get(TblPasEaTkAuditan.class, id);
	}
	
	public List<PasEaTkAuditan> getAll(){
		return (List<PasEaTkAuditan>) session.createCriteria(PasEaTkAuditan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaTkAuditan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaTkAuditan> getAll(int start, int rowcount ){
		return (List<PasEaTkAuditan>) session.createCriteria(PasEaTkAuditan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeTkAuditan,String NamaTkAuditan){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaTkAuditan.class);
                    if (KodeTkAuditan.length()>0){criteria.add(Restrictions.eq("kodeTkAuditan", KodeTkAuditan)); 	}
                    if (NamaTkAuditan.length()>0){criteria.add(Restrictions.eq("namaTkAuditan", NamaTkAuditan)); 	}
		
		return criteria;
	}

	public List<PasEaTkAuditan> getBy(String KodeTkAuditan,String NamaTkAuditan ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeTkAuditan,NamaTkAuditan);
		return (List<PasEaTkAuditan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeTkAuditan,String NamaTkAuditan, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeTkAuditan,NamaTkAuditan);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeTkAuditan,String NamaTkAuditan ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeTkAuditan,NamaTkAuditan,  start,rowcount);//total jumlah row
		List<PasEaTkAuditan> l = getBy(KodeTkAuditan,NamaTkAuditan, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaTkAuditan> getBy(String KodeTkAuditan,String NamaTkAuditan  ){
		Criteria criteria =getCriteria(KodeTkAuditan,NamaTkAuditan);
		return (List<PasEaTkAuditan>) criteria.list();
	}


}
