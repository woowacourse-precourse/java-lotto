package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치하는 번호 개수와 보너스 번호 포함 여부를 통해, 각 등수를 구한다.")
    @Test
    void compareLotto() {
        // when
        Game game = new Game();

        // then
        assertThat(game.valueOf(6,false)).isEqualTo(FIRST);
        assertThat(game.valueOf(6,true)).isEqualTo(FIRST);
        assertThat(game.valueOf(5,  true)).isEqualTo(SECOND);
        assertThat(game.valueOf(2, false)).isEqualTo(null);
    }


}
