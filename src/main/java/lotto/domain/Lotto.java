package lotto.domain;

import lotto.exception.lotto.LottoNumDuplicatedException;
import lotto.exception.lotto.LottoNumRangeException;
import lotto.exception.lotto.LottoNumsSizeException;

import java.util.List;

import static lotto.Validator.*;

public class Lotto {
    public static final int LOTTO_NUMS_SIZE = 6;
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMS_SIZE) {
            throw new LottoNumsSizeException();
        }
        if (!isInRangeAll(numbers)) {
            throw new LottoNumRangeException();
        }
        if (!isNotDuplicate(numbers)) {
            throw new LottoNumDuplicatedException();
        }
    }

    public List<Integer> get() {
        return numbers;
    }

    public int countSameNum(WinningNums winningNums) {
        return (int) numbers.stream()
                .filter(n -> winningNums.getWinningNums().contains(n))
                .count();
    }

    public boolean isContainsBonus(WinningNums winningNums) {
        return numbers.contains(winningNums.getBonusNum());
    }

}
