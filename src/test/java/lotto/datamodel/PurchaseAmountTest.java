package lotto.datamodel;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @DisplayName("입력 받은 구매금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createNumberIsValid() {
        assertThatThrownBy(() -> new PurchaseAmount("15000dwe"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyIsValid() {
        assertThatThrownBy(() -> new PurchaseAmount("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
