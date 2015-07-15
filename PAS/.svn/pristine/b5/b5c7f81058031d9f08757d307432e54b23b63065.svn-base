package co.id.pegadaian.pasg2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.hibernate.Session;

import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.util.AppProp;

//import com.id.kas.db.HibernateUtil;
//import com.id.kas.util.AppProp;

/**
 * Servlet implementation class KasServlet
 */
public class PasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
//    	super.init();  
    	try {
    		Session sess = HibernateUtil.getSessionFactory().openSession();
        	System.out.println("Open Connection.............");
        	sess.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	
    	//CLOSE  OPEN
    	AppProp.setsAppStatus("OPEN");
    	
    }
}
