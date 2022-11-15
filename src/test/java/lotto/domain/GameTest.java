package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameTest {


    @DisplayName("최대 로또 번호를 넘은 보너스 번호를 설정 시 예외 발생")
    @Test
    public void setBonusOutOfRange(){
        Game game = new Game();
        assertThatThrownBy(() -> game.setBonus(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이미 해당 보너스 번호가 당첨 번호에 포함되어 있을 시 예외 발생")
    @Test
    public void setBonusDuplicated(){
        Game game = new Game();
        game.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> game.setBonus(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생.")
    @Test
    void createLottoByOverSize() {
        Game game = new Game();
        assertThatThrownBy(() -> game.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        Game game = new Game();
        assertThatThrownBy(() -> game.setWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1~45 범위를 넘어간 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange(){
        Game game = new Game();
        assertThatThrownBy(() -> game.setWinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


}