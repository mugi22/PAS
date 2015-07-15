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

import co.id.pegadaian.pasg2.pojo.TblPasKsHariLibur;

public class TblPasKsHariLiburDAO {
	private Session session;
	
	public TblPasKsHariLiburDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasKsHariLibur tblpasksharilibur){
		session.save(tblpasksharilibur);
	}
		
	public void delete(TblPasKsHariLibur tblpasksharilibur){
		session.delete(tblpasksharilibur);
	}
	
	public void update(TblPasKsHariLibur tblpasksharilibur){
		session.update(tblpasksharilibur);
	}
//====================================================================	
	public TblPasKsHariLibur getById(String  kodeHariLibur){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsHariLibur.class);
                    if (kodeHariLibur.length()>0){criteria.add(Restrictions.eq("kodeHariLibur", kodeHariLibur)); 	}

		return (TblPasKsHariLibur)  criteria.uniqueResult();//session.get(TblPasKsHariLibur.class, id);
	}
	
	public List<TblPasKsHariLibur> getAll(){
		return (List<TblPasKsHariLibur>) session.createCriteria(TblPasKsHariLibur.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasKsHariLibur.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasKsHariLibur> getAll(int start, int rowcount ){
		return (List<TblPasKsHariLibur>) session.createCriteria(TblPasKsHariLibur.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeHariLibur,Date TanggalHariLibur,String KeteranganHariLibur){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsHariLibur.class);
                    if (KodeHariLibur.length()>0){criteria.add(Restrictions.eq("kodeHariLibur", KodeHariLibur)); 	}
                    try {
                    if (TanggalHariLibur.after(formatter.parse("00-00-0000"))){criteria.add(Restrictions.eq("tanggalHariLibur", TanggalHariLibur)); 	}
                    } catch (ParseException e) {
                    e.printStackTrace();
                    }                    if (KeteranganHariLibur.length()>0){criteria.add(Restrictions.eq("keteranganHariLibur", KeteranganHariLibur)); 	}
		
		return criteria;
	}

	public List<TblPasKsHariLibur> getBy(String KodeHariLibur,Date TanggalHariLibur,String KeteranganHariLibur ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeHariLibur,TanggalHariLibur,KeteranganHariLibur);
		return (List<TblPasKsHariLibur>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeHariLibur,Date TanggalHariLibur,String KeteranganHariLibur, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeHariLibur,TanggalHariLibur,KeteranganHariLibur);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeHariLibur,Date TanggalHariLibur,String KeteranganHariLibur ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeHariLibur,TanggalHariLibur,KeteranganHariLibur,  start,rowcount);//total jumlah row
		List<TblPasKsHariLibur> l = getBy(KodeHariLibur,TanggalHariLibur,KeteranganHariLibur, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasKsHariLibur> getBy(String KodeHariLibur,Date TanggalHariLibur,String KeteranganHariLibur  ){
		Criteria criteria =getCriteria(KodeHariLibur,TanggalHariLibur,KeteranganHariLibur);
		return (List<TblPasKsHariLibur>) criteria.list();
	}


}
