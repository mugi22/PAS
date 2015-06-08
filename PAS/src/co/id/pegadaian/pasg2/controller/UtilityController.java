package co.id.pegadaian.pasg2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.id.pegadaian.pasg2.dao.TblBranchDAO;
import co.id.pegadaian.pasg2.dao.TblGroupDAO;
import co.id.pegadaian.pasg2.dao.TblKabupatenDAO;
import co.id.pegadaian.pasg2.dao.TblKecamatanDAO;
import co.id.pegadaian.pasg2.dao.TblLookupDAO;
import co.id.pegadaian.pasg2.dao.TblMenuDAO;
import co.id.pegadaian.pasg2.dao.TblPasEaJenisPemeriksaanDAO;
import co.id.pegadaian.pasg2.dao.TblPasEaKantorAuditorDAO;
import co.id.pegadaian.pasg2.dao.TblPasEaKetuaTimAuditorDAO;
import co.id.pegadaian.pasg2.dao.TblPasEaTkAuditanDAO;
import co.id.pegadaian.pasg2.dao.PasEaTkKantorAuditorDAO;
import co.id.pegadaian.pasg2.dao.TblProvinsiDAO;
import co.id.pegadaian.pasg2.dao.TblUserDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblBranch;
import co.id.pegadaian.pasg2.pojo.TblGroup;
import co.id.pegadaian.pasg2.pojo.TblKabupaten;
import co.id.pegadaian.pasg2.pojo.TblKecamatan;
import co.id.pegadaian.pasg2.pojo.TblLookup;
import co.id.pegadaian.pasg2.pojo.TblMenu;
import co.id.pegadaian.pasg2.pojo.TblPasEaJenisPemeriksaan;
import co.id.pegadaian.pasg2.pojo.TblPasEaKantorAuditor;
import co.id.pegadaian.pasg2.pojo.TblPasEaKetuaTimAuditor;
import co.id.pegadaian.pasg2.pojo.PasEaTkAuditan;
import co.id.pegadaian.pasg2.pojo.PasEaTkKantorAuditor;
import co.id.pegadaian.pasg2.pojo.TblProvinsi;
import co.id.pegadaian.pasg2.pojo.TblUser;

import com.google.gson.Gson;


@Controller
public class UtilityController {

	/**
	 * untuk mengisi combobox branch keseluruhan (tanpa filter)
	 * @param model
	 * @param session
	 * @param reg
	 * @return
	 */
	
