	import java.io.BufferedReader;
	import java.io.DataOutputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.io.Reader;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.net.URLConnection;
	import java.net.URLEncoder;
	import java.util.LinkedHashMap;
	import java.util.Map;

	import javax.net.ssl.HttpsURLConnection;


	public class Http {

		private final static String USER_AGENT = "Mozilla/5.0";
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
	//			http://arduino.local/arduino/digital/13/1
				
	//			sendGetRequest("http://linino.local/arduino/digital/13/1");
				sendGetRequest("http://linino.local/arduino/digital/13/0");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// HTTP GET request
			private static void sendGetRequest(String url) throws Exception {

				URL u = new URL(url);
				HttpURLConnection con = (HttpURLConnection) u.openConnection();

				// optional default is GET
				con.setRequestMethod("GET");

				//add request header
	//			con.setRequestProperty("User-Agent", USER_AGENT);

				int responseCode = con.getResponseCode();
				
				System.out.println("Sending 'GET' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);

				BufferedReader in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				//print result
				System.out.println("Response info : " + response.toString());
			}
			
			// HTTP POST request
			private void sendPostRequest(String url,String urlParameters) throws Exception {

				URL u = new URL(url);
				HttpsURLConnection con = (HttpsURLConnection) u.openConnection();

				//add reuqest header
				con.setRequestMethod("POST");
	//			con.setRequestProperty("User-Agent", USER_AGENT);
	//			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

	//			String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
				
				// Send post request
				con.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();

				int responseCode = con.getResponseCode();
				System.out.println("Sending 'POST' request to URL : " + url);
				System.out.println("Post parameters : " + urlParameters);
				System.out.println("Response Code : " + responseCode);

				BufferedReader in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				
				//print result
				System.out.println("Response info : " + response.toString());

			}
	}
