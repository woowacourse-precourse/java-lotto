package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("calculateProfit 가 수익률을 정상적으로 계산한다.")
    @Test
    void runCalculateProfit() {
        Money money = new Money(9000);
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.THIRD);
        lottoResult.addRank(Rank.THIRD);
        lottoResult.addRank(Rank.THIRD);
        lottoResult.addRank(Rank.FOURTH);
        lottoResult.addRank(Rank.FOURTH);
        lottoResult.addRank(Rank.FIFTH);
        lottoResult.addRank(Rank.NOTHING);
        double result = 22606722.2;
        assertThat(lottoResult.calculateProfit(money)).isEqualTo(result);
    }
    @DisplayName("둘째자리에서 반올림을 하는경우")
    @Test
    void runCalculateProfitByRound() {
        Money money = new Money(3000);
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIFTH);
        lottoResult.addRank(Rank.NOTHING);
        lottoResult.addRank(Rank.NOTHING);
        double result = 166.7;
        assertThat(lottoResult.calculateProfit(money)).isEqualTo(result);
    }

    @DisplayName("최소 수익률일 경우")
    @Test
    void runCalculateProfitByMinProfit() {
        Money money = new Money(1000);
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.NOTHING);
        double result = 0;
        assertThat(lottoResult.calculateProfit(money)).isEqualTo(result);
    }

    @DisplayName("최대 수익률일 경우")
    @Test
    void runCalculateProfitByMaxProfit() {
        Money money = new Money(100000);
        LottoResult lottoResult = new LottoResult();
        int count = 100;
        while(count != 0){
            lottoResult.addRank(Rank.FIRST);
            count--;
        }
        double result = 200_000_000;
        assertThat(lottoResult.calculateProfit(money)).isEqualTo(result);
    }
}
