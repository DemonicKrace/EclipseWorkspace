package hw11;

import java.util.Scanner;

public class CPersonData {
	public String name;
	public String degree;
	private String p_id;
	private int salary;
	
	CPersonData(){		
		CPersonData("~~~~~~~~","~~~~~~~~","~~~~~~~~",0);
	}
	void CPersonData(final String name,final String degree,final String p_id,final int salary){
		this.name = name;
		this.degree = degree;
		this.p_id = p_id;
		this.salary = salary;
	}
	
	int getSalary(){
		return this.salary;
	}
	
	void setSalary(int salary){
		this.salary = salary;
	}
}

class CPersonAccount{
	private CPersonData[] personArr;
	final int count = 5;
	CPersonAccount(){
		personArr = new CPersonData[count];
		for(int i = 0 ;i < personArr.length ; i++){
			personArr[i] = new CPersonData();
		}
	}
	
	void inputData(){
		Scanner s = new Scanner(System.in);
		for(int i = 0 ;i < personArr.length ; i++ ){
			System.out.printf("請輸入第%d位姓名:",i+1);	
			personArr[i].name = s.next();
			System.out.printf("請輸入第%d位職別:",i+1);
			personArr[i].degree = s.next();
			System.out.printf("請輸入第%d位月薪資:",i+1);	
			personArr[i].setSalary(s.nextInt());
		}
		System.out.println("輸入完畢");
	}
	void displayData(){
		System.out.println("姓名            職別           月薪資");
		for(int i = 0 ;i < personArr.length ; i++ ){
			System.out.printf("%-14s %-14s %d\n",personArr[i].name,personArr[i].degree ,personArr[i].getSalary());
		}
		System.out.println("顯示完畢");
	}
	void sortBySalary(){
		CPersonData tempSalary = new CPersonData();
		for(int i = 0 ;i < personArr.length - 1 ; i++ ){
			for(int j = 0 ;j < personArr.length - 1 - i ; j++ ){		
				if(personArr[j].getSalary() > personArr[j+1].getSalary()){
					tempSalary = personArr[j];
					personArr[j] = personArr[j+1];
					personArr[j+1] = tempSalary;
				}
			}
		}
		System.out.println("排序完畢");
	}
}
