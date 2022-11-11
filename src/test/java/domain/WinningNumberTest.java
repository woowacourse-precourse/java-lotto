package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("당첨 번호 개수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    public void createWinningNumberByOverSize() {

        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7, 8), "10"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4), "10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 당첨 번호가 입력되면 예외가 발생한다.")
    @Test
    public void createWinningNumberByWrongNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(0,46,47,48,49,2),"10"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("잘못된 보너스 번호가 입력되면 예외가 발생한다.")
    @Test
    public void createWinningNumberByWrongBonusNumber() {

        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), "ㄱ"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 중복이 있다면 예외가 발생한다.")
    @Test
    public void createWinningNumberByReference() {

        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 2, 3, 4, 5), "10"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외가 발생한다.")
    @Test
    public void createWinningNumberBySameBonusNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}