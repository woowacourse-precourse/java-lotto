package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("calculateProfit 가 수익률을 정상적으로 계산한다.")
    @Test
    void runCalculateProfit() {
        Money money = new Money("9000");
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
        float result = (float)22606722.2;
        assertThat(lottoResult.calculateProfit(money)).isEqualTo(result);
    }
}
