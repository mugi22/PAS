/*
*Create by CodeGenerator
*controllerTemplate
*M U G I
*/

package co.id.pegadaian.pasg2.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import co.id.pegadaian.pasg2.util.AbstractListScreen;
import co.id.pegadaian.pasg2.util.Constants;

import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.PasEaPPL;
import co.id.pegadaian.pasg2.pojo.TblAppProperties;
import co.id.pegadaian.pasg2.pojo.TblParam;
import co.id.pegadaian.pasg2.pojo.TblUser;
import co.id.pegadaian.pasg2.pojo.PasEaPPLUser;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.PasEaPPLDAO;
import co.id.pegadaian.pasg2.dao.PasEaPPLUserDAO;
import co.id.pegadaian.pasg2.dao.TblAppPropertiesDAO;
import co.id.pegadaian.pasg2.dao.TblParamDAO;
import co.id.pegadaian.pasg2.dao.TblUserDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasEaPPLUserController  extends AbstractListScreen{
	@RequestMapping(value="/pasEaPPLUser.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/pasEaPPLUser.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasEaPPLUser";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/pasEaPPLUserListAll.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaPPLUserListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodePPLUSer=reg.getParameter("KodePPLUSer");
                    String PenyelenggaraPPL=reg.getParameter("PenyelenggaraPPL");
                    String KodeUser=reg.getParameter("KodeUser");		 
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
			PasEaPPLUserDAO dao = new PasEaPPLUserDAO(sess);
			Map h = new HashMap<String, Object>();
			List<PasEaPPLUser> l = new ArrayList<PasEaPPLUser>();
				h = dao.getByPerPage(KodePPLUSer,PenyelenggaraPPL,KodeUser,loffset, row);
//			sess.close();
            result = gson.toJson(h);
            System.out.println(result);
            
            /**  BILA ADA PERUBAHAN DATA JSON*/
            String x = changeJson(h, sess);
            sess.close();
        	result ="{"+'"'+"total"+'"'+":"+h.get("total")+","+'"'+"rows"+'"'+":["+x+']'+'}';
		} catch (Exception e) {
			// TODO: handle exception
			if(sess != null && sess.isOpen()) sess.close();
			e.printStackTrace();
		}         
         return result;
     }

// *********************ADD***********************
 @RequestMapping(value="/pasEaPPLUserAdd.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaPPLUserAdd(Map<String, Object> model,HttpSession session,HttpServletRequest reg,@RequestParam("file") MultipartFile file) {
		String userId = reg.getParameter("userId");
         //String ses = (String) session.getAttribute("session"+userId);
         TblUser user = (TblUser) session.getAttribute("user"+userId);
         String fileName = reg.getParameter("namaFileBuktiPPL");
         if(!cekValidSession(session,userId)){
        	 return "fail";
         }
         
         Session sess = null;
         String x ="";
         Map h = new HashMap<String, Object>();
         Gson gson = new Gson();
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         String sCurentmilis = System.currentTimeMillis()+"";
         String dirFolder = "";
         try {
               sess = HibernateUtil.getSessionFactory().openSession();
               PasEaPPLUserDAO dao = new PasEaPPLUserDAO(sess);
               PasEaPPLUser tbl = new PasEaPPLUser();
                    tbl.setKodePPLUSer(reg.getParameter("kodePPLUSer"));
                    tbl.setPenyelenggaraPPL(reg.getParameter("penyelenggaraPPL"));
                    tbl.setTglAkhirPPL(formatter.parse(reg.getParameter("tglAkhirPPL")));

                    tbl.setKodeUser(reg.getParameter("kodeUser"));
                    tbl.setTglAwalPPL(formatter.parse(reg.getParameter("tglAwalPPL")));
                    tbl.setLamaPPL(Long.parseLong((reg.getParameter("lamaPPL"))));
                    tbl.setNilai(new BigDecimal((reg.getParameter("nilai"))));
                             
               tbl.setCreateBy(user.getUserId());
               tbl.setCreateDate(new Date());
               
               sess.beginTransaction();
               
//             ----------UPLOAD FILE
         	  String z ="";
         	  
              if (!file.isEmpty()) {
       	           // try {
            	 TblParamDAO paramDAO = new TblParamDAO(sess);
            	 TblParam properties = paramDAO.getById("DIR_PPL_USER");
            	 dirFolder = properties.getValue()+"\\";
            	//String dirFolder = "";
       	                byte[] bytes = file.getBytes();
       	                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(/*Constants.SysParam.DownloadFolder*/
       	                		dirFolder+sCurentmilis+"_"+file.getOriginalFilename()/*fileName+"."+z*/)));
       	                stream.write(bytes);
       	                stream.close();
       	                System.out.println( "You successfully uploaded " + fileName + "!");
       	                //kalao file di ganti rubah nama file yang di TABEL
       	                tbl.setNamaFileBuktiPPL(file.getOriginalFilename());//(reg.getParameter("namaFileBuktiPPL"));
       	                tbl.setFileBuktiPPL(sCurentmilis+"_"+file.getOriginalFilename());//(reg.getParameter("fileBuktiPPL"));
       	        } else {
       	            System.out.println("You failed to upload " + fileName + " because the file was empty.");
       	            //jika gagal data hatap dihapus
       	           
       	        }
