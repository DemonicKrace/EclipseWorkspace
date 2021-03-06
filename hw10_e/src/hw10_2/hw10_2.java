package hw10_2;

public class hw10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CFlyMachine[] objArr = new CFlyMachine[10];
		int n[];
		
		//(4)-c：仿照(1)-e,f的做法，在main()函式中，
		//建立CFlyMachine的物件陣列objArr，容量為10個物件，
		//並且利用亂數產生物件所需資料，規範如下：
		//速度之值為介於5000~50000的整數。
		//載重量之值為介於10000~40000的整數。
		//類型之值為介於0,1,2,3的整數。
		for(int i = 0; i < 10 ;i++){
			n = makeThreeNum();			
			//System.out.printf("%d,%d,%d\n",n[0],n[1],n[2]);
			objArr[i] = new CFlyMachine(n[0],n[1],n[2]);
		}
		
		//(4)-d：直接利用counter變數，印出有多少架類型為2的飛行器（不得使用迴圈重新計算）。
		System.out.printf("類型為2的飛行器有%d架\n",objArr[0].counter);
		System.out.println("速度     載重量   類型");

		//(4)-e：使用迴圈，讓物件陣列中所有的物件呼叫printData()方法。
		//而printData()方法是一個新增的公用方法，可印出物件的所有資料，
		//若類型為2，則呼叫另一個private等級的print()方法，並印出一行「***多一架***」。
		for(int i = 0;i < 10 ;i++){
			objArr[i].printData();
		}
		
	}
	
	//(1)-e：撰寫一個產生三個亂數的主類別函式int [] makeThreeNum()。三個數存放於陣列中。
		//陣列[0]之值為介於5000~50000的整數。
		//陣列[1]之值為介於10000~40000的整數。
		//陣列[2]之值為介於0~3的整數。
		static int[] makeThreeNum(){
//			speed 5000~50000,carryCapacity 10000~40000,machineType 0~3
			int n1 = (int)(Math.random() * (50000-5000+1)) + 5000;
			int n2 = (int)(Math.random() * (40000-10000+1)) + 10000;
			int n3 = (int)(Math.random() * 4);
			int n[] = {n1,n2,n3};
			return n;
		}

}

class CFlyMachine{
	public int speed;
	public int carryCapacity;
	private int machineType;
	public static int counter; //使用static 使counter資料會只“建立一次”，達到所有CFlyMachine物件共用此變數
	
	//(4)-a：設計一個無參數的建構子，將資料項目皆設為0。
	CFlyMachine(){
		this(0,0,0);
	}
	
	//(4)-b：設計一個包含3個參數的建構子，用來設定除counter之外的3項資料。
	//其中若machineType設定為2，則將counter累加1（您應該思考如何對某一變數累加以便所有物件可共用該變數）。
	CFlyMachine(int speed,int carryCapacity,int machineType){
		this.speed = speed;
		this.carryCapacity = carryCapacity;
		this.machineType = machineType;
		if(machineType == 2){
			this.counter = counter + 1;
		}
	}
	
	//而printData()方法是一個新增的公用方法，可印出物件的所有資料，
	//若類型為2，則呼叫另一個private等級的print()方法，並印出一行「***多一架***」。
	public void printData(){
		System.out.printf("%-5d   %-5d   %-5d\n",this.speed,this.carryCapacity,this.machineType);
		if(this.machineType == 2){
			print();
		}
	}
	
	private void print(){
		System.out.println("***多一架***");
	}
}