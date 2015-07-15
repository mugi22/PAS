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
import co.id.pegadaian.pasg2.util.SequenceAdd;
import co.id.pegadaian.pasg2.util.Util;

import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblUser;
import co.id.pegadaian.pasg2.pojo.PasRaPKPT;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.PasRaPKPTDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasRaPKPTController  extends AbstractListScreen{
	@RequestMapping(value="/pasRaPKPT.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/pasRaPKPT.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasRaPKPT";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/pasRaPKPTListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaPKPTListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeKantorAuditorPemilik=reg.getParameter("KodeKantorAuditorPemilik");
                    String StatusReviu=reg.getParameter("StatusReviu");
                    String KodePKPT=reg.getParameter("KodePKPT");
                    String TahunPKPT=reg.getParameter("TahunPKPT");
                    String StatusPKPT=reg.getParameter("StatusPKPT");		 
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
			PasRaPKPTDAO dao = new PasRaPKPTDAO(sess);
			Map h = new HashMap<String, Object>();
			List<PasRaPKPT> l = new ArrayList<PasRaPKPT>();
				h = dao.getByPerPage(KodeKantorAuditorPemilik,StatusReviu,KodePKPT,TahunPKPT,StatusPKPT,loffset, row);
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
			// TODO: handle exception
			e.printStackTrace();
		}         
         return result;
     }

// *********************ADD***********************
 @RequestMapping(value="/pasRaPKPTAdd.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaPKPTAdd(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		String userId = reg.getParameter("userId");
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
               PasRaPKPTDAO dao = new PasRaPKPTDAO(sess);
               PasRaPKPT tbl = new PasRaPKPT();
                    tbl.setKodeKantorAuditorPemilik(reg.getParameter("kodeKantorAuditorPemilik"));
                    tbl.setKodeUserPembuat(reg.getParameter("kodeUserPembuat"));
                    tbl.setStatusPembuatan(reg.getParameter("statusPembuatan"));
                    tbl.setNomorSuratPengajuan(reg.getParameter("nomorSuratPengajuan"));
                    tbl.setKodePKPT(user.getBranchCode()+reg.getParameter("tahunPKPT"));//(Util.right(Util.getYear(),2)+(Util.right((lSeq+""),4))); kagak apake sequence
                    tbl.setTahunPKPT(reg.getParameter("tahunPKPT"));
                    tbl.setStatusPKPT("B");  //Baru dibuat       
               tbl.setCreateBy(user.getUserId());
               tbl.setCreateDate(new Date());
               
               sess.beginTransaction();
               dao.insert(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl),"ADD",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               
               sess.close();
               h.put("successCode", 1);
        	   h.put("message", "Simpan Sukses");
               x=gson.toJson(h);
               System.out.println("x "+x);
         }catch(Exception e){
        	 if(sess != null && sess.isOpen()) sess.close();
        	 h.put("successCode", 0);
      	   	 h.put("message", "Simpan Gagal");
      	   	 x=gson.toJson(h); 
             System.out.println("gagal "+x);
             e.printStackTrace();
         }
         return x;
 	 }

//**************************************EDIT*************************************
//	 EDIT	 
	 @RequestMapping(value="/pasRaPKPTEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaPKPTEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodePKPT=reg.getParameter("kodePKPT");
		 
		String userId = reg.getParameter("userId");
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
               PasRaPKPTDAO dao = new PasRaPKPTDAO(sess);
               PasRaPKPT tbl = dao.getById(KodePKPT);
                String tblOld = gson.toJson(tbl);
                    tbl.setStatusPembuatan(reg.getParameter("statusPembuatan"));
               tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               
               sess.beginTransaction();
               dao.update(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl)+"OLD "+tblOld,"MODIFY",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               sess.close();
               h.put("successCode", 1);
        	   h.put("message", "Edit Sukses");
        	   x=gson.toJson(h); 
        	   System.out.println("edit "+x);
         }catch(Exception e){
        	 if(sess != null && sess.isOpen()) sess.close();
        	 h.put("successCode", 0);
      	   	 h.put("message", "Edit Gagal.....");
      	   	 x=gson.toJson(h); 

             e.printStackTrace();
         }
         return x;
 	 }
	 
//	***********************************DELETE**************************************** 
	 @RequestMapping(value="/pasRaPKPTDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaPKPTDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodePKPT=reg.getParameter("kodePKPT");
		 String userId = reg.getParameter("userId");
         TblUser user = (TblUser) session.getAttribute("user"+userId);
          if(!cekValidSession(session,userId)){
                	 return "fail";
         }
         Session sess = null;
         String x ="";
         Map h = new HashMap<String, Object>();
         Gson gson = new Gson();
         try {
               sess = HibernateUtil.getSessionFactory().openSession();
               PasRaPKPTDAO dao = new PasRaPKPTDAO(sess);
               PasRaPKPT tbl = dao.getById(KodePKPT);
               String tblDel = gson.toJson(tbl);
               sess.beginTransaction();
               dao.delete(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl),"DELETE",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               sess.close();
               h.put("successCode", 1);
        	   h.put("message", "Simpan Sukses");
               x=gson.toJson(h);
               System.out.println("delete sukses "+x);
         }catch(Exception e){
        	 if(sess != null && sess.isOpen()) sess.close();
        	 h.put("successCode", 0);
      	     h.put("message", "Delete GAGAL......");
      	     x=gson.toJson(h); 
      	   System.out.println("delete gagal "+x);
             e.printStackTrace();
         }
         return x;
 	 }

	 
