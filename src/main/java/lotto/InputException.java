package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {
    static final int DIVIDE_NUMBER = 1000;
    static final int COMMA_COUNT = 5;

    public static void isValidNumber(String input) {
        String compare = input.replaceAll("[0-9]", "");
        if (compare.length() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER.printMessage());
        }
    }

    public static void isValidDivide(int input) {
        if (input == 0 || input % DIVIDE_NUMBER != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DIVIDE.printMessage());
        }
    }

    public static void isValidWinningNumberLength(String input) {
        String replaceInput = input.replaceAll(",", "");
        if (input.length() - COMMA_COUNT != replaceInput.length()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LENGTH.printMessage());
        }
        isValidWinningNumber(replaceInput);
        isValidWinningNumberOverlap(input);
    }

    public static void isValidWinningNumber(String replaceInput) {
        String compare = replaceInput.replaceAll("[0-9]", "");
        if (compare.length() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER.printMessage());
        }
    }

    public static void isValidWinningNumberOverlap(String input) {
        int[] winningNumbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> checkOverlap = new HashSet<>();
        for (int i = 0; i < winningNumbers.length; i++) {
            checkOverlap.add(winningNumbers[i]);
        }
        if (winningNumbers.length != checkOverlap.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OVERLAP.printMessage());
        }
        isValidWinningNumberRange(winningNumbers);
    }

    public static void isValidWinningNumberRange(int[] winningNumbers) {
        for (int i = 0; i < winningNumbers.length; i++) {
            if (winningNumbers[i] < 1 || winningNumbers[i] > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE.printMessage());
            }
        }
    }

    public static void isValidWBonusNumber(String input) {
        String compare = input.replaceAll("[0-9]", "");
        if (compare.length() != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER.printMessage());
        }
        isValidWBonusRange(input);
    }

    public static void isValidBonusNumberOverlap(List<Integer> winiingNumber, int bonusNumber) {
        if (winiingNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER_OVERLAP.printMessage());
        }
    }

    public static void isValidWBonusRange(String input) {
        int compare = Integer.valueOf(input);
        if (compare < 1 || compare > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE.printMessage());
        }
    }

    public enum ErrorMessage {
        ERROR_NUMBER("숫자만 입력해 주세요."),
        ERROR_DIVIDE("1000원 단위로 입력해 주세요."),
        ERROR_LENGTH("6자리 숫자와 쉼표로 입력해 주세요."),
        ERROR_OVERLAP("중복되지 않는 숫자를 입력하세요."),
        ERROR_RANGE("1~45 숫자를 입력하세요."),
        ERROR_BONUS_NUMBER_OVERLAP("당첨번호와 중복되지 않는 숫자를 입력하세요.");

        protected final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String printMessage() {
            return "[ERROR] " + message;
        }
    }
}
