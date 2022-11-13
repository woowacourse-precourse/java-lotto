package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningCountTest {
    WinningCount winningCount;

    @BeforeEach
    void setUp() {
        winningCount = new WinningCount();
    }

    @Test
    void 당첨금액_테스트() {
        winningCount.addWinningResult("3", false);
        winningCount.addWinningResult("4", false);
        winningCount.addWinningResult("5", true);

        assertThat(winningCount.getProfitSum()).isEqualTo(30055000);
    }

}