import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class DatagramPacket_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//建立傳送與接收UDP資料用的類別
		
		//傳送資料
		//建構參數需要四個，位元組資料,資料長度,位址,埠號
		//DatagramPacket(byte[] data,int length,InetAddress dest,int port)
		//DatagramPacket(byte[] data,int offset,int length,InetAddress dest,int port)
		
		//接收資料
		//buffer為接收資料的的緩存,length為接收資料的長度
		//DatagramPacket(byte[] buffer,int length)
		//DatagramPacket(byte[] buffer,int offset,int length)
		
		//取得UDP封包內的資料
		//public byte[] getData()
		//new String(byte[] data,String encoding); //處理編碼
		
		//public setData(byte data[])
		try {
			String str = "test";
			byte[] data = str.getBytes();
			InetAddress dest;
			dest = InetAddress.getLocalHost();
			//只有建立資料，並未傳送
			DatagramPacket packet = new DatagramPacket(data,data.length,dest,8080);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
