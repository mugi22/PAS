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
import co.id.pegadaian.pasg2.pojo.PasKsAuditTrail;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.PasKsAuditTrailDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasKsAuditTrailController  extends AbstractListScreen{
	@RequestMapping(value="/pasKsAuditTrail.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/pasKsAuditTrail.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasKsAuditTrail";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/pasKsAuditTrailListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String pasKsAuditTrailListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String AlamatIP=reg.getParameter("AlamatIP");
                    String KodeRecord ="0";
                    if(reg.getParameter("KodeRecord").length()>0){
                    KodeRecord = (reg.getParameter("KodeRecord"));
                    }
                    String NamaTable=reg.getParameter("NamaTable");
                    String Aksi=reg.getParameter("Aksi");
                    String KodeUserPelaku=reg.getParameter("KodeUserPelaku");
                    String KodeAuditTrail ="0";
                    if(reg.getParameter("KodeAuditTrail").length()>0){
                    KodeAuditTrail = (reg.getParameter("KodeAuditTrail"));
                    }
                    String NamaKomputer=reg.getParameter("NamaKomputer");		 
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
			PasKsAuditTrailDAO dao = new PasKsAuditTrailDAO(sess);
			Map h = new HashMap<String, Object>();
			List<PasKsAuditTrail> l = new ArrayList<PasKsAuditTrail>();
				h = dao.getByPerPage(AlamatIP,Long.parseLong(KodeRecord),NamaTable,Aksi,KodeUserPelaku,Long.parseLong(KodeAuditTrail),NamaKomputer,loffset, row);
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
 @RequestMapping(value="/pasKsAuditTrailAdd.htm", method=RequestMethod.POST)
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
               PasKsAuditTrailDAO dao = new PasKsAuditTrailDAO(sess);
               PasKsAuditTrail tbl = new PasKsAuditTrail();
                    tbl.setAlamatIP(reg.getParameter("alamatIP"));
                    tbl.setKodeRecord(Long.parseLong((reg.getParameter("kodeRecord"))));
                    tbl.setNamaTable(reg.getParameter("namaTable"));
                    tbl.setAksi(reg.getParameter("aksi"));
                    tbl.setKodeUserPelaku(reg.getParameter("kodeUserPelaku"));
                    tbl.setKodeAuditTrail(Long.parseLong((reg.getParameter("kodeAuditTrail"))));
                    tbl.setNamaKomputer(reg.getParameter("namaKomputer"));
                             
               tbl.setCreateBy(user.getUserId());
               tbl.setCreateDate(new Date());
               
               sess.beginTransaction();
               dao.insert(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl),"ADD",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
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
	 @RequestMapping(value="/pasKsAuditTrailEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String pasKsAuditTrailEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeAuditTrail="0";
                    if(reg.getParameter("kodeAuditTrail").length()>0){
                    KodeAuditTrail = (reg.getParameter("kodeAuditTrail"));
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
               PasKsAuditTrailDAO dao = new PasKsAuditTrailDAO(sess);
               PasKsAuditTrail tbl = dao.getById(Long.parseLong(KodeAuditTrail));
                String tblOld = gson.toJson(tbl);
                    tbl.setAlamatIP(reg.getParameter("alamatIP"));
                    tbl.setKodeRecord(Long.parseLong((reg.getParameter("kodeRecord"))));
                    tbl.setNamaTable(reg.getParameter("namaTable"));
                    tbl.setAksi(reg.getParameter("aksi"));
                    tbl.setKodeUserPelaku(reg.getParameter("kodeUserPelaku"));
                    tbl.setKodeAuditTrail(Long.parseLong((reg.getParameter("kodeAuditTrail"))));
                    tbl.setNamaKomputer(reg.getParameter("namaKomputer"));
               
               tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               
               sess.beginTransaction();
               dao.update(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl)+" OLD: "+tblOld,"MODIFY",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               sess.close();
               x=gson.toJson("UPDATE SUKSES");
         }catch(Exception e){
             x=gson.toJson("fail");
             e.printStackTrace();
         }
         return x;
 	 }
	 
//	***********************************DELETE**************************************** 
	 @RequestMapping(value="/pasKsAuditTrailDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String pasKsAuditTrailDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeAuditTrail="0";
                    if(reg.getParameter("kodeAuditTrail").length()>0){
                    KodeAuditTrail = (reg.getParameter("kodeAuditTrail"));
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
               PasKsAuditTrailDAO dao = new PasKsAuditTrailDAO(sess);
               PasKsAuditTrail tbl = dao.getById(Long.parseLong(KodeAuditTrail));
               String tblDel = gson.toJson(tbl);
               sess.beginTransaction();
               dao.delete(tbl);
               simpanLog(user.getUserId(),tblDel,"DELETE  : ",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
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

	@RequestMapping(value="/pasKsAuditTrailReport.htm",method=RequestMethod.GET)
	 public String doGetpasKsAuditTrailReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/pasKsAuditTrailReport";
	}
	
	
		 @RequestMapping(value="/pasKsAuditTrailDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String pasKsAuditTrailDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String AlamatIP=reg.getParameter("AlamatIP");
                    String KodeRecord ="0";
                    if(reg.getParameter("KodeRecord").length()>0){
                    KodeRecord = (reg.getParameter("KodeRecord"));
                    }
                    String NamaTable=reg.getParameter("NamaTable");
                    String Aksi=reg.getParameter("Aksi");
                    String KodeUserPelaku=reg.getParameter("KodeUserPelaku");
                    String KodeAuditTrail ="0";
                    if(reg.getParameter("KodeAuditTrail").length()>0){
                    KodeAuditTrail = (reg.getParameter("KodeAuditTrail"));
                    }
                    String NamaKomputer=reg.getParameter("NamaKomputer");		 
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
			PasKsAuditTrailDAO dao = new PasKsAuditTrailDAO(sess);
			List<PasKsAuditTrail> l = new ArrayList<PasKsAuditTrail>();
				l = dao.getBy(AlamatIP,Long.parseLong(KodeRecord),NamaTable,Aksi,KodeUserPelaku,Long.parseLong(KodeAuditTrail),NamaKomputer);
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
