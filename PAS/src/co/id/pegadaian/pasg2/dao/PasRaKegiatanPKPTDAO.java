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

import co.id.pegadaian.pasg2.pojo.PasRaKegiatanPKPT;

public class PasRaKegiatanPKPTDAO {
	private Session session;
	
	public PasRaKegiatanPKPTDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(PasRaKegiatanPKPT pasrakegiatanpkpt){
		session.save(pasrakegiatanpkpt);
	}
		
	public void delete(PasRaKegiatanPKPT pasrakegiatanpkpt){
		session.delete(pasrakegiatanpkpt);
	}
	
	public void update(PasRaKegiatanPKPT pasrakegiatanpkpt){
		session.update(pasrakegiatanpkpt);
	}
//====================================================================	
	public PasRaKegiatanPKPT getById(String  kodeKegiatanPKPT,String  kodePKPT){
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaKegiatanPKPT.class);
                    if (kodeKegiatanPKPT.length()>0){criteria.add(Restrictions.eq("kodeKegiatanPKPT", kodeKegiatanPKPT)); 	}
                    if (kodePKPT.length()>0){criteria.add(Restrictions.eq("kodePKPT", kodePKPT)); 	}

		return (PasRaKegiatanPKPT)  criteria.uniqueResult();//session.get(PasRaKegiatanPKPT.class, id);
	}
	
	public List<PasRaKegiatanPKPT> getAll(){
		return (List<PasRaKegiatanPKPT>) session.createCriteria(PasRaKegiatanPKPT.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(PasRaKegiatanPKPT.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<PasRaKegiatanPKPT> getAll(int start, int rowcount ){
		return (List<PasRaKegiatanPKPT>) session.createCriteria(PasRaKegiatanPKPT.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String NamaKegiatan,String KodePKPT){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(PasRaKegiatanPKPT.class);
                    if (NamaKegiatan.length()>0){criteria.add(Restrictions.eq("namaKegiatan", NamaKegiatan)); 	}
                    if (KodePKPT.length()>0){criteria.add(Restrictions.eq("kodePKPT", KodePKPT)); 	}
		
		return criteria;
	}
	
	public  Map<String,Object> getByMont(Date tglAwal,Date tglAkhir,String KodePKPT ,int start, int rowcount  ){
		Map map = new HashMap<String, Object>();	
		Criteria criteria =session.createCriteria(PasRaKegiatanPKPT.class);//getCriteria(NamaKegiatan,KodePKPT);
		criteria.add(Restrictions.ge("tanggalAwal", tglAwal));
		criteria.add(Restrictions.le("tanggalAkhir", tglAkhir));
		criteria.add(Restrictions.eq("kodePKPT", KodePKPT));
		List<PasRaKegiatanPKPT> l = criteria.setFirstResult(start).setMaxResults(rowcount).list();
		map.put("rows", l);
		map.put("total",  getByMontCount(tglAwal,tglAkhir,KodePKPT));
		return map;
	}
	
	public  long getByMontCount(Date tglAwal,Date tglAkhir,String KodePKPT ){
		Map map = new HashMap<String, Object>();	
		Criteria criteria =session.createCriteria(PasRaKegiatanPKPT.class);//getCriteria(NamaKegiatan,KodePKPT);
		criteria.add(Restrictions.ge("tanggalAwal", tglAwal));
		criteria.add(Restrictions.le("tanggalAkhir", tglAkhir));
		criteria.add(Restrictions.eq("kodePKPT", KodePKPT));
		long total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return total;
	}

	public List<PasRaKegiatanPKPT> getBy(String NamaKegiatan,String KodePKPT ,int start, int rowcount ){
		Criteria criteria =getCriteria(NamaKegiatan,KodePKPT);
		return (List<PasRaKegiatanPKPT>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String NamaKegiatan,String KodePKPT, int start, int rowcount  ){
		Criteria criteria =getCriteria(NamaKegiatan,KodePKPT);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String NamaKegiatan,String KodePKPT ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(NamaKegiatan,KodePKPT,  start,rowcount);//total jumlah row
		List<PasRaKegiatanPKPT> l = getBy(NamaKegiatan,KodePKPT, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<PasRaKegiatanPKPT> getBy(String NamaKegiatan,String KodePKPT  ){
		Criteria criteria =getCriteria(NamaKegiatan,KodePKPT).addOrder(Order.asc("tanggalAwal"));
		return (List<PasRaKegiatanPKPT>) criteria.list();
	}


}
