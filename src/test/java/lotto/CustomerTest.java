package lotto;

import lotto.domain.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {
    @DisplayName("구입 금액이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createCustomerByWrongMoney() {
        assertThatThrownBy(() -> new Customer(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이면 예외가 발생한다.")
    @Test
    void createCustomerByNoMoney() {
        assertThatThrownBy(() -> new Customer(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
