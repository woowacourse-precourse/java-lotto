package lotto;

import java.util.List;

public class LottoWinningNumber {

    private final Lotto winningNumber;

    public LottoWinningNumber(List<Integer> winningNumbers) {
        this.winningNumber = createLottoWinningNumbers(winningNumbers);
    }

    private Lotto createLottoWinningNumbers(List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

}
