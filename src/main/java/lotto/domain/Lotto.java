package lotto.domain;

import static lotto.domain.LottoConstant.LOTTO_NUMBER_LENGTH;
import static lotto.domain.LottoConstant.LOTTO_NUMBER_MAX_VALUE;
import static lotto.domain.LottoConstant.LOTTO_NUMBER_MIN_VALUE;

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

    public int getNumberOfMatchesByWinningNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean containBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isWrongNumberOfValues(numbers)) {
            throw new IllegalArgumentException("로또 번호의 갯수는 6개여야합니다.");
        }

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호가 중복됩니다.");
        }

        if (isWrongRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하의 정수입니다.");
        }
    }

    private boolean isWrongNumberOfValues(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_LENGTH;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != LOTTO_NUMBER_LENGTH;
    }

    private boolean isWrongRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > LOTTO_NUMBER_MAX_VALUE || number < LOTTO_NUMBER_MIN_VALUE);
    }

}
