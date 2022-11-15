package lotto.winningnumber;

import lotto.lotto.Lotto;
import lotto.message.ExceptionMessage;
import lotto.setting.WinningNumberSetting;
import java.util.List;

public class WinningNumber {

    private List<Integer> numbers;
    private List<Integer> bonusNumbers;

    public WinningNumber(List<Integer> numbers, List<Integer> bonusNumbers, WinningNumberSetting setting) {
        validate(numbers, bonusNumbers, setting);
        this.numbers = numbers;
        this.bonusNumbers = bonusNumbers;
    }

    private void validate(List<Integer> numbers, List<Integer> bonusNumbers, WinningNumberSetting setting) {
        if (!setting.isValidateNumbers(numbers, bonusNumbers)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_FORM_NOT_MATCHED.toString());
        }
    }

    public int countNumberMatched(Lotto lotto) {
        return (int) numbers.stream()
                .filter(number -> lotto.isInNumbers(number))
                .count();
    }

    public int countBonusNumberMatched(Lotto lotto) {
        return (int) bonusNumbers.stream()
                .filter(number -> lotto.isInNumbers(number))
                .count();
    }
}
