import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetAddress_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//使用DNS查詢目標主機IP
			InetAddress addr1 = InetAddress.getByName("google.com");
			System.out.println(addr1);
			
			//取得本機位址
			InetAddress addr2 = InetAddress.getLocalHost();
			System.out.println(addr2);

			//傳入一個byte[] 表示ip位址
			byte[] b = {(byte) 192,(byte) 168,0,1};
			InetAddress addr3 = InetAddress.getByAddress(b);
			System.out.println(addr3);
			
			//取得該主機的所有網卡ip
			InetAddress[] addr4 = InetAddress.getAllByName("hostname");
			for(int i=0;i<addr4.length;i++){
				System.out.println(addr4[i]);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
