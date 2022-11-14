package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {
    LottoController lc = new LottoController();

    @DisplayName("입력된 금액이 천원으로 나누어지는 수가 아닐시 예외 발생")
    @Test
    void isRemainderZeroWhenDividedByThousand() {
        assertThatThrownBy(() -> lc.readUserMoney("1760"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액이 0일시 예외 발생")
    @Test
    void isInputNumberNotZero() {
        assertThatThrownBy(() -> lc.readUserMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수가 아닌 문자가 입력될시 예외 발생")
    @Test
    void isInputNumberConsistOfDigit() {
        assertThatThrownBy(() -> lc.readUserMoney("1칠60"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
