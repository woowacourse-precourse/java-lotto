package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.dto.TotalWinningLottoDto;
import lotto.domain.enums.WinResultStatus;
import lotto.message.ErrorMessage;

public class Lotto {
    public static final int LOTTO_COUNT = 6;
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    public static final int NEED_CHECK_BONUS_NUMBER_COUNT = 5;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER_ERROR);
        }
        if (isOutOfBound(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BOUNDS_LOTTO_NUMBER_ERROR);
        }
    }

    private boolean isDuplicated(final List<Integer> numbers) {
        return LOTTO_COUNT > numbers.stream()
                .distinct()
                .count();
    }

    private boolean isOutOfBound(final List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).get() > MAX_NUMBER
                || numbers.stream().min(Integer::compareTo).get() < MIN_NUMBER;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList())
                .toString();
    }

    public boolean contains(final int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public WinResultStatus getMatchResult(final TotalWinningLottoDto totalWinningLotto) {
        int equalCount = totalWinningLotto.getWinningNumber()
                .getEqualCount(Collections.unmodifiableList(numbers));
        boolean needBonus = false;
        if (equalCount == NEED_CHECK_BONUS_NUMBER_COUNT) {
            BonusNumber bonusNumber = totalWinningLotto.getBonusNumber();
            needBonus = numbers.contains(bonusNumber.getBonusNumber());
        }
        return WinResultStatus.findResult(equalCount, needBonus);
    }

}
