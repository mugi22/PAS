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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.id.pegadaian.pasg2.dao.TblUserDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblUser;
import co.id.pegadaian.pasg2.util.AbstractListScreen;

import com.dframework.jpos.security.SecurityUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Controller
public class UserCariController extends AbstractListScreen {

    
	 @RequestMapping(value="/userCari.htm", method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session,  HttpServletRequest reg, HttpServletResponse res) {		 
		 return super.doGet(model, session, reg,res);
		}
	 

	 @RequestMapping(value="/userCari.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 
	 
	 
//	 ***************************** AJAX  **************************************************************
	 @RequestMapping(value="/userCariList.htm", method=RequestMethod.POST)
     public @ResponseBody String userListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		 String userId = reg.getParameter("userID");
		 String param =reg.getParameter("param");
		 String sNama = reg.getParameter("nama");
		 String kodeUnit = reg.getParameter("kodeUnit");
         TblUser user = (TblUser) session.getAttribute("user"+userId);
         System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS  "+sNama+"  "+userId);
         //model.put("session", ses);
         if(!cekValidSession(session,userId)){
        	 return "[]";
         }
         String result="";
         int row = Integer.parseInt(reg.getParameter("rows"));
         int loffset = (Integer.parseInt(reg.getParameter("page"))-1)*row;
         Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
         
         Session sess = null;
         try {
         	long rowCount=0;
 			sess = HibernateUtil.getSessionFactory().openSession();
 			TblUserDAO dao = new TblUserDAO(sess);
 			Map h = new HashMap<String, Object>();
 			List<TblUser> l = new ArrayList<TblUser>();
 				h = dao.getByPerPage(param,kodeUnit,sNama,loffset, row);
 			sess.close();
             result = gson.toJson(h);
             System.out.println(result);
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
//        	long rowCount=0;
//			sess = HibernateUtil.getSessionFactory().openSession();
//			TblUserDAO dao = new TblUserDAO(sess);
//			Map h = new HashMap<String, Object>();
//			List<TblUser> l = new ArrayList<TblUser>();
//			if (reg.getParameter("param").equals("")|| reg.getParameter("param") == null) {
//				rowCount = dao.getAllCount();
//				l = dao.getAll(loffset, row);				
//				h.put("total", rowCount);
//				h.put("rows", l);
//			} else {
//				TblUser tblUser = dao.getById(reg.getParameter("param"));
//				if(tblUser!=null){
//					h.put("total", 1);
//					l.add(tblUser);
//					h.put("rows", l);
//				}else{//bila pencarian tidak di temukan
//					h.put("total", 0);
//					List lz = new ArrayList();
//					h.put("rows", lz);
//				}
//			}
//			sess.close();
//            result = gson.toJson(h);
//            System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}         
         return result;
     }
	 
	 
	

@Override
protected String getView() {
	// TODO Auto-generated method stub
	return "userCari";
}
	 


	 
	 
}
