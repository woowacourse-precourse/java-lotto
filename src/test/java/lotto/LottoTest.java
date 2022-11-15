package lotto;

import lotto.business.controller.LottoGame;
import lotto.business.model.Lotto;
import lotto.business.model.LottoAnswer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
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

    @DisplayName("로또 범위가 지정된 범위를 벗어나며 예외가 발생한다.")
    @Test
    void createLottoByOutRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 서로 중복되지 않는 6자리의 숫자와 1자리의 보너스 숫자로 구성된다.")
    @Test
    void createLottoAnswer() {
        assertThatCode(() -> new LottoAnswer(List.of(1,2,3,4,5,6), 7))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호는 당첨 번호와 겹쳐서는 안된다.")
    @Test
    void bonusNumberDuplicate() {
        assertThatThrownBy(() -> new LottoAnswer(List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
