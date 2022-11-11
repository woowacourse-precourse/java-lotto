package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("당첨 번호에 숫자가 아닌 입력이 있는 경우")
    @Test
    void inputWinningNumberByNotNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of("A", "2", "3", "4", "5", "6"), "45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복 입력이 있는 경우")
    @Test
    void inputWinningNumberByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "1", "3", "4", "5", "6"), "45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 개수가 6개가 넘은 경우")
    @Test
    void inputWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of("1", "2", "3", "4", "5", "6", "7"), "45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1~45 범위 밖 숫자 입력이 있는 경우")
    @Test
    void inputWinningNumberByNoLottoNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of("0", "46", "3", "4", "5", "6"), "45"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
