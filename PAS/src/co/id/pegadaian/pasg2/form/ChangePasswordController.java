/*
*Create by CodeGenerator
*controllerTemplate
*/

package co.id.pegadaian.pasg2.form;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.id.pegadaian.pasg2.dao.TblUserDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblUser;
import co.id.pegadaian.pasg2.util.AbstractListScreen;

import com.dframework.jpos.security.SecurityUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class ChangePasswordController  extends AbstractListScreen{
	@RequestMapping(value="/changePassword.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
		//super.doGet(model, session, reg,res);
		 
//		 String param =reg.getParameter("param");//.replace(" ", "");
//		 String param2 =reg.getParameter("param2");//param2 dari klik menu -> key(random string)
		 String UID =reg.getParameter("UID");
		 String userId = reg.getParameter("userId");
		 TblUser user;
		 if(userId.length()>0){
	         String ses = (String) session.getAttribute("session"+userId);
	         user = (TblUser) session.getAttribute("user"+userId);
		 }else{
			 String ses = (String) session.getAttribute("session"+UID);
	        user = (TblUser) session.getAttribute("user"+UID);
		 }
		 model.put("tblUser", user);
		 if(!cekValidSession(session,user.getUserId())){
        	 return "[]";
         }
		 
		return getView();
	}
	
	
	 @RequestMapping(value="/changePassword.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		return "changePassword";
	}
	

//**************************************EDIT*************************************
//	 EDIT	 
	 @RequestMapping(value="/changePasswordEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String FormseqEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
         String UserId=reg.getParameter("UserId");//dr form
		 System.out.println("changePasswordEdit");
		 String userId = reg.getParameter("userId");
		 TblUser user = new TblUser();
		 System.out.println("userId "+userId);
		 
		 if(userId.length()>0){
	         String ses = (String) session.getAttribute("session"+userId);
	         user = (TblUser) session.getAttribute("user"+userId);
		 }
         
         
         
         if(!cekValidSession(session,userId)){      
        	 System.out.println("Session Invalid................................");
         	return "fail";
         }
         
         Session sess = null;
         String x ="";
         Map h = new HashMap<String, Object>();
         Gson gson = new Gson();
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         try {
               sess = HibernateUtil.getSessionFactory().openSession();
               TblUserDAO dao = new TblUserDAO(sess);
               
               TblUser tbl = dao.getById(UserId);
               System.out.println(gson.toJson(tbl));
                String tblOld = gson.toJson(tbl);
//                    tbl.setPassword(reg.getParameter("Password"));
                    tbl.setPassword(SecurityUtil.encrypt(reg.getParameter("Password")));
                    tbl.setLastChangePwd(new Date());
                    tbl.setUserId(UserId);
               tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               
               sess.beginTransaction();
               dao.update(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl)+"OLD "+tblOld,"MODIFY",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               sess.close();
               x=gson.toJson("UPDATE SUKSES");
               System.out.println("x "+x);
         }catch(Exception e){
             x=gson.toJson("fail");
             e.printStackTrace();
         }
         return x;
 	 }
	
}
