package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.BonusNumberException;
import lotto.exception.WinningNumbersException;
import lotto.view.InputView;

public class Winning {

    private Lotto winningNumbers;

    private Integer bonusNumber;

    public Winning() {
        this.winningNumbers = new Lotto(getWinningNumbersByInput());
        this.bonusNumber = getBonusNumberByInput();
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

    public Integer getBonusNumberByInput() {
        String bonusNumberInput = InputView.bonusNumberInput();
        BonusNumberException.checkBonusNumber(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }
}
