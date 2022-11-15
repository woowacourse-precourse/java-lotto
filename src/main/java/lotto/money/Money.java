package lotto.money;

import static lotto.constant.Rules.LOTTO_PRICE;

import java.text.DecimalFormat;
import lotto.exception.money.PurchaseMoneyNotDividedByPriceException;
import lotto.exception.money.PurchaseMoneyNotPositiveIntegerException;
import lotto.exception.money.PurchaseMoneyRangeException;

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
            throw new PurchaseMoneyNotPositiveIntegerException();
        }
        int moneyValue = Integer.parseInt(money);
        if (!verifyRange(moneyValue)) {
            throw new PurchaseMoneyRangeException();
        }
        if (!verifyDividedByPrice(moneyValue)) {
            throw new PurchaseMoneyNotDividedByPriceException();
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
