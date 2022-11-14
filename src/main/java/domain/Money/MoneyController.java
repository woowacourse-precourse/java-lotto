package domain.Money;

import MoneyService;

import java.util.regex.Pattern;

public class MoneyController {
    private final static String FORMAT = "^[0-9]*$";
    private final MoneyService moneyService = new MoneyService();

    public Money getPurchaseAmount(String purchaseAmount) {
        isNumber(purchaseAmount);
        return moneyService.saveMoney(purchaseAmount);
    }

    public int getAvailablePurchaseNumber(Money money) {
        return moneyService.getAvailablePurchaseNumber(money);
    }

    public void isNumber(String purchaseAmount) {
        if (!Pattern.matches(FORMAT, purchaseAmount)) {
            throw new IllegalArgumentException("구매 금액은 숫자여야 합니다.");
        }
    }
}
