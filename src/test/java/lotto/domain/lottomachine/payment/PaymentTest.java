package lotto.domain.lottomachine.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @DisplayName("from 메소드에 1000미만의 숫자가 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 123, 20})
    void from_test_with_under_1000(int number) {
        assertThatThrownBy(() -> Payment.from(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 이상이어야 합니다.");
    }

    @DisplayName("from 메소드에 1000의 배수가 아닌 수가 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1001, 1543, 2522})
    void from_test_with_non_multiple_of_1000(int number) {
        assertThatThrownBy(() -> Payment.from(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("divideBy 메소드에 가격을 입력했을 때 Payment 객체를 가격으로 나눈 값을 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"5000, 1000, 5", "100000, 2000, 50", "1000, 1000, 1"})
    void divideBy_test(int amount, int price, int expected) {
        Payment money = Payment.from(amount);

        int actual = money.divideBy(price);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("divideBy 메소드에 가격을 0으로 입력했을 때 오류를 발생시키는지 확인")
    @ParameterizedTest
    @CsvSource({"5000, 0"})
    void divideBy_error_test(int amount, int price) {
        Payment money = Payment.from(amount);

        assertThatThrownBy(() -> money.divideBy(price)).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("[ERROR] 0으로 나눌 수 없습니다.");
    }

    @DisplayName("createBigDecimal 메소드가 BigDecimal 객체를 생성해 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1000, 123000, 20000})
    void createBigDecimal_test(int amount) {
        Payment money = Payment.from(amount);

        BigDecimal actual = money.createBigDecimal();

        assertThat(actual).isEqualTo(BigDecimal.valueOf(amount));
    }
}
