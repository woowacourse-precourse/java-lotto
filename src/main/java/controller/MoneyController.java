package controller;

import domain.Money;
import service.MoneyService;

public class MoneyController {
    MoneyService moneyService = new MoneyService();

    public Money getPurchaseAmount(String purchaseAmount) {
        return moneyService.saveMoney(purchaseAmount);
    }
}
