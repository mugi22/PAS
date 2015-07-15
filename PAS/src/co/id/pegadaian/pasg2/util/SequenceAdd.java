package co.id.pegadaian.pasg2.util;

import java.math.BigDecimal;

import org.hibernate.Session;

import co.id.pegadaian.pasg2.dao.TblSeqDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblSeq;

public class SequenceAdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SequenceAdd add = new SequenceAdd();
		add.generateSEQ("KodeRKBPT");
	}
	
	public static long generateSEQ(String seqName){
		long x = 0;
		Session sess =null;
		try{
		sess = HibernateUtil.getSessionFactory().openSession();
		TblSeqDAO seqDAO = new TblSeqDAO(sess);
		TblSeq seq = seqDAO.getSeqName(seqName);
		
		sess.beginTransaction();
		if(seq ==null){
			TblSeq newSeq = new TblSeq();
			newSeq.setSeqName(seqName);
			newSeq.setSeqNum(1);
			newSeq.setVersi(new BigDecimal(System.currentTimeMillis()));
			seqDAO.insert(newSeq);
			x = 1;
		}else{
			x = seq.getSeqNum() + 1 ;
			seq.setSeqNum(x);
			seqDAO.update(seq);
		}
		sess.getTransaction().commit();
		sess.close();
		}catch (Exception e){
			if(sess != null && sess.isOpen()) sess.close();
			e.printStackTrace();
		}
		return  x;
		
	}

}
