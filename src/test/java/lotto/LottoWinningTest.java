package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningTest {
    @DisplayName("수익률이 잘못 계산되면 에러를 반환한다..")
    @Test
    void createQuotientByMoney() {
        int[] tcase = {1,0,0,0,0};
        Integer money = 5000;
        assertThat(LottoWinning.getBenefit(tcase,money)).isEqualTo((double)100.0);
    }
}