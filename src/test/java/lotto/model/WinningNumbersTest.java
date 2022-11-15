package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkOverlapByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("1", "2", "3", "4", "5", "5"), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_범위_확인_메서드() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("1", "52", "3", "4", "5", "6"), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }
}