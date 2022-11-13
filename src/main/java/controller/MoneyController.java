package controller;

import domain.Money;
import service.MoneyService;

import java.util.regex.Pattern;

public class MoneyController {
    MoneyService moneyService = new MoneyService();
    private final static String FORMAT = "^[0-9]*$";

    public Money getPurchaseAmount(String purchaseAmount) {
        if (!isNumber(purchaseAmount))
            throw new IllegalArgumentException("구매 금액은 숫자여야 합니다.");
        return moneyService.saveMoney(purchaseAmount);
    }

    public int getAvailablePurchaseNumber(Money money) {
        return moneyService.getAvailablePurchaseNumber(money);
    }

    public boolean isNumber(String purchaseAmount) {
        return Pattern.matches(FORMAT, purchaseAmount);
    }
}
