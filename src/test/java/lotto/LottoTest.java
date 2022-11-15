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

    @DisplayName("로또 번호가 1~45 밖으로 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 999)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("bonus 번호가 1~45 밖으로 넘어가면 예외 발생.")
    @Test
    void createBonusByOverRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.setBonus(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스");
    }

    @DisplayName("bonus 번호가 당첨번호와 중복일 시 예외 발생.")
    @Test
    void createBonusByDuplicationWithWinningNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.setBonus(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스");
    }
}
