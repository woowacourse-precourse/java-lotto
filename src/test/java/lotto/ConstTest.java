package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.Const.SIZE;

public class ConstTest {

    @DisplayName("")
    @Test
    void checkEqualMethodOfSize() {
        assertThat(SIZE.equals(6)).isTrue();
        assertThat(SIZE.equals(5)).isFalse();
    }
}
