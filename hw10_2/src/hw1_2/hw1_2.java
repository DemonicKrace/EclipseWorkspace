package hw1_2;
import java.util.Arrays;
public class hw1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(1)-f：在main()中，建立CTriangle的物件陣列objArr，
		//並使用迴圈呼叫10次makeThreeNum()，取得10組數值，
		//並利用這10組數值作為objArr[0]~objArr[9]的成員值（若不合法，則該物件之成員會自動被設定為3,4,5）。

		CTriangle[] objArr = new CTriangle[10];
		int n[];
		for(int i = 0; i < 10 ;i++){
			n = makeThreeNum();			
			//System.out.printf("%d,%d,%d\n",n[0],n[1],n[2]);
			objArr[i] = new CTriangle(n[0],n[1],n[2]);
		}
		
		//(1)-g：在main()中，手動修正objArr[9]的三個成員值為(20,21,29)。
		objArr[9].setEdge1(20);
		objArr[9].setEdge1(21);
		objArr[9].setEdge1(29);

		//(1)-h：在main()函式中，印出物件陣列的10個三角形的邊，並判斷是否為直角三角形。
		for(int i = 0 ; i < 10 ;i++){
			System.out.printf("3邊為  %-2d   %-2d   %-2d   ",objArr[i].getEdge1(),objArr[i].getEdge2(),objArr[i].getEdge3());
			if(objArr[i].isRightAngled()){
				System.out.println("是直角三角形");
			}else{
				System.out.println("不是直角三角形");
			}
		}
		
	}

	//(1)-e：撰寫一個產生三個亂數的主類別函式int [] makeThreeNum()。三個數存放於陣列中。
	//陣列[0]之值為介於5~29的整數。
	//陣列[1]之值為介於9~49的整數。
	//陣列[2]之值為介於29~89的整數。
	static int[] makeThreeNum(){
//		5~29, 9~49, 29~89
		int n1 = (int)(Math.random() * (29-5+1)) + 5;
		int n2 = (int)(Math.random() * (49-9+1)) + 9;
		int n3 = (int)(Math.random() * (89-29+1)) + 29;
		int n[] = {n1,n2,n3};
		return n;
	}
}

class CTriangle{
	//設計一個三角形類別，當中包含三項公用資料如下：
	private int edge1;
	private int edge2;
	private int edge3;
	
	//(1)-c：設計一個建構子，接受三個整數引數a,b,c，內容為利用isLegal判定輸入的引數是否可構成三角形，
	//若無法構成，則設定三個邊為3,4,5（請呼叫(1)-a來完成），若可構成三角形，則設定a,b,c為三個邊的值。
	public CTriangle(int a,int b,int c){
		//先升冪排序
//		System.out.printf("CT %d,%d,%d\n",a,b,c);
		int e[] = {a , b , c};
		Arrays.sort(e);
//		System.out.printf("CT sort %d,%d,%d\n",e[0],e[1],e[2]);
		if(isLegal(e[0],e[1],e[2])){
			this.edge1 = e[0] ;
			this.edge2 = e[1] ;
			this.edge3 = e[2] ;
		}else{
			this.edge1 = 3;
			this.edge2 = 4;
			this.edge3 = 5;
		}
	}
	
	//(1)-a：設計一個無參數的建構子。功能為設定三個邊為3,4,5。
	public CTriangle(){
		this(3,4,5);
	}
	
	//(1)-b：設計一個類別方法(class method)，boolean isLegal(int a,int b,int c)，用以判斷a,b,c是否能夠成為三角形的邊。其中
	//須符合a≦b≦c，否則回傳false。
	//須符合 |另兩邊的差| < 第三邊 < 另兩邊的和，否則回傳false。
	private boolean isLegal(int a,int b,int c){ 
		return (a <= b && b <= c) && (b - a < c && a + b < c);			
	}
	
	//(1)-d：設計一個方法boolean isRightAngled()，使用畢氏定理判定是否為直角三角形。
	public boolean isRightAngled(){
		return (edge1 * edge1 + edge2 * edge2 == edge3 * edge3) ;
	}
	
	//set
	public void setEdge1(int edge){
		this.edge1 = edge;
	}
	
	public void setEdge2(int edge){
		this.edge2 = edge;
	}
	
	public void setEdge3(int edge){
		this.edge3 = edge;
	}
	
	//get
	public int getEdge1(){
		return this.edge1;
	}
	
	public int getEdge2(){
		return this.edge2;
	}
	
	public int getEdge3(){
		return this.edge3;
	}
}