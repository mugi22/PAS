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

import co.id.pegadaian.pasg2.pojo.TblRekeningIaMaster;

public class TblRekeningIaMasterDAO {
	private Session session;
	
	public TblRekeningIaMasterDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblRekeningIaMaster tblrekeningiamaster){
		session.save(tblrekeningiamaster);
	}
		
	public void delete(TblRekeningIaMaster tblrekeningiamaster){
		session.delete(tblrekeningiamaster);
	}
	
	public void update(TblRekeningIaMaster tblrekeningiamaster){
		session.update(tblrekeningiamaster);
	}
//====================================================================	
	public TblRekeningIaMaster getById(String  noRek){
		Criteria criteria =null;
		criteria = session.createCriteria(TblRekeningIaMaster.class);
                    if (noRek.length()>0){criteria.add(Restrictions.eq("noRek", noRek)); 	}

		return (TblRekeningIaMaster)  criteria.uniqueResult();//session.get(TblRekeningIaMaster.class, id);
	}
	
	public List<TblRekeningIaMaster> getAll(){
		return (List<TblRekeningIaMaster>) session.createCriteria(TblRekeningIaMaster.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblRekeningIaMaster.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblRekeningIaMaster> getAll(int start, int rowcount ){
		return (List<TblRekeningIaMaster>) session.createCriteria(TblRekeningIaMaster.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Description,String NoRek,String NoCoa){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblRekeningIaMaster.class);
                    if (Description.length()>0){criteria.add(Restrictions.like("description", "%"+Description+"%")); 	}
                    if (NoRek.length()>0){criteria.add(Restrictions.eq("noRek", NoRek)); 	}
                    if (NoCoa.length()>0){criteria.add(Restrictions.eq("noCoa", NoCoa)); 	}
		
		return criteria;
	}

	public List<TblRekeningIaMaster> getBy(String Description,String NoRek,String NoCoa ,int start, int rowcount ){
		Criteria criteria =getCriteria(Description,NoRek,NoCoa);
		return (List<TblRekeningIaMaster>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Description,String NoRek,String NoCoa, int start, int rowcount  ){
		Criteria criteria =getCriteria(Description,NoRek,NoCoa);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Description,String NoRek,String NoCoa ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Description,NoRek,NoCoa,  start,rowcount);//total jumlah row
		List<TblRekeningIaMaster> l = getBy(Description,NoRek,NoCoa, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblRekeningIaMaster> getBy(String Description,String NoRek,String NoCoa  ){
		Criteria criteria =getCriteria(Description,NoRek,NoCoa);
		return (List<TblRekeningIaMaster>) criteria.list();
	}


}
