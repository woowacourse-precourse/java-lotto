package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeCountTest {

    private final PrizeCount prizeCount = new PrizeCount();

    @BeforeEach
    void setUp() {
        prizeCount.addPrizeCount(Prize.FIFTH);
    }

    @DisplayName("$등수의 합산 금액이 맞는지 확인하기")
    @Test
    void getTotalPrizeMoney() {
        assertThat(prizeCount.getTotalPrizeMoney(Prize.FIFTH)).isEqualTo(
                Prize.FIFTH.getMoney());
    }

    @DisplayName("당첨 내역을 출력한다.")
    @Test
    void testToString() {
        assertThat(prizeCount.toString()).isEqualTo(
                "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개");
    }

}