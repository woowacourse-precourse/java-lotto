package lotto.exception;

import java.util.stream.Stream;

public class InputNumbers extends CommonException {

    public static void checkException(String numbers) {
        checkNumberCount(numbers);
        checkSeparationByComma(numbers);
        Stream.of(numbers.split(",")).forEach(CommonException::checkInteger);
    }

    private static void checkSeparationByComma(String numbers) {
        long count = numbers.chars().filter(c -> c == ',').count();

        if (count != 5) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_NOT_SEPARATED_BY_COMMA.getMessage());
        }
    }

    private static void checkNumberCount(String numbers) {
        String onlyNumber = numbers.replaceAll("[^0-9]", "");

        if (onlyNumber.length() < 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE_NOT_SIX.getMessage());
        }
    }
}