package hw11;

import java.util.Scanner;

public class hw11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPersonAccount obj = new CPersonAccount();
    	char runFunc='d';
        Scanner scan = new Scanner(System.in);   
        
        while(runFunc!='q')
        {
          System.out.print("請選擇作業");
          System.out.print("(i=輸入資料 s=依月薪資排序 d=顯示資料 q=離開):");
          runFunc = scan.next().charAt(0);
          switch (runFunc)
          {
            case 'i':
               obj.inputData();
               break;            
            case 's':
               obj.sortBySalary();
               break;
            case 'd':
               obj.displayData();
               break;
           default:
               break;
          }
        }

	}

}
