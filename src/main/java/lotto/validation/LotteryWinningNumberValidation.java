package lotto.validation;

import java.util.List;
import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class LotteryWinningNumberValidation extends Validation{
    @Override
    public void isValidate(String userInput) {
        String[] splitString = userInput.split(",");
        isLottoInputLength(splitString);
        isLottoInputNumeric(splitString);
        isLottoInputBetween(splitString);
    }

    @Override
    public void isValidate(String userInput, List<Integer> compareToUserInput) {

    }

    private void isLottoInputLength(String[] splitString) {
        if (!(LottoValidation.isLottoInputLength(splitString, IntConstant.LOTTO_NUMBER_COUNT))) {
            createError(StringConstant.LOTTO_INPUT_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private void isLottoInputNumeric(String[] splitString) {
        if (!(LottoValidation.isLottoInputNumeric(splitString, IntConstant.ZERO_ASCII_CODE, IntConstant.NINE_ASCII_CODE))) {
            createError(StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }


    private void isLottoInputBetween(String[] splitString) {
        if (!(LottoValidation.isLottoInputBetween(splitString, IntConstant.LOTTO_NUMBER_BIGGER_THAN,
                IntConstant.LOTTO_NUMBER_SMALLER_THAN))) {
            createError(StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }


}
