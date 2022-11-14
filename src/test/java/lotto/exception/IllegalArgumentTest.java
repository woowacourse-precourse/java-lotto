package lotto.exception;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class IllegalArgumentTest {

    @Test
    void 숫자가_아닌_입력값() {
        assertThat(IllegalArgument.isNumber("숫자아님")).isFalse();
    }

    @Test
    void 숫자인_입력값() {
        assertThat(IllegalArgument.isNumber("13000")).isTrue();
    }

    @Test
    void 천원_단위_숫자_입력() {
        assertThat(IllegalArgument.isThousandWon("13000")).isTrue();
    }

    @Test
    void 천원_단위_아닌_숫자_입력() {
        assertThat(IllegalArgument.isThousandWon("1234")).isFalse();
    }
}
