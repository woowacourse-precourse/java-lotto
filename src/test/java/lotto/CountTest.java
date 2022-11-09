package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class CountTest {
    @Test
    void 로또구입금액_정상입력() {
        String userInput = "10000";
        int result = 10;
        assertThat(new Count(userInput).getNumOfLotto()).isEqualTo(result);
    }

    @Test
    void 로또구입금액_비정상입력_숫자x() {
        String userInput = "100&&";
        Assertions.assertThatThrownBy(() -> new Count(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    void 로또구입금액_비정상입력_천원단위x() {
        String userInput = "10001";
        Assertions.assertThatThrownBy(() -> new Count(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1,000원 단위로 입력해주세요.");
    }

}