
public class hw14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
//			checkNumbers(args);
			Amount amount = new Amount();
			amount.main(Integer.parseInt(args[0]));
		}catch(Exception e){
			System.out.println(e.toString());
		}

	}
	
	static public void checkNumbers(String str[]) throws ArrayIndexOutOfBoundsException,ArithmeticException{
		if(str.length < 2){
			throw new ArrayIndexOutOfBoundsException("您的輸入參數不足二個");
		}else if(str.length > 2){
			throw new ArrayIndexOutOfBoundsException("您的輸入參數超過二個");
		}else if(Integer.parseInt(str[1]) == 0){
			throw new ArithmeticException("分母不可為零");
		}else{
			System.out.println("答案：" + (Double.parseDouble(str[0]) / Double.parseDouble(str[1])));
		}
	}

}

class ArrayIndexOutOfBoundsException extends Exception
{
  public ArrayIndexOutOfBoundsException (String msg)
  {
    super(msg);
  }
}

class ArithmeticException extends Exception
{
  public ArithmeticException  (String msg)
  {
    super(msg);
  }
}

class Amount{
	public void main(int x){
		try {
			check(x);
		} catch (AmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void check(int x) throws AmountException{
		if(x > 300){
			System.out.printf("檢查成功，傳入整數為 %d 大於 300\n",x);
		}else{
			throw new AmountException("不行！傳入整數小於 300 ！");
		}
	}
}

class AmountException extends Exception
{
  public AmountException  (String msg)
  {
    super(msg);
  }
}