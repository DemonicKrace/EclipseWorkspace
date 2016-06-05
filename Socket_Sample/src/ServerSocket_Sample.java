import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;


public class ServerSocket_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//使用SocketAddress設定埠號
			//SocketAddress使用bind綁定埠號
			ServerSocket s1 = new ServerSocket();
			SocketAddress webPortocol = new InetSocketAddress(23);
			s1.bind(webPortocol);
			
			//建立一物件，指定傾聽8080埠
			ServerSocket s2 = new ServerSocket(8080);
			
			//建立一物件，埠號設為0，則由作業系統配置一埠號
			ServerSocket s3 = new ServerSocket(0);
			System.out.println("port = " + s3.getLocalPort());
			
			//設定客戶連線等待佇列最多使用個數(20個) ，預設50個
			ServerSocket s4 = new ServerSocket(8080,20);
			
			//綁定網卡位址，預設為本機所有網卡位址
			ServerSocket s5 = new ServerSocket(8080,20,InetAddress.getByName("192.168.1.1"));
			
			//印出綁定的ip位址
			//若為0.0.0.0代表本機所有ip位址
			System.out.println("ip = " + s5.getInetAddress().getHostAddress());

			//客戶連線後取得該Socket物件
			Socket client = s5.accept();
			
			//連線結結束，釋放該埠號
			s5.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ServerSocket ss = new ServerSocket(80);
			Socket client = ss.accept();
			
			//連線後取得輸出輸入串流
			OutputStream out = client.getOutputStream();
			InputStream in = client.getInputStream();
			
			//輸入串流轉成BufferedReader
			BufferedReader brIn = new BufferedReader(new InputStreamReader(in));
			/*
			//BufferedReader 由Reader類擴展而來，提供通用的緩衝方式字串讀取，
			//而且提供了很實用的readLine，讀取一行字串，
			//從字元輸入流中讀取字串，緩衝各個字元，從而提供字元、數組和行的高效讀取。
			//Sample
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
			String data = null;
			while((data = br.readLine())!=null)
			{
				System.out.println(data); 
			}
			*/
			
			/*
			//是字節流通向字元流的橋樑,封裝了InputStream在裡頭, 
			//它以較高級的方式,一次讀取一個一個字元，以文本格式輸入 / 輸出，可以指定編碼格式；
			//Sample
			InputStreamReader isr = new InputStreamReader(new FileInputStream("text.txt"));
			int data;
			while((data = isr.read())!=-1)
			{
				System.out.print((char)data); 
			}
			*/
			
			//OutputStream 為輸出binary資料，PrintWriter則可輸出字串
			//輸出串流轉成PrintWriter
			PrintWriter pwOut = new PrintWriter(out);
			//pwOut.println("data...");
			//pwOut.flush();
			//pwOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//支援多客戶端連線
		try {
			ServerSocket ss = new ServerSocket(8888);
			while(true){
				Socket client = ss.accept();
				//...
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
