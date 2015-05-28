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

import co.id.pegadaian.pasg2.pojo.TblPasKsKodefikasiSebab;

public class TblPasKsKodefikasiSebabDAO {
	private Session session;
	
	public TblPasKsKodefikasiSebabDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasKsKodefikasiSebab tblpaskskodefikasisebab){
		session.save(tblpaskskodefikasisebab);
	}
		
	public void delete(TblPasKsKodefikasiSebab tblpaskskodefikasisebab){
		session.delete(tblpaskskodefikasisebab);
	}
	
	public void update(TblPasKsKodefikasiSebab tblpaskskodefikasisebab){
		session.update(tblpaskskodefikasisebab);
	}
//====================================================================	
	public TblPasKsKodefikasiSebab getById(String  kodeSebab){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiSebab.class);
                    if (kodeSebab.length()>0){criteria.add(Restrictions.eq("kodeSebab", kodeSebab)); 	}

		return (TblPasKsKodefikasiSebab)  criteria.uniqueResult();//session.get(TblPasKsKodefikasiSebab.class, id);
	}
	
	public List<TblPasKsKodefikasiSebab> getAll(){
		return (List<TblPasKsKodefikasiSebab>) session.createCriteria(TblPasKsKodefikasiSebab.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasKsKodefikasiSebab.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasKsKodefikasiSebab> getAll(int start, int rowcount ){
		return (List<TblPasKsKodefikasiSebab>) session.createCriteria(TblPasKsKodefikasiSebab.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Status,String KodeSebab,String NamaSebab){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiSebab.class);
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (KodeSebab.length()>0){criteria.add(Restrictions.eq("kodeSebab", KodeSebab)); 	}
                    if (NamaSebab.length()>0){criteria.add(Restrictions.eq("namaSebab", NamaSebab)); 	}
		
		return criteria;
	}

	public List<TblPasKsKodefikasiSebab> getBy(String Status,String KodeSebab,String NamaSebab ,int start, int rowcount ){
		Criteria criteria =getCriteria(Status,KodeSebab,NamaSebab);
		return (List<TblPasKsKodefikasiSebab>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Status,String KodeSebab,String NamaSebab, int start, int rowcount  ){
		Criteria criteria =getCriteria(Status,KodeSebab,NamaSebab);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Status,String KodeSebab,String NamaSebab ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Status,KodeSebab,NamaSebab,  start,rowcount);//total jumlah row
		List<TblPasKsKodefikasiSebab> l = getBy(Status,KodeSebab,NamaSebab, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasKsKodefikasiSebab> getBy(String Status,String KodeSebab,String NamaSebab  ){
		Criteria criteria =getCriteria(Status,KodeSebab,NamaSebab);
		return (List<TblPasKsKodefikasiSebab>) criteria.list();
	}


}
