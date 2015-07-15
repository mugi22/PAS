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

import co.id.pegadaian.pasg2.pojo.PasEaPPL;

public class PasEaPPLDAO {
	private Session session;
	
	public PasEaPPLDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasEaPPL paseappl){
		session.save(paseappl);
	}
		
	public void delete(PasEaPPL paseappl){
		session.delete(paseappl);
	}
	
	public void update(PasEaPPL paseappl){
		session.update(paseappl);
	}
//====================================================================	
	public PasEaPPL getById(String  kodePPL){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaPPL.class);
                    if (kodePPL.length()>0){criteria.add(Restrictions.eq("kodePPL", kodePPL)); 	}

		return (PasEaPPL)  criteria.uniqueResult();//session.get(PasEaPPL.class, id);
	}
	
	public List<PasEaPPL> getAll(){
		return (List<PasEaPPL>) session.createCriteria(PasEaPPL.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaPPL.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaPPL> getAll(int start, int rowcount ){
		return (List<PasEaPPL>) session.createCriteria(PasEaPPL.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodePPL,String NamaPPL){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaPPL.class);
                    if (KodePPL.length()>0){criteria.add(Restrictions.eq("kodePPL", KodePPL)); 	}
                    if (NamaPPL.length()>0){criteria.add(Restrictions.eq("namaPPL", NamaPPL)); 	}
		
		return criteria;
	}

	public List<PasEaPPL> getBy(String KodePPL,String NamaPPL ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodePPL,NamaPPL);
		return (List<PasEaPPL>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodePPL,String NamaPPL, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodePPL,NamaPPL);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodePPL,String NamaPPL ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodePPL,NamaPPL,  start,rowcount);//total jumlah row
		List<PasEaPPL> l = getBy(KodePPL,NamaPPL, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaPPL> getBy(String KodePPL,String NamaPPL  ){
		Criteria criteria =getCriteria(KodePPL,NamaPPL);
		return (List<PasEaPPL>) criteria.list();
	}


}
