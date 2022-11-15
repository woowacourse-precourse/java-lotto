package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClerkTest {

    private final Clerk clerk = new Clerk();

    @DisplayName("빈 문자열이 입력되면 예외를 발생시킨다.")
    @Test
    void inputMoneyByBlank() {
        String input = "";

        assertThatThrownBy(() -> clerk.calculateLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열이 입력되었습니다.");
    }

    @DisplayName("숫자가 아닌 입력이 있으면 예외를 발생시킨다.")
    @Test
    void inputMoneyByNoneNumeric() {
        String input = "aa";

        assertThatThrownBy(() -> clerk.calculateLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수가 아닌 입력이 있습니다.");
    }

    @DisplayName("0원이 입력되면 예외를 발생한다.")
    @Test
    void inputZeroMoney() {
        String input = "0";

        assertThatThrownBy(() -> clerk.calculateLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원은 입력받을 수 없습니다.");
    }

    @Test
    @DisplayName("돈의 나머지가 발생하면 예외를 발생시킨다.")
    void inputMoneyHaveRest() {
        String input = "1100";

        assertThatThrownBy(() -> clerk.calculateLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력금액과 로또 금액이 나누어 떨어지지 않습니다.");
    }

    @DisplayName("로또 수량 계산")
    @Test
    void calculateLottosQuantityByInputMoney() {
        String input = "4000";

        assertThat(clerk.calculateLottoQuantity(input)).isEqualTo(4);
    }
}