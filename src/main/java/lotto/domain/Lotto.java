package lotto.domain;

import static lotto.domain.Constants.Lotto.SIZE;

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
            throw new IllegalArgumentException("[ERROR] 로또는 숫자가 6개이어야 합니다.");
        }
    }

    private void validateDuplicates(List<LottoNumber> numbers) {
        Set<LottoNumber> nonDuplicatesNumbers = new HashSet<>(numbers);
        if (nonDuplicatesNumbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
}