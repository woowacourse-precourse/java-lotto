package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.Customer;

import java.lang.reflect.Field;

public class CustomerTest {

    @DisplayName("구입 금액이 1,000원 단위인 경우 객체 생성")
    @Test
    void case1_validate_unit() {
        assertThat(new Customer(1000))
                .isInstanceOf(Customer.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우 예외 발생")
    @Test
    void case2_validate_unit() {
        assertThatThrownBy(() -> new Customer(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
