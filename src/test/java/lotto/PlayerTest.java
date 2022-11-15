package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    public void 입력검증_숫자가_아닌_값을_입력한_경우() {
        String input = "abc";
        Player player = new Player();

        assertThatThrownBy(() -> player.payValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다");
    }

    @Test
    public void 입력검증_1000원_단위_입력이_아닌_경우() {
        String input = "1234";
        Player player = new Player();

        assertThatThrownBy(() -> player.payValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위만 입력 가능합니다");
    }
}
