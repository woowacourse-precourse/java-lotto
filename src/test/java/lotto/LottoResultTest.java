package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("수익률 계산하기")
    @Test
    void calculateLottoProfit() {
        final Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 1);
        result.put(Rank.FIFTH, 1);
        result.put(Rank.NOTHING, 10);

        LottoResult lottoResult = new LottoResult(result);
        lottoResult.calculateLottoProfit(new LottoMoney(10000));
        assertThat(lottoResult.calculateLottoProfit(new LottoMoney(10000))).isEqualTo((double) 55000 / 10000 * 100);
    }
}
