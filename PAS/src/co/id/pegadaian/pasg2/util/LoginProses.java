package co.id.pegadaian.pasg2.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.jpos.iso.ISOException;

import co.id.pegadaian.pasg2.dao.TblUserDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblUser;

import com.dframework.jpos.security.SecurityUtil;


public class LoginProses {
	final static Logger logger = Logger.getLogger(LoginProses.class);
	private TblUser tblUser;
	public TblUser getTblUser() {
		return tblUser;
	}
	public void setTblUser(TblUser tblUser) {
		this.tblUser = tblUser;
	}
	public boolean checkValidUserPassword(String userName, String password){
		logger.info(userName+" Login.....................");
		String enkPwd="";
		boolean validLogin = false;
		try {
			enkPwd = SecurityUtil.encrypt(password);
		} catch (ISOException e) {			
			e.printStackTrace();
		}
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tblUser = new TblUser();
			TblUserDAO tblUserDAO = new TblUserDAO(session);
			tblUser = tblUserDAO.getById(userName);
			if(tblUser!=null){
				logger.info(userName+" Login Sukses");
				validLogin = true;
			}else{
				logger.info(userName+" Login Gagal");
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen()&&session!=null){
				session.close();
			}
		}
		
		
		
		return validLogin;
	}
}
