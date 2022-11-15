package lotto.domain.strategy.lottosissuancestrategy;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.strategy.lottoissuancestrategy.LottoIssuanceStrategy;
import lotto.domain.strategy.lottoissuancestrategy.RandomLottoIssuanceStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottosIssuanceStrategy implements LottosIssuanceStrategy {
    private static final int MIN_NUMBER_OF_LOTTO_PURCHASED = 1;
    
    @Override
    public Lottos issueLottos(final int numberOfLottoPurchased) {
        return new Lottos(createLottos(numberOfLottoPurchased));
    }
    
    private List<Lotto> createLottos(final int numberOfLottoPurchased) {
        return IntStream.rangeClosed(MIN_NUMBER_OF_LOTTO_PURCHASED, numberOfLottoPurchased)
                .mapToObj(count -> issueLotto(new RandomLottoIssuanceStrategy()))
                .collect(Collectors.toList());
    }
    
    private Lotto issueLotto(LottoIssuanceStrategy lottoIssuanceStrategy) {
        return lottoIssuanceStrategy.issueLotto();
    }
}
