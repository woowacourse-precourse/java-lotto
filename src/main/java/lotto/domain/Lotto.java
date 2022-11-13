package lotto.domain;

import lotto.constant.LottoConstants;

import java.text.MessageFormat;
import java.util.List;

final class Lotto {
    private static final String LOTTO_FORMAT = "[{0}, {1}, {2}, {3}, {4}, {5}]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isRightLength(numbers);
        isUnique(numbers);
        isInRange(numbers);
    }

    private void isRightLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(List<Integer> numbers) {
        numbers.forEach(this::isInLottoSize);
    }

    private void isInLottoSize(int number) {
        if (LottoConstants.LOTTO_START_INCLUSIVE.value() > number) {
            throw new IllegalArgumentException();
        }
        if (LottoConstants.LOTTO_END_INCLUSIVE.value() < number) {
            throw new IllegalArgumentException();
        }
    }

    public String getLottoPrinting() {
        return MessageFormat.format(LOTTO_FORMAT, numbers.toArray());
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean contains(BonusNumber bonus) {
        for (int number : numbers) {
            if (bonus.isBonusNumber(number)) {
                return true;
            }
        }
        return false;
    }

    public int getScore(Lotto other) {
        return numbers.stream()
                .reduce(0,
                        (total, number) -> total + calculateScore(number, other));
    }

    private int calculateScore(int number, Lotto other) {
        if (other.contains(number)) {
            return 1;
        }
        return 0;
    }
}
