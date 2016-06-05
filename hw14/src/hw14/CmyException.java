package hw14;

public class CmyException extends Exception{
	public CmyException(){
		super();
	}
	public CmyException(String msg){
		super(msg);
		System.out.println(msg);
	}
}
