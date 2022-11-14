package system.process.validation;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;

public class BuyingValidation {
    public static void validateAmountPaidInput(String amountPaidInput) {
        if (amountPaidInput.contains(",")) {
            IllegalArgument.handleException(IllegalArgument.NOT_DIGIT_TEXT.getMessage());
        }

        if (amountPaidInput.length() > LottoConstant.MAX_AMOUNT_PAID_LENGTH) {
            IllegalArgument.handleException(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage());
        }
    }

    public static void validateAvailableAmount(int amountPaid) {
        if (amountPaid > LottoConstant.MAX_AMOUNT_PAID || amountPaid < LottoConstant.LOTTO_PRICE) {
            IllegalArgument.handleException(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage());
        }

        if (amountPaid % LottoConstant.LOTTO_PRICE != 0) {
            IllegalArgument.handleException(IllegalArgument.NOT_DIVISION.getMessage());
        }
    }
}
