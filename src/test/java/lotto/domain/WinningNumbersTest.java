package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {
    WinningNumbers winningNumbers;

    @BeforeEach()
    void init(){
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6),7);
    }

    @DisplayName("로또 당첨 6 자리 return 확인")
    @Test
    void getWinNumbers() {
        assertThat(winningNumbers.getWinNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 당첨 보너스 번호 return 확인")
    @Test
    void getBonus() {
        assertThat(winningNumbers.getBonus()).isEqualTo(7);
    }
}