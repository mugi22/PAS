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
import co.id.pegadaian.pasg2.pojo.TblMenu;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.TblMenuDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class MenuController  extends AbstractListScreen{
	@RequestMapping(value="/menu.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/menu.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "menu";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/menuListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String menuListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String MenuId ="0";
                    if(reg.getParameter("MenuId").length()>0){
                    MenuId = (reg.getParameter("MenuId"));
                    }
                    String MenuName=reg.getParameter("MenuName");
                    String ParentId ="0";
                    if(reg.getParameter("ParentId").length()>0){
                    ParentId = (reg.getParameter("ParentId"));
                    }		 
         String userId = reg.getParameter("userId");
         String ses = (String) session.getAttribute("session"+userId);
         TblUser user = (TblUser) session.getAttribute("user"+userId);
         System.out.println(" MenuId  "+MenuId+" ParentId  "+ParentId);
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
			TblMenuDAO dao = new TblMenuDAO(sess);
			Map h = new HashMap<String, Object>();
			List<TblMenu> l = new ArrayList<TblMenu>();
				h = dao.getByPerPage(new BigDecimal(MenuId),MenuName,new BigDecimal(ParentId),loffset, row);
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
 @RequestMapping(value="/menuAdd.htm", method=RequestMethod.POST)
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
               TblMenuDAO dao = new TblMenuDAO(sess);
               TblMenu tbl = new TblMenu();
                    tbl.setParams(reg.getParameter("params"));
                    tbl.setMenuId(new BigDecimal((reg.getParameter("menuId"))));
                    tbl.setMenuName(reg.getParameter("menuName"));
                    tbl.setNoUrut(new BigDecimal((reg.getParameter("noUrut"))));
                    tbl.setParentId(new BigDecimal((reg.getParameter("parentId"))));
                    tbl.setMenuPage(reg.getParameter("menuPage"));
                    tbl.setScreenClass(reg.getParameter("screenClass"));
                    tbl.setIsUsingGroovy(reg.getParameter("isUsingGroovy"));
                    tbl.setHaveChild(reg.getParameter("haveChild").charAt(0));
                             
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
	 @RequestMapping(value="/menuEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String menuEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String MenuId="0";
                    if(reg.getParameter("menuId").length()>0){
                    MenuId = (reg.getParameter("menuId"));
                    }
		 
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
               TblMenuDAO dao = new TblMenuDAO(sess);
               TblMenu tbl = dao.getById(new BigDecimal(MenuId));
                String tblOld = gson.toJson(tbl);
                    tbl.setParams(reg.getParameter("params"));
                    tbl.setMenuId(new BigDecimal((reg.getParameter("menuId"))));
                    tbl.setMenuName(reg.getParameter("menuName"));
                    tbl.setNoUrut(new BigDecimal((reg.getParameter("noUrut"))));
                    tbl.setParentId(new BigDecimal((reg.getParameter("parentId"))));
                    tbl.setMenuPage(reg.getParameter("menuPage"));
                    tbl.setScreenClass(reg.getParameter("screenClass"));
                    tbl.setIsUsingGroovy(reg.getParameter("isUsingGroovy"));
                    tbl.setHaveChild(reg.getParameter("haveChild").charAt(0));
               
               tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               
               sess.beginTransaction();
               dao.update(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl)+"OLD "+gson.toJson(tblOld),"MODIFY",sess,tbl.getClass().getName());
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
	 @RequestMapping(value="/menuDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String menuDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String MenuId="0";
                    if(reg.getParameter("menuId").length()>0){
                    MenuId = (reg.getParameter("menuId"));
                    }
	
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
               TblMenuDAO dao = new TblMenuDAO(sess);
               TblMenu tbl = dao.getById(new BigDecimal(MenuId));
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

	@RequestMapping(value="/menuReport.htm",method=RequestMethod.GET)
	 public String doGetmenuReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/menuReport";
	}
	
	
		 @RequestMapping(value="/menuDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String menuDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String MenuId ="0";
                    if(reg.getParameter("MenuId").length()>0){
                    MenuId = (reg.getParameter("MenuId"));
                    }
                    String MenuName=reg.getParameter("MenuName");
                    String ParentId ="0";
                    if(reg.getParameter("ParentId").length()>0){
                    ParentId = (reg.getParameter("ParentId"));
                    }		 
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
			TblMenuDAO dao = new TblMenuDAO(sess);
			List<TblMenu> l = new ArrayList<TblMenu>();
				l = dao.getBy(new BigDecimal(MenuId),MenuName,new BigDecimal(ParentId));
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
