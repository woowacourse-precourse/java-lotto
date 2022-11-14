package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.money.Money;
import lotto.domain.rank.Rank;
import lotto.domain.salesman.LottoSalesman;
import lotto.domain.statistics.Statistics;
import lotto.domain.winningnumber.WinningNumber;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoService {

    private final LottoSalesman lottoSalesman;

    public LottoService(final Money pricePerLotto, final LottoGenerator generator) {
        this.lottoSalesman = new LottoSalesman(pricePerLotto, generator);
    }

    public List<Lotto> purchaseLotto(final Money payment) {
        return lottoSalesman.salesLotto(payment);
    }

    public Statistics judgeWinning(
            final Money principle,
            final List<Lotto> lottos,
            final WinningNumber winningNumber
    ) {
        List<Rank> result = lottos.stream()
                .map(winningNumber::judge)
                .collect(toList());

        return Statistics.of(principle, result);
    }
}
