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
import co.id.pegadaian.pasg2.pojo.TblPasKsKodefikasiTemuan;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.TblPasKsKodefikasiTemuanDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasKsKodefikasiTemuanController  extends AbstractListScreen{
	@RequestMapping(value="/pasKsKodefikasiTemuan.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/pasKsKodefikasiTemuan.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasKsKodefikasiTemuan";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/pasKsKodefikasiTemuanListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String pasKsKodefikasiTemuanListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KdParent=reg.getParameter("KdParent");
                    String NamaTemuan=reg.getParameter("NamaTemuan");
                    String KodeTemuan=reg.getParameter("KodeTemuan");
                    String Status=reg.getParameter("Status");
                    String KodeAspekPemeriksaan=reg.getParameter("KodeAspekPemeriksaan");
                    String KodeJenisPemeriksaan=reg.getParameter("KodeJenisPemeriksaan");		 
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
			TblPasKsKodefikasiTemuanDAO dao = new TblPasKsKodefikasiTemuanDAO(sess);
			Map h = new HashMap<String, Object>();
			List<TblPasKsKodefikasiTemuan> l = new ArrayList<TblPasKsKodefikasiTemuan>();
				h = dao.getByPerPage(KdParent,NamaTemuan,KodeTemuan,Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan,loffset, row);
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
 @RequestMapping(value="/pasKsKodefikasiTemuanAdd.htm", method=RequestMethod.POST)
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
               TblPasKsKodefikasiTemuanDAO dao = new TblPasKsKodefikasiTemuanDAO(sess);
               TblPasKsKodefikasiTemuan tbl = new TblPasKsKodefikasiTemuan();
                    tbl.setKdParent(reg.getParameter("kdParent"));
                    tbl.setNamaTemuan(reg.getParameter("namaTemuan"));
                    tbl.setKodeTemuan(reg.getParameter("kodeTemuan"));
                    tbl.setStatus(reg.getParameter("status"));
                    tbl.setKodeAspekPemeriksaan(reg.getParameter("kodeAspekPemeriksaan"));
                    tbl.setKodeJenisPemeriksaan(reg.getParameter("kodeJenisPemeriksaan"));
                             
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
	 @RequestMapping(value="/pasKsKodefikasiTemuanEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String pasKsKodefikasiTemuanEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTemuan=reg.getParameter("kodeTemuan");
                    String KodeAspekPemeriksaan=reg.getParameter("kodeAspekPemeriksaan");
                    String KodeJenisPemeriksaan=reg.getParameter("kodeJenisPemeriksaan");
		 
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
               TblPasKsKodefikasiTemuanDAO dao = new TblPasKsKodefikasiTemuanDAO(sess);
               TblPasKsKodefikasiTemuan tbl = dao.getById(KodeTemuan,KodeAspekPemeriksaan,KodeJenisPemeriksaan);
                String tblOld = gson.toJson(tbl);
                    tbl.setKdParent(reg.getParameter("kdParent"));
                    tbl.setNamaTemuan(reg.getParameter("namaTemuan"));
                    tbl.setKodeTemuan(reg.getParameter("kodeTemuan"));
                    tbl.setStatus(reg.getParameter("status"));
                    tbl.setKodeAspekPemeriksaan(reg.getParameter("kodeAspekPemeriksaan"));
                    tbl.setKodeJenisPemeriksaan(reg.getParameter("kodeJenisPemeriksaan"));
               
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
	 @RequestMapping(value="/pasKsKodefikasiTemuanDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String pasKsKodefikasiTemuanDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeTemuan=reg.getParameter("kodeTemuan");
                    String KodeAspekPemeriksaan=reg.getParameter("kodeAspekPemeriksaan");
                    String KodeJenisPemeriksaan=reg.getParameter("kodeJenisPemeriksaan");
	
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
               TblPasKsKodefikasiTemuanDAO dao = new TblPasKsKodefikasiTemuanDAO(sess);
               TblPasKsKodefikasiTemuan tbl = dao.getById(KodeTemuan,KodeAspekPemeriksaan,KodeJenisPemeriksaan);
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

	@RequestMapping(value="/pasKsKodefikasiTemuanReport.htm",method=RequestMethod.GET)
	 public String doGetpasKsKodefikasiTemuanReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/pasKsKodefikasiTemuanReport";
	}
	
	
		 @RequestMapping(value="/pasKsKodefikasiTemuanDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String pasKsKodefikasiTemuanDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KdParent=reg.getParameter("KdParent");
                    String NamaTemuan=reg.getParameter("NamaTemuan");
                    String KodeTemuan=reg.getParameter("KodeTemuan");
                    String Status=reg.getParameter("Status");
                    String KodeAspekPemeriksaan=reg.getParameter("KodeAspekPemeriksaan");
                    String KodeJenisPemeriksaan=reg.getParameter("KodeJenisPemeriksaan");		 
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
			TblPasKsKodefikasiTemuanDAO dao = new TblPasKsKodefikasiTemuanDAO(sess);
			List<TblPasKsKodefikasiTemuan> l = new ArrayList<TblPasKsKodefikasiTemuan>();
				l = dao.getBy(KdParent,NamaTemuan,KodeTemuan,Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan);
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
