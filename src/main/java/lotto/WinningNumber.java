package lotto;

import java.util.List;

public class WinningNumber {
    private static final String DUPLICATE_WITH_MAIN_NUMBER = "보너스 번호가 당첨 번호와 중복됩니다.";
    public final Lotto mainNumbers;
    int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        mainNumbers = LottoGenerator.generateByNumberList(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WITH_MAIN_NUMBER);
        }
    }
}
