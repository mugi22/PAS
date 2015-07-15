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
import co.id.pegadaian.pasg2.pojo.PasRaDetailRKAP;
import co.id.pegadaian.pasg2.pojo.TblUser;
import co.id.pegadaian.pasg2.pojo.PasRaMasterRKAP;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.PasRaDetailRKAPDAO;
import co.id.pegadaian.pasg2.dao.PasRaMasterRKAPDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasRaMasterRKAPSahController  extends AbstractListScreen{
	@RequestMapping(value="/pasRaMasterRKAPSah.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
		model.put("kodeUser", "testtt");
	 	
	 	//model.put(key, value)
	 	String sUserId = reg.getParameter("UID");
	 	TblUser user = (TblUser) session.getAttribute("user"+sUserId);
	 	model.put("tblUser", user);
	 	return super.doGet(model, session, reg,res);//getView();	
	}
	
	
	 @RequestMapping(value="/pasRaMasterRKAPSah.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasRaMasterRKAPSah";
	}
	
////	 ***************************** LIST  **************************************************************
//	 @RequestMapping(value="/pasRaMasterRKAPReviuListAll.htm", method=RequestMethod.POST)
//     public @ResponseBody String pasRaMasterRKAPListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//                    String KodeRKAP=reg.getParameter("KodeRKAP");
//                    String TahunRKAP=reg.getParameter("TahunRKAP");
//                    String StatusRKAP=reg.getParameter("StatusRKAP");
//                    String KodeKantorAuditorPemilik=reg.getParameter("KodeKantorAuditorPemilik");
//                    String StatusPersetujuan=reg.getParameter("StatusPersetujuan");		//String StatusPembuatan StatusReviu
//                    String StatusPembuatan=reg.getParameter("StatusPembuatan");	
//                    String StatusReviu=reg.getParameter("StatusReviu");	
//         String userId = reg.getParameter("userId");
//         String ses = (String) session.getAttribute("session"+userId);
//         TblUser user = (TblUser) session.getAttribute("user"+userId);
//  
//         model.put("session", ses);
//         if(!cekValidSession(session,userId)){
//        	 return "[]";
//         }
//         String result="";
//         int row = Integer.parseInt(reg.getParameter("rows"));
//         int loffset = (Integer.parseInt(reg.getParameter("page"))-1)*row;
//         Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
//         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//         Session sess = null;
//         try {
//        	long rowCount=0;
//			sess = HibernateUtil.getSessionFactory().openSession();
//			PasRaMasterRKAPDAO dao = new PasRaMasterRKAPDAO(sess);
//			Map h = new HashMap<String, Object>();
//			List<PasRaMasterRKAP> l = new ArrayList<PasRaMasterRKAP>();
//				h = dao.getByPerPage(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan, StatusPembuatan,StatusReviu,loffset, row);
//			sess.close();
//            result = gson.toJson(h);
//            System.out.println(result);
//            
//            /**  BILA ADA PERUBAHAN DATA JSON
//            String x = changeJson(h, sess);
//            sess.close();
//        	result ="{"+'"'+"total"+'"'+":"+h.get("total")+","+'"'+"rows"+'"'+":["+x+']'+'}';
//            */
//            
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}         
//         return result;
//     }
//
//// *********************ADD***********************
// @RequestMapping(value="/pasRaMasterRKAPReviuAdd.htm", method=RequestMethod.POST)
//     public @ResponseBody String pasRaMasterRKAPAdd(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//		String userId = reg.getParameter("userId");
//         //String ses = (String) session.getAttribute("session"+userId);
//         TblUser user = (TblUser) session.getAttribute("user"+userId);
//         
//         if(!cekValidSession(session,userId)){
//        	 return "fail";
//         }
//         Session sess = null;
//         String x ="";
//         Map h = new HashMap<String, Object>();
//         Gson gson = new Gson();
//         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//         try {
//               sess = HibernateUtil.getSessionFactory().openSession();
//               PasRaMasterRKAPDAO dao = new PasRaMasterRKAPDAO(sess);
//               PasRaMasterRKAP tbl = new PasRaMasterRKAP();
//                    tbl.setKodeRKAP(reg.getParameter("kodeRKAP"));
//                    tbl.setTahunRKAP(reg.getParameter("tahunRKAP"));
//                    tbl.setStatusRKAP(reg.getParameter("statusRKAP"));
//                    tbl.setKodeRKAPYangDirevisi(reg.getParameter("kodeRKAPYangDirevisi"));
//                    tbl.setKodeKantorAuditorPemilik(reg.getParameter("kodeKantorAuditorPemilik"));
//                    tbl.setKodeUserPembuat(reg.getParameter("kodeUserPembuat"));
//                    tbl.setStatusPembuatan(reg.getParameter("statusPembuatan"));
//                    tbl.setNomorSuratPengajuan(reg.getParameter("nomorSuratPengajuan"));
//                    
//                  
//                    
////                    tbl.setKodeUserPreviu(reg.getParameter("kodeUserPreviu"));
////                    tbl.setStatusReviu(reg.getParameter("statusReviu"));
////                    tbl.setKodeUserPenyetuju(reg.getParameter("kodeUserPenyetuju"));
////                    tbl.setStatusPersetujuan(reg.getParameter("statusPersetujuan"));
////                    tbl.setNomorSuratPersetujuan(reg.getParameter("nomorSuratPersetujuan"));
////                    if(reg.getParameter("tanggalSuratPengajuan").length()>0 && reg.getParameter("tanggalSuratPengajuan")!=null){//||reg.getParameter("tanggalSuratPengajuan").equals(""))
////                    	tbl.setTanggalSuratPengajuan(formatter.parse(reg.getParameter("tanggalSuratPengajuan")));
////                    }
////                    if(reg.getParameter("tanggalSuratPersetujuan").length()>0){//||reg.getParameter("tanggalSuratPersetujuan")!=null||reg.getParameter("tanggalSuratPersetujuan").equals(""))
////                    	tbl.setTanggalSuratPersetujuan(formatter.parse(reg.getParameter("tanggalSuratPersetujuan")));
////                    }
//               tbl.setCreateBy(user.getUserId());
//               tbl.setCreateDate(new Date());
//               
//               sess.beginTransaction();
//               dao.insert(tbl);
//               simpanLog(user.getUserId(),gson.toJson(tbl),"ADD",sess,tbl.getClass().getName());
//               sess.getTransaction().commit();
//               
//               sess.close();
//               x=gson.toJson("SUKSES");
//         }catch(Exception e){
//             x=gson.toJson("fail");
//             e.printStackTrace();
//         }
//         return x;
// 	 }
//
////**************************************EDIT*************************************
////	 EDIT	 
//	 @RequestMapping(value="/pasRaMasterRKAPReviuEdit.htm", method=RequestMethod.POST)
//     public @ResponseBody String pasRaMasterRKAPEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//                    String KodeRKAP=reg.getParameter("kodeRKAP");
//		 
//		String userId = reg.getParameter("userId");
//         //String ses = (String) session.getAttribute("session"+userId);
//         TblUser user = (TblUser) session.getAttribute("user"+userId);
//         if(!cekValidSession(session,userId)){        	 
//         	return "fail";
//         }
//         
//         Session sess = null;
//         String x ="";
//         Map h = new HashMap<String, Object>();
//         Gson gson = new Gson();
//         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//         try {
//               sess = HibernateUtil.getSessionFactory().openSession();
//               PasRaMasterRKAPDAO dao = new PasRaMasterRKAPDAO(sess);
//               PasRaMasterRKAP tbl = dao.getById(KodeRKAP);
//                String tblOld = gson.toJson(tbl);
//                    tbl.setKodeRKAP(reg.getParameter("kodeRKAP"));
//                    tbl.setTahunRKAP(reg.getParameter("tahunRKAP"));
//                    tbl.setStatusRKAP(reg.getParameter("statusRKAP"));
//                    tbl.setKodeRKAPYangDirevisi(reg.getParameter("kodeRKAPYangDirevisi"));
//                    tbl.setKodeKantorAuditorPemilik(reg.getParameter("kodeKantorAuditorPemilik"));
//                    tbl.setKodeUserPembuat(reg.getParameter("kodeUserPembuat"));
//                    tbl.setStatusPembuatan(reg.getParameter("statusPembuatan"));
////                    tbl.setNomorSuratPengajuan(reg.getParameter("nomorSuratPengajuan"));
//////                  tbl.setTanggalSuratPengajuan(formatter.parse(reg.getParameter("tanggalSuratPengajuan")));
////                    tbl.setKodeUserPreviu(reg.getParameter("kodeUserPreviu"));
////                    tbl.setStatusReviu(reg.getParameter("statusReviu"));
////                    tbl.setKodeUserPenyetuju(reg.getParameter("kodeUserPenyetuju"));
////                    tbl.setStatusPersetujuan(reg.getParameter("statusPersetujuan"));
////                    tbl.setNomorSuratPersetujuan(reg.getParameter("nomorSuratPersetujuan"));
//////                    tbl.setTanggalSuratPersetujuan(formatter.parse(reg.getParameter("tanggalSuratPersetujuan")));
////                    
////                    if(reg.getParameter("tanggalSuratPengajuan").length()>0){//||reg.getParameter("tanggalSuratPengajuan")!=null||reg.getParameter("tanggalSuratPengajuan").equals(""))
////                    	tbl.setTanggalSuratPengajuan(formatter.parse(reg.getParameter("tanggalSuratPengajuan")));
////                    }
////                    if(reg.getParameter("tanggalSuratPersetujuan").length()>0){//||reg.getParameter("tanggalSuratPersetujuan")!=null||reg.getParameter("tanggalSuratPersetujuan").equals(""))
////                    	tbl.setTanggalSuratPersetujuan(formatter.parse(reg.getParameter("tanggalSuratPersetujuan")));
////                    }
//               
//               tbl.setUpdateBy(user.getUserId());
//               tbl.setUpdateDate(new Date());
//               
//               sess.beginTransaction();
//               dao.update(tbl);
//               simpanLog(user.getUserId(),gson.toJson(tbl)+"OLD "+tblOld,"MODIFY",sess,tbl.getClass().getName());
//               sess.getTransaction().commit();
//               sess.close();
//               x=gson.toJson("UPDATE SUKSES");
//         }catch(Exception e){
//             x=gson.toJson("fail");
//             e.printStackTrace();
//         }
//         return x;
// 	 }
//	 
////	***********************************DELETE**************************************** 
//	 @RequestMapping(value="/pasRaMasterRKAPReviuDelete.htm", method=RequestMethod.POST)
//     public @ResponseBody String pasRaMasterRKAPDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//                    String KodeRKAP=reg.getParameter("kodeRKAP");
//	
//		 String userId = reg.getParameter("userId");
//         TblUser user = (TblUser) session.getAttribute("user"+userId);
//          if(!cekValidSession(session,userId)){
//                	 return "fail";
//         }
//          
//         Session sess = null;
//         String x ="";
//         Map h = new HashMap<String, Object>();
//         Gson gson = new Gson();
//         try {
//               sess = HibernateUtil.getSessionFactory().openSession();
////             Sebelum delete cek apakah masih nyangkut di detail
//               PasRaDetailRKAPDAO detailRKAPDAO = new PasRaDetailRKAPDAO(sess);
//               List<PasRaDetailRKAP> l = detailRKAPDAO.getBy("", KodeRKAP);
//               if(l.size()>0){
//            	   //System.out.println("DISINIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII"+gson.toJson(h.put("success", false)));
//            	   
//                   h.put("success", "Data Detail Masih Ada");
//                   x=gson.toJson(h);
//                   System.out.println("xx  : "+x);
//                   sess.close();
//            	   return x;//gson.toJson(h.put("success", "fail")); //"fail";
//               }
//               PasRaMasterRKAPDAO dao = new PasRaMasterRKAPDAO(sess);
//               PasRaMasterRKAP tbl = dao.getById(KodeRKAP);
//               String tblDel = gson.toJson(tbl);
//               sess.beginTransaction();
//               dao.delete(tbl);
//               simpanLog(user.getUserId(),gson.toJson(tbl),"DELETE",sess,tbl.getClass().getName());
//               sess.getTransaction().commit();
//               sess.close();
//               h.put("success", true);
//               x=gson.toJson(h);
//         }catch(Exception e){
//        	 x=gson.toJson("fail");
//             e.printStackTrace();
//         }
//         return x;
// 	 }
//
////----------BILA ADA PERUBAHAN DATA JSON, RUBAH DI SINI------------------------------------------
////	public String changeJson(Map<String,Object> result, Session sess){//nemabhakan field nama group dan nama menu
////		List<TblPriviledge> listPri = (List<TblPriviledge>) result.get("rows");
//////		List<TblPriviledge> priv = (List<TblPriviledge>) h.get("rows");
////		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
////		StringBuffer sb = new StringBuffer();
////		for(TblPriviledge pr : listPri){
////			String s = gson.toJson(pr);			
////			TblGroupDAO groupDAO = new TblGroupDAO(sess);
////			TblGroup group = groupDAO.getById(pr.getGroupId());
////			TblMenuDAO menuDAO = new TblMenuDAO(sess);
////			TblMenu menu =  menuDAO.getById(pr.getMenuId());
////			String a = s.replace("}", ","+'"'+"groupName"+'"'+":"+'"'+group.getGroupName()+'"'+","+'"'+"menuName"+'"'+":"+'"'+menu.getMenuName()+'"'+"},");
////			sb.append(a);
////		}
////		String x="";
////		if(sb.toString().length()>0){
////			x= (sb.toString()).substring(0,sb.toString().length()-1);
////		}	else{
////			x="";
////		}
////		return x;
////	}
//
//	 
//	 
////	//**********************************PENGAJUAN MASTER****EDIT*************************************
////	 @RequestMapping(value="/pasRaMasterRKAPPengajuanEdit.htm", method=RequestMethod.POST)
////     public @ResponseBody String pasRaMasterRKAPPengajuanEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
////                    String KodeRKAP=reg.getParameter("kodeRKAPDM");
////		 
////		String userId = reg.getParameter("userId");
////         //String ses = (String) session.getAttribute("session"+userId);
////         TblUser user = (TblUser) session.getAttribute("user"+userId);
////         if(!cekValidSession(session,userId)){        	 
////         	return "fail";
////         }
////         
////         Session sess = null;
////         String x ="";
////         Map h = new HashMap<String, Object>();
////         Gson gson = new Gson();
////         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
////         try {
////               sess = HibernateUtil.getSessionFactory().openSession();
////               PasRaMasterRKAPDAO dao = new PasRaMasterRKAPDAO(sess);
////               PasRaMasterRKAP tbl = dao.getById(KodeRKAP);
////                String tblOld = gson.toJson(tbl);
//////                    tbl.setKodeRKAP(reg.getParameter("kodeRKAP"));
//////                    tbl.setTahunRKAP(reg.getParameter("tahunRKAP"));
////                    tbl.setStatusRKAP("A");//(reg.getParameter("statusRKAP"));
////                    tbl.setStatusPembuatan("SS");//(reg.getParameter("statusPembuatan"));
////                    tbl.setNomorSuratPengajuan(reg.getParameter("nomorSuratPengajuanAju"));
////                    tbl.setTanggalSuratPengajuan(new Date());
////                    if(reg.getParameter("tanggalSuratPengajuanAju").length()>0){//||reg.getParameter("tanggalSuratPengajuan")!=null||reg.getParameter("tanggalSuratPengajuan").equals(""))
////                    	tbl.setTanggalSuratPengajuan(formatter.parse(reg.getParameter("tanggalSuratPengajuanAju")));
////                    }
//////                    tbl.setKodeRKAPYangDirevisi(reg.getParameter("kodeRKAPYangDirevisi"));
//////                    tbl.setKodeKantorAuditorPemilik(reg.getParameter("kodeKantorAuditorPemilik"));
//////                    tbl.setKodeUserPembuat(reg.getParameter("kodeUserPembuat"));
//////                    tbl.setKodeUserPreviu(reg.getParameter("kodeUserPreviu"));
//////                    tbl.setStatusReviu(reg.getParameter("statusReviu"));
//////                    tbl.setKodeUserPenyetuju(reg.getParameter("kodeUserPenyetuju"));
//////                    tbl.setStatusPersetujuan(reg.getParameter("statusPersetujuan"));
//////                    tbl.setNomorSuratPersetujuan(reg.getParameter("nomorSuratPersetujuan"));
//////                    tbl.setTanggalSuratPersetujuan(formatter.parse(reg.getParameter("tanggalSuratPersetujuan")));
//////                    if(reg.getParameter("tanggalSuratPersetujuan").length()>0){//||reg.getParameter("tanggalSuratPersetujuan")!=null||reg.getParameter("tanggalSuratPersetujuan").equals(""))
//////                    	tbl.setTanggalSuratPersetujuan(formatter.parse(reg.getParameter("tanggalSuratPersetujuan")));
//////                    }
////               
////               tbl.setUpdateBy(user.getUserId());
////               tbl.setUpdateDate(new Date());
////               
////               sess.beginTransaction();
////               dao.update(tbl);
////               simpanLog(user.getUserId(),gson.toJson(tbl)+"OLD "+tblOld,"MODIFY",sess,tbl.getClass().getName());
////               sess.getTransaction().commit();
////               sess.close();
////               x=gson.toJson("UPDATE SUKSES");
////         }catch(Exception e){
////             x=gson.toJson("fail");
////             e.printStackTrace();
////         }
////         return x;
//// 	 }
//	 
//////===============================REPORT====================================================
////
////	@RequestMapping(value="/pasRaMasterRKAPReport.htm",method=RequestMethod.GET)
////	 public String doGetpasRaMasterRKAPReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
////	 	super.doGet(model, session, reg,res);
////	 	return "/report/pasRaMasterRKAPReport";
////	}
////	
////	
////		 @RequestMapping(value="/pasRaMasterRKAPDataReport.htm", method=RequestMethod.GET)
////     public @ResponseBody String pasRaMasterRKAPDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
////                    String KodeRKAP=reg.getParameter("KodeRKAP");
////                    String TahunRKAP=reg.getParameter("TahunRKAP");
////                    String StatusRKAP=reg.getParameter("StatusRKAP");
////                    String KodeKantorAuditorPemilik=reg.getParameter("KodeKantorAuditorPemilik");
////                    String StatusPersetujuan=reg.getParameter("StatusPersetujuan");		 
////         String userId = reg.getParameter("userId");
////         String ses = (String) session.getAttribute("session"+userId);
////         TblUser user = (TblUser) session.getAttribute("user"+userId);
////  
////         model.put("session", ses);
////         if(!cekValidSession(session,userId)){
////        	 return "[]";
////         }
////         String result="";
////          Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
////         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
////         Session sess = null;
////         try {
////        	long rowCount=0;
////			sess = HibernateUtil.getSessionFactory().openSession();
////			PasRaMasterRKAPDAO dao = new PasRaMasterRKAPDAO(sess);
////			List<PasRaMasterRKAP> l = new ArrayList<PasRaMasterRKAP>();
////				l = dao.getBy(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan);
////			sess.close();
////            result = gson.toJson(l);
////            System.out.println(result);
////            
////            /**  BILA ADA PERUBAHAN DATA JSON
////            String x = changeJson(h, sess);
////            sess.close();
////        	result ="{"+'"'+"total"+'"'+":"+h.get("total")+","+'"'+"rows"+'"'+":["+x+']'+'}';
////            */
////            
////			
////		} catch (Exception e) {
////			// TODO: handle exception
////			e.printStackTrace();
////		}         
////         return result;
////     }
////	
////	
////	
//	
	
}
