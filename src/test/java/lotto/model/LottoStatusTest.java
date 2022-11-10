package lotto.model;

import static lotto.model.Constants.LottoStatus.MATCH_FIVE_ADD_BONUS_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FIVE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_FOUR_PROFIT;
import static lotto.model.Constants.LottoStatus.MATCH_THREE_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_SIX_PROFIT;
import static lotto.model.Constants.LottoStatus.MATH_UNSATISFIED_PROFIT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatusTest {

    @DisplayName("각 상태에서 수익을 반환")
    @Test
    void return_profit() {
        LottoStatus lottoStatus = LottoStatus.MATCH_UNSATISFIED;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATH_UNSATISFIED_PROFIT);

        lottoStatus = LottoStatus.MATCH_THREE;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATCH_THREE_PROFIT);

        lottoStatus = LottoStatus.MATCH_FOUR;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATCH_FOUR_PROFIT);

        lottoStatus = LottoStatus.MATCH_FIVE;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATCH_FIVE_PROFIT);

        lottoStatus = LottoStatus.MATCH_FIVE_ADD_BONUS;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATCH_FIVE_ADD_BONUS_PROFIT);

        lottoStatus = LottoStatus.MATCH_SIX;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATH_SIX_PROFIT);
    }
}
