package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class DrawingMachine {
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public void setWinningNumber() {
        winningNumber = InputView.getWinningNumber();
    }

    public void setBonusNumber() {
        bonusNumber = InputView.getBonusNumber();
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
