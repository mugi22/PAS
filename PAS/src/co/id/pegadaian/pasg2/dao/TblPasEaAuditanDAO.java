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

import co.id.pegadaian.pasg2.pojo.TblPasEaAuditan;

public class TblPasEaAuditanDAO {
	private Session session;
	
	public TblPasEaAuditanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasEaAuditan tblpaseaauditan){
		session.save(tblpaseaauditan);
	}
		
	public void delete(TblPasEaAuditan tblpaseaauditan){
		session.delete(tblpaseaauditan);
	}
	
	public void update(TblPasEaAuditan tblpaseaauditan){
		session.update(tblpaseaauditan);
	}
//====================================================================	
	public TblPasEaAuditan getById(String  kodeTkAuditan,String  kodeAuditan){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaAuditan.class);
                    if (kodeTkAuditan.length()>0){criteria.add(Restrictions.eq("kodeTkAuditan", kodeTkAuditan)); 	}
                    if (kodeAuditan.length()>0){criteria.add(Restrictions.eq("kodeAuditan", kodeAuditan)); 	}

		return (TblPasEaAuditan)  criteria.uniqueResult();//session.get(TblPasEaAuditan.class, id);
	}
	
	public List<TblPasEaAuditan> getAll(){
		return (List<TblPasEaAuditan>) session.createCriteria(TblPasEaAuditan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasEaAuditan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasEaAuditan> getAll(int start, int rowcount ){
		return (List<TblPasEaAuditan>) session.createCriteria(TblPasEaAuditan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeTkAuditan,String KodeAuditan,String NamaAuditan,String KotaAuditan,String ProvinsiAuditan,String KdParent){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaAuditan.class);
                    if (KodeTkAuditan.length()>0){criteria.add(Restrictions.eq("kodeTkAuditan", KodeTkAuditan)); 	}
                    if (KodeAuditan.length()>0){criteria.add(Restrictions.eq("kodeAuditan", KodeAuditan)); 	}
                    if (NamaAuditan.length()>0){criteria.add(Restrictions.eq("namaAuditan", NamaAuditan)); 	}
                    if (KotaAuditan.length()>0){criteria.add(Restrictions.eq("kotaAuditan", KotaAuditan)); 	}
                    if (ProvinsiAuditan.length()>0){criteria.add(Restrictions.eq("provinsiAuditan", ProvinsiAuditan)); 	}
                    if (KdParent.length()>0){criteria.add(Restrictions.eq("kdParent", KdParent)); 	}
		
		return criteria;
	}

	public List<TblPasEaAuditan> getBy(String KodeTkAuditan,String KodeAuditan,String NamaAuditan,String KotaAuditan,String ProvinsiAuditan,String KdParent ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeTkAuditan,KodeAuditan,NamaAuditan,KotaAuditan,ProvinsiAuditan,KdParent);
		return (List<TblPasEaAuditan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeTkAuditan,String KodeAuditan,String NamaAuditan,String KotaAuditan,String ProvinsiAuditan,String KdParent, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeTkAuditan,KodeAuditan,NamaAuditan,KotaAuditan,ProvinsiAuditan,KdParent);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeTkAuditan,String KodeAuditan,String NamaAuditan,String KotaAuditan,String ProvinsiAuditan,String KdParent ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeTkAuditan,KodeAuditan,NamaAuditan,KotaAuditan,ProvinsiAuditan,KdParent,  start,rowcount);//total jumlah row
		List<TblPasEaAuditan> l = getBy(KodeTkAuditan,KodeAuditan,NamaAuditan,KotaAuditan,ProvinsiAuditan,KdParent, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasEaAuditan> getBy(String KodeTkAuditan,String KodeAuditan,String NamaAuditan,String KotaAuditan,String ProvinsiAuditan,String KdParent  ){
		Criteria criteria =getCriteria(KodeTkAuditan,KodeAuditan,NamaAuditan,KotaAuditan,ProvinsiAuditan,KdParent);
		return (List<TblPasEaAuditan>) criteria.list();
	}


}
