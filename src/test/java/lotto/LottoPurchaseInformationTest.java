package lotto;

import lotto.domain.LottoPurchaseInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseInformationTest {
    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void createPurchaseAmountNegative() {
        assertThatThrownBy(() -> new LottoPurchaseInformation(-3000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이면 예외가 발생한다.")
    @Test
    void createPurchaseAmountZero() {
        assertThatThrownBy(() -> new LottoPurchaseInformation(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountNotDividedByThousand() {
        assertThatThrownBy(() -> new LottoPurchaseInformation(12345))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
