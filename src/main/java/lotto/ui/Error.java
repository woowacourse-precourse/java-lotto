package lotto.ui;

import static lotto.ui.Message.LOTTO_NUMBER_EXCEPTION;
import static lotto.ui.Message.LOTTO_NUMBER_SIZE_EXCEPTION;
import static lotto.ui.Message.NON_DUPLICATED_BONUS_NUMBER_EXCEPTION;
import static lotto.ui.Message.NON_DUPLICATED_LOTTO_NUMBERS_EXCEPTION;
import static lotto.ui.Message.NUMBER_EXCEPTION;
import static lotto.ui.Message.PRICE_EXCEPTION;
import static lotto.ui.Message.SPLIT_BY_COMMA_INPUT_SIZE_EXCEPTION;

public class Error {

    public static String numberException() {
        return NUMBER_EXCEPTION.getValue();
    }

    public static String lottoNumberException() {
        return LOTTO_NUMBER_EXCEPTION.getValue();
    }

    public static String priceException() {
        return PRICE_EXCEPTION.getValue();
    }

    public static String splitByCommaInputSizeException() {
        return SPLIT_BY_COMMA_INPUT_SIZE_EXCEPTION.getValue();
    }

    public static String nonDuplicatedLottoNumbersException() {
        return NON_DUPLICATED_LOTTO_NUMBERS_EXCEPTION.getValue();
    }

    public static String lottoNumberSizeException() {
        return LOTTO_NUMBER_SIZE_EXCEPTION.getValue();
    }

    public static String nonDuplicatedBonusNumberException() {
        return NON_DUPLICATED_BONUS_NUMBER_EXCEPTION.getValue();
    }
}
