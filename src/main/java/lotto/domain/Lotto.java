package lotto.domain;

import lotto.constant.LottoConstants;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {
    private static final String LOTTO_FORMAT = "[{0}, {1}, {2}, {3}, {4}, {5}]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(List<Integer> numbers) {
        //Todo: 메시지 추가
        if (!isRightLength(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!isUnique(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isOverRange(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isUnderRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRightLength(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isUnique(List<Integer> numbers) {
        return numbers.stream().distinct().count() == 6;
    }

    private boolean isOverRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(it -> it > LottoConstants.LOTTO_END_INCLUSIVE.value());
    }

    private boolean isUnderRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(it -> it < LottoConstants.LOTTO_START_INCLUSIVE.value());
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
