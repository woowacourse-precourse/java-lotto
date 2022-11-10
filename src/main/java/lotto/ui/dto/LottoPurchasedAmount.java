package lotto.ui.dto;

import lotto.util.Validator;

public class LottoPurchasedAmount {

    private final Integer lotteryPurchasedAmount;

    public LottoPurchasedAmount(String userInput, Validator validator) {
        validator.validate(userInput);
        this.lotteryPurchasedAmount = Integer.parseInt(userInput);
    }
}
