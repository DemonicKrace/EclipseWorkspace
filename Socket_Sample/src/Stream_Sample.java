import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Stream_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stream Sample
		try{
			//Stream
			Socket socket3 = new Socket("192.168.0.3",80);
			//取得輸入串流
			InputStream in = socket3.getInputStream();
			//取得輸出串流
			OutputStream out = socket3.getOutputStream();
			
			//取得一個byte
			int data = in.read();
			
			//傳送一個byte
			out.write(64);
			//從緩存區送出至遠方
			out.flush();
			
			//關閉連線
			in.close();
			out.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//主機連線失敗
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//資料傳輸失敗
			e.printStackTrace();
		}
	}

}
