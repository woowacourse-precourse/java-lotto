package lotto.domain;

public class Wallet {

    private static final int TICKET_PRICE = 1000;

    private final int money;

    public Wallet(int money) {
        validate(money);
        this.money = money;
    }

    public int calculate() {
        return money / TICKET_PRICE;
    }

    private void validate(final int money) {
        validateNormal(money);
        validateDividedByTicketPrice(money);
    }

    private void validateNormal(final int money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException("[ERROR] 입력된 구입 금액이 티켓 가격보다 작습니다.");
        }
    }

    private void validateDividedByTicketPrice(int money) {
        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 티켓 가격으로 나누어 떨어지지 않습니다.");
        }
    }
}
