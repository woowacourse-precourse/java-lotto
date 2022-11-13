package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("당첨 번호에 존재하는 보너스 번호가 입력되면 예외를 발생한다.")
    @Test
    void createMoneyWithUnmatchingUnit() {
        assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}