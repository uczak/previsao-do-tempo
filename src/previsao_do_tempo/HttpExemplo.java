/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package previsao_do_tempo;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author marcelosiedler
 */
public class HttpExemplo {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
//	public static void main(String[] args) throws Exception {
// 
//		HttpExemplo http = new HttpExemplo();
//                //String chamadaWs = "http://www.byjg.com.br/site/webservice.php/ws/cep";
//                //String chamadaWs = "http://localhost:8080/metodoWebService/webresources/WS/Incluir";
//                String chamadaWs ="http://api.openweathermap.org/data/2.5/weather?id=3452925&appid=4e6327bac3230a583079e31491060b85";
//		System.out.println("Testing 1 - Send Http GET request");
//		String json = http.sendGet(chamadaWs);
//                Gson g = new Gson();
//               // g.
//                System.out.println(json);
//		//System.out.println("\nTesting 2 - Send Http POST request");
//		//http.sendPost();
// 
//	}
 
	// HTTP GET request
	public String sendGet(String url) throws Exception {
 
		//String url = "http://localhost:8080/RestExemplo01/webresources/generic/exemplojson/oi";
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		return response.toString();
 
	}
 
	// HTTP POST request
	public String sendPost(String url) throws Exception {
 
		//String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		//System.out.println(response.toString());
                return response.toString();
	}
 
}
