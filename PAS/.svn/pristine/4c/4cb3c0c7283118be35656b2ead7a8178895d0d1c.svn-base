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

import co.id.pegadaian.pasg2.pojo.TblPasKsKodefikasiKasus;

public class TblPasKsKodefikasiKasusDAO {
	private Session session;
	
	public TblPasKsKodefikasiKasusDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasKsKodefikasiKasus tblpaskskodefikasikasus){
		session.save(tblpaskskodefikasikasus);
	}
		
	public void delete(TblPasKsKodefikasiKasus tblpaskskodefikasikasus){
		session.delete(tblpaskskodefikasikasus);
	}
	
	public void update(TblPasKsKodefikasiKasus tblpaskskodefikasikasus){
		session.update(tblpaskskodefikasikasus);
	}
//====================================================================	
	public TblPasKsKodefikasiKasus getById(String  kodeKasus){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiKasus.class);
                    if (kodeKasus.length()>0){criteria.add(Restrictions.eq("kodeKasus", kodeKasus)); 	}

		return (TblPasKsKodefikasiKasus)  criteria.uniqueResult();//session.get(TblPasKsKodefikasiKasus.class, id);
	}
	
	public List<TblPasKsKodefikasiKasus> getAll(){
		return (List<TblPasKsKodefikasiKasus>) session.createCriteria(TblPasKsKodefikasiKasus.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasKsKodefikasiKasus.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasKsKodefikasiKasus> getAll(int start, int rowcount ){
		return (List<TblPasKsKodefikasiKasus>) session.createCriteria(TblPasKsKodefikasiKasus.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeKasus,String NamaKasus,String Status){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiKasus.class);
                    if (KodeKasus.length()>0){criteria.add(Restrictions.eq("kodeKasus", KodeKasus)); 	}
                    if (NamaKasus.length()>0){criteria.add(Restrictions.eq("namaKasus", NamaKasus)); 	}
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
		
		return criteria;
	}

	public List<TblPasKsKodefikasiKasus> getBy(String KodeKasus,String NamaKasus,String Status ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeKasus,NamaKasus,Status);
		return (List<TblPasKsKodefikasiKasus>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeKasus,String NamaKasus,String Status, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeKasus,NamaKasus,Status);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeKasus,String NamaKasus,String Status ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeKasus,NamaKasus,Status,  start,rowcount);//total jumlah row
		List<TblPasKsKodefikasiKasus> l = getBy(KodeKasus,NamaKasus,Status, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasKsKodefikasiKasus> getBy(String KodeKasus,String NamaKasus,String Status  ){
		Criteria criteria =getCriteria(KodeKasus,NamaKasus,Status);
		return (List<TblPasKsKodefikasiKasus>) criteria.list();
	}


}
