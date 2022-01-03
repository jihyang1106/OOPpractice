
public class Buy {

	public static void main(String[] args) {
		Buyer b = new Buyer();  // Buyer Ŭ���� ����
		
//		b.buy(new Tv(500));     // b���������� buy�޼��忡 Tv��ü �ٷ��
//		b.buy(new Computer(200));  // b���������� buy�޼��忡 Computer ��ü �ٷ��
		b.buy(new Audio(400));
		System.out.println("���� ���� ���� " + b.money + "�����Դϴ�.");
		System.out.println("���� ���ε� �ݾ��� " + b.discount + "�����Դϴ�.");

	}
}

class Product {
	int price;      // iv���� ����
	int discount;   // iv���� ����
	
	Product(int price) {
		this.price = price;              // ����
		discount = (int)(price*0.1);     // ���ε� �ݾ�	
	}
}

class Tv extends Product {	
	Tv(int price) {     //Tv ������ 
		super(price);   //������ ������ �״�� ����迭�� Product�� �����ڷ� ���� ���
		System.out.println("Tv�� ������ " + price + "�����Դϴ�.");
	}
	public String toString() { 
		return "Tv"; }  // Tv�� ���ڿ���(object ��ü �������̵�)
}

class Computer extends Product {
	Computer(int price) { //Computer ������
		super(price);
		System.out.println("Computer�� ������ " + price + "�����Դϴ�.");
	}
	public String toString() { return "Computer"; } //Computer�� ���ڿ���(object ��ü �������̵�
}

class Audio extends Product {
	Audio(int price) {
		super(price);
		System.out.println("Audio�� ������ " + price + "�����Դϴ�.");
	}
	public String toString() { return "Audio"; } 
}
class Buyer {
	int money = 1000;  //���� �����ִ� �� ���� ����
	int discount;           //���ε� �ݾ�
	Product[] cart = new Product[10];  // ������ ��ǰ�� �����ϱ� ���� �迭
	
	void buy(Product p) {   //buy�޼��� ���� Product �Ű����� p�� ��ü ����
		if(money < p.price) {  // ���� �����ִ� ������ ��ǰ�� ������ ������ 
			System.out.println("�ܾ��� ������ ������ �� �� �����ϴ�.");
		}
		                        // ���� �����ִ� ���� �� ������
		money = money - p.price - p.discount;       // �����ִ� ������ ��ǰ ���� ����
		discount = p.discount;  // ���αݾ�
		System.out.println(p.toString() + "��/�� �����ϼ̽��ϴ�.");
	}
}