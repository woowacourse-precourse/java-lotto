package lotto;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    	int payment = User.getPayment();
    	int purchaseQuantity = payment / 1000;
    	System.out.println(purchaseQuantity);
    }
}