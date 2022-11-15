package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoServiceTest {
    private final WinningLottoService winningLottoService = new WinningLottoService();

    @DisplayName("로또로 입력한 숫자가 문자인 경우 예외가 발생한다.")
    @Test
    void scanWinningNums() {
        assertThatThrownBy(() -> winningLottoService.changeToList("dk"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호로 입력한 숫자가 문자인 경우 에외가 발생한다.")
    @Test
    void scanNumbers() {
        assertThatThrownBy(() -> winningLottoService.changeToInteger("dk"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}