package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClerkTest {

    private final Clerk clerk = new Clerk();

    @Test
    void 빈_문자열_입력_테스트() {
        String input = "";

        assertThatThrownBy(() -> clerk.giveLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 문자열이 입력되었습니다.");
    }

    @Test
    void 수가아닌_입력_테스트() {
        String input = "aa";

        assertThatThrownBy(() -> clerk.giveLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 수가 아닌 입력이 있습니다.");
    }

    @Test
    void 나누어_떨어지지않는_입력_테스트() {
        String input = "1100";

        assertThatThrownBy(() -> clerk.giveLottoQuantity(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력금액과 로또 금액이 나누어 떨어지지 않습니다.");
    }

    @Test
    void 로또_수량_테스트() {
        String input = "4000";

        assertThat(clerk.giveLottoQuantity(input)).isEqualTo(4);
    }
}