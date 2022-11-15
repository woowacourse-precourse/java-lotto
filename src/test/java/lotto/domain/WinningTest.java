package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {
    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkWinningNumberIsNotNumeric() {
        assertThatThrownBy(() -> new Winning("100d0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkWinningNumberDuplicated() {
        assertThatThrownBy(() -> new Winning("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
