package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Nested
    class setMoneyTest{
        @DisplayName("구매 금액에 한글이 들어있는 경우 예외가 발생한다.")
        @Test
        void koreanInFee() {
            assertThatThrownBy(() -> {
                Customer customer = new Customer();
                customer.setMoney("2000원");
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("구매 금액에 영어가 들어있는 경우 예외가 발생한다.")
        @Test
        void englishInFee() {
            assertThatThrownBy(() -> {
                Customer customer = new Customer();
                customer.setMoney("2000Won");
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
        @Test
        void notDividedBy1000() {
            assertThatThrownBy(() -> {
                Customer customer = new Customer();
                customer.setMoney("1234");
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
