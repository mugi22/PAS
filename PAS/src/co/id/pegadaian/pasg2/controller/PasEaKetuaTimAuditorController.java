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
import co.id.pegadaian.pasg2.pojo.TblPasEaKetuaTimAuditor;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.TblPasEaKetuaTimAuditorDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasEaKetuaTimAuditorController  extends AbstractListScreen{
	@RequestMapping(value="/pasEaKetuaTimAuditor.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/pasEaKetuaTimAuditor.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasEaKetuaTimAuditor";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/pasEaKetuaTimAuditorListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaKetuaTimAuditorListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTkKantorAuditor=reg.getParameter("KodeTkKantorAuditor");
                    String KodeKantorAuditor=reg.getParameter("KodeKantorAuditor");
                    String KodeUserKetuaTimAuditor=reg.getParameter("KodeUserKetuaTimAuditor");		 
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
			TblPasEaKetuaTimAuditorDAO dao = new TblPasEaKetuaTimAuditorDAO(sess);
			Map h = new HashMap<String, Object>();
			List<TblPasEaKetuaTimAuditor> l = new ArrayList<TblPasEaKetuaTimAuditor>();
				h = dao.getByPerPage(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor,loffset, row);
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
			e.printStackTrace();
		}         
         return result;
     }

// *********************ADD***********************
 @RequestMapping(value="/pasEaKetuaTimAuditorAdd.htm", method=RequestMethod.POST)
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
               TblPasEaKetuaTimAuditorDAO dao = new TblPasEaKetuaTimAuditorDAO(sess);
               TblPasEaKetuaTimAuditor tbl = new TblPasEaKetuaTimAuditor();
                    tbl.setKodeTkKantorAuditor(reg.getParameter("kodeTkKantorAuditor"));
                    tbl.setKodeKantorAuditor(reg.getParameter("kodeKantorAuditor"));
                    tbl.setKodeUserKetuaTimAuditor(reg.getParameter("kodeUserKetuaTimAuditor"));
                             
               tbl.setCreateBy(user.getUserId());
               tbl.setCreateDate(new Date());
               
               sess.beginTransaction();
               dao.insert(tbl);
               sess.getTransaction().commit();
               simpanLog(user.getUserId(),gson.toJson(tbl));
               sess.close();
               x=gson.toJson("SUKSES");
         }catch(Exception e){
             x=gson.toJson("fail");
             e.printStackTrace();
         }
         return x;
 	 }

//**************************************EDIT*************************************
//	 EDIT	 
	 @RequestMapping(value="/pasEaKetuaTimAuditorEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaKetuaTimAuditorEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTkKantorAuditor=reg.getParameter("kodeTkKantorAuditor");
                    String KodeKantorAuditor=reg.getParameter("kodeKantorAuditor");
                    String KodeUserKetuaTimAuditor=reg.getParameter("kodeUserKetuaTimAuditor");
		 
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
               TblPasEaKetuaTimAuditorDAO dao = new TblPasEaKetuaTimAuditorDAO(sess);
               TblPasEaKetuaTimAuditor tbl = dao.getById(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
                String tblOld = gson.toJson(tbl);
                    tbl.setKodeTkKantorAuditor(reg.getParameter("kodeTkKantorAuditor"));
                    tbl.setKodeKantorAuditor(reg.getParameter("kodeKantorAuditor"));
                    tbl.setKodeUserKetuaTimAuditor(reg.getParameter("kodeUserKetuaTimAuditor"));
               
               tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               
               sess.beginTransaction();
               dao.update(tbl);
               sess.getTransaction().commit();
                simpanLog(user.getUserId(),"MODIFY  : "+gson.toJson(tbl)+" OLD "+tblOld);
               sess.close();
               x=gson.toJson("UPDATE SUKSES");
         }catch(Exception e){
             x=gson.toJson("fail");
             e.printStackTrace();
         }
         return x;
 	 }
	 
//	***********************************DELETE**************************************** 
	 @RequestMapping(value="/pasEaKetuaTimAuditorDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaKetuaTimAuditorDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTkKantorAuditor=reg.getParameter("kodeTkKantorAuditor");
                    String KodeKantorAuditor=reg.getParameter("kodeKantorAuditor");
                    String KodeUserKetuaTimAuditor=reg.getParameter("kodeUserKetuaTimAuditor");
	
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
               TblPasEaKetuaTimAuditorDAO dao = new TblPasEaKetuaTimAuditorDAO(sess);
               TblPasEaKetuaTimAuditor tbl = dao.getById(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
               String tblDel = gson.toJson(tbl);
               sess.beginTransaction();
               dao.delete(tbl);
               sess.getTransaction().commit();
               simpanLog(user.getUserId(),"DELETE  : "+tblDel);
               sess.close();
               h.put("success", true);
               x=gson.toJson(h);
         }catch(Exception e){
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

	@RequestMapping(value="/pasEaKetuaTimAuditorReport.htm",method=RequestMethod.GET)
	 public String doGetpasEaKetuaTimAuditorReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/pasEaKetuaTimAuditorReport";
	}
	
	
		 @RequestMapping(value="/pasEaKetuaTimAuditorDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String pasEaKetuaTimAuditorDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTkKantorAuditor=reg.getParameter("KodeTkKantorAuditor");
                    String KodeKantorAuditor=reg.getParameter("KodeKantorAuditor");
                    String KodeUserKetuaTimAuditor=reg.getParameter("KodeUserKetuaTimAuditor");		 
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
			TblPasEaKetuaTimAuditorDAO dao = new TblPasEaKetuaTimAuditorDAO(sess);
			List<TblPasEaKetuaTimAuditor> l = new ArrayList<TblPasEaKetuaTimAuditor>();
				l = dao.getBy(KodeTkKantorAuditor,KodeKantorAuditor,KodeUserKetuaTimAuditor);
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
			e.printStackTrace();
		}         
         return result;
     }
	
	
	
	
	
}
