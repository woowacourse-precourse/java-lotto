package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final Money LOTTO_PRICE = new Money(1000);

    private final NumberGenerateStrategy numberGenerateStrategy;

    public LottoStore(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public Lottos purchaseLotto(Money money) {
        return new Lottos(IntStream.range(0, money.divideValue(LOTTO_PRICE))
                .mapToObj(number -> createLotto())
                .collect(Collectors.toList()));
    }

    private Lotto createLotto() {
        return new Lotto(numberGenerateStrategy.generateNumbers());
    }
}
