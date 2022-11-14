package lotto.management;

import java.util.List;

public class LottoWinningNumber {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    LottoWinningNumber(List<Integer> winningNumber, int bonusNumber){
        this.winningNumber =winningNumber;
        this.bonusNumber =bonusNumber;
    }
}
