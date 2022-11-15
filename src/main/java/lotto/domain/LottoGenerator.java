package lotto.domain;

import lotto.domain.strategy.LottoGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    LottoGenerateStrategy lottoGenerateStrategy;

    private LottoGenerator(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }

    public static LottoGenerator from(LottoGenerateStrategy lottoGenerateStrategy) {
        return new LottoGenerator(lottoGenerateStrategy);
    }

    public Lotto generate() {
        return lottoGenerateStrategy.generate();
    }

    public List<Lotto> generateMultipleLotto(int countOfLotto) {
        List<Lotto> multipleLotto = new ArrayList<>();
        while (countOfLotto > 0) {
            multipleLotto.add(generate());
            countOfLotto--;
        }
        return multipleLotto;
    }
}