package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumberList;
    private int bonusNumber;

    public WinningNumber() {
        this.winningNumberList = new ArrayList<>();
        this.bonusNumber = 0;
    }

    public void makeWinningNumber(String wn, int bn) {
        String[] winningNumberArr = wn.split(",");

        for (String winningNumber : winningNumberArr) {
            winningNumberList.add(Integer.parseInt(winningNumber));
        }

        bonusNumber = bn;
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
