package lotto;

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
        long count = numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return changeToLottoResult(bonusNumber, count);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != 6;
    }

    private LottoResult changeToLottoResult(int bonusNumber, long count) {
        if (count == 3) {
            return LottoResult.THREE;
        }

        if (count == 4) {
            return LottoResult.FOUR;
        }

        if (count == 5) {
            if (numbers.contains(bonusNumber)) {
                return LottoResult.FIVE_WITH_BONUS;
            }
            return LottoResult.FIVE;
        }

        if (count == 6) {
            return LottoResult.SIX;
        }
        return LottoResult.ELSE;
    }
}
