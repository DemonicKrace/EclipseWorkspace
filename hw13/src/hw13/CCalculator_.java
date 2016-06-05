package hw13;

public class CCalculator_ implements IFullCompute{

	public double result;

	//IBasicCompute method
	@Override
	public double Add(double numberA,double numberB) {
		// TODO Auto-generated method stub
		result = numberA + numberB;
		return result;
	}

	@Override
	public double Sub(double numberA,double numberB) {
		// TODO Auto-generated method stub
		result = numberA - numberB;
		return result;
	}

	@Override
	public double Mul(double numberA,double numberB) {
		// TODO Auto-generated method stub
		result = numberA * numberB;
		return result;
	}

	@Override
	public double Div(double numberA,double numberB) {
		// TODO Auto-generated method stub
		if(numberB!=0)
			result = numberA / numberB;
		else
			System.out.println("Error: Divide by Zero!");
		return result;
	}

	//IAdvCompute method
	@Override
	public double LOG(double x) {
		// TODO Auto-generated method stub
		result = Math.log10(x);
		return result;
	}

	@Override
	public double LN(double x) {
		// TODO Auto-generated method stub
		result = Math.log(x);
		return result;
	}
}
