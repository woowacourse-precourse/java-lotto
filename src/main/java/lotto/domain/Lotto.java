package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.constants.enums.WinResultStatus;
import lotto.constants.messages.ExceptionMessage;
import lotto.constants.utils.MessageFormatUtil;

public class Lotto {
    public static final int LOTTO_COUNT = 6;
    public static final int ONE = 1;
    public static final int HIT_THREE = 3;
    public static final int HIT_FIVE = 5;
    public static final int SECOND_PLACE_COUNT = 7;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.NUMERIC_LENGTH);
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctNumbers.size() != LOTTO_COUNT;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public String createMessage() {
        // TODO 리팩토링
        StringBuilder lottoResult = new StringBuilder();
        lottoResult.append(MessageFormatUtil.START_BRACKET);
        numbers.stream()
                .sorted(Integer::compareTo)
                .forEach(number -> lottoResult.append(number)
                        .append(MessageFormatUtil.COMMA)
                        .append(MessageFormatUtil.SPACE));
        return lottoResult.delete(lottoResult.lastIndexOf(MessageFormatUtil.COMMA),
                        lottoResult.lastIndexOf(MessageFormatUtil.SPACE) + ONE)
                .append(MessageFormatUtil.END_BRACKET)
                .toString();
    }

    public WinResultStatus getWinResult(WinningNumber winningNumber) {
        int hitCount = getHitCount(winningNumber.getNumbers());
        if (hitCount < HIT_THREE) {
            return WinResultStatus.NOTHING;
        }
        return convertHitCountToWinResult(hitCount, winningNumber);
    }

    private WinResultStatus convertHitCountToWinResult(int hitCount, WinningNumber winningNumber) {
        if (isSecondPlace(hitCount, winningNumber)) {
            return WinResultStatus.getWinResultStatus(SECOND_PLACE_COUNT);
        }
        return WinResultStatus.getWinResultStatus(hitCount);
    }

    private int getHitCount(List<Integer> winningLotto) {
        return (int) numbers.stream()
                .filter(buyNumber -> winningLotto.stream()
                        .anyMatch(Predicate.isEqual(buyNumber)))
                .count();
    }

    private boolean isSecondPlace(int hitCount, WinningNumber winningNumber) {
        return hitCount == HIT_FIVE && numbers.contains(winningNumber.getBonusNumber());
    }
}
