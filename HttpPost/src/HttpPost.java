import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;


public class HttpPost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			sentHttpPostRequest_1("http://yun01.local", "arg1=value1&arg2=value2");
//			sentHttpPostRequest_2("http://linino.local");
//			sentHttpPostRequest_2("192.168.0.107");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sentHttpPostRequest_1(String url, String args) throws IOException {
	    URLConnection connection = new URL(url).openConnection();
	    // by default, connection with enable input, but won't enable output
	    connection.setDoOutput(true);
	    //connection.setDoInput(true);
	    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
	    out.write(args);
	    out.flush();
	    out.close();
	    
	     //* If the page has respond, uncomment these statements the retrieve the respond data
	    InputStream is = connection.getInputStream();
	    FileOutputStream fos = new FileOutputStream("respond.txt");
	    byte[] buffer = new byte[1024];
	    for (int length; (length = is.read(buffer)) > 0;) {
	        fos.write(buffer, 0, length);
	    }
	    fos.close();
	    is.close();   
	}
	
	public static void sentHttpPostRequest_2(String dest) throws Exception{
		URL url = new URL(dest);
		
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("name", "Freddie the Fish");

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
        	System.out.println("response ok!");
	        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	
	        for (int c; (c = in.read()) >= 0;)
	            System.out.print((char)c);
        }
	}
}
