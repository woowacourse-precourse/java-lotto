package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryWinTest {
    @DisplayName("로또 당첨 여부 테스트")
    @Test
    void lottoPriceNotDivide() {
        assertThat(LotteryWin.FIRST_GRADE.getLotteryWinMoney()).isEqualTo("2,000,000,000");
    }


}
