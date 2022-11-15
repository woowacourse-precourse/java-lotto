package lotto.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @DisplayName("숫자가 아닌 값이 들어오면 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"숫자아님", "!@#"})
    void 숫자_확인_테스트(String input) {
        assertThatThrownBy(() -> player.setLottoCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수가 들어오면 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1000"})
    void 음수_입력_테스트(String input) {
        assertThatThrownBy(() -> player.setLottoCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000 단위로 나눠 나머지가 발생한다면 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1100", "1230", "200"})
    void 숫자_단위_테스트(String input) {
        assertThatThrownBy(() -> player.setLottoCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}