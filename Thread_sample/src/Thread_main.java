
public class Thread_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Thread mthread = Thread.currentThread();
		System.out.println("main thread is:" + mthread.getName());
		mthread.setName("Demo");
		System.out.println("main thread is:" + mthread.getName());
		*/
		Horse h1 = new Horse();
		Horse h2 = new Horse();
		Horse h3 = new Horse();
		
		h1.setName("h1");
		h2.setName("h2");
		h3.setName("h3");
		
//		h1.setPriority(Thread.MAX_PRIORITY); //1:MIN 5:NORMAL 10:MAX range:1~10
		
		h1.start();
		h2.start();
		h3.start();
		
		try{
			//main thread waiting for h1,h2,h3 thread finish
			h1.join();
			h2.join();
			h3.join();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("main thread ended");
	}

}

class Horse extends Thread{
	public void run(){

		for(int i=0;i<1000;i++){
//			System.out.println(this.getName() + ": i=" + i);
		}

		System.out.println(this.getName() + " is finish");
		while(true);
	}
	
	//method level 同步方法
	//限定同一時間只能由“一個物件”執行此方法，
	public synchronized void f1(){
		System.out.println("method level:");
		for(int i = 0 ;i < 1000;i++){
			//...
			System.out.println(this.getName() + " f1() is running!");
		}
	}
	
	//block level
	//限定同一時間內只能由“某單一執行緒”執行此段程式碼
	public void f2(){
		System.out.println("block level:");
		synchronized(this){
			for(int i = 0;i < 1000;i++){
				//...
				System.out.println(this.getName() + " f2() is running!");
			}
		}
	}
}