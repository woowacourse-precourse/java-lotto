package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomerTest {

    @DisplayName("사용자가 로또 구매 금액을 입력하면 매수를 반환")
    @Test
    void calculateHowManySheet() {
        // given
        Customer customer = new Customer();

        // when
        int sheet = customer.buy(8000);

        // then
        assertThat(sheet).isEqualTo(8);
    }

    @DisplayName("사용자가 잘못된 금액을 입력하면 예외 반환")
    @Test
    void customerPayWrong() {
        // given
        Customer customer = new Customer();

        // then
        assertThatThrownBy(customer.buy(8100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorPhrase.WRONG_PAY);
    }
}
