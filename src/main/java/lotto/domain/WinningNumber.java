package lotto.domain;

public class WinningNumber {
    private Lotto winningNumber;

    public void inputWinningNumber(String input) {
        winningNumber = new Lotto(input);
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }
}
