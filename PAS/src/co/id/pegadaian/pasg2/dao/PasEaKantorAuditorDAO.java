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

import co.id.pegadaian.pasg2.pojo.PasEaKantorAuditor;

public class PasEaKantorAuditorDAO {
	private Session session;
	
	public PasEaKantorAuditorDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasEaKantorAuditor tblpaseakantorauditor){
		session.save(tblpaseakantorauditor);
	}
		
	public void delete(PasEaKantorAuditor tblpaseakantorauditor){
		session.delete(tblpaseakantorauditor);
	}
	
	public void update(PasEaKantorAuditor tblpaseakantorauditor){
		session.update(tblpaseakantorauditor);
	}
//====================================================================	
	public PasEaKantorAuditor getById(String  kodeKantor){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaKantorAuditor.class);
                    if (kodeKantor.length()>0){criteria.add(Restrictions.eq("kodeKantor", kodeKantor)); 	}

		return (PasEaKantorAuditor)  criteria.uniqueResult();//session.get(TblPasEaKantorAuditor.class, id);
	}
	
	public List<PasEaKantorAuditor> getAll(){
		return (List<PasEaKantorAuditor>) session.createCriteria(PasEaKantorAuditor.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaKantorAuditor.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaKantorAuditor> getAll(int start, int rowcount ){
		return (List<PasEaKantorAuditor>) session.createCriteria(PasEaKantorAuditor.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaKantorAuditor.class);
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (Nama.length()>0){criteria.add(Restrictions.like("nama", "%"+Nama+"%")); 	}
                    if (KodeTk.length()>0){criteria.add(Restrictions.eq("kodeTk", KodeTk)); 	}
                    if (KodeKantor.length()>0){criteria.add(Restrictions.eq("kodeKantor", KodeKantor)); 	}
                    if (Provinsi.length()>0){criteria.add(Restrictions.eq("provinsi", Provinsi)); 	}
                    if (KodeParent.length()>0){criteria.add(Restrictions.eq("kodeParent", KodeParent)); 	}
		
		return criteria;
	}

	public List<PasEaKantorAuditor> getBy(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent ,int start, int rowcount ){
		Criteria criteria =getCriteria(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent);
		return (List<PasEaKantorAuditor>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent, int start, int rowcount  ){
		Criteria criteria =getCriteria(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	/**
	 * 
	 * @param Status
	 * @param Nama
	 * @param KodeTk
	 * @param KodeKantor
	 * @param Provinsi
	 * @param KodeParent
	 * @param start
	 * @param rowcount
	 * @return
	 */
	public Map<String,Object> getByPerPage(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent,  start,rowcount);//total jumlah row
		List<PasEaKantorAuditor> l = getBy(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

	
	public List<PasEaKantorAuditor> getByKodeTk(String KodeTk ){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaKantorAuditor.class);
                   criteria.add(Restrictions.eq("kodeTk", KodeTk)); 
		return (List<PasEaKantorAuditor>) criteria.list();
	}
	
	public List<PasEaKantorAuditor> getByKodeParent(String KodeParent ){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaKantorAuditor.class);
                   criteria.add(Restrictions.eq("kodeParent", KodeParent)); 
		return (List<PasEaKantorAuditor>) criteria.list();
	}
	
	
//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaKantorAuditor> getBy(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent  ){
		Criteria criteria =getCriteria(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent);
		return (List<PasEaKantorAuditor>) criteria.list();
	}


}
