package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @DisplayName("당첨번호와 로또 번호가 일치하는 개수와, 보너스 번호가 일치하는지를 제공하면 등수를 알 수 있다. ")
    @ParameterizedTest
    @CsvSource({"2,false,LOSE", "3,false,FIFTH", "4,false,FOURTH", "5,false,THIRD", "5,true,SECOND", "6,false,FIRST"})
    void 등수_맞추기(int winningNumberCount, boolean hasBonusNumber, LottoRank correctRank) {
        LottoRank rank = LottoRank.getRank(winningNumberCount, hasBonusNumber);
        assertThat(rank).isEqualTo(correctRank);
    }

    @Test
    @DisplayName("당첨 횟수를 알면 수익을 구할 수 있다. ")
    void 수익_계산() {
        LottoRank rank = LottoRank.FIFTH;
        int profit = rank.calculateProfit(3);
        assertThat(profit).isEqualTo(15000);
    }

}