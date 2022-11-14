package lotto.domain.lottomachine.winningnumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberSystem {

    private WinningNumberSystem() {
    }

    public static WinningNumberSystem getInstance() {
        return new WinningNumberSystem();
    }

    public WinningNumbers createWinningNumbers(String userInput) {
        List<WinningNumber> numbers = makeWinningNumbers(userInput);
        return WinningNumbers.from(numbers);
    }

    private List<WinningNumber> makeWinningNumbers(String userInput) {
        return Arrays.stream(userInput.split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(WinningNumber::from)
                .collect(Collectors.toList());
    }

    public WinningNumber creativeBonusNumber(String userInput, WinningNumbers winningNumbers) {
        int number = Integer.parseInt(userInput);
        validateDuplication(number, winningNumbers);
        return WinningNumber.from(number);
    }

    private void validateDuplication(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }
}
