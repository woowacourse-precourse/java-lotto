package lotto;

import lotto.enums.Rank;
import lotto.model.Rate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RateTest {
    @DisplayName("Rate 생성 후 정확한 earningRate인지 확인한다.")
    @Test
    void getEarningRateValid() {
        // given
        int price = 8000;
        Map<Rank,Integer> winningStats = new HashMap<>();
        winningStats.put(Rank.first,0);
        winningStats.put(Rank.second,0);
        winningStats.put(Rank.third,0);
        winningStats.put(Rank.fourth,1);
        winningStats.put(Rank.fifth,0);

        double answerRate = (Constant.fourthRankPrice / (double) price) * 100;

        // when
        Rate rate = new Rate(winningStats,price);
        double earningRate = rate.getEarningRate();

        // then
        assertThat(earningRate == answerRate).isTrue();
    }
}
