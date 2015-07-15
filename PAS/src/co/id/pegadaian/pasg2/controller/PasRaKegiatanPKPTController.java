/*
*Create by CodeGenerator
*controllerTemplate
*M U G I
*/

package co.id.pegadaian.pasg2.controller;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import co.id.pegadaian.pasg2.pojo.PasRaPKPT;
import co.id.pegadaian.pasg2.pojo.TblUser;
import co.id.pegadaian.pasg2.pojo.PasRaKegiatanPKPT;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.PasRaKegiatanPKPTDAO;
import co.id.pegadaian.pasg2.dao.PasRaPKPTDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasRaKegiatanPKPTController  extends AbstractListScreen{
	@RequestMapping(value="/pasRaKegiatanPKPT.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/pasRaKegiatanPKPT.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasRaKegiatanPKPT";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/pasRaKegiatanPKPTListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaKegiatanPKPTListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String NamaKegiatan=reg.getParameter("NamaKegiatan");
                    String KodePKPT=reg.getParameter("KodePKPT");		 
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
			PasRaKegiatanPKPTDAO dao = new PasRaKegiatanPKPTDAO(sess);
			Map h = new HashMap<String, Object>();
			List<PasRaKegiatanPKPT> l = new ArrayList<PasRaKegiatanPKPT>();
				h = dao.getByPerPage(NamaKegiatan,KodePKPT,loffset, row);
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
//--------------------------
	 //	 ***************************** LISTpasRaKegiatanPKPTListByMonth  **************************************************************
	 @RequestMapping(value="/pasRaKegiatanPKPTListByMonth.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaKegiatanPKPTListByMonth(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String bulan=reg.getParameter("bulan");
                    String KodePKPT=reg.getParameter("KodePKPT");		
                    String thPKPT = reg.getParameter("thPKPT");
                    System.out.println("bulan "+bulan+" KodePKPT "+"thPKPT "+thPKPT);
         String userId = reg.getParameter("userId");
         String ses = (String) session.getAttribute("session"+userId);
         TblUser user = (TblUser) session.getAttribute("user"+userId);
         int row = Integer.parseInt(reg.getParameter("rows"));
         int loffset = (Integer.parseInt(reg.getParameter("page"))-1)*row;
         model.put("session", ses);
         if(!cekValidSession(session,userId)){
        	 return "[]";
         }
         String result="";
         Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         Date tglAwalKegiatan = null;
         Date tglAkhir = null;
         Calendar c = Calendar.getInstance();
         try {
			tglAwalKegiatan = formatter.parse("01-"+bulan+"-"+thPKPT);
			c.setTime(tglAwalKegiatan);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			tglAkhir = c.getTime();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         Session sess = null;
         try {
        	long rowCount=0;
			sess = HibernateUtil.getSessionFactory().openSession();
			PasRaKegiatanPKPTDAO dao = new PasRaKegiatanPKPTDAO(sess);
			Map h = new HashMap<String, Object>();
				h = dao.getByMont(tglAwalKegiatan,tglAkhir,KodePKPT,loffset, row);
				List<PasRaKegiatanPKPT> l = (List<PasRaKegiatanPKPT>) h.get("rows");
//				bila masih kosong tambahkan sesuai tgl kalender 30/31
				if(l.size()>0){
					System.out.println("Sudah Ada Kegiatan");
				}else{
					//cek untuk yang sudah approved atau dalam pengajuan tidak boleh di update lagi
					PasRaPKPTDAO pasRaPKPTDAO = new PasRaPKPTDAO(sess);
					PasRaPKPT pasRaPKPT = pasRaPKPTDAO.getById(KodePKPT);
					if(pasRaPKPT.getStatusPKPT().equals("B")){
					Calendar start = Calendar.getInstance();
					start.setTime(tglAwalKegiatan);
					Calendar end = Calendar.getInstance();
					end.setTime(tglAkhir);
					end.add(Calendar.DATE, 1);
					PasRaKegiatanPKPTDAO kegiatanPKPTDAO = new PasRaKegiatanPKPTDAO(sess);
					sess.beginTransaction();
					for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
						String seqName ="KGT-PKPT-"+Util.right((Util.getYear()),2)+user.getBranchCode();
						long  lSeq = SequenceAdd.generateSEQ(seqName)+10000;
						PasRaKegiatanPKPT kegiatanPKPT = new PasRaKegiatanPKPT();
						kegiatanPKPT.setBiayaLumpsum(new BigDecimal(0));
						kegiatanPKPT.setBiayaMobilDinas(new BigDecimal(0));
						kegiatanPKPT.setBiayaTransportasi(new BigDecimal(0));
						kegiatanPKPT.setKodeKegiatanPKPT(Util.right((Util.getYear()),2)+lSeq);
						kegiatanPKPT.setKodePKPT(KodePKPT);
						kegiatanPKPT.setTanggalAwal(date);
						kegiatanPKPT.setTanggalAkhir(date);
						kegiatanPKPTDAO.insert(kegiatanPKPT);						
					}
					sess.getTransaction().commit();
					}
				}
			h = dao.getByMont(tglAwalKegiatan,tglAkhir,KodePKPT,loffset, row);
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
 @RequestMapping(value="/pasRaKegiatanPKPTAdd.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaKegiatanPKPTAdd(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
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
               PasRaKegiatanPKPTDAO dao = new PasRaKegiatanPKPTDAO(sess);
               PasRaKegiatanPKPT tbl = new PasRaKegiatanPKPT();
                    tbl.setKodeUserPembuat(reg.getParameter("kodeUserPembuat"));
                    tbl.setTanggalAwal(formatter.parse(reg.getParameter("tanggalAwal")));
                    tbl.setTanggalAkhir(formatter.parse(reg.getParameter("tanggalAkhir")));
                    tbl.setNamaKegiatan(reg.getParameter("namaKegiatan"));
                    tbl.setKeteranganKegiatan(reg.getParameter("keteranganKegiatan"));
                    tbl.setJenisTransportasi(reg.getParameter("jenisTransportasi"));
                    tbl.setBiayaTransportasi(new BigDecimal((reg.getParameter("biayaTransportasi"))));
                    tbl.setBiayaLumpsum(new BigDecimal((reg.getParameter("biayaLumpsum"))));
                    tbl.setKodeKegiatanPKPT(reg.getParameter("kodeKegiatanPKPT"));
                    tbl.setBiayaMobilDinas(new BigDecimal((reg.getParameter("biayaMobilDinas"))));
                    tbl.setKodePKPT(reg.getParameter("kodePKPT"));
                    tbl.setStatusInap(reg.getParameter("statusInap"));
                             
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
	 @RequestMapping(value="/pasRaKegiatanPKPTEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaKegiatanPKPTEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeKegiatanPKPT=reg.getParameter("kodeKegiatanPKPT");
                    String KodePKPT=reg.getParameter("kodePKPT");
		 
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
               PasRaKegiatanPKPTDAO dao = new PasRaKegiatanPKPTDAO(sess);
               PasRaKegiatanPKPT tbl = dao.getById(KodeKegiatanPKPT,KodePKPT);
                String tblOld = gson.toJson(tbl);
                    tbl.setKodeUserPembuat(reg.getParameter("kodeUserPembuat"));
                    tbl.setTanggalAwal(formatter.parse(reg.getParameter("tanggalAwal")));
                    tbl.setTanggalAkhir(formatter.parse(reg.getParameter("tanggalAkhir")));
                    tbl.setNamaKegiatan(reg.getParameter("namaKegiatan"));
                    tbl.setKeteranganKegiatan(reg.getParameter("keteranganKegiatan"));
                    tbl.setJenisTransportasi(reg.getParameter("jenisTransportasi"));
                    tbl.setBiayaTransportasi(new BigDecimal((reg.getParameter("biayaTransportasi"))));
                    tbl.setBiayaLumpsum(new BigDecimal((reg.getParameter("biayaLumpsum"))));
                    tbl.setKodeKegiatanPKPT(reg.getParameter("kodeKegiatanPKPT"));
                    tbl.setBiayaMobilDinas(new BigDecimal((reg.getParameter("biayaMobilDinas"))));
                    tbl.setKodePKPT(reg.getParameter("kodePKPT"));
                    tbl.setStatusInap(reg.getParameter("statusInap"));
                    tbl.setKodeUserPembuat(user.getUserId());
                    tbl.setKodeAuditan(reg.getParameter("kodeAuditan"));
                    tbl.setKodeJenisPemeriksaan(reg.getParameter("kodeJenisPemeriksaan"));
               
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
	 @RequestMapping(value="/pasRaKegiatanPKPTDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String pasRaKegiatanPKPTDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodeKegiatanPKPT=reg.getParameter("kodeKegiatanPKPT");
                    String KodePKPT=reg.getParameter("kodePKPT");
	
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
               PasRaKegiatanPKPTDAO dao = new PasRaKegiatanPKPTDAO(sess);
               PasRaKegiatanPKPT tbl = dao.getById(KodeKegiatanPKPT,KodePKPT);
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

	@RequestMapping(value="/pasRaKegiatanPKPTReport.htm",method=RequestMethod.GET)
	 public String doGetpasRaKegiatanPKPTReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/pasRaKegiatanPKPTReport";
	}
	
	
		 @RequestMapping(value="/pasRaKegiatanPKPTDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String pasRaKegiatanPKPTDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String NamaKegiatan=reg.getParameter("NamaKegiatan");
                    String KodePKPT=reg.getParameter("KodePKPT");		 
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
			PasRaKegiatanPKPTDAO dao = new PasRaKegiatanPKPTDAO(sess);
			List<PasRaKegiatanPKPT> l = new ArrayList<PasRaKegiatanPKPT>();
				l = dao.getBy(NamaKegiatan,KodePKPT);
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
	
	
		//===============================Detail====================================================

			@RequestMapping(value="/pasRaKegiatanPKPTPersetujuanDetail.htm",method=RequestMethod.GET)
			 public String doGetpasRaKegiatanPKPTPersetujuanDetail(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
			 	super.doGet(model, session, reg,res);
			 	System.out.println("Cek.........................");
			 	return "/report/pasRaKegiatanPKPTPersetujuanDetail";
			}
			
				 @RequestMapping(value="/pasRaKegiatanPKPTDataPersetujuanDetail.htm", method=RequestMethod.GET)
		     public @ResponseBody String pasRaKegiatanPKPTPersetujuanDetail(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		                    String NamaKegiatan=reg.getParameter("NamaKegiatan");
		                    String KodePKPT=reg.getParameter("KodePKPT");		 
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
					PasRaKegiatanPKPTDAO dao = new PasRaKegiatanPKPTDAO(sess);
					List<PasRaKegiatanPKPT> l = new ArrayList<PasRaKegiatanPKPT>();
						l = dao.getBy(NamaKegiatan,KodePKPT);
					sess.close();
		            result = gson.toJson(l);
		            System.out.println("result :"+result);
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
