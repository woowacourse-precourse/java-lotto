package lotto.domain;

public class Payment {
    private static final int LOTTO_PRICE = 1000;
    
    private final int payment;
    
    public Payment(final int payment) {
        this.payment = payment;
    }
    
    public int countOfPurchasedLotto() {
        return payment / LOTTO_PRICE;
    }
}
