package co.id.pegadaian.pasg2.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadPropertiesFile {

	/**
	 * @param args
	 */


	public  void propertesChek(String stringToChek) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;	
		String s = Constants.SysParam.WorkSpaceFroder+Constants.SysParam.PropertiesFile;//"/WebContent/WEB-INF/myapp.properties";
		System.out.println(" ***************************  "+s);
		try{
			String sCurrentLine;
			br = new BufferedReader(new FileReader(s));
			int check = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String line = sCurrentLine;
				System.out.println(line+ "| =stringToChek= |"+stringToChek+"|");
				if (sCurrentLine.contains(stringToChek)){
//					String z;// = line.replaceAll("XXXjudul", jspName.toUpperCase());					
					check =1;
				}
				
			}
			if(check==0){
				//tambah
				sb.append("\n");
				sb.append(stringToChek);				
				createFile(s, sb.toString());
			}
		}catch (Exception e){
			
		}
	}
	
	
	public void createFile(String fileName,String fileText) {
		try {
			File file = new File(fileName);
			if(file.exists()){
				BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
				output.write(fileText);
				output.close();
		        System.out.println("Success file added..........................................!"+fileName);
			}
		         else{
		         System.out.println("Error ,"+fileName+" file already exists.");
		    }
			
			
		} catch (IOException e) {
			System.out.println("file : "+fileName);
			e.printStackTrace();
		}
	}
	
	
	
	
}
