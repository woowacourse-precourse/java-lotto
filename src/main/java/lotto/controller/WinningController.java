package lotto.controller;

import static lotto.utils.Converter.stringToIngerListByComma;

import java.util.List;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class WinningController {

    Output output;

    public WinningController() {
        output = new Output();
    }

    public WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        output.printGetWinningNumbers();
        String input = Input.readLine();
        return stringToIngerListByComma(input);
    }

    private int getBonusNumber() {
        output.pringGetWinningBonusNumber();
        return Input.readNumber();
    }
}
