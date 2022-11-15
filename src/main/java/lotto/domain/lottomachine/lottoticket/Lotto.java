package lotto.domain.lottomachine.lottoticket;

import lotto.domain.lottomachine.winningnumber.WinningNumber;
import lotto.domain.lottomachine.winningnumber.WinningNumbers;

import java.util.List;

import static lotto.domain.lottomachine.messages.DomainErrorMessage.LESS_THAN_SIZE_OF_SIX;
import static lotto.domain.lottomachine.messages.DomainErrorMessage.LOTTO_NUMBERS_DUPLICATION;

public class Lotto {
    private static final String FIVE_COUNT = "5";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNotSizeSix(numbers)) {
            throw new IllegalArgumentException(LESS_THAN_SIZE_OF_SIX.getMessage());
        }
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION.getMessage());
        }
    }

    private boolean isNotSizeSix(List<Integer> numbers) {
        return numbers.size() != LottoTicketSystem.COUNT;
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    public String countNumbersConsistentWith(WinningNumbers winningNumbers, WinningNumber bonusNumber) {
        String count = winningNumbers.countSameValue(numbers);
        if (isFive(count)) {
            return count + bonusNumber.checkSameValue(numbers);
        }
        return count;
    }

    private boolean isFive(String number) {
        return number.equals(FIVE_COUNT);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
