package co.id.pegadaian.pasg2.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

import org.hibernate.Session;

import co.id.pegadaian.pasg2.dao.TblBranchDAO;
import co.id.pegadaian.pasg2.db.HibernateUtil;
import co.id.pegadaian.pasg2.pojo.AuditTrail;
import co.id.pegadaian.pasg2.pojo.PasEaAuditan;
import co.id.pegadaian.pasg2.pojo.TblBranch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.id.kas.pojo.AuditTrail;

public class SetTableData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("----------------MULAI  SET--------------");
	// TODO Auto-generated method stub
			SetTableData rest = new SetTableData();
			/*	//			rest.restorePojo("TblCoaMaster");
			GetTableData getTableData = new GetTableData();
		    rest.restorePojo("PasKsAuditTrail");
			rest.restorePojo("PasEaTkAuditan");
			rest.restorePojo("PasEaAuditan");
		    rest.restorePojo("PasEaFormasiAuditan");
		    rest.restorePojo("PasEaPPL");
		    rest.restorePojo("PasEaPPLUser");
		    rest.restorePojo("PasEaKantorAuditor");
		    rest.restorePojo("PasEaKetuaTimAuditor");
		    rest.restorePojo("PasEaAnggotaTimAuditor");
		    rest.restorePojo("PasEaJenisPemeriksaan");
			rest.restorePojo("PasEaTkKantorAuditor");
		    rest.restorePojo("PasEaAspekPemeriksaan");
		    rest.restorePojo("TblAppProperties");
		    rest.restorePojo("PasEaProsedurPemeriksaan");
		    
		    rest.restorePojo("TblSukasuka");
		    
		    rest.restorePojo("TblUser");
		 
		    rest.restorePojo("TblPriviledge");
		    rest.restorePojo("TblUserGroup");
		    rest.restorePojo("TblMenu");
		    rest.restorePojo("TblGroup");
//		    rest.restorePojo("TblBranch");
//		    rest.restorePojo("TblTest");
		   
		    rest.restorePojo("TblLookup");
//		    rest.restorePojo("TblProvinsi");
//		    rest.restorePojo("TblKabupaten");
//		    rest.restorePojo("TblKecamatan"); 
//			rest.restorePojo("TblKelurahan"); 
			
		  	rest.restorePojo("TblPasKsKodefikasiKasus");
		  	rest.restorePojo("TblPasKsKodefikasiSebab");
		    rest.restorePojo("TblPasKsKodefikasiTkTemuan");
		    rest.restorePojo("TblPasKsKodefikasiTemuan");
		    rest.restorePojo("TblPasKsKodefikasiBidangKasus");
		    rest.restorePojo("TblPasKsHariLibur");
		    rest.restorePojo("TblParam");
		    rest.restorePojo("TblSeq");
		    rest.restorePojo("PasRaMasterRKAP");
		    rest.restorePojo("PasRaDetailRKAP");
		    rest.restorePojo("PasRaKegiatanRKBPT");
		    rest.restorePojo("TblRekeningIaMaster");
		    rest.restorePojo("PasRaKegiatanPKPT");
		    System.out.println("-------------SELESAI SET------------------");
*/
		rest.TblBarnchToAuditan("TblBranch");
	}
private String sFolder ="H:\\trans\\pasg2\\";
	public void restorePojo(String pojo){
		
		String filename = sFolder+pojo+".json";
		String sPakage ="co.id.pegadaian.pasg2.pojo.";
		String namaClass = sPakage+pojo;
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		
		try {
			File file = new File(filename);
			if (file.exists()) {
				System.out.println("File Ada............");
				
				BufferedReader br = null;
				int z = 0;
				try {
					String sCurrentLine;
					br = new BufferedReader(new FileReader(filename));
//					ITransaction trx = null;
					Session session=null;
					session = HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					while ((sCurrentLine = br.readLine()) != null) { // baca_perbaris_dari_file
						System.out.println("sCurrentLine "+sCurrentLine);
						z++;
						Object o = Class.forName(namaClass).newInstance();
						// System.out.println(sCurrentLine);
						o = gson.fromJson(sCurrentLine, Class.forName(namaClass));
						if (o instanceof AuditTrail) {
							// System.out.println(o.getNamaKelurahan());
							((AuditTrail) o).setCreateBy("IMPORTX");
							((AuditTrail) o).setCreateDate(new Date());
							((AuditTrail) o).setUpdateBy("IMPORTX");
							((AuditTrail) o).setUpdateDate(new Date());
						}
						session.saveOrUpdate(o);						
					}
					session.getTransaction().commit();
					session.close();
					System.out.println("Selesai................");
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
			}else{
				System.out.println("File Not Exist...............");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	private void TblBarnchToAuditan(String pojo){
		String filename = sFolder+pojo+".json";
		String sPakage ="co.id.pegadaian.pasg2.pojo.";
		String namaClass = sPakage+pojo;
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		
		try {
			File file = new File(filename);
			if (file.exists()) {
				System.out.println("File Ada............");
				
				BufferedReader br = null;
				int z = 0;
				try {
					String sCurrentLine;
					br = new BufferedReader(new FileReader(filename));
//					ITransaction trx = null;
					Session session=null;
					session = HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					TblBranchDAO branchDAO = new TblBranchDAO(session);
					while ((sCurrentLine = br.readLine()) != null) { // baca_perbaris_dari_file
						System.out.println("sCurrentLine "+sCurrentLine);
						z++;
						//Object o = Class.forName(namaClass).newInstance();
						 System.out.println(sCurrentLine);
						TblBranch o = new TblBranch(); 
						o = gson.fromJson(sCurrentLine, TblBranch.class);
						if (o instanceof AuditTrail) {
							// System.out.println(o.getNamaKelurahan());
							((AuditTrail) o).setCreateBy("IMPORTX");
							((AuditTrail) o).setCreateDate(new Date());
							((AuditTrail) o).setUpdateBy("IMPORTX");
							((AuditTrail) o).setUpdateDate(new Date());
						}
						PasEaAuditan a = new PasEaAuditan();
						a.setKodeAuditan(o.getBranchCode());
						a.setKdParent(o.getParentId());
						a.setNamaAuditan(o.getName());
						a.setKodeTkAuditan("0"+o.getLvl());
						a.setFaximiliAuditan(o.getTelp());
						a.setNikPicTl(o.getPinca());
						//a.getAlamatAuditan(o.get);
						
						session.saveOrUpdate(a);						
					}
					session.getTransaction().commit();
					session.close();
					System.out.println("Selesai................");
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
			}else{
				System.out.println("File Not Exist...............");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
