package Info;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class InputException {
    public static void outOfDigitException(String userInput) {
        userInput.chars().forEach(inputIndex -> {
            if (!Character.isDigit(inputIndex)) {
                throw new IllegalArgumentException(PrintGameInfo.getIsNotDigitString());
            }
        });
    }

    public static void emptyException(String userInput) {
        if (userInput == null || userInput.isEmpty() || userInput.isBlank()) {
            throw new IllegalArgumentException(PrintGameInfo.getIsEmptyString());
        }
    }

    /**
     * 로또 숫자 범위 이외의 값 입력을 위한 예외처리
     * @param numbers
     */
    public static void outOfRange(List<String> numbers) {
        numbers.stream().forEach(number -> {
            if (Lotto.isOutOfRange(Integer.valueOf(number))) {
                throw new IllegalArgumentException(PrintGameInfo.getOutOfRange());
            };
        });
    }

    public static void wrongWinningNumberFormat(String winningNumber) {
        List<String> numbers = Arrays.asList(winningNumber.split(","));
        for(String number: numbers) {
            emptyException(number);
            outOfDigitException(number);
        }
        outOfRange(numbers);
    }

    /**
     * 미사용 : 0원에 대해서 예외처리 할지 추후 결정
     * @param amount
     */
    public static void userInputZeroException(String amount) {
        if (checkAllZero(amount)) {
            throw new IllegalArgumentException(PrintGameInfo.USER_INPUT_ZERO);
        }
    }
    public static boolean checkAllZero(String amount) {
        boolean allZero = false;
        for (char digit : amount.toCharArray()) {
            if (PrintGameInfo.ZERO != digit) {
                return false;
            }
        }
        return true;
    }
}
