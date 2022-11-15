package lotto.domain.lottomachine.winningnumber;

import java.util.List;

import static lotto.domain.lottomachine.messages.DomainErrorMessage.WINNING_NUMBERS_DUPLICATION;


public class WinningNumbers {
    private final List<WinningNumber> winningNumbers;

    private WinningNumbers(List<WinningNumber> winningNumbers) {
        validateDuplication(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(List<WinningNumber> winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    private void validateDuplication(List<WinningNumber> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATION.getMessage());
        }
    }

    private boolean hasDuplication(List<WinningNumber> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    public boolean contains(int number) {
        return winningNumbers.stream()
                .anyMatch(winningNumber -> winningNumber.isSameValue(number));
    }

    public String countSameValue(List<Integer> numbers) {
        long count = winningNumbers.stream()
                .filter(winningNumber -> numbers.stream()
                        .anyMatch(winningNumber::isSameValue))
                .count();
        return convertToString(count);
    }

    private String convertToString(Long count) {
        return String.valueOf(count);
    }
}
