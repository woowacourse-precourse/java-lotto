package lotto.domain;

public class Wallet {

    private static final int TICKET_PRICE = 1000;

    private final int money;

    public Wallet(int money) {
        validateMultiple(money);
        this.money = money;
    }

    public int calculate() {
        return money / TICKET_PRICE;
    }

    private void validateMultiple(int money) {
        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 티켓 가격으로 나누어 떨어지지 않습니다.");
        }
    }
}
