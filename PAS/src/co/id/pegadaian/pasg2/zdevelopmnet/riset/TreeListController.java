package co.id.pegadaian.pasg2.zdevelopmnet.riset;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.id.pegadaian.pasg2.util.AbstractListScreen;

@Controller
public class TreeListController extends AbstractListScreen{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	@RequestMapping(value="/treeGrid.htm",method=RequestMethod.GET)
	 public String doGet(java.util.Map<String,Object> model, HttpSession session, HttpServletRequest reg, HttpServletResponse res){ 
	 	return super.doGet(model, session, reg,res);
	}
	
	
	 @RequestMapping(value="/treeGrid.htm", method=RequestMethod.POST)
	 public String doPost(Map<String, Object> model,HttpSession session, HttpServletRequest reg, HttpServletResponse res) {
		 super.doPost(model, session,reg,res);
		return getView();		 
	 }


	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return "treeGrid";
	}
	
	
}
