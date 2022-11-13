package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ConstValue.DIGIT_REGEX;
import static lotto.constant.Message.INVALID_NUMBER_INPUT_FORMAT_MESSAGE;

public class WinningLotto extends Lotto{
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, String inputBonus) {
        super(numbers);
        validate(numbers, inputBonus);
        this.bonusNumber = Integer.parseInt(inputBonus);
    }

    private void validate(List<Integer> numbers, String inputBonus) {
        if (!validateDigit(inputBonus)) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT_FORMAT_MESSAGE);
        }

        if (!validateDuplicate(numbers, inputBonus)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateDigit(String inputBonus) {
        if (Pattern.matches(DIGIT_REGEX, inputBonus)) {
            return false;
        }
        return true;
    }
}
