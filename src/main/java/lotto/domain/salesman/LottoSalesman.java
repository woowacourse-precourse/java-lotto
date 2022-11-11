package lotto.domain.salesman;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.money.Money;

import java.util.List;

public class LottoSalesman {

    private final Money pricePerLotto;
    private final LottoGenerator lottoGenerator;

    public LottoSalesman(Money pricePerLotto, LottoGenerator lottoGenerator) {
        this.pricePerLotto = pricePerLotto;
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> salesLotto(Money payment) {
        int salesCount = payment.exchangeFor(pricePerLotto).size();
        return lottoGenerator.generateByCount(salesCount);
    }
}
