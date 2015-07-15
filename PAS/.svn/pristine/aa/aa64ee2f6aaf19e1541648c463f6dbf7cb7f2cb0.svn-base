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

import co.id.pegadaian.pasg2.pojo.TblPasEaAspekPemeriksaan;

public class TblPasEaAspekPemeriksaanDAO {
	private Session session;
	
	public TblPasEaAspekPemeriksaanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasEaAspekPemeriksaan tblpaseaaspekpemeriksaan){
		session.save(tblpaseaaspekpemeriksaan);
	}
		
	public void delete(TblPasEaAspekPemeriksaan tblpaseaaspekpemeriksaan){
		session.delete(tblpaseaaspekpemeriksaan);
	}
	
	public void update(TblPasEaAspekPemeriksaan tblpaseaaspekpemeriksaan){
		session.update(tblpaseaaspekpemeriksaan);
	}
//====================================================================	
	public TblPasEaAspekPemeriksaan getById(String  kodeAspekPemeriksaan,String  kodeJenisPemeriksaan){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaAspekPemeriksaan.class);
                    if (kodeAspekPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeAspekPemeriksaan", kodeAspekPemeriksaan)); 	}
                    if (kodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", kodeJenisPemeriksaan)); 	}

		return (TblPasEaAspekPemeriksaan)  criteria.uniqueResult();//session.get(TblPasEaAspekPemeriksaan.class, id);
	}
	
	public List<TblPasEaAspekPemeriksaan> getAll(){
		return (List<TblPasEaAspekPemeriksaan>) session.createCriteria(TblPasEaAspekPemeriksaan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasEaAspekPemeriksaan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasEaAspekPemeriksaan> getAll(int start, int rowcount ){
		return (List<TblPasEaAspekPemeriksaan>) session.createCriteria(TblPasEaAspekPemeriksaan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan,String KdParent){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaAspekPemeriksaan.class);
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (KodeAspekPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeAspekPemeriksaan", KodeAspekPemeriksaan)); 	}
                    if (KodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", KodeJenisPemeriksaan)); 	}
                    if (KdParent.length()>0){criteria.add(Restrictions.eq("kdParent", KdParent)); 	}
		
		return criteria;
	}

	public List<TblPasEaAspekPemeriksaan> getBy(String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan,String KdParent ,int start, int rowcount ){
		Criteria criteria =getCriteria(Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan,KdParent);
		return (List<TblPasEaAspekPemeriksaan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan,String KdParent, int start, int rowcount  ){
		Criteria criteria =getCriteria(Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan,KdParent);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan,String KdParent ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan,KdParent,  start,rowcount);//total jumlah row
		List<TblPasEaAspekPemeriksaan> l = getBy(Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan,KdParent, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasEaAspekPemeriksaan> getBy(String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan,String KdParent  ){
		Criteria criteria =getCriteria(Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan,KdParent);
		return (List<TblPasEaAspekPemeriksaan>) criteria.list();
	}


}
