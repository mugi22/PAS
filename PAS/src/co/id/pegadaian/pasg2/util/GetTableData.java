package co.id.pegadaian.pasg2.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.id.getdata.HibernateUtil;

public class GetTableData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("-------------MULAI------------------");
		// TODO Auto-generated method stub
		GetTableData getTableData = new GetTableData();
//	    getTableData.getDataByTableAndSave("PasKsAuditTrail");
		getTableData.getDataByTableAndSave("PasEaTkAuditan");
		getTableData.getDataByTableAndSave("PasEaAuditan");
	    getTableData.getDataByTableAndSave("PasEaFormasiAuditan");
	    getTableData.getDataByTableAndSave("PasEaPPL");
	    getTableData.getDataByTableAndSave("PasEaPPLUser");
	    getTableData.getDataByTableAndSave("PasEaKantorAuditor");
	    getTableData.getDataByTableAndSave("PasEaKetuaTimAuditor");
	    getTableData.getDataByTableAndSave("PasEaAnggotaTimAuditor");
	    getTableData.getDataByTableAndSave("PasEaJenisPemeriksaan");
		getTableData.getDataByTableAndSave("PasEaTkKantorAuditor");
	    getTableData.getDataByTableAndSave("PasEaAspekPemeriksaan");
	    getTableData.getDataByTableAndSave("TblAppProperties");
	    getTableData.getDataByTableAndSave("PasEaProsedurPemeriksaan");
	    
//	    getTableData.getDataByTableAndSave("TblSukasuka");
	    
	    getTableData.getDataByTableAndSave("TblUser");
	 
	    getTableData.getDataByTableAndSave("TblPriviledge");
	    getTableData.getDataByTableAndSave("TblUserGroup");
	    getTableData.getDataByTableAndSave("TblMenu");
	    getTableData.getDataByTableAndSave("TblGroup");
//	    getTableData.getDataByTableAndSave("TblBranch");
	    getTableData.getDataByTableAndSave("TblTest");
	   
	    getTableData.getDataByTableAndSave("TblLookup");
//	    getTableData.getDataByTableAndSave("TblProvinsi");
//	    getTableData.getDataByTableAndSave("TblKabupaten");
//	    getTableData.getDataByTableAndSave("TblKecamatan"); 
//		getTableData.getDataByTableAndSave("TblKelurahan"); 
		
	  	getTableData.getDataByTableAndSave("TblPasKsKodefikasiKasus");
	  	getTableData.getDataByTableAndSave("TblPasKsKodefikasiSebab");
	    getTableData.getDataByTableAndSave("TblPasKsKodefikasiTkTemuan");
	    getTableData.getDataByTableAndSave("TblPasKsKodefikasiTemuan");
	    getTableData.getDataByTableAndSave("TblPasKsKodefikasiBidangKasus");
	    getTableData.getDataByTableAndSave("TblPasKsHariLibur");
	    getTableData.getDataByTableAndSave("TblParam");
	    getTableData.getDataByTableAndSave("TblSeq");
	    getTableData.getDataByTableAndSave("PasRaMasterRKAP");
	    getTableData.getDataByTableAndSave("PasRaDetailRKAP");
	    getTableData.getDataByTableAndSave("PasRaKegiatanRKBPT");
	    getTableData.getDataByTableAndSave("TblRekeningIaMaster");//
	    getTableData.getDataByTableAndSave("PasRaKegiatanPKPT");
	    //getTableData.getDataByTableAndSave("");
	   
		
		    System.out.println("-------------SELESAI------------------");
		   
	}

	
	String sFolder ="H:\\trans\\pasg2\\";
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
			System.out.println("Retrieving...."+pojo);
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
		System.out.println("Session Close....DONE : "+pojo);
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
