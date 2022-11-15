package lotto.domain.winningElements;

import static lotto.domain.winningElements.WinningNumbersValidator.validateAfterParse;
import static lotto.domain.winningElements.WinningNumbersValidator.validateBeforeParse;

import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningElements {
    static List<Integer> winningNumbers;

    public static List<Integer> getWinningNumbers() {
        String receivedWinningNumbers = InputView.receiveWinningNumber();

        validateBeforeParse(receivedWinningNumbers);

        winningNumbers = parseReceivedWinningNumbers(receivedWinningNumbers);

        validateAfterParse(winningNumbers);

        return winningNumbers;
    }

    public static List<Integer> parseReceivedWinningNumbers(String receivedWinningNumbers) {
        List<Integer> finalWinningNumbers =
                Arrays.stream(receivedWinningNumbers.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        return finalWinningNumbers;
    }

    public static int getBonusNumber() {
        String receivedBonusNumber = InputView.receiveBonusNumber();

        BonusNumberValidator.validate(receivedBonusNumber, winningNumbers);

        int bonusNumber = Integer.parseInt(receivedBonusNumber);

        return bonusNumber;
    }
}
