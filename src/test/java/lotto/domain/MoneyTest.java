package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("구매 금액 입력 테스트")
    void MoneyTest_success() {
        // given
        String payment = "8000";
        int expectedEPayment = 8000;

        // when
        Money money = new Money(payment);

        // then
        assertThat(expectedEPayment).isEqualTo(money.getPayment());
    }

    @Test
    @DisplayName("숫자가 아닌 금액 입력으로 인해 IllegalArgumentException 예외 발생")
    void MoneyTest_throw_IllegalArgumentException() {
        // given
        String payment = "8000원";
        int expectedEPayment = 8000;

        // when && then
        assertThatThrownBy(() -> new Money(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }
}