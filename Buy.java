
public class Buy {

	public static void main(String[] args) {
		Buyer b = new Buyer();  // Buyer 클래스 생성
		
//		b.buy(new Tv(500));     // b참조변수로 buy메서드에 Tv객체 다루기
//		b.buy(new Computer(200));  // b참조변수로 buy메서드에 Computer 객체 다루기
		b.buy(new Audio(400));
		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("현재 할인된 금액은 " + b.discount + "만원입니다.");

	}
}

class Product {
	int price;      // iv변수 생성
	int discount;   // iv변수 생성
	
	Product(int price) {
		this.price = price;              // 가격
		discount = (int)(price*0.1);     // 할인된 금액	
	}
}

class Tv extends Product {	
	Tv(int price) {     //Tv 생성자 
		super(price);   //가격이 들어오면 그대로 조상배열인 Product의 생성자로 가서 계산
		System.out.println("Tv의 가격은 " + price + "만원입니다.");
	}
	public String toString() { 
		return "Tv"; }  // Tv를 문자열로(object 객체 오버라이딩)
}

class Computer extends Product {
	Computer(int price) { //Computer 생성자
		super(price);
		System.out.println("Computer의 가격은 " + price + "만원입니다.");
	}
	public String toString() { return "Computer"; } //Computer를 문자열로(object 객체 오버라이딩
}

class Audio extends Product {
	Audio(int price) {
		super(price);
		System.out.println("Audio의 가격은 " + price + "만원입니다.");
	}
	public String toString() { return "Audio"; } 
}
class Buyer {
	int money = 1000;  //내가 갖고있는 돈 개수 저장
	int discount;           //할인된 금액
	Product[] cart = new Product[10];  // 구입한 제품을 저장하기 위한 배열
	
	void buy(Product p) {   //buy메서드 생성 Product 매개변수 p로 객체 생성
		if(money < p.price) {  // 내가 갖고있는 돈보다 제품의 가격이 높으면 
			System.out.println("잔액이 부족해 물건을 살 수 없습니다.");
		}
		                        // 내가 갖고있는 돈이 더 많으면
		money = money - p.price - p.discount;       // 갖고있는 돈에서 제품 가격 빼기
		discount = p.discount;  // 할인금액
		System.out.println(p.toString() + "을/를 구입하셨습니다.");
	}
}