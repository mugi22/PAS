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
import co.id.pegadaian.pasg2.pojo.TblAppProperties;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.TblAppPropertiesDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class AppPropertiesController  extends AbstractListScreen{
	@RequestMapping(value="/appProperties.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/appProperties.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "appProperties";
	}
	
//generate fire properties
	 @RequestMapping(value="/appPropertiesGenerate.htm", method=RequestMethod.GET)
     public @ResponseBody String appPropertiesGenerate(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		 
		  Session sess = null;
		  try {
			  sess = HibernateUtil.getSessionFactory().openSession();
			  TblAppPropertiesDAO appPropertiesDAO = new TblAppPropertiesDAO(sess);
			  List<TblAppProperties> l = appPropertiesDAO.getAll();
			  StringBuffer sb = new StringBuffer();
			  for(TblAppProperties x:l){
				  String k = x.getPropertiesNama()+"="+x.getPropertiesValue();
				  sb.append(x.getPropertiesNama()+"="+x.getPropertiesValue()+"\n");
			  }
			  System.out.println(sb.toString());
		  } catch (Exception e) {
				if(sess != null && sess.isOpen()) sess.close();
				e.printStackTrace();
			}   
		
		 return "appPropertiesGenerate";
	 }
	 
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/appPropertiesListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String appPropertiesListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String PropertiesValue=reg.getParameter("PropertiesValue");
                    String PropertiesNama=reg.getParameter("PropertiesNama");		 
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
			TblAppPropertiesDAO dao = new TblAppPropertiesDAO(sess);
			Map h = new HashMap<String, Object>();
			List<TblAppProperties> l = new ArrayList<TblAppProperties>();
				h = dao.getByPerPage(PropertiesValue,PropertiesNama,loffset, row);
			sess.close();
            result = gson.toJson(h);
            System.out.println(result);
            
            /**  BILA ADA PERUBAHAN DATA JSON
            String x = changeJson(h, sess);
            sess.close();
        	result ="{"+'"'+"total"+'"'+":"+h.get("total")+","+'"'+"rows"+'"'+":["+x+']'+'}';
            */
		} catch (Exception e) {
			if(sess != null && sess.isOpen()) sess.close();
			e.printStackTrace();
		}         
         return result;
     }

// *********************ADD***********************
 @RequestMapping(value="/appPropertiesAdd.htm", method=RequestMethod.POST)
     public @ResponseBody String userAdd(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
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
               TblAppPropertiesDAO dao = new TblAppPropertiesDAO(sess);
               TblAppProperties tbl = new TblAppProperties();
                    tbl.setPropertiesValue(reg.getParameter("propertiesValue"));
                    tbl.setPropertiesNama(reg.getParameter("propertiesNama"));
                             
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
	 @RequestMapping(value="/appPropertiesEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String appPropertiesEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String PropertiesNama=reg.getParameter("propertiesNama");
		 
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
               TblAppPropertiesDAO dao = new TblAppPropertiesDAO(sess);
               TblAppProperties tbl = dao.getById(PropertiesNama);
                String tblOld = gson.toJson(tbl);
                    tbl.setPropertiesValue(reg.getParameter("propertiesValue"));
                    tbl.setPropertiesNama(reg.getParameter("propertiesNama"));
               tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               sess.beginTransaction();
               dao.update(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl)+"OLD "+tblOld,"MODIFY",sess,tbl.getClass().getName());
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
	 @RequestMapping(value="/appPropertiesDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String appPropertiesDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String PropertiesNama=reg.getParameter("propertiesNama");
	
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
               TblAppPropertiesDAO dao = new TblAppPropertiesDAO(sess);
               TblAppProperties tbl = dao.getById(PropertiesNama);
               String tblDel = gson.toJson(tbl);
               sess.beginTransaction();
               dao.delete(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl),"DELETE",sess,tbl.getClass().getName());
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

	@RequestMapping(value="/appPropertiesReport.htm",method=RequestMethod.GET)
	 public String doGetappPropertiesReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/appPropertiesReport";
	}
	
	
		 @RequestMapping(value="/appPropertiesDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String appPropertiesDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String PropertiesValue=reg.getParameter("PropertiesValue");
                    String PropertiesNama=reg.getParameter("PropertiesNama");		 
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
			TblAppPropertiesDAO dao = new TblAppPropertiesDAO(sess);
			List<TblAppProperties> l = new ArrayList<TblAppProperties>();
				l = dao.getBy(PropertiesValue,PropertiesNama);
			sess.close();
            result = gson.toJson(l);
            System.out.println(result);
            
            /**  BILA ADA PERUBAHAN DATA JSON
            String x = changeJson(h, sess);
            sess.close();
        	result ="{"+'"'+"total"+'"'+":"+h.get("total")+","+'"'+"rows"+'"'+":["+x+']'+'}';
            */
			
		} catch (Exception e) {
			if(sess != null && sess.isOpen()) sess.close();
			e.printStackTrace();
		}         
         return result;
     }
	
	
	
	
	
}
