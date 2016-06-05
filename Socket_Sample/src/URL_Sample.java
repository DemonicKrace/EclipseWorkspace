import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class URL_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//URL
		try{
			//與目標資源建立URL連線
			URL url = new URL("https://google.com");
			//URL url_2 = new URL("http","demonickrce.com",80,"/web/index.html");
			
			//取得該連線物件
			URLConnection con = url.openConnection();
			//與該資源建立實質連線
			con.connect();
			
			//取得輸入資料串流物件，預設編碼
			//InputStream in = con.getInputStream();
			//Reader串流，設置utf-8邊碼
			InputStreamReader in = new InputStreamReader(con.getInputStream(),"UTF-8");
			
			//讀取資料
			int data ;
			while((data = in.read()) != -1){
				System.out.print((char)data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//資料傳輸失敗
			e.printStackTrace();
		
		}

	}

}
