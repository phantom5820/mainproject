package tms;

import java.util.Random;

public class Bus extends Public{
	int fee = 1200;
	
	@Override
	int pay(int money) {
		if(money - fee < 0) {
			System.out.println("잔액이 부족합니다.");
		}else {
			money -= fee;
		}
		return money;
	}
	

	@Override
	void go(int btnIndex, int money) {
		Random r = new Random();
		//출발지와 도착지가 같은지 확인해 주고
		while(true) {
			int index = r.nextInt(arStation.length);
			if(!arStation[btnIndex].equals(arStation[index])) break;
				
			}
			pay(money)
		}
		//정방향인지 역방향인지를 생각해서 for문을 돌아야한다.
	@Override
	void showDestMSG(String destination) {
		System.out.println(destination + "에 도착했습니다.");
	}
	
}


