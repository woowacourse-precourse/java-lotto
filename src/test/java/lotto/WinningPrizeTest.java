package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningPrizeTest {

    @DisplayName("지정한 금액이 정상적으로 인식되는지 확인")
    @Test
    void getPrize() {
        Assertions.assertThat(WinningPrize.FIRST_PRIZE.getPrize())
                .isEqualTo(2000000000);
    }

    @DisplayName("당첨 금액이 #,### 포멧에 맞춰 출력되는지 확인")
    @Test
    void getStringPrize() {
        Assertions.assertThat(WinningPrize.FIRST_PRIZE.getStringPrize())
                .isEqualTo("2,000,000,000");
    }
}