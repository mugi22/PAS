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

import co.id.pegadaian.pasg2.pojo.TblKecamatan;

public class TblKecamatanDAO {
	private Session session;
	
	public TblKecamatanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblKecamatan tblkecamatan){
		session.save(tblkecamatan);
	}
		
	public void delete(TblKecamatan tblkecamatan){
		session.delete(tblkecamatan);
	}
	
	public void update(TblKecamatan tblkecamatan){
		session.update(tblkecamatan);
	}
//====================================================================	
	public TblKecamatan getById(String  kodeKabupaten,String  kodeKecamatan){
		Criteria criteria =null;
		criteria = session.createCriteria(TblKecamatan.class);
                    if (kodeKabupaten.length()>0){criteria.add(Restrictions.eq("kodeKabupaten", kodeKabupaten)); 	}
                    if (kodeKecamatan.length()>0){criteria.add(Restrictions.eq("kodeKecamatan", kodeKecamatan)); 	}

		return (TblKecamatan)  criteria.uniqueResult();//session.get(TblKecamatan.class, id);
	}
	
	
	
	public List<TblKecamatan> getAll(){
		return (List<TblKecamatan>) session.createCriteria(TblKecamatan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblKecamatan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblKecamatan> getAll(int start, int rowcount ){
		return (List<TblKecamatan>) session.createCriteria(TblKecamatan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeKabupaten,String NamaKecamatan,String KodeKecamatan){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblKecamatan.class);
                    if (KodeKabupaten.length()>0){criteria.add(Restrictions.eq("kodeKabupaten", KodeKabupaten)); 	}
                    if (NamaKecamatan.length()>0){criteria.add(Restrictions.like("namaKecamatan","%"+ NamaKecamatan+"%")); 	}
                    if (KodeKecamatan.length()>0){criteria.add(Restrictions.eq("kodeKecamatan", KodeKecamatan)); 	}
		
		return criteria;
	}

	public List<TblKecamatan> getBy(String KodeKabupaten,String NamaKecamatan,String KodeKecamatan ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeKabupaten,NamaKecamatan,KodeKecamatan);
		return (List<TblKecamatan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeKabupaten,String NamaKecamatan,String KodeKecamatan, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeKabupaten,NamaKecamatan,KodeKecamatan);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeKabupaten,String NamaKecamatan,String KodeKecamatan ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeKabupaten,NamaKecamatan,KodeKecamatan,  start,rowcount);//total jumlah row
		List<TblKecamatan> l = getBy(KodeKabupaten,NamaKecamatan,KodeKecamatan, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

	
	public List<TblKecamatan> getByKabupaten(String KodeKabupaten){
		Criteria criteria = session.createCriteria(TblKecamatan.class);
		 criteria =criteria.add(Restrictions.eq("kodeKabupaten", KodeKabupaten));
		return (List<TblKecamatan>) criteria.list();
	}
	
	
	
//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblKecamatan> getBy(String KodeKabupaten,String NamaKecamatan,String KodeKecamatan  ){
		Criteria criteria =getCriteria(KodeKabupaten,NamaKecamatan,KodeKecamatan);
		return (List<TblKecamatan>) criteria.list();
	}


}
