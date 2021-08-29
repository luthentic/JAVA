class Product {
    int price;			
    int bonusPoint;	

    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price/10.0);	
    }
}

class Tv1 extends Product {
    Tv1() {
      
        super(100);		
    }

    // ObjectŬ������ toString()�� �������̵��Ѵ�.
    public String toString() { return "Tv"; }
}

class Computer extends Product {
    Computer() { super(200); }

    public String toString() { return "Computer"; }
}

class Buyer {	// ��, ������ ��� ���
    int money = 1000;	  // �����ݾ�
    int bonusPoint = 0; // ���ʽ�����

    void buy(Product p) {
        if(money < p.price) {
            System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
            return;
        }

        money -= p.price;            
        bonusPoint += p.bonusPoint;  
        System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
    }
}

class Polymorphism{
    public static void main(String args[]) {
        Buyer b = new Buyer();

        b.buy(new Tv1());
        b.buy(new Computer());

        System.out.println("REMAIN " + b.money + "MONEY");
        System.out.println("YOU GET" + b.bonusPoint + "bonusPoint");
    }
}