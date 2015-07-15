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

import co.id.pegadaian.pasg2.pojo.PasRaPKPT;

public class PasRaPKPTDAO {
	private Session session;
	
	public PasRaPKPTDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasRaPKPT pasrapkpt){
		session.save(pasrapkpt);
	}
		
	public void delete(PasRaPKPT pasrapkpt){
		session.delete(pasrapkpt);
	}
	
	public void update(PasRaPKPT pasrapkpt){
		session.update(pasrapkpt);
	}
//====================================================================	
	public PasRaPKPT getById(String  kodePKPT){
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaPKPT.class);
                    if (kodePKPT.length()>0){criteria.add(Restrictions.eq("kodePKPT", kodePKPT)); 	}

		return (PasRaPKPT)  criteria.uniqueResult();//session.get(PasRaPKPT.class, id);
	}
	
	public List<PasRaPKPT> getAll(){
		return (List<PasRaPKPT>) session.createCriteria(PasRaPKPT.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasRaPKPT.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasRaPKPT> getAll(int start, int rowcount ){
		return (List<PasRaPKPT>) session.createCriteria(PasRaPKPT.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeKantorAuditorPemilik,String StatusReviu,String KodePKPT,String TahunPKPT,String StatusPKPT){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaPKPT.class);
                    if (KodeKantorAuditorPemilik.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditorPemilik", KodeKantorAuditorPemilik)); 	}
                    if (StatusReviu.length()>0){criteria.add(Restrictions.eq("statusReviu", StatusReviu)); 	}
                    if (KodePKPT.length()>0){criteria.add(Restrictions.eq("kodePKPT", KodePKPT)); 	}
                    if (TahunPKPT.length()>0){criteria.add(Restrictions.eq("tahunPKPT", TahunPKPT)); 	}
                    if (StatusPKPT.length()>0){criteria.add(Restrictions.eq("statusPKPT", StatusPKPT)); 	}
		
		return criteria;
	}

	public List<PasRaPKPT> getBy(String KodeKantorAuditorPemilik,String StatusReviu,String KodePKPT,String TahunPKPT,String StatusPKPT ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeKantorAuditorPemilik,StatusReviu,KodePKPT,TahunPKPT,StatusPKPT);
		return (List<PasRaPKPT>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeKantorAuditorPemilik,String StatusReviu,String KodePKPT,String TahunPKPT,String StatusPKPT, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeKantorAuditorPemilik,StatusReviu,KodePKPT,TahunPKPT,StatusPKPT);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeKantorAuditorPemilik,String StatusReviu,String KodePKPT,String TahunPKPT,String StatusPKPT ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeKantorAuditorPemilik,StatusReviu,KodePKPT,TahunPKPT,StatusPKPT,  start,rowcount);//total jumlah row
		List<PasRaPKPT> l = getBy(KodeKantorAuditorPemilik,StatusReviu,KodePKPT,TahunPKPT,StatusPKPT, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasRaPKPT> getBy(String KodeKantorAuditorPemilik,String StatusReviu,String KodePKPT,String TahunPKPT,String StatusPKPT  ){
		Criteria criteria =getCriteria(KodeKantorAuditorPemilik,StatusReviu,KodePKPT,TahunPKPT,StatusPKPT);
		return (List<PasRaPKPT>) criteria.list();
	}


}
