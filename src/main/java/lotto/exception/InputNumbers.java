package lotto.exception;

public class InputNumbers extends CommonException {

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