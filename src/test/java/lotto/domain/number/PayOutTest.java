package lotto.domain.number;

import lotto.resource.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PayOutTest {

    @Test
    @DisplayName("지불 금액이 양수가 아닌경우")
    void numberIsNotPositive() {
        String input = "-1";

        assertThatThrownBy(() -> new PayOut(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessage(ErrorMessage.NUMBER_IS_NOT_POSITIVE_MESSAGE.getValue());
    }

    @Test
    @DisplayName("지불 금액이 1000으로 나누어 떨어지지 않는 경우")
    void numberIsNotDivisibleByThousands() {
        String input = "1111";

        assertThatThrownBy(() -> new PayOut(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessage(ErrorMessage.NOT_DIVISIBLE_BY_THOUSANDS_MESSAGE.getValue());
    }

    @Test
    @DisplayName("지불 금액이 유효한 경우")
    void numberIsPositive() {
        String input = "1000";

        PayOut payOut = new PayOut(input);

        assertThat(payOut.getValueAsInt()).isEqualTo(1000);
    }

    @Test
    @DisplayName("지불 금액에 대한 게임 횟수 조회")
    void getGameCount() {
        String input = "10000";

        PayOut payOut = new PayOut(input);
        int gameCount = payOut.getGameCount();

        assertThat(gameCount).isEqualTo(10);
    }
}