import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class DatagramSocket_Sample {
	public static void main(String[] args) {
		//DatagramSocket 用來傳送與接收UDP ，搭配DatagramPacket
			
	}
}
class UDPClient{
	void sendData(){
		try {
			int destPort = 8080;
			String str = "test";
			byte[] data = str.getBytes();
			InetAddress dest;
			dest = InetAddress.getLocalHost();
			DatagramPacket packet = new DatagramPacket(data,data.length,dest,destPort);
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class UDPServer{
	void receiveData(){
		try {
			int listeningPort = 8080;
			byte[] buffer = new byte[10];
			DatagramPacket packet = new DatagramPacket(buffer,10);
			DatagramSocket Socket;
			Socket = new DatagramSocket(listeningPort);
			System.out.println("Waiting for port: " + Socket.getLocalPort());
			Socket.receive(packet);
			System.out.println("received UDP packet , content:");
			for(int i = 0;i < buffer.length;i++){
				System.out.println(buffer[i]);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}