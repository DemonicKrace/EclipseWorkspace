package pkgd;

import pkgb.RV;
import pkgc.Jeep;

public class hw15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		RV rv = new RV();
		rv.start();
		rv.break_();
		Jeep jeep = new Jeep();
		jeep.start();
		jeep.break_();
		*/
		
		String str1=new String("abcabcabcabcabcbbcbbc");
	    int counter=0,k=0;    	     	
	    // 補足程式碼，可使用int indexOf(String str,int fromIndex)方法
	    while(k < str1.length() - "bc".length()){
	    	k = str1.indexOf("bc",k) + "bc".length();
	    	counter ++ ;
	    }
	    System.out.println("bc出現在" + str1 + "共" + counter +"次");	    
	}
}
