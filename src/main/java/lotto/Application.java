package lotto;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    	int payment = User.getPayment();
    	int purchaseQuantity = payment / Constant.PAYMENT_UNIT.value;

    	Lotto lotto = Lotto.newLotto();
		System.out.println(lotto.getNumbers());
    }
}