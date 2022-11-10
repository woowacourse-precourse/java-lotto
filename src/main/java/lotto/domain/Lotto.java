package lotto.domain;

import static lotto.domain.LottoGenerator.LOTTO_NUMBER_LENGTH;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    public LottoResult result(List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return changeToLottoResult(bonusNumber, matchCount);
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
        return new HashSet<>(numbers).size() != 6;
    }

    private LottoResult changeToLottoResult(int bonusNumber, long matchCount) {
        if (matchCount == 3) {
            return LottoResult.THREE;
        }

        if (matchCount == 4) {
            return LottoResult.FOUR;
        }

        if (matchCount == 5) {
            if (numbers.contains(bonusNumber)) {
                return LottoResult.FIVE_WITH_BONUS;
            }
            return LottoResult.FIVE;
        }

        if (matchCount == 6) {
            return LottoResult.SIX;
        }
        return LottoResult.ELSE;
    }
}
