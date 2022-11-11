package lotto.validation;

import java.util.Arrays;
import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class LottoValidation {
    public static boolean isLottoInputNumeric(String[] splitString, IntConstant asciiBiggerThan, IntConstant asciiSmallerThan) {
        return Arrays.stream(splitString).allMatch(
                digitString -> IntegerValidation.isNumeric(digitString, asciiBiggerThan, asciiSmallerThan));
    }

    public static boolean isLottoInputLength(String[] splitString, IntConstant length) {
        return splitString.length == length.getValue();
    }

    public static boolean isLottoInputBetween(String[] splitString, IntConstant valueBiggerThan, IntConstant valueSmallerThan) {
        return Arrays.stream(splitString).allMatch(
                digitString -> IntegerValidation.isBetween(digitString, valueBiggerThan, valueSmallerThan));

    }
}
