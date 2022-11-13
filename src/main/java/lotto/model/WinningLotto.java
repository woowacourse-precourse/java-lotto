package lotto.model;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
