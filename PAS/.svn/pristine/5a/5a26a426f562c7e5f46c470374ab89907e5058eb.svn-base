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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import co.id.pegadaian.pasg2.pojo.PasRaKegiatanRKBPT;

public class PasRaKegiatanRKBPTDAO {
	private Session session;
	
	public PasRaKegiatanRKBPTDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasRaKegiatanRKBPT pasrakegiatanrkbpt){
		session.save(pasrakegiatanrkbpt);
	}
		
	public void delete(PasRaKegiatanRKBPT pasrakegiatanrkbpt){
		session.delete(pasrakegiatanrkbpt);
	}
	
	public void update(PasRaKegiatanRKBPT pasrakegiatanrkbpt){
		session.update(pasrakegiatanrkbpt);
	}
//====================================================================	
	public PasRaKegiatanRKBPT getById(String  kodeKegiatanRKBPT,String  kodeRKBPT){
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaKegiatanRKBPT.class);
                    if (kodeKegiatanRKBPT.length()>0){criteria.add(Restrictions.eq("kodeKegiatanRKBPT", kodeKegiatanRKBPT)); 	}
                    if (kodeRKBPT.length()>0){criteria.add(Restrictions.eq("kodeRKBPT", kodeRKBPT)); 	}

		return (PasRaKegiatanRKBPT)  criteria.uniqueResult();//session.get(PasRaKegiatanRKBPT.class, id);
	}
	
	public List<PasRaKegiatanRKBPT> getAll(){
		return (List<PasRaKegiatanRKBPT>) session.createCriteria(PasRaKegiatanRKBPT.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasRaKegiatanRKBPT.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasRaKegiatanRKBPT> getAll(int start, int rowcount ){
		return (List<PasRaKegiatanRKBPT>) session.createCriteria(PasRaKegiatanRKBPT.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String KodeKegiatanRKBPT,String KeteranganKegiatan,String KodeRKBPT){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaKegiatanRKBPT.class);
                    if (KodeKegiatanRKBPT.length()>0){criteria.add(Restrictions.eq("kodeKegiatanRKBPT", KodeKegiatanRKBPT)); 	}
                    if (KeteranganKegiatan.length()>0){criteria.add(Restrictions.eq("keteranganKegiatan", KeteranganKegiatan)); 	}
                    if (KodeRKBPT.length()>0){criteria.add(Restrictions.eq("kodeRKBPT", KodeRKBPT)); 	}
                    criteria.addOrder(Order.asc("tanggalAwal"));
		return criteria;
	}

	public List<PasRaKegiatanRKBPT> getBy(String KodeKegiatanRKBPT,String KeteranganKegiatan,String KodeRKBPT ,int start, int rowcount ){
		Criteria criteria =getCriteria(KodeKegiatanRKBPT,KeteranganKegiatan,KodeRKBPT);
		return (List<PasRaKegiatanRKBPT>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String KodeKegiatanRKBPT,String KeteranganKegiatan,String KodeRKBPT, int start, int rowcount  ){
		Criteria criteria =getCriteria(KodeKegiatanRKBPT,KeteranganKegiatan,KodeRKBPT);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeKegiatanRKBPT,String KeteranganKegiatan,String KodeRKBPT ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeKegiatanRKBPT,KeteranganKegiatan,KodeRKBPT,  start,rowcount);//total jumlah row
		List<PasRaKegiatanRKBPT> l = getBy(KodeKegiatanRKBPT,KeteranganKegiatan,KodeRKBPT, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

	//tanpa paging
	public Long getByCount(String KodeKegiatanRKBPT,String KeteranganKegiatan,String KodeRKBPT ){
		Criteria criteria =getCriteria( KodeKegiatanRKBPT, KeteranganKegiatan, KodeRKBPT);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String KodeKegiatanRKBPT,String KeteranganKegiatan,String KodeRKBPT){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(KodeKegiatanRKBPT,KeteranganKegiatan,KodeRKBPT);//total jumlah row
		List<PasRaKegiatanRKBPT> l = getBy(KodeKegiatanRKBPT,KeteranganKegiatan,KodeRKBPT);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}
	/**
	 * Cek overlap tanggal
	 * @param KodeRKBPT
	 * @param tgl
	 * @return
	 */
	public List<PasRaKegiatanRKBPT> getTglAwalAndTglAkhir(String KodeRKBPT,Date tgl ){
		Criteria criteria =  session.createCriteria(PasRaKegiatanRKBPT.class);
		criteria.add(Restrictions.le("tanggalAwal", tgl))
		.add(Restrictions.ge("tanggalAkhir", tgl))
		.add(Restrictions.eq("kodeRKBPT", KodeRKBPT))	;
		return  (List<PasRaKegiatanRKBPT>) criteria.list();
	}
	
//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasRaKegiatanRKBPT> getBy(String KodeKegiatanRKBPT,String KeteranganKegiatan,String KodeRKBPT  ){
		Criteria criteria =getCriteria(KodeKegiatanRKBPT,KeteranganKegiatan,KodeRKBPT);
		return (List<PasRaKegiatanRKBPT>) criteria.list();
	}


}
