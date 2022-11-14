package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {


    @DisplayName("당첨 로또 번호 크기가 7이 아닌 경우")
    @Test
    void createLottoExceedSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호가 중복")
    @Test
    void createWinningLottoDuplicated() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 7, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호가 수 범위를 넘어가는 경우")
    @Test
    void createWinningLottoOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(3,7,9,13,16,18,43,999)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}