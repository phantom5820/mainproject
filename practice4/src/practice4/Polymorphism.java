package practice4;

import java.util.Random;

class Avengers{
   public void fight() {
	   System.out.println("Avengers Assemble!!");
   }
}
class IronMan extends Avengers{
	
	@Override
	public void fight() {
		System.out.println("Beam!");
	}
}
class Thor extends Avengers{
	
	@Override
	public void fight() {
		System.out.println("Thunder from Hammer!");
	}
}
class Hurk extends Avengers{
	@Override
	public void fight() {
		System.out.println("big green monster!");
	}
}
class CaptainAmerica extends Avengers{
	@Override
	public void fight() {
		System.out.println("Throw the SHIELD!");
	}
}
class HawkEye extends Avengers{
	
	@Override
	public void fight() {
		System.out.println("Arrow Bomb!");
	}
}
class BlackWidow extends Avengers{
	@Override
	public void fight() {
		System.out.println("kick and punch!");
	}
}
class Loki extends Avengers{

	@Override
	public void fight() {
		System.out.println("Duplication!");
	}
}


public class Polymorphism {
	
	public boolean WhoAreYou(Avengers a){
		boolean isLoki = true;
		if(a instanceof IronMan) {
			System.out.println("I Am IRONMAN!");
		}else if(a instanceof Thor) {
			System.out.println("I Am Thor");
		}else if(a instanceof CaptainAmerica) {
			System.out.println("I Am CaptainAmerica");
		}else if(a instanceof Hurk) {
			System.out.println("I Am Hurk");
		}else if(a instanceof HawkEye) {
			System.out.println("I Am HawkEye");
		}else if(a instanceof BlackWidow) {
			System.out.println("I Am BlackWidow");
		}else if(a instanceof Loki) {
			isLoki = false;
			System.out.println("We found Loki!");
		}
		else {
			System.out.println("Villain");
		}
		return isLoki;
	}
	
	
	
	public static void main(String[] args) {
		
		Polymorphism p = new Polymorphism();
		Random r = new Random();
		Avengers[] avengers = {
				new IronMan(),
				new Thor(),
				new CaptainAmerica(),
				new Hurk(),
				new HawkEye(),
				new BlackWidow(),
				new Loki()
		};
		
		for (int i = 0; i < 10; i++) {
			int index = r.nextInt(7);
			if(p.WhoAreYou(avengers[index]) == false) break;
			
			try {
				Thread.sleep(500);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
