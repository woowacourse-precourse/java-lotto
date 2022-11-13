package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    @DisplayName("구입 금액에 따라 복권 수량을 계산한다")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "15000, 15"})
    void 구매_가능한_복권_수량_계산(int amount, int num) {
        assertThat(new PurchaseAmount(amount).getNumberOfLottos()).isEqualTo(num);
    }

    @Test
    void 구매_금액_1000단위가_아니면_예외던지기() {
        assertThatThrownBy(() -> new PurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 구매_금액_0원보다_작으면_예외던지기() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "구매금액 4000원 상금은 {0}원, 수익률은 {1}%")
    @CsvSource({"2000,50", "2500,62.5"})
    void 로또_당첨금액으로_수익률_계산_기능(int winningAmount, double profitRate) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(4000);
        assertThat(purchaseAmount.calculateProfitRate(winningAmount)).isEqualTo(profitRate);
    }
}