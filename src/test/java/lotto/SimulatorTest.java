package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimulatorTest {
    @DisplayName("구입금액이 1,000원 단위가 아닐 시 예외가 발생한다.")
    @Test
    void invalidPurchasePriceMultiple() {
        assertThatThrownBy(() -> new Simulator(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0일 경우 예외가 발생한다.")
    @Test
    void invalidPurchasePriceZero() {
        assertThatThrownBy(() -> new Simulator(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 음수일 경우 예외가 발생한다.")
    @Test
    void invalidPurchasePriceNegative() {
        assertThatThrownBy(() -> new Simulator(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1,000원 단위일 경우 정상 처리한다.")
    @Test
    void validPurchasePrice() {
        Simulator simulator = new Simulator(2000);
    }
}
