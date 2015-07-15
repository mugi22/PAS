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

import co.id.pegadaian.pasg2.pojo.PasEaPPLUser;

public class PasEaPPLUserDAO {
	private Session session;
	
	public PasEaPPLUserDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasEaPPLUser paseappluser){
		session.save(paseappluser);
	}
		
	public void delete(PasEaPPLUser paseappluser){
		session.delete(paseappluser);
	}
	
	public void update(PasEaPPLUser paseappluser){
		session.update(paseappluser);
	}
//====================================================================	
	public PasEaPPLUser getById(String  kodePPLUSer,String  kodeUser){
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaPPLUser.class);
                    if (kodePPLUSer.length()>0){criteria.add(Restrictions.eq("kodePPLUSer", kodePPLUSer)); 	}
                    if (kodeUser.length()>0){criteria.add(Restrictions.eq("kodeUser", kodeUser)); 	}

		return (PasEaPPLUser)  criteria.uniqueResult();//session.get(PasEaPPLUser.class, id);
	}
	
	public List<PasEaPPLUser> getAll(){
		return (List<PasEaPPLUser>) session.createCriteria(PasEaPPLUser.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasEaPPLUser.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasEaPPLUser> getAll(int start, int rowcount ){
		return (List<PasEaPPLUser>) session.createCriteria(PasEaPPLUser.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodePPLUSer,String PenyelenggaraPPL,String KodeUser){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasEaPPLUser.class);
                    if (KodePPLUSer.length()>0){criteria.add(Restrictions.eq("kodePPLUSer", KodePPLUSer)); 	}
                    if (PenyelenggaraPPL.length()>0){criteria.add(Restrictions.eq("penyelenggaraPPL", PenyelenggaraPPL)); 	}
                    if (KodeUser.length()>0){criteria.add(Restrictions.eq("kodeUser", KodeUser)); 	}
		
		return criteria;
	}

	public List<PasEaPPLUser> getBy(String KodePPLUSer,String PenyelenggaraPPL,String KodeUser ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodePPLUSer,PenyelenggaraPPL,KodeUser);
		return (List<PasEaPPLUser>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodePPLUSer,String PenyelenggaraPPL,String KodeUser, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodePPLUSer,PenyelenggaraPPL,KodeUser);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodePPLUSer,String PenyelenggaraPPL,String KodeUser ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodePPLUSer,PenyelenggaraPPL,KodeUser,  start,rowcount);//total jumlah row
		List<PasEaPPLUser> l = getBy(KodePPLUSer,PenyelenggaraPPL,KodeUser, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasEaPPLUser> getBy(String KodePPLUSer,String PenyelenggaraPPL,String KodeUser  ){
		Criteria criteria =getCriteria(KodePPLUSer,PenyelenggaraPPL,KodeUser);
		return (List<PasEaPPLUser>) criteria.list();
	}


}
