package lotto.domain.strategy.lottosissuancestrategy;

import lotto.domain.Lottos;

public interface LottosIssuanceStrategy {
    Lottos issueLottos(final int numberOfLottoPurchased);
}
