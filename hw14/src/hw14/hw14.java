package hw14;

import java.util.Scanner;
import exception.CmyException;

public class hw14 {

	public static void main(String[] args) throws CmyException{
		// TODO Auto-generated method stub
		int x = 0;
		int y = 0;
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.printf("請輸入x:");			
			try {
				x = Integer.parseInt(s.next());
				break;
			} catch(Exception e) {
				System.out.println("x,y請輸入整數");
			}
		}
		
		while(true){
			System.out.printf("請輸入y:");			
			try {
				y = Integer.parseInt(s.next());
				break;
			} catch(Exception e) {
				System.out.println("x,y請輸入整數");
			}
		}
		System.out.printf("%d的 %d次方=%d",x,y,powerXY(2,5));
		/*
		System.out.println("2的 5次方=" +powerXY(2,5));
        System.out.println("2的 0次方=" +powerXY(2,0));
        System.out.println("0的 0次方=" +powerXY(0,0));
        System.out.println("2的 -2次方=" +powerXY(2,-2));
        */
	}
	
	static int powerXY(int x,int y){
		if(x==0&&y==0){
			new CmyException("無定義,回傳值將錯誤");
			return -1;
		}else if(y<0){
			new CmyException("次方為負值,結果不為整數,回傳值將錯誤");
			return -1;
		}
		return (int)Math.pow(x, y);
	}
}
