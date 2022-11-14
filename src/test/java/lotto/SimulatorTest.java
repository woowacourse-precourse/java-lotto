package lotto;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("유효한 구입금액은 알맞은 수량으로 변환된다. (Case 1)")
    @Test
    void validPurchasePriceCase1() {
        Simulator simulator = new Simulator(2000);
        assertThat(simulator.getQuantity()).isEqualTo(2);
    }

    @DisplayName("유효한 구입금액은 알맞은 수량으로 변환된다. (Case 2)")
    @Test
    void validPurchasePriceCase2() {
        Simulator simulator = new Simulator(1000);
        assertThat(simulator.getQuantity()).isEqualTo(1);
    }

    @DisplayName("유효한 구입금액은 알맞은 수량으로 변환된다. (Case 3)")
    @Test
    void validPurchasePriceCase3() {
        Simulator simulator = new Simulator(14000);
        assertThat(simulator.getQuantity()).isEqualTo(14);
    }
}
