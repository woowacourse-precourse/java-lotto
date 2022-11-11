package lotto.validation;

import java.util.Arrays;
import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class LotteryWinningNumberValidation extends Validation{
    @Override
    public void isValidate(String userInput) {
        String[] splitString = userInput.split(",");
        isLottoInputLength(splitString, IntConstant.LOTTO_NUMBER_COUNT);
        isLottoInputNumeric(splitString, IntConstant.ZERO_ASCII_CODE,
                IntConstant.NINE_ASCII_CODE);
        isLottoInputBetween(splitString, IntConstant.LOTTO_NUMBER_BIGGER_THAN,
                IntConstant.LOTTO_NUMBER_SMALLER_THAN);
    }

    private void isLottoInputLength(String[] splitString, IntConstant length) {
        if (!(LottoValidation.isLottoInputLength(splitString, length))) {
            createError(StringConstant.LOTTO_INPUT_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private void isLottoInputNumeric(String[] splitString, IntConstant asciiBiggerThan, IntConstant asciiSmallerThan) {
        if (!(LottoValidation.isLottoInputNumeric(splitString, asciiBiggerThan, asciiSmallerThan))) {
            createError(StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }


    private void isLottoInputBetween(String[] splitString, IntConstant valueBiggerThan, IntConstant valueSmallerThan) {
        if (!(LottoValidation.isLottoInputBetween(splitString, valueBiggerThan, valueSmallerThan))) {
            createError(StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }


}
