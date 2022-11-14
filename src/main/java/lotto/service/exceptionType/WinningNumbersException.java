package lotto.service.exceptionType;

import java.util.Arrays;

public class WinningNumbersException {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String EXCEPTION_WITH_NOT_SIX_ITEMS_MESSAGE = " \',\'를 기준으로 6개의 항목을 입력해야합니다.";
    private static final String BLANK_EXCEPTION_MESSAGE = " 당첨 번호에 공백은 존재할 수 없습니다.";
    private static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = " 중복된 당첨 번호가 존재합니다.";
    public void checkIfTheWinningNumbersHasSixCharactersBasedOnTheConma(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        if (numbers.length != 6) {
            System.out.println(ERROR_MESSAGE + EXCEPTION_WITH_NOT_SIX_ITEMS_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void checkForSpacesInWinningNumbers(String winningNumbers) {
        if (winningNumbers.contains(" ")) {
            System.out.println(ERROR_MESSAGE + BLANK_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void checkForDupliCateWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        if (numbers.length != Arrays.stream(numbers).distinct().count()){
            System.out.println(ERROR_MESSAGE + DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
