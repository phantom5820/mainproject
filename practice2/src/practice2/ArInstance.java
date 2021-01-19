package practice2;

import java.util.Scanner;

class Animal{
	String name;
	int age;
	String feed;

	public Animal() {
	}
	
	public Animal(String name, int age, String feed) {
		super();
		this.name = name;
		this.age = age;
		this.feed = feed;
	}

	@Override
	public String toString() {
		return "이름 : "+ name + "\n나이 : " + age + "살\n 먹이 : " + feed;
	}
	
}

public class ArInstance{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Animal[] arAni = new Animal[3];
		String name="";
		int age=0;
		String feed ="";
		
		
		for (int i = 0; i < arAni.length; i++) {
//			arAni[i] = new Animal();
//			
//			System.out.println(i+1+"번 동물의 이름 : ");
			System.out.println(i+1+"번 동물의 이름 : ");
			name = sc.next();
//			System.out.println(arAni[i].name + "의 나이 :");
			System.out.println("나이 :");
			age = sc.nextInt();
//			System.out.println(arAni[i].name + "의 먹이 :");
			System.out.println("먹이 :");
			feed = sc.next();
			arAni[i] = new Animal(name, age, feed);
		
			
		}
		for (int i = 0; i < arAni.length; i++) {
			System.out.println(arAni[i]);
		}
	}
}



