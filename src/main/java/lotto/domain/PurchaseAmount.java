package lotto.domain;

public class PurchaseAmount {
    private final Integer money;

    public PurchaseAmount(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        isMoneyZero(money);
        isMoneyDivisibleByLottoPrice(money);
    }

    private void isMoneyDivisibleByLottoPrice(int money) {
        if (money % Lottery.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_IS_NOT_DIVIDE_LOTTERY_PRICE.getMessage());
        }
    }

    private void isMoneyZero(int money) {
        if (money == 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_IS_ZERO.getMessage());
        }
    }

    public int countLotterySize() {
        return money / Lottery.LOTTO_PRICE;
    }
}
