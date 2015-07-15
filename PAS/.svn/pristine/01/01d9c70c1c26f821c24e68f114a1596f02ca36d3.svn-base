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

import co.id.pegadaian.pasg2.pojo.PasEaFormasiAuditan;

public class PasEaFormasiAuditanDAO {
	private Session session;
	
	public PasEaFormasiAuditanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasEaFormasiAuditan paseaformasiauditan){
		session.save(paseaformasiauditan);
	}
		
	public void delete(PasEaFormasiAuditan paseaformasiauditan){
		session.delete(paseaformasiauditan);
	}
	
	public void update(PasEaFormasiAuditan paseaformasiauditan){
		session.update(paseaformasiauditan);
	}
//====================================================================	
	public PasEaFormasiAuditan getById(String  kodeTkAuditan,String  kodeAuditan,String  kodeFormasiAuditan){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaFormasiAuditan.class);
                    if (kodeTkAuditan.length()>0){criteria.add(Restrictions.eq("kodeTkAuditan", kodeTkAuditan)); 	}
                    if (kodeAuditan.length()>0){criteria.add(Restrictions.eq("kodeAuditan", kodeAuditan)); 	}
                    if (kodeFormasiAuditan.length()>0){criteria.add(Restrictions.eq("kodeFormasiAuditan", kodeFormasiAuditan)); 	}

		return (PasEaFormasiAuditan)  criteria.uniqueResult();//session.get(PasEaFormasiAuditan.class, id);
	}
	
	public List<PasEaFormasiAuditan> getAll(){
		return (List<PasEaFormasiAuditan>) session.createCriteria(PasEaFormasiAuditan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaFormasiAuditan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaFormasiAuditan> getAll(int start, int rowcount ){
		return (List<PasEaFormasiAuditan>) session.createCriteria(PasEaFormasiAuditan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Nama,String KodeTkAuditan,String KodeAuditan,String KodeFormasiAuditan){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaFormasiAuditan.class);
                    if (Nama.length()>0){criteria.add(Restrictions.eq("nama", Nama)); 	}
                    if (KodeTkAuditan.length()>0){criteria.add(Restrictions.eq("kodeTkAuditan", KodeTkAuditan)); 	}
                    if (KodeAuditan.length()>0){criteria.add(Restrictions.eq("kodeAuditan", KodeAuditan)); 	}
                    if (KodeFormasiAuditan.length()>0){criteria.add(Restrictions.eq("kodeFormasiAuditan", KodeFormasiAuditan)); 	}
		
		return criteria;
	}

	public List<PasEaFormasiAuditan> getBy(String Nama,String KodeTkAuditan,String KodeAuditan,String KodeFormasiAuditan ,int start, int rowcount ){
		Criteria criteria =getCriteria(Nama,KodeTkAuditan,KodeAuditan,KodeFormasiAuditan);
		return (List<PasEaFormasiAuditan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Nama,String KodeTkAuditan,String KodeAuditan,String KodeFormasiAuditan, int start, int rowcount  ){
		Criteria criteria =getCriteria(Nama,KodeTkAuditan,KodeAuditan,KodeFormasiAuditan);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Nama,String KodeTkAuditan,String KodeAuditan,String KodeFormasiAuditan ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Nama,KodeTkAuditan,KodeAuditan,KodeFormasiAuditan,  start,rowcount);//total jumlah row
		List<PasEaFormasiAuditan> l = getBy(Nama,KodeTkAuditan,KodeAuditan,KodeFormasiAuditan, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaFormasiAuditan> getBy(String Nama,String KodeTkAuditan,String KodeAuditan,String KodeFormasiAuditan  ){
		Criteria criteria =getCriteria(Nama,KodeTkAuditan,KodeAuditan,KodeFormasiAuditan);
		return (List<PasEaFormasiAuditan>) criteria.list();
	}


}
