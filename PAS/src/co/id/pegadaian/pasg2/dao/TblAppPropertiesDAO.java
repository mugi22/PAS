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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import co.id.pegadaian.pasg2.pojo.TblAppProperties;

public class TblAppPropertiesDAO {
	private Session session;
	
	public TblAppPropertiesDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblAppProperties tblappproperties){
		session.save(tblappproperties);
	}
	
	public void saveOrUpdate(TblAppProperties tblappproperties){
		session.saveOrUpdate(tblappproperties);
	}
	
	
	public void delete(TblAppProperties tblappproperties){
		session.delete(tblappproperties);
	}
	
	public void update(TblAppProperties tblappproperties){
		session.update(tblappproperties);
	}
//====================================================================	
	public TblAppProperties getById(String  propertiesNama){
		Criteria criteria =null;
		criteria = session.createCriteria(TblAppProperties.class);
                    if (propertiesNama.length()>0){criteria.add(Restrictions.eq("propertiesNama", propertiesNama)); 	}

		return (TblAppProperties)  criteria.uniqueResult();//session.get(TblAppProperties.class, id);
	}
	
	public List<TblAppProperties> getAll(){
		return (List<TblAppProperties>) session.createCriteria(TblAppProperties.class).addOrder(Order.asc("propertiesNama")).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblAppProperties.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblAppProperties> getAll(int start, int rowcount ){
		return (List<TblAppProperties>) session.createCriteria(TblAppProperties.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String PropertiesValue,String PropertiesNama){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblAppProperties.class);
                    if (PropertiesValue.length()>0){criteria.add(Restrictions.eq("propertiesValue", PropertiesValue)); 	}
                    if (PropertiesNama.length()>0){criteria.add(Restrictions.eq("propertiesNama", PropertiesNama)); 	}
		
		return criteria;
	}

	public List<TblAppProperties> getBy(String PropertiesValue,String PropertiesNama ,int start, int rowcount ){
		Criteria criteria =getCriteria(PropertiesValue,PropertiesNama);
		return (List<TblAppProperties>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String PropertiesValue,String PropertiesNama, int start, int rowcount  ){
		Criteria criteria =getCriteria(PropertiesValue,PropertiesNama);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String PropertiesValue,String PropertiesNama ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(PropertiesValue,PropertiesNama,  start,rowcount);//total jumlah row
		List<TblAppProperties> l = getBy(PropertiesValue,PropertiesNama, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblAppProperties> getBy(String PropertiesValue,String PropertiesNama  ){
		Criteria criteria =getCriteria(PropertiesValue,PropertiesNama);
		return (List<TblAppProperties>) criteria.list();
	}


}
