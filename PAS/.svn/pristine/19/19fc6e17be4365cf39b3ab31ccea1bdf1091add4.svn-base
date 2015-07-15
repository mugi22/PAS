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

import co.id.pegadaian.pasg2.pojo.TblKelurahan;

public class TblKelurahanDAO {
	private Session session;
	
	public TblKelurahanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblKelurahan tblkelurahan){
		session.save(tblkelurahan);
	}
		
	public void delete(TblKelurahan tblkelurahan){
		session.delete(tblkelurahan);
	}
	
	public void update(TblKelurahan tblkelurahan){
		session.update(tblkelurahan);
	}
//====================================================================	
	public TblKelurahan getById(String  kodeKecamatan,String  idKelurahan){
		Criteria criteria =null;
		criteria = session.createCriteria(TblKelurahan.class);
                    if (kodeKecamatan.length()>0){criteria.add(Restrictions.eq("kodeKecamatan", kodeKecamatan)); 	}
                    if (idKelurahan.length()>0){criteria.add(Restrictions.eq("idKelurahan", idKelurahan)); 	}

		return (TblKelurahan)  criteria.uniqueResult();//session.get(TblKelurahan.class, id);
	}
	
	public List<TblKelurahan> getAll(){
		return (List<TblKelurahan>) session.createCriteria(TblKelurahan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblKelurahan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblKelurahan> getAll(int start, int rowcount ){
		return (List<TblKelurahan>) session.createCriteria(TblKelurahan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeKecamatan,String NamaKelurahan,String IdKelurahan,String KodePos){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblKelurahan.class);
                    if (KodeKecamatan.length()>0){criteria.add(Restrictions.eq("kodeKecamatan", KodeKecamatan)); 	}
                    if (NamaKelurahan.length()>0){criteria.add(Restrictions.eq("namaKelurahan", NamaKelurahan)); 	}
                    if (IdKelurahan.length()>0){criteria.add(Restrictions.eq("idKelurahan", IdKelurahan)); 	}
                    if (KodePos.length()>0){criteria.add(Restrictions.eq("kodePos", KodePos)); 	}
		
		return criteria;
	}

	public List<TblKelurahan> getBy(String KodeKecamatan,String NamaKelurahan,String IdKelurahan,String KodePos ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeKecamatan,NamaKelurahan,IdKelurahan,KodePos);
		return (List<TblKelurahan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeKecamatan,String NamaKelurahan,String IdKelurahan,String KodePos, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeKecamatan,NamaKelurahan,IdKelurahan,KodePos);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeKecamatan,String NamaKelurahan,String IdKelurahan,String KodePos ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeKecamatan,NamaKelurahan,IdKelurahan,KodePos,  start,rowcount);//total jumlah row
		List<TblKelurahan> l = getBy(KodeKecamatan,NamaKelurahan,IdKelurahan,KodePos, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblKelurahan> getBy(String KodeKecamatan,String NamaKelurahan,String IdKelurahan,String KodePos  ){
		Criteria criteria =getCriteria(KodeKecamatan,NamaKelurahan,IdKelurahan,KodePos);
		return (List<TblKelurahan>) criteria.list();
	}


}
