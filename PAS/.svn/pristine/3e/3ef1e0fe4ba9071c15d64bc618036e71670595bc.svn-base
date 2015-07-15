package co.id.pegadaian.pasg2.test;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import co.id.pegadaian.pasg2.dao.TblGroupDAO;
import co.id.pegadaian.pasg2.dao.TblUserDAO;
import co.id.pegadaian.pasg2.dao.TblUserGroupDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblGroup;
import co.id.pegadaian.pasg2.pojo.TblPriviledge;
import co.id.pegadaian.pasg2.pojo.TblUser;
import co.id.pegadaian.pasg2.pojo.TblUserGroup;



public class ConnectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session =null;
		try{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	/*	TblUser user = new TblUser();
		user.setBranchCode("00002");
		user.setBranchMobileId("");
		user.setCreateBy("mugi");
		user.setCreateDate(new Date());
		user.setName("mugi");
		user.setUserId("P81035");
		user.setPassword("138FD3F8C2C86123");
		user.setEndTime(new Date());
		user.setStartTime(new Date());
		TblUserDAO tblUserDAO = new TblUserDAO(session);
		//session.beginTransaction();
		tblUserDAO.insert(user);
		//session.getTransaction().commit();
		
	*/	
		
		/* group 
		TblGroup group = new TblGroup();
		group.setCreateBy("ADMIN");
		group.setCreateDate(new Date());
		group.setGroupId(new BigDecimal(1));
		group.setGroupName("ADMIN");
		group.setJabatan("ADMIN");
		
		
		TblGroupDAO groupDAO = new TblGroupDAO(session);
		groupDAO.insert(group);
		//session.getTransaction().commit();
		*/
		/*userGroup
		TblUserGroup userGroup = new TblUserGroup();
		userGroup.setUserId("P81035");
		userGroup.setGroupId(new BigDecimal(1));
		TblUserGroupDAO tblUserGroupDAO = new TblUserGroupDAO(session);
		tblUserGroupDAO.insert(userGroup);
		*/
		
		TblPriviledge  priviledge = new TblPriviledge();
		priviledge.setCreateBy("ADMIN");
		priviledge.setGroupId(new BigDecimal(1));
		//priviledge.setMenuId(menuId)
		
		
		
		session.getTransaction().commit();
		
		System.out.println("connect sukses....");
		session.close();
		System.out.println("Session Selesai");
		} catch (Exception e) {
			System.out.println("connect Gagal....");
			e.printStackTrace();
		}
	}
	

}
