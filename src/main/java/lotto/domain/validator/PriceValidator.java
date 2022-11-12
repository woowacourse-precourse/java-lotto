package lotto.domain.validator;

import lotto.util.ErrorMessages;

public class PriceValidator {
    private static final int MINIMUM_MONEY = 1_000 ;

//    public void validateMoneyInput(String inputValue){
//        final int INPUT_MONEY = Integer.parseInt(inputValue.replace(",",""));
//    }

    public void checkingPurchasable(int inputMoney){
        if (inputMoney < MINIMUM_MONEY){
            throw new IllegalArgumentException(ErrorMessages.BELOW_THE_PRICE_THRESHOLD.getMessage());
        }
    }

}
