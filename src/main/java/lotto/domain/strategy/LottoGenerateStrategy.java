package lotto.domain.strategy;

import lotto.domain.Lotto;

public interface LottoGenerateStrategy {
    int LOTTO_MIN_NUMBER = 1;
    int LOTTO_MAX_NUMBER = 45;
    int LOTTO_SIZE = 6;

    Lotto generate();
}
