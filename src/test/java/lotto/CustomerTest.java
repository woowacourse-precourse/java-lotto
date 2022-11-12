package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerTest {
    @DisplayName("구매금액이 1,000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createWrongPrice() {
        String input = "2500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new Customer())
                        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1,000으로 나누어 떨어지면 count에 값이 할당된다.")
    @Test
    void createRightPrice() {
        String input = "3000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Customer customer = new Customer();
        assertThat(customer.count).isEqualTo(3);
    }
}