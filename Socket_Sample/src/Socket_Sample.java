import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;


public class Socket_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//與主機loaclhost的80 port建立連線
			Socket socket1 = new Socket("loaclhost",80);
			
			//取得本機位址物件
			SocketAddress local = socket1.getLocalSocketAddress();
			
			//取得遠端位址物件
			SocketAddress remote = socket1.getRemoteSocketAddress();

			//Sample_1
			
			//建立本地位址+埠
			InetSocketAddress localhost = new InetSocketAddress(8080);
			//建立遠端位址+埠
			InetSocketAddress remotehost = new InetSocketAddress("192.168.0.2",80);
			//建立socket
			Socket socket2 = new Socket();
			//綁定本地位址
			socket2.bind(localhost);
			//印出本地埠號
			System.out.println("localhost port:" + socket2.getLocalPort());
			//與遠端建立連線
			socket2.connect(remotehost);
			//與遠端建立連線，並設定連線時間-timeout(毫秒)
			//socket2.connect(remotehost,1000);
						
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
