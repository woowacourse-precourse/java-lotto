package domain.Money;

public class MoneyService {
    private final static int UNIT = 1000;
    public Money createMoney(String money) {
        return new Money(Integer.parseInt(money));
    }

    public int calcAvailablePurchaseNumber(Money money) {
        return money.getMoney() / UNIT;
    }
}
