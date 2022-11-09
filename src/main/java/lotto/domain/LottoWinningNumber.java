package lotto.domain;

import java.util.List;

public class LottoWinningNumber extends Lotto {
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumber, String bonusNumber) {
        super(winningNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bonusNumber : "+
                bonusNumber;
    }
}
