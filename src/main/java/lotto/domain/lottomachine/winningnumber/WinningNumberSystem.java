package lotto.domain.lottomachine.winningnumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.lottomachine.messages.DomainErrorMessage.BONUS_NUMBER_DUPLICATION;

public class WinningNumberSystem {
    private static final String COMMA = ",";

    private WinningNumberSystem() {
    }

    public static WinningNumberSystem getInstance() {
        return new WinningNumberSystem();
    }

    public WinningNumbers createWinningNumbers(String input) {
        List<WinningNumber> numbers = makeWinningNumbers(input);
        return WinningNumbers.from(numbers);
    }

    private List<WinningNumber> makeWinningNumbers(String input) {
        return Arrays.stream(input.split(COMMA))
                .mapToInt(Integer::parseInt)
                .mapToObj(WinningNumber::from)
                .collect(Collectors.toList());
    }

    public WinningNumber creativeBonusNumber(String input, WinningNumbers winningNumbers) {
        int number = convertToInt(input);
        validateDuplication(number, winningNumbers);
        return WinningNumber.from(number);
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
    }

    private void validateDuplication(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }
}
