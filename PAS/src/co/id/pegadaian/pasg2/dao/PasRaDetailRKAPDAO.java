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

import co.id.pegadaian.pasg2.pojo.PasRaDetailRKAP;

public class PasRaDetailRKAPDAO {
	private Session session;
	
	public PasRaDetailRKAPDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasRaDetailRKAP pasradetailrkap){
		session.save(pasradetailrkap);
	}
		
	public void delete(PasRaDetailRKAP pasradetailrkap){
		session.delete(pasradetailrkap);
	}
	
	public void update(PasRaDetailRKAP pasradetailrkap){
		session.update(pasradetailrkap);
	}
//====================================================================	
	public PasRaDetailRKAP getById(String  kodeMataAnggaran,String  kodeRKAP){
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaDetailRKAP.class);
                    if (kodeMataAnggaran.length()>0){criteria.add(Restrictions.eq("kodeMataAnggaran", kodeMataAnggaran)); 	}
                    if (kodeRKAP.length()>0){criteria.add(Restrictions.eq("kodeRKAP", kodeRKAP)); 	}

		return (PasRaDetailRKAP)  criteria.uniqueResult();//session.get(PasRaDetailRKAP.class, id);
	}
	
	public List<PasRaDetailRKAP> getAll(){
		return (List<PasRaDetailRKAP>) session.createCriteria(PasRaDetailRKAP.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasRaDetailRKAP.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasRaDetailRKAP> getAll(int start, int rowcount ){
		return (List<PasRaDetailRKAP>) session.createCriteria(PasRaDetailRKAP.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeMataAnggaran,String KodeRKAP){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaDetailRKAP.class);
                    if (KodeMataAnggaran.length()>0){criteria.add(Restrictions.eq("kodeMataAnggaran", KodeMataAnggaran)); 	}
                    if (KodeRKAP.length()>0){criteria.add(Restrictions.eq("kodeRKAP", KodeRKAP)); 	}
		
		return criteria;
	}

	public List<PasRaDetailRKAP> getBy(String KodeMataAnggaran,String KodeRKAP ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeMataAnggaran,KodeRKAP);
		return (List<PasRaDetailRKAP>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeMataAnggaran,String KodeRKAP, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeMataAnggaran,KodeRKAP);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeMataAnggaran,String KodeRKAP ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeMataAnggaran,KodeRKAP,  start,rowcount);//total jumlah row
		List<PasRaDetailRKAP> l = getBy(KodeMataAnggaran,KodeRKAP, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

	//***** tanpa pagging********
	public Long getByCount(String KodeMataAnggaran,String KodeRKAP ){
		Criteria criteria =getCriteria(KodeMataAnggaran,KodeRKAP);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	public Map<String,Object> getByPerPage(String KodeMataAnggaran,String KodeRKAP  ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeMataAnggaran,KodeRKAP);//total jumlah row
		List<PasRaDetailRKAP> l = getBy(KodeMataAnggaran,KodeRKAP);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}
	
	
	
//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasRaDetailRKAP> getBy(String KodeMataAnggaran,String KodeRKAP  ){
		Criteria criteria =getCriteria(KodeMataAnggaran,KodeRKAP);
		return (List<PasRaDetailRKAP>) criteria.list();
	}


}
