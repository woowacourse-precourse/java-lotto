package lotto.validation;

import java.util.List;
import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class BonusLottoValidation extends Validation{
    @Override
    public void isValidate(String userInput) {

    }

    @Override
    public void isValidate(String userInput, List<Integer> compareToUserInput) {
        String[] splitString = userInput.split(",");
        isBonusLottoInputLength(splitString);
        isBonusLottoInputNumeric(splitString);
        isBonusLottoInputBetween(splitString);
        isContainsWinningLotto(splitString[0], compareToUserInput);
    }

    private void isBonusLottoInputLength(String[] splitString) {
        if (!(LottoValidation.isLottoInputLength(splitString, IntConstant.BONUS_LOTTO_NUMBER_COUNT))) {
            createError(StringConstant.BONUS_LOTTO_INPUT_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private void isBonusLottoInputNumeric(String[] splitString) {
        if (!(LottoValidation.isLottoInputNumeric(splitString, IntConstant.ZERO_ASCII_CODE, IntConstant.NINE_ASCII_CODE))) {
            createError(StringConstant.BONUS_LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }

    private void isBonusLottoInputBetween(String[] splitString) {
        if (!(LottoValidation.isLottoInputBetween(splitString, IntConstant.LOTTO_NUMBER_BIGGER_THAN,
                IntConstant.LOTTO_NUMBER_SMALLER_THAN))) {
            createError(StringConstant.BONUS_LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }

    private void isContainsWinningLotto(String bonusLotto, List<Integer> compareToUserInput) {
        int bonus = Integer.parseInt(bonusLotto);
        if (compareToUserInput.contains(bonus)) {
            createError(StringConstant.BONUS_LOTTO_OVERLAPPING_WITH_WINNING_LOTTO_ERROR_MESSAGE.getMessage());
        }
    }

}

