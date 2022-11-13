package lotto;

import java.util.List;

public class LottoAnalyzer {

    private final List<Lotto> lottoTickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoAnalyzer(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
