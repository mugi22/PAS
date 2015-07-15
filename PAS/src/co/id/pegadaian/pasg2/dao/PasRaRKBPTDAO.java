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

import co.id.pegadaian.pasg2.pojo.PasRaRKBPT;

public class PasRaRKBPTDAO {
	private Session session;
	
	public PasRaRKBPTDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasRaRKBPT pasrarkbpt){
		session.save(pasrarkbpt);
	}
		
	public void delete(PasRaRKBPT pasrarkbpt){
		session.delete(pasrarkbpt);
	}
	
	public void update(PasRaRKBPT pasrarkbpt){
		session.update(pasrarkbpt);
	}
//====================================================================	
	public PasRaRKBPT getById(String  kodeRKBPT){
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaRKBPT.class);
                    if (kodeRKBPT.length()>0){criteria.add(Restrictions.eq("kodeRKBPT", kodeRKBPT)); 	}

		return (PasRaRKBPT)  criteria.uniqueResult();//session.get(PasRaRKBPT.class, id);
	}
	
	public List<PasRaRKBPT> getAll(){
		return (List<PasRaRKBPT>) session.createCriteria(PasRaRKBPT.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasRaRKBPT.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasRaRKBPT> getAll(int start, int rowcount ){
		return (List<PasRaRKBPT>) session.createCriteria(PasRaRKBPT.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeKantorAuditorPemilik,String StatusPembuatan,String StatusReviu,String StatusPerstujuan,String StatusRKBPT,String TahunRKBPT){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaRKBPT.class);
                    if (KodeKantorAuditorPemilik.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditorPemilik", KodeKantorAuditorPemilik)); 	}
                    if (StatusPembuatan.length()>0){criteria.add(Restrictions.eq("statusPembuatan", StatusPembuatan)); 	}
                    if (StatusReviu.length()>0){criteria.add(Restrictions.eq("statusReviu", StatusReviu)); 	}
                    if (StatusPerstujuan.length()>0){criteria.add(Restrictions.eq("statusPerstujuan", StatusPerstujuan)); 	}
                    if (StatusRKBPT.length()>0){criteria.add(Restrictions.eq("statusRKBPT", StatusRKBPT)); 	}
                    if (TahunRKBPT.length()>0){criteria.add(Restrictions.eq("tahunRKBPT", TahunRKBPT)); 	}
		
		return criteria;
	}

	public List<PasRaRKBPT> getBy(String KodeKantorAuditorPemilik,String StatusPembuatan,String StatusReviu,String StatusPerstujuan,String StatusRKBPT,String TahunRKBPT ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeKantorAuditorPemilik,StatusPembuatan,StatusReviu,StatusPerstujuan,StatusRKBPT,TahunRKBPT);
		return (List<PasRaRKBPT>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeKantorAuditorPemilik,String StatusPembuatan,String StatusReviu,String StatusPerstujuan,String StatusRKBPT,String TahunRKBPT, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeKantorAuditorPemilik,StatusPembuatan,StatusReviu,StatusPerstujuan,StatusRKBPT,TahunRKBPT);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeKantorAuditorPemilik,String StatusPembuatan,String StatusReviu,String StatusPerstujuan,String StatusRKBPT,String TahunRKBPT ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeKantorAuditorPemilik,StatusPembuatan,StatusReviu,StatusPerstujuan,StatusRKBPT,TahunRKBPT,  start,rowcount);//total jumlah row
		List<PasRaRKBPT> l = getBy(KodeKantorAuditorPemilik,StatusPembuatan,StatusReviu,StatusPerstujuan,StatusRKBPT,TahunRKBPT, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasRaRKBPT> getBy(String KodeKantorAuditorPemilik,String StatusPembuatan,String StatusReviu,String StatusPerstujuan,String StatusRKBPT,String TahunRKBPT  ){
		Criteria criteria =getCriteria(KodeKantorAuditorPemilik,StatusPembuatan,StatusReviu,StatusPerstujuan,StatusRKBPT,TahunRKBPT);
		return (List<PasRaRKBPT>) criteria.list();
	}


}
