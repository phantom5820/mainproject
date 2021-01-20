package practiceday19;

public abstract class Shape {
	double area;
	
	
	abstract void showArea(double w, double h);
	
	//final(상수) 키워드를 넣은이유 : 자식클래스에서 재정의 하는것을 막기 위해서, 즉, 사용만 하기 위한 목적이다
	final void function() {
		System.out.println("추상클래스의 일반 메서드 입니다.");
	}
}



class Rect extends Shape{

	@Override
	void showArea(double w, double h) {
		area = w*h;
		System.out.println("넓이 : "+area + "cm²");
	}
	
	
}

class Tri extends Shape{

	@Override
	void showArea(double w, double h) {
	area = (w*h) / 2;
	System.out.println("넓이 : " + area + "cm²");

	}
	
	
	
}