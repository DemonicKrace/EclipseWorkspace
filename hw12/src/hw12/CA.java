package hw12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CA{
	List<Integer> prime = new ArrayList<>();
	
	CA(){
		prime.add(2);
	}
	
	void prime(final int x){
		for(int i = 3;i < x ;i++){
			boolean isPrime = true;
			for(int j = 0 ; j < prime.size();j++){
				if(i%prime.get(j) == 0){
					isPrime = false;
				}
			}
			if(isPrime){
				prime.add(i);
			}
		}
		System.out.printf("prime(%d) was set!\n",x);
	}
}

class CB extends CA{
	void output(){
		for(int i = 0 ; i < super.prime.size() ; i++){
			System.out.println(super.prime.get(i));
		}
	}
}