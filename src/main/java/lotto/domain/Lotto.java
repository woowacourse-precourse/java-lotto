package lotto.domain;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_LENGTH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    //numbers의 불변을 유지하기 위해 Collections.unmodifiableList를 통해 반환
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public long compareWinningNumbers(List<Integer> winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != LOTTO_NUMBER_LENGTH;
    }

}
