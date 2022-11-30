package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("중복된 보너스 번호가 들어왔을 때 예외처리한다.")
    @Test
    void createBonusLottoDuplicate() {
        assertThatThrownBy(() -> {
            new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 5);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 로또 번호가 들어왔을 때 예외처리한다.")
    @Test
    void createWinningLottoDuplicate() {
        assertThatThrownBy(() -> {
            new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 4, 5)), 5);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위에서 벗어났을 때 예외처리한다.")
    @Test
    void createBonusLottoOutOfRange() {
        assertThatThrownBy(() -> {
            new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 4, 5)), 75);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
