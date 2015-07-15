package co.id.pegadaian.pasg2.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
//import org.hamcrest.core.IsAnything;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import co.id.pegadaian.pasg2.dao.PasKsAuditTrailDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.PasEaKantorAuditor;
import co.id.pegadaian.pasg2.pojo.PasKsAuditTrail;
import co.id.pegadaian.pasg2.pojo.TblUser;


public abstract class AbstractListScreen {
	private final transient Logger log=Logger.getLogger(getClass());

	protected abstract String getView() ;
	private HttpSession session;
	//=========================
	
	 public String doGet(Map<String, Object> model,HttpSession session,HttpServletRequest reg,HttpServletResponse res) {
		 
		 String param =reg.getParameter("param");//.replace(" ", "");
		 String param2 =reg.getParameter("param2");//param2 dari klik menu -> key(random string)
		 String UIDEnc =reg.getParameter("UID");//UID di encript
		 String UID ="";
		 //String Key = reg.getParameter("paramB");
		 
		 //untuk form yang tidak ada tombol add delete dll nya
//		 if (param==null) {
//			 param="ud5QqNn792ilaMP05ijYm8/uVEYl3fND5MVdd9WTr35xDpucRJe3bcM3K8S2kbi0WbUfbvyFpQZer47TYkhJ2g==";
//			 param2="xntldrqmbpqwhrry";
//		 }
		 JCrypto crypto = new JCrypto(param2);
		 UID = crypto.decrypt(UIDEnc);
			 String sPriv = crypto.decrypt(param);
			 String sDec[] =sPriv.split("&");//==
			 String sIsAdd ="";		 String sIsEdit ="";		 String sIsDelete ="";		 String sIsView="";				 
			 for(String s: sDec){
				if (s.contains("isAdd=")){
					sIsAdd = /*crypto.decrypt*/(((s.replace("isAdd=", ""))));
				}
				if (s.contains("isEdit=")){
					sIsEdit = /*crypto.decrypt*/(((s.replace("isEdit=", ""))));
				}
				if (s.contains("isDelete=")){
					sIsDelete = /*crypto.decrypt*/(((s.replace("isDelete=", ""))));
				}
				if (s.contains("isView=")){
					sIsView = /*crypto.decrypt*/(((s.replace("isView=", ""))));
				}
			 }
			
			 String sUserId = UID;//reg.getParameter("UID");
	         String ses = (String) session.getAttribute("session"+sUserId);
	         TblUser user = (TblUser) session.getAttribute("user"+sUserId);
	         model.put("tblUser", user);
//	         waktu login session.setAttribute("unit"+userName, kantorAuditor);
	         PasEaKantorAuditor kantorAuditor = (PasEaKantorAuditor) session.getAttribute("unit"+sUserId);
	         model.put("kantorAuditor", kantorAuditor);
	        
	         if(user==null) return "redirect:/logout.htm";
	         String ret = null;
	         //ADMIN MODE OPEN
         if(AppProp.getsAppStatus().equals(AppConstant.AdminMode.AdminModeOpen)){
	         if(cekValidSession(session,UID)){
		         model.put("btnAdd",sIsAdd);// "disable");
		         model.put("btnEdit",sIsEdit);//reg.getParameter("isEdit") );//"disable");
		         model.put("btnDelete",sIsDelete);//reg.getParameter("isDelete"));//"disable");   isShow
		         model.put("btnShow",sIsView);//reg.getParameter("isView"));//"disable");
		         model.put("userId", sUserId);
		         ret= getView();
	         }else{
	        	 ret=  "redirect:/logout.htm";
	         }
         }else{
        	 //cek apakah user punya group adminmode
        	 Session sess = null;        	 
        	 try{
        	 sess = HibernateUtil.getSessionFactory().openSession();
        	 if(Util.cekUserAdminMode(user.getUserId(), sess)){//cek apakah user punya group adminmode
        		sess.close();
	        		 if(cekValidSession(session,UID)){//session disini httpservletsession
	    		         model.put("btnAdd",sIsAdd);// "disable");
	    		         model.put("btnEdit",sIsEdit);//reg.getParameter("isEdit") );//"disable");
	    		         model.put("btnDelete",sIsDelete);//reg.getParameter("isDelete"));//"disable");   isShow
	    		         model.put("btnShow",sIsView);//reg.getParameter("isView"));//"disable");
	    		         model.put("userId", sUserId);
	    		         ret =  getView();
	    	         }else{
	    	        	 ret =  "redirect:/logout.htm";
	    	         }
				}else{
					ret =  "redirect:/appstatus.htm";
				}
        	 
        	 }catch (Exception e){
        		 e.printStackTrace();
        	 }
         }
         
	
 
         
         //cek single longin
         if(!isSinleLogin(user.getUserId(),(String) session.getAttribute("key"+user.getUserId()),session,/*Key*/param2)){
        	 System.out.println("key  :"+(String) session.getAttribute("key"+user.getUserId()));
        	 ret =  "redirect:/sessionExpire.htm";
         }
         System.out.println("Akhir     : "+new Date());
      	 return ret;
        
     }
	
	
	public String doPost(Map<String, Object> model, HttpSession session,HttpServletRequest reg, HttpServletResponse res) {
		return getView();
	}
	
	
	public boolean cekValidSession(HttpSession session,String userId){		
	    TblUser user = (TblUser) session.getAttribute("user"+userId);
	    String valid =  (String) session.getAttribute("valid"+userId);
	    if(session.getAttribute("valid"+userId) == null){	    	
	    	return false;
	    }else{
		    if (valid.equals("valid")){
		    	return true;
		    }else{
		    	return false;
		    }
			
		}
	}
	
