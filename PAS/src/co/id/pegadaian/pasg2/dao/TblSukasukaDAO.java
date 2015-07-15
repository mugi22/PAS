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

import co.id.pegadaian.pasg2.pojo.TblSukasuka;

public class TblSukasukaDAO {
	private Session session;
	
	public TblSukasukaDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblSukasuka tblsukasuka){
		session.save(tblsukasuka);
	}
		
	public void delete(TblSukasuka tblsukasuka){
		session.delete(tblsukasuka);
	}
	
	public void update(TblSukasuka tblsukasuka){
		session.update(tblsukasuka);
	}
//====================================================================	
	public TblSukasuka getById(String  sukaSukaID){
		Criteria criteria =null;
		criteria = session.createCriteria(TblSukasuka.class);
                    if (sukaSukaID.length()>0){criteria.add(Restrictions.eq("sukaSukaID", sukaSukaID)); 	}

		return (TblSukasuka)  criteria.uniqueResult();//session.get(TblSukasuka.class, id);
	}
	
	public List<TblSukasuka> getAll(){
		return (List<TblSukasuka>) session.createCriteria(TblSukasuka.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblSukasuka.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblSukasuka> getAll(int start, int rowcount ){
		return (List<TblSukasuka>) session.createCriteria(TblSukasuka.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String SukaSukaID,String SukaName,Date SukaTgl,BigDecimal SukaGaji,long SukaJmlx){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblSukasuka.class);
                    if (SukaSukaID.length()>0){criteria.add(Restrictions.eq("sukaSukaID", SukaSukaID)); 	}
                    if (SukaName.length()>0){criteria.add(Restrictions.eq("sukaName", SukaName)); 	}
                    try {
                    if (SukaTgl.after(formatter.parse("00-00-0000"))){criteria.add(Restrictions.eq("sukaTgl", SukaTgl)); 	}
                    } catch (ParseException e) {
                    e.printStackTrace();
                    }                    if (SukaGaji.doubleValue()>0){criteria.add(Restrictions.eq("sukaGaji", SukaGaji)); 	}
                    if (SukaJmlx>0){criteria.add(Restrictions.eq("sukaJmlx", SukaJmlx)); 	}
		
		return criteria;
	}

	public List<TblSukasuka> getBy(String SukaSukaID,String SukaName,Date SukaTgl,BigDecimal SukaGaji,long SukaJmlx ,int start, int rowcount ){
		Criteria criteria =getCriteria(SukaSukaID,SukaName,SukaTgl,SukaGaji,SukaJmlx);
		return (List<TblSukasuka>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String SukaSukaID,String SukaName,Date SukaTgl,BigDecimal SukaGaji,long SukaJmlx, int start, int rowcount  ){
		Criteria criteria =getCriteria(SukaSukaID,SukaName,SukaTgl,SukaGaji,SukaJmlx);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String SukaSukaID,String SukaName,Date SukaTgl,BigDecimal SukaGaji,long SukaJmlx ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(SukaSukaID,SukaName,SukaTgl,SukaGaji,SukaJmlx,  start,rowcount);//total jumlah row
		List<TblSukasuka> l = getBy(SukaSukaID,SukaName,SukaTgl,SukaGaji,SukaJmlx, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblSukasuka> getBy(String SukaSukaID,String SukaName,Date SukaTgl,BigDecimal SukaGaji,long SukaJmlx  ){
		Criteria criteria =getCriteria(SukaSukaID,SukaName,SukaTgl,SukaGaji,SukaJmlx);
		return (List<TblSukasuka>) criteria.list();
	}


}
