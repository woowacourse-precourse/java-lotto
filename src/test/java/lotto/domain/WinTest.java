package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinTest {

    @Test
    @DisplayName("숫자 6개가 아닌 경우 예외가 발생한다.")
    void createWinNumbers() {
        assertThatThrownBy(() -> new Win(List.of(1,2,3,4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    void createWinNumbersOutOfRange() {
        assertThatThrownBy(() -> new Win(List.of(1,2,3,4,50,51)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 있는 경우 예외가 발생한다.")
    void createWinNumbersDuplicateNumber() {
        assertThatThrownBy(() -> new Win(List.of(1,2,3,4,4,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    void setBonusNumberOutOfRange() {
        Win win = new Win(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> win.setBonus(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자인 경우 예외가 발생한다.")
    void setBonusNumberDuplicate() {
        Win win = new Win(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> win.setBonus(4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}