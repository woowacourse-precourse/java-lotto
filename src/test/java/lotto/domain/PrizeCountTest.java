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
        prizeCount.addPrizeCount(Prize.FIFTH);
    }


    @DisplayName("$등수의 합산 금액이 맞는지 확인하기")
    @Test
    void getTotalPrizeMoney() {
        assertThat(prizeCount.getTotalPrizeMoney(Prize.FIFTH)).isEqualTo(Prize.FIFTH.getMoney() * 2);
    }



}