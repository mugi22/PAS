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

import co.id.pegadaian.pasg2.pojo.PasEaProsedurPemeriksaan;

public class PasEaProsedurPemeriksaanDAO {
	private Session session;
	
	public PasEaProsedurPemeriksaanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasEaProsedurPemeriksaan paseaprosedurpemeriksaan){
		session.save(paseaprosedurpemeriksaan);
	}
		
	public void delete(PasEaProsedurPemeriksaan paseaprosedurpemeriksaan){
		session.delete(paseaprosedurpemeriksaan);
	}
	
	public void update(PasEaProsedurPemeriksaan paseaprosedurpemeriksaan){
		session.update(paseaprosedurpemeriksaan);
	}
//====================================================================	
	public PasEaProsedurPemeriksaan getById(String  kodeAspekPemeriksaan,String  kodePemeriksaan,String  kodeJenisPemeriksaan){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaProsedurPemeriksaan.class);
                    if (kodeAspekPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeAspekPemeriksaan", kodeAspekPemeriksaan)); 	}
                    if (kodePemeriksaan.length()>0){criteria.add(Restrictions.eq("kodePemeriksaan", kodePemeriksaan)); 	}
                    if (kodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", kodeJenisPemeriksaan)); 	}

		return (PasEaProsedurPemeriksaan)  criteria.uniqueResult();//session.get(PasEaProsedurPemeriksaan.class, id);
	}
	
	public List<PasEaProsedurPemeriksaan> getAll(){
		return (List<PasEaProsedurPemeriksaan>) session.createCriteria(PasEaProsedurPemeriksaan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaProsedurPemeriksaan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaProsedurPemeriksaan> getAll(int start, int rowcount ){
		return (List<PasEaProsedurPemeriksaan>) session.createCriteria(PasEaProsedurPemeriksaan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeAspekPemeriksaan,String KodePemeriksaan){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaProsedurPemeriksaan.class);
                    if (KodeAspekPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeAspekPemeriksaan", KodeAspekPemeriksaan)); 	}
                    if (KodePemeriksaan.length()>0){criteria.add(Restrictions.eq("kodePemeriksaan", KodePemeriksaan)); 	}
		
		return criteria;
	}

	public List<PasEaProsedurPemeriksaan> getBy(String KodeAspekPemeriksaan,String KodePemeriksaan ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeAspekPemeriksaan,KodePemeriksaan);
		return (List<PasEaProsedurPemeriksaan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeAspekPemeriksaan,String KodePemeriksaan, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeAspekPemeriksaan,KodePemeriksaan);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeAspekPemeriksaan,String KodePemeriksaan ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeAspekPemeriksaan,KodePemeriksaan,  start,rowcount);//total jumlah row
		List<PasEaProsedurPemeriksaan> l = getBy(KodeAspekPemeriksaan,KodePemeriksaan, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaProsedurPemeriksaan> getBy(String KodeAspekPemeriksaan,String KodePemeriksaan  ){
		Criteria criteria =getCriteria(KodeAspekPemeriksaan,KodePemeriksaan);
		return (List<PasEaProsedurPemeriksaan>) criteria.list();
	}


}
