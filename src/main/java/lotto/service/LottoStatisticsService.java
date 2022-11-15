package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.LottoWinningNumber;

public class LottoStatisticsService {
    private final LottoMachine lottoMachine;
    private final LottoWinningNumber lottoWinningNumber;

    public LottoStatisticsService(LottoMachine lottoMachine, LottoWinningNumber lottoWinningNumber) {
        this.lottoMachine = lottoMachine;
        this.lottoWinningNumber = lottoWinningNumber;
    }
}
