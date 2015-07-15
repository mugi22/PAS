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

import co.id.pegadaian.pasg2.pojo.TblAnto;

public class TblAntoDAO {
	private Session session;
	
	public TblAntoDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblAnto tblanto){
		session.save(tblanto);
	}
		
	public void delete(TblAnto tblanto){
		session.delete(tblanto);
	}
	
	public void update(TblAnto tblanto){
		session.update(tblanto);
	}
//====================================================================	
	public TblAnto getById(String  nik){
		Criteria criteria =null;
		criteria = session.createCriteria(TblAnto.class);
                    if (nik.length()>0){criteria.add(Restrictions.eq("nik", nik)); 	}

		return (TblAnto)  criteria.uniqueResult();//session.get(TblAnto.class, id);
	}
	
	public List<TblAnto> getAll(){
		return (List<TblAnto>) session.createCriteria(TblAnto.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblAnto.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblAnto> getAll(int start, int rowcount ){
		return (List<TblAnto>) session.createCriteria(TblAnto.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Alamat,String Nik){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblAnto.class);
                    if (Alamat.length()>0){criteria.add(Restrictions.eq("alamat", Alamat)); 	}
                    if (Nik.length()>0){criteria.add(Restrictions.eq("nik", Nik)); 	}
		
		return criteria;
	}

	public List<TblAnto> getBy(String Alamat,String Nik ,int start, int rowcount ){
		Criteria criteria =getCriteria(Alamat,Nik);
		return (List<TblAnto>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Alamat,String Nik, int start, int rowcount  ){
		Criteria criteria =getCriteria(Alamat,Nik);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Alamat,String Nik ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Alamat,Nik,  start,rowcount);//total jumlah row
		List<TblAnto> l = getBy(Alamat,Nik, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblAnto> getBy(String Alamat,String Nik  ){
		Criteria criteria =getCriteria(Alamat,Nik);
		return (List<TblAnto>) criteria.list();
	}


}
