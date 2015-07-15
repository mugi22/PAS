package co.id.pegadaian.pasg2.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AmbilJasonFromURL {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		 String sURL = "http://localhost:8082/PassionToPasG2/getUserAll.htm"; //just a string

		    // Connect to the URL using java's native library
		    URL url;
			try {
				url = new URL(sURL);
				 HttpURLConnection request = (HttpURLConnection) url.openConnection();
				    request.connect();
				    
				    // Convert to a JSON object to print data
				    JsonParser jp = new JsonParser(); //from gson
				    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //convert the input stream to a json element
				    System.out.println("root /awal :"+root);
				    String x = root.toString();
				    
				    Gson gson = new Gson();
				    String rootobj = gson.toJson(x);
				    System.out.println("rubah manjadi jsonobject "+rootobj);
				    JSONArray jsonArray = new JSONArray(x);
				    System.out.println("root /awal  ubaj ke json array"+jsonArray);
				    System.out.println("======================================================");
				    for (int i = 0; i < jsonArray.length(); i++) {
				        JSONObject jsonobject = jsonArray.getJSONObject(i);
				        String userId = jsonobject.getString("userId");
				        String branchCode = jsonobject.getString("branchCode");
				        System.out.println(userId+" = "+branchCode);
				    }
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	}

}
