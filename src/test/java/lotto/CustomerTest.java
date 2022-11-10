package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.Customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    @DisplayName("입력값이 숫자인 경우 Customer 객체 생성")
    @Test
    void case1_validate_unit() {
        assertThat(new Customer("1000"))
                .isInstanceOf(Customer.class);
    }

    @DisplayName("입력값이 숫자가 아닌 아닌 경우 예외 발생")
    @Test
    void case2_validate_unit() {
        assertThatThrownBy(() -> new Customer("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
