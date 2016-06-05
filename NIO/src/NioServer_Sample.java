import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class NioServer_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NIO可讓main執行緒處理多個客戶端需求，不需為客戶端產生個別執行緒，以非阻斷式(non-blocking)
		//非阻斷式為當事件發生才進行處理，而非等待其發生
		
		//ServerSocketChannel 連線通道
		//SocketChannel 傳輸通道
		
		//Selector 做事件觸發監控，當連線與資料傳輸時做處理
		

		try {
			//1.建立ServerSocketChannel來監聽埠號
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			ServerSocket ss = serverChannel.socket();
			ss.bind(new InetSocketAddress(8080));
			serverChannel.configureBlocking(false); //設定為非阻斷式
			
			//2.註冊動作Accept至Selector
			Selector selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT); //連線請求

			//3.準備監視迴圈，
			while(true){
				selector.select(); //不斷進行監視
				Set keys = selector.selectedKeys();//取得收集到的鍵值				
				//4.檢查所有發生動作的鍵值
				Iterator it = keys.iterator();
				while(it.hasNext()){
					SelectionKey key = (SelectionKey) it.next(); //轉型成鍵值
					it.remove();
					//5.產生該連線的SocketChannel資料通道
					if(key.isAcceptable()){//轉為傳輸通道
						System.out.println("client connected");
						ServerSocketChannel server = (ServerSocketChannel)key.channel(); //取得連線通道
						SocketChannel client = server.accept(); //取得傳輸通道
						client.configureBlocking(false); //設定為非阻斷式
						SelectionKey clientKey = client.register(selector,SelectionKey.OP_WRITE);//註冊寫入事件
					}else if(key.isWritable()){ //寫入事件
						//6.使用此SocketChannel進行資料傳輸
						SocketChannel client = (SocketChannel) key.channel();//使用傳輸通道，傳輸資料到客戶端
						ByteBuffer buf = ByteBuffer.allocate(10);
						buf.put("hello".getBytes());
						buf.flip();
						client.write(buf);
						client.close();
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