//              --------------------END UPLOAD
               
               dao.insert(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl),"ADD",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               
               sess.close();
               x=gson.toJson("SUKSES");
         }catch(Exception e){
        	 if(sess != null && sess.isOpen()) sess.close();
        	 //HAPUS fILE YANG SUDAH TERBENTU
        	 
        	 File f = new File(dirFolder+sCurentmilis+"_"+file.getOriginalFilename());
	            boolean success = f.delete();
    	         if (success) {
    	            System.out.println("The file has been successfully deleted"); 
    	         }
             x=gson.toJson("fail");
             e.printStackTrace();
         }
         return x;
 	 }

//**************************************EDIT*************************************
//	 EDIT	 
	 @RequestMapping(value="/pasEaPPLUserEdit.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaPPLUserEdit(Map<String, Object> model,HttpSession session,HttpServletRequest reg,@RequestParam("file") MultipartFile file) {
                    String KodePPLUSer=reg.getParameter("kodePPLUSer");
                    String KodeUser=reg.getParameter("kodeUser");
		 
		String userId = reg.getParameter("userId");
         TblUser user = (TblUser) session.getAttribute("user"+userId);
         String fileName = reg.getParameter("namaFileBuktiPPL");
         if(!cekValidSession(session,userId)){        	 
         	return "fail";
         }
         Session sess = null;
         String x ="";
         Map h = new HashMap<String, Object>();
         Gson gson = new Gson();
       String dirFolder = "";
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
         String sCurentmilis = System.currentTimeMillis()+"";
         try {
               sess = HibernateUtil.getSessionFactory().openSession();
               PasEaPPLUserDAO dao = new PasEaPPLUserDAO(sess);
               PasEaPPLUser tbl = dao.getById(KodePPLUSer,KodeUser);
               String oldFileName = tbl.getFileBuktiPPL();
                String tblOld = gson.toJson(tbl);
                    tbl.setKodePPLUSer(reg.getParameter("kodePPLUSer"));
                    tbl.setPenyelenggaraPPL(reg.getParameter("penyelenggaraPPL"));
                    tbl.setTglAkhirPPL(formatter.parse(reg.getParameter("tglAkhirPPL")));
//                    tbl.setNamaFileBuktiPPL(file.getOriginalFilename());//(reg.getParameter("namaFileBuktiPPL"));
//                    tbl.setFileBuktiPPL(sCurentmilis+"_"+file.getOriginalFilename());//(reg.getParameter("fileBuktiPPL"));
                    tbl.setKodeUser(reg.getParameter("kodeUser"));
                    tbl.setTglAwalPPL(formatter.parse(reg.getParameter("tglAwalPPL")));
                    tbl.setLamaPPL(Long.parseLong((reg.getParameter("lamaPPL"))));
                    tbl.setNilai(new BigDecimal((reg.getParameter("nilai"))));
               
               tbl.setUpdateBy(user.getUserId());
               tbl.setUpdateDate(new Date());
               sess.beginTransaction();
               
//             ----------UPLOAD FILE
         	  String z ="";
              if (!file.isEmpty()) {
            	  TblParamDAO paramDAO = new TblParamDAO(sess);
             	 TblParam properties = paramDAO.getById("DIR_PPL_USER");
             	 dirFolder = properties.getValue()+"\\";
             	//String dirFolder = "";
       	                byte[] bytes = file.getBytes();
       	                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(dirFolder+sCurentmilis+"_"+file.getOriginalFilename()/*fileName+"."+z*/)));
       	                stream.write(bytes);
       	                stream.close();
       	                System.out.println( "You successfully uploaded " + fileName + "!");
       	                //kalao file di ganti rubah nama file yang di TABEL
       	                tbl.setNamaFileBuktiPPL(file.getOriginalFilename());//(reg.getParameter("namaFileBuktiPPL"));
       	                tbl.setFileBuktiPPL(sCurentmilis+"_"+file.getOriginalFilename());//(reg.getParameter("fileBuktiPPL"));
       	                //file yang lama di pindahkan ke folder rename
       	                File fileOri = new File(dirFolder+oldFileName);
       	                File fileRename = new File(dirFolder+"rename\\"+oldFileName);
		       		      if(fileOri.renameTo(fileRename)) {
		       		         System.out.println("renamed");
		       		      } else {
		       		         System.out.println("Error");
		       		      }
		       		    System.out.println(dirFolder+oldFileName);
       	        } else {
       	            System.out.println("You failed to upload " + fileName + " because the file was empty.");
       	            //jika gagal data hatap dihapus
       	        }
       	 
