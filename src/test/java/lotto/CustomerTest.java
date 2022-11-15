package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    @DisplayName("구매 금액이 천원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void createCustomerByInvalidMoney() {
        assertThatThrownBy(() -> new Customer(1500))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 천원 미만인 경우 예외가 발생한다.")
    @Test
    void createCustomerByTooSmallMoney() {
        assertThatThrownBy(() -> new Customer(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
