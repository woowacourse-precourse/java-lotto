package lotto.input;

import java.util.List;

public class Input {
    private final int purchaseAmount;
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public Input(int purchaseAmount, List<Integer> winningNumber, int bonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        checkAmount();
    }

    private void checkAmount() {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
