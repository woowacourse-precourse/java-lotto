package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonus() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("당첨 번호의 범위는 1~ 45 이다.1")
    @Test
    void createLottoByOverRange1() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, -1), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위는 1~ 45 이다.2")
    @Test
    void createLottoByOverRange2() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 55), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 번호 체크")
    @Test
    void hasNumberInList() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 8);

        assertThat(winningNumber.hasNumber(3)).isTrue();
        assertThat(winningNumber.hasNumber(4)).isTrue();
        assertThat(winningNumber.hasNumber(8)).isFalse();
        assertThat(winningNumber.hasNumber(16)).isFalse();
    }

    @DisplayName("당첨 번호의 보너스 번호 체크")
    @Test
    void hasBonus() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 8);

        assertThat(winningNumber.hasBonus(3)).isFalse();
        assertThat(winningNumber.hasBonus(4)).isFalse();
        assertThat(winningNumber.hasBonus(8)).isTrue();
        assertThat(winningNumber.hasBonus(16)).isFalse();
    }
}