//              --------------------END UPLOAD
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
	 @RequestMapping(value="/pasEaPPLUserDelete.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaPPLUserDelete(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodePPLUSer=reg.getParameter("kodePPLUSer");
                    String KodeUser=reg.getParameter("kodeUser");
	
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
       String dirFolder = "";
         try {
               sess = HibernateUtil.getSessionFactory().openSession();
               PasEaPPLUserDAO dao = new PasEaPPLUserDAO(sess);
               PasEaPPLUser tbl = dao.getById(KodePPLUSer,KodeUser);
               String oldFileName = tbl.getFileBuktiPPL();
               String tblDel = gson.toJson(tbl);
               sess.beginTransaction();
               dao.delete(tbl);
               simpanLog(user.getUserId(),gson.toJson(tbl),"DELETE",sess,tbl.getClass().getName());
               sess.getTransaction().commit();
               //bila data berhasil di hapus pindahkan file ke folder delete
               TblParamDAO paramDAO = new TblParamDAO(sess);
           	 TblParam properties = paramDAO.getById("DIR_PPL_USER");
           	 dirFolder = properties.getValue()+"\\";
           	//String dirFolder = "";
               File fileOri = new File(dirFolder+oldFileName);
	                File fileRename = new File(dirFolder+"delete\\"+oldFileName);
      		      if(fileOri.renameTo(fileRename)) {
      		         System.out.println("renamed");
      		      } else {
      		         System.out.println("Error");
      		      }
               
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
		public String changeJson(Map<String,Object> result, Session sess){//nemabhakan field nama group dan nama menu
			List<PasEaPPLUser> list = (List<PasEaPPLUser>) result.get("rows");
//			List<TblPriviledge> priv = (List<TblPriviledge>) h.get("rows");
			Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
			StringBuffer sb = new StringBuffer();
			for(PasEaPPLUser pr : list){
				String s = gson.toJson(pr);			
				TblUserDAO daox = new TblUserDAO(sess);
				TblUser tblx = daox.getById(pr.getKodeUser());
				PasEaPPLDAO menuDAO = new PasEaPPLDAO(sess);
				PasEaPPL tblz =  menuDAO.getById(pr.getKodePPLUSer());
				String a = s.replace("}", ","+'"'+"userName"+'"'+":"+'"'+tblx.getName()+'"'+","+'"'+"namaPPL"+'"'+":"+'"'+tblz.getNamaPPL()+'"'+"},");
				sb.append(a);
			}
			String x="";
			if(sb.toString().length()>0){
				x= (sb.toString()).substring(0,sb.toString().length()-1);
			}	else{
				x="";
			}
			return x;
		}

//===============================REPORT====================================================

	@RequestMapping(value="/pasEaPPLUserReport.htm",method=RequestMethod.GET)
	 public String doGetpasEaPPLUserReport(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	super.doGet(model, session, reg,res);
	 	return "/report/pasEaPPLUserReport";
	}
	
	
		 @RequestMapping(value="/pasEaPPLUserDataReport.htm", method=RequestMethod.GET)
     public @ResponseBody String pasEaPPLUserDataReport(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
                    String KodePPLUSer=reg.getParameter("KodePPLUSer");
                    String PenyelenggaraPPL=reg.getParameter("PenyelenggaraPPL");
                    String KodeUser=reg.getParameter("KodeUser");		 
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
			PasEaPPLUserDAO dao = new PasEaPPLUserDAO(sess);
			List<PasEaPPLUser> l = new ArrayList<PasEaPPLUser>();
				l = dao.getBy(KodePPLUSer,PenyelenggaraPPL,KodeUser);
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
	
	
			@RequestMapping(value = "/downloadFiles.htm", method = RequestMethod.GET)
			public @ResponseBody void downloadFiles(HttpServletRequest request,	HttpServletResponse response) {
				String fileNamex = request.getParameter("param");
				ServletContext context = request.getServletContext();
				System.out.println("param ============================================== "+fileNamex);
				Session sess = null;
				String dirFolder = "";
				try{
					sess = HibernateUtil.getSessionFactory().openSession();
					 TblParamDAO paramDAO = new TblParamDAO(sess);
		           	 TblParam properties = paramDAO.getById("DIR_PPL_USER");
		           	 dirFolder = properties.getValue()+"\\";
		           	//String dirFolder = "";
				} catch (Exception e) {
					if(sess != null && sess.isOpen()) sess.close();
					e.printStackTrace();
				}  
				
				File downloadFile = new File(/*"C:/Users/Mugiarto/Documents/Dokumen/"*/dirFolder+fileNamex);
				FileInputStream inputStream = null;
				OutputStream outStream = null;
				
				try {
					inputStream = new FileInputStream(downloadFile);
		 
					response.setContentLength((int) downloadFile.length());
					response.setContentType(context.getMimeType(/*"C:/Users/Mugiarto/Documents/Dokumen/"*/dirFolder+fileNamex));			
		 
					// response header
					String headerKey = "Content-Disposition";
					String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
					response.setHeader(headerKey, headerValue);
		 
					// Write response
					outStream = response.getOutputStream();
					IOUtils.copy(inputStream, outStream);
		 
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (null != inputStream)
							inputStream.close();
						if (null != inputStream)
							outStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
		 
				}
		 
			}
	
	
}
