package lotto.controller;

import lotto.domain.Money;
import lotto.service.MoneyService;
import view.MoneyView;

public class MoneyController {

    private final MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    public int receiveMoney() {
        Money money = viewUserInput();
        moneyService.saveMoney(money);
        return moneyService.findMoney().getMoney() / 1000;
    }

    private Money viewUserInput() {
        MoneyView moneyView = new MoneyView();
        return moneyView.show();
    }
}
