package pkgc;

import pkga.Vehicle;

public class Jeep extends Vehicle{
	public void start(){
		super.start("吉普車發動中..");
	}
	public void break_(){
		super.break_("吉普車煞車中..");
	}
}
