package lotto.winningnumber;

import lotto.message.ExceptionMessage;
import lotto.setting.WinningNumberSetting;
import java.util.List;

public class WinningNumber {

    private List<Integer> numbers;
    private List<Integer> bonusNumbers;

    WinningNumber(List<Integer> numbers, List<Integer> bonusNumbers, WinningNumberSetting setting) {
        validate(numbers, bonusNumbers, setting);
        this.numbers = numbers;
        this.bonusNumbers = bonusNumbers;
    }

    private void validate(List<Integer> numbers, List<Integer> bonusNumbers, WinningNumberSetting setting) {
        if (!setting.isValidateNumbers(numbers, bonusNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_FORM_NOT_MATCHED.toString());
        }
    }
}
