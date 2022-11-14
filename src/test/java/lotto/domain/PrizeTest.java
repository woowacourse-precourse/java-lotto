package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    private static final int MATCHING_COUNT = 5;
    private static final boolean HAS_BONUS_NUMBER = Boolean.TRUE;

    @DisplayName("로또 등수를 알 수 있다.")
    @Test
    void findPrize() {
        assertThat(Prize.findPrize(MATCHING_COUNT, HAS_BONUS_NUMBER)).isEqualTo(Prize.SECOND);
    }

    @DisplayName("당첨 기준과 금액을 출력한다.")
    @Test
    void testToString() {
        StringBuilder message = new StringBuilder();
        for (Prize prize : Prize.values()) {
            message.append(prize).append("\n");
        }

        assertThat(message.toString()).isEqualTo(
                "3개 일치 (5,000원)\n"
                + "4개 일치 (50,000원)\n"
                + "5개 일치 (1,500,000원)\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원)\n"
                + "6개 일치 (2,000,000,000원)\n");
    }
}