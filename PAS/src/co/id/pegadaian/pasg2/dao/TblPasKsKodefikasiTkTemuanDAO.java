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

import co.id.pegadaian.pasg2.pojo.TblPasKsKodefikasiTkTemuan;

public class TblPasKsKodefikasiTkTemuanDAO {
	private Session session;
	
	public TblPasKsKodefikasiTkTemuanDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblPasKsKodefikasiTkTemuan tblpaskskodefikasitktemuan){
		session.save(tblpaskskodefikasitktemuan);
	}
		
	public void delete(TblPasKsKodefikasiTkTemuan tblpaskskodefikasitktemuan){
		session.delete(tblpaskskodefikasitktemuan);
	}
	
	public void update(TblPasKsKodefikasiTkTemuan tblpaskskodefikasitktemuan){
		session.update(tblpaskskodefikasitktemuan);
	}
//====================================================================	
	public TblPasKsKodefikasiTkTemuan getById(String  kodeTkTemuan){
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiTkTemuan.class);
                    if (kodeTkTemuan.length()>0){criteria.add(Restrictions.eq("kodeTkTemuan", kodeTkTemuan)); 	}

		return (TblPasKsKodefikasiTkTemuan)  criteria.uniqueResult();//session.get(TblPasKsKodefikasiTkTemuan.class, id);
	}
	
	public List<TblPasKsKodefikasiTkTemuan> getAll(){
		return (List<TblPasKsKodefikasiTkTemuan>) session.createCriteria(TblPasKsKodefikasiTkTemuan.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblPasKsKodefikasiTkTemuan.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblPasKsKodefikasiTkTemuan> getAll(int start, int rowcount ){
		return (List<TblPasKsKodefikasiTkTemuan>) session.createCriteria(TblPasKsKodefikasiTkTemuan.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String Status,String KodeTkTemuan,String NamaTkTemuan){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblPasKsKodefikasiTkTemuan.class);
                    if (Status.length()>0){criteria.add(Restrictions.eq("status", Status)); 	}
                    if (KodeTkTemuan.length()>0){criteria.add(Restrictions.eq("kodeTkTemuan", KodeTkTemuan)); 	}
                    if (NamaTkTemuan.length()>0){criteria.add(Restrictions.eq("namaTkTemuan", NamaTkTemuan)); 	}
		
		return criteria;
	}

	public List<TblPasKsKodefikasiTkTemuan> getBy(String Status,String KodeTkTemuan,String NamaTkTemuan ,int start, int rowcount ){
		Criteria criteria =getCriteria(Status,KodeTkTemuan,NamaTkTemuan);
		return (List<TblPasKsKodefikasiTkTemuan>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String Status,String KodeTkTemuan,String NamaTkTemuan, int start, int rowcount  ){
		Criteria criteria =getCriteria(Status,KodeTkTemuan,NamaTkTemuan);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String Status,String KodeTkTemuan,String NamaTkTemuan ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(Status,KodeTkTemuan,NamaTkTemuan,  start,rowcount);//total jumlah row
		List<TblPasKsKodefikasiTkTemuan> l = getBy(Status,KodeTkTemuan,NamaTkTemuan, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblPasKsKodefikasiTkTemuan> getBy(String Status,String KodeTkTemuan,String NamaTkTemuan  ){
		Criteria criteria =getCriteria(Status,KodeTkTemuan,NamaTkTemuan);
		return (List<TblPasKsKodefikasiTkTemuan>) criteria.list();
	}


}
