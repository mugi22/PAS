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

import co.id.pegadaian.pasg2.pojo.TblPasKsKodefikasiBidangKasus;

public class TblPasKsKodefikasiBidangKasusDAO {
	private Session session;
	
	public TblPasKsKodefikasiBidangKasusDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasKsKodefikasiBidangKasus tblpaskskodefikasibidangkasus){
		session.save(tblpaskskodefikasibidangkasus);
	}
		
	public void delete(TblPasKsKodefikasiBidangKasus tblpaskskodefikasibidangkasus){
		session.delete(tblpaskskodefikasibidangkasus);
	}
	
	public void update(TblPasKsKodefikasiBidangKasus tblpaskskodefikasibidangkasus){
		session.update(tblpaskskodefikasibidangkasus);
	}
//====================================================================	
	public TblPasKsKodefikasiBidangKasus getById(String  kodeBidangKasus){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiBidangKasus.class);
                    if (kodeBidangKasus.length()>0){criteria.add(Restrictions.eq("kodeBidangKasus", kodeBidangKasus)); 	}

		return (TblPasKsKodefikasiBidangKasus)  criteria.uniqueResult();//session.get(TblPasKsKodefikasiBidangKasus.class, id);
	}
	
	public List<TblPasKsKodefikasiBidangKasus> getAll(){
		return (List<TblPasKsKodefikasiBidangKasus>) session.createCriteria(TblPasKsKodefikasiBidangKasus.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasKsKodefikasiBidangKasus.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasKsKodefikasiBidangKasus> getAll(int start, int rowcount ){
		return (List<TblPasKsKodefikasiBidangKasus>) session.createCriteria(TblPasKsKodefikasiBidangKasus.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Status,String KodeBidangKasus,String NamaBidangKasus){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiBidangKasus.class);
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (KodeBidangKasus.length()>0){criteria.add(Restrictions.eq("kodeBidangKasus", KodeBidangKasus)); 	}
                    if (NamaBidangKasus.length()>0){criteria.add(Restrictions.eq("namaBidangKasus", NamaBidangKasus)); 	}
		
		return criteria;
	}

	public List<TblPasKsKodefikasiBidangKasus> getBy(String Status,String KodeBidangKasus,String NamaBidangKasus ,int start, int rowcount ){
		Criteria criteria =getCriteria(Status,KodeBidangKasus,NamaBidangKasus);
		return (List<TblPasKsKodefikasiBidangKasus>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Status,String KodeBidangKasus,String NamaBidangKasus, int start, int rowcount  ){
		Criteria criteria =getCriteria(Status,KodeBidangKasus,NamaBidangKasus);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Status,String KodeBidangKasus,String NamaBidangKasus ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Status,KodeBidangKasus,NamaBidangKasus,  start,rowcount);//total jumlah row
		List<TblPasKsKodefikasiBidangKasus> l = getBy(Status,KodeBidangKasus,NamaBidangKasus, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasKsKodefikasiBidangKasus> getBy(String Status,String KodeBidangKasus,String NamaBidangKasus  ){
		Criteria criteria =getCriteria(Status,KodeBidangKasus,NamaBidangKasus);
		return (List<TblPasKsKodefikasiBidangKasus>) criteria.list();
	}


}
