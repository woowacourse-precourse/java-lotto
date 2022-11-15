package domain.Money;

import java.util.regex.Pattern;

public class MoneyController {
    private final static String FORMAT = "^\\d*$";
    private final MoneyService moneyService = new MoneyService();

    public void validateFormat(String purchaseAmount) {
        if (!Pattern.matches(FORMAT, purchaseAmount)) {
            throw new IllegalArgumentException("구매 금액은 공백이 포함되지 않은 자연수 하나만 입력해야 합니다.");
        }
    }

    public Money createMoney(String money) {
        validateFormat(money);
        return moneyService.createMoney(money);
    }

    public int getAvailablePurchaseNumber(Money money) {
        return moneyService.calcAvailablePurchaseNumber(money);
    }
}
