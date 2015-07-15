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

import co.id.pegadaian.pasg2.pojo.PasEaJenisPemeriksaan;

public class PasEaJenisPemeriksaanDAO {
	private Session session;
	
	public PasEaJenisPemeriksaanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasEaJenisPemeriksaan tblpaseajenispemeriksaan){
		session.save(tblpaseajenispemeriksaan);
	}
		
	public void delete(PasEaJenisPemeriksaan tblpaseajenispemeriksaan){
		session.delete(tblpaseajenispemeriksaan);
	}
	
	public void update(PasEaJenisPemeriksaan tblpaseajenispemeriksaan){
		session.update(tblpaseajenispemeriksaan);
	}
//====================================================================	
	public PasEaJenisPemeriksaan getById(String  kodeJenisPemeriksaan){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaJenisPemeriksaan.class);
                    if (kodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", kodeJenisPemeriksaan)); 	}

		return (PasEaJenisPemeriksaan)  criteria.uniqueResult();//session.get(TblPasEaJenisPemeriksaan.class, id);
	}
	
	public List<PasEaJenisPemeriksaan> getAll(){
		return (List<PasEaJenisPemeriksaan>) session.createCriteria(PasEaJenisPemeriksaan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaJenisPemeriksaan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaJenisPemeriksaan> getAll(int start, int rowcount ){
		return (List<PasEaJenisPemeriksaan>) session.createCriteria(PasEaJenisPemeriksaan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaJenisPemeriksaan.class);
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (KodeJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("kodeJenisPemeriksaan", KodeJenisPemeriksaan)); 	}
                    if (NamaJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("namaJenisPemeriksaan", NamaJenisPemeriksaan)); 	}
                    if (KeteranganJenisPemeriksaan.length()>0){criteria.add(Restrictions.eq("keteranganJenisPemeriksaan", KeteranganJenisPemeriksaan)); 	}
		
		return criteria;
	}

	public List<PasEaJenisPemeriksaan> getBy(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan ,int start, int rowcount ){
		Criteria criteria =getCriteria(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan);
		return (List<PasEaJenisPemeriksaan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan, int start, int rowcount  ){
		Criteria criteria =getCriteria(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan,  start,rowcount);//total jumlah row
		List<PasEaJenisPemeriksaan> l = getBy(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaJenisPemeriksaan> getBy(String Status,String KodeJenisPemeriksaan,String NamaJenisPemeriksaan,String KeteranganJenisPemeriksaan  ){
		Criteria criteria =getCriteria(Status,KodeJenisPemeriksaan,NamaJenisPemeriksaan,KeteranganJenisPemeriksaan);
		return (List<PasEaJenisPemeriksaan>) criteria.list();
	}


}
