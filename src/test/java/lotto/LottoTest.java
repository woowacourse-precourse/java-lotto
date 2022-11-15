package lotto;

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

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외 발생")
    @Test
    void createLottoByOverWinNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("승리 번호와 보너스 번호에 중복된 숫자가 있으면 예외 발생")
    @Test
    void createWinNumberByDuplicatedBonusNumber() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThatThrownBy(() -> {
            lotto.validateBonusNumber(List.of(1,2,3,4,5,6), 6);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 번호의 범위가 1~45가 아니면 예외 발생")
    @Test
    void createLottoByOverBonusNumberRange() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> lotto.validateBonusNumber(List.of(1,2,3,4,5,6),0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
