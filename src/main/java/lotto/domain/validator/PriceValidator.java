package lotto.domain.validator;

import lotto.util.ErrorMessages;

public class PriceValidator {
    private static final int REF_MONEY_AMOUNT = 1_000 ;

    public void validateMoneyInput(String inputValue){
        try{
            final int inputMoney = Integer.parseInt(inputValue.replace(",",""));
            checkingPurchasable(inputMoney);
            checkingDividable(inputMoney);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER_EXIST.getMessage());
        }

    }

    public void checkingPurchasable(int inputMoney){
        if (inputMoney < REF_MONEY_AMOUNT){
            throw new IllegalArgumentException(ErrorMessages.BELOW_THE_PRICE_THRESHOLD.getMessage());
        }
    }

    public void checkingDividable(int inputMoney){
        if ((inputMoney % REF_MONEY_AMOUNT) != 0){
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNDIVIDED.getMessage());
        }
    }

}
