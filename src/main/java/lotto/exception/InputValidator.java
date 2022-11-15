package lotto.exception;

import static lotto.domain.LottoConstant.LOTTO_NUMBER_LENGTH;
import static lotto.domain.LottoConstant.LOTTO_NUMBER_MAX_VALUE;
import static lotto.domain.LottoConstant.LOTTO_NUMBER_MIN_VALUE;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public void validateMoney(String money) {
        validateValueIsNumber(money);
        validateValueCanDivideOneThousand(money);
    }

    public void validateWinningNumbers(String input) {
        validateValueUseComma(input);

        List<String> inputValues = Arrays.asList(input.split(","));
        validateNumberOfValue(inputValues);

        for (String inputValue : inputValues) {
            validateValueIsNumber(inputValue);
            validateValueRange(inputValue);
        }
    }

    public void validateBonusNumber(String input,
                                    List<Integer> winningNumbers) {
        validateValueIsNumber(input);
        validateValueRange(input);
        validateValueIsDuplicate(input, winningNumbers);
    }

    private void validateValueIsDuplicate(String input, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private void validateValueIsNumber(String money) {
        if (!money.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateValueCanDivideOneThousand(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 숫자를 입력해주세요.");
        }
    }

    private void validateValueUseComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("콤마(,)를 통해 숫자를 구분해주세요.");
        }
    }

    private void validateValueRange(String input) {
        if (isNotRightRangeNumber(input)) {
            throw new IllegalArgumentException("1 이상 45 이하의 숫자를 입력하여야 합니다.");
        }
    }

    private boolean isNotRightRangeNumber(String input) {
        int value = Integer.parseInt(input);
        return value > LOTTO_NUMBER_MAX_VALUE || value < LOTTO_NUMBER_MIN_VALUE;
    }

    private void validateNumberOfValue(List<String> inputValues) {
        if (inputValues.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 6자리를 입력하여야 합니다.");
        }
    }
}
