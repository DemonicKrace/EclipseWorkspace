import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class NioClient_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetSocketAddress addr = new InetSocketAddress("localhost",80);
			SocketChannel chann;
			chann = SocketChannel.open(addr);
	
			//緩衝區
			ByteBuffer buf = ByteBuffer.allocate(1024);
			//讀取資料
			chann.read(buf);
			System.out.println("緩衝區資料個數: " + buf.position());
			//將緩衝區的位置0，準備一一讀出並列印
			buf.flip();
			//印出
			while(buf.hasRemaining()){
				System.out.println((char)buf.get());
			}
			
			//傳送資料
			buf.clear();
			buf.put("some data".getBytes());
			buf.flip();
			chann.write(buf);
			buf.clear();
			
			//再次讀取資料
			chann.read(buf);
			buf.flip();
			while(buf.hasRemaining()){
				System.out.println((char)buf.get());
			}
			
		} catch(IOException e){
			e.toString();
		}
	}
}
