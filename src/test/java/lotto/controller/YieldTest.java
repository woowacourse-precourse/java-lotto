package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class YieldTest {
    @DisplayName("로또로 번 돈 계산")
    @Test
    public void SumMoneyTest() {
        assertThat((Yield.SumWinLotto(1,0,0,0,0) == 5000));
    }

    @DisplayName("수익률 계산")
    @Test
    public void YieldTest() {
        assertThat((Yield.YieldLotto(3000,9000) == 3.33));
    }
}