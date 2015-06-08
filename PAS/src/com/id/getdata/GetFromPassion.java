package com.id.getdata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.m24.shared.pojo.TblUser;

public class GetFromPassion {
String sFolder ="H:\\PAStrans\\";
	public StringBuffer getDataByTable(String pojo){
		System.out.println("Connecting............");
		Session session = null;//
		Criteria crit = null;
//		Gson gson = new Gson();
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		
		String tbl =pojo;
		String sPakage ="co.id.pegadaian.pasg2.pojo.";
		String sJson ="";
		StringBuffer sb = new StringBuffer();
		try{
		session=HibernateUtil.getSessionFactory().openSession();
			System.out.println("connected....");
			crit = session.createCriteria(Class.forName(sPakage+tbl));
			System.out.println("Retrieving....");
			List<Object> l = crit.list();
			for (Object tblPojo : l) {
				String z = gson.toJson(tblPojo);
//				System.out.println(z);
				sb.append(z + "\n");
			}
			sJson = gson.toJson(l);
			System.out.println(gson.toJson(l));
		}catch(Exception e){
			e.printStackTrace();
		}
		session.close();
		System.out.println("Session Close....");
		return sb;
	}
	
	public void getDataByTableAndSave(String pojo){
		StringBuffer sJson = getDataByTable(pojo);
		String sFile = sFolder+pojo+".json";
		File file = new File(sFile);
		if (file.length() == 0 && file.delete()) {			
			System.out.println("File already exists DELETED  "+file.getAbsolutePath());
		}
		
		
		try {
			if (file.createNewFile()) {
				
				System.out.println("File is created! " + pojo );

				FileWriter fw = new FileWriter(sFile, true); // the true will append the new data
				fw.write(sJson.toString());// appends the string to the file
				fw.close();
			} else {
				
				System.out.println("File already exists. "+ sFile);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
