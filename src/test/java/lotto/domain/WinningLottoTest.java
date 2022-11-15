package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호들은 서로 달라야 한다.")
    public void validate_unique() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 5;
        // when
        // then
        assertThatThrownBy(() -> WinningLotto.validate(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 1 ~ 45 사이의 숫자여야 한다")
    public void inputWinningLotto_bonusNumber_validRange() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;
        // when
        // then
        assertThatThrownBy(() -> WinningLotto.validate(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}