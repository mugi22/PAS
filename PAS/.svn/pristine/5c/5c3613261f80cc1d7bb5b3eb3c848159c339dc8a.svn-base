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

import co.id.pegadaian.pasg2.pojo.TblParam;

public class TblParamDAO {
	private Session session;
	
	public TblParamDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblParam tblparam){
		session.save(tblparam);
	}
		
	public void delete(TblParam tblparam){
		session.delete(tblparam);
	}
	
	public void update(TblParam tblparam){
		session.update(tblparam);
	}
//====================================================================	
	public TblParam getById(String  key){
		Criteria criteria =null;
		criteria = session.createCriteria(TblParam.class);
                    if (key.length()>0){criteria.add(Restrictions.eq("key", key)); 	}

		return (TblParam)  criteria.uniqueResult();//session.get(TblParam.class, id);
	}
	
	public List<TblParam> getAll(){
		return (List<TblParam>) session.createCriteria(TblParam.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblParam.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblParam> getAll(int start, int rowcount ){
		return (List<TblParam>) session.createCriteria(TblParam.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Key,String Description){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblParam.class);
                    if (Key.length()>0){criteria.add(Restrictions.eq("key", Key)); 	}
                    if (Description.length()>0){criteria.add(Restrictions.eq("description", Description)); 	}
		
		return criteria;
	}

	public List<TblParam> getBy(String Key,String Description ,int start, int rowcount ){
		Criteria criteria =getCriteria(Key,Description);
		return (List<TblParam>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Key,String Description, int start, int rowcount  ){
		Criteria criteria =getCriteria(Key,Description);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Key,String Description ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Key,Description,  start,rowcount);//total jumlah row
		List<TblParam> l = getBy(Key,Description, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblParam> getBy(String Key,String Description  ){
		Criteria criteria =getCriteria(Key,Description);
		return (List<TblParam>) criteria.list();
	}


}
