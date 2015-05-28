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

import co.id.pegadaian.pasg2.pojo.TblPasEaKantorAuditor;

public class TblPasEaKantorAuditorDAO {
	private Session session;
	
	public TblPasEaKantorAuditorDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasEaKantorAuditor tblpaseakantorauditor){
		session.save(tblpaseakantorauditor);
	}
		
	public void delete(TblPasEaKantorAuditor tblpaseakantorauditor){
		session.delete(tblpaseakantorauditor);
	}
	
	public void update(TblPasEaKantorAuditor tblpaseakantorauditor){
		session.update(tblpaseakantorauditor);
	}
//====================================================================	
	public TblPasEaKantorAuditor getById(String  kodeKantor){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaKantorAuditor.class);
                    if (kodeKantor.length()>0){criteria.add(Restrictions.eq("kodeKantor", kodeKantor)); 	}

		return (TblPasEaKantorAuditor)  criteria.uniqueResult();//session.get(TblPasEaKantorAuditor.class, id);
	}
	
	public List<TblPasEaKantorAuditor> getAll(){
		return (List<TblPasEaKantorAuditor>) session.createCriteria(TblPasEaKantorAuditor.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasEaKantorAuditor.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasEaKantorAuditor> getAll(int start, int rowcount ){
		return (List<TblPasEaKantorAuditor>) session.createCriteria(TblPasEaKantorAuditor.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaKantorAuditor.class);
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (Nama.length()>0){criteria.add(Restrictions.eq("nama", Nama)); 	}
                    if (KodeTk.length()>0){criteria.add(Restrictions.eq("kodeTk", KodeTk)); 	}
                    if (KodeKantor.length()>0){criteria.add(Restrictions.eq("kodeKantor", KodeKantor)); 	}
                    if (Provinsi.length()>0){criteria.add(Restrictions.eq("provinsi", Provinsi)); 	}
                    if (KodeParent.length()>0){criteria.add(Restrictions.eq("kodeParent", KodeParent)); 	}
		
		return criteria;
	}

	public List<TblPasEaKantorAuditor> getBy(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent ,int start, int rowcount ){
		Criteria criteria =getCriteria(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent);
		return (List<TblPasEaKantorAuditor>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent, int start, int rowcount  ){
		Criteria criteria =getCriteria(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent,  start,rowcount);//total jumlah row
		List<TblPasEaKantorAuditor> l = getBy(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

	
	public List<TblPasEaKantorAuditor> getByKodeTk(String KodeTk ){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasEaKantorAuditor.class);
                   criteria.add(Restrictions.eq("kodeTk", KodeTk)); 
		return (List<TblPasEaKantorAuditor>) criteria.list();
	}
	
//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasEaKantorAuditor> getBy(String Status,String Nama,String KodeTk,String KodeKantor,String Provinsi,String KodeParent  ){
		Criteria criteria =getCriteria(Status,Nama,KodeTk,KodeKantor,Provinsi,KodeParent);
		return (List<TblPasEaKantorAuditor>) criteria.list();
	}


}
