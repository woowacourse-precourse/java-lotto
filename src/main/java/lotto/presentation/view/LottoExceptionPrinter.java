package lotto.presentation.view;

import constants.ExceptionMessage;

public class LottoExceptionPrinter {

    public static void throwDuplicateNumbers() {
        System.out.println(ExceptionMessage.DUPLICATE_NUMBERS);
    }

    public static void throwWithinRange () {
        System.out.println(ExceptionMessage.WITHIN_RANGE);
    }

    public static void throwMustSixDigit() {
        System.out.println(ExceptionMessage.MUST_SIX_DIGIT);
    }

    public static void throwContainBonus() {
        System.out.println(ExceptionMessage.CONTAIN_BONUS);
    }

    public static void throwIllegalLottoAmount() {
        System.out.println(ExceptionMessage.ILLEGAL_LOTTO_AMOUNT);
    }

    public static void throwMustNumber() {
        System.out.println(ExceptionMessage.MUST_NUMBER);
    }

    public static void throwMustCommaArray() {
        System.out.println(ExceptionMessage.MUST_COMMA_ARRAY);
    }

}
