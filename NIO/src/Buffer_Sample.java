import java.nio.ByteBuffer;


public class Buffer_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//分為直接與間接緩衝區
		//直接：跳過JVM的處理，直接對OS的記憶體做緩衝區資料存取，適合大檔案，長時間傳輸，因JVM會限制記憶體緩衝區使用量
		//間接：由JVM分配處理，限制多，但一般建議使用此方式，除非大檔案或長時間傳輸，較安全
		
		//直接
		ByteBuffer buf1 = ByteBuffer.allocateDirect(10);
		//間接
		ByteBuffer buf2 = ByteBuffer.allocate(10);
		
		
		//put 放入資料
		byte[] data = "some data".getBytes();
		buf2.put(data);
		ByteBuffer buf3 = ByteBuffer.allocate(10);
		//放入ByteBuffer
		buf3.put(buf2);
		
		//最大容量
		System.out.println("max capacity: " + buf3.capacity()); //10
		
		ByteBuffer buf4 = ByteBuffer.allocate(10);
		buf4.put("data".getBytes());
		//當前資料可用的最大索引值
		System.out.println("limit = " + buf4.limit());
		//當前資料位址
		System.out.println("position = " + buf4.position());
		//標記當前資料位址，當前為4
		buf4.mark();
		//接續放入資料
		buf4.put("test".getBytes());
		//回到標記位址
		buf4.reset();
		//回到4
		System.out.println(" position = " + buf4.position());
		
		
		//從緩衝區取出資料

		ByteBuffer buf5 = ByteBuffer.allocate(10);
		buf5.put("abc".getBytes());
		//flip()將position重置為0，limit則依舊是當前資料位址
		buf5.flip();
		System.out.println("capacity = " + buf5.capacity()); //10
		System.out.println("limit = " + buf5.limit()); //3
		System.out.println("position" + buf5.position());//0
		//再使用get()取出資料
		Byte[] bb = new Byte[10];
		//buf5.get(); //讀取當前position的值，position 在 + 1 
		//buf5.get(1); //指定讀取position的值
		while(buf5.hasRemaining()){
			System.out.println((char)buf5.get());
		}
		//clear() 重新放資料 
		
	}

}
