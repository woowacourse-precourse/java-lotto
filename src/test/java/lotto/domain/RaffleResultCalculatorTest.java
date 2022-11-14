package lotto.domain;

import lotto.domain.raffleDevice.RaffleResultCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RaffleResultCalculatorTest {

    RaffleResultCalculator raffleResultCalculator = new RaffleResultCalculator();

    @Test
    void 로또_상금_수익률_계산() {
        List<Integer> lottoResult = List.of(0, 0, 0, 0, 0, 1);
        Integer lottosSize = 5;

        Assertions.assertThat(raffleResultCalculator.calculateStatics(lottoResult, lottosSize)).isEqualTo((double) 100);
    }
}