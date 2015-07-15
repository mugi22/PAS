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

import co.id.pegadaian.pasg2.pojo.PasKsAuditTrail;

public class PasKsAuditTrailDAO {
	private Session session;
	
	public PasKsAuditTrailDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasKsAuditTrail pasksaudittrail){
		session.save(pasksaudittrail);
	}
		
	public void delete(PasKsAuditTrail pasksaudittrail){
		session.delete(pasksaudittrail);
	}
	
	public void update(PasKsAuditTrail pasksaudittrail){
		session.update(pasksaudittrail);
	}
//====================================================================	
	public PasKsAuditTrail getById(long  kodeAuditTrail){
		Criteria criteria =null;
		criteria = session.createCriteria(PasKsAuditTrail.class);
                    if (kodeAuditTrail>0){criteria.add(Restrictions.eq("kodeAuditTrail", kodeAuditTrail)); 	}

		return (PasKsAuditTrail)  criteria.uniqueResult();//session.get(PasKsAuditTrail.class, id);
	}
	
	public List<PasKsAuditTrail> getAll(){
		return (List<PasKsAuditTrail>) session.createCriteria(PasKsAuditTrail.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasKsAuditTrail.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasKsAuditTrail> getAll(int start, int rowcount ){
		return (List<PasKsAuditTrail>) session.createCriteria(PasKsAuditTrail.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String AlamatIP,long KodeRecord,String NamaTable,String Aksi,String KodeUserPelaku,long KodeAuditTrail,String NamaKomputer){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasKsAuditTrail.class);
                    if (AlamatIP.length()>0){criteria.add(Restrictions.eq("alamatIP", AlamatIP)); 	}
                    if (KodeRecord>0){criteria.add(Restrictions.eq("kodeRecord", KodeRecord)); 	}
                    if (NamaTable.length()>0){criteria.add(Restrictions.eq("namaTable", NamaTable)); 	}
                    if (Aksi.length()>0){criteria.add(Restrictions.eq("aksi", Aksi)); 	}
                    if (KodeUserPelaku.length()>0){criteria.add(Restrictions.eq("kodeUserPelaku", KodeUserPelaku)); 	}
                    if (KodeAuditTrail>0){criteria.add(Restrictions.eq("kodeAuditTrail", KodeAuditTrail)); 	}
                    if (NamaKomputer.length()>0){criteria.add(Restrictions.eq("namaKomputer", NamaKomputer)); 	}
		
		return criteria;
	}

	public List<PasKsAuditTrail> getBy(String AlamatIP,long KodeRecord,String NamaTable,String Aksi,String KodeUserPelaku,long KodeAuditTrail,String NamaKomputer ,int start, int rowcount ){
		Criteria criteria =getCriteria(AlamatIP,KodeRecord,NamaTable,Aksi,KodeUserPelaku,KodeAuditTrail,NamaKomputer);
		return (List<PasKsAuditTrail>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String AlamatIP,long KodeRecord,String NamaTable,String Aksi,String KodeUserPelaku,long KodeAuditTrail,String NamaKomputer, int start, int rowcount  ){
		Criteria criteria =getCriteria(AlamatIP,KodeRecord,NamaTable,Aksi,KodeUserPelaku,KodeAuditTrail,NamaKomputer);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String AlamatIP,long KodeRecord,String NamaTable,String Aksi,String KodeUserPelaku,long KodeAuditTrail,String NamaKomputer ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(AlamatIP,KodeRecord,NamaTable,Aksi,KodeUserPelaku,KodeAuditTrail,NamaKomputer,  start,rowcount);//total jumlah row
		List<PasKsAuditTrail> l = getBy(AlamatIP,KodeRecord,NamaTable,Aksi,KodeUserPelaku,KodeAuditTrail,NamaKomputer, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasKsAuditTrail> getBy(String AlamatIP,long KodeRecord,String NamaTable,String Aksi,String KodeUserPelaku,long KodeAuditTrail,String NamaKomputer  ){
		Criteria criteria =getCriteria(AlamatIP,KodeRecord,NamaTable,Aksi,KodeUserPelaku,KodeAuditTrail,NamaKomputer);
		return (List<PasKsAuditTrail>) criteria.list();
	}


}
