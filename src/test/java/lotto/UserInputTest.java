package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {

    @Test
    void 돈_입력_예외_1() {
        assertThatThrownBy(() -> UserInput.inputMoney("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_예외_2() {
        assertThatThrownBy(() -> UserInput.inputMoney("rrr"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈_입력_테스트() {
        long a = UserInput.inputMoney("2000");
        assertThat(a).isEqualTo(2000);
    }
}
