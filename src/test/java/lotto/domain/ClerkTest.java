package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClerkTest {

    private final Clerk clerk = new Clerk();

    @Test
    void 빈_문자열_입력_테스트() {
        String input = "";

        assertThatThrownBy(() -> clerk.giveLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열이 입력되었습니다.");
    }

    @Test
    void 수가아닌_입력_테스트() {
        String input = "aa";

        assertThatThrownBy(() -> clerk.giveLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수가 아닌 입력이 있습니다.");
    }

    @DisplayName("0원이 입력되면 예외를 발생한다.")
    @Test
    void inputZeroMoney() {
        String input = "0";

        assertThatThrownBy(() -> clerk.giveLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원은 입력받을 수 없습니다.");
    }

    @Test
    void 나누어_떨어지지않는_입력_테스트() {
        String input = "1100";

        assertThatThrownBy(() -> clerk.giveLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력금액과 로또 금액이 나누어 떨어지지 않습니다.");
    }

    @Test
    void 로또_수량_테스트() {
        String input = "4000";

        assertThat(clerk.giveLottoQuantity(input)).isEqualTo(4);
    }
}