package lotto.model;

import lotto.util.Calculator;

public class Service {

    Player player = new Player();

    public int getLottoAmount(String purchaseAmount) {
        return Calculator.countLottoAmount(purchaseAmount);
    }

}
