package system.process.validation;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;

public class BuyingValidation {
    public static void validateAvailableAmount(int amountPaid) {
        if (amountPaid > LottoConstant.MAX_AMOUNT_PAID || amountPaid < LottoConstant.LOTTO_PRICE) {
            IllegalArgument.handleException(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage());
        }

        if (amountPaid % LottoConstant.LOTTO_PRICE != 0) {
            IllegalArgument.handleException(IllegalArgument.NOT_DIVISION.getMessage());
        }
    }
}
