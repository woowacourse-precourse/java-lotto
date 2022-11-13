package lotto.domain;

import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;

public class DrawingMachine {
    public final List<Integer> winningNumber;
    public final Integer bonusNumber;

    DrawingMachine() {
        winningNumber = InputView.getWinningNumber();
        bonusNumber = InputView.getBonusNumber();
    }
}
