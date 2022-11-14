package lotto.exception;

public class InputNumbers extends CommonException {

    private static void checkNumberCount(String numbers) {
        String onlyNumber = numbers.replaceAll("[^0-9]", "");

        if (onlyNumber.length() < 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE_NOT_SIX.getMessage());
        }
    }
}