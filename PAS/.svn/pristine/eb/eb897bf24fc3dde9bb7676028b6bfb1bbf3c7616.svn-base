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

import co.id.pegadaian.pasg2.pojo.TblBuzz;

public class TblBuzzDAO {
	private Session session;
	
	public TblBuzzDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblBuzz tblbuzz){
		session.save(tblbuzz);
	}
		
	public void delete(TblBuzz tblbuzz){
		session.delete(tblbuzz);
	}
	
	public void update(TblBuzz tblbuzz){
		session.update(tblbuzz);
	}
//====================================================================	
	public TblBuzz getById(String  nik){
		Criteria criteria =null;
		criteria = session.createCriteria(TblBuzz.class);
                    if (nik.length()>0){criteria.add(Restrictions.eq("nik", nik)); 	}

		return (TblBuzz)  criteria.uniqueResult();//session.get(TblBuzz.class, id);
	}
	
	public List<TblBuzz> getAll(){
		return (List<TblBuzz>) session.createCriteria(TblBuzz.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblBuzz.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblBuzz> getAll(int start, int rowcount ){
		return (List<TblBuzz>) session.createCriteria(TblBuzz.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Nik,String Nama,Date Tgl_Masuk){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblBuzz.class);
                    if (Nik.length()>0){criteria.add(Restrictions.eq("nik", Nik)); 	}
                    if (Nama.length()>0){criteria.add(Restrictions.eq("nama", Nama)); 	}
                    try {
                    if (Tgl_Masuk.after(formatter.parse("00-00-0000"))){criteria.add(Restrictions.eq("tgl_Masuk", Tgl_Masuk)); 	}
                    } catch (ParseException e) {
                    e.printStackTrace();
                    }		
		return criteria;
	}

	public List<TblBuzz> getBy(String Nik,String Nama,Date Tgl_Masuk ,int start, int rowcount ){
		Criteria criteria =getCriteria(Nik,Nama,Tgl_Masuk);
		return (List<TblBuzz>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Nik,String Nama,Date Tgl_Masuk, int start, int rowcount  ){
		Criteria criteria =getCriteria(Nik,Nama,Tgl_Masuk);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Nik,String Nama,Date Tgl_Masuk ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Nik,Nama,Tgl_Masuk,  start,rowcount);//total jumlah row
		List<TblBuzz> l = getBy(Nik,Nama,Tgl_Masuk, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblBuzz> getBy(String Nik,String Nama,Date Tgl_Masuk  ){
		Criteria criteria =getCriteria(Nik,Nama,Tgl_Masuk);
		return (List<TblBuzz>) criteria.list();
	}


}
