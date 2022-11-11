package lotto.ui.dto;

import lotto.util.Validator;

public class LottoPurchasedAmount {

    private final Integer lottoPurchasedAmount;

    public LottoPurchasedAmount(String userInput, Validator validator) {
        validator.validate(userInput);
        this.lottoPurchasedAmount = Integer.parseInt(userInput);
    }

    public Integer getLottoPurchasedAmount() {
        return this.lottoPurchasedAmount;
    }
}
