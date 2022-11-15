package lotto.domain;

import java.util.List;

import static lotto.enumtype.LottoValidationMsg.*;

public class LottoWinningNumber {
    private static final int FIX_SIZE = 6;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
