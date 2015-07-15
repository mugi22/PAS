package co.id.pegadaian.pasg2.util;

import java.io.File;

public class RenameFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	public void renameFile(String originalName, String newNameFile ){
		 File oldName = new File("C:/program.txt");
	      File newName = new File("C:/java.txt");
	      if(oldName.renameTo(newName)) {
	         System.out.println("renamed");
	      } else {
	         System.out.println("Error");
	      }
		
	}
}
