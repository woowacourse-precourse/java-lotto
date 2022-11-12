package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    @DisplayName("보너스 번호가 1보다 작거나 45보다 크면 예외 처리")
    void createBonusNumberByOutOfNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.toString());
    }
}