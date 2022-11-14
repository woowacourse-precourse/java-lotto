package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    @ParameterizedTest(name = "{0}원으로 복권 {1}장 구매 가능")
    @CsvSource({"1000,1", "2000,2", "15000, 15"})
    void 구매_가능한_로또_수량_계산(int amount, int expected) {
        assertThat(new PurchaseAmount(amount).getNumberOfLottos()).isEqualTo(expected);
    }

    @Test
    void 구매_금액_1000원_단위가_아니면_예외_던지기() {
        assertThatThrownBy(() -> new PurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 구매_금액_0원보다_작으면_예외_던지기() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest(name = "구매 금액 4000원 상금 {0}원, 수익률 {1}%")
    @CsvSource({"2000,50", "2500,62.5", "135000,3375"})
    void 로또_수익률_계산_기능(int winningAmount, double expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(4000);
        assertThat(purchaseAmount.calculateProfitRate(winningAmount)).isEqualTo(expected);
    }
}