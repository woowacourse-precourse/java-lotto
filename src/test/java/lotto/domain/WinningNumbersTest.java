package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningNumbersTest {

    WinningNumbersImple winningNumbers = new WinningNumbersImple();

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외")
    @Test
    void createWinningNumberDuplicateWithBonus() {
        assertThatThrownBy(() ->
                winningNumbers.generateFromRawValues(List.of(1, 2, 3, 4, 5, 7),7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복되면 예외")
    @Test
    void createWinningNumberDuplicate() {
        assertThatThrownBy(() ->
                winningNumbers.generateFromRawValues(List.of(1,7, 3, 4, 5, 7),10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 번호가 1-45사이가 아니면 예외")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() ->
                winningNumbers.generateFromRawValues(List.of(1, 182, 3, 4, 5, 7),7))
                .isInstanceOf(IllegalArgumentException.class);
    }

}