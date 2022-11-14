package lotto;

import type.LottoGrade;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (validateSizeOf(numbers) || validateBoundOf(numbers) || validateDuplicationOf(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean validateSizeOf(List<Integer> numbers) {
        if (numbers.size() != 6) return true;
        return false;
    }

    private Boolean validateBoundOf(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
    }

    private Boolean validateDuplicationOf(List<Integer> numbers) {
        return numbers.stream()
                .mapToLong(targetNumber -> numbers.stream()
                        .filter(targetNumber::equals)
                        .count())
                .anyMatch(count -> count >= 2);
    }

    public Integer countNumbersIncluded(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public LottoGrade getLottoGrade(Integer numberOfMatches, Boolean containsBonusNumber) {
        if (numberOfMatches == 6) return LottoGrade.FIRST;
        if (numberOfMatches == 5 && containsBonusNumber) return LottoGrade.SECOND;
        if (numberOfMatches == 5) return LottoGrade.THIRD;
        if (numberOfMatches == 4) return LottoGrade.FOURTH;
        if (numberOfMatches == 3) return LottoGrade.FIFTH;
        return LottoGrade.NOTHING;
    }

    public Boolean containsBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
