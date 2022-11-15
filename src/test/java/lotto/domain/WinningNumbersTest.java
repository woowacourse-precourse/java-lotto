package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("당첨 번호에 보너스 숫자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_보너스번호_중복확인() {
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6).checkUnique())
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(10, 14, 25, 36, 39, 45)), 25).checkUnique())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
