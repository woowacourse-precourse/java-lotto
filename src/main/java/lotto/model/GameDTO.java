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

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public int getReturnOfRate() {
        return returnOfRate;
    }

    public void setReturnOfRate(int returnOfRate) {
        this.returnOfRate = returnOfRate;
    }

    public int[] getWinningCount() {
        return winningCount;
    }

    public void setWinningCount(int[] winningCount) {
        this.winningCount = winningCount;
    }
}
