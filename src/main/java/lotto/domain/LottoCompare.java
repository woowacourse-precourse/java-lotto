package lotto.domain;

import java.util.List;

public class LottoCompare {
    private final WinningNumbers winningNumbers;
    private final List<Lotto> container;

    public LottoCompare(List<Lotto> container,
                        WinningNumbers winningNumbers) {
        this.container = container;
        this.winningNumbers = winningNumbers;
    }

    public void compare() {
        CompareEachLotto.mapInit();
        for (Lotto lotto : container) {
            CompareEachLotto.compare(lotto, winningNumbers);
        }
        CompareEachLotto.printWinningHistory();
    }
}
