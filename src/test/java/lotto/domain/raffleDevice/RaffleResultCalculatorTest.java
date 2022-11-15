package lotto.domain.raffleDevice;

import lotto.domain.Rank;
import lotto.domain.raffleDevice.RaffleResultCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

class RaffleResultCalculatorTest {

    RaffleResultCalculator raffleResultCalculator = new RaffleResultCalculator();

    @Test
    void 로또_상금_수익률_계산() {
        HashMap<Rank, Integer> winnerPerRank = new HashMap<>();

        winnerPerRank.put(Rank.FIRST, 0);
        winnerPerRank.put(Rank.SECOND, 0);
        winnerPerRank.put(Rank.THIRD, 0);
        winnerPerRank.put(Rank.FOURTH, 0);
        winnerPerRank.put(Rank.FIFTH, 1);
        winnerPerRank.put(Rank.NONE, 0);

        Assertions.assertThat(raffleResultCalculator.getProfitRate(winnerPerRank, 5)).isEqualTo((double) 100);
    }
}