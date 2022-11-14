package lotto;

public class Money {
    private Long money;

    public Money(String money) {
        this.money = getPurchaseAmount(money);
    }

    private Long getPurchaseAmount(String money) {
        validate(money);
        return Long.parseLong(money);
    }

    private void validate(String money) {
        if (!money.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }

        int digitPurchaseAmount = Integer.parseInt(money);
        if (digitPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위로 입력 할 수 있습니다.");
        }
    }

    public Long getMoney() {
        return money;
    }
}
