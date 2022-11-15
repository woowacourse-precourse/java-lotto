package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeCountTest {
    private PrizeCount prizeCount;

    @BeforeEach
    void setUp() {
        prizeCount = new PrizeCount();
    }

    @Test
    void 당첨확인_5등() {
        prizeCount.addPrize(Prize.calculatePrize(3, false));
        assertThat(prizeCount.getPrize(Prize.FIFTH)).isEqualTo(1);
    }

    @Test
    void 당첨확인_1등() {
        prizeCount.addPrize(Prize.calculatePrize(6, false));
        assertThat(prizeCount.getPrize(Prize.FIRST)).isEqualTo(1);
    }

    @Test
    void 당첨확인_2등() {
        prizeCount.addPrize(Prize.calculatePrize(5, true));
        assertThat(prizeCount.getPrize(Prize.SECOND)).isEqualTo(1);
    }

    @Test
    void 당첨확인_3등() {
        prizeCount.addPrize(Prize.calculatePrize(5, false));
        assertThat(prizeCount.getPrize(Prize.THIRD)).isEqualTo(1);
    }
}