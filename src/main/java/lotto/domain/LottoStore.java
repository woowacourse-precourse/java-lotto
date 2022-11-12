package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final Money LOTTO_PRICE = new Money(1000);

    private final LottoNumberGenerateStrategy lottoNumberGenerateStrategy;

    public LottoStore(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this.lottoNumberGenerateStrategy = lottoNumberGenerateStrategy;
    }

    public Lottos purchaseLotto(Money money) {
        return new Lottos(IntStream.range(0, money.divide(LOTTO_PRICE))
                .mapToObj(number -> createLotto())
                .collect(Collectors.toList()));
    }

    private Lotto createLotto() {
        return new Lotto(lottoNumberGenerateStrategy.generateNumbers()
                .stream()
                .map(LottoNumber::number)
                .collect(Collectors.toList()));
    }
}
