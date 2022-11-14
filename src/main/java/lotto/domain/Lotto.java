package lotto.domain;

import lotto.constant.LottoConstants;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 하나의 로또를 담당하는 클래스
 */
public final class Lotto {
    private static final String NULL_MESSAGE = "숫자들이 null 입니다";
    private static final String INCORRECT_LENGTH_MESSAGE = "숫자는 6개가 들어와야 합니다";
    private static final String DUPLICATE_MESSAGE = "숫자에 중복이 있습니다";
    private static final String OVER_RANGE_MESSAGE = "로또에는 " +
            LottoConstants.LOTTO_END_INCLUSIVE.value() + "보다 큰 숫자가 올 수 없습니다";
    private static final String UNDER_RANGE_MESSAGE = "로또에는 " +
            LottoConstants.LOTTO_END_INCLUSIVE.value() + "보다 큰 숫자가 올 수 없습니다";
    private static final String LOTTO_FORMAT = "[{0}, {1}, {2}, {3}, {4}, {5}]";
    private final List<Integer> numbers;

    /**
     * 숫자들을 받고, 그 숫자로 로또를 만들 수 없으면 IEA 예외가 발생함
     *
     * @param numbers 1부터 45이하 숫자 6개
     */
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

    /**
     * 원하는 출력의 형태로 만들어준다
     *
     * @return [1, 2, 3, 4, 5, 6] 형태의 String
     */
    public String toPrintableFormat() {
        return MessageFormat.format(LOTTO_FORMAT, numbers.toArray());
    }

    /**
     * 로또 안에 특정 숫자가 있는지를 검사한다
     *
     * @param number 비교를 위한 숫자
     * @return 포함되어 있는지 여부 포함되어 있다면 true
     */
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    /**
     * 로또 안에 보너스 넘버가 포함되어 있는지를 검사하는 메서드
     *
     * @param bonus 비교를 원하는 보너스 넘버
     * @return 포함되어 있는지 여부 포함되어 있다면 true
     */
    public boolean contains(BonusNumber bonus) {
        return numbers.stream()
                .anyMatch(bonus::isBonusNumber);
    }

    /**
     * 다른 로또와 겹치는 숫자가 몇 개인지를 반환한다
     *
     * @param other 비교를 원하는 다른 로또
     * @return 일치한 만큼의 숫자 int 값
     */
    public int calculateTotalSameCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }
}
