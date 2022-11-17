package lotto;

import java.util.List;

public class WinningNumber {
    private static final String DUPLICATE_WITH_MAIN_NUMBER = "보너스 번호가 당첨 번호와 중복됩니다.";
    private static final String BONUS_NUMBER_OUT_OF_RANGE = "보너스 번호의 범위가 유효하지 않습니다.";
    public final Lotto mainNumbers;
    int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        mainNumbers = LottoGenerator.generateByNumberList(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (bonusNumber < Lotto.MIN_NUMBER || bonusNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE);
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WITH_MAIN_NUMBER);
        }
    }
}
