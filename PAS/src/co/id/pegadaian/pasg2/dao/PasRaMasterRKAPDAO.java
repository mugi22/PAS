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

import co.id.pegadaian.pasg2.pojo.PasRaMasterRKAP;

public class PasRaMasterRKAPDAO {
	private Session session;
	
	public PasRaMasterRKAPDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasRaMasterRKAP pasramasterrkap){
		session.save(pasramasterrkap);
	}
		
	public void delete(PasRaMasterRKAP pasramasterrkap){
		session.delete(pasramasterrkap);
	}
	
	public void update(PasRaMasterRKAP pasramasterrkap){
		session.update(pasramasterrkap);
	}
//====================================================================	
	public PasRaMasterRKAP getById(String  kodeRKAP){
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaMasterRKAP.class);
                    if (kodeRKAP.length()>0){criteria.add(Restrictions.eq("kodeRKAP", kodeRKAP)); 	}

		return (PasRaMasterRKAP)  criteria.uniqueResult();//session.get(PasRaMasterRKAP.class, id);
	}
	
	public List<PasRaMasterRKAP> getAll(){
		return (List<PasRaMasterRKAP>) session.createCriteria(PasRaMasterRKAP.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasRaMasterRKAP.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasRaMasterRKAP> getAll(int start, int rowcount ){
		return (List<PasRaMasterRKAP>) session.createCriteria(PasRaMasterRKAP.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeRKAP,String TahunRKAP,String StatusRKAP,String KodeKantorAuditorPemilik,String StatusPersetujuan,String StatusPembuatan, String StatusReviu){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaMasterRKAP.class);
                    if (KodeRKAP.length()>0){criteria.add(Restrictions.eq("kodeRKAP", KodeRKAP)); 	}
                    if (TahunRKAP.length()>0){criteria.add(Restrictions.eq("tahunRKAP", TahunRKAP)); 	}
                    if (StatusRKAP.length()>0){criteria.add(Restrictions.eq("statusRKAP", StatusRKAP)); 	}
                    if (KodeKantorAuditorPemilik.length()>0){criteria.add(Restrictions.eq("kodeKantorAuditorPemilik", KodeKantorAuditorPemilik)); 	}
                    if (StatusPersetujuan.length()>0){criteria.add(Restrictions.eq("statusPersetujuan", StatusPersetujuan)); 	}
                    if (StatusPembuatan.length()>0){criteria.add(Restrictions.eq("statusPembuatan", StatusPembuatan)); 	}//
                    if (StatusReviu.length()>0){criteria.add(Restrictions.eq("statusReviu", StatusReviu)); 	}
		return criteria;
	}

	public List<PasRaMasterRKAP> getBy(String KodeRKAP,String TahunRKAP,String StatusRKAP,String KodeKantorAuditorPemilik,String StatusPersetujuan ,String StatusPembuatan,String StatusReviu,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan, StatusPembuatan, StatusReviu);
		return (List<PasRaMasterRKAP>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeRKAP,String TahunRKAP,String StatusRKAP,String KodeKantorAuditorPemilik,String StatusPersetujuan,String StatusPembuatan,String StatusReviu, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan,StatusPembuatan, StatusReviu);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeRKAP,String TahunRKAP,String StatusRKAP,String KodeKantorAuditorPemilik,String StatusPersetujuan,String StatusPembuatan ,String StatusReviu,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan, StatusPembuatan, StatusReviu,  start,rowcount);//total jumlah row
		List<PasRaMasterRKAP> l = getBy(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan,  StatusPembuatan, StatusReviu,start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasRaMasterRKAP> getBy(String KodeRKAP,String TahunRKAP,String StatusRKAP,String KodeKantorAuditorPemilik,String StatusPersetujuan ,String StatusPembuatan,String StatusReviu ){
		Criteria criteria =getCriteria(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan, StatusPembuatan, StatusReviu);
		return (List<PasRaMasterRKAP>) criteria.list();
	}


}
