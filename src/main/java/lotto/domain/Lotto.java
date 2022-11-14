package lotto.domain;

import lotto.constant.LottoConstants;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {
    private static final int CONTAINS = 1;
    private static final int NOT_CONTAINS = 0;
    private static final String NULL_MESSAGE = "숫자들이 null 입니다";
    private static final String INCORRECT_LENGTH_MESSAGE = "숫자는 6개가 들어와야 합니다";
    private static final String DUPLICATE_MESSAGE = "숫자에 중복이 있습니다";
    private static final String OVER_RANGE_MESSAGE = "로또에는 " +
            LottoConstants.LOTTO_END_INCLUSIVE.value() + "보다 큰 숫자가 올 수 없습니다";
    private static final String UNDER_RANGE_MESSAGE = "로또에는 " +
            LottoConstants.LOTTO_END_INCLUSIVE.value() + "보다 큰 숫자가 올 수 없습니다";
    private static final String LOTTO_FORMAT = "[{0}, {1}, {2}, {3}, {4}, {5}]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        if (!isRightLength(numbers)) {
            throw new IllegalArgumentException(INCORRECT_LENGTH_MESSAGE);
        }
        if (!isUnique(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
        if (isOverRange(numbers)) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
        if (isUnderRange(numbers)) {
            throw new IllegalArgumentException(UNDER_RANGE_MESSAGE);
        }
    }

    private boolean isRightLength(List<Integer> numbers) {
        return numbers.size() == LottoConstants.LOTTO_LENGTH.value();
    }

    private boolean isUnique(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() == LottoConstants.LOTTO_LENGTH.value();
    }

    private boolean isOverRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(it -> it > LottoConstants.LOTTO_END_INCLUSIVE.value());
    }

    private boolean isUnderRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(it -> it < LottoConstants.LOTTO_START_INCLUSIVE.value());
    }

    public String toPrintableFormat() {
        return MessageFormat.format(LOTTO_FORMAT, numbers.toArray());
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean contains(BonusNumber bonus) {
        return numbers.stream()
                .anyMatch(bonus::isBonusNumber);
    }

    public int calculateTotalSameCount(Lotto other) {
        return numbers.stream()
                .reduce(0,
                        (total, number) -> total + addIfContains(number, other));
    }

    private int addIfContains(int number, Lotto other) {
        if (other.contains(number)) {
            return CONTAINS;
        }
        return NOT_CONTAINS;
    }
}
