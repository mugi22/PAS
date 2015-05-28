package co.id.pegadaian.pasg2.test;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import com.google.gson.Gson;

import co.id.pegadaian.pasg2.dao.TblKabupatenDAO;
import co.id.pegadaian.pasg2.dao.TblKecamatanDAO;
import co.id.pegadaian.pasg2.dao.TblMenuDAO;
import co.id.pegadaian.pasg2.dao.TblPasEaKantorAuditorDAO;
import co.id.pegadaian.pasg2.dao.TblPasEaTkKantorAuditorDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblKabupaten;
import co.id.pegadaian.pasg2.pojo.TblKecamatan;
import co.id.pegadaian.pasg2.pojo.TblPasEaKantorAuditor;
import co.id.pegadaian.pasg2.pojo.TblPasEaTkKantorAuditor;

public class TestDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
//		TblMenuDAO dao = new TblMenuDAO(sess);
//		System.out.println(dao.getByCount(new BigDecimal(100), "", new BigDecimal(0), 0, 10));
//		TblKabupatenDAO dao = new TblKabupatenDAO(sess);
//		List<TblKabupaten> l = dao.getByProvinsi("01");
//		Gson gson = new Gson();
//		for(TblKabupaten tbl : l){
//			System.out.println(gson.toJson(tbl));
//		}
		//testKecamatanDao(sess);
		testTblPasEaKantorAuditorDao(sess);
		sess.close();
	}
	
	
	
	public static void testKecamatanDao(Session sess){
		TblKecamatanDAO dao = new TblKecamatanDAO(sess);
		List<TblKecamatan> list = dao.getByKabupaten("0101");
		Gson gson = new Gson();
		for(TblKecamatan tbl : list){
			System.out.println(gson.toJson(tbl));
		}
		
	}
	
	public static void testTblPasEaKantorAuditorDao(Session sess) {
		TblPasEaKantorAuditorDAO auditor = new TblPasEaKantorAuditorDAO(sess);
		List<TblPasEaKantorAuditor> l = auditor.getByKodeTk("02");
		Gson gson = new Gson();
		for(TblPasEaKantorAuditor tbl : l){
			System.out.println(gson.toJson(tbl));
		}
	}

}