//PENGAJUAN
	//**************************************pasRaPKPTPengajuan*************************************
	 @RequestMapping(value="/pasRaPKPTPengajuan.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaPKPTPengajuan(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodePKPT=reg.getParameter("kodePKPT");
		 
		String userId = reg.getParameter("userId");
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
               PasRaPKPTDAO dao = new PasRaPKPTDAO(sess);
               PasRaPKPT tbl = dao.getById(KodePKPT);
				String tblOld = gson.toJson(tbl);
				tbl.setStatusPembuatan("SS");// (reg.getParameter("statusPembuatan"));
				tbl.setNomorSuratPengajuan(reg.getParameter("nomorSuratPengajuan"));
				tbl.setTanggalSuratPengajuan(formatter.parse(reg.getParameter("tanggalSuratPengajuan")));
				tbl.setStatusPerstujuan("BP");//butuh persetujuan
				tbl.setStatusPKPT("P");//butuh persetujuan
				tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               
               sess.beginTransaction();
               dao.update(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl)+"OLD "+tblOld,"MODIFY",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               sess.close();
               h.put("successCode", 1);
        	   h.put("message", "Pengajuan Sukses");
        	   x=gson.toJson(h); 
         }catch(Exception e){
        	 if(sess != null && sess.isOpen()) sess.close();
        	 h.put("successCode", 0);
      	   	 h.put("message", "Pengajuan Gagal.....");
      	   	 x=gson.toJson(h); 

             e.printStackTrace();
         }
         return x;
 	 }
	
	 
	//PERSETUJUAN
		//**************************************pasRaPKPTPengajuan*************************************
		 @RequestMapping(value="/pasRaPKPTPersetujuan.htm", method=RequestMethod.POST)
	     public @ResponseBody String pasRaPKPTPersetujuan(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
	                    String KodePKPT=reg.getParameter("kodePKPT");
			 
			String userId = reg.getParameter("userId");
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
	               PasRaPKPTDAO dao = new PasRaPKPTDAO(sess);
	               PasRaPKPT tbl = dao.getById(KodePKPT);
					String tblOld = gson.toJson(tbl);
					tbl.setStatusPembuatan("SS");// (reg.getParameter("statusPembuatan"));
//					tbl.setNomorSuratPengajuan(reg.getParameter("nomorSuratPengajuan"));
//					tbl.setTanggalSuratPengajuan(formatter.parse(reg.getParameter("tanggalSuratPengajuan")));
					tbl.setStatusPerstujuan("BP");//butuh persetujuan
					tbl.setUpdateBy(user.getUserId());
	               tbl.setUpdateDate(new Date());
	               tbl.setTanggalSuratPersetujuan(formatter.parse(reg.getParameter("tanggalSuratPersetujuan")));
	               tbl.setNomorSuratPersetujuan(reg.getParameter("nomorSuratPersetujuan"));
	               tbl.setStatusPKPT("A");
	               tbl.setStatusPerstujuan("SS");
	               tbl.setKodeUserPenyetuju(user.getUserId());
	               
	               sess.beginTransaction();
	               dao.update(tbl);
	               simpanLog(user.getUserId(),gson.toJson(tbl)+"OLD "+tblOld,"MODIFY",sess,tbl.getClass().getName());
	               sess.getTransaction().commit();
	               sess.close();
	               h.put("successCode", 1);
	        	   h.put("message", "Pengajuan Sukses");
	        	   x=gson.toJson(h); 
	         }catch(Exception e){
	        	 if(sess != null && sess.isOpen()) sess.close();
	        	 h.put("successCode", 0);
	      	   	 h.put("message", "Pengajuan Gagal.....");
	      	   	 x=gson.toJson(h); 

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

	@RequestMapping(value="/pasRaPKPTReport.htm",method=RequestMethod.GET)
	 public String doGetpasRaPKPTReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/pasRaPKPTReport";
	}
	
	
		 @RequestMapping(value="/pasRaPKPTDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String pasRaPKPTDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeKantorAuditorPemilik=reg.getParameter("KodeKantorAuditorPemilik");
                    String StatusReviu=reg.getParameter("StatusReviu");
                    String KodePKPT=reg.getParameter("KodePKPT");
                    String TahunPKPT=reg.getParameter("TahunPKPT");
                    String StatusPKPT=reg.getParameter("StatusPKPT");		 
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
			PasRaPKPTDAO dao = new PasRaPKPTDAO(sess);
			List<PasRaPKPT> l = new ArrayList<PasRaPKPT>();
				l = dao.getBy(KodeKantorAuditorPemilik,StatusReviu,KodePKPT,TahunPKPT,StatusPKPT);
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
			// TODO: handle exception
			e.printStackTrace();
		}         
         return result;
     }
	
	
	
	
	
}
