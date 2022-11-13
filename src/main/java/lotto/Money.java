package lotto;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private final long money;

    public Money(long money) {
        this.money = money;
        validate();
    }

    private void validate() {
        validateNotNegative();
        validateMultipleOfLottoPrice();
    }

    private void validateNotNegative() {
        if (money < 0) {
            System.out.println("[ERROR] 구입 금액은 0보다 작을 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateMultipleOfLottoPrice() {
        if (money % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public long getMoney() {
        return money;
    }

    public long countPurchasable(int price) {
        return money / price;
    }
}