	public TblUser  getUser(HttpSession session,String userId){
		TblUser user = (TblUser) session.getAttribute("user"+userId);
		return user;
	}
	
	
	public void simpanLog(String sUserId,String sLog,String aksi,Session sessLog,String pojo ){
		//table name
		GetTableNameFromPojo tableNameFromPojo = new GetTableNameFromPojo();
		String tblName = tableNameFromPojo.getTableName(pojo);
		System.out.println(tblName+"   "+pojo);
		String logger =sUserId+"  CRUD  "/*+ new Date()*/+" "+sLog; //engga [perlu pake data suda ada dari looger
		log.warn(logger);
			PasKsAuditTrailDAO auditTrailDAO = new PasKsAuditTrailDAO(sessLog);
			PasKsAuditTrail auditTrail = new PasKsAuditTrail();
			auditTrail.setAksi(aksi+" : "+sLog);
//			auditTrail.setAlamatIP("IP");
			auditTrail.setCreateBy(sUserId);
			auditTrail.setCreateDate(new Date());
			auditTrail.setKodeAuditTrail(System.currentTimeMillis());
//			auditTrail.setKodeRecord(System.currentTimeMillis());
			auditTrail.setKodeUserPelaku(sUserId);
			auditTrail.setNamaKomputer("");
			auditTrail.setNamaTable(tblName);//nama class aja blom ketemu nama table
			auditTrailDAO.insert(auditTrail);
	}
/*
 * Cek single login
 */
	public  boolean isSinleLogin(String userId,String sessionKey,HttpSession session,String key) {
		boolean ret = true;
		if(AppProp.isSingleLogin()==true){			
			if(AppProp.getmSessionVal(userId)==null){
				System.out.println("user BELUM login "+userId+"  id: "+userId+"  true");
				AppProp.setmSession(userId,sessionKey);
				ret= true;
			}else{
				//cek apakah random stringnya sama atau tidak
				System.out.println("userid "+userId+" sessionkey "+sessionKey+" key "+key);
				if(/*sessionKey*/key.equals(AppProp.getmSessionVal(userId))){	
					System.out.println("=====key "+/*(String)session.getAttribute("key"+userId)*/key+ " rs :"+(AppProp.getmSessionVal(userId)).toString());
					ret = true;
				}else{
	//				AppProp.setmSession(userId,randomString);
					System.out.println("user SUDAH login "+userId+"  key "+/*(String)session.getAttribute("key"+userId)*/key+ " rs :"+(AppProp.getmSessionVal(userId)).toString());
					ret= false;
				}
			}	
		}
		return ret;
	}
	
	
	
	
}


