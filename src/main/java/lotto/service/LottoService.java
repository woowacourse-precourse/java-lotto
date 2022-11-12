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

    public LottoService(Money pricePerLotto, LottoGenerator generator) {
        this.lottoSalesman = new LottoSalesman(pricePerLotto, generator);
    }

    public List<Lotto> purchaseLotto(Money payment) {
        return lottoSalesman.salesLotto(payment);
    }

    public Statistics calculateWinning(Money principle, List<Lotto> lottos, WinningNumber winningNumber) {
        List<Rank> result = lottos.stream()
                .map(winningNumber::judge)
                .collect(toList());

        return Statistics.of(principle, result);
    }
}
