package lotto;

import lotto.enums.Rank;
import lotto.model.Rate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
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

    @DisplayName("Rate 생성 후 earningRate가 소수점 둘째 자리에서 반올림하는지 확인한다.")
    @Test
    void getEarningRateRound() {
        // given
        int price = 6000;
        Map<Rank,Integer> winningStats = new HashMap<>();
        winningStats.put(Rank.first,0);
        winningStats.put(Rank.second,0);
        winningStats.put(Rank.third,0);
        winningStats.put(Rank.fourth,0);
        winningStats.put(Rank.fifth,1);

        // when
        Rate rate = new Rate(winningStats,price);
        double earningRate = rate.getEarningRate();

        // then
        String earningRateWord = String.valueOf(earningRate);
        int underZeroLength = earningRateWord.substring(earningRateWord.indexOf(".")).length();
        assertThat(underZeroLength == 2).isTrue();
    }

}
