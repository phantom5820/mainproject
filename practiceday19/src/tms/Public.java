package tms;

//pay() : 요금을 정산할 수 있는 메서드
public abstract class Public {
	String[]arStation = {"교대","강남","역삼","선릉"};
	
	
	abstract int pay(int money);
	//showDestMSG(String destination): 도착시 "도착지에 도착했습니다." 메세지 출력하는 메서드
	abstract void showDestMSG(String destination);
	
	abstract void go(int btnIndex);
	
	}
