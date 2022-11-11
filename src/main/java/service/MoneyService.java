package service;

import domain.Money;

public class MoneyService {
    public Money saveMoney(String purchaseMoney) {
        return new Money(Integer.parseInt(purchaseMoney));
    }

    public int getAvailablePurchaseNumber(Money money) {
        return money.availablePurchases();
    }
}
