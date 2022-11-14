package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.winning.LottoResults;
import lotto.domain.winning.LottoTickets;
import lotto.domain.winning.WinningLotto;
import lotto.domain.winning.WinningStatistics;

public class LottoService {

    private final LottoStore lottoStore;
    private final LottoMachine lottoMachine;

    public LottoService(LottoStore lottoStore, LottoMachine lottoMachine) {
        this.lottoStore = lottoStore;
        this.lottoMachine = lottoMachine;
    }

    public LottoTickets lottoTickets(String money) {
        return lottoStore.lottoTickets(money);
    }

    public WinningLotto winningLotto(String formattedNumber, String bonusNumber) {
        return lottoMachine.winningLotto(formattedNumber, bonusNumber);
    }

    public FinalResultsDto finalResultsDto(LottoTickets lottoTickets, WinningLotto winningLotto) {
        LottoResults lottoResults = winningLotto.lottoResults(lottoTickets);
        WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, lottoResults);

        return new FinalResultsDto(lottoResults, winningStatistics);
    }
}