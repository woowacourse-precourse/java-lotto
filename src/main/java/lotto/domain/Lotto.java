package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.constants.enums.WinningResultStatus;
import lotto.constants.messages.ExceptionMessage;
import lotto.constants.utils.MessageFormatUtil;
import lotto.constants.utils.NumberUtil;
import lotto.constants.utils.WinningResultUtil;

public class Lotto {
    public static final int HIT_THREE = 3;
    public static final int HIT_FIVE = 5;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberUtil.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.NUMERIC_LENGTH);
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctNumbers.size() != NumberUtil.LOTTO_NUMBER_COUNT;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public String createMessage() {
        StringBuilder lottoResult = new StringBuilder();
        lottoResult.append(MessageFormatUtil.START_BRACKET);
        appendBuyingLottoMessage(lottoResult);
        deleteLastSeparator(lottoResult);
        lottoResult.append(MessageFormatUtil.END_BRACKET);
        return lottoResult.toString();
    }

    private void appendBuyingLottoMessage(StringBuilder lottoResult) {
        numbers.stream()
                .sorted(Integer::compareTo)
                .forEach(number -> lottoResult.append(number)
                        .append(MessageFormatUtil.COMMA)
                        .append(MessageFormatUtil.SPACE));
    }

    private void deleteLastSeparator(StringBuilder lottoResult) {
        lottoResult.delete(lottoResult.lastIndexOf(MessageFormatUtil.COMMA),
                lottoResult.lastIndexOf(MessageFormatUtil.SPACE) + NumberUtil.ONE);
    }

    public WinningResultStatus getWinningResultStatus(WinningNumber winningNumber) {
        int hitCount = getHitCount(winningNumber.getNumbers());
        if (hitCount < HIT_THREE) {
            return WinningResultStatus.NOTHING;
        }
        return convertHitCountToWinningResultStatus(hitCount, winningNumber);
    }

    private WinningResultStatus convertHitCountToWinningResultStatus(int hitCount, WinningNumber winningNumber) {
        if (isSecondPlace(hitCount, winningNumber)) {
            return WinningResultStatus.getWinningResultStatus(WinningResultUtil.SECOND_PLACE_COUNT);
        }
        return WinningResultStatus.getWinningResultStatus(hitCount);
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
