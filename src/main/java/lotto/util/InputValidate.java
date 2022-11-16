package lotto.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class InputValidate {
    private static final String ERROR_MESSAGE_NOT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_AMOUNT = "[ERROR] 구입 금액은 1000원 단위로 입력할 수 있습니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_WINNING_NUMBER_COUNT = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String ERROR_MESSAGE_NOT_INT_BETWEEN_COMMA = "[ERROR] 각 쉼표 사이에 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NUMBER_DUPLICATE = "[ERROR] 각 숫자는 중복될 수 없습니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_NUMBER_RANGE = "[ERROR] 1~45 사이의 수를 입력해야 합니다.";
    private static final String ERROR_MESSAGE_DUPLICATE_WITH_WINNING = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";


    public InputValidate() {
    }

    public void validateInputAmount(String inputAmount) {
        validateIsNumber(inputAmount);
        validateIsProperAmount(inputAmount);
    }

    public void validateInputWinningNumber(String input) {
        validateElementCount(input);
        validateOnlyNumbers(input);
        validateNotDuplicate(input);
        validateSixNumberRange(input);
    }

    public void validateInputBonusNumber(String inputNumber) {
        validateIsNumber(inputNumber);
        validateNumberRange(inputNumber);
    }

    public void validateBonusNumberNotDuplicate(List<Integer> winningNums, String bonusNumber) {
        int num = Integer.valueOf(bonusNumber);
        if (winningNums.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_WITH_WINNING);
        }
    }

    private void validateElementCount(String input) {
        String[] inputNums = input.split(",");
        if (inputNums.length != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_WINNING_NUMBER_COUNT);
        }
    }

    private void validateOnlyNumbers(String input) {
        String[] inputNums = input.split(",");

        for (String num : inputNums) {
            if (!isNumber(num)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INT_BETWEEN_COMMA);
            }
        }
    }

    private void validateNotDuplicate(String input) {
        String[] inputNums = input.split(",");

        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, inputNums);

        if (set.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_DUPLICATE);
        }
    }

    private void validateSixNumberRange(String input) {
        String[] inputNums = input.split(",");

        for (String num : inputNums) {
            validateNumberRange(num);
        }
    }

    private void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_NUMBER_RANGE);
        }
    }

    private void validateIsNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INT);
        }
    }

    private void validateIsProperAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_AMOUNT);
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_AMOUNT);
        }
    }

    private boolean isNumber(String input) {
        final String REGEX = "[0-9]+";

        if (input.matches(REGEX)) {
            return true;
        }
        return false;
    }

}
