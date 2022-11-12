package lotto.controller;

import java.util.List;
import lotto.model.Buyer;
import lotto.view.BuyerView;

public class LottoStoreController {
    private final BuyerView input;

    public LottoStoreController(BuyerView input) {
        this.input = new BuyerView();
    }

    private Buyer createBuyer() {
        int money = input.inputMoney();
        List<Integer> numbers = input.inputNumbers();
        int bonusNumber = input.inputBonusNumber();
        return new Buyer(money, numbers, bonusNumber);
    }
    
}
