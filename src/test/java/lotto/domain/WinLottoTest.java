package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class WinLottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("당첨번호에 문자를 입력하면 예외가 발생한다.")
    void createWinLottoByNotDigitNumbers() {
        assertThatThrownBy(() -> new WinLotto("a,b,c,d,e,f", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinLotto("abcdef", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨번호의 개수가 6개가 아니면 예외가 발생한다.")
    void createWinLottoByNotFitSize() {
        assertThatThrownBy(() -> new WinLotto("1,2,3", "4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6,7", "8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨번호가 1부터 45사이의 값이 아니면 예외가 발생한다.")
    void createWinLottoByNotInRangedNumbers() {
        assertThatThrownBy(() -> new WinLotto("0,1,2,3,4,5", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,66", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinLotto("51,52,53,54,55,56,57", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createWinLottoByDuplicatedNumbers() {
        assertThatThrownBy(() -> new WinLotto("1,1,1,1,1,1", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,1", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호에 문자를 입력하면 예외가 발생한다.")
    void createWinLottoByNotDigitBonusNumber() {
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", "."))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45사이의 값이 아니면 예외가 발생한다.")
    void createWinLottoByNotInRangedBonusNumber() {
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", "51"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호에 이미 존재하는 숫자면 예외가 발생한다.")
    void createWinLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}