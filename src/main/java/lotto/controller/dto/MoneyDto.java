package lotto.controller.dto;

import lotto.controller.validator.MoneyValidator;

public class MoneyDto implements Dto {

    private final int money;

    public MoneyDto(String money) {
        validateInput(money, MoneyValidator.values());
        this.money = Integer.parseInt(money);
    }

    public int getMoney() {
        return money;
    }
}
