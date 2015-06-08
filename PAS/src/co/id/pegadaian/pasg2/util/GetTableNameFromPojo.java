package co.id.pegadaian.pasg2.util;

import java.lang.annotation.Annotation;

import co.id.pegadaian.pasg2.pojo.TblUser;

public class GetTableNameFromPojo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		
		GetTableNameFromPojo fromPojo = new GetTableNameFromPojo();
		fromPojo.getTableName("co.id.pegadaian.pasg2.pojo.TblUser");
	}

	
	public String getTableName(String sClass){
		String tableName ="";
		try {
			try {
				Object c =  Class.forName(sClass).newInstance();
				//TblUser tblUser = new TblUser();
				Annotation[] annos = c.getClass().getAnnotations();		      
			      for(Annotation a : annos){
			    	  
			    	  String z = a.toString();
			    	  if(z.contains("Table")){
			    	  String[] x = z.split(",");
			    	  for(String f:x){
			    		  if(f.contains("name=")){
			    			  tableName = (f.replace("name=", "")).trim();
			    		  }
			    	  }
			    	  }
			      }
			      System.out.println(tableName);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return tableName;
	}
}
