package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,5").toLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByCharacterString() {
        assertThatThrownBy(() -> new WinningLotto("a,1,2,3,4,5").toLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45범위 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByNumberRange() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,46").toLotto())
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningLotto("0,2,3,4,5,45").toLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자가 안들어올 경우 예외가 발생한다.")
    @Test
    void createWinningLottoByNumbersSize() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5").toLotto())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 범위의 중복되지 않는 숫자 6개를 입력하면 성공한다.")
    @Test
    void createWinningLotto() {
        assertDoesNotThrow(() -> new WinningLotto("1,2,3,4,5,6").toLotto());
        assertDoesNotThrow(() -> new WinningLotto("11,15,32,36,40,45").toLotto());
    }
}