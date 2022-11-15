package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));
            Winning winning = new Winning(lotto, 8);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위 밖이면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverBonus() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Winning winning = new Winning(lotto, 50);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateBonus() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Winning winning = new Winning(lotto, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
