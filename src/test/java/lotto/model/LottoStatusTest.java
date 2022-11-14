package lotto.model;

import static lotto.model.LottoStatus.Constants.MATCH_FIVE_ADD_BONUS_PROFIT;
import static lotto.model.LottoStatus.Constants.MATCH_FIVE_PROFIT;
import static lotto.model.LottoStatus.Constants.MATCH_FOUR_PROFIT;
import static lotto.model.LottoStatus.Constants.MATCH_THREE_PROFIT;
import static lotto.model.LottoStatus.Constants.MATH_SIX_PROFIT;
import static lotto.model.LottoStatus.Constants.MATH_UNSATISFIED_PROFIT;
import static lotto.model.LottoStatus.MATCH_FIVE;
import static lotto.model.LottoStatus.MATCH_FIVE_ADD_BONUS;
import static lotto.model.LottoStatus.MATCH_FOUR;
import static lotto.model.LottoStatus.MATCH_SIX;
import static lotto.model.LottoStatus.MATCH_THREE;
import static lotto.model.LottoStatus.MATCH_UNSATISFIED;
import static lotto.model.LottoStatus.checkValue;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatusTest {

    @DisplayName("각 상태에서 수익을 반환")
    @Test
    void return_profit() {
        LottoStatus lottoStatus = MATCH_UNSATISFIED;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATH_UNSATISFIED_PROFIT);

        lottoStatus = MATCH_THREE;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATCH_THREE_PROFIT);

        lottoStatus = MATCH_FOUR;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATCH_FOUR_PROFIT);

        lottoStatus = MATCH_FIVE;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATCH_FIVE_PROFIT);

        lottoStatus = MATCH_FIVE_ADD_BONUS;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATCH_FIVE_ADD_BONUS_PROFIT);

        lottoStatus = MATCH_SIX;
        assertThat(lottoStatus.getProfit()).isEqualTo(MATH_SIX_PROFIT);
    }

    @DisplayName("숫자를 받고 상태 반환")
    @Test
    void get_count_return_status() {
        assertThat(checkValue(0)).isEqualTo(MATCH_UNSATISFIED);
        assertThat(checkValue(1)).isEqualTo(MATCH_UNSATISFIED);
        assertThat(checkValue(2)).isEqualTo(MATCH_UNSATISFIED);
        assertThat(checkValue(3)).isEqualTo(MATCH_THREE);
        assertThat(checkValue(4)).isEqualTo(MATCH_FOUR);
        assertThat(checkValue(5)).isEqualTo(MATCH_FIVE);
        assertThat(checkValue(6)).isEqualTo(MATCH_SIX);
        assertThat(checkValue(7)).isEqualTo(MATCH_FIVE_ADD_BONUS);
    }
}
