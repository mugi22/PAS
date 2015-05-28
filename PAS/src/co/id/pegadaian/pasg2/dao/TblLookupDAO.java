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

import co.id.pegadaian.pasg2.pojo.TblLookup;

public class TblLookupDAO {
	private Session session;
	
	public TblLookupDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblLookup tbllookup){
		session.save(tbllookup);
	}
		
	public void delete(TblLookup tbllookup){
		session.delete(tbllookup);
	}
	
	public void update(TblLookup tbllookup){
		session.update(tbllookup);
	}
//====================================================================	
	public TblLookup getById(String  lookupName,String  lookupValue){
		Criteria criteria =null;
		criteria = session.createCriteria(TblLookup.class);
                    if (lookupName.length()>0){criteria.add(Restrictions.eq("lookupName", lookupName)); 	}
                    if (lookupValue.length()>0){criteria.add(Restrictions.eq("lookupValue", lookupValue)); 	}

		return (TblLookup)  criteria.uniqueResult();//session.get(TblLookup.class, id);
	}
	
	public List<TblLookup> getAll(){
		return (List<TblLookup>) session.createCriteria(TblLookup.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblLookup.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblLookup> getAll(int start, int rowcount ){
		return (List<TblLookup>) session.createCriteria(TblLookup.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String LookupName,String LookupValue,String LookupLabel){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblLookup.class);
                    if (LookupName.length()>0){criteria.add(Restrictions.eq("lookupName", LookupName)); 	}
                    if (LookupValue.length()>0){criteria.add(Restrictions.eq("lookupValue", LookupValue)); 	}
                    if (LookupLabel.length()>0){criteria.add(Restrictions.eq("lookupLabel", LookupLabel)); 	}
		
		return criteria;
	}

	public List<TblLookup> getBy(String LookupName,String LookupValue,String LookupLabel ,int start, int rowcount ){
		Criteria criteria =getCriteria(LookupName,LookupValue,LookupLabel);
		return (List<TblLookup>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String LookupName,String LookupValue,String LookupLabel, int start, int rowcount  ){
		Criteria criteria =getCriteria(LookupName,LookupValue,LookupLabel);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String LookupName,String LookupValue,String LookupLabel ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(LookupName,LookupValue,LookupLabel,  start,rowcount);//total jumlah row
		List<TblLookup> l = getBy(LookupName,LookupValue,LookupLabel, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

	
	//ambil semua berdasarkan kategori
	public Criteria getCriteria(String LookupName){
		Criteria criteria =null;
		criteria = session.createCriteria(TblLookup.class);
//                    if (LookupValue.length()>0){criteria.add(Restrictions.eq("lookupValue", LookupValue)); 	}
                    if (LookupName.length()>0){criteria.add(Restrictions.eq("lookupName", LookupName)); 	}
		
		return criteria;
	}
	//ambil semua
	public List<TblLookup> getBy(String LookupName ){
		Criteria criteria =getCriteria(LookupName);
		return (List<TblLookup>) criteria.list();
	}
	
//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblLookup> getBy(String LookupName,String LookupValue,String LookupLabel  ){
		Criteria criteria =getCriteria(LookupName,LookupValue,LookupLabel);
		return (List<TblLookup>) criteria.list();
	}


}