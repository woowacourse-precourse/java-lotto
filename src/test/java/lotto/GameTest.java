package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.game.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    @DisplayName("보너스 번호가 1~45 범위가 아니면 예외가 발생한다.")
    @Test
    void setBonusNumberNotInRange() {
        Game game = new Game(1000);
        game.setWinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> game.setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
    @Test
    void setDuplicatedBonusNumber() {
        Game game = new Game(1000);
        game.setWinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> game.setBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
