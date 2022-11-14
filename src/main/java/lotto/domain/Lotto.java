package lotto.domain;

import static lotto.constant.Constants.ErrorMessage.HAS_DUPLICATED_NUMBERS;
import static lotto.constant.Constants.ErrorMessage.WRONG_SIZE;
import static lotto.constant.Constants.Lotto.SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    public int countSameNumbers(Lotto winningNumbers) {
        int count = 0;
        for (LottoNumber number : numbers) {
            if (winningNumbers.hasNumber(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(WRONG_SIZE);
        }
    }

    private void validateDuplicates(List<LottoNumber> numbers) {
        Set<LottoNumber> nonDuplicatesNumbers = new HashSet<>(numbers);
        if (nonDuplicatesNumbers.size() != SIZE) {
            throw new IllegalArgumentException(HAS_DUPLICATED_NUMBERS);
        }
    }
}