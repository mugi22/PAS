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

import co.id.pegadaian.pasg2.pojo.TblSeq;

public class TblSeqDAO {
	private Session session;
	
	public TblSeqDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblSeq tblseq){
		session.save(tblseq);
	}
		
	public void delete(TblSeq tblseq){
		session.delete(tblseq);
	}
	
	public void update(TblSeq tblseq){
		session.update(tblseq);
	}
//====================================================================	
	public TblSeq getById(BigDecimal  versi,String  seqName){
		Criteria criteria =null;
		criteria = session.createCriteria(TblSeq.class);
                    if (versi.doubleValue()>0){criteria.add(Restrictions.eq("versi", versi)); 	}
                    if (seqName.length()>0){criteria.add(Restrictions.eq("seqName", seqName)); 	}

		return (TblSeq)  criteria.uniqueResult();//session.get(TblSeq.class, id);
	}
	
	public TblSeq getSeqName(String  seqName){
		Criteria criteria =null;
		criteria = session.createCriteria(TblSeq.class);
                    if (seqName.length()>0){criteria.add(Restrictions.eq("seqName", seqName)); 	}
		return (TblSeq)  criteria.uniqueResult();//session.get(TblSeq.class, id);
	}
	
	public List<TblSeq> getAll(){
		return (List<TblSeq>) session.createCriteria(TblSeq.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblSeq.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblSeq> getAll(int start, int rowcount ){
		return (List<TblSeq>) session.createCriteria(TblSeq.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(String SeqName){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblSeq.class);
                    if (SeqName.length()>0){criteria.add(Restrictions.eq("seqName", SeqName)); 	}
		
		return criteria;
	}

	public List<TblSeq> getBy(String SeqName ,int start, int rowcount ){
		Criteria criteria =getCriteria(SeqName);
		return (List<TblSeq>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(String SeqName, int start, int rowcount  ){
		Criteria criteria =getCriteria(SeqName);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(String SeqName ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(SeqName,  start,rowcount);//total jumlah row
		List<TblSeq> l = getBy(SeqName, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblSeq> getBy(String SeqName  ){
		Criteria criteria =getCriteria(SeqName);
		return (List<TblSeq>) criteria.list();
	}


}
