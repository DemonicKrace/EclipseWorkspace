package ex1;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	   print99(1,1);   
		int Level = 5;
		/*
		for(int i=1;i<=Level;i++){	
			for(int j=Level;j>i;j--)
				System.out.print(" ");
			for(int j=1;j<=i;j++){
				if(j!=1)	
					System.out.print(" ");
				System.out.print("*");		
			}
			System.out.print("\n"); 	
		}	
		*/
		for(int i=1;i<=Level;i++){	
			for(int j=1;j<i;j++)
				System.out.print(" ");
			for(int j=Level;j>=i;j--){
				if(j!=Level)	
					System.out.print(" ");
				System.out.print("*");		
			}
			System.out.print("\n"); 	
		}	
		System.out.print(String.valueOf(sum(5))); 	
	
    }   
	static int sum(int n) {
	    if (n == 1) {
	        return 0;
	    } else {
	        return sum(n-1)+n*(n-1);
	    }
	}
    static void print99(int x,int y){
      //請用遞迴呼叫實作
    	if(x<10){
	        if(y<10){
	            System.out.printf("%d*%d=%-2d ",x,y,x*y);
	            print99(x, y+1);
	        }else{
	        	System.out.printf("\n");
	            x++;
	            print99(x,1);
	        }
	    }
    }    
}

