package lotto.service;

import lotto.model.Money;

public class GameService {
    private Money userMoney;

    public GameService() {

    }

    public void createMoney(String userInput) {
        this.userMoney = Money.from(userInput);
    }
}
