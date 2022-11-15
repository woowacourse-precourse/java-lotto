package lotto.domain.winningElements;

import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningElements {
    static List<Integer> winningNumbers;

    public static List<Integer> getWinningNumbers() {
        String receivedWinningNumbers = InputView.receiveWinningNumber();

        winningNumbers = parseReceivedWinningNumbers(receivedWinningNumbers);

        return winningNumbers;
    }

    public static List<Integer> parseReceivedWinningNumbers(String receivedWinningNumbers) {
        List<Integer> finalWinningNumbers =
                Arrays.stream(receivedWinningNumbers.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        return finalWinningNumbers;
    }
}
