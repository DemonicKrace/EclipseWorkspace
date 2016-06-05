package hw13;

public class hw13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CCalculator obj1 = new CCalculator();
		CCalculator_ obj1 = new CCalculator_();
        double a,b;
        a=Math.random()*20;
        b=Math.random()*10;
        
        System.out.println(a + " Add " + b + " = " +obj1.Add(a,b));
        System.out.println(a + " Sub " + b + " = " +obj1.Sub(a,b));
        System.out.println(a + " Mul " + b + " = " +obj1.Mul(a,b));
        System.out.println(a + " Div " + b + " = " +obj1.Div(a,b));
              
        System.out.println("log(" + a + ") = "   +obj1.LOG(a));
        System.out.println("ln(" + a + ") = "    +obj1.LN(a));
	}

}