package co.id.pegadaian.pasg2.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.hibernate.Session;

import co.id.pegadaian.pasg2.dao.TblAppPropertiesDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.TblAppProperties;

public class PropertiesFileToDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertiesFileToDB prDb = new PropertiesFileToDB();
		prDb.bacaFile();
		
		

	}

	public void bacaFile(){
		File file = new File("H:/Workspace/PAS/PAS/WebContent/WEB-INF/pasg2.properties");
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		String[] s = null ;
		try {
			Session sess ;
			sess = HibernateUtil.getSessionFactory().openSession();
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				if(!sCurrentLine.equals("")){
					s = sCurrentLine.split("=");
				
					try {
						TblAppPropertiesDAO appPropertiesDAO = new TblAppPropertiesDAO(sess);
						TblAppProperties tblAppProperties = new TblAppProperties();
						tblAppProperties.setPropertiesNama(s[0]);
						tblAppProperties.setPropertiesValue(s[1]);
						
						sess.beginTransaction();
						appPropertiesDAO.saveOrUpdate(tblAppProperties);
						
						sess.getTransaction().commit();
						System.out.println("Simpan Ukses...............");
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Simpan Errror................");
						e.printStackTrace();
					}
					
				
			}
			}
			sess.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
