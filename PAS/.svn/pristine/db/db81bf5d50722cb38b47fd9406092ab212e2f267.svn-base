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
import co.id.pegadaian.pasg2.pojo.PasEaAspekPemeriksaan;//harap Sesuaikan
import co.id.pegadaian.pasg2.dao.PasEaAspekPemeriksaanDAO;

import co.id.pegadaian.pasg2.util.AbstractListScreen;


@Controller
public class PasEaAspekPemeriksaanCariController  extends AbstractListScreen{
	@RequestMapping(value="/pasEaAspekPemeriksaanCari.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/pasEaAspekPemeriksaanCari.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }
	 
	 @Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "pasEaAspekPemeriksaanCari";
	}
	
//	 ***************************** LIST  **************************************************************
	 @RequestMapping(value="/pasEaAspekPemeriksaanListAllCari.htm", method=RequestMethod.POST)
     public @ResponseBody String pasEaAspekPemeriksaanListAll(Map<String, Object> model,HttpSession session,HttpServletRequest reg) {
		 System.err.println("============================ pasEaAspekPemeriksaanListAllCari :");
                    String Status=reg.getParameter("Status");
                    String KodeAspekPemeriksaan=reg.getParameter("KodeAspekPemeriksaan");
                    String KodeJenisPemeriksaan=reg.getParameter("KodeJenisPemeriksaan");
                    String KdParent=reg.getParameter("KdParent");		 
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
			PasEaAspekPemeriksaanDAO dao = new PasEaAspekPemeriksaanDAO(sess);
			Map h = new HashMap<String, Object>();
			List<PasEaAspekPemeriksaan> l = new ArrayList<PasEaAspekPemeriksaan>();
				h = dao.getByPerPage(Status,KodeAspekPemeriksaan,KodeJenisPemeriksaan,KdParent,loffset, row);
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

	
}
