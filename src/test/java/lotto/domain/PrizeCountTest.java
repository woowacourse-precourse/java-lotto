package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrizeCountTest {
    private PrizeCount prizeCount;

    @BeforeEach
    void setUp() {
        prizeCount = new PrizeCount();
    }

    @Test
    void 당첨_후_확인() {
        prizeCount.addPrize(Prize.calculatePrize(3, false));
    }

}