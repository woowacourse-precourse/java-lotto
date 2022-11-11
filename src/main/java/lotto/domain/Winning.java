package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.WinningNumbersException;
import lotto.view.InputView;

public class Winning {

    private Lotto winningNumbers;


    public Winning() {
        this.winningNumbers = new Lotto(getWinningNumbersByInput());
    }

    public List<Integer> getWinningNumbersByInput() {
        String winningNumbersInput = InputView.winningNumbersInput();
        WinningNumbersException.checkWinningNumbers(winningNumbersInput);
        return stringToIntegerList(winningNumbersInput);
    }

    private List<Integer> stringToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