	@RequestMapping(value="/comboAllBranch.htm", method=RequestMethod.POST)
    public @ResponseBody String comboAllBranch(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		 String param =reg.getParameter("param");
		 String selectVal =reg.getParameter("selected");
//		 System.out.println("param  "+param+" selected "+selectVal);
		 Session sess = null;
		 String x="";String z ="";
		 try {
			sess = HibernateUtil.getSessionFactory().openSession();
			TblBranchDAO dao = new TblBranchDAO(sess);
			List<TblBranch> l = new ArrayList<TblBranch>();
			TblBranch branch = dao.getById(reg.getParameter("param"));
			if(param.length()>0){
				l = dao.getByParent(/*branch.getParentId()*/param);
			}
			StringBuffer sb = new StringBuffer();
					sb.append("[");
			for(TblBranch tbl : l){
				String selected="";
				if(param.length()>0){
					if (tbl.getBranchCode().equals(selectVal)){
						selected = ","+'"'+"selected"+'"'+":true";
					}else{
						selected="";
					}
				}
				String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getBranchCode()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getBranchCode()+" - "+tbl.getName()+'"'+selected+"},";	
				sb.append(item);
			}
			x = (sb.toString()).substring(0,sb.toString().length()-1);
			 z = x+"]";
			 if (z.equals("]") )z="[]";
			 sess.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 System.out.println(z);
	 return z;
	 }
	
	
	
	
	@RequestMapping(value="/comboAllKanwil.htm", method=RequestMethod.POST)
    public @ResponseBody String comboAllKanwil(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		 String param =reg.getParameter("param");
		 Session sess = null;
		 String x="";String z ="";
		 try {
			sess = HibernateUtil.getSessionFactory().openSession();
			TblBranchDAO dao = new TblBranchDAO(sess);
			List<TblBranch> l = new ArrayList<TblBranch>();
				l = dao.getByParent("00002");
			StringBuffer sb = new StringBuffer();
					sb.append("[");
			for(TblBranch tbl : l){
				String selected="";
				if(param.length()>0){
					if (tbl.getBranchCode().equals(reg.getParameter("param"))){
						selected = ","+'"'+"selected"+'"'+":true";
					}else{
						selected="";
					}
				}else{//untuk tambah -> set default combobox nya 0002
					if(tbl.getBranchCode().equals("00002")){
						selected = ","+'"'+"selected"+'"'+":true";
					}
				}
				String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getBranchCode()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getBranchCode()+" - "+tbl.getName()+'"'+selected+"},";	
				sb.append(item);
			}
			x = (sb.toString()).substring(0,sb.toString().length()-1);
			 z = x+"]";
			 if (z.equals("]") )z="[]";
			 sess.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 System.out.println(z);
	 return z;
	 }
	 
	 
//******************provinsi************************
	 @RequestMapping(value="/comboProvinsi.htm", method=RequestMethod.POST)
	    public @ResponseBody String provinsi(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
			 String param =reg.getParameter("param");
			 Session sess = null;
			 String x="";String z ="";
			 try {
				sess = HibernateUtil.getSessionFactory().openSession();
				TblProvinsiDAO dao = new TblProvinsiDAO(sess);
				List<TblProvinsi> l = dao.getAll();
				StringBuffer sb = new StringBuffer();
						sb.append("[");
				for(TblProvinsi tbl : l){
					String selected="";
					if(param.length()>0){
						if (tbl.getKodeProvinsi().equals(reg.getParameter("param"))){
							selected = ","+'"'+"selected"+'"'+":true";
						}else{
							selected="";
						}
					}else{//untuk tambah -> set default combobox nya 0002
						if(tbl.getKodeProvinsi().equals("00")){
							selected = ","+'"'+"selected"+'"'+":true";
						}
					}
					String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getKodeProvinsi()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getKodeProvinsi()+" - "+tbl.getNamaProvinsi()+'"'+selected+"},";	
					sb.append(item);
				}
				x = (sb.toString()).substring(0,sb.toString().length()-1);
				 z = x+"]";
				 if (z.equals("]") )z="[]";
				 sess.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return z;
		 }
	 
//	 KABUPATEN BY PROVINSI
	//******************Kabupaten************************
		 @RequestMapping(value="/comboKabupatenByProvinsi.htm", method=RequestMethod.POST)
		    public @ResponseBody String kabupatenByProvinsi(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
				 String param =reg.getParameter("param");
				 String param2 =reg.getParameter("param2");
//				 System.out.println("param   =============  > "+param+" param2   =============  > "+param2);
				 Session sess = null;
				 String x="";String z ="";
				 try {
					sess = HibernateUtil.getSessionFactory().openSession();
					TblKabupatenDAO dao = new TblKabupatenDAO(sess);
					List<TblKabupaten> l = dao.getByProvinsi(param);
					StringBuffer sb = new StringBuffer();
							sb.append("[");
							String selected="";
					for(TblKabupaten tbl : l){
						
						if(param.length()>0){
							if (tbl.getKodeKabupaten()/*getKodeProvinsi()*/.equals(reg.getParameter("param2"))){
								selected = ","+'"'+"selected"+'"'+":true";
							}else{
								selected="";
							}
						}else{//untuk tambah -> set default combobox nya 0002
							if(tbl.getKodeKabupaten()/*getKodeProvinsi()*/.equals("00")){
								selected = ","+'"'+"selected"+'"'+":true";
							}
						}
						String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getKodeKabupaten()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getKodeKabupaten()+" - "+tbl.getNamaKabupaten()+'"'+selected+"},";	
						sb.append(item);
					}
					x = (sb.toString()).substring(0,sb.toString().length()-1);
					 z = x+"]";
					 if (z.equals("]") )z="[]";
					 sess.close();
					 System.out.println("kabupaten by propinsi "+z);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 return z;
			 }
	 
//ambil kode provinsi berdasarkan kode kabupaten	
	@RequestMapping(value="/getKodeKabupaten.htm", method=RequestMethod.GET)
    public @ResponseBody String getKodeKabupaten(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		 String param =reg.getParameter("param");
		 Session sess = null;
		 String x="";String z ="";
		 TblKabupaten tblKabupaten = null;
		 try {
			sess = HibernateUtil.getSessionFactory().openSession();
			TblKabupatenDAO kabupatenDAO = new TblKabupatenDAO(sess);
			List<TblKabupaten> kabupaten = kabupatenDAO.getBy("", param, "");//pake yang ada
			
			for(TblKabupaten tbl : kabupaten){
//				System.out.println("kode kabupaten "+tbl.getKodeKabupaten()+" "+tbl.getNamaKabupaten());
				tblKabupaten=tbl;
			}
			
		 } catch(Exception e){
			 e.printStackTrace();
		 }
		 Gson gson = new Gson();
		 System.out.println(gson.toJson(tblKabupaten));
	 return gson.toJson(tblKabupaten);
	 }
		 

	
//	 KECAMATAN BY KABUPATEN
	//******************kecmatan************************
		 @RequestMapping(value="/comboKecamatanByKabupaten.htm", method=RequestMethod.POST)
		    public @ResponseBody String KecamatanByKabupaten(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
				 String param =reg.getParameter("param");
				 String param2 =reg.getParameter("param2");
				 System.out.println("comboKecamatanByKabupaten   param   =============  > "+param+" param2   =============  > "+param2);
				 Session sess = null;
				 String x="";String z ="";
				 try {
					sess = HibernateUtil.getSessionFactory().openSession();
					TblKecamatanDAO dao = new TblKecamatanDAO(sess);
					List<TblKecamatan> l = dao.getByKabupaten(param);
					StringBuffer sb = new StringBuffer();
							sb.append("[");
							String selected="";
					for(TblKecamatan tbl : l){
						
						if(param.length()>0){
							if (tbl.getKodeKecamatan().equals(reg.getParameter("param2"))){
								//selected = ","+'"'+"selected"+'"'+":true";
							}else{
								//selected="";
							}
						}else{//untuk tambah -> set default combobox nya 0002
							if(tbl.getKodeKecamatan()/*getKodeProvinsi()*/.equals("0")){
								//selected = ","+'"'+"selected"+'"'+":true";
							}
						}
						String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getKodeKecamatan()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getKodeKecamatan()+" - "+tbl.getNamaKecamatan()+'"'+selected+"},";	
						sb.append(item);
					}
					x = (sb.toString()).substring(0,sb.toString().length()-1);
					 
					 z = x+"]";
					 if (z.equals("]") )z="[]";
					 sess.close();
					
					//System.out.println("selected "+selected);
					 System.out.println("xxxxx "+z);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 return z;
			 }	
	
	
	
		//ambil kode kabupaten berdasarkan kode tang ada di kecamatan	
			@RequestMapping(value="/getKodeKecamatan.htm", method=RequestMethod.GET)
		    public @ResponseBody String getKodeKecamatan(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
				 String param =reg.getParameter("param");
				 Session sess = null;
				 String x="";String z ="";
				 TblKecamatan tblKecamatan = null;
				 try {
					sess = HibernateUtil.getSessionFactory().openSession();
					TblKecamatanDAO kecamatanDAO = new TblKecamatanDAO(sess);
					List<TblKecamatan> kecamatan = kecamatanDAO.getBy("","" ,param);
					
					for(TblKecamatan tbl : kecamatan){
//						System.out.println("kode kabupaten "+tbl.getKodeKabupaten()+" "+tbl.getNamaKabupaten());
						tblKecamatan=tbl;
					}
					
				 } catch(Exception e){
					 e.printStackTrace();
				 }
				 Gson gson = new Gson();
				 System.out.println(gson.toJson(tblKecamatan));
			 return gson.toJson(tblKecamatan);
			 }	
	
	
//	===================
			//******************PasEaKantorAuditor************************
			 @RequestMapping(value="/comboPasEaKantorAuditorByTk.htm", method=RequestMethod.POST)
			    public @ResponseBody String PasEaKantorAuditorByTk(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
					 String param =reg.getParameter("param");
					 String param2 =reg.getParameter("param2");
					 System.out.println("param2..................... "+param2);
					 Session sess = null;
					 String x="";String z ="";
					 try {
						sess = HibernateUtil.getSessionFactory().openSession();
						TblPasEaKantorAuditorDAO dao = new TblPasEaKantorAuditorDAO(sess);
						List<TblPasEaKantorAuditor> l = dao.getByKodeTk(param);
						StringBuffer sb = new StringBuffer();
								sb.append("[");
						for(TblPasEaKantorAuditor tbl : l){
							String selected="";
							if(param.length()>0){
								if (tbl.getKodeKantor().equals(reg.getParameter("param2"))){
									selected = ","+'"'+"selected"+'"'+":true";
								}else{
									selected="";
								}
							}else{//untuk tambah -> set default combobox nya 0002
								if(tbl.getKodeKantor().equals("00")){
									selected = ","+'"'+"selected"+'"'+":true";
								}
							}
							String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getKodeKantor()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getKodeKantor()+" - "+tbl.getNama()+'"'+selected+"},";	
							sb.append(item);
						}
						x = (sb.toString()).substring(0,sb.toString().length()-1);
						 z = x+"]";
						 if (z.equals("]") )z="[]";
						 sess.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				 return z;
				 }
			 
//	=============ambil TblPasEaKantorAudiror berdasarkan kodekantor=========================
				@RequestMapping(value="/getPasEaKantorAuditor.htm", method=RequestMethod.GET)
			    public @ResponseBody String getPasEaKantorAuditor(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
					 String param =reg.getParameter("param");
					 Session sess = null;
					 String x="";String z ="";
					 TblPasEaKantorAuditor tblPasEaKantorAuditor = null;
					 try {
						sess = HibernateUtil.getSessionFactory().openSession();
						TblPasEaKantorAuditorDAO pasEaKantorAuditor = new TblPasEaKantorAuditorDAO(sess);
						 tblPasEaKantorAuditor = pasEaKantorAuditor.getById(param);
						
//						for(TblPasEaKantorAuditor tbl : l){
////							System.out.println("kode kabupaten "+tbl.getKodeKabupaten()+" "+tbl.getNamaKabupaten());
//							tblPasEaKantorAuditor=tbl;
//						}
						
					 } catch(Exception e){
						 e.printStackTrace();
					 }
					 Gson gson = new Gson();
					 System.out.println("tblPasEaKantorAuditor "+gson.toJson(tblPasEaKantorAuditor));
				 return gson.toJson(tblPasEaKantorAuditor);
				 }	
			 
	
	
			
			
			
			
			
			
			
			
			
			
	
		 
//		 
//	 
//	 /**
//	  * Meng Clear kan table hasil /result
//	  * @param model
//	  * @param session
//	  * @param reg
//	  * @return
//	  */
	 //	CLEAR TABLE
	 @RequestMapping(value="/listClear.htm", method=RequestMethod.POST)
     public @ResponseBody String userClear(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		 String sClear ="{"+'"'+"total"+'"'+":"+"0"+","+'"'+"rows"+'"'+":"+"[]}";
//		 {"total":0,"rows":[]}
		 return sClear;
	 }
//	 
//	 
//	 
//	 @RequestMapping(value="/cariUser.htm", method=RequestMethod.GET)
//	 public String cariUser(){
//		 return "cariUser";
//	 }
//	 
//	 
////comboLookup
	 @RequestMapping(value="/comboLookup.htm", method=RequestMethod.POST)
	    public @ResponseBody String comboStatusPeg(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
			 String param =reg.getParameter("param");
			 String param2 =reg.getParameter("param2");
//			 System.out.println("param2 xx : "+param2);
			 Session sess = null;
			 String x="";String z ="";
			 try {
				sess = HibernateUtil.getSessionFactory().openSession();
				TblLookupDAO dao = new TblLookupDAO(sess);
				List<TblLookup> l = dao.getBy(param2);
				StringBuffer sb = new StringBuffer();
						sb.append("[");
				for(TblLookup tbl : l){
					String selected="";
					if(param.length()>0){
						if (tbl.getLookupName().equals(reg.getParameter("param2"))){
							selected = ","+'"'+"selected"+'"'+":true";
						}else{
							selected="";
						}
					}else{//untuk tambah -> set default combobox nya 0002
						if(tbl.getLookupName().equals("00")){
							selected = ","+'"'+"selected"+'"'+":true";
						}
					}
					String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getLookupValue()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getLookupValue()+" - "+tbl.getLookupLabel()+'"'+selected+"},";	
					sb.append(item);
				}
				x = (sb.toString()).substring(0,sb.toString().length()-1);
				 z = x+"]";
				 sess.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return z;
		 }
		 
//	 group
	 @RequestMapping(value="/comboGroup.htm", method=RequestMethod.POST)
	  public @ResponseBody String comboGroup(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
			 String param =reg.getParameter("param");
			 Session sess = null;
			 String x="";String z ="";
			 try {
				sess = HibernateUtil.getSessionFactory().openSession();
				TblGroupDAO dao = new TblGroupDAO(sess);
				List<TblGroup> l = dao.getAll();//getBy(param2);
				StringBuffer sb = new StringBuffer();
						sb.append("[");
				for(TblGroup tbl : l){
					String selected="";
					if(param.length()>0){
						if (tbl.getGroupId().equals(reg.getParameter("param"))){
							selected = ","+'"'+"selected"+'"'+":true";
						}else{
							selected="";
						}
					}else{//untuk tambah -> set default combobox nya 0002
						if(tbl.getGroupId().equals("00002")){
							selected = ","+'"'+"selected"+'"'+":true";
						}
					}
					String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getGroupId()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getGroupId()+" - "+tbl.getGroupName()+'"'+selected+"},";	
					sb.append(item);
				}
				x = (sb.toString()).substring(0,sb.toString().length()-1);
				 z = x+"]";
				 if (z.equals("]") )z="[]";
				 sess.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 System.out.println(z);
		 return z;
		 }

	 
//MENU
	 @RequestMapping(value="/comboMenu.htm", method=RequestMethod.POST)
	  public @ResponseBody String comboMenu(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
			 String param =reg.getParameter("param");
			 Session sess = null;
			 String x="";String z ="";
			 try {
				sess = HibernateUtil.getSessionFactory().openSession();
				TblMenuDAO dao = new TblMenuDAO(sess);
				List<TblMenu> l = dao.getAll();//getBy(param2);
				StringBuffer sb = new StringBuffer();
						sb.append("[");
				for(TblMenu tbl : l){
					String selected="";
					if(param.length()>0){
						if (tbl.getMenuId().equals(reg.getParameter("param"))){
							selected = ","+'"'+"selected"+'"'+":true";
						}else{
							selected="";
						}
					}else{//untuk tambah -> set default combobox nya 0002
//						if(tbl.getMenuId().equals("00002")){
//							selected = ","+'"'+"selected"+'"'+":true";
//						}
					}
					String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getMenuId()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getMenuId()+" - "+tbl.getMenuName()+'"'+selected+"},";	
					sb.append(item);
				}
				x = (sb.toString()).substring(0,sb.toString().length()-1);
				 z = x+"]";
				 if (z.equals("]") )z="[]";
				 sess.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 System.out.println("menu : "+z);
		 return z;
		 }

	 	 	 
	 
	 
	 
//	 
///*
// * 	 
// */
//	 @RequestMapping(value="/sessionExpire.htm", method=RequestMethod.GET)
//	  public  String sessionExpire(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//		 //session.invalidate();
//		 return "sessionExpire";
//	 }
//	 
//	 @RequestMapping(value="/getParent.htm", method=RequestMethod.GET)
//	 public @ResponseBody String getParent(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//		 String kdUnit = reg.getParameter("kodeUnit");
//		 System.out.println("getParent..............................................     "+kdUnit);
//		 Session sess = HibernateUtil.getSessionFactory().openSession();
//		 TblBranchDAO branchDAO = new TblBranchDAO(sess);
//		 TblBranch branch = branchDAO.getById(kdUnit);
//		 sess.close();
//	 	return branch.getParentId();
//	 }
//	 
//	 
//	 
//	 @RequestMapping(value="/cekUserBaranch.htm", method=RequestMethod.GET)
//	 public @ResponseBody String cekUserBaranch(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//		 String userId = reg.getParameter("nik");
//		 String sUID =  reg.getParameter("UID");
//		 System.out.println("userId..............................................     "+userId+" sUID "+sUID);
//		 String message ="";
//		 String a="";
//		 try {
//			 Session sess = HibernateUtil.getSessionFactory().openSession();
//			 TblUserDAO tblUserDAO = new TblUserDAO(sess);
//			 TblUser tblUser = tblUserDAO.getById(userId);
//			 if(tblUser.getUserId().length()<1){
//				 sess.close();
//				 return "{}";
//			 }
//			 //cek tblUser mempunyai unit yang sama dengan user penginput (UID)
//			 TblUser tblUserInput = tblUserDAO.getById(sUID);
//			 
//			 if(tblUser.getBranchCode().equals(tblUserInput.getBranchCode())){
//				 System.out.println("ADA........................");
//				 Gson gson = new  Gson();
//				 message = gson.toJson(tblUser);
//				 /** * tambhakan nama branc  */
//				 TblBranchDAO branchDAO = new TblBranchDAO(sess);
//				 TblBranch branch = branchDAO.getById(tblUser.getBranchCode());
//				 a = message.replace("}", ","+'"'+"branchName"+'"'+":"+'"'+branch.getName()+'"'+"}");
//		
//			 }else{
//				 //message="User Tidak Ada Untuk Unit ......."+tblUserInput.getBranchCode();
//				 a="{}";
//				 System.out.println("TIDAK.......................................");
//			 }
//			 		sess.close();
//			 
//	            /**  BILA ADA PERUBAHAN DATA JSON
//	             * String a = s.replace("}", ","+'"'+"groupName"+'"'+":"+'"'+group.getGroupName()+'"'+","+'"'+"menuName"+'"'+":"+'"'+menu.getMenuName()+'"'+"},");
////		
//	            String x = changeJson(h, sess);
//	            sess.close();
//	        	result ="{"+'"'+"total"+'"'+":"+h.get("total")+","+'"'+"rows"+'"'+":["+x+']'+'}';
//	            */
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		System.out.println(a);
//	 	return a;//;branch.getParentId();
//	 }
//	 
//	 @RequestMapping(value="/cekRekening.htm", method=RequestMethod.GET)
//	 public @ResponseBody String cekRekening(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
//		 String norek = reg.getParameter("norek");
//		 String sUID =  reg.getParameter("UID");
//		 
//		 String rek = null;
//		 Session sess = null;
//		 try {
//			sess = HibernateUtil.getSessionFactory().openSession();
//			TblRekeningIADAO rekeningIADAO = new TblRekeningIADAO(sess);
//			TblRekeningIA ia = rekeningIADAO.getById(norek);
//			if(ia.getNorek().length()>0){
//				rek = new Gson().toJson(ia);
//			}else{
//				rek="{}";
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		 System.out.println("norek  "+norek);
//		 sess.close();
//		 System.out.println("rek "+rek);
//		 return rek;
//	 }
//	 
//	 //Ambil Branch berdasarkan ID
//	 
//	 @RequestMapping(value="/getBranchByID.htm", method=RequestMethod.GET)
//	 public @ResponseBody String getBranchByID(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
////		 String sUID =  reg.getParameter("UID");
//		 String branchCode = reg.getParameter("branchCode");
//		 Session sess = null;
//		 String sBranch="";
//		 try {
//			 sess = HibernateUtil.getSessionFactory().openSession();
//			 TblBranchDAO branchDAO = new TblBranchDAO(sess);
//			 TblBranch branch = branchDAO.getById(branchCode);
//			 if(branch.getName().length()> 0){
//				 Gson gson = new Gson();
//				 sBranch = gson.toJson(branch);
//			 }else{
//				 sBranch="{}";
//			 }
//			sess.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		 System.out.println(sBranch);
//		return sBranch;
//	 }
	 
	 
//// EA TK KANTOR AUDITOR
 @RequestMapping(value="/comboEaTkKantorAuditor.htm", method=RequestMethod.POST)
  public @ResponseBody String comboTkKantorAuditor(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		 String param =reg.getParameter("param");
		 System.out.println("PARAM ************** "+param);
		 Session sess = null;
		 String x="";String z ="";
		 try {
			sess = HibernateUtil.getSessionFactory().openSession();
			PasEaTkKantorAuditorDAO dao = new PasEaTkKantorAuditorDAO(sess);
			List<PasEaTkKantorAuditor> l = dao.getAll();//getBy(param2);
			StringBuffer sb = new StringBuffer();
					sb.append("[");
			for(PasEaTkKantorAuditor tbl : l){
				String selected="";
				if(param.length()>0){
					if (tbl.getKodeTk().equals(reg.getParameter("param"))){
						selected = ","+'"'+"selected"+'"'+":true";
					}else{
						selected="";
					}
				}else{//untuk tambah -> set default combobox nya 0002
//					if(tbl.getKodeTk().equals("00")){
//						selected = ","+'"'+"selected"+'"'+":true";
//					}
				}
				String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getKodeTk()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getNamaTk()+'"'+selected+"},";	
				sb.append(item);
			}
			x = (sb.toString()).substring(0,sb.toString().length()-1);
			 z = x+"]";
			 sess.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return z;
	 }
 
 //-----------------
////EA TINGKAT AUDITAN
@RequestMapping(value="/comboEaTkAuditon.htm", method=RequestMethod.POST)
public @ResponseBody String comboEaTkAuditon(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
	 String param =reg.getParameter("param");
	 System.out.println("PARAM ************** "+param);
	 Session sess = null;
	 String x="";String z ="";
	 try {
		sess = HibernateUtil.getSessionFactory().openSession();
		TblPasEaTkAuditanDAO dao = new TblPasEaTkAuditanDAO(sess);
		List<PasEaTkAuditan> l = dao.getAll();//getBy(param2);
		StringBuffer sb = new StringBuffer();
				sb.append("[");
		for(PasEaTkAuditan tbl : l){
			String selected="";
			if(param.length()>0){
				if (tbl.getKodeTkAuditan().equals(reg.getParameter("param"))){
					selected = ","+'"'+"selected"+'"'+":true";
				}else{
					selected="";
				}
			}else{//untuk tambah -> set default combobox nya 0002
//				if(tbl.getKodeTk().equals("00")){
//					selected = ","+'"'+"selected"+'"'+":true";
//				}
			}
			String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getKodeTkAuditan()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getNamaTkAuditan()+'"'+selected+"},";	
			sb.append(item);
		}
		x = (sb.toString()).substring(0,sb.toString().length()-1);
		 z = x+"]";
		 sess.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
 return z;
 }
 
 //------------
// USER BY BRANCH CODE
@RequestMapping(value="/comboUserBranch.htm", method=RequestMethod.POST)
public @ResponseBody String comboUserBranch(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
	 String param =reg.getParameter("param");
	 String param2 =reg.getParameter("param2");
	 System.out.println("PARAM *****comboUserBranch********* "+param);
	 Session sess = null;
	 String x="";String z ="";
	 try {
		sess = HibernateUtil.getSessionFactory().openSession();
		TblUserDAO dao = new TblUserDAO(sess);
		List<TblUser> l = dao.getByBranch(param);//getBy(param2);
		StringBuffer sb = new StringBuffer();
				sb.append("[");
		for(TblUser tbl : l){
			String selected="";
			if(param.length()>0){
				if (tbl.getUserId().equals(reg.getParameter("param2"))){
					selected = ","+'"'+"selected"+'"'+":true";
				}else{
					selected="";
				}
			}else{//untuk tambah -> set default combobox nya 0002
//				if(tbl.getKodeTk().equals("00")){
//					selected = ","+'"'+"selected"+'"'+":true";
//				}
			}
			String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getUserId()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getUserId()+" - "+tbl.getName()+'"'+selected+"},";	
			sb.append(item);
		}
		x = (sb.toString()).substring(0,sb.toString().length()-1);
		 z = x+"]";
		 if(z.equals("]")) z="[]";
		 System.out.println("zzzz   ==== "+z);
		 sess.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
 return z;
 } 


//Ketua tim auditor BY BRANCH CODE
@RequestMapping(value="/comboKetuaTimAuditor.htm", method=RequestMethod.GET)
public @ResponseBody String comboKetuaTimAuditor(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
	 String param =reg.getParameter("param");
	 System.out.println("PARAM ************** "+param);
	 Session sess = null;
	 String x="";String z ="";
	 try {
		sess = HibernateUtil.getSessionFactory().openSession();
		TblPasEaKetuaTimAuditorDAO dao = new TblPasEaKetuaTimAuditorDAO(sess);
		TblPasEaKetuaTimAuditor tbl = dao.getByBranch(param);//getBy(param2);
		if(tbl.getKodeKantorAuditor().length()>0){
			z= tbl.getKodeUserKetuaTimAuditor();
		}
		
		 sess.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
return z;
} 


////EaJenisPemeriksaan
@RequestMapping(value="/comboEaJenisPemeriksaan.htm", method=RequestMethod.POST)
public @ResponseBody String comboEaJenisPemeriksaan(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
	 String param =reg.getParameter("param");
	 System.out.println("PARAM ************** "+param);
	 Session sess = null;
	 String x="";String z ="";
	 try {
		sess = HibernateUtil.getSessionFactory().openSession();
		TblPasEaJenisPemeriksaanDAO dao = new TblPasEaJenisPemeriksaanDAO(sess);
		List<TblPasEaJenisPemeriksaan> l = dao.getAll();//getBy(param2);
		StringBuffer sb = new StringBuffer();
				sb.append("[");
		for(TblPasEaJenisPemeriksaan tbl : l){
			String selected="";
			if(param.length()>0){
				if (tbl.getKodeJenisPemeriksaan().equals(reg.getParameter("param"))){
					selected = ","+'"'+"selected"+'"'+":true";
				}else{
					selected="";
				}
			}else{//untuk tambah -> set default combobox nya 0002
//				if(tbl.getKodeTk().equals("00")){
//					selected = ","+'"'+"selected"+'"'+":true";
//				}
			}
			String item = "{"+'"'+"id"+'"'+":"+'"'+tbl.getKodeJenisPemeriksaan()+'"'+","+'"'+"text"+'"'+":"+'"'+tbl.getKodeJenisPemeriksaan()+" - "+tbl.getNamaJenisPemeriksaan()+'"'+selected+"},";	
			sb.append(item);
		}
		x = (sb.toString()).substring(0,sb.toString().length()-1);
		 z = x+"]";
		 sess.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
return z;
}





	 
}
