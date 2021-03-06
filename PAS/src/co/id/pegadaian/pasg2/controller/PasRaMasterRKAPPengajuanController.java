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
public class PasRaMasterRKAPPengajuanController  /*extends AbstractListScreen*/{
//	@RequestMapping(value="/pasRaMasterRKAPPengajuan.htm",method=RequestMethod.GET)
//	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
//		model.put("kodeUser", "testtt");
//	 	super.doGet(model, session, reg,res);
//	 	//model.put(key, value)
//	 	String sUserId = reg.getParameter("UID");
//	 	TblUser user = (TblUser) session.getAttribute("user"+sUserId);
//	 	model.put("tblUser", user);
//	 	return getView();	
//	}
//	
//	
//	 @RequestMapping(value="/pasRaMasterRKAPPengajuan.htm", method=RequestMethod.POST)
//	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
//		 super.doPost(model, session,reg,res);
//		return getView();		 
//	 }
//	 
//	 @Override
//	protected String getView() {
//		// TODO Auto-generated method stub
//		return "pasRaMasterRKAPPengajuan";
//	}
//	
////	 ***************************** LIST  **************************************************************
//	 @RequestMapping(value="/pasRaMasterRKAPPengajuanListAll.htm", method=RequestMethod.POST)
//     public @ResponseBody String pasRaMasterRKAPListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//                    String KodeRKAP=reg.getParameter("KodeRKAP");
//                    String TahunRKAP=reg.getParameter("TahunRKAP");
//                    String StatusRKAP=reg.getParameter("StatusRKAP");
//                    String KodeKantorAuditorPemilik=reg.getParameter("KodeKantorAuditorPemilik");
//                    String StatusPersetujuan=reg.getParameter("StatusPersetujuan");		 
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
//				h = dao.getByPerPage(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan,loffset, row);
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
// @RequestMapping(value="/pasRaMasterRKAPPengajuanAdd.htm", method=RequestMethod.POST)
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
//                    tbl.setNomorSuratPersetujuan(reg.getParameter("nomorSuratPersetujuan"));
//                    System.out.println(formatter.parse(reg.getParameter("tanggalSuratPengajuan")));
//                    if(reg.getParameter("tanggalSuratPengajuan").length()>0 /*&& reg.getParameter("tanggalSuratPengajuan")!=null*/){//||reg.getParameter("tanggalSuratPengajuan").equals(""))
//                    	tbl.setTanggalSuratPengajuan(formatter.parse(reg.getParameter("tanggalSuratPengajuan")));
//                    }
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
////	***********************************DELETE**************************************** 
//	 @RequestMapping(value="/pasRaMasterRKAPPengajuanDelete.htm", method=RequestMethod.POST)
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
////===============================REPORT====================================================
//
//	@RequestMapping(value="/pasRaMasterRKAPPengajuanReport.htm",method=RequestMethod.GET)
//	 public String doGetpasRaMasterRKAPReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
//	 	super.doGet(model, session, reg,res);
//	 	return "/report/pasRaMasterRKAPReport";
//	}
//	
//	
//		 @RequestMapping(value="/pasRaMasterRKAPPengajuanReport.htm", method=RequestMethod.GET)
//     public @ResponseBody String pasRaMasterRKAPDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//                    String KodeRKAP=reg.getParameter("KodeRKAP");
//                    String TahunRKAP=reg.getParameter("TahunRKAP");
//                    String StatusRKAP=reg.getParameter("StatusRKAP");
//                    String KodeKantorAuditorPemilik=reg.getParameter("KodeKantorAuditorPemilik");
//                    String StatusPersetujuan=reg.getParameter("StatusPersetujuan");		 
//         String userId = reg.getParameter("userId");
//         String ses = (String) session.getAttribute("session"+userId);
//         TblUser user = (TblUser) session.getAttribute("user"+userId);
//  
//         model.put("session", ses);
//         if(!cekValidSession(session,userId)){
//        	 return "[]";
//         }
//         String result="";
//          Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
//         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//         Session sess = null;
//         try {
//        	long rowCount=0;
//			sess = HibernateUtil.getSessionFactory().openSession();
//			PasRaMasterRKAPDAO dao = new PasRaMasterRKAPDAO(sess);
//			List<PasRaMasterRKAP> l = new ArrayList<PasRaMasterRKAP>();
//				l = dao.getBy(KodeRKAP,TahunRKAP,StatusRKAP,KodeKantorAuditorPemilik,StatusPersetujuan);
//			sess.close();
//            result = gson.toJson(l);
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
//	
//	
	
	
}
