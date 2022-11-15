package lotto.domain.validator;

import lotto.util.ErrorMessages;

public class PriceValidator {
    private static final int REF_MONEY_AMOUNT = 1_000;

    public void validateMoneyInput(String inputValue) {
        if (!inputValue.matches("[0-9]+")) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER_EXIST.getMessage());
        }
        if (inputValue.contains(",")){
            inputValue = inputValue.replace(",","");
        }
        long inputMoney = Long.parseLong(inputValue);
        checkingPurchasable(inputMoney);
        checkingDividable(inputMoney);
    }

    public void checkingPurchasable(long inputMoney) {
        if (inputMoney < REF_MONEY_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessages.BELOW_THE_PRICE_THRESHOLD.getMessage());
        }
    }

    public void checkingDividable(long inputMoney) {
        if ((inputMoney % REF_MONEY_AMOUNT) != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNDIVIDED.getMessage());
        }
    }

}
