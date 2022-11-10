package lotto.validation;

import java.util.Arrays;
import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class LotteryWinningNumberValidation extends Validation{
    @Override
    public void isValidate(String userInput) {
        String[] splitString = userInput.split(",");
        isLottoInputLength(splitString, IntConstant.LOTTO_NUMBER_COUNT.getValue());
        isLottoInputNumeric(splitString, IntConstant.ZERO_ASCII_CODE.getValue(),
                IntConstant.NINE_ASCII_CODE.getValue());
        isLottoInputBetween(splitString, IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue(),
                IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue());
    }

    private void isLottoInputNumeric(String[] splitString, int biggerThan, int smallerThan) {
        IntegerValidation integerValidation = new IntegerValidation();
        Arrays.stream(splitString)
                .filter(digitString -> !(integerValidation.isNumeric(digitString, biggerThan, smallerThan)))
                .map(digitString -> StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage())
                .forEach(this::createError);
    }


    private void isLottoInputLength(String[] splitString, int length) {
        if (!(splitString.length == length)) {
            createError(StringConstant.LOTTO_INPUT_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private void isLottoInputBetween(String[] splitString, int biggerThan, int smallerThan) {
        IntegerValidation integerValidation = new IntegerValidation();
        Arrays.stream(splitString)
                .filter(digitString -> !(integerValidation.isBetween(digitString, biggerThan, smallerThan)))
                .map(digitString -> StringConstant.LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage())
                .forEach(this::createError);
    }


}
