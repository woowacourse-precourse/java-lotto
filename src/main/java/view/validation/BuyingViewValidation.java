package view.validation;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;

public class BuyingViewValidation {
    public static void validateAmountPaidInput(String amountPaidInput) {
        if (amountPaidInput.contains(",")) {
            IllegalArgument.handleException(IllegalArgument.NOT_DIGIT_TEXT.getMessage());
        }

        if (amountPaidInput.length() > LottoConstant.MAX_AMOUNT_PAID_LENGTH) {
            IllegalArgument.handleException(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage());
        }
    }
}
