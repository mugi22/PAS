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

import co.id.pegadaian.pasg2.pojo.TblPasKsKodefikasiTemuan;

public class TblPasKsKodefikasiTemuanDAO {
	private Session session;
	
	public TblPasKsKodefikasiTemuanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasKsKodefikasiTemuan tblpaskskodefikasitemuan){
		session.save(tblpaskskodefikasitemuan);
	}
		
	public void delete(TblPasKsKodefikasiTemuan tblpaskskodefikasitemuan){
		session.delete(tblpaskskodefikasitemuan);
	}
	
	public void update(TblPasKsKodefikasiTemuan tblpaskskodefikasitemuan){
		session.update(tblpaskskodefikasitemuan);
	}
//====================================================================	
	public TblPasKsKodefikasiTemuan getById(String  kodeTemuan,String  kodeAspekPemeriksaan,String  kodeJenisPemeriksaan){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiTemuan.class);
                    if (kodeTemuan.length()>0){criteria.add(Restrictions.eq("kodeTemuan", kodeTemuan)); 	}
                    if (kodeAspekPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeAspekPemeriksaan", kodeAspekPemeriksaan)); 	}
                    if (kodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", kodeJenisPemeriksaan)); 	}

		return (TblPasKsKodefikasiTemuan)  criteria.uniqueResult();//session.get(TblPasKsKodefikasiTemuan.class, id);
	}
	
	public List<TblPasKsKodefikasiTemuan> getAll(){
		return (List<TblPasKsKodefikasiTemuan>) session.createCriteria(TblPasKsKodefikasiTemuan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasKsKodefikasiTemuan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasKsKodefikasiTemuan> getAll(int start, int rowcount ){
		return (List<TblPasKsKodefikasiTemuan>) session.createCriteria(TblPasKsKodefikasiTemuan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KdParent,String NamaTemuan,String KodeTemuan,String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiTemuan.class);
                    if (KdParent.length()>0){criteria.add(Restrictions.eq("kdParent", KdParent)); 	}
                    if (NamaTemuan.length()>0){criteria.add(Restrictions.eq("namaTemuan", NamaTemuan)); 	}
                    if (KodeTemuan.length()>0){criteria.add(Restrictions.eq("kodeTemuan", KodeTemuan)); 	}
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (KodeAspekPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeAspekPemeriksaan", KodeAspekPemeriksaan)); 	}
                    if (KodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", KodeJenisPemeriksaan)); 	}
		
		return criteria;
	}

	public List<TblPasKsKodefikasiTemuan> getBy(String KdParent,String NamaTemuan,String KodeTemuan,String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan ,int start, int rowcount ){
		Criteria criteria =getCriteria(KdParent,NamaTemuan,KodeTemuan,Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan);
		return (List<TblPasKsKodefikasiTemuan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KdParent,String NamaTemuan,String KodeTemuan,String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan, int start, int rowcount  ){
		Criteria criteria =getCriteria(KdParent,NamaTemuan,KodeTemuan,Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KdParent,String NamaTemuan,String KodeTemuan,String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KdParent,NamaTemuan,KodeTemuan,Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan,  start,rowcount);//total jumlah row
		List<TblPasKsKodefikasiTemuan> l = getBy(KdParent,NamaTemuan,KodeTemuan,Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasKsKodefikasiTemuan> getBy(String KdParent,String NamaTemuan,String KodeTemuan,String Status,String KodeAspekPemeriksaan,String KodeJenisPemeriksaan  ){
		Criteria criteria =getCriteria(KdParent,NamaTemuan,KodeTemuan,Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan);
		return (List<TblPasKsKodefikasiTemuan>) criteria.list();
	}


}
