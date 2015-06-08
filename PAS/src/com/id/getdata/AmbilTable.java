package com.id.getdata;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;
//import com.m24.shared.pojo.TblBranch;
//import com.m24.shared.pojo.TblUser;

//import com.id.kas.pojo.TblUser;
//import com.id.kas.pojo.TblUserHome;

public class AmbilTable {
	public static void main(String[] args) {
		GetFromPassion get = new GetFromPassion();
//		get.getDataByTable("TblProvinsi");
		get.getDataByTableAndSave("TblProvinsi");
		get.getDataByTableAndSave("TblKabupaten");
		get.getDataByTableAndSave("TblKecamatan");
		get.getDataByTableAndSave("TblKelurahan");
		get.getDataByTableAndSave("TblBranch");
//		get.getDataByTableAndSave("TblCoaMaster");
//		get.getDataByTableAndSave("TblRekeningIaMaster");
		
	}
}
