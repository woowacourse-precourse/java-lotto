package lotto.domain.game;

import lotto.domain.game.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createDuplicateBonusAndWinningNumber(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> lotto.validateDuplicateBonusAndWinningNumber(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위가 45보다 크면 예외가 발생한다.")
    @Test
    void createWinningNumberOverRange(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,1000)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
