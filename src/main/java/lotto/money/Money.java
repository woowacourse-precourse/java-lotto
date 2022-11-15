package lotto.money;

import static lotto.constant.Rules.LOTTO_PRICE;

import java.text.DecimalFormat;
import lotto.exception.money.MoneyNotDividedByPriceException;
import lotto.exception.money.MoneyNotPositiveIntegerException;
import lotto.exception.money.MoneyRangeException;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public static Money createPurchaseMoney(String money) {
        validate(money);
        return new Money(Integer.parseInt(money));
    }

    private static void validate(String money) {
        if (!verifyPositiveInteger(money)) {
            throw new MoneyNotPositiveIntegerException();
        }
        int moneyValue = Integer.parseInt(money);
        if (!verifyRange(moneyValue)) {
            throw new MoneyRangeException();
        }
        if (!verifyDividedByPrice(moneyValue)) {
            throw new MoneyNotDividedByPriceException();
        }
    }

    private static boolean verifyPositiveInteger(String money) {
        return money != null && money.matches("^[1-9]\\d*");
    }

    private static boolean verifyRange(int money) {
        return money >= LOTTO_PRICE;
    }

    private static boolean verifyDividedByPrice(int money) {
        return money % LOTTO_PRICE == 0;
    }

    public int calculateLottoCount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(this.money) + "원";
    }
}
