package lotto.domain;

import lotto.util.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createAmountByNotNumber() {
        InputStream in = generateUserInput("10!1000");
        System.setIn(in);

        assertThatThrownBy(Input::inputAmount)
                .hasMessageContaining("[ERROR] 구입 금액이 너무 크거나 입력이 올바르지 않습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 너무 크면 예외가 발생한다.")
    @Test
    void createAmountByTooBigNumber() {
        InputStream in = generateUserInput("100000000000000000");
        System.setIn(in);

        assertThatThrownBy(Input::inputAmount)
                .hasMessageContaining("[ERROR] 구입 금액이 너무 크거나 입력이 올바르지 않습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void createAmountByNegativeNumber() {
        assertThatThrownBy(() -> Amount.pay(-10000))
                .hasMessageContainingAll("[ERROR] 구매 금액은", "이상의 양수여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createAmountByNotDivisibleNumber() {
        assertThatThrownBy(() -> Amount.pay(1001))
                .hasMessageContainingAll("[ERROR] 구매 금액은", "원 단위여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}