package lotto.exception;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_LENGTH;
import static lotto.domain.LottoGenerator.LOTTO_NUMBER_MAX_VALUE;
import static lotto.domain.LottoGenerator.LOTTO_NUMBER_MIN_VALUE;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static final String NEED_TO_INPUT_NUMBER = "[ERROR] 숫자를 입력해주세요";
    public static final String NEED_TO_INPUT_NUMBER_CAN_DIVIDE_BY_ONE_THOUSAND =
            "[ERROR] 1000으로 나누어 떨어지는 숫자를 입력해주세요";
    public static final String NEED_TO_INPUT_SIX_NUMBER = "[ERROR] 로또 번호는 6자리를 입력하여야 합니다.";
    public static final String NEED_TO_INPUT_RIGHT_NUMBER_RANGE =
            "[ERROR] 1 이상 45 이하의 숫자를 입력하여야 합니다.";
    public static final String NEED_TO_USE_COMMA = "[ERROR] 콤마(,)를 통해 숫자를 구분해주세요";
    public static final String NEED_TO_NOT_DUPLICATE = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";
    
    public void validateMoney(String money) {
        validateValueIsNumber(money);
        validateValueCanDivideOneThousand(money);
    }

    public void validateWinningNumbers(String input) {
        validateValueUseComma(input);
        List<String> inputValues = Arrays.asList(input.split(","));
        validateNumberOfValue(inputValues);
        inputValues.forEach(this::validateValueIsNumber);
        inputValues.forEach(this::validateValueRange);
    }

    public void validateBonusNumber(String input,
                                    List<Integer> winningNumbers) {
        validateValueIsNumber(input);
        validateValueRange(input);
        validateValueIsDuplicate(input, winningNumbers);
    }

    private void validateValueIsDuplicate(String input, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(NEED_TO_NOT_DUPLICATE);
        }
    }

    private void validateValueIsNumber(String money) {
        if (!money.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NEED_TO_INPUT_NUMBER);
        }
    }

    private void validateValueCanDivideOneThousand(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(NEED_TO_INPUT_NUMBER_CAN_DIVIDE_BY_ONE_THOUSAND);
        }
    }

    private void validateValueUseComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(NEED_TO_USE_COMMA);
        }
    }

    private void validateValueRange(String input) {
        if (isNotRightRangeNumber(input)) {
            throw new IllegalArgumentException(NEED_TO_INPUT_RIGHT_NUMBER_RANGE);
        }
    }

    private boolean isNotRightRangeNumber(String input) {
        int value = Integer.parseInt(input);
        return value > LOTTO_NUMBER_MAX_VALUE || value < LOTTO_NUMBER_MIN_VALUE;
    }

    private void validateNumberOfValue(List<String> inputValues) {
        if (inputValues.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(NEED_TO_INPUT_SIX_NUMBER);
        }
    }
}
