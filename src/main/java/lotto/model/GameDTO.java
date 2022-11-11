package lotto.model;

import java.util.List;

public class GameDTO {
    private Lotto winningNumber;
    private int bonusNumber;
    private int[] winningCount;
    private int winningAmount;
    private int returnOfRate;

    public void setWinningNumber(List<Integer> number) {
        this.winningNumber = new Lotto(number);
    }
    public Lotto getWinningNumber() {
        return this.winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
