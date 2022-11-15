package lotto.domain;

public class PurchaseAmount {
    private final Integer money;

    public PurchaseAmount(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money == 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_IS_ZERO.getMessage());
        }
        if (money % Lottery.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_IS_NOT_DIVIDE_LOTTERY_PRICE.getMessage());
        }
    }

    public int countLotterySize() {
        return money / Lottery.LOTTO_PRICE;
    }
}
