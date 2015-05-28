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

import co.id.pegadaian.pasg2.pojo.TblPasEaJenisPemeriksaan;

public class TblPasEaJenisPemeriksaanDAO {
	private Session session;
	
	public TblPasEaJenisPemeriksaanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasEaJenisPemeriksaan tblpaseajenispemeriksaan){
		session.save(tblpaseajenispemeriksaan);
	}
		
	public void delete(TblPasEaJenisPemeriksaan tblpaseajenispemeriksaan){
		session.delete(tblpaseajenispemeriksaan);
	}
	
	public void update(TblPasEaJenisPemeriksaan tblpaseajenispemeriksaan){
		session.update(tblpaseajenispemeriksaan);
	}
//====================================================================	
	public TblPasEaJenisPemeriksaan getById(String  kodeJenisPemeriksaan){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaJenisPemeriksaan.class);
                    if (kodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", kodeJenisPemeriksaan)); 	}

		return (TblPasEaJenisPemeriksaan)  criteria.uniqueResult();//session.get(TblPasEaJenisPemeriksaan.class, id);
	}
	
	public List<TblPasEaJenisPemeriksaan> getAll(){
		return (List<TblPasEaJenisPemeriksaan>) session.createCriteria(TblPasEaJenisPemeriksaan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasEaJenisPemeriksaan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasEaJenisPemeriksaan> getAll(int start, int rowcount ){
		return (List<TblPasEaJenisPemeriksaan>) session.createCriteria(TblPasEaJenisPemeriksaan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaJenisPemeriksaan.class);
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (KodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", KodeJenisPemeriksaan)); 	}
                    if (NamaJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("namaJenisPemeriksaan", NamaJenisPemeriksaan)); 	}
                    if (KeteranganJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("keteranganJenisPemeriksaan", KeteranganJenisPemeriksaan)); 	}
		
		return criteria;
	}

	public List<TblPasEaJenisPemeriksaan> getBy(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan ,int start, int rowcount ){
		Criteria criteria =getCriteria(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan);
		return (List<TblPasEaJenisPemeriksaan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan, int start, int rowcount  ){
		Criteria criteria =getCriteria(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan,  start,rowcount);//total jumlah row
		List<TblPasEaJenisPemeriksaan> l = getBy(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasEaJenisPemeriksaan> getBy(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan  ){
		Criteria criteria =getCriteria(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan);
		return (List<TblPasEaJenisPemeriksaan>) criteria.list();
	}


}
