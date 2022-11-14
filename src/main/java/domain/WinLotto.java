package domain;

import java.util.List;

public class WinLotto {

    private final List<Lotto> lotteries;
    private final Lotto winnerNumber;
    private final int bonusNumber;

    public WinLotto(List<Lotto> lotteries, Lotto winnerNumber, int bonusNumber) {
        this.lotteries = lotteries;
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }


}
