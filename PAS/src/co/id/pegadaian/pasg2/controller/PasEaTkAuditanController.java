/*
*Create by CodeGenerator
*controllerTemplate
*M U G I
*/

package co.id.pegadaian.pasg2.controller;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import co.id.pegadaian.pasg2.util.AbstractListScreen;

import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblUser;
import co.id.pegadaian.pasg2.pojo.PasEaTkAuditan;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.PasEaTkAuditanDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasEaTkAuditanController  extends AbstractListScreen{
	@RequestMapping(value="/pasEaTkAuditan.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/pasEaTkAuditan.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasEaTkAuditan";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/pasEaTkAuditanListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaTkAuditanListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTkAuditan=reg.getParameter("KodeTkAuditan");
                    String NamaTkAuditan=reg.getParameter("NamaTkAuditan");		 
         String userId = reg.getParameter("userId");
         String ses = (String) session.getAttribute("session"+userId);
         TblUser user = (TblUser) session.getAttribute("user"+userId);
  
         model.put("session", ses);
         if(!cekValidSession(session,userId)){
        	 return "[]";
         }
         String result="";
         int row = Integer.parseInt(reg.getParameter("rows"));
         int loffset = (Integer.parseInt(reg.getParameter("page"))-1)*row;
         Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         Session sess = null;
         try {
        	long rowCount=0;
			sess = HibernateUtil.getSessionFactory().openSession();
			PasEaTkAuditanDAO dao = new PasEaTkAuditanDAO(sess);
			Map h = new HashMap<String, Object>();
			List<PasEaTkAuditan> l = new ArrayList<PasEaTkAuditan>();
				h = dao.getByPerPage(KodeTkAuditan,NamaTkAuditan,loffset, row);
			sess.close();
            result = gson.toJson(h);
            System.out.println(result);
            
            /**  BILA ADA PERUBAHAN DATA JSON
            String x = changeJson(h, sess);
            sess.close();
        	result ="{"+'"'+"total"+'"'+":"+h.get("total")+","+'"'+"rows"+'"'+":["+x+']'+'}';
            */
            
			
		} catch (Exception e) {
			// TODO: handle exception
			if(sess != null && sess.isOpen()) sess.close();
			e.printStackTrace();
		}         
         return result;
     }

// *********************ADD***********************
 @RequestMapping(value="/pasEaTkAuditanAdd.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaTkAuditanAdd(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		String userId = reg.getParameter("userId");
         //String ses = (String) session.getAttribute("session"+userId);
         TblUser user = (TblUser) session.getAttribute("user"+userId);
         
         if(!cekValidSession(session,userId)){
        	 return "fail";
         }
         Session sess = null;
         String x ="";
         Map h = new HashMap<String, Object>();
         Gson gson = new Gson();
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         try {
               sess = HibernateUtil.getSessionFactory().openSession();
               PasEaTkAuditanDAO dao = new PasEaTkAuditanDAO(sess);
               PasEaTkAuditan tbl = new PasEaTkAuditan();
                    tbl.setKodeTkAuditan(reg.getParameter("kodeTkAuditan"));
                    tbl.setNamaTkAuditan(reg.getParameter("namaTkAuditan"));
                    tbl.setKeteranganTkAuditan(reg.getParameter("keteranganTkAuditan"));
                    tbl.setStatusTkAuditan(reg.getParameter("statusTkAuditan"));
                             
               tbl.setCreateBy(user.getUserId());
               tbl.setCreateDate(new Date());
               
               sess.beginTransaction();
               dao.insert(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl),"ADD",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               sess.close();
               x=gson.toJson("SUKSES");
         }catch(Exception e){
        	 if(sess != null && sess.isOpen()) sess.close();
             x=gson.toJson("fail");
             e.printStackTrace();
         }
         return x;
 	 }

//**************************************EDIT*************************************
//	 EDIT	 
	 @RequestMapping(value="/pasEaTkAuditanEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaTkAuditanEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTkAuditan=reg.getParameter("kodeTkAuditan");
		 
		String userId = reg.getParameter("userId");
         //String ses = (String) session.getAttribute("session"+userId);
         TblUser user = (TblUser) session.getAttribute("user"+userId);
         if(!cekValidSession(session,userId)){        	 
         	return "fail";
         }
         
         Session sess = null;
         String x ="";
         Map h = new HashMap<String, Object>();
         Gson gson = new Gson();
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         try {
               sess = HibernateUtil.getSessionFactory().openSession();
               PasEaTkAuditanDAO dao = new PasEaTkAuditanDAO(sess);
               PasEaTkAuditan tbl = dao.getById(KodeTkAuditan);
                String tblOld = gson.toJson(tbl);
                    tbl.setKodeTkAuditan(reg.getParameter("kodeTkAuditan"));
                    tbl.setNamaTkAuditan(reg.getParameter("namaTkAuditan"));
                    tbl.setKeteranganTkAuditan(reg.getParameter("keteranganTkAuditan"));
                    tbl.setStatusTkAuditan(reg.getParameter("statusTkAuditan"));
               
               tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               
               sess.beginTransaction();
               dao.update(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl)+" OLD "+tblOld,"MODIFY",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               sess.close();
               x=gson.toJson("UPDATE SUKSES");
         }catch(Exception e){
        	 if(sess != null && sess.isOpen()) sess.close();
             x=gson.toJson("fail");
             e.printStackTrace();
         }
         return x;
 	 }
	 
//	***********************************DELETE**************************************** 
	 @RequestMapping(value="/pasEaTkAuditanDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaTkAuditanDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTkAuditan=reg.getParameter("kodeTkAuditan");
	
//		 String sId = reg.getParameter("param"); //param sesuaikan dengan yg di jsp
		 String userId = reg.getParameter("userId");
         //String ses = (String) session.getAttribute("session"+userId);
         TblUser user = (TblUser) session.getAttribute("user"+userId);
         //model.put("session", ses);
          if(!cekValidSession(session,userId)){
                	 return "fail";
         }
         Session sess = null;
         String x ="";
         Map h = new HashMap<String, Object>();
         Gson gson = new Gson();
         try {
               sess = HibernateUtil.getSessionFactory().openSession();
               PasEaTkAuditanDAO dao = new PasEaTkAuditanDAO(sess);
               PasEaTkAuditan tbl = dao.getById(KodeTkAuditan);
               String tblDel = gson.toJson(tbl);
               sess.beginTransaction();
               dao.delete(tbl);
               simpanLog(user.getUserId(),tblDel,"DELETE",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               sess.close();
               h.put("success", true);
               x=gson.toJson(h);
         }catch(Exception e){
        	 if(sess != null && sess.isOpen()) sess.close();
        	 x=gson.toJson("fail");
             e.printStackTrace();
         }
         return x;
 	 }

//----------BILA ADA PERUBAHAN DATA JSON, RUBAH DI SINI------------------------------------------
//	public String changeJson(Map<String,Object> result, Session sess){//nemabhakan field nama group dan nama menu
//		List<TblPriviledge> listPri = (List<TblPriviledge>) result.get("rows");
////		List<TblPriviledge> priv = (List<TblPriviledge>) h.get("rows");
//		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
//		StringBuffer sb = new StringBuffer();
//		for(TblPriviledge pr : listPri){
//			String s = gson.toJson(pr);			
//			TblGroupDAO groupDAO = new TblGroupDAO(sess);
//			TblGroup group = groupDAO.getById(pr.getGroupId());
//			TblMenuDAO menuDAO = new TblMenuDAO(sess);
//			TblMenu menu =  menuDAO.getById(pr.getMenuId());
//			String a = s.replace("}", ","+'"'+"groupName"+'"'+":"+'"'+group.getGroupName()+'"'+","+'"'+"menuName"+'"'+":"+'"'+menu.getMenuName()+'"'+"},");
//			sb.append(a);
//		}
//		String x="";
//		if(sb.toString().length()>0){
//			x= (sb.toString()).substring(0,sb.toString().length()-1);
//		}	else{
//			x="";
//		}
//		return x;
//	}

//===============================REPORT====================================================

	@RequestMapping(value="/pasEaTkAuditanReport.htm",method=RequestMethod.GET)
	 public String doGetpasEaTkAuditanReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/pasEaTkAuditanReport";
	}
	
	
		 @RequestMapping(value="/pasEaTkAuditanDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String pasEaTkAuditanDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTkAuditan=reg.getParameter("KodeTkAuditan");
                    String NamaTkAuditan=reg.getParameter("NamaTkAuditan");		 
         String userId = reg.getParameter("userId");
         String ses = (String) session.getAttribute("session"+userId);
         TblUser user = (TblUser) session.getAttribute("user"+userId);
  
         model.put("session", ses);
         if(!cekValidSession(session,userId)){
        	 return "[]";
         }
         String result="";
          Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         Session sess = null;
         try {
        	long rowCount=0;
			sess = HibernateUtil.getSessionFactory().openSession();
			PasEaTkAuditanDAO dao = new PasEaTkAuditanDAO(sess);
			List<PasEaTkAuditan> l = new ArrayList<PasEaTkAuditan>();
				l = dao.getBy(KodeTkAuditan,NamaTkAuditan);
			sess.close();
            result = gson.toJson(l);
            System.out.println(result);
            
            /**  BILA ADA PERUBAHAN DATA JSON
            String x = changeJson(h, sess);
            sess.close();
        	result ="{"+'"'+"total"+'"'+":"+h.get("total")+","+'"'+"rows"+'"'+":["+x+']'+'}';
            */
            
			
		} catch (Exception e) {
			// TODO: handle exception
			if(sess != null && sess.isOpen()) sess.close();
			e.printStackTrace();
		}         
         return result;
     }
	
	
	
	
	
}